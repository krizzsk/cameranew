package com.android.pgvolley.toolbox;

import android.util.Log;
import com.android.pgvolley.AuthFailureError;
import com.android.pgvolley.NetworkResponse;
import com.android.pgvolley.Request;
import com.android.pgvolley.Response;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class MultipartRequest extends Request<String> {
    Map<String, String> mHeaders;
    private final Response.Listener<String> mListener;
    MultipartEntity mMultiPartEntity;

    public MultipartRequest(String str, Response.Listener<String> listener) {
        this(str, listener, null);
    }

    public void addHeader(String str, String str2) {
        this.mHeaders.put(str, str2);
    }

    @Override // com.android.pgvolley.Request
    public byte[] getBody() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.mMultiPartEntity.writeTo(byteArrayOutputStream);
        } catch (IOException unused) {
            Log.e("", "IOException writing to ByteArrayOutputStream");
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.android.pgvolley.Request
    public String getBodyContentType() {
        return this.mMultiPartEntity.getContentType().getValue();
    }

    @Override // com.android.pgvolley.Request
    public Map<String, String> getHeaders() throws AuthFailureError {
        return this.mHeaders;
    }

    public MultipartEntity getMultiPartEntity() {
        return this.mMultiPartEntity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.pgvolley.Request
    public Response<String> parseNetworkResponse(NetworkResponse networkResponse) {
        String str;
        try {
            str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
        } catch (UnsupportedEncodingException unused) {
            str = new String(networkResponse.data);
        }
        return Response.success(str, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    public MultipartRequest(String str, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(1, str, errorListener);
        this.mMultiPartEntity = new MultipartEntity();
        this.mHeaders = new HashMap();
        this.mListener = listener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.pgvolley.Request
    public void deliverResponse(String str) {
        Response.Listener<String> listener = this.mListener;
        if (listener != null) {
            listener.onResponse(str);
        }
    }
}
