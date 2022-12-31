package com.growingio.android.sdk.utils;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class JsonUtil {
    private JsonUtil() {
    }

    public static JSONObject copyJson(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (!z && ((opt instanceof JSONObject) || (opt instanceof JSONArray))) {
                    throw new IllegalArgumentException("containJSONObject is false, but jsonObject contain JSONObject and JSONArray");
                }
                jSONObject2.put(next, opt);
            }
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c A[Catch: JSONException -> 0x0038, TryCatch #0 {JSONException -> 0x0038, blocks: (B:9:0x0012, B:10:0x0016, B:12:0x001c, B:15:0x0029), top: B:24:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean equal(org.json.JSONObject r5, org.json.JSONObject r6) {
        /*
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L39
            if (r6 != 0) goto L7
            goto L39
        L7:
            int r2 = r5.length()
            int r3 = r6.length()
            if (r2 == r3) goto L12
            return r1
        L12:
            java.util.Iterator r2 = r5.keys()     // Catch: org.json.JSONException -> L38
        L16:
            boolean r3 = r2.hasNext()     // Catch: org.json.JSONException -> L38
            if (r3 == 0) goto L38
            java.lang.Object r3 = r2.next()     // Catch: org.json.JSONException -> L38
            java.lang.String r3 = (java.lang.String) r3     // Catch: org.json.JSONException -> L38
            boolean r4 = r6.has(r3)     // Catch: org.json.JSONException -> L38
            if (r4 != 0) goto L29
            return r1
        L29:
            java.lang.Object r4 = r5.get(r3)     // Catch: org.json.JSONException -> L38
            java.lang.Object r3 = r6.get(r3)     // Catch: org.json.JSONException -> L38
            boolean r3 = jsonEqual(r4, r3)     // Catch: org.json.JSONException -> L38
            if (r3 != 0) goto L16
            return r1
        L38:
            return r0
        L39:
            if (r5 != r6) goto L3c
            goto L3d
        L3c:
            r0 = 0
        L3d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.utils.JsonUtil.equal(org.json.JSONObject, org.json.JSONObject):boolean");
    }

    public static JSONObject fromString(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    private static boolean jsonEqual(Object obj, Object obj2) {
        if (ObjectUtils.equals(obj, obj2)) {
            return true;
        }
        if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
            return equal((JSONObject) obj, (JSONObject) obj2);
        }
        if ((obj instanceof JSONArray) && (obj2 instanceof JSONArray)) {
            return equal((JSONArray) obj, (JSONArray) obj2);
        }
        return false;
    }

    public static boolean equal(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null || jSONArray2 == null) {
            return jSONArray == jSONArray2;
        } else if (jSONArray.length() != jSONArray2.length()) {
            return false;
        } else {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    if (!jsonEqual(jSONArray.get(i2), jSONArray2.get(i2))) {
                        return false;
                    }
                } catch (JSONException unused) {
                }
            }
            return true;
        }
    }
}
