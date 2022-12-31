package us.pinguo.repository2020.network;

import android.text.TextUtils;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.JsonSyntaxException;
import com.pinguo.lib.GsonUtilKt;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.s;
import kotlin.text.d;
import us.pinguo.common.network.HttpRequestBase;
/* compiled from: HttpRequest.kt */
/* loaded from: classes6.dex */
public abstract class c<T> extends HttpRequestBase<T> {
    private final HashMap<String, String> params;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i2, String url) {
        super(i2, url);
        s.h(url, "url");
        this.params = new HashMap<>();
    }

    protected final Type getEntityType() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Objects.requireNonNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        s.g(type, "(javaClass.genericSuperc…e).actualTypeArguments[0]");
        return type;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public Map<String, String> getParams() {
        return this.params;
    }

    public final HashMap<String, String> getParamsPublic() {
        return this.params;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.common.network.pgrequest.BaseRequest, com.android.volley.Request
    public Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        String str;
        s.h(networkResponse, "networkResponse");
        super.parseNetworkResponse(networkResponse);
        try {
            byte[] bArr = networkResponse.data;
            s.g(bArr, "networkResponse.data");
            Charset forName = Charset.forName(HttpHeaderParser.parseCharset(networkResponse.headers));
            s.g(forName, "forName(HttpHeaderParser…networkResponse.headers))");
            str = new String(bArr, forName);
        } catch (UnsupportedEncodingException unused) {
            byte[] bArr2 = networkResponse.data;
            s.g(bArr2, "networkResponse.data");
            str = new String(bArr2, d.a);
        }
        if (TextUtils.isEmpty(str)) {
            Response<T> error = Response.error(new VolleyError(new Exception("no-content")));
            s.g(error, "error<T>(VolleyError(Exception(\"no-content\")))");
            return error;
        }
        Type entityType = getEntityType();
        if (s.c(entityType, String.class)) {
            Response<T> success = Response.success(str, HttpHeaderParser.parseCacheHeaders(networkResponse));
            s.g(success, "success(parsed as T, Htt…Headers(networkResponse))");
            return success;
        }
        try {
            Response<T> success2 = Response.success(GsonUtilKt.getCachedGson().k(str, entityType), HttpHeaderParser.parseCacheHeaders(networkResponse));
            s.g(success2, "{\n            val t = ca…tworkResponse))\n        }");
            return success2;
        } catch (JsonSyntaxException e2) {
            Response<T> error2 = Response.error(new VolleyError(str, e2));
            s.g(error2, "{\n            Response.e…ror(parsed, e))\n        }");
            return error2;
        }
    }
}
