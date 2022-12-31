package d.d.a.a.a.g;

import android.os.Build;
import com.growingio.android.sdk.collection.Constants;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    public static String a() {
        return Build.MANUFACTURER + "; " + Build.MODEL;
    }

    public static String b() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    public static String c() {
        return Constants.PLATFORM_ANDROID;
    }

    public static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        b.g(jSONObject, "deviceType", a());
        b.g(jSONObject, "osVersion", b());
        b.g(jSONObject, "os", c());
        return jSONObject;
    }
}
