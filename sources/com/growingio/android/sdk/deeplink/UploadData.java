package com.growingio.android.sdk.deeplink;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.growingio.android.sdk.base.event.HttpCallBack;
import com.growingio.android.sdk.base.event.HttpEvent;
import com.growingio.android.sdk.base.event.SocketEvent;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.DeviceUUIDFactory;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.models.ad.ReengageEvent;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.NetworkUtil;
import com.growingio.eventcenter.EventCenter;
import com.tapjoy.TapjoyConstants;
import com.tencent.stat.DeviceInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class UploadData {
    private static final String TAG = "GIO.deeplink.upload";
    private byte[] mData;
    private Map<String, String> mHeaders;
    private String mRequestMethod;
    private String mUrl;
    private JSONObject reengageEvent;
    private int retry = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.growingio.android.sdk.deeplink.UploadData$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$growingio$android$sdk$deeplink$UploadData$UploadType;

        static {
            int[] iArr = new int[UploadType.values().length];
            $SwitchMap$com$growingio$android$sdk$deeplink$UploadData$UploadType = iArr;
            try {
                iArr[UploadType.REENGAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private DeeplinkInfo deeplinkInfo;
        private UploadType type;

        private UploadData buildReengage() {
            return new UploadData(getReengageEvent(), null);
        }

        private JSONObject getReengageEvent() {
            JSONObject jSONObject = new JSONObject();
            CoreAppState coreAppState = CoreInitialize.coreAppState();
            DeviceUUIDFactory deviceUUIDFactory = CoreInitialize.deviceUUIDFactory();
            GConfig config = CoreInitialize.config();
            try {
                jSONObject.put("t", ReengageEvent.TYPE_NAME);
                jSONObject.put("u", AbstractGrowingIO.getInstance().getDeviceId());
                jSONObject.put("d", coreAppState.getSPN());
                String str = Build.MODEL;
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                jSONObject.put("dm", str);
                String str3 = Build.VERSION.RELEASE;
                if (str3 == null) {
                    str3 = "";
                }
                jSONObject.put("osv", str3);
                jSONObject.put(DeviceInfo.TAG_IMEI, deviceUUIDFactory.getIMEI());
                jSONObject.put("iv", deviceUUIDFactory.getAndroidId());
                jSONObject.put("link_id", this.deeplinkInfo.linkID);
                jSONObject.put("click_id", this.deeplinkInfo.clickID);
                jSONObject.put("tm_click", this.deeplinkInfo.clickTM);
                jSONObject.put("tm", this.deeplinkInfo.tm);
                if (config.getAppUserId() != null) {
                    str2 = config.getAppUserId();
                }
                jSONObject.put("cs1", str2);
                jSONObject.put("gaid", deviceUUIDFactory.getGoogleAdId());
                jSONObject.put("host", String.format(NetworkConfig.getInstance().getDeeplinkHost(), coreAppState.getProjectId(), TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE));
                jSONObject.put("method", "GET");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ua", deviceUUIDFactory.getUserAgent());
                jSONObject2.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, deviceUUIDFactory.getIp());
                jSONObject.put("header", jSONObject2);
                jSONObject.put("var", this.deeplinkInfo.customParams);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public UploadData build() {
            if (AnonymousClass2.$SwitchMap$com$growingio$android$sdk$deeplink$UploadData$UploadType[this.type.ordinal()] != 1) {
                return null;
            }
            return buildReengage();
        }

        public Builder setDeeplinkInfo(DeeplinkInfo deeplinkInfo) {
            this.deeplinkInfo = deeplinkInfo;
            return this;
        }

        public Builder setType(UploadType uploadType) {
            this.type = uploadType;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum UploadType {
        REENGAGE
    }

    public UploadData(JSONObject jSONObject, byte[] bArr) {
        this.reengageEvent = jSONObject;
        try {
            this.mRequestMethod = jSONObject.getString("method");
            Pair<String, Map<String, String>> urlAndHeaderFromJSON = getUrlAndHeaderFromJSON(jSONObject);
            if (urlAndHeaderFromJSON != null) {
                this.mUrl = urlAndHeaderFromJSON.first;
                this.mHeaders = urlAndHeaderFromJSON.second;
                this.mData = bArr;
            }
        } catch (JSONException e2) {
            LogUtil.e(TAG, e2.toString());
        }
    }

    static /* synthetic */ int access$210(UploadData uploadData) {
        int i2 = uploadData.retry;
        uploadData.retry = i2 - 1;
        return i2;
    }

    private Pair<String, Map<String, String>> getUrlAndHeaderFromJSON(JSONObject jSONObject) {
        try {
            HashMap hashMap = new HashMap();
            StringBuffer stringBuffer = new StringBuffer(jSONObject.getString("host"));
            stringBuffer.append("?");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                char c = 65535;
                int hashCode = next.hashCode();
                if (hashCode != -1221270899) {
                    if (hashCode != -1077554975) {
                        if (hashCode == 3208616 && next.equals("host")) {
                            c = 0;
                        }
                    } else if (next.equals("method")) {
                        c = 2;
                    }
                } else if (next.equals("header")) {
                    c = 1;
                }
                if (c != 0) {
                    if (c == 1) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("header");
                        Iterator<String> keys2 = jSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            hashMap.put(next2, jSONObject2.getString(next2));
                        }
                    } else if (c != 2) {
                        stringBuffer.append(next + "=");
                        stringBuffer.append(NetworkUtil.encode(jSONObject.getString(next)));
                        if (keys.hasNext()) {
                            stringBuffer.append("&");
                        }
                    }
                }
            }
            String stringBuffer2 = stringBuffer.toString();
            if (hashMap.isEmpty() || TextUtils.isEmpty(stringBuffer2)) {
                return null;
            }
            return new Pair<>(stringBuffer2, hashMap);
        } catch (JSONException e2) {
            LogUtil.e(TAG, e2.toString());
            return null;
        }
    }

    public byte[] getData() {
        return this.mData;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public String getRequestMethod() {
        return this.mRequestMethod;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void upload() {
        if (CoreInitialize.config().isEnabled()) {
            final HttpEvent httpEvent = new HttpEvent();
            httpEvent.setUrl(this.mUrl);
            if ("GET".equals(this.mRequestMethod.toUpperCase())) {
                httpEvent.setRequestMethod(HttpEvent.REQUEST_METHOD.GET);
            } else {
                httpEvent.setRequestMethod(HttpEvent.REQUEST_METHOD.POST);
            }
            httpEvent.setHeaders(this.mHeaders);
            httpEvent.setData(this.mData);
            httpEvent.setCallBack(new HttpCallBack() { // from class: com.growingio.android.sdk.deeplink.UploadData.1
                @Override // com.growingio.android.sdk.base.event.HttpCallBack
                public void afterRequest(Integer num, byte[] bArr, long j2, Map<String, List<String>> map) {
                    if (num.intValue() == 200) {
                        if (UploadData.this.reengageEvent != null) {
                            EventCenter.getInstance().post(new SocketEvent(SocketEvent.EVENT_TYPE.SEND_DEBUGGER, UploadData.this.reengageEvent));
                        }
                        LogUtil.i(UploadData.TAG, "upload success! url " + UploadData.this.mUrl);
                    } else if (UploadData.access$210(UploadData.this) > 0) {
                        EventCenter.getInstance().post(httpEvent);
                    }
                }
            });
            EventCenter.getInstance().post(httpEvent);
        }
    }
}
