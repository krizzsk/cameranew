package com.facebook;

import android.util.Log;
import com.facebook.internal.r;
import com.facebook.internal.x;
import com.google.android.material.timepicker.TimeModel;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes.dex */
public class GraphResponse {

    /* renamed from: d  reason: collision with root package name */
    private static final String f2259d = "GraphResponse";
    private final HttpURLConnection a;
    private final JSONObject b;
    private final FacebookRequestError c;

    /* loaded from: classes.dex */
    public enum PagingDirection {
        NEXT,
        PREVIOUS
    }

    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject) {
        this(graphRequest, httpURLConnection, str, jSONObject, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<GraphResponse> a(List<GraphRequest> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new GraphResponse(list.get(i2), httpURLConnection, new FacebookRequestError(httpURLConnection, facebookException)));
        }
        return arrayList;
    }

    private static GraphResponse b(GraphRequest graphRequest, HttpURLConnection httpURLConnection, Object obj, Object obj2) throws JSONException {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            FacebookRequestError a = FacebookRequestError.a(jSONObject, obj2, httpURLConnection);
            if (a != null) {
                Log.e(f2259d, a.toString());
                if (a.c() == 190 && x.P(graphRequest.q())) {
                    if (a.l() != 493) {
                        AccessToken.B(null);
                    } else if (!AccessToken.j().y()) {
                        AccessToken.g();
                    }
                }
                return new GraphResponse(graphRequest, httpURLConnection, a);
            }
            Object E = x.E(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
            if (E instanceof JSONObject) {
                return new GraphResponse(graphRequest, httpURLConnection, E.toString(), (JSONObject) E);
            }
            if (E instanceof JSONArray) {
                return new GraphResponse(graphRequest, httpURLConnection, E.toString(), (JSONArray) E);
            }
            obj = JSONObject.NULL;
        }
        if (obj == JSONObject.NULL) {
            return new GraphResponse(graphRequest, httpURLConnection, obj.toString(), (JSONObject) null);
        }
        throw new FacebookException("Got unexpected object type in response, class: " + obj.getClass().getSimpleName());
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<com.facebook.GraphResponse> c(java.net.HttpURLConnection r7, java.util.List<com.facebook.GraphRequest> r8, java.lang.Object r9) throws com.facebook.FacebookException, org.json.JSONException {
        /*
            int r0 = r8.size()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            r2 = 0
            r3 = 1
            if (r0 != r3) goto L51
            java.lang.Object r3 = r8.get(r2)
            com.facebook.GraphRequest r3 = (com.facebook.GraphRequest) r3
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.io.IOException -> L34 org.json.JSONException -> L43
            r4.<init>()     // Catch: java.io.IOException -> L34 org.json.JSONException -> L43
            java.lang.String r5 = "body"
            r4.put(r5, r9)     // Catch: java.io.IOException -> L34 org.json.JSONException -> L43
            if (r7 == 0) goto L24
            int r5 = r7.getResponseCode()     // Catch: java.io.IOException -> L34 org.json.JSONException -> L43
            goto L26
        L24:
            r5 = 200(0xc8, float:2.8E-43)
        L26:
            java.lang.String r6 = "code"
            r4.put(r6, r5)     // Catch: java.io.IOException -> L34 org.json.JSONException -> L43
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch: java.io.IOException -> L34 org.json.JSONException -> L43
            r5.<init>()     // Catch: java.io.IOException -> L34 org.json.JSONException -> L43
            r5.put(r4)     // Catch: java.io.IOException -> L34 org.json.JSONException -> L43
            goto L52
        L34:
            r4 = move-exception
            com.facebook.GraphResponse r5 = new com.facebook.GraphResponse
            com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
            r6.<init>(r7, r4)
            r5.<init>(r3, r7, r6)
            r1.add(r5)
            goto L51
        L43:
            r4 = move-exception
            com.facebook.GraphResponse r5 = new com.facebook.GraphResponse
            com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
            r6.<init>(r7, r4)
            r5.<init>(r3, r7, r6)
            r1.add(r5)
        L51:
            r5 = r9
        L52:
            boolean r3 = r5 instanceof org.json.JSONArray
            if (r3 == 0) goto L97
            org.json.JSONArray r5 = (org.json.JSONArray) r5
            int r3 = r5.length()
            if (r3 != r0) goto L97
        L5e:
            int r0 = r5.length()
            if (r2 >= r0) goto L96
            java.lang.Object r0 = r8.get(r2)
            com.facebook.GraphRequest r0 = (com.facebook.GraphRequest) r0
            java.lang.Object r3 = r5.get(r2)     // Catch: com.facebook.FacebookException -> L76 org.json.JSONException -> L85
            com.facebook.GraphResponse r3 = b(r0, r7, r3, r9)     // Catch: com.facebook.FacebookException -> L76 org.json.JSONException -> L85
            r1.add(r3)     // Catch: com.facebook.FacebookException -> L76 org.json.JSONException -> L85
            goto L93
        L76:
            r3 = move-exception
            com.facebook.GraphResponse r4 = new com.facebook.GraphResponse
            com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
            r6.<init>(r7, r3)
            r4.<init>(r0, r7, r6)
            r1.add(r4)
            goto L93
        L85:
            r3 = move-exception
            com.facebook.GraphResponse r4 = new com.facebook.GraphResponse
            com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
            r6.<init>(r7, r3)
            r4.<init>(r0, r7, r6)
            r1.add(r4)
        L93:
            int r2 = r2 + 1
            goto L5e
        L96:
            return r1
        L97:
            com.facebook.FacebookException r7 = new com.facebook.FacebookException
            java.lang.String r8 = "Unexpected number of results"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphResponse.c(java.net.HttpURLConnection, java.util.List, java.lang.Object):java.util.List");
    }

    static List<GraphResponse> d(InputStream inputStream, HttpURLConnection httpURLConnection, i iVar) throws FacebookException, JSONException, IOException {
        String i0 = x.i0(inputStream);
        r.h(LoggingBehavior.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(i0.length()), i0);
        return e(i0, httpURLConnection, iVar);
    }

    static List<GraphResponse> e(String str, HttpURLConnection httpURLConnection, i iVar) throws FacebookException, JSONException, IOException {
        List<GraphResponse> c = c(httpURLConnection, iVar, new JSONTokener(str).nextValue());
        r.h(LoggingBehavior.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", iVar.l(), Integer.valueOf(str.length()), c);
        return c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<GraphResponse> f(HttpURLConnection httpURLConnection, i iVar) {
        InputStream inputStream;
        try {
            try {
                if (f.y()) {
                    if (httpURLConnection.getResponseCode() >= 400) {
                        inputStream = httpURLConnection.getErrorStream();
                    } else {
                        inputStream = httpURLConnection.getInputStream();
                    }
                    List<GraphResponse> d2 = d(inputStream, httpURLConnection, iVar);
                    x.h(inputStream);
                    return d2;
                }
                Log.e(f2259d, "GraphRequest can't be used when Facebook SDK isn't fully initialized");
                throw new FacebookException("GraphRequest can't be used when Facebook SDK isn't fully initialized");
            } catch (FacebookException e2) {
                r.h(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", e2);
                List<GraphResponse> a = a(iVar, httpURLConnection, e2);
                x.h(null);
                return a;
            } catch (Exception e3) {
                r.h(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", e3);
                List<GraphResponse> a2 = a(iVar, httpURLConnection, new FacebookException(e3));
                x.h(null);
                return a2;
            }
        } catch (Throwable th) {
            x.h(null);
            throw th;
        }
    }

    public final FacebookRequestError g() {
        return this.c;
    }

    public final JSONObject h() {
        return this.b;
    }

    public String toString() {
        String str;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            HttpURLConnection httpURLConnection = this.a;
            objArr[0] = Integer.valueOf(httpURLConnection != null ? httpURLConnection.getResponseCode() : 200);
            str = String.format(locale, TimeModel.NUMBER_FORMAT, objArr);
        } catch (IOException unused) {
            str = "unknown";
        }
        return "{Response:  responseCode: " + str + ", graphObject: " + this.b + ", error: " + this.c + "}";
    }

    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONArray jSONArray) {
        this(graphRequest, httpURLConnection, str, null, jSONArray, null);
    }

    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(graphRequest, httpURLConnection, null, null, null, facebookRequestError);
    }

    GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        this.a = httpURLConnection;
        this.b = jSONObject;
        this.c = facebookRequestError;
    }
}
