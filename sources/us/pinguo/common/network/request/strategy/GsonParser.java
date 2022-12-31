package us.pinguo.common.network.request.strategy;

import android.text.TextUtils;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.e;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import us.pinguo.common.log.a;
/* loaded from: classes4.dex */
public class GsonParser<T> implements IAcceptParser<T> {
    private static final String PROTOCOL_ACCEPT = "application/json";

    @Override // us.pinguo.common.network.request.strategy.IAcceptParser
    public String getAcceptType() {
        return "application/json";
    }

    @Override // us.pinguo.common.network.request.strategy.IAcceptParser
    public Response<T> parseNetworkResponse(NetworkResponse networkResponse, Type type) {
        String str;
        try {
            str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
        } catch (UnsupportedEncodingException unused) {
            str = new String(networkResponse.data);
        }
        a.c("json response:" + str, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            return Response.error(new VolleyError(new Exception("no-content")));
        }
        try {
            return Response.success(new e().k(str, type), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (JsonSyntaxException e2) {
            return Response.error(new VolleyError(e2));
        }
    }
}
