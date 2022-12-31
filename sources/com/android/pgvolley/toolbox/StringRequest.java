package com.android.pgvolley.toolbox;

import com.android.pgvolley.AuthFailureError;
import com.android.pgvolley.NetworkResponse;
import com.android.pgvolley.Request;
import com.android.pgvolley.Response;
import java.io.UnsupportedEncodingException;
import java.util.Map;
/* loaded from: classes.dex */
public class StringRequest extends Request<String> {
    private final Response.Listener<String> mListener;
    private Map<String, String> mPostMaps;

    public StringRequest(int i2, String str, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(i2, str, errorListener);
        this.mListener = listener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.pgvolley.Request
    public Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> map = this.mPostMaps;
        return map != null ? map : super.getParams();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.pgvolley.Request
    public void deliverResponse(String str) {
        this.mListener.onResponse(str);
    }

    public StringRequest(int i2, String str, Map<String, String> map, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(i2, str, errorListener);
        this.mListener = listener;
        this.mPostMaps = map;
    }

    public StringRequest(String str, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        this(0, str, listener, errorListener);
    }
}
