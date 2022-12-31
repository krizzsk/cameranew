package com.tapjoy.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class dm {
    private static WindowManager b;
    private static String[] c = {"x", "y", "width", "height"};
    static float a = Resources.getSystem().getDisplayMetrics().density;

    /* loaded from: classes3.dex */
    static class a {
        final float a;
        final float b;

        a(float f2, float f3) {
            this.a = f2;
            this.b = f3;
        }
    }

    public static JSONObject a(int i2, int i3, int i4, int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", i2 / a);
            jSONObject.put("y", i3 / a);
            jSONObject.put("width", i4 / a);
            jSONObject.put("height", i5 / a);
        } catch (JSONException e2) {
            dn.a("Error with creating viewStateObject", e2);
        }
        return jSONObject;
    }

    public static void a(Context context) {
        if (context != null) {
            a = context.getResources().getDisplayMetrics().density;
            b = (WindowManager) context.getSystemService("window");
        }
    }

    public static void a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e2) {
            dn.a("Error with setting ad session id", e2);
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e2) {
            dn.a("JSONException during JSONObject.put for name [" + str + "]", e2);
        }
    }

    public static void a(JSONObject jSONObject, List list) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
        } catch (JSONException e2) {
            dn.a("Error with setting friendly obstruction", e2);
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    public static void b(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e2) {
            dn.a("Error with setting not visible reason", e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(@androidx.annotation.NonNull org.json.JSONObject r10, @androidx.annotation.Nullable org.json.JSONObject r11) {
        /*
            r0 = 1
            if (r10 != 0) goto L6
            if (r11 != 0) goto L6
            return r0
        L6:
            r1 = 0
            if (r10 == 0) goto La0
            if (r11 != 0) goto Ld
            goto La0
        Ld:
            java.lang.String[] r2 = com.tapjoy.internal.dm.c
            int r3 = r2.length
            r4 = 0
        L11:
            if (r4 >= r3) goto L26
            r5 = r2[r4]
            double r6 = r10.optDouble(r5)
            double r8 = r11.optDouble(r5)
            int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r5 == 0) goto L23
            r2 = 0
            goto L27
        L23:
            int r4 = r4 + 1
            goto L11
        L26:
            r2 = 1
        L27:
            if (r2 == 0) goto La0
            java.lang.String r2 = "adSessionId"
            java.lang.String r3 = ""
            java.lang.String r4 = r10.optString(r2, r3)
            java.lang.String r2 = r11.optString(r2, r3)
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto La0
            java.lang.String r2 = "isFriendlyObstructionFor"
            org.json.JSONArray r4 = r10.optJSONArray(r2)
            org.json.JSONArray r2 = r11.optJSONArray(r2)
            if (r4 != 0) goto L49
            if (r2 == 0) goto L6a
        L49:
            boolean r5 = a(r4, r2)
            if (r5 != 0) goto L51
        L4f:
            r2 = 0
            goto L6b
        L51:
            r5 = 0
        L52:
            int r6 = r4.length()
            if (r5 >= r6) goto L6a
            java.lang.String r6 = r4.optString(r5, r3)
            java.lang.String r7 = r2.optString(r5, r3)
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L67
            goto L4f
        L67:
            int r5 = r5 + 1
            goto L52
        L6a:
            r2 = 1
        L6b:
            if (r2 == 0) goto La0
            java.lang.String r2 = "childViews"
            org.json.JSONArray r10 = r10.optJSONArray(r2)
            org.json.JSONArray r11 = r11.optJSONArray(r2)
            if (r10 != 0) goto L7b
            if (r11 == 0) goto L9c
        L7b:
            boolean r2 = a(r10, r11)
            if (r2 != 0) goto L83
        L81:
            r10 = 0
            goto L9d
        L83:
            r2 = 0
        L84:
            int r3 = r10.length()
            if (r2 >= r3) goto L9c
            org.json.JSONObject r3 = r10.optJSONObject(r2)
            org.json.JSONObject r4 = r11.optJSONObject(r2)
            boolean r3 = b(r3, r4)
            if (r3 != 0) goto L99
            goto L81
        L99:
            int r2 = r2 + 1
            goto L84
        L9c:
            r10 = 1
        L9d:
            if (r10 == 0) goto La0
            return r0
        La0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.dm.b(org.json.JSONObject, org.json.JSONObject):boolean");
    }

    public static void a(JSONObject jSONObject) {
        float f2;
        float f3 = 0.0f;
        if (Build.VERSION.SDK_INT >= 17) {
            if (b != null) {
                Point point = new Point(0, 0);
                b.getDefaultDisplay().getRealSize(point);
                float f4 = a;
                f3 = point.x / f4;
                f2 = point.y / f4;
            }
            f2 = 0.0f;
        } else {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                float f5 = 0.0f;
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        double optDouble = optJSONObject.optDouble("x");
                        double optDouble2 = optJSONObject.optDouble("y");
                        double optDouble3 = optJSONObject.optDouble("width");
                        double optDouble4 = optJSONObject.optDouble("height");
                        f3 = Math.max(f3, (float) (optDouble + optDouble3));
                        f5 = Math.max(f5, (float) (optDouble2 + optDouble4));
                    }
                }
                f2 = f5;
            }
            f2 = 0.0f;
        }
        a aVar = new a(f3, f2);
        try {
            jSONObject.put("width", aVar.a);
            jSONObject.put("height", aVar.b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
