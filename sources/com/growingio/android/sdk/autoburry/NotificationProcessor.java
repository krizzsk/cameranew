package com.growingio.android.sdk.autoburry;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.util.FileUtil;
import com.growingio.android.sdk.base.event.NewIntentEvent;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ReflectUtil;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.bus.EventBus;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
import com.growingio.eventcenter.bus.meta.Subscriber;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@TargetApi(12)
/* loaded from: classes2.dex */
public class NotificationProcessor implements Subscriber {
    private static final String ACTION_HUAWEI_CLICK = "com.huawei.android.push.intent.CLICK";
    private static final String ACTION_HUAWEI_PUSH = "com.huawei.intent.action.PUSH";
    private static final String ACTION_XIAOMI_RECEIVE_MESSAGE = "com.xiaomi.mipush.RECEIVE_MESSAGE";
    private static final String DIR_NAME = ".gio.push";
    @VisibleForTesting
    static final String GIO_ID_KEY = "__GIO_ID";
    private static final long MAX_TIME = 86400000;
    private static final String TAG = "GIO.Notification";
    CoreAppState coreAppState;
    boolean enable;
    private AtomicInteger gioIntentId;
    private long lastHuaWeiPush;
    private int myPid;
    @VisibleForTesting
    WeakHashMap<PendingIntent, String> pendingIntent2Ids;
    File pushFile;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class NotificationActionInfo {
        String actionTitle;
        NotificationInfo info;

        NotificationActionInfo() {
        }

        public static NotificationActionInfo fromJson(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                NotificationActionInfo notificationActionInfo = new NotificationActionInfo();
                notificationActionInfo.actionTitle = jSONObject.optString("actionTitle");
                NotificationInfo notificationInfo = new NotificationInfo();
                notificationActionInfo.info = notificationInfo;
                notificationInfo.title = jSONObject.optString("title");
                notificationActionInfo.info.content = jSONObject.optString(FirebaseAnalytics.Param.CONTENT);
                notificationActionInfo.info.hasContentPending = jSONObject.getBoolean("hasContentPending");
                return notificationActionInfo;
            } catch (JSONException e2) {
                LogUtil.d(NotificationProcessor.TAG, e2);
                return null;
            }
        }

