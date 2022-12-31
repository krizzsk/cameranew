package us.pinguo.advsdk.statistic.b;

import android.text.TextUtils;
import org.json.JSONObject;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.advsdk.statistic.StatisticNetWorkHelper;
/* compiled from: GrowingIOStatistic.java */
/* loaded from: classes3.dex */
public class a {
    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && PgAdvManager.getInstance().r().d()) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (TextUtils.isEmpty(str2)) {
                    str2 = "v";
                }
                jSONObject.put("k", str2);
                PgAdvManager.getInstance().r().h(str, jSONObject);
            } catch (Exception unused) {
            }
        }
    }

    public static void b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && PgAdvManager.getInstance().r().d()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("k", StatisticNetWorkHelper.getInstance().c() + str2);
                PgAdvManager.getInstance().r().h(str, jSONObject);
            } catch (Exception unused) {
            }
        }
    }
}
