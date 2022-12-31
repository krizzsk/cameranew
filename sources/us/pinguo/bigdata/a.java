package us.pinguo.bigdata;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import us.pinguo.bigdata.config.BDConfig;
import us.pinguo.bigdata.config.BDConfigManager;
import us.pinguo.bigdata.config.BDLocalConfig;
import us.pinguo.bigdata.config.BDServerConfig;
import us.pinguo.bigdata.config.Sampling;
import us.pinguo.bigdata.config.SamplingStrategy;
import us.pinguo.bigdata.config.Strategy;
import us.pinguo.bigdata.f.b;
/* compiled from: BDStatistics.java */
/* loaded from: classes3.dex */
public class a {
    public static Application a = null;
    private static boolean b = true;
    public static boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    private static String f9105d = "";

    /* renamed from: e  reason: collision with root package name */
    public static boolean f9106e = true;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f9107f = false;

    /* renamed from: g  reason: collision with root package name */
    private static long f9108g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BDStatistics.java */
    /* renamed from: us.pinguo.bigdata.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0359a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SamplingStrategy.values().length];
            a = iArr;
            try {
                iArr[SamplingStrategy.PROB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private static void a(String str) {
        if (b) {
            c();
            if (str == null) {
                return;
            }
            try {
                String str2 = System.currentTimeMillis() + " " + str;
                if (c) {
                    Log.e("C360_STAT", "offer msg:" + str2);
                }
                us.pinguo.bigdata.e.a.a().b(str2);
            } catch (Exception unused) {
            }
        }
    }

    private static String b(String str) {
        if (str.isEmpty()) {
            return "session_id=" + f9108g;
        }
        return str + ",session_id=" + f9108g;
    }

    private static void c() {
        if (a == null) {
            throw new IllegalStateException("BDStatistics must be init before using it.");
        }
    }

    public static void d() {
        us.pinguo.bigdata.e.a.a().b("UPLOAD");
    }

    public static String e() throws NullPointerException {
        c();
        return BDConfigManager.instance().getLocalConfig().getEid();
    }

    public static void f(Application application) {
        a = application;
        us.pinguo.bigdata.c.a.e(application);
    }

    public static void g(BDConfig bDConfig) {
        if (a == null) {
            return;
        }
        us.pinguo.bigdata.b.a.l().h(a);
        BDLocalConfig localConfig = BDConfigManager.instance().getLocalConfig();
        localConfig.setDebug(bDConfig.getDebug());
        localConfig.setUid(bDConfig.getUserid());
        localConfig.setCuid(bDConfig.getCuid());
        localConfig.setCid(bDConfig.getCid());
        localConfig.setClatitude(bDConfig.getLat());
        localConfig.setClongitude(bDConfig.getLongt());
        localConfig.setNewUserTime(bDConfig.getNewUserTime());
        localConfig.setChannel(bDConfig.getChannel());
        String userid = bDConfig.getUserid();
        f9105d = userid;
        if (TextUtils.isEmpty(userid)) {
            String e2 = e();
            f9105d = e2;
            if (e2 == null) {
                f9105d = "";
            }
        }
        BDConfigManager.instance().updateLocalConfig();
    }

    private static boolean h(String str) {
        BDConfigManager instance;
        BDServerConfig serverConfig;
        SamplingStrategy samplingStrategy;
        if (str == null || (instance = BDConfigManager.instance()) == null || (serverConfig = instance.getServerConfig()) == null) {
            return true;
        }
        List<Sampling> sam = serverConfig.getSam();
        if (sam != null && sam.size() != 0) {
            Iterator<Sampling> it = sam.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Sampling next = it.next();
                if (str.equals(next.getEvtId())) {
                    Strategy strategy = next.getStrategy();
                    if (strategy == null) {
                        return true;
                    }
                    try {
                        samplingStrategy = SamplingStrategy.valueOf(strategy.getName().toUpperCase());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        samplingStrategy = SamplingStrategy.NONE;
                    }
                    if (C0359a.a[samplingStrategy.ordinal()] != 1) {
                        return true;
                    }
                    int nextInt = new Random().nextInt(100);
                    float floatValue = strategy.getThreshold() != null ? strategy.getThreshold().floatValue() : 0.0f;
                    float f2 = nextInt / 100.0f;
                    r0 = f2 <= floatValue;
                    if (c) {
                        Log.i("C360_STAT", "eventId:" + str + "current strategy:" + f2 + " threshold:" + floatValue + " 是否上报:" + r0);
                    }
                }
            }
        }
        return r0;
    }

    public static boolean i() {
        return b;
    }

    public static void j(String str, String str2) {
        if (b && !TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            if (f9107f && f9108g != 0) {
                hashMap.put("item", b(str2));
            } else {
                hashMap.put("item", str2);
            }
            k(str, hashMap);
        }
    }

    public static void k(String str, HashMap<String, String> hashMap) {
        if (b && !TextUtils.isEmpty(str)) {
            try {
                a(b.b(f9105d, str, hashMap));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void l() {
        if (b) {
            c();
            us.pinguo.bigdata.b.a.l().r();
        }
    }

    public static void m(boolean z) {
        b = z;
        us.pinguo.bigdata.b.a.l().o(z);
    }

    public static void n() {
        long j2 = f9108g;
        if (0 == j2) {
            f9108g = System.currentTimeMillis();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - j2;
        if (j3 > 1000 || j3 < 0) {
            f9108g = currentTimeMillis;
        }
    }

    public static void o() {
        long j2 = f9108g;
        if (0 == j2 || !f9107f || j2 == 0) {
            return;
        }
        j("SessionSummary", us.pinguo.bigdata.f.a.a(a));
    }

    public static void onEvent(String str) {
        if (b) {
            HashMap hashMap = new HashMap();
            if (f9107f && f9108g != 0) {
                hashMap.put("item", b("").toLowerCase(Locale.ENGLISH));
            }
            onEvent(str, hashMap);
        }
    }

    public static void onEvent(String str, String str2) {
        if (b && !TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            if (f9107f && f9108g != 0) {
                hashMap.put("item", b(str2).toLowerCase(Locale.ENGLISH));
            } else {
                hashMap.put("item", str2.toLowerCase(Locale.ENGLISH));
            }
            onEvent(str, hashMap);
        }
    }

    public static void onEvent(String str, String str2, String str3) {
        if (!b || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (f9107f && f9108g != 0) {
            String b2 = b(str2);
            Locale locale = Locale.ENGLISH;
            hashMap.put("item", b2.toLowerCase(locale));
            hashMap.put("item1", b(str3).toLowerCase(locale));
        } else {
            Locale locale2 = Locale.ENGLISH;
            hashMap.put("item", str2.toLowerCase(locale2));
            hashMap.put("item1", str3.toLowerCase(locale2));
        }
        onEvent(str, hashMap);
    }

    public static void onEvent(String str, HashMap<String, String> hashMap) {
        if (b && !TextUtils.isEmpty(str) && h(str)) {
            try {
                a(b.a(f9105d, str, hashMap));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }
}
