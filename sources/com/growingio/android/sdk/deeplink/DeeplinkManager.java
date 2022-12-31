package com.growingio.android.sdk.deeplink;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.growingio.android.sdk.base.event.ActivityLifecycleEvent;
import com.growingio.android.sdk.base.event.HttpCallBack;
import com.growingio.android.sdk.base.event.HttpEvent;
import com.growingio.android.sdk.base.event.NewIntentEvent;
import com.growingio.android.sdk.base.event.ValidUrlEvent;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.DeviceUUIDFactory;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.deeplink.UploadData;
import com.growingio.android.sdk.models.ad.ActivateEvent;
import com.growingio.android.sdk.models.ad.ReengageEvent;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.NetworkUtil;
import com.growingio.android.sdk.utils.ObjectUtils;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.EventCenter;
import com.growingio.eventcenter.bus.EventBus;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
import com.growingio.eventcenter.bus.meta.Subscriber;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes2.dex */
public class DeeplinkManager implements Subscriber {
    private static final String TAG = "GIO.deeplink";
    private DeeplinkInfo activateDeepLink;
    @VisibleForTesting
    ClipboardManager cm;
    private WeakReference<Intent> lastIntentRef;
    @VisibleForTesting
    GConfig mConfig;
    private Context mGlobalContext;
    private boolean isActivateSended = false;
    private boolean isDigestedIntent = false;
    private boolean isClipBoardChecked = false;

    public DeeplinkManager(GConfig gConfig, Context context) {
        this.mConfig = gConfig;
        this.mGlobalContext = context;
    }

