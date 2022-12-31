package com.growingio.android.sdk.api;

import android.os.Build;
import com.growingio.android.sdk.base.event.HttpCallBack;
import com.growingio.android.sdk.base.event.HttpEvent;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.DeviceUUIDFactory;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.deeplink.DeeplinkInfo;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.NetworkUtil;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.eventcenter.EventCenter;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class DynamicLinkTrackTask {
    private static DeeplinkInfo applinkInfo;

    private static DeeplinkInfo getApplinkInfo() {
        return applinkInfo;
    }

    public static void run() {
        String googleAdId;
        String oaid;
        try {
            CoreAppState coreAppState = CoreInitialize.coreAppState();
            DeviceUUIDFactory deviceUUIDFactory = CoreInitialize.deviceUUIDFactory();
            String str = NetworkConfig.getInstance().trackHost() + "/" + coreAppState.getProjectId() + "/android/devices?u=" + NetworkUtil.encode(deviceUUIDFactory.getDeviceId()) + "&dm=" + NetworkUtil.encode(Build.BRAND + " " + Build.MODEL) + "&osv=" + NetworkUtil.encode("Android " + Build.VERSION.RELEASE) + "&d=" + NetworkUtil.encode(coreAppState.getSPN()) + "&t=activate&tm=" + NetworkUtil.encode(String.valueOf(System.currentTimeMillis())) + "&imei=" + NetworkUtil.encode(deviceUUIDFactory.getIMEI()) + "&adrid=" + NetworkUtil.encode(deviceUUIDFactory.getAndroidId());
            if (deviceUUIDFactory.getGoogleAdId() != null) {
                str = str + "&gaid=" + NetworkUtil.encode(googleAdId);
            }
            if (deviceUUIDFactory.getOaid() != null) {
                str = str + "&oaid=" + NetworkUtil.encode(oaid);
            }
            if (getApplinkInfo() != null) {
                str = (((str + "&link_id=" + NetworkUtil.encode(applinkInfo.linkID)) + "&click_id=" + NetworkUtil.encode(applinkInfo.clickID)) + "&tm_click=" + NetworkUtil.encode(applinkInfo.clickTM)) + "&cl=defer";
            }
            LogUtil.d("T_SEND", "发送事件：" + str);
            final HttpEvent httpEvent = new HttpEvent();
            httpEvent.setUrl(str);
            httpEvent.setCallBack(new HttpCallBack() { // from class: com.growingio.android.sdk.api.DynamicLinkTrackTask.1
                @Override // com.growingio.android.sdk.base.event.HttpCallBack
                public void afterRequest(Integer num, byte[] bArr, long j2, Map<String, List<String>> map) {
                    if (num.intValue() == 200) {
                        LogUtil.d("T_SEND", "得到反馈");
                    } else {
                        ThreadUtils.postOnUiThreadDelayed(new Runnable() { // from class: com.growingio.android.sdk.api.DynamicLinkTrackTask.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                EventCenter.getInstance().post(HttpEvent.this);
                            }
                        }, 10000L);
                    }
                }
            });
            EventCenter.getInstance().post(httpEvent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setApplinkInfo(DeeplinkInfo deeplinkInfo) {
        applinkInfo = deeplinkInfo;
    }
}
