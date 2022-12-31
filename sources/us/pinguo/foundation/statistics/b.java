package us.pinguo.foundation.statistics;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.tapjoy.TJAdUnitConstants;
import com.tencent.tauth.AuthActivity;
import org.json.JSONObject;
/* compiled from: GrowingIOStat.java */
/* loaded from: classes4.dex */
public class b {
    private static boolean a = true;

    public static void a(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FirebaseAnalytics.Param.SUCCESS, z ? "yes" : "no");
            AbstractGrowingIO.getInstance().track("push_cid_success", jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void b(String str, String str2, String str3, String str4, String str5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TJAdUnitConstants.PARAM_PUSH_ID, str);
            jSONObject.put("push_type", str2);
            jSONObject.put(AuthActivity.ACTION_KEY, str3);
            jSONObject.put("show_type", str4);
            jSONObject.put("is_active", str5);
            if (a) {
                AbstractGrowingIO.getInstance().track("push_action", jSONObject);
            }
        } catch (Exception unused) {
        }
    }

    public static void c(boolean z) {
        a = z;
    }

    public static void d(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("material_type", str);
            jSONObject.put("material_package_id", str2);
            jSONObject.put("button_type", str3);
            if (a) {
                AbstractGrowingIO.getInstance().track("store_material_download_click", jSONObject);
            }
            us.pinguo.common.log.a.m("GrowingIOStat", "store_material_download_click", new Object[0]);
        } catch (Exception unused) {
        }
    }
}
