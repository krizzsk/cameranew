package com.android.volley.toolbox;

import androidx.annotation.Nullable;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class JsonObjectRequest extends JsonRequest<JSONObject> {
    public JsonObjectRequest(int i2, String str, @Nullable JSONObject jSONObject, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(i2, str, jSONObject == null ? null : jSONObject.toString(), listener, errorListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.toolbox.JsonRequest, com.android.volley.Request
    public Response<JSONObject> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            return Response.success(new JSONObject(new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers, "utf-8"))), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e2) {
            return Response.error(new ParseError(e2));
        } catch (JSONException e3) {
            return Response.error(new ParseError(e3));
        }
    }

    public JsonObjectRequest(String str, @Nullable JSONObject jSONObject, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        this(jSONObject == null ? 0 : 1, str, jSONObject, listener, errorListener);
    }
}