    @MainThread
    @VisibleForTesting
    private void checkActivateStatus(Activity activity) {
        if (!this.isActivateSended && !this.mConfig.isDeviceActivated()) {
            CoreInitialize.deviceUUIDFactory().initUserAgent(activity);
            if (!this.isClipBoardChecked) {
                if (this.cm == null) {
                    this.cm = (ClipboardManager) this.mGlobalContext.getSystemService("clipboard");
                }
                if (Build.VERSION.SDK_INT >= 29 && activity != null) {
                    activity.getWindow().getDecorView().post(new Runnable() { // from class: com.growingio.android.sdk.deeplink.DeeplinkManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DeeplinkManager.this.checkClipBoardAndSendActivateEvent();
                        }
                    });
                    return;
                } else {
                    checkClipBoardAndSendActivateEvent();
                    return;
                }
            }
            submitActivateEvent();
            return;
        }
        this.isActivateSended = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkClipBoardAndSendActivateEvent() {
        EventBus.getDefault().getExecutorService().submit(new Runnable() { // from class: com.growingio.android.sdk.deeplink.DeeplinkManager.2
            @Override // java.lang.Runnable
            public void run() {
                final DeeplinkInfo deeplinkInfo = new DeeplinkInfo();
                final boolean checkClipBoard = DeeplinkManager.this.checkClipBoard(deeplinkInfo);
                ThreadUtils.runOnUiThread(new Runnable() { // from class: com.growingio.android.sdk.deeplink.DeeplinkManager.2.1
                    /* JADX WARN: Code restructure failed: missing block: B:8:0x0062, code lost:
                        if (r1.parseClipBoardInfo(r0, r1.activateDeepLink) == false) goto L11;
                     */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public void run() {
                        /*
                            r6 = this;
                            com.growingio.android.sdk.deeplink.DeeplinkManager$2 r0 = com.growingio.android.sdk.deeplink.DeeplinkManager.AnonymousClass2.this
                            com.growingio.android.sdk.deeplink.DeeplinkManager r0 = com.growingio.android.sdk.deeplink.DeeplinkManager.this
                            com.growingio.android.sdk.deeplink.DeeplinkInfo r1 = r2
                            com.growingio.android.sdk.deeplink.DeeplinkManager.access$102(r0, r1)
                            boolean r0 = r3
                            r1 = 0
                            java.lang.String r2 = "GIO.deeplink"
                            r3 = 1
                            if (r0 == 0) goto L26
                            com.growingio.android.sdk.deeplink.DeeplinkManager$2 r0 = com.growingio.android.sdk.deeplink.DeeplinkManager.AnonymousClass2.this
                            com.growingio.android.sdk.deeplink.DeeplinkManager r0 = com.growingio.android.sdk.deeplink.DeeplinkManager.this
                            com.growingio.android.sdk.deeplink.DeeplinkInfo r4 = com.growingio.android.sdk.deeplink.DeeplinkManager.access$100(r0)
                            com.growingio.android.sdk.deeplink.DeeplinkManager.access$200(r0, r4)
                            java.lang.Object[] r0 = new java.lang.Object[r3]
                            java.lang.String r4 = "用户通过延迟深度链接方式打开，收到参数准备传给 DeepLinkCallback"
                            r0[r1] = r4
                            com.growingio.android.sdk.utils.LogUtil.d(r2, r0)
                            goto L6c
                        L26:
                            java.lang.Object[] r0 = new java.lang.Object[r3]
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder
                            r4.<init>()
                            java.lang.String r5 = "非延迟深度链接方式打开应用"
                            r4.append(r5)
                            com.growingio.android.sdk.deeplink.DeeplinkManager$2 r5 = com.growingio.android.sdk.deeplink.DeeplinkManager.AnonymousClass2.this
                            com.growingio.android.sdk.deeplink.DeeplinkManager r5 = com.growingio.android.sdk.deeplink.DeeplinkManager.this
                            boolean r5 = com.growingio.android.sdk.deeplink.DeeplinkManager.access$300(r5)
                            r4.append(r5)
                            java.lang.String r4 = r4.toString()
                            r0[r1] = r4
                            com.growingio.android.sdk.utils.LogUtil.d(r2, r0)
                            com.growingio.android.sdk.deeplink.DeeplinkManager$2 r0 = com.growingio.android.sdk.deeplink.DeeplinkManager.AnonymousClass2.this
                            com.growingio.android.sdk.deeplink.DeeplinkManager r0 = com.growingio.android.sdk.deeplink.DeeplinkManager.this
                            com.growingio.android.sdk.collection.GConfig r0 = r0.mConfig
                            java.lang.String r0 = r0.getActivateInfo()
                            boolean r1 = r0.isEmpty()
                            if (r1 != 0) goto L64
                            com.growingio.android.sdk.deeplink.DeeplinkManager$2 r1 = com.growingio.android.sdk.deeplink.DeeplinkManager.AnonymousClass2.this
                            com.growingio.android.sdk.deeplink.DeeplinkManager r1 = com.growingio.android.sdk.deeplink.DeeplinkManager.this
                            com.growingio.android.sdk.deeplink.DeeplinkInfo r2 = com.growingio.android.sdk.deeplink.DeeplinkManager.access$100(r1)
                            boolean r0 = r1.parseClipBoardInfo(r0, r2)
                            if (r0 != 0) goto L6c
                        L64:
                            com.growingio.android.sdk.deeplink.DeeplinkManager$2 r0 = com.growingio.android.sdk.deeplink.DeeplinkManager.AnonymousClass2.this
                            com.growingio.android.sdk.deeplink.DeeplinkManager r0 = com.growingio.android.sdk.deeplink.DeeplinkManager.this
                            r1 = 0
                            com.growingio.android.sdk.deeplink.DeeplinkManager.access$102(r0, r1)
                        L6c:
                            com.growingio.android.sdk.deeplink.DeeplinkManager$2 r0 = com.growingio.android.sdk.deeplink.DeeplinkManager.AnonymousClass2.this
                            com.growingio.android.sdk.deeplink.DeeplinkManager r0 = com.growingio.android.sdk.deeplink.DeeplinkManager.this
                            com.growingio.android.sdk.deeplink.DeeplinkManager.access$402(r0, r3)
                            com.growingio.android.sdk.deeplink.DeeplinkManager$2 r0 = com.growingio.android.sdk.deeplink.DeeplinkManager.AnonymousClass2.this
                            com.growingio.android.sdk.deeplink.DeeplinkManager r0 = com.growingio.android.sdk.deeplink.DeeplinkManager.this
                            com.growingio.android.sdk.deeplink.DeeplinkManager.access$500(r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.deeplink.DeeplinkManager.AnonymousClass2.AnonymousClass1.run():void");
                    }
                });
            }
        });
    }

    private void handleDeepLink(Uri uri) {
        DeeplinkInfo deeplinkInfo = new DeeplinkInfo();
        Uri parse = Uri.parse(uri.toString().replace("&amp;", "&"));
        deeplinkInfo.linkID = parse.getQueryParameter("link_id");
        deeplinkInfo.clickID = parse.getQueryParameter("click_id") != null ? parse.getQueryParameter("click_id") : "";
        deeplinkInfo.clickTM = parse.getQueryParameter("tm_click") != null ? parse.getQueryParameter("tm_click") : "";
        deeplinkInfo.customParams = parse.getQueryParameter("custom_params");
        deeplinkInfo.tm = System.currentTimeMillis();
        sendReengage(deeplinkInfo);
        if (this.mConfig.getDeeplinkCallback() != null) {
            HashMap hashMap = new HashMap();
            this.mConfig.getDeeplinkCallback().onReceive(hashMap, parseJson(deeplinkInfo.customParams, hashMap), 0L);
        }
    }

    public static boolean isDeepLinkUrl(@Nullable String str, @Nullable Uri uri) {
        if (uri == null) {
            if (str == null) {
                return false;
            }
            uri = Uri.parse(str);
        }
        String host = uri.getHost();
        String scheme = uri.getScheme();
        if (host == null || scheme == null) {
            return false;
        }
        if ("http".equals(scheme) || "https".equals(scheme)) {
            return "gio.ren".equals(host) || "datayi.cn".equals(host) || host.endsWith(".datayi.cn");
        }
        return false;
    }

    private int parseJson(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            map.clear();
            return 3;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!"_gio_var".equals(next)) {
                    map.put(next, jSONObject.getString(next));
                }
            }
            return 0;
        } catch (JSONException unused) {
            map.clear();
            return 1;
        }
    }

    private void reengage(String str, String str2, String str3, String str4, long j2) {
        if (TextUtils.isEmpty(str4)) {
            str4 = "{}";
        }
        DeeplinkInfo deeplinkInfo = new DeeplinkInfo();
        deeplinkInfo.linkID = str;
        deeplinkInfo.clickID = str2;
        deeplinkInfo.clickTM = str3;
        deeplinkInfo.customParams = str4;
        deeplinkInfo.tm = j2;
        new UploadData.Builder().setType(UploadData.UploadType.REENGAGE).setDeeplinkInfo(deeplinkInfo).build().upload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendInfoToDefferCallback(DeeplinkInfo deeplinkInfo) {
        if (deeplinkInfo == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(deeplinkInfo.customParams);
            final HashMap hashMap = new HashMap();
            final int parseJson = parseJson(jSONObject.toString(), hashMap);
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.growingio.android.sdk.deeplink.DeeplinkManager.5
                @Override // java.lang.Runnable
                public void run() {
                    if (DeeplinkManager.this.mConfig.getDeeplinkCallback() != null) {
                        DeeplinkManager.this.mConfig.getDeeplinkCallback().onReceive(hashMap, parseJson, 0L);
                    }
                }
            });
        } catch (JSONException e2) {
            LogUtil.e(TAG, "deeplink info 解析异常 ", e2);
        }
    }

    private void sendReengage(DeeplinkInfo deeplinkInfo) {
        if (TextUtils.isEmpty(deeplinkInfo.customParams)) {
            deeplinkInfo.customParams = "{}";
        }
        CoreInitialize.messageProcessor().persistEvent(new ReengageEvent(deeplinkInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitActivateEvent() {
        if (!this.mConfig.isEnabled() || this.mConfig.isDeviceActivated()) {
            return;
        }
        this.isActivateSended = true;
        DeeplinkInfo deeplinkInfo = this.activateDeepLink;
        if (deeplinkInfo != null) {
            sendReengage(deeplinkInfo);
        }
        CoreInitialize.messageProcessor().persistEvent(this.isDigestedIntent ? new ActivateEvent() : new ActivateEvent(this.activateDeepLink));
        CoreInitialize.config().setDeviceActivated();
        this.mConfig.setActivateInfo("");
    }

    @VisibleForTesting
    boolean checkClipBoard(DeeplinkInfo deeplinkInfo) {
        CharSequence coerceToText;
        try {
            ClipboardManager clipboardManager = this.cm;
            ClipData primaryClip = clipboardManager != null ? clipboardManager.getPrimaryClip() : null;
            if (primaryClip == null || primaryClip.getItemCount() == 0) {
                return false;
            }
            ClipData.Item itemAt = primaryClip.getItemAt(0);
            if ("text/html".equals(primaryClip.getDescription().getMimeType(0)) && (coerceToText = itemAt.coerceToText(this.mGlobalContext)) != null && coerceToText.length() != 0) {
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                while (true) {
                    int i3 = 1;
                    if (i2 >= coerceToText.length()) {
                        break;
                    }
                    if (coerceToText.charAt(i2) == 8204) {
                        i3 = 0;
                    }
                    sb.append(i3);
                    i2++;
                }
                if (sb.length() % 16 != 0) {
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                int i4 = 0;
                while (i4 < sb.length()) {
                    int i5 = i4 + 16;
                    arrayList.add(sb.substring(i4, i5));
                    i4 = i5;
                }
                StringBuilder sb2 = new StringBuilder();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sb2.append((char) Integer.parseInt((String) it.next(), 2));
                }
                String sb3 = sb2.toString();
                if (parseClipBoardInfo(sb3, deeplinkInfo)) {
                    this.mConfig.setActivateInfo(sb3);
                    if (Build.VERSION.SDK_INT >= 28) {
                        this.cm.clearPrimaryClip();
                    } else {
                        this.cm.setPrimaryClip(ClipData.newPlainText(null, null));
                    }
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            LogUtil.e(TAG, e2.toString());
            return false;
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public void do$Action(String str, Object obj) {
        if (str.equals("#onActivityLifecycle(com.growingio.android.sdk.base.event.ActivityLifecycleEvent")) {
            onActivityLifecycle((ActivityLifecycleEvent) obj);
        } else if (str.equals("#onActivateEvent(com.growingio.android.sdk.deeplink.DeepLinkEvent")) {
            onActivateEvent((DeepLinkEvent) obj);
        } else if (str.equals("#onValidSchemaUrlIntent(com.growingio.android.sdk.base.event.ValidUrlEvent")) {
            onValidSchemaUrlIntent((ValidUrlEvent) obj);
        } else {
            System.out.println("No such method to delegate");
        }
    }

    public boolean doDeeplinkByUrl(@Nullable String str, @Nullable DeeplinkCallback deeplinkCallback) {
        if (!isDeepLinkUrl(str, null)) {
            LogUtil.d(TAG, "doDeeplinkByUrl, but url is not DeeplinkUrl, just return false: ", str);
            return false;
        }
        handleAppLink(parseTrackerId(str), false, true, deeplinkCallback);
        return true;
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public SubscriberMethod[] get$SubscriberMethods() {
        ThreadMode threadMode = ThreadMode.POSTING;
        return new SubscriberMethod[]{new SubscriberMethod("onActivityLifecycle", ActivityLifecycleEvent.class, "#onActivityLifecycle(com.growingio.android.sdk.base.event.ActivityLifecycleEvent", threadMode, 0, false), new SubscriberMethod("onActivateEvent", DeepLinkEvent.class, "#onActivateEvent(com.growingio.android.sdk.deeplink.DeepLinkEvent", threadMode, 0, false), new SubscriberMethod("onValidSchemaUrlIntent", ValidUrlEvent.class, "#onValidSchemaUrlIntent(com.growingio.android.sdk.base.event.ValidUrlEvent", threadMode, 0, false)};
    }

    @VisibleForTesting
    void handleAppLink(String str, final boolean z, boolean z2, final DeeplinkCallback deeplinkCallback) {
        final long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        DeviceUUIDFactory deviceUUIDFactory = CoreInitialize.deviceUUIDFactory();
        hashMap.put("ua", deviceUUIDFactory.getUserAgent());
        hashMap.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, deviceUUIDFactory.getIp());
        if (CoreInitialize.config().isEnabled()) {
            HttpEvent httpEvent = new HttpEvent();
            httpEvent.setUrl(NetworkConfig.getInstance().getAppLinkParamsUrl(str, z2));
            httpEvent.setRequestMethod(HttpEvent.REQUEST_METHOD.GET);
            httpEvent.setHeaders(hashMap);
            httpEvent.setCallBack(new HttpCallBack() { // from class: com.growingio.android.sdk.deeplink.DeeplinkManager.3
                @Override // com.growingio.android.sdk.base.event.HttpCallBack
                public void afterRequest(Integer num, byte[] bArr, long j2, Map<String, List<String>> map) {
                    DeeplinkManager.this.onReceiveAppLinkArgs(num, bArr, z, currentTimeMillis, deeplinkCallback);
                }
            });
            EventCenter.getInstance().post(httpEvent);
        }
    }

    public boolean handleIntent(Intent intent, Activity activity) {
        this.lastIntentRef = new WeakReference<>(intent);
        EventCenter.getInstance().post(new NewIntentEvent(intent));
        Uri data = intent == null ? null : intent.getData();
        if (data == null || data.getScheme() == null) {
            return false;
        }
        if (data.getScheme().startsWith("growing.")) {
            EventCenter.getInstance().post(new ValidUrlEvent(data, activity, 1));
            intent.setData(null);
            return true;
        } else if (data.getHost() != null && isDeepLinkUrl(null, data)) {
            EventCenter.getInstance().post(new ValidUrlEvent(data, activity, 2));
            intent.setData(null);
            return true;
        } else {
            return false;
        }
    }

    @Subscribe
    public void onActivateEvent(DeepLinkEvent deepLinkEvent) {
        if (deepLinkEvent.getType() == 1 && this.isClipBoardChecked) {
            checkActivateStatus(null);
        }
    }

    @Subscribe
    public void onActivityLifecycle(ActivityLifecycleEvent activityLifecycleEvent) {
        ActivityLifecycleEvent.EVENT_TYPE event_type = activityLifecycleEvent.event_type;
        if (event_type == ActivityLifecycleEvent.EVENT_TYPE.ON_CREATED || event_type == ActivityLifecycleEvent.EVENT_TYPE.ON_NEW_INTENT || event_type == ActivityLifecycleEvent.EVENT_TYPE.ON_STARTED) {
            WeakReference<Intent> weakReference = this.lastIntentRef;
            if (weakReference != null && weakReference.get() == activityLifecycleEvent.getIntent()) {
                LogUtil.d(TAG, "handleIntent, and this intent has been dealt, return");
                return;
            }
            this.isDigestedIntent = handleIntent(activityLifecycleEvent.getIntent(), activityLifecycleEvent.getActivity());
        }
        if (activityLifecycleEvent.event_type == ActivityLifecycleEvent.EVENT_TYPE.ON_RESUMED) {
            checkActivateStatus(activityLifecycleEvent.getActivity());
        }
    }

    void onReceiveAppLinkArgs(Integer num, byte[] bArr, boolean z, final long j2, final DeeplinkCallback deeplinkCallback) {
        int i2;
        HashMap hashMap;
        DeeplinkInfo deeplinkInfo = new DeeplinkInfo();
        try {
            if (num.intValue() == 200) {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                i2 = jSONObject.getInt("code");
                String optString = jSONObject.optString("msg");
                if (i2 == 200) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    deeplinkInfo.clickID = jSONObject2.getString("click_id");
                    deeplinkInfo.linkID = jSONObject2.getString("link_id");
                    deeplinkInfo.clickTM = jSONObject2.getString("tm_click");
                    deeplinkInfo.customParams = jSONObject2.getString("custom_params");
                    deeplinkInfo.tm = System.currentTimeMillis();
                    if (z) {
                        sendReengage(deeplinkInfo);
                    }
                    i2 = 0;
                } else {
                    LogUtil.d(TAG, "onReceiveApplinkArgs returnCode error: ", Integer.valueOf(i2), ": ", optString);
                }
            } else {
                i2 = 5;
            }
        } catch (Exception e2) {
            LogUtil.e(TAG, "parse the applink params error \n" + e2.toString());
            i2 = 6;
        }
        if (i2 == 0) {
            hashMap = new HashMap();
            i2 = parseJson(deeplinkInfo.customParams, hashMap);
        } else {
            hashMap = null;
        }
        final HashMap hashMap2 = hashMap;
        final int i3 = i2;
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.growingio.android.sdk.deeplink.DeeplinkManager.4
            @Override // java.lang.Runnable
            public void run() {
                DeeplinkCallback deeplinkCallback2 = deeplinkCallback;
                if (deeplinkCallback2 == null) {
                    deeplinkCallback2 = DeeplinkManager.this.mConfig.getDeeplinkCallback();
                }
                if (deeplinkCallback2 != null) {
                    deeplinkCallback2.onReceive(hashMap2, i3, System.currentTimeMillis() - j2);
                }
            }
        });
    }

    @Subscribe
    public void onValidSchemaUrlIntent(ValidUrlEvent validUrlEvent) {
        if (CoreInitialize.coreAppState().getForegroundActivity() == null) {
            CoreInitialize.coreAppState().setForegroundActivity(validUrlEvent.activity);
        }
        CoreInitialize.deviceUUIDFactory().initUserAgent(validUrlEvent.activity);
        int i2 = validUrlEvent.type;
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            if (TextUtils.isEmpty(validUrlEvent.data.getPath())) {
                LogUtil.e(TAG, "onValidSchemaUrlIntent, but not valid applink, return");
                return;
            } else {
                handleAppLink(parseTrackerId(validUrlEvent.data.toString()), true, false, null);
                return;
            }
        }
        String queryParameter = validUrlEvent.data.getQueryParameter("openConsoleLog");
        if (!TextUtils.isEmpty(queryParameter) && "YES".equalsIgnoreCase(queryParameter)) {
            LogUtil.add(LogUtil.DebugUtil.getInstance());
        }
        if (TextUtils.isEmpty(validUrlEvent.data.getQueryParameter("link_id"))) {
            LogUtil.e(TAG, "onValidSchemaUrlIntent, but not found link_id, return");
        } else {
            handleDeepLink(validUrlEvent.data);
        }
    }

    boolean parseClipBoardInfo(String str, DeeplinkInfo deeplinkInfo) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if ("gads".equals(jSONObject.getString("typ"))) {
                if (!ObjectUtils.equals(this.mConfig.getsGrowingScheme(), jSONObject.getString("scheme"))) {
                    LogUtil.d(TAG, "非此应用的延迟深度链接， urlsheme 不匹配，期望为：" + this.mConfig.getsGrowingScheme() + "， 实际为：" + jSONObject.getString("scheme"));
                    return false;
                }
                deeplinkInfo.linkID = jSONObject.getString("link_id");
                deeplinkInfo.clickID = jSONObject.getString("click_id");
                deeplinkInfo.clickTM = jSONObject.getString("tm_click");
                deeplinkInfo.customParams = NetworkUtil.decode(jSONObject.getJSONObject("v1").getString("custom_params"));
                deeplinkInfo.tm = System.currentTimeMillis();
                return true;
            }
            return false;
        } catch (JSONException e2) {
            LogUtil.e(TAG, "Clipboard 解析异常 ", e2);
            return false;
        }
    }

    String parseTrackerId(@NonNull String str) {
        String str2 = Constants.HTTPS_PROTOCOL_PREFIX;
        if (!str.startsWith(Constants.HTTPS_PROTOCOL_PREFIX)) {
            str2 = Constants.HTTP_PROTOCOL_PREFIX;
        }
        return str.substring(str.indexOf("/", str2.length()) + 1);
    }

    @VisibleForTesting
    public DeeplinkManager() {
    }
}
