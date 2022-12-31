package com.tencent.stat;

import android.content.Context;
import androidx.work.PeriodicWorkRequest;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import java.util.Iterator;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class StatConfig {
    private static String n;
    private static String o;

    /* renamed from: e  reason: collision with root package name */
    private static StatLogger f8230e = com.tencent.stat.common.k.b();
    static b a = new b(2);
    static b b = new b(1);

    /* renamed from: f  reason: collision with root package name */
    private static StatReportStrategy f8231f = StatReportStrategy.APP_LAUNCH;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f8232g = true;

    /* renamed from: h  reason: collision with root package name */
    private static int f8233h = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;

    /* renamed from: i  reason: collision with root package name */
    private static int f8234i = 1024;

    /* renamed from: j  reason: collision with root package name */
    private static int f8235j = 30;

    /* renamed from: k  reason: collision with root package name */
    private static int f8236k = 3;

    /* renamed from: l  reason: collision with root package name */
    private static int f8237l = 30;
    static String c = "__HIBERNATE__";
    private static String m = null;

    /* renamed from: d  reason: collision with root package name */
    static String f8229d = "";
    private static int p = 1440;
    private static int q = 1024;
    private static boolean r = true;
    private static long s = 0;
    private static long t = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    public static boolean isAutoExceptionCaught = true;
    private static String u = "http://pingma.qq.com:80/mstat/report";
    private static int v = 0;
    private static volatile int w = 0;
    private static int x = 20;
    private static int y = 0;
    private static boolean z = false;
    private static int A = 4096;
    private static boolean B = false;
    private static String C = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        return f8235j;
    }

    static String a(Context context) {
        return com.tencent.stat.common.k.d(com.tencent.stat.common.p.a(context, "_mta_ky_tag_", (String) null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2) {
        String string;
        try {
            string = b.b.getString(str);
        } catch (Throwable th) {
            f8230e.w(th);
        }
        return string != null ? string : str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(int i2) {
        synchronized (StatConfig.class) {
            w = i2;
        }
    }

    static void a(Context context, String str) {
        if (str != null) {
            com.tencent.stat.common.p.b(context, "_mta_ky_tag_", com.tencent.stat.common.k.c(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(b bVar) {
        int i2 = bVar.a;
        if (i2 == b.a) {
            b = bVar;
            b(bVar.b);
        } else if (i2 == a.a) {
            a = bVar;
        }
    }

    static void a(b bVar, JSONObject jSONObject) {
        boolean z2 = false;
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase("v")) {
                    int i2 = jSONObject.getInt(next);
                    if (bVar.f8273d != i2) {
                        z2 = true;
                    }
                    bVar.f8273d = i2;
                } else if (next.equalsIgnoreCase("c")) {
                    String string = jSONObject.getString("c");
                    if (string.length() > 0) {
                        bVar.b = new JSONObject(string);
                    }
                } else if (next.equalsIgnoreCase("m")) {
                    bVar.c = jSONObject.getString("m");
                }
            }
            if (z2) {
                n a2 = n.a(d.a());
                if (a2 != null) {
                    a2.a(bVar);
                }
                if (bVar.a == b.a) {
                    b(bVar.b);
                    c(bVar.b);
                }
            }
        } catch (JSONException e2) {
            f8230e.e((Exception) e2);
        } catch (Throwable th) {
            f8230e.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        b bVar;
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase(Integer.toString(b.a))) {
                    jSONObject2 = jSONObject.getJSONObject(next);
                    bVar = b;
                } else if (next.equalsIgnoreCase(Integer.toString(a.a))) {
                    jSONObject2 = jSONObject.getJSONObject(next);
                    bVar = a;
                } else if (!next.equalsIgnoreCase("rs")) {
                    return;
                } else {
                    StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt(next));
                    if (statReportStrategy != null) {
                        f8231f = statReportStrategy;
                        StatLogger statLogger = f8230e;
                        statLogger.d("Change to ReportStrategy:" + statReportStrategy.name());
                    }
                }
                a(bVar, jSONObject2);
            }
        } catch (JSONException e2) {
            f8230e.e((Exception) e2);
        }
    }

    static void a(boolean z2) {
        StatNativeCrashReport.setNativeCrashDebugEnable(z2);
    }

    static boolean a(int i2, int i3, int i4) {
        return i2 >= i3 && i2 <= i4;
    }

    private static boolean a(String str) {
        if (str == null) {
            return false;
        }
        String str2 = n;
        if (str2 == null) {
            n = str;
            return true;
        } else if (str2.contains(str)) {
            return false;
        } else {
            n += Effect.DIVIDER + str;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HttpHost b() {
        String str = m;
        if (str == null || str.length() <= 0) {
            return null;
        }
        String str2 = m;
        String[] split = str2.split(":");
        int i2 = 80;
        if (split.length == 2) {
            str2 = split[0];
            i2 = Integer.parseInt(split[1]);
        }
        return new HttpHost(str2, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(int i2) {
        if (i2 < 0) {
            return;
        }
        y = i2;
    }

    static void b(JSONObject jSONObject) {
        try {
            StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt("rs"));
            if (statReportStrategy != null) {
                setStatSendStrategy(statReportStrategy);
            }
        } catch (JSONException unused) {
            f8230e.d("rs not found.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c() {
        synchronized (StatConfig.class) {
            w++;
        }
    }

    static void c(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(c);
            StatLogger statLogger = f8230e;
            statLogger.d("hibernateVer:" + string + ", current version:" + StatConstants.VERSION);
            long b2 = com.tencent.stat.common.k.b(string);
            if (com.tencent.stat.common.k.b(StatConstants.VERSION) <= b2) {
                com.tencent.stat.common.p.b(d.a(), c, b2);
                setEnableStatService(false);
                StatLogger statLogger2 = f8230e;
                statLogger2.warn("MTA has disable for SDK version of " + string + " or lower.");
            }
        } catch (JSONException unused) {
            f8230e.d("__HIBERNATE__ not found.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d() {
        y++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e() {
        return y;
    }

    public static synchronized String getAppKey(Context context) {
        synchronized (StatConfig.class) {
            String str = n;
            if (str != null) {
                return str;
            }
            if (context != null && str == null) {
                n = com.tencent.stat.common.k.i(context);
            }
            String str2 = n;
            if (str2 == null || str2.trim().length() == 0) {
                f8230e.error("AppKey can not be null or empty, please read Developer's Guide first!");
            }
            return n;
        }
    }

    public static int getCurSessionStatReportCount() {
        return w;
    }

    public static String getCustomProperty(String str) {
        try {
            return a.b.getString(str);
        } catch (Throwable th) {
            f8230e.e(th);
            return null;
        }
    }

    public static String getCustomProperty(String str, String str2) {
        String string;
        try {
            string = a.b.getString(str);
        } catch (Throwable th) {
            f8230e.e(th);
        }
        return string != null ? string : str2;
    }

    public static String getCustomUserId(Context context) {
        if (context == null) {
            f8230e.error("Context for getCustomUid is null.");
            return null;
        }
        if (C == null) {
            C = com.tencent.stat.common.p.a(context, "MTA_CUSTOM_UID", "");
        }
        return C;
    }

    public static DeviceInfo getDeviceInfo(Context context) {
        return StatMid.getDeviceInfo(context);
    }

    public static synchronized String getInstallChannel(Context context) {
        synchronized (StatConfig.class) {
            String str = o;
            if (str != null) {
                return str;
            }
            String j2 = com.tencent.stat.common.k.j(context);
            o = j2;
            if (j2 == null || j2.trim().length() == 0) {
                f8230e.w("installChannel can not be null or empty, please read Developer's Guide first!");
            }
            return o;
        }
    }

    public static int getMaxBatchReportCount() {
        return f8237l;
    }

    public static int getMaxDaySessionNumbers() {
        return x;
    }

    public static int getMaxParallelTimmingEvents() {
        return q;
    }

    public static int getMaxReportEventLength() {
        return A;
    }

    public static int getMaxSendRetryCount() {
        return f8236k;
    }

    public static int getMaxSessionStatReportCount() {
        return v;
    }

    public static int getMaxStoreEventCount() {
        return f8234i;
    }

    public static String getMid(Context context) {
        return StatMid.getMid(context);
    }

    public static String getQQ() {
        return f8229d;
    }

    public static int getSendPeriodMinutes() {
        return p;
    }

    public static int getSessionTimoutMillis() {
        return f8233h;
    }

    public static String getStatReportUrl() {
        return u;
    }

    public static StatReportStrategy getStatSendStrategy() {
        return f8231f;
    }

    public static void initNativeCrashReport(Context context, String str) {
        if (isEnableStatService()) {
            if (context == null) {
                f8230e.error("The Context of StatConfig.initNativeCrashReport() can not be null!");
            } else {
                StatNativeCrashReport.initNativeCrash(context, str);
            }
        }
    }

    public static boolean isAutoExceptionCaught() {
        return isAutoExceptionCaught;
    }

    public static boolean isDebugEnable() {
        return com.tencent.stat.common.k.b().isDebugEnable();
    }

    public static boolean isEnableConcurrentProcess() {
        return B;
    }

    public static boolean isEnableSmartReporting() {
        return r;
    }

    public static boolean isEnableStatService() {
        return f8232g;
    }

    public static void setAppKey(Context context, String str) {
        StatLogger statLogger;
        String str2;
        if (context == null) {
            statLogger = f8230e;
            str2 = "ctx in StatConfig.setAppKey() is null";
        } else if (str != null && str.length() <= 256) {
            if (n == null) {
                n = a(context);
            }
            if (a(str) || a(com.tencent.stat.common.k.i(context))) {
                a(context, n);
                return;
            }
            return;
        } else {
            statLogger = f8230e;
            str2 = "appkey in StatConfig.setAppKey() is null or exceed 256 bytes";
        }
        statLogger.error(str2);
    }

    public static void setAppKey(String str) {
        StatLogger statLogger;
        String str2;
        if (str == null) {
            statLogger = f8230e;
            str2 = "appkey in StatConfig.setAppKey() is null";
        } else if (str.length() <= 256) {
            n = str;
            return;
        } else {
            statLogger = f8230e;
            str2 = "The length of appkey cann't exceed 256 bytes.";
        }
        statLogger.error(str2);
    }

    public static void setAutoExceptionCaught(boolean z2) {
        isAutoExceptionCaught = z2;
    }

    public static void setCustomUserId(Context context, String str) {
        if (context == null) {
            f8230e.error("Context for setCustomUid is null.");
            return;
        }
        com.tencent.stat.common.p.b(context, "MTA_CUSTOM_UID", str);
        C = str;
    }

    public static void setDebugEnable(boolean z2) {
        com.tencent.stat.common.k.b().setDebugEnable(z2);
        a(z2);
    }

    public static void setEnableConcurrentProcess(boolean z2) {
        B = z2;
    }

    public static void setEnableSmartReporting(boolean z2) {
        r = z2;
    }

    public static void setEnableStatService(boolean z2) {
        f8232g = z2;
        if (z2) {
            return;
        }
        f8230e.warn("!!!!!!MTA StatService has been disabled!!!!!!");
    }

    public static void setInstallChannel(String str) {
        if (str.length() > 128) {
            f8230e.error("the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            o = str;
        }
    }

    public static void setMaxBatchReportCount(int i2) {
        if (a(i2, 2, 1000)) {
            f8237l = i2;
        } else {
            f8230e.error("setMaxBatchReportCount can not exceed the range of [2,1000].");
        }
    }

    public static void setMaxDaySessionNumbers(int i2) {
        if (i2 <= 0) {
            f8230e.e("maxDaySessionNumbers must be greater than 0.");
        } else {
            x = i2;
        }
    }

    public static void setMaxParallelTimmingEvents(int i2) {
        if (a(i2, 1, 4096)) {
            q = i2;
        } else {
            f8230e.error("setMaxParallelTimmingEvents can not exceed the range of [1, 4096].");
        }
    }

    public static void setMaxReportEventLength(int i2) {
        if (i2 <= 0) {
            f8230e.error("maxReportEventLength on setMaxReportEventLength() must greater than 0.");
        } else {
            A = i2;
        }
    }

    public static void setMaxSendRetryCount(int i2) {
        if (a(i2, 1, 1000)) {
            f8236k = i2;
        } else {
            f8230e.error("setMaxSendRetryCount can not exceed the range of [1,1000].");
        }
    }

    public static void setMaxSessionStatReportCount(int i2) {
        if (i2 < 0) {
            f8230e.error("maxSessionStatReportCount cannot be less than 0.");
        } else {
            v = i2;
        }
    }

    public static void setMaxStoreEventCount(int i2) {
        if (a(i2, 0, 500000)) {
            f8234i = i2;
        } else {
            f8230e.error("setMaxStoreEventCount can not exceed the range of [0, 500000].");
        }
    }

    public static void setQQ(Context context, String str) {
        StatService.reportQQ(context, str);
    }

    public static void setSendPeriodMinutes(int i2) {
        if (a(i2, 1, 10080)) {
            p = i2;
        } else {
            f8230e.error("setSendPeriodMinutes can not exceed the range of [1, 7*24*60] minutes.");
        }
    }

    public static void setSessionTimoutMillis(int i2) {
        if (a(i2, 1000, 86400000)) {
            f8233h = i2;
        } else {
            f8230e.error("setSessionTimoutMillis can not exceed the range of [1000, 24 * 60 * 60 * 1000].");
        }
    }

    public static void setStatReportUrl(String str) {
        if (str == null || str.length() == 0) {
            f8230e.error("statReportUrl cannot be null or empty.");
        } else {
            u = str;
        }
    }

    public static void setStatSendStrategy(StatReportStrategy statReportStrategy) {
        f8231f = statReportStrategy;
        StatLogger statLogger = f8230e;
        statLogger.d("Change to statSendStrategy: " + statReportStrategy);
    }
}
