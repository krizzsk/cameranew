package us.pinguo.advsdk.statistic.a;

import android.os.Bundle;
import android.text.TextUtils;
import com.tapjoy.TapjoyConstants;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.advsdk.statistic.StatisticNetWorkHelper;
import us.pinguo.advsdk.utils.b;
/* compiled from: FirebaseStatistic.java */
/* loaded from: classes3.dex */
public class a {
    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("pg_content", str2);
            PgAdvManager.getInstance().r().f(str, bundle);
        } catch (Exception unused) {
        }
        b.b("xht", "key:" + str + "_value:" + str2);
    }

    public static void b(String str, boolean z, long j2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            long j3 = j2 / 1000;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_");
            sb.append(z ? TapjoyConstants.TJC_PLUGIN_NATIVE : "interstial");
            sb.append("_");
            String str2 = sb.toString() + j3;
            Bundle bundle = new Bundle();
            bundle.putString("pg_content", str2);
            PgAdvManager.getInstance().r().f("third_req_consume", bundle);
            b.b("xht", "key:third_req_consume_value:" + str2);
        } catch (Exception unused) {
        }
    }

    public static void c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String str4 = str + "_" + str3;
            if (!TextUtils.isEmpty(str2)) {
                str4 = str4 + "_" + str2;
            }
            Bundle bundle = new Bundle();
            bundle.putString("pg_content", "k");
            PgAdvManager.getInstance().r().f(str4, bundle);
            b.b("xht", "key:" + str4 + "_value:");
        } catch (Exception unused) {
        }
    }

    public static void d(String str, boolean z, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            String str3 = str + "_" + (z ? TapjoyConstants.TJC_PLUGIN_NATIVE : "interstial") + "_" + StatisticNetWorkHelper.getInstance().c() + str2;
            bundle.putString("pg_content", str3);
            PgAdvManager.getInstance().r().f("third_sdk_request_failed_info", bundle);
            b.b("xht", "key:third_sdk_request_failed_info_value:" + str3);
        } catch (Exception unused) {
        }
    }

    public static void e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            String str3 = str + ":" + str2;
            Bundle bundle = new Bundle();
            bundle.putString("pg_content", str3);
            PgAdvManager.getInstance().r().f("waterfall", bundle);
            b.b("xht", "key:waterfall_value:" + str3);
        } catch (Exception unused) {
        }
    }
}
