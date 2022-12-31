package com.growingio.android.sdk.java_websocket;

import android.app.Activity;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.growingio.android.sdk.base.event.SocketStatusEvent;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.CustomEvent;
import com.growingio.android.sdk.collection.DeviceUUIDFactory;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.models.ActionEvent;
import com.growingio.android.sdk.models.ConversionEvent;
import com.growingio.android.sdk.models.PageEvent;
import com.growingio.android.sdk.models.PageVariableEvent;
import com.growingio.android.sdk.models.PeopleEvent;
import com.growingio.android.sdk.models.VisitEvent;
import com.growingio.android.sdk.models.ad.ReengageEvent;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ScreenshotHelper;
import com.growingio.android.sdk.utils.WindowHelper;
import com.growingio.eventcenter.EventCenter;
import com.tapjoy.TapjoyConstants;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.cell.recycler.a;
/* loaded from: classes2.dex */
public class GioProtocol {
    private static final String CLIENT_INIT = "client_init";
    private static final String CLIENT_QUIT = "client_quit";
    private static final String EDITOR_QUIT = "editor_quit";
    private static final String EDITOR_READY = "editor_ready";
    private static final String HEARTBEAT = "heartbeat";
    private static final long HEARTBEAT_INTERVAL = 30000;
    private static final String HYBRID_MESSAGE = "hybridEvent";
    private static final String MSG_ID_SDK_CLOSE = "sdk_closed";
    private static final String TAG = "GIO.GioProtocol";
    private static final String TARGET_DISCONNECT = "target_disconnect";
    private String mAI;
    private String mAppVersion;
    private WebSocket mHeartBeatSocket;
    private String mSPN;
    private String mSdkVersion;
    private Integer mProtocolVersion = 0;
    ScheduledExecutorService mScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    private boolean isReady = false;
    private Runnable mHeartbeatTask = new Runnable() { // from class: com.growingio.android.sdk.java_websocket.GioProtocol.1
        @Override // java.lang.Runnable
        public void run() {
            if (GioProtocol.this.mHeartBeatSocket != null) {
                GioProtocol gioProtocol = GioProtocol.this;
                gioProtocol.sendHeartbeatMessage(gioProtocol.mHeartBeatSocket);
            }
            GioProtocol.this.mScheduledExecutor.schedule(this, 30000L, TimeUnit.MILLISECONDS);
        }
    };

    public GioProtocol() {
        CoreAppState coreAppState = CoreInitialize.coreAppState();
        setAI(coreAppState.getProjectId());
        setSPN(coreAppState.getSPN());
        setAppVersion(CoreInitialize.config().getAppVersion());
        setSdkVersion(GConfig.GROWING_VERSION);
        setProtocolVersion(1);
    }

    private static String getUploadEventType(String str) {
        return str == null ? a.PAGE_TYPE_OTHER : (str.equals(CustomEvent.TYPE_NAME) || str.equals(PageVariableEvent.TYPE_NAME) || str.equals(ConversionEvent.TYPE_NAME) || str.equals(PeopleEvent.TYPE_NAME)) ? CustomEvent.TYPE_NAME : (str.equals(PageEvent.TYPE_NAME) || str.equals(VisitEvent.TYPE_NAME)) ? "pv" : str.equals(ActionEvent.IMP_TYPE_NAME) ? ActionEvent.IMP_TYPE_NAME : a.PAGE_TYPE_OTHER;
    }

    private String parseMsgId(JSONObject jSONObject) throws JSONException {
        return jSONObject.getString("msgId");
    }

