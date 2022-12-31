package us.pinguo.admobvista.StaticsAdv;

import android.content.Context;
import com.adjust.sdk.AdjustConfig;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import org.json.JSONObject;
import us.pinguo.admobvista.f.a;
import us.pinguo.admobvista.f.c;
import us.pinguo.advsdk.manager.PgAdvManager;
/* loaded from: classes3.dex */
public class DauStatistics {
    private static final String DAU_BACKGROUND_TIMESTAMP = "DAU_BACKGROUND_TIMESTAMP";
    private static final String DAU_FOREGROUND_TIMESTAMP = "DAU_FOREGROUND_TIMESTAMP";

    private static void dauStatistics(Context context, int i2) {
        PgAdvManager.getInstance().r().i(context, i2, new String[]{"facebook", AdjustConfig.AD_REVENUE_ADMOB, "infomobi", "mobvista", "altamob", "mobpower", "baidu"});
        duaStatisticsGIO(i2);
    }

    public static void dauStatisticsBackground(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (c.a(((Long) a.a(applicationContext, DAU_BACKGROUND_TIMESTAMP, 0L)).longValue())) {
            dauStatistics(applicationContext, 1);
            a.b(applicationContext, DAU_BACKGROUND_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static void dauStatisticsForeground(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (c.a(((Long) a.a(applicationContext, DAU_FOREGROUND_TIMESTAMP, 0L)).longValue())) {
            dauStatistics(applicationContext, 0);
            a.b(applicationContext, DAU_FOREGROUND_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        }
    }

    private static void duaStatisticsGIO(int i2) {
        if (i2 == 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "foreground_startup");
                AbstractGrowingIO.getInstance().track("startup", jSONObject);
            } catch (Exception unused) {
            }
        }
    }
}
