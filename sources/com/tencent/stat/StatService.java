package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import java.lang.Thread;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes3.dex */
public class StatService {
    private static Handler a;
    private static volatile Map<com.tencent.stat.a.c, Long> b = new ConcurrentHashMap();
    private static volatile long c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static volatile long f8241d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static volatile int f8242e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static volatile String f8243f = "";

    /* renamed from: g  reason: collision with root package name */
    private static volatile String f8244g = "";

    /* renamed from: h  reason: collision with root package name */
    private static Map<String, Long> f8245h = new ConcurrentHashMap();

    /* renamed from: i  reason: collision with root package name */
    private static StatLogger f8246i = com.tencent.stat.common.k.b();

    /* renamed from: j  reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f8247j = null;

    /* renamed from: k  reason: collision with root package name */
    private static volatile boolean f8248k = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = z && currentTimeMillis - c >= ((long) StatConfig.getSessionTimoutMillis());
        c = currentTimeMillis;
        if (f8241d == 0) {
            f8241d = com.tencent.stat.common.k.c();
        }
        if (currentTimeMillis >= f8241d) {
            f8241d = com.tencent.stat.common.k.c();
            if (n.a(context).b(context).getUserType() != 1) {
                n.a(context).b(context).b(1);
            }
            StatConfig.b(0);
            StatMid.a(context);
            z2 = true;
        }
        if (f8248k ? true : z2) {
            if (StatConfig.e() < StatConfig.getMaxDaySessionNumbers()) {
                com.tencent.stat.common.k.F(context);
                d(context);
            } else {
                f8246i.e("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
        }
        if (f8248k) {
            com.tencent.stat.common.f.b(context);
            testSpeed(context);
            e(context);
            f8248k = false;
        }
        return f8242e;
    }

    static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            int i2 = StatConfig.b.f8273d;
            if (i2 != 0) {
                jSONObject2.put("v", i2);
            }
            jSONObject.put(Integer.toString(StatConfig.b.a), jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            int i3 = StatConfig.a.f8273d;
            if (i3 != 0) {
                jSONObject3.put("v", i3);
            }
            jSONObject.put(Integer.toString(StatConfig.a.a), jSONObject3);
        } catch (JSONException e2) {
            f8246i.e((Exception) e2);
        }
        return jSONObject;
    }

    static synchronized void a(Context context) {
        synchronized (StatService.class) {
            if (context == null) {
                return;
            }
            if (a == null) {
                if (!b(context)) {
                    return;
                }
                if (!com.tencent.stat.common.f.a(context)) {
                    f8246i.e("ooh, Compatibility problem was found in this device!");
                    f8246i.e("If you are on debug mode, please delete apk and try again.");
                    StatConfig.setEnableStatService(false);
                    return;
                }
                HandlerThread handlerThread = new HandlerThread("StatService");
                handlerThread.start();
                a = new Handler(handlerThread.getLooper());
                n.a(context);
                d.b(context);
                d.e();
                StatConfig.getDeviceInfo(context);
                f8247j = Thread.getDefaultUncaughtExceptionHandler();
                if (StatConfig.isAutoExceptionCaught()) {
                    Thread.setDefaultUncaughtExceptionHandler(new g(context.getApplicationContext()));
                } else {
                    f8246i.warn("MTA SDK AutoExceptionCaught is disable");
                }
                if (StatConfig.getStatSendStrategy() == StatReportStrategy.APP_LAUNCH && com.tencent.stat.common.k.h(context)) {
                    n.a(context).a(-1);
                }
                f8246i.d("Init MTA StatService success.");
            }
        }
    }

    static void a(Context context, Throwable th) {
        try {
            if (StatConfig.isEnableStatService()) {
                if (context == null) {
                    f8246i.error("The Context of StatService.reportSdkSelfException() can not be null!");
                    return;
                }
                com.tencent.stat.a.d dVar = new com.tencent.stat.a.d(context, a(context, false), 99, th);
                if (c(context) != null) {
                    c(context).post(new k(dVar));
                }
            }
        } catch (Throwable th2) {
            StatLogger statLogger = f8246i;
            statLogger.e("reportSdkSelfException error: " + th2);
        }
    }

