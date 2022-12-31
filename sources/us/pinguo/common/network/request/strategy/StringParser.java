package us.pinguo.common.network.request.strategy;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
/* loaded from: classes4.dex */
public class StringParser implements IAcceptParser<String> {
    private static final String PROTOCOL_ACCEPT = "text/plain";

    @Override // us.pinguo.common.network.request.strategy.IAcceptParser
    public String getAcceptType() {
        return PROTOCOL_ACCEPT;
    }

    @Override // us.pinguo.common.network.request.strategy.IAcceptParser
    public Response<String> parseNetworkResponse(NetworkResponse networkResponse, Type type) {
        String str;
        try {
            str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
        } catch (UnsupportedEncodingException unused) {
            str = new String(networkResponse.data);
        }
        return Response.success(str, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }
}
