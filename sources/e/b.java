package e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.hianalytics.v2.HiAnalytics;
import com.huawei.hianalytics.v2.HiAnalyticsConf;
import java.io.File;
import java.util.LinkedHashMap;
import org.json.JSONObject;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advstrategy.PgAdvStrategyManager;
/* compiled from: HuaweiPreInstallAnalytics.java */
/* loaded from: classes3.dex */
public class b {
    public static String b = "huawei";
    public static String c = "other";

    /* renamed from: d  reason: collision with root package name */
    public static String f8628d = "HuaweiPreInstall";

    /* renamed from: e  reason: collision with root package name */
    private static b f8629e;
    private String a = null;

    private b(Context context) {
        if (TextUtils.isEmpty(null)) {
            a(context);
        }
    }

    private void a(Context context) {
        if (context == null) {
            return;
        }
        if (PgAdvStrategyManager.getInstance().getStrategyKeeper(context).getGlobleOpenKey(IADStatisticBase.UNIT_ID_GLOBAL, "discard_channel_huawei")) {
            this.a = c;
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("camera360_db_preinstall", 4);
        String string = sharedPreferences.getString("camera360_preinstall", null);
        this.a = string;
        if (TextUtils.isEmpty(string)) {
            if (g(context) && !e()) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("camera360_preinstall", b);
                edit.apply();
                this.a = b;
                return;
            }
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            edit2.putString("camera360_preinstall", c);
            edit2.apply();
            this.a = c;
        }
    }

    private boolean b(Context context, String str) {
        if (!TextUtils.isEmpty(str) && str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("product");
                String optString2 = jSONObject.optString("channel");
                String optString3 = jSONObject.optString("pkgName");
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3) || !b.equals(optString2) || !optString3.equals(context.getPackageName())) {
                    return false;
                }
                return "Camera360".equals(optString);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static b d(Context context) {
        if (f8629e == null) {
            f8629e = new b(context);
        }
        return f8629e;
    }

    private boolean e() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            StringBuilder sb = new StringBuilder();
            sb.append(externalStorageDirectory.getAbsolutePath());
            sb.append("/huaweichannel");
            return new File(sb.toString()).exists();
        }
        return false;
    }

    private boolean g(Context context) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return b(context, (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.huaweiMarket.Camera360.path"));
        } catch (Exception e2) {
            us.pinguo.advsdk.utils.b.a(e2.getMessage());
            return false;
        }
    }

    public String c() {
        return "ca-app-pub-1216196833098935~1611020253";
    }

    public boolean f() {
        return b.equals(this.a);
    }

    public void h(Context context) {
        HiAnalyticsConf.Builder builder = new HiAnalyticsConf.Builder(context);
        builder.setChannel(a.a()).setEnableAndroidID(false).setEnableImei(false);
        builder.create();
        HiAnalytics.onEvent(2, "1", new LinkedHashMap());
        HiAnalytics.onReport();
    }

    public void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("register_id", str);
        HiAnalytics.onEvent(2, "2", linkedHashMap);
        HiAnalytics.onReport();
    }
}