    static void a(Context context, Map<String, ?> map) {
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                f8246i.error("The Context of StatService.sendAdditionEvent() can not be null!");
                return;
            }
            try {
                com.tencent.stat.a.a aVar = new com.tencent.stat.a.a(context, a(context, false), map);
                if (c(context) != null) {
                    c(context).post(new k(aVar));
                }
            } catch (Throwable th) {
                f8246i.e(th);
                a(context, th);
            }
        }
    }

    static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    static boolean b(Context context) {
        if (com.tencent.stat.common.k.b(StatConstants.VERSION) <= com.tencent.stat.common.p.a(context, StatConfig.c, 0L)) {
            StatConfig.setEnableStatService(false);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Handler c(Context context) {
        if (a == null) {
            a(context);
        }
        return a;
    }

    public static void commitEvents(Context context, int i2) {
        StatLogger statLogger;
        String str;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = f8246i;
                str = "The Context of StatService.commitEvents() can not be null!";
            } else if (i2 >= -1 && i2 != 0) {
                try {
                    n.a(context).a(i2);
                    return;
                } catch (Throwable th) {
                    f8246i.e(th);
                    a(context, th);
                    return;
                }
            } else {
                statLogger = f8246i;
                str = "The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.";
            }
            statLogger.error(str);
        }
    }

    static void d(Context context) {
        if (c(context) != null) {
            f8246i.d("start new session.");
            f8242e = com.tencent.stat.common.k.a();
            StatConfig.a(0);
            StatConfig.d();
            c(context).post(new k(new com.tencent.stat.a.k(context, f8242e, a())));
        }
    }

    static void e(Context context) {
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                f8246i.error("The Context of StatService.reportNativeCrash() can not be null!");
                return;
            }
            try {
                if (c(context) != null) {
                    c(context).post(new i(context));
                }
            } catch (Throwable th) {
                f8246i.e(th);
                a(context, th);
            }
        }
    }

    public static void onPause(Context context) {
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                f8246i.error("The Context of StatService.onPause() can not be null!");
            } else {
                trackEndPage(context, com.tencent.stat.common.k.k(context));
            }
        }
    }

    public static void onResume(Context context) {
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                f8246i.error("The Context of StatService.onResume() can not be null!");
            } else {
                trackBeginPage(context, com.tencent.stat.common.k.k(context));
            }
        }
    }

    public static void reportAppMonitorStat(Context context, StatAppMonitor statAppMonitor) {
        StatLogger statLogger;
        String str;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = f8246i;
                str = "The Context of StatService.reportAppMonitorStat() can not be null!";
            } else if (statAppMonitor == null) {
                statLogger = f8246i;
                str = "The StatAppMonitor of StatService.reportAppMonitorStat() can not be null!";
            } else if (statAppMonitor.getInterfaceName() != null) {
                try {
                    com.tencent.stat.a.h hVar = new com.tencent.stat.a.h(context, a(context, false), statAppMonitor);
                    if (c(context) != null) {
                        c(context).post(new k(hVar));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    f8246i.e(th);
                    a(context, th);
                    return;
                }
            } else {
                statLogger = f8246i;
                str = "The interfaceName of StatAppMonitor on StatService.reportAppMonitorStat() can not be null!";
            }
            statLogger.error(str);
        }
    }

    public static void reportError(Context context, String str) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = f8246i;
                str2 = "The Context of StatService.reportError() can not be null!";
            } else if (!a(str)) {
                try {
                    com.tencent.stat.a.d dVar = new com.tencent.stat.a.d(context, a(context, false), str, 0, StatConfig.getMaxReportEventLength());
                    if (c(context) != null) {
                        c(context).post(new k(dVar));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    f8246i.e(th);
                    a(context, th);
                    return;
                }
            } else {
                statLogger = f8246i;
                str2 = "Error message in StatService.reportError() is empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void reportException(Context context, Throwable th) {
        StatLogger statLogger;
        String str;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = f8246i;
                str = "The Context of StatService.reportException() can not be null!";
            } else if (th != null) {
                com.tencent.stat.a.d dVar = new com.tencent.stat.a.d(context, a(context, false), 1, th);
                if (c(context) != null) {
                    c(context).post(new k(dVar));
                    return;
                }
                return;
            } else {
                statLogger = f8246i;
                str = "The Throwable error message of StatService.reportException() can not be null!";
            }
            statLogger.error(str);
        }
    }

    public static void reportGameUser(Context context, StatGameUser statGameUser) {
        StatLogger statLogger;
        String str;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = f8246i;
                str = "The Context of StatService.reportGameUser() can not be null!";
            } else if (statGameUser == null) {
                statLogger = f8246i;
                str = "The gameUser of StatService.reportGameUser() can not be null!";
            } else if (statGameUser.getAccount() != null && statGameUser.getAccount().length() != 0) {
                try {
                    com.tencent.stat.a.g gVar = new com.tencent.stat.a.g(context, a(context, false), statGameUser);
                    if (c(context) != null) {
                        c(context).post(new k(gVar));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    f8246i.e(th);
                    a(context, th);
                    return;
                }
            } else {
                statLogger = f8246i;
                str = "The account of gameUser on StatService.reportGameUser() can not be null or empty!";
            }
            statLogger.error(str);
        }
    }

    public static void reportQQ(Context context, String str) {
        if (str == null) {
            str = "";
        }
        if (StatConfig.f8229d.equals(str)) {
            return;
        }
        StatConfig.f8229d = new String(str);
        a(context, (Map<String, ?>) null);
    }

    public static void setEnvAttributes(Context context, Map<String, String> map) {
        if (map == null || map.size() > 512) {
            f8246i.error("The map in setEnvAttributes can't be null or its size can't exceed 512.");
            return;
        }
        try {
            com.tencent.stat.common.a.a(context, map);
        } catch (JSONException e2) {
            f8246i.e((Exception) e2);
        }
    }

    public static void startNewSession(Context context) {
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                f8246i.error("The Context of StatService.startNewSession() can not be null!");
                return;
            }
            try {
                stopSession();
                a(context, true);
            } catch (Throwable th) {
                f8246i.e(th);
                a(context, th);
            }
        }
    }

    public static boolean startStatService(Context context, String str, String str2) {
        if (!StatConfig.isEnableStatService()) {
            f8246i.error("MTA StatService is disable.");
            return false;
        }
        f8246i.d("MTA SDK version, current: " + StatConstants.VERSION + " ,required: " + str2);
        if (context == null || str2 == null) {
            f8246i.error("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
            StatConfig.setEnableStatService(false);
            throw new MtaSDkException("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
        } else if (com.tencent.stat.common.k.b(StatConstants.VERSION) >= com.tencent.stat.common.k.b(str2)) {
            try {
                String installChannel = StatConfig.getInstallChannel(context);
                if (installChannel == null || installChannel.length() == 0) {
                    StatConfig.setInstallChannel(PGTransHeader.CONNECTOR);
                }
                if (str != null) {
                    StatConfig.setAppKey(context, str);
                }
                c(context);
                a(context, false);
                return true;
            } catch (Throwable th) {
                f8246i.e(th);
                return false;
            }
        } else {
            String str3 = ("MTA SDK version conflicted, current: " + StatConstants.VERSION + ",required: " + str2) + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/";
            f8246i.error(str3);
            StatConfig.setEnableStatService(false);
            throw new MtaSDkException(str3);
        }
    }

    public static void stopSession() {
        c = 0L;
    }

    public static void testSpeed(Context context) {
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                f8246i.error("The Context of StatService.testSpeed() can not be null!");
                return;
            }
            try {
                if (c(context) != null) {
                    c(context).post(new j(context, null));
                }
            } catch (Throwable th) {
                f8246i.e(th);
                a(context, th);
            }
        }
    }

    public static void testSpeed(Context context, Map<String, Integer> map) {
        StatLogger statLogger;
        String str;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = f8246i;
                str = "The Context of StatService.testSpeed() can not be null!";
            } else if (map != null && map.size() != 0) {
                try {
                    if (c(context) != null) {
                        c(context).post(new j(context, map));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    f8246i.e(th);
                    a(context, th);
                    return;
                }
            } else {
                statLogger = f8246i;
                str = "The domainMap of StatService.testSpeed() can not be null or empty!";
            }
            statLogger.error(str);
        }
    }

    public static void trackBeginPage(Context context, String str) {
        if (StatConfig.isEnableStatService()) {
            if (context == null || str == null || str.length() == 0) {
                f8246i.error("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
                return;
            }
            try {
                synchronized (f8245h) {
                    if (f8245h.size() >= StatConfig.getMaxParallelTimmingEvents()) {
                        StatLogger statLogger = f8246i;
                        statLogger.error("The number of page events exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                        return;
                    }
                    f8243f = str;
                    if (!f8245h.containsKey(f8243f)) {
                        f8245h.put(f8243f, Long.valueOf(System.currentTimeMillis()));
                        a(context, true);
                        return;
                    }
                    StatLogger statLogger2 = f8246i;
                    statLogger2.e("Duplicate PageID : " + f8243f + ", onResume() repeated?");
                }
            } catch (Throwable th) {
                f8246i.e(th);
                a(context, th);
            }
        }
    }

    public static void trackCustomBeginEvent(Context context, String str, String... strArr) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = f8246i;
                str2 = "The Context of StatService.trackCustomBeginEvent() can not be null!";
            } else if (!a(str)) {
                try {
                    com.tencent.stat.a.c cVar = new com.tencent.stat.a.c(str, strArr, null);
                    if (b.containsKey(cVar)) {
                        StatLogger statLogger2 = f8246i;
                        statLogger2.error("Duplicate CustomEvent key: " + cVar.toString() + ", trackCustomBeginEvent() repeated?");
                        return;
                    } else if (b.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                        b.put(cVar, Long.valueOf(System.currentTimeMillis()));
                        return;
                    } else {
                        StatLogger statLogger3 = f8246i;
                        statLogger3.error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                        return;
                    }
                } catch (Throwable th) {
                    f8246i.e(th);
                    a(context, th);
                    return;
                }
            } else {
                statLogger = f8246i;
                str2 = "The event_id of StatService.trackCustomBeginEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomBeginKVEvent(Context context, String str, Properties properties) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = f8246i;
                str2 = "The Context of StatService.trackCustomBeginEvent() can not be null!";
            } else if (!a(str)) {
                try {
                    com.tencent.stat.a.c cVar = new com.tencent.stat.a.c(str, null, properties);
                    if (b.containsKey(cVar)) {
                        StatLogger statLogger2 = f8246i;
                        statLogger2.error("Duplicate CustomEvent key: " + cVar.toString() + ", trackCustomBeginKVEvent() repeated?");
                        return;
                    } else if (b.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                        b.put(cVar, Long.valueOf(System.currentTimeMillis()));
                        return;
                    } else {
                        StatLogger statLogger3 = f8246i;
                        statLogger3.error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                        return;
                    }
                } catch (Throwable th) {
                    f8246i.e(th);
                    a(context, th);
                    return;
                }
            } else {
                statLogger = f8246i;
                str2 = "The event_id of StatService.trackCustomBeginEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomEndEvent(Context context, String str, String... strArr) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = f8246i;
                str2 = "The Context of StatService.trackCustomEndEvent() can not be null!";
            } else if (!a(str)) {
                try {
                    com.tencent.stat.a.c cVar = new com.tencent.stat.a.c(str, strArr, null);
                    Long remove = b.remove(cVar);
                    if (remove == null) {
                        StatLogger statLogger2 = f8246i;
                        statLogger2.error("No start time found for custom event: " + cVar.toString() + ", lost trackCustomBeginEvent()?");
                        return;
                    }
                    com.tencent.stat.a.b bVar = new com.tencent.stat.a.b(context, a(context, false), str);
                    bVar.a(strArr);
                    Long valueOf = Long.valueOf((System.currentTimeMillis() - remove.longValue()) / 1000);
                    bVar.a(Long.valueOf(valueOf.longValue() == 0 ? 1L : valueOf.longValue()).longValue());
                    if (c(context) != null) {
                        c(context).post(new k(bVar));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    f8246i.e(th);
                    a(context, th);
                    return;
                }
            } else {
                statLogger = f8246i;
                str2 = "The event_id of StatService.trackCustomEndEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomEndKVEvent(Context context, String str, Properties properties) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = f8246i;
                str2 = "The Context of StatService.trackCustomEndEvent() can not be null!";
            } else if (!a(str)) {
                try {
                    com.tencent.stat.a.c cVar = new com.tencent.stat.a.c(str, null, properties);
                    Long remove = b.remove(cVar);
                    if (remove == null) {
                        StatLogger statLogger2 = f8246i;
                        statLogger2.error("No start time found for custom event: " + cVar.toString() + ", lost trackCustomBeginKVEvent()?");
                        return;
                    }
                    com.tencent.stat.a.b bVar = new com.tencent.stat.a.b(context, a(context, false), str);
                    bVar.a(properties);
                    Long valueOf = Long.valueOf((System.currentTimeMillis() - remove.longValue()) / 1000);
                    bVar.a(Long.valueOf(valueOf.longValue() == 0 ? 1L : valueOf.longValue()).longValue());
                    if (c(context) != null) {
                        c(context).post(new k(bVar));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    f8246i.e(th);
                    a(context, th);
                    return;
                }
            } else {
                statLogger = f8246i;
                str2 = "The event_id of StatService.trackCustomEndEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomEvent(Context context, String str, String... strArr) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = f8246i;
                str2 = "The Context of StatService.trackCustomEvent() can not be null!";
            } else if (!a(str)) {
                try {
                    com.tencent.stat.a.b bVar = new com.tencent.stat.a.b(context, a(context, false), str);
                    bVar.a(strArr);
                    if (c(context) != null) {
                        c(context).post(new k(bVar));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    f8246i.e(th);
                    a(context, th);
                    return;
                }
            } else {
                statLogger = f8246i;
                str2 = "The event_id of StatService.trackCustomEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomKVEvent(Context context, String str, Properties properties) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = f8246i;
                str2 = "The Context of StatService.trackCustomEvent() can not be null!";
            } else if (!a(str)) {
                try {
                    com.tencent.stat.a.b bVar = new com.tencent.stat.a.b(context, a(context, false), str);
                    bVar.a(properties);
                    if (c(context) != null) {
                        c(context).post(new k(bVar));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    f8246i.e(th);
                    a(context, th);
                    return;
                }
            } else {
                statLogger = f8246i;
                str2 = "The event_id of StatService.trackCustomEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void trackEndPage(Context context, String str) {
        Long remove;
        if (StatConfig.isEnableStatService()) {
            if (context == null || str == null || str.length() == 0) {
                f8246i.error("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
                return;
            }
            try {
                synchronized (f8245h) {
                    remove = f8245h.remove(str);
                }
                if (remove == null) {
                    StatLogger statLogger = f8246i;
                    statLogger.e("Starttime for PageID:" + str + " not found, lost onResume()?");
                    return;
                }
                Long valueOf = Long.valueOf((System.currentTimeMillis() - remove.longValue()) / 1000);
                if (valueOf.longValue() <= 0) {
                    valueOf = 1L;
                }
                Long l2 = valueOf;
                String str2 = f8244g;
                if (str2 != null && str2.equals(str)) {
                    str2 = PGTransHeader.CONNECTOR;
                }
                String str3 = str2;
                if (c(context) != null) {
                    com.tencent.stat.a.j jVar = new com.tencent.stat.a.j(context, str3, str, a(context, false), l2);
                    if (!str.equals(f8243f)) {
                        f8246i.warn("Invalid invocation since previous onResume on diff page.");
                    }
                    c(context).post(new k(jVar));
                }
                f8244g = str;
            } catch (Throwable th) {
                f8246i.e(th);
                a(context, th);
            }
        }
    }
}
