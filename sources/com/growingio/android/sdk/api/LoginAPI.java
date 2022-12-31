package com.growingio.android.sdk.api;

import android.util.Log;
import com.growingio.android.sdk.base.event.HttpCallBack;
import com.growingio.android.sdk.base.event.HttpEvent;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.DeviceUUIDFactory;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.ipc.GrowingIOIPC;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.eventcenter.EventCenter;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
/* loaded from: classes2.dex */
public class LoginAPI implements HttpCallBack {
    static final String TAG = "GIO.LoginAPI";
    private HttpCallBack httpCallBack;
    private final Object mTokenLocker = new Object();
    private GrowingIOIPC growingIOIPC = CoreInitialize.growingIOIPC();

    @Override // com.growingio.android.sdk.base.event.HttpCallBack
    public void afterRequest(Integer num, byte[] bArr, long j2, Map<String, List<String>> map) {
        if (num.intValue() == 200 && bArr.length > 0) {
            synchronized (this.mTokenLocker) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    String string = jSONObject.getString("accessToken");
                    String string2 = jSONObject.getString(GuestProfileFragment.USER_ID);
                    GrowingIOIPC growingIOIPC = this.growingIOIPC;
                    if (growingIOIPC != null) {
                        growingIOIPC.setToken(string);
                        this.growingIOIPC.setGioUserId(string2);
                    }
                    Log.i(TAG, "get access token by login token success");
                } catch (JSONException unused) {
                    LogUtil.d(TAG, "parse the loginToken error");
                }
            }
        }
        this.httpCallBack.afterRequest(num, bArr, j2, map);
    }

    public void login(String str) {
        LogUtil.d(TAG, "login with loginToken: ", str);
        JSONObject jSONObject = new JSONObject();
        DeviceUUIDFactory deviceUUIDFactory = CoreInitialize.deviceUUIDFactory();
        try {
            jSONObject.put("grantType", "login_token");
            jSONObject.put("deviceId", deviceUUIDFactory.getDeviceId());
            jSONObject.put("loginToken", str);
        } catch (JSONException unused) {
            Log.d(TAG, "gen login json error");
        }
        HttpEvent createCircleHttpEvent = HttpEvent.createCircleHttpEvent(NetworkConfig.getInstance().getEndPoint() + Constants.ENDPOINT_TAIL, jSONObject, false);
        createCircleHttpEvent.setCallBack(this);
        EventCenter.getInstance().post(createCircleHttpEvent);
    }

    @Deprecated
    public void logout() {
        GrowingIOIPC growingIOIPC = this.growingIOIPC;
        if (growingIOIPC != null) {
            growingIOIPC.setToken(null);
            this.growingIOIPC.setUserId(null);
        }
    }

    public void setHttpCallBack(HttpCallBack httpCallBack) {
        this.httpCallBack = httpCallBack;
    }
}
