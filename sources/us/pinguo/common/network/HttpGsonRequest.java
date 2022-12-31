package us.pinguo.common.network;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.e;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
@Deprecated
/* loaded from: classes4.dex */
public abstract class HttpGsonRequest<T> extends HttpRequestBase<T> {
    public HttpGsonRequest(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.common.network.pgrequest.BaseRequest, com.android.volley.Request
    public Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        String str;
        super.parseNetworkResponse(networkResponse);
        try {
            str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
        } catch (UnsupportedEncodingException unused) {
            str = new String(networkResponse.data);
        }
        try {
            return Response.success(new e().k(str, ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (JsonSyntaxException e2) {
            return Response.error(new VolleyError(e2));
        }
    }

    public HttpGsonRequest(int i2, String str) {
        super(i2, str);
    }
}