    public static String sendDebuggerInit() {
        LogUtil.d(TAG, "DebuggerInit");
        JSONObject jSONObject = new JSONObject();
        GConfig config = CoreInitialize.config();
        CoreAppState coreAppState = CoreInitialize.coreAppState();
        DeviceUUIDFactory deviceUUIDFactory = CoreInitialize.deviceUUIDFactory();
        try {
            jSONObject.put("msgId", "client_info");
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, GConfig.GROWING_VERSION);
            jSONObject.put("u", deviceUUIDFactory.getDeviceId());
            jSONObject.put("cs1", config.getAppUserId());
            try {
                JSONObject jSONObject2 = new JSONObject();
                String simOperator = ((TelephonyManager) CoreInitialize.coreAppState().getGlobalContext().getSystemService("phone")).getSimOperator();
                if (!TextUtils.isEmpty(simOperator) && simOperator.length() > 3) {
                    jSONObject2.put("countryCode", new StringBuffer(simOperator).insert(3, '-').toString());
                }
                jSONObject.put("locate", jSONObject2);
            } catch (Exception unused) {
                LogUtil.e(TAG, "位置信息错误");
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, config.getAppVersion());
            jSONObject3.put("appChannel", config.getChannel());
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W, ScreenshotHelper.getScaledShort());
            jSONObject4.put(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H, ScreenshotHelper.getScaledLong());
            jSONObject3.put("screenSize", jSONObject4);
            jSONObject3.put("os", Constants.PLATFORM_ANDROID);
            jSONObject3.put("osVersion", Build.VERSION.SDK_INT);
            jSONObject3.put("deviceBrand", Build.BRAND);
            jSONObject3.put("deviceType", Build.TYPE);
            jSONObject3.put("deviceModel", Build.MODEL);
            jSONObject.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, jSONObject3);
            jSONObject.put(PageEvent.TYPE_NAME, CoreInitialize.messageProcessor().getPageNameWithoutPending());
            jSONObject.put("referralPage", (Object) null);
            jSONObject.put(PeopleEvent.TYPE_NAME, coreAppState.getPeopleVariable());
            if (coreAppState.getForegroundActivity() != null) {
                jSONObject.put(PageVariableEvent.TYPE_NAME, coreAppState.getPageVariable());
            }
            jSONObject.put(ConversionEvent.TYPE_NAME, coreAppState.getConversionVariable());
            LogUtil.d(TAG, "向Debugger发送 client_info：");
            return jSONObject.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.d(TAG, "DebuggerInit 失败:" + e2.getMessage());
            return null;
        }
    }

    public static String sendDebuggerStr(JSONObject jSONObject) {
        String str;
        LogUtil.d(TAG, "向Debugger发送数据");
        try {
            str = jSONObject.getString("t");
        } catch (JSONException unused) {
            str = null;
        }
        DeviceUUIDFactory deviceUUIDFactory = CoreInitialize.deviceUUIDFactory();
        CoreAppState coreAppState = CoreInitialize.coreAppState();
        if (ReengageEvent.TYPE_NAME.equals(str)) {
            try {
                jSONObject.put("msgId", "server_action");
                jSONObject.put("u", deviceUUIDFactory.getDeviceId());
                return jSONObject.toString();
            } catch (JSONException e2) {
                LogUtil.d(TAG, "向Debugger发送数据失败：" + e2.toString());
            }
        }
        String format = String.format(Locale.US, "%s/%s/android/%s?stm=%d", NetworkConfig.getInstance().apiEndPoint(), coreAppState.getProjectId(), getUploadEventType(str), Long.valueOf(System.currentTimeMillis()));
        try {
            jSONObject.put("msgId", "server_action");
            jSONObject.put("uri", format);
            jSONObject.put("u", deviceUUIDFactory.getDeviceId());
        } catch (Exception unused2) {
            LogUtil.d(TAG, "获取信息失败");
        }
        LogUtil.d(TAG, "向Debugger发送 server_action：" + jSONObject.toString());
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendHeartbeatMessage(WebSocket webSocket) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgId", HEARTBEAT);
            jSONObject.put("ai", this.mAI);
            jSONObject.put("spn", this.mSPN);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        webSocket.send(jSONObject.toString());
    }

    public static String sendScreenUpdate() {
        LogUtil.e(TAG, "sendScreenUpdate:");
        byte[] captureAllWindows = ScreenshotHelper.captureAllWindows(WindowHelper.getSortedWindowViews(), null);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgId", "screen_update");
            jSONObject.put("screenshotWidth", ScreenshotHelper.getScaledShort());
            jSONObject.put("screenshotWidth", ScreenshotHelper.getScaledShort());
            jSONObject.put("screenshotHeight", ScreenshotHelper.getScaledLong());
            jSONObject.put("screenshot", "data:image/jpeg;base64," + Base64.encodeToString(captureAllWindows, 2));
            LogUtil.d(TAG, "向Debugger发送 screen_update：");
            return jSONObject.toString();
        } catch (Exception unused) {
            LogUtil.d(TAG, "屏幕更新失败");
            return null;
        }
    }

    public String dealWithOldVersionSDK(String str) {
        CoreAppState coreAppState;
        Activity foregroundActivity;
        Integer num = this.mProtocolVersion;
        if ((num != null && num.intValue() != 0) || (coreAppState = CoreInitialize.coreAppState()) == null || (foregroundActivity = coreAppState.getForegroundActivity()) == null) {
            return str;
        }
        if (foregroundActivity.getResources().getConfiguration().orientation != 2) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(PageEvent.TYPE_NAME) && jSONObject.has("screenshot")) {
                int i2 = jSONObject.getInt("screenshotWidth");
                int i3 = jSONObject.getInt("screenshotHeight");
                jSONObject.put("screenshotHeight", i2);
                jSONObject.put("screenshotWidth", i3);
                return jSONObject.toString();
            }
            return str;
        } catch (JSONException unused) {
            return str;
        }
    }

    public void fakeEditorReadyMessage(WebSocket webSocket) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgId", EDITOR_READY);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        webSocket.send(jSONObject.toString());
    }

    public boolean isClientQuit(String str) {
        return CLIENT_QUIT.equals(str);
    }

    public boolean isEditorQuit(String str) {
        return EDITOR_QUIT.equals(str) || TARGET_DISCONNECT.equals(str);
    }

    public boolean isEditorReady(String str) {
        return EDITOR_READY.equals(str);
    }

    public boolean isEmptyMessage(String str) {
        return " ".equals(str) || str == null || str.length() == 0;
    }

    public boolean isReady() {
        return this.isReady;
    }

    public void onMessage(String str) {
        if (isEmptyMessage(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String parseMsgId = parseMsgId(jSONObject);
            LogUtil.d(TAG, "onMessage, and msgId is:", parseMsgId);
            if (isEditorReady(parseMsgId)) {
                setReady(true);
                EventCenter.getInstance().post(SocketStatusEvent.ofStatus(SocketStatusEvent.SocketStatus.EDITOR_READY));
            } else if (isEditorQuit(parseMsgId)) {
                setReady(false);
                EventCenter.getInstance().post(SocketStatusEvent.ofStatus(SocketStatusEvent.SocketStatus.EDITOR_QUIT));
            } else if (isClientQuit(parseMsgId)) {
                setReady(false);
                EventCenter.getInstance().post(SocketStatusEvent.ofStatus(SocketStatusEvent.SocketStatus.CLIENT_QUIT));
            } else if (HYBRID_MESSAGE.equals(parseMsgId)) {
                EventCenter.getInstance().post(SocketStatusEvent.ofStatusAndObj(SocketStatusEvent.SocketStatus.HYBRID_MESSAGE, jSONObject));
            } else if (MSG_ID_SDK_CLOSE.equals(parseMsgId)) {
                EventCenter.getInstance().post(SocketStatusEvent.ofStatus(SocketStatusEvent.SocketStatus.EDITOR_QUIT));
            } else {
                EventCenter.getInstance().post(SocketStatusEvent.ofStatusAndObj(SocketStatusEvent.SocketStatus.OTHER_MESSAGE, str));
            }
        } catch (Throwable th) {
            LogUtil.e(TAG, th.getMessage(), th);
        }
    }

    public void sendAndroidInitMessage(WebSocket webSocket) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ai", this.mAI);
            jSONObject.put("msgId", CLIENT_INIT);
            Integer num = this.mProtocolVersion;
            if (num != null && num.intValue() > 0) {
                jSONObject.put("protocolVersion", this.mProtocolVersion);
            }
            jSONObject.put("tm", System.currentTimeMillis());
            jSONObject.put("spn", this.mSPN);
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, this.mSdkVersion);
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, this.mAppVersion);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        System.out.println("sendAndInitMessage");
        webSocket.send(jSONObject.toString());
    }

    public void sendQuitMessage(WebSocket webSocket) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgId", CLIENT_QUIT);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        webSocket.send(jSONObject.toString());
    }

    public void setAI(String str) {
        this.mAI = str;
    }

    public void setAppVersion(String str) {
        this.mAppVersion = str;
    }

    public void setProtocolVersion(Integer num) {
        this.mProtocolVersion = num;
    }

    public void setReady(boolean z) {
        this.isReady = z;
    }

    public void setSPN(String str) {
        this.mSPN = str;
    }

    public void setSdkVersion(String str) {
        this.mSdkVersion = str;
    }

    public void startSendHeartbeat(WebSocket webSocket) {
        this.mHeartBeatSocket = webSocket;
        this.mScheduledExecutor.schedule(this.mHeartbeatTask, 30000L, TimeUnit.MILLISECONDS);
    }

    public void stopSendHeartbeat() {
        this.mHeartBeatSocket = null;
    }

    public String parseMsgId(String str) {
        try {
            return parseMsgId(new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
