package com.growingio.android.sdk.collection;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.growingio.android.sdk.base.event.ActivityLifecycleEvent;
import com.growingio.android.sdk.ipc.GrowingIOIPC;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
import com.growingio.eventcenter.bus.meta.Subscriber;
import java.util.UUID;
/* loaded from: classes2.dex */
public class SessionManager implements Subscriber {
    private static final int SAND_APP_CLOSE_DELAY = 10000;
    private static final String TAG = "GIO.SessionManager";
    private final GConfig config;
    private final GrowingIOIPC growingIOIPC;
    private boolean mNextPassMustSendVisit;
    private boolean mNextResumeSendVisit;
    private Runnable mSendAppCloseTask;
    private final MessageProcessor messageProcessor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.growingio.android.sdk.collection.SessionManager$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE;

        static {
            int[] iArr = new int[ActivityLifecycleEvent.EVENT_TYPE.values().length];
            $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE = iArr;
            try {
                iArr[ActivityLifecycleEvent.EVENT_TYPE.ON_RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[ActivityLifecycleEvent.EVENT_TYPE.ON_PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public SessionManager(MessageProcessor messageProcessor, GrowingIOIPC growingIOIPC, GConfig gConfig) {
        this.mNextPassMustSendVisit = false;
        this.mNextResumeSendVisit = false;
        this.messageProcessor = messageProcessor;
        this.growingIOIPC = growingIOIPC;
        this.config = gConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getLastPauseTime() {
        return this.growingIOIPC.getLastPauseTime();
    }

    public static String getSessionId() {
        SessionManager sessionManager = CoreInitialize.sessionManager();
        if (sessionManager != null) {
            return sessionManager.getSessionIdInner();
        }
        return null;
    }

    private void onActivityPause() {
        if (this.mNextPassMustSendVisit) {
            this.messageProcessor.saveVisit(true);
            this.mNextPassMustSendVisit = false;
        }
        updateLastPauseTime(System.currentTimeMillis());
        ThreadUtils.cancelTaskOnUiThread(this.mSendAppCloseTask);
        Runnable runnable = new Runnable() { // from class: com.growingio.android.sdk.collection.SessionManager.1
            @Override // java.lang.Runnable
            public void run() {
                long lastPauseTime = SessionManager.this.getLastPauseTime();
                if (SessionManager.this.growingIOIPC.getLastResumeTime() < lastPauseTime) {
                    SessionManager.this.messageProcessor.setAppClose(lastPauseTime);
                }
            }
        };
        this.mSendAppCloseTask = runnable;
        ThreadUtils.postOnUiThreadDelayed(runnable, 10000L);
    }

    private void updateLastPauseTime(long j2) {
        this.growingIOIPC.setLastPauseTime(j2);
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public void do$Action(String str, Object obj) {
        if (str.equals("#onActivityLifecycle(com.growingio.android.sdk.base.event.ActivityLifecycleEvent")) {
            onActivityLifecycle((ActivityLifecycleEvent) obj);
        } else {
            System.out.println("No such method to delegate");
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public SubscriberMethod[] get$SubscriberMethods() {
        return new SubscriberMethod[]{new SubscriberMethod("onActivityLifecycle", ActivityLifecycleEvent.class, "#onActivityLifecycle(com.growingio.android.sdk.base.event.ActivityLifecycleEvent", ThreadMode.MAIN, 0, false)};
    }

    public String getSessionIdInner() {
        String sessionId = this.growingIOIPC.getSessionId();
        if (TextUtils.isEmpty(sessionId)) {
            String uuid = UUID.randomUUID().toString();
            this.growingIOIPC.setSessionId(uuid);
            LogUtil.d(TAG, "found sessionId is null or empty, generate one sessionId: ", uuid);
            this.mNextPassMustSendVisit = true;
            return uuid;
        }
        return sessionId;
    }

    public void nextResumeResendVisit() {
        this.mNextResumeSendVisit = true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onActivityLifecycle(ActivityLifecycleEvent activityLifecycleEvent) {
        int i2 = AnonymousClass3.$SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[activityLifecycleEvent.event_type.ordinal()];
        if (i2 == 1) {
            onActivityResume();
        } else if (i2 != 2) {
        } else {
            onActivityPause();
        }
    }

    @VisibleForTesting
    void onActivityResume() {
        long currentTimeMillis = System.currentTimeMillis();
        this.growingIOIPC.setLastResumeTime(currentTimeMillis);
        ThreadUtils.cancelTaskOnUiThread(this.mSendAppCloseTask);
        if (this.mNextPassMustSendVisit) {
            this.messageProcessor.saveVisit(true);
            this.mNextPassMustSendVisit = false;
            return;
        }
        if (currentTimeMillis - getLastPauseTime() > this.config.getSessionInterval()) {
            this.growingIOIPC.setSessionId(UUID.randomUUID().toString());
            this.messageProcessor.saveVisit(true);
        } else if (this.mNextResumeSendVisit) {
            this.messageProcessor.saveVisit(true);
            this.mNextResumeSendVisit = false;
        }
    }

    public void updateSessionByUserIdChanged() {
        this.growingIOIPC.setSessionId(UUID.randomUUID().toString());
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.growingio.android.sdk.collection.SessionManager.2
            @Override // java.lang.Runnable
            public void run() {
                SessionManager.this.messageProcessor.saveVisit(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionManager() {
        this.mNextPassMustSendVisit = false;
        this.mNextResumeSendVisit = false;
        this.messageProcessor = null;
        this.growingIOIPC = null;
        this.config = null;
    }
}
