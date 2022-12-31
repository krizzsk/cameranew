package com.android.pgvolley.toolbox;

import com.android.pgvolley.NetworkResponse;
import com.android.pgvolley.Request;
import com.android.pgvolley.Response;
import com.android.pgvolley.VolleyLog;
import java.io.UnsupportedEncodingException;
/* loaded from: classes.dex */
public abstract class JsonRequest<T> extends Request<T> {
    protected static final String PROTOCOL_CHARSET = "utf-8";
    private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", PROTOCOL_CHARSET);
    private final Response.Listener<T> mListener;
    private final String mRequestBody;

    @Deprecated
    public JsonRequest(String str, String str2, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        this(-1, str, str2, listener, errorListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.pgvolley.Request
    public void deliverResponse(T t) {
        this.mListener.onResponse(t);
    }

    @Override // com.android.pgvolley.Request
    public byte[] getBody() {
        try {
            String str = this.mRequestBody;
            if (str == null) {
                return null;
            }
            return str.getBytes(PROTOCOL_CHARSET);
        } catch (UnsupportedEncodingException unused) {
            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", this.mRequestBody, PROTOCOL_CHARSET);
            return null;
        }
    }

    @Override // com.android.pgvolley.Request
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    @Override // com.android.pgvolley.Request
    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }

    @Override // com.android.pgvolley.Request
    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.pgvolley.Request
    public abstract Response<T> parseNetworkResponse(NetworkResponse networkResponse);

    public JsonRequest(int i2, String str, String str2, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(i2, str, errorListener);
        this.mListener = listener;
        this.mRequestBody = str2;
    }
}
