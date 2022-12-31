package com.growingio.android.sdk.message;

import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.DeviceUUIDFactory;
import com.growingio.android.sdk.message.MessageHandler;
import com.growingio.android.sdk.models.VisitEvent;
import com.tencent.stat.DeviceInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class RealTimeMessageHolder implements MessageHandler.MessageCallBack {
    public RealTimeMessageCallBack callBack;

    public RealTimeMessageHolder(RealTimeMessageCallBack realTimeMessageCallBack) {
        this.callBack = realTimeMessageCallBack;
    }

    @Override // com.growingio.android.sdk.message.MessageHandler.MessageCallBack
    public void handleMessage(int i2, Object... objArr) {
        String str;
        JSONObject jSONObject;
        if (i2 == 2097155) {
            DeviceUUIDFactory deviceUUIDFactory = CoreInitialize.deviceUUIDFactory();
            JSONObject jSONObject2 = null;
            try {
                str = (String) objArr[0];
                try {
                    jSONObject = new JSONObject((String) objArr[2]);
                    try {
                        jSONObject.put("u", AbstractGrowingIO.getInstance().getDeviceId());
                        if (str.equals(VisitEvent.TYPE_NAME)) {
                            try {
                                jSONObject.put(DeviceInfo.TAG_IMEI, deviceUUIDFactory.getIMEI());
                                jSONObject.put("iv", deviceUUIDFactory.getAndroidId());
                            } catch (Exception unused) {
                            }
                        }
                    } catch (JSONException unused2) {
                        jSONObject2 = jSONObject;
                        jSONObject = jSONObject2;
                        this.callBack.receivedMessage(str, jSONObject);
                    }
                } catch (JSONException unused3) {
                }
            } catch (JSONException unused4) {
                str = null;
            }
            this.callBack.receivedMessage(str, jSONObject);
        }
    }
}
