package us.pinguo.foundation.m;

import android.text.TextUtils;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.JsonSyntaxException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* compiled from: VolleyGsonRequest.java */
/* loaded from: classes4.dex */
public class g<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final String f11028e = g.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: protected */
    public g(int i2, String str) {
        super(i2, str);
    }

    protected Type getEntityType() {
        return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        String str;
        try {
            str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
        } catch (UnsupportedEncodingException unused) {
            str = new String(networkResponse.data);
        }
        String str2 = f11028e;
        us.pinguo.common.log.a.m(str2, "url is:" + getUrl(), new Object[0]);
        us.pinguo.common.log.a.m(str2, "json response:" + str, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            return Response.error(new VolleyError(new Exception("no-content")));
        }
        Type entityType = getEntityType();
        if (entityType.equals(String.class)) {
            return Response.success(str, HttpHeaderParser.parseCacheHeaders(networkResponse));
        }
        try {
            return Response.success(new com.google.gson.e().k(str, entityType), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (JsonSyntaxException e2) {
            return Response.error(new VolleyError(str, e2));
        }
    }
}
