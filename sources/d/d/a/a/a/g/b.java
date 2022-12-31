package d.d.a.a.a.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.ironsrc.walking.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private static WindowManager a;
    private static String[] b = {"x", "y", "width", "height"};
    static float c = Resources.getSystem().getDisplayMetrics().density;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        final float a;
        final float b;

        a(float f2, float f3) {
            this.a = f2;
            this.b = f3;
        }
    }

    static float a(int i2) {
        return i2 / c;
    }

    public static JSONObject b(int i2, int i3, int i4, int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", a(i2));
            jSONObject.put("y", a(i3));
            jSONObject.put("width", a(i4));
            jSONObject.put("height", a(i5));
        } catch (JSONException e2) {
            c.b("Error with creating viewStateObject", e2);
        }
        return jSONObject;
    }

    public static void c(Context context) {
        if (context != null) {
            c = context.getResources().getDisplayMetrics().density;
            a = (WindowManager) context.getSystemService("window");
        }
    }

    public static void d(JSONObject jSONObject) {
        a j2 = j(jSONObject);
        try {
            jSONObject.put("width", j2.a);
            jSONObject.put("height", j2.b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void e(JSONObject jSONObject, a.C0203a c0203a) {
        d.d.a.a.a.d.c a2 = c0203a.a();
        JSONArray jSONArray = new JSONArray();
        for (String str : c0203a.c()) {
            jSONArray.put(str);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", a2.b());
            jSONObject.put("friendlyObstructionPurpose", a2.c());
            jSONObject.put("friendlyObstructionReason", a2.d());
        } catch (JSONException e2) {
            c.b("Error with setting friendly obstruction", e2);
        }
    }

    public static void f(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e2) {
            c.b("Error with setting ad session id", e2);
        }
    }

    public static void g(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e2) {
            c.b("JSONException during JSONObject.put for name [" + str + "]", e2);
        }
    }

    public static void h(JSONObject jSONObject, JSONObject jSONObject2) {
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

    private static boolean i(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    private static a j(JSONObject jSONObject) {
        float f2;
        float f3 = 0.0f;
        if (Build.VERSION.SDK_INT >= 17) {
            if (a != null) {
                Point point = new Point(0, 0);
                a.getDefaultDisplay().getRealSize(point);
                f3 = a(point.x);
                f2 = a(point.y);
            }
            f2 = 0.0f;
        } else {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                float f4 = 0.0f;
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        double optDouble = optJSONObject.optDouble("x");
                        double optDouble2 = optJSONObject.optDouble("y");
                        double optDouble3 = optJSONObject.optDouble("width");
                        double optDouble4 = optJSONObject.optDouble("height");
                        f3 = Math.max(f3, (float) (optDouble + optDouble3));
                        f4 = Math.max(f4, (float) (optDouble2 + optDouble4));
                    }
                }
                f2 = f4;
            }
            f2 = 0.0f;
        }
        return new a(f3, f2);
    }

    public static void k(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e2) {
            c.b("Error with setting not visible reason", e2);
        }
    }

    public static boolean l(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        return jSONObject != null && jSONObject2 != null && m(jSONObject, jSONObject2) && n(jSONObject, jSONObject2) && o(jSONObject, jSONObject2) && p(jSONObject, jSONObject2);
    }

    private static boolean m(JSONObject jSONObject, JSONObject jSONObject2) {
        String[] strArr;
        for (String str : b) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean n(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    private static boolean o(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (i(optJSONArray, optJSONArray2)) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                if (!optJSONArray.optString(i2, "").equals(optJSONArray2.optString(i2, ""))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static boolean p(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (i(optJSONArray, optJSONArray2)) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                if (!l(optJSONArray.optJSONObject(i2), optJSONArray2.optJSONObject(i2))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