        public String toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("actionTitle", this.actionTitle);
                jSONObject.put("hasContentPending", this.info.hasContentPending);
                jSONObject.put("title", this.info.title);
                jSONObject.put(FirebaseAnalytics.Param.CONTENT, this.info.content);
                return jSONObject.toString();
            } catch (JSONException e2) {
                LogUtil.d(NotificationProcessor.TAG, e2);
                return null;
            }
        }

        public String toString() {
            return "NotificationActionInfo{info=" + this.info + ", actionTitle='" + this.actionTitle + "'}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class NotificationInfo {
        String content;
        boolean hasContentPending;
        String title;

        NotificationInfo() {
        }

        public String toString() {
            return "NotificationInfo{title='" + this.title + "', content='" + this.content + "', hasContentPending=" + this.hasContentPending + '}';
        }
    }

    /* loaded from: classes2.dex */
    public static class NotificationReadEvent {
        final String intentId;

        private NotificationReadEvent(String str) {
            this.intentId = str;
        }
    }

    /* loaded from: classes2.dex */
    public static class NotificationStoreEvent {
        private final NotificationActionInfo actionInfo;
        private final String intentId;

        private NotificationStoreEvent(NotificationActionInfo notificationActionInfo, String str) {
            this.actionInfo = notificationActionInfo;
            this.intentId = str;
        }
    }

    public NotificationProcessor(Context context, CoreAppState coreAppState) {
        this.pendingIntent2Ids = new WeakHashMap<>();
        this.gioIntentId = new AtomicInteger();
        this.pushFile = new File(context.getFilesDir(), DIR_NAME);
        this.myPid = Process.myPid();
        this.enable = Build.VERSION.SDK_INT >= 19;
        this.coreAppState = coreAppState;
    }

    private boolean checkAndStoreNotificationInfo(PendingIntent pendingIntent, String str, NotificationInfo notificationInfo) {
        if (pendingIntent == null) {
            return false;
        }
        String str2 = this.pendingIntent2Ids.get(pendingIntent);
        if (str2 != null) {
            NotificationActionInfo notificationActionInfo = new NotificationActionInfo();
            notificationActionInfo.actionTitle = str;
            notificationActionInfo.info = notificationInfo;
            EventBus.getDefault().post(new NotificationStoreEvent(notificationActionInfo, str2));
        } else {
            LogUtil.d(TAG, "checkAndStoreNotificationInfo, but gio not found, actionTitle: ", str);
        }
        return true;
    }

    private NotificationInfo getNotificationInfo(Notification notification) {
        NotificationInfo notificationInfo = new NotificationInfo();
        if (Build.VERSION.SDK_INT >= 19) {
            notificationInfo.title = notification.extras.getString(NotificationCompat.EXTRA_TITLE);
            notificationInfo.content = notification.extras.getString(NotificationCompat.EXTRA_TEXT);
        }
        return notificationInfo;
    }

    private void handleHuaWeiNCMessage(Intent intent) {
        try {
            JSONArray jSONArray = new JSONArray(intent.getStringExtra("click"));
            new JSONObject();
            String str = null;
            String str2 = null;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject.has("notification_title")) {
                    str = jSONObject.optString("notification_title");
                }
                if (jSONObject.has("notification_content")) {
                    str2 = jSONObject.optString("notification_content");
                }
            }
            sendMessageClickedEvent(str, str2, "GIO$$ContentPending");
        } catch (Exception e2) {
            LogUtil.e(TAG, e2.getMessage(), e2);
        }
    }

    private synchronized void initAndCleanDir() {
        if (!this.pushFile.exists()) {
            this.pushFile.mkdirs();
        }
        File[] listFiles = this.pushFile.listFiles();
        if (listFiles == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (File file : listFiles) {
            if (currentTimeMillis - file.lastModified() > 86400000) {
                LogUtil.d(TAG, "clean file: ", file);
                file.delete();
            }
        }
    }

    private boolean isHooked(Intent intent) {
        try {
            return intent.hasExtra(GIO_ID_KEY);
        } catch (Exception e2) {
            LogUtil.e(TAG, e2.getMessage(), e2);
            return false;
        }
    }

    private void parseNotificationTitleLowVersion(NotificationInfo notificationInfo, Notification notification) {
        try {
            Class<?> cls = Class.forName("import com.android.internal.R.id");
            Field field = null;
            Object findField = ReflectUtil.findField(cls, null, "title");
            Object findField2 = ReflectUtil.findField(cls, null, "text");
            if (findField != null && findField2 != null) {
                List list = (List) ReflectUtil.findField(RemoteViews.class, notification.contentView, "actions");
                if (list != null) {
                    Field field2 = null;
                    Field field3 = null;
                    for (Object obj : list) {
                        if (field == null) {
                            field = ReflectUtil.findFieldObjRecur(obj.getClass(), "viewId");
                            field2 = ReflectUtil.findFieldObjRecur(obj.getClass(), "methodName");
                            field3 = ReflectUtil.findFieldObjRecur(obj.getClass(), FirebaseAnalytics.Param.VALUE);
                        }
                        if (field3 != null && "setText".equals(field2.get(obj))) {
                            if (((Integer) field.get(obj)).intValue() == ((Integer) findField).intValue()) {
                                notificationInfo.title = (String) field3.get(obj);
                            } else if (((Integer) field.get(obj)).intValue() == ((Integer) findField2).intValue()) {
                                notificationInfo.content = (String) field3.get(obj);
                            }
                        }
                    }
                }
                Toast.makeText(CoreInitialize.coreAppState().getGlobalContext(), "获取标题: " + notificationInfo.title + ", 内容: " + notificationInfo.content, 0).show();
                return;
            }
            LogUtil.d(TAG, "parse titleId failed");
        } catch (Exception e2) {
            Log.e(TAG, e2.getMessage(), e2);
            LogUtil.d(TAG, "parseNotification low version: failed");
        }
    }

    private void sendMessageArrivedEvent(String str, String str2) {
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("notification_title", str);
            jSONObject.put("notification_content", str2);
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.growingio.android.sdk.autoburry.NotificationProcessor.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getInstance().track("notification_show", jSONObject);
                }
            });
        } catch (Exception e2) {
            LogUtil.d(TAG, e2);
        }
    }

    private void sendMessageClickedEvent(String str, String str2, String str3) {
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("notification_title", str);
            jSONObject.put("notification_content", str2);
            jSONObject.put("notification_action_title", str3);
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.growingio.android.sdk.autoburry.NotificationProcessor.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getInstance().track("notification_click", jSONObject);
                }
            });
        } catch (JSONException e2) {
            LogUtil.d(TAG, e2);
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public void do$Action(String str, Object obj) {
        if (str.equals("#onIntent(com.growingio.android.sdk.base.event.NewIntentEvent")) {
            onIntent((NewIntentEvent) obj);
        } else if (str.equals("#storeNotificationInfo(com.growingio.android.sdk.autoburry.NotificationProcessor$NotificationStoreEvent")) {
            storeNotificationInfo((NotificationStoreEvent) obj);
        } else if (str.equals("#onIntentGet(com.growingio.android.sdk.autoburry.NotificationProcessor$NotificationReadEvent")) {
            onIntentGet((NotificationReadEvent) obj);
        } else {
            System.out.println("No such method to delegate");
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public SubscriberMethod[] get$SubscriberMethods() {
        ThreadMode threadMode = ThreadMode.BACKGROUND;
        return new SubscriberMethod[]{new SubscriberMethod("onIntent", NewIntentEvent.class, "#onIntent(com.growingio.android.sdk.base.event.NewIntentEvent", ThreadMode.MAIN, 0, false), new SubscriberMethod("storeNotificationInfo", NotificationStoreEvent.class, "#storeNotificationInfo(com.growingio.android.sdk.autoburry.NotificationProcessor$NotificationStoreEvent", threadMode, 0, false), new SubscriberMethod("onIntentGet", NotificationReadEvent.class, "#onIntentGet(com.growingio.android.sdk.autoburry.NotificationProcessor$NotificationReadEvent", threadMode, 0, false)};
    }

    public void hookPendingIntentCreateAfter(@NonNull Intent intent, PendingIntent pendingIntent) {
        if (this.enable) {
            String stringExtra = intent.getStringExtra(GIO_ID_KEY);
            if (stringExtra == null) {
                if (ACTION_XIAOMI_RECEIVE_MESSAGE.equals(intent.getAction())) {
                    this.pendingIntent2Ids.put(pendingIntent, "XIAO_MI");
                }
                LogUtil.d(TAG, "hookPendingIntentCreateAfter, but gioId is null, maybe xiaomi push just return");
                return;
            }
            this.pendingIntent2Ids.put(pendingIntent, stringExtra);
        }
    }

    public void hookPendingIntentCreateBefore(@NonNull Intent intent) {
        this.coreAppState.waitUntilInitComplete();
        if (this.enable) {
            if (isHooked(intent)) {
                LogUtil.v(TAG, "hookPendingIntentCreate, and intent has been hooked, and return");
            } else if (ACTION_XIAOMI_RECEIVE_MESSAGE.equals(intent.getAction())) {
            } else {
                intent.putExtra(GIO_ID_KEY, this.myPid + "-_-" + this.gioIntentId.getAndIncrement());
            }
        }
    }

    public boolean isEnable() {
        return this.enable;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onIntent(NewIntentEvent newIntentEvent) {
        if (this.enable) {
            this.coreAppState.waitUntilInitComplete();
            Intent intent = newIntentEvent.intent;
            if (intent == null) {
                return;
            }
            if (isHooked(intent)) {
                LogUtil.d(TAG, "onIntent, and found hooked intent: ", intent.getAction());
                String stringExtra = intent.getStringExtra(GIO_ID_KEY);
                intent.removeExtra(GIO_ID_KEY);
                if (stringExtra == null) {
                    LogUtil.d(TAG, "onIntent, and id is null, return");
                    return;
                }
                if (ACTION_HUAWEI_PUSH.equals(intent.getAction())) {
                    this.lastHuaWeiPush = System.currentTimeMillis();
                }
                EventBus.getDefault().post(new NotificationReadEvent(stringExtra));
            } else if (!ACTION_HUAWEI_CLICK.equals(intent.getAction()) || System.currentTimeMillis() - this.lastHuaWeiPush <= 5000) {
            } else {
                LogUtil.d(TAG, "HuaWei NC message received");
                handleHuaWeiNCMessage(intent);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onIntentGet(NotificationReadEvent notificationReadEvent) {
        NotificationActionInfo notificationInfo = getNotificationInfo(notificationReadEvent.intentId);
        if (notificationInfo == null) {
            LogUtil.d(TAG, "onIntent, and actionInfo is null, return");
            return;
        }
        LogUtil.d(TAG, "onIntent, and found actionInfo: ", notificationInfo);
        NotificationInfo notificationInfo2 = notificationInfo.info;
        sendMessageClickedEvent(notificationInfo2.title, notificationInfo2.content, notificationInfo.actionTitle);
    }

    public void onNotify(String str, int i2, Notification notification) {
        if (this.enable) {
            this.coreAppState.waitUntilInitComplete();
            PendingIntent pendingIntent = notification.contentIntent;
            if (pendingIntent != null && "XIAO_MI".equals(this.pendingIntent2Ids.get(pendingIntent))) {
                LogUtil.d(TAG, "onNotify, and found xiaomi push, just return");
                return;
            }
            LogUtil.d(TAG, "onNotify, tag: ", str, ", id=", Integer.valueOf(i2));
            NotificationInfo notificationInfo = getNotificationInfo(notification);
            notificationInfo.hasContentPending = checkAndStoreNotificationInfo(notification.contentIntent, "GIO$$ContentPending", notificationInfo);
            sendMessageArrivedEvent(notificationInfo.title, notificationInfo.content);
        }
    }

    public void onXiaoMiMessageArrived(MiPushMessage miPushMessage) {
        if (this.enable) {
            LogUtil.d(TAG, "onXiaoMiMessageArrived: ", miPushMessage.toString());
            sendMessageArrivedEvent(miPushMessage.getTitle(), miPushMessage.getDescription());
        }
    }

    public void onXiaoMiMessageClicked(MiPushMessage miPushMessage) {
        if (this.enable) {
            LogUtil.d(TAG, "onXiaoMiMessageClicked: ", miPushMessage.toString());
            sendMessageClickedEvent(miPushMessage.getTitle(), miPushMessage.getDescription(), "GIO$$ContentPending");
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void storeNotificationInfo(NotificationStoreEvent notificationStoreEvent) {
        String str = notificationStoreEvent.intentId;
        NotificationActionInfo notificationActionInfo = notificationStoreEvent.actionInfo;
        LogUtil.d(TAG, "storeNotificationInfo: id=", str, ", actionInfo", notificationActionInfo);
        initAndCleanDir();
        File file = new File(this.pushFile, str);
        if (file.exists()) {
            LogUtil.e(TAG, "toFile exists, maybe some error");
            file.delete();
        }
        try {
            FileUtil.writeToFile(file, notificationActionInfo.toJson());
        } catch (IOException e2) {
            LogUtil.e(TAG, e2.getMessage(), e2);
        }
    }

    public NotificationActionInfo getNotificationInfo(String str) {
        initAndCleanDir();
        File file = new File(this.pushFile, str);
        if (file.exists()) {
            try {
                String readFromFile = FileUtil.readFromFile(file);
                if (TextUtils.isEmpty(readFromFile)) {
                    return null;
                }
                return NotificationActionInfo.fromJson(readFromFile);
            } catch (IOException e2) {
                LogUtil.e(TAG, e2.getMessage(), e2);
                return null;
            }
        }
        return null;
    }

    @VisibleForTesting
    NotificationProcessor() {
        this.pendingIntent2Ids = new WeakHashMap<>();
        this.gioIntentId = new AtomicInteger();
    }
}
