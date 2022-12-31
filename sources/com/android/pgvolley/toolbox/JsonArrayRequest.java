package com.android.pgvolley.toolbox;

import com.android.pgvolley.NetworkResponse;
import com.android.pgvolley.ParseError;
import com.android.pgvolley.Response;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes.dex */
public class JsonArrayRequest extends JsonRequest<JSONArray> {
    public JsonArrayRequest(String str, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(0, str, null, listener, errorListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.pgvolley.toolbox.JsonRequest, com.android.pgvolley.Request
    public Response<JSONArray> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            return Response.success(new JSONArray(new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers, "utf-8"))), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e2) {
            return Response.error(new ParseError(e2));
        } catch (JSONException e3) {
            return Response.error(new ParseError(e3));
        }
    }

    public JsonArrayRequest(int i2, String str, JSONArray jSONArray, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(i2, str, jSONArray == null ? null : jSONArray.toString(), listener, errorListener);
    }
}
