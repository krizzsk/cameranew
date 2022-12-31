package us.pinguo.common.network;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import java.io.UnsupportedEncodingException;
@Deprecated
/* loaded from: classes4.dex */
public abstract class HttpStringRequest extends HttpRequestBase<String> {
    public HttpStringRequest(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.common.network.pgrequest.BaseRequest, com.android.volley.Request
    public Response<String> parseNetworkResponse(NetworkResponse networkResponse) {
        String str;
        super.parseNetworkResponse(networkResponse);
        try {
            str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
        } catch (UnsupportedEncodingException unused) {
            str = new String(networkResponse.data);
        }
        return Response.success(str, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    public HttpStringRequest(int i2, String str) {
        super(i2, str);
    }
}
