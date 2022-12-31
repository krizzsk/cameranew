package com.growingio.android.sdk.autoburry;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebView;
import com.growingio.android.sdk.api.FetchTagListTask;
import com.growingio.android.sdk.base.event.ActivityLifecycleEvent;
import com.growingio.android.sdk.base.event.CircleEvent;
import com.growingio.android.sdk.base.event.RefreshPageEvent;
import com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent;
import com.growingio.android.sdk.base.event.message.MessageEvent;
import com.growingio.android.sdk.collection.ActionCalculator;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.MessageProcessor;
import com.growingio.android.sdk.models.ActionEvent;
import com.growingio.android.sdk.models.PageEvent;
import com.growingio.android.sdk.models.ViewNode;
import com.growingio.android.sdk.models.ViewTraveler;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.SysTrace;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WindowHelper;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.EventCenter;
import com.growingio.eventcenter.bus.EventBus;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
import com.growingio.eventcenter.bus.meta.Subscriber;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
/* loaded from: classes2.dex */
public class AutoBuryMessageProcessor implements Subscriber {
    private static final int MAX_RETRY_CHECK_SETTINGS_COUNT = 1;
    private static final int ONREUME_TIME_INTERVAL = 500;
    private static final int SAVE_ALL_IMPRESSION_DELAY = 250;
    private static final int SAVE_NEW_WINDOW_IMPRESSION_DELAY = 500;
    private static final String TAG = "GIO.AutoBuryMessageProcessor";
    private static int sSettingsRetryCount;
    private final AutoBuryAppState mAutoAppState;
    private FetchTagListTask mCheckSettingsTask;
    private final GConfig mConfig;
    private final CoreAppState mCoreAppState;
    private final MessageProcessor mCoreMessageProcessor;
    private boolean mIsInFirstImpressionTime;
    private WeakReference<Activity> mLastActivity;
    private Runnable mResendPageEventTask;
    private Map<WeakReference<View>, ActionCalculator> mActionCalculatorMap = new LinkedHashMap();
    private boolean mFullRefreshingPage = false;
    private long mLastSettingsUpdateTime = -1;
    private long mNextForceSaveAllImpressionTime = -1;
    private long mViewTreeChangeDownTime = -1;
    private volatile boolean mIsInObtainImpressing = false;
    private long mLastPauseTime = -1;
    private Runnable mSaveAllWindowImpression = new Runnable() { // from class: com.growingio.android.sdk.autoburry.AutoBuryMessageProcessor.3
        @Override // java.lang.Runnable
        public void run() {
            AutoBuryMessageProcessor.this.mIsInFirstImpressionTime = false;
            AutoBuryMessageProcessor.this.saveAllWindowImpress(false);
        }
    };
    private ExecutorService mBgExecutorService = EventBus.getDefault().getExecutorService();
    private final ProcessorHandler mHandler = new ProcessorHandler();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.growingio.android.sdk.autoburry.AutoBuryMessageProcessor$6  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass6 {
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

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
    public class ProcessorHandler extends Handler {
        private static final int MSG_SEND_ACTIVITY_PAGE = 2;

        private ProcessorHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 2) {
                return;
            }
            AutoBuryMessageProcessor.this.flushPendingActivityPageEvent();
        }
    }

    public AutoBuryMessageProcessor(GConfig gConfig, CoreAppState coreAppState, AutoBuryAppState autoBuryAppState, MessageProcessor messageProcessor) {
        this.mConfig = gConfig;
        this.mCoreAppState = coreAppState;
        this.mAutoAppState = autoBuryAppState;
        this.mCoreMessageProcessor = messageProcessor;
    }

    static /* synthetic */ int access$708() {
        int i2 = sSettingsRetryCount;
        sSettingsRetryCount = i2 + 1;
        return i2;
    }

    private void cancelSaveImpAndClearImpRecord() {
        clearActionCalculatorMap();
        ThreadUtils.cancelTaskOnUiThread(this.mSaveAllWindowImpression);
    }

    private synchronized void clearActionCalculatorMap() {
        try {
            this.mActionCalculatorMap.clear();
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(TAG, "mActionCalculatorMap clear failed");
        }
        updateNextForceSaveAllImpressionTime();
    }

    private synchronized void clearActionCalculatorMapAndSaveImpressDelay() {
        this.mHandler.removeMessages(2);
        clearActionCalculatorMap();
        this.mIsInFirstImpressionTime = true;
        ThreadUtils.cancelTaskOnUiThread(this.mSaveAllWindowImpression);
        ThreadUtils.postOnUiThreadDelayed(this.mSaveAllWindowImpression, 500L);
    }

    private ActionCalculator findCalculatorByWindow(View view) {
        for (WeakReference<View> weakReference : this.mActionCalculatorMap.keySet()) {
            if (weakReference.get() == view) {
                return this.mActionCalculatorMap.get(weakReference);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flushPendingActivityPageEvent() {
        PageEvent pendingPageEvent = this.mCoreMessageProcessor.getPendingPageEvent();
        if (pendingPageEvent != null) {
            MessageProcessor messageProcessor = this.mCoreMessageProcessor;
            messageProcessor.savePage(pendingPageEvent, messageProcessor.getPendingObj());
            this.mCoreMessageProcessor.updatePendingPageEvent(null, null);
        }
        this.mHandler.removeMessages(2);
        clearActionCalculatorMapAndSaveImpressDelay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceRefresh(boolean z) {
        Activity foregroundActivity = CoreInitialize.coreAppState().getForegroundActivity();
        if (foregroundActivity != null) {
            ThreadUtils.cancelTaskOnUiThread(this.mResendPageEventTask);
            if (z) {
                clearActionCalculatorMap();
                ThreadUtils.cancelTaskOnUiThread(this.mSaveAllWindowImpression);
                LogUtil.d(TAG, "forceRefresh: saveAllWindowImpression");
                this.mSaveAllWindowImpression.run();
                return;
            }
            ViewHelper.traverseWindow(foregroundActivity.getWindow().getDecorView(), "", new ViewTraveler() { // from class: com.growingio.android.sdk.autoburry.AutoBuryMessageProcessor.2
                @Override // com.growingio.android.sdk.models.ViewTraveler
                public void traverseCallBack(ViewNode viewNode) {
                    View view = viewNode.mView;
                    if ((view instanceof WebView) || ClassExistHelper.instanceOfX5WebView(view)) {
                        LogUtil.d(AutoBuryMessageProcessor.TAG, "resend page event for ", viewNode.mView);
                        if (VdsJsBridgeManager.isWebViewHooked(viewNode.mView)) {
                            Util.callJavaScript(viewNode.mView, "_vds_hybrid.resendPage", Boolean.FALSE);
                        }
                    }
                }
            });
        }
    }

    private boolean isLegalPageEvent() {
        return this.mCoreAppState.isScreenOn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAllWindowImpressionDelayedForViewTreeChange() {
        if (this.mIsInFirstImpressionTime) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mViewTreeChangeDownTime > 4000) {
            updateNextForceSaveAllImpressionTime();
            this.mViewTreeChangeDownTime = currentTimeMillis;
        }
        if (this.mNextForceSaveAllImpressionTime < currentTimeMillis) {
            LogUtil.d(TAG, "saveAllWindowImpression, and last saveAllImpressionTime over three seconds, force refresh");
            this.mSaveAllWindowImpression.run();
            return;
        }
        ThreadUtils.cancelTaskOnUiThread(this.mSaveAllWindowImpression);
        ThreadUtils.postOnUiThreadDelayed(this.mSaveAllWindowImpression, 250L);
    }

    private void saveImpInBg(final Collection<ActionCalculator> collection) {
        if (this.mIsInObtainImpressing) {
            LogUtil.d(TAG, "saveImpInBg, but mIsInObtainImpression is true, just return");
        } else {
            this.mBgExecutorService.execute(new Runnable() { // from class: com.growingio.android.sdk.autoburry.AutoBuryMessageProcessor.4
                @Override // java.lang.Runnable
                public void run() {
                    if (AutoBuryMessageProcessor.this.mIsInObtainImpressing) {
                        return;
                    }
                    AutoBuryMessageProcessor.this.mIsInObtainImpressing = true;
                    LogUtil.d(AutoBuryMessageProcessor.TAG, "start saveImpInBg....");
                    try {
                        try {
                            for (ActionCalculator actionCalculator : collection) {
                                AutoBuryMessageProcessor.this.saveImpressInBgMyThrowException(actionCalculator);
                            }
                        } catch (Exception e2) {
                            if (e2.getMessage() != null && e2.getMessage().contains("WebView getUrl")) {
                                LogUtil.d(AutoBuryMessageProcessor.TAG, "saveImpInBg failed, should be webView question, save imp delay");
                            } else {
                                LogUtil.d(AutoBuryMessageProcessor.TAG, "saveImpInBg failed, may ConcurrentModificationException or IndexOutOfException", e2);
                            }
                            AutoBuryMessageProcessor.this.saveAllWindowImpressionDelayedForViewTreeChange();
                        }
                    } finally {
                        AutoBuryMessageProcessor.this.mIsInObtainImpressing = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImpressInBgMyThrowException(ActionCalculator actionCalculator) {
        List<ActionEvent> obtainImpress;
        if (actionCalculator == null || (obtainImpress = actionCalculator.obtainImpress()) == null) {
            return;
        }
        for (ActionEvent actionEvent : obtainImpress) {
            this.mCoreMessageProcessor.persistEvent(actionEvent);
        }
    }

    private boolean shouldCancelUpdateSettings() {
        return GConfig.ISOP() || (this.mLastSettingsUpdateTime != -1 && System.currentTimeMillis() - this.mLastSettingsUpdateTime < AdvTimeUtils.MILLIS_OF_A_DAY);
    }

    private void updateNextForceSaveAllImpressionTime() {
        this.mNextForceSaveAllImpressionTime = System.currentTimeMillis() + 3000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSettingsIfNeeded() {
        if (!shouldCancelUpdateSettings() && this.mCheckSettingsTask == null) {
            FetchTagListTask fetchTagListTask = new FetchTagListTask() { // from class: com.growingio.android.sdk.autoburry.AutoBuryMessageProcessor.5
                @Override // com.growingio.android.sdk.api.FetchTagListTask, com.growingio.android.sdk.base.event.HttpCallBack
                public void afterRequest(Integer num, byte[] bArr, long j2, Map<String, List<String>> map) {
                    super.afterRequest(num, bArr, j2, map);
                    if (num.intValue() != 200 && num.intValue() != 304 && AutoBuryMessageProcessor.sSettingsRetryCount < 1) {
                        ThreadUtils.postOnUiThreadDelayed(new Runnable() { // from class: com.growingio.android.sdk.autoburry.AutoBuryMessageProcessor.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AutoBuryMessageProcessor.access$708();
                                AutoBuryMessageProcessor.this.updateSettingsIfNeeded();
                            }
                        }, 5000L);
                    } else {
                        AutoBuryMessageProcessor.this.mLastSettingsUpdateTime = System.currentTimeMillis();
                    }
                    AutoBuryMessageProcessor.this.mCheckSettingsTask = null;
                }
            };
            this.mCheckSettingsTask = fetchTagListTask;
            fetchTagListTask.run();
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public void do$Action(String str, Object obj) {
        if (str.equals("#onActivityLifeCycleChanged(com.growingio.android.sdk.base.event.ActivityLifecycleEvent")) {
            onActivityLifeCycleChanged((ActivityLifecycleEvent) obj);
        } else if (str.equals("#onScrollChanged(com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent")) {
            onScrollChanged((ViewTreeStatusChangeEvent) obj);
        } else if (str.equals("#refreshPageIfNeeded(com.growingio.android.sdk.base.event.RefreshPageEvent")) {
            refreshPageIfNeeded((RefreshPageEvent) obj);
        } else if (str.equals("#onMessageEvent(com.growingio.android.sdk.base.event.message.MessageEvent")) {
            onMessageEvent((MessageEvent) obj);
        } else {
            System.out.println("No such method to delegate");
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public SubscriberMethod[] get$SubscriberMethods() {
        ThreadMode threadMode = ThreadMode.POSTING;
        ThreadMode threadMode2 = ThreadMode.MAIN;
        return new SubscriberMethod[]{new SubscriberMethod("onActivityLifeCycleChanged", ActivityLifecycleEvent.class, "#onActivityLifeCycleChanged(com.growingio.android.sdk.base.event.ActivityLifecycleEvent", threadMode, 0, false), new SubscriberMethod("onScrollChanged", ViewTreeStatusChangeEvent.class, "#onScrollChanged(com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent", threadMode, 0, false), new SubscriberMethod("refreshPageIfNeeded", RefreshPageEvent.class, "#refreshPageIfNeeded(com.growingio.android.sdk.base.event.RefreshPageEvent", threadMode2, 0, false), new SubscriberMethod("onMessageEvent", MessageEvent.class, "#onMessageEvent(com.growingio.android.sdk.base.event.message.MessageEvent", threadMode2, 0, false)};
    }

    @Subscribe
    public void onActivityLifeCycleChanged(ActivityLifecycleEvent activityLifecycleEvent) {
        Activity activity = activityLifecycleEvent.getActivity();
        int i2 = AnonymousClass6.$SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[activityLifecycleEvent.event_type.ordinal()];
        if (i2 == 1) {
            savePageForPureActivity(activity);
            updateSettingsIfNeeded();
        } else if (i2 != 2) {
        } else {
            flushPendingActivityPageEvent();
            cancelSaveImpAndClearImpRecord();
            this.mIsInFirstImpressionTime = true;
            this.mLastPauseTime = System.currentTimeMillis();
        }
    }

    public void onFragmentPage(SuperFragment superFragment) {
        Activity activity = superFragment.getActivity();
        if (activity == null) {
            return;
        }
        this.mIsInFirstImpressionTime = true;
        this.mCoreMessageProcessor.savePage(new PageEvent(this.mAutoAppState.getPageName(activity), this.mCoreMessageProcessor.getPageNameWithoutPending(), System.currentTimeMillis()), superFragment.getFragment());
        clearActionCalculatorMapAndSaveImpressDelay();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent) {
        if (messageEvent.messageType != MessageEvent.MessageType.IMP || this.mActionCalculatorMap.size() <= 0) {
            return;
        }
        saveAllWindowImpressionDelayedForViewTreeChange();
    }

    @Subscribe
    public void onScrollChanged(ViewTreeStatusChangeEvent viewTreeStatusChangeEvent) {
        saveAllWindowImpressionDelayedForViewTreeChange();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshPageIfNeeded(RefreshPageEvent refreshPageEvent) {
        final boolean isWithImpression = refreshPageEvent.isWithImpression();
        boolean isNewPTM = refreshPageEvent.isNewPTM();
        if (!this.mFullRefreshingPage || isWithImpression) {
            this.mFullRefreshingPage = isWithImpression && isNewPTM;
            ThreadUtils.cancelTaskOnUiThread(this.mResendPageEventTask);
            Runnable runnable = new Runnable() { // from class: com.growingio.android.sdk.autoburry.AutoBuryMessageProcessor.1
                @Override // java.lang.Runnable
                public void run() {
                    AutoBuryMessageProcessor.this.mFullRefreshingPage = false;
                    AutoBuryMessageProcessor.this.forceRefresh(isWithImpression);
                }
            };
            this.mResendPageEventTask = runnable;
            ThreadUtils.postOnUiThreadDelayed(runnable, 250L);
        }
    }

    public void saveAllWindowImpress(boolean z) {
        SysTrace.beginSection("gio.saveAllWindowImpress");
        updateNextForceSaveAllImpressionTime();
        EventCenter.getInstance().post(new CircleEvent("updateTagsIfNeeded"));
        GConfig gConfig = this.mConfig;
        if (gConfig != null && gConfig.shouldSendImp()) {
            Activity resumedActivity = CoreInitialize.coreAppState().getResumedActivity();
            if (resumedActivity == null) {
                SysTrace.endSection();
                return;
            }
            WindowHelper.init();
            View[] windowViews = WindowHelper.getWindowViews();
            ArrayList arrayList = new ArrayList();
            boolean z2 = ViewHelper.getMainWindowCount(windowViews) > 1;
            WindowHelper.init();
            for (View view : windowViews) {
                if (view != null) {
                    String windowPrefix = WindowHelper.getWindowPrefix(view);
                    if (!WindowHelper.sIgnoredWindowPrefix.equals(windowPrefix) && ViewHelper.isWindowNeedTraverse(view, windowPrefix, z2) && findCalculatorByWindow(view) == null) {
                        ActionCalculator actionCalculator = new ActionCalculator(this.mAutoAppState.getPageName(resumedActivity), this.mCoreMessageProcessor.getPTMWithPending(), view, windowPrefix);
                        this.mActionCalculatorMap.put(new WeakReference<>(view), actionCalculator);
                        arrayList.add(actionCalculator);
                    }
                }
            }
            saveImpInBg(z ? arrayList : this.mActionCalculatorMap.values());
            if (arrayList.size() > 0) {
                EventCenter.getInstance().post(new CircleEvent("refreshWebCircleTasks"));
            }
            SysTrace.endSection();
            return;
        }
        SysTrace.endSection();
    }

    public void savePageForManualModel(Activity activity) {
        ThreadUtils.cancelTaskOnUiThread(this.mResendPageEventTask);
        this.mCoreMessageProcessor.savePage(new PageEvent(this.mAutoAppState.getPageName(activity), this.mCoreMessageProcessor.getPageNameWithoutPending(), System.currentTimeMillis()), activity);
        clearActionCalculatorMapAndSaveImpressDelay();
    }

    public void savePageForPureActivity(Activity activity) {
        if (activity == null || !isLegalPageEvent()) {
            return;
        }
        WeakReference<Activity> weakReference = this.mLastActivity;
        if ((weakReference == null || activity != weakReference.get() || System.currentTimeMillis() - this.mLastPauseTime >= 500) && !this.mAutoAppState.isIgnoredActivity(activity)) {
            this.mLastActivity = new WeakReference<>(activity);
            PageEvent pageEvent = new PageEvent(this.mAutoAppState.getPageName(activity), this.mCoreMessageProcessor.getPageNameWithoutPending(), System.currentTimeMillis());
            if (this.mAutoAppState.isPageManualModel(activity)) {
                this.mCoreMessageProcessor.savePage(pageEvent, activity);
            } else {
                this.mCoreMessageProcessor.updatePendingPageEvent(pageEvent, activity);
            }
            this.mIsInFirstImpressionTime = true;
            if (this.mHandler.hasMessages(2)) {
                return;
            }
            this.mHandler.sendEmptyMessageDelayed(2, 1000L);
        }
    }

    public void saveRNPage(String str, Object obj) {
        ThreadUtils.cancelTaskOnUiThread(this.mResendPageEventTask);
        this.mCoreMessageProcessor.savePage(new PageEvent(str, this.mCoreMessageProcessor.getPageNameWithoutPending(), System.currentTimeMillis()), obj);
        clearActionCalculatorMapAndSaveImpressDelay();
    }
}
