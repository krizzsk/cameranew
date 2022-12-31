package com.growingio.android.sdk.base.event;

import com.android.billingclient.api.BillingFlowParams;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.ipc.GrowingIOIPC;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes2.dex */
public class HttpEvent {
    private HttpCallBack callBack;
    private byte[] data;
    private Map<String, String> headers;
    private long mSinceModified = 0;
    private REQUEST_METHOD requestMethod;
    private String url;

    /* loaded from: classes2.dex */
    public enum REQUEST_METHOD {
        GET,
        POST
    }

    public static HttpEvent createCircleHttpEvent(String str, JSONObject jSONObject, boolean z) {
        HttpEvent httpEvent = new HttpEvent();
        httpEvent.setUrl(str);
        if (jSONObject != null) {
            httpEvent.setData(jSONObject.toString().getBytes());
        }
        HashMap hashMap = new HashMap();
        hashMap.put(HttpRequest.HEADER_CONTENT_TYPE, HttpRequest.CONTENT_TYPE_JSON);
        hashMap.put(HttpRequest.HEADER_ACCEPT, HttpRequest.CONTENT_TYPE_JSON);
        GrowingIOIPC growingIOIPC = CoreInitialize.growingIOIPC();
        if (growingIOIPC != null) {
            hashMap.put("token", growingIOIPC.getToken());
        }
        hashMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, CoreInitialize.coreAppState().getProjectId());
        httpEvent.setHeaders(hashMap);
        if (z) {
            httpEvent.setRequestMethod(REQUEST_METHOD.GET);
        } else {
            httpEvent.setRequestMethod(REQUEST_METHOD.POST);
        }
        return httpEvent;
    }

    public HttpCallBack getCallBack() {
        return this.callBack;
    }

    public byte[] getData() {
        return this.data;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public REQUEST_METHOD getRequestMethod() {
        return this.requestMethod;
    }

    public String getUrl() {
        return this.url;
    }

    public long getmSinceModified() {
        return this.mSinceModified;
    }

    public void setCallBack(HttpCallBack httpCallBack) {
        this.callBack = httpCallBack;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public void setRequestMethod(REQUEST_METHOD request_method) {
        this.requestMethod = request_method;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setmSinceModified(long j2) {
        this.mSinceModified = j2;
    }
}
