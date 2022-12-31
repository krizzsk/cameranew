package com.mob.commons;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.facebook.common.callercontext.ContextChain;
import com.growingio.android.sdk.models.PeopleEvent;
import com.mob.MobSDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.stat.DeviceInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.inspire.module.MissionDetail.TaskDetailPresenter;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
import us.pinguo.inspire.module.message.category.entity.InspireMsg;
/* compiled from: CommonConfig.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    private static HashMap<String, Object> f5873g;
    private static HashMap<String, Object> a = new HashMap<>();
    private static boolean b = false;
    private static volatile boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    private static int f5870d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static Object f5871e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static Object f5872f = new Object();

    /* renamed from: h  reason: collision with root package name */
    private static HashMap<String, Object> f5874h = null;

    /* renamed from: i  reason: collision with root package name */
    private static Object f5875i = new Object();

    /* renamed from: j  reason: collision with root package name */
    private static long f5876j = 0;

    /* compiled from: CommonConfig.java */
    /* loaded from: classes2.dex */
    public static abstract class a {
        public void a() {
        }
    }

    public static long A() {
        return ((Long) a("arpl", 0L)).longValue();
    }

    public static boolean B() {
        return ((Long) a("gm", 0L)).longValue() == 1;
    }

    public static long C() {
        return ((Long) a("aa", 0L)).longValue();
    }

    public static long D() {
        return ((Long) a("rs", 0L)).longValue();
    }

    public static boolean E() {
        return ((Integer) a("lno", 0)).intValue() > 0;
    }

    public static boolean F() {
        return 1 == ((Integer) a("to", 0)).intValue();
    }

    public static boolean G() {
        HashMap<String, Object> hashMap = f5873g;
        return 1 == ((Integer) ResHelper.forceCast(hashMap != null ? hashMap.get("to") : null, 0)).intValue();
    }

    public static boolean H() {
        return 1 == ((Integer) a(PeopleEvent.TYPE_NAME, 0)).intValue();
    }

    public static boolean I() {
        return ((Integer) a("cerr", 0)).intValue() == 1;
    }

    public static boolean J() {
        return ((Integer) a("serr", 0)).intValue() == 1;
    }

    public static long K() {
        return ((Long) a("strategyId", 0L)).longValue();
    }

    public static int L() {
        return ((Integer) a("apm", 0)).intValue();
    }

    public static long M() {
        return ((Long) a("apmhuh", 300L)).longValue();
    }

    public static long N() {
        return ((Long) a("apmauh", 300L)).longValue();
    }

    public static boolean O() {
        return 1 == ((Integer) a("oid", 0)).intValue();
    }

    public static void P() {
        b((HashMap<String, Object>) null);
    }

    public static void Q() {
        if (Z()) {
            new Thread() { // from class: com.mob.commons.b.3
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (b.Z() && b.b) {
                        try {
                            Thread.sleep(1000L);
                        } catch (Throwable unused) {
                        }
                    }
                    if (!b.Z() || b.b) {
                        return;
                    }
                    boolean unused2 = b.b = true;
                    boolean unused3 = b.c = false;
                    try {
                        if (!b.X()) {
                            b.Y();
                        }
                    } catch (Throwable th) {
                        MobLog.getInstance().d(th);
                    }
                    boolean unused4 = b.b = false;
                }
            }.start();
        }
    }

    private static long V() {
        long j2;
        try {
            j2 = Long.valueOf(String.valueOf(f5873g.get("deviceTime"))).longValue();
        } catch (Throwable unused) {
            j2 = 0;
        }
        if (j2 == 0) {
            return 0L;
        }
        return SystemClock.elapsedRealtime() - j2;
    }

    private static boolean W() {
        try {
            String a2 = h.a();
            HashMap fromJson = TextUtils.isEmpty(a2) ? null : new Hashon().fromJson(a2);
            if (fromJson != null && !fromJson.isEmpty()) {
                b(fromJson);
                a((HashMap<String, Object>) fromJson, false);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean X() {
        String aa = aa();
        HashMap fromJson = !TextUtils.isEmpty(aa) ? new Hashon().fromJson(aa) : null;
        if (fromJson != null && !fromJson.isEmpty()) {
            h.a(aa);
            a((HashMap<String, Object>) fromJson);
            b(fromJson);
            ae();
            a((HashMap<String, Object>) fromJson, true);
            return true;
        }
        h.a((String) null);
        b((HashMap<String, Object>) null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
        ae();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void Y() {
        /*
            r0 = 2
            r2 = 1
            r6 = r0
            r4 = r2
        L6:
            r8 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 * r4
            r10 = 0
            java.lang.Thread.sleep(r8)     // Catch: java.lang.Throwable -> Lf
            goto L17
        Lf:
            r8 = move-exception
            com.mob.tools.log.NLog r9 = com.mob.tools.MobLog.getInstance()     // Catch: java.lang.Throwable -> L47
            r9.d(r8)     // Catch: java.lang.Throwable -> L47
        L17:
            boolean r8 = ac()     // Catch: java.lang.Throwable -> L47
            if (r8 == 0) goto L28
            r11 = 0
            int r9 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r9 > 0) goto L27
            ae()     // Catch: java.lang.Throwable -> L47
            goto L4f
        L27:
            long r6 = r6 - r2
        L28:
            long r4 = r4 * r0
            r11 = 8
            if (r8 != 0) goto L33
            int r8 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r8 >= 0) goto L33
            r4 = r11
        L33:
            r8 = 300(0x12c, double:1.48E-321)
            int r13 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r13 <= 0) goto L3a
            r4 = r11
        L3a:
            boolean r8 = X()     // Catch: java.lang.Throwable -> L47
            if (r8 != 0) goto L4f
            boolean r8 = t()     // Catch: java.lang.Throwable -> L47
            if (r8 == 0) goto L6
            goto L4f
        L47:
            r0 = move-exception
            com.mob.tools.log.NLog r1 = com.mob.tools.MobLog.getInstance()     // Catch: java.lang.Throwable -> L53
            r1.d(r0)     // Catch: java.lang.Throwable -> L53
        L4f:
            a(r10)
            return
        L53:
            r0 = move-exception
            a(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.b.Y():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Z() {
        boolean z;
        synchronized (f5871e) {
            z = true;
            if (f5870d != 1) {
                z = false;
            }
        }
        return z;
    }

    public static void a(HashMap<String, Object> hashMap, boolean z) {
    }

    private static boolean a(long j2) {
        return false;
    }

    private static String aa() {
        try {
            if (!t() && ac()) {
                DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
                NetworkHelper networkHelper = new NetworkHelper();
                String packageName = deviceHelper.getPackageName();
                String appkey = MobSDK.getAppkey();
                a(TextUtils.isEmpty(appkey) ? 1 : 2);
                ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                arrayList.add(new KVPair<>("appkey", appkey));
                arrayList.add(new KVPair<>("plat", String.valueOf(deviceHelper.getPlatformCode())));
                arrayList.add(new KVPair<>("apppkg", packageName));
                arrayList.add(new KVPair<>("appver", deviceHelper.getAppVersionName()));
                arrayList.add(new KVPair<>("networktype", deviceHelper.getDetailNetworkTypeForStatic()));
                String authorizeForOnce = DeviceAuthorizer.authorizeForOnce();
                if (!TextUtils.isEmpty(authorizeForOnce)) {
                    arrayList.add(new KVPair<>("duid", authorizeForOnce));
                }
                arrayList.add(new KVPair<>("ags", String.valueOf(deviceHelper.isPackageInstalled(j.a(17)) ? 1 : -1)));
                long currentTimeMillis = System.currentTimeMillis();
                arrayList.add(new KVPair<>(DeviceInfo.TAG_TIMESTAMPS, String.valueOf(currentTimeMillis)));
                deviceHelper.getDefaultResolvePkg(j.a(18));
                List<String> resolvePkgs = deviceHelper.getResolvePkgs(j.a(18));
                StringBuilder sb = new StringBuilder();
                sb.append("com.android.vending");
                sb.append(Effect.DIVIDER);
                if (resolvePkgs != null && resolvePkgs.size() > 0) {
                    int size = resolvePkgs.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(resolvePkgs.get(i2));
                        if (i2 < size - 1) {
                            sb.append(",");
                        }
                    }
                } else {
                    sb.append("null");
                }
                arrayList.add(new KVPair<>("as", Base64.encodeToString(Data.AES128Encode(Data.rawMD5(appkey + ":" + packageName + ":" + currentTimeMillis), sb.toString()), 2)));
                Boolean e2 = com.mob.commons.a.e();
                if (e2 != null) {
                    arrayList.add(new KVPair<>("isAgreePp", String.valueOf(e2)));
                }
                Boolean f2 = com.mob.commons.a.f();
                if (f2 != null) {
                    arrayList.add(new KVPair<>("isAgreePd", String.valueOf(f2)));
                }
                arrayList.add(new KVPair<>("ppVersion", String.valueOf(com.mob.commons.a.g())));
                arrayList.add(new KVPair<>("v6", String.valueOf(MobSDK.checkV6() ? 1 : -1)));
                arrayList.add(new KVPair<>("uc", String.valueOf(deviceHelper.checkUA() ? 1 : 0)));
                arrayList.add(new KVPair<>("ud", String.valueOf(deviceHelper.usbEnable() ? 1 : 0)));
                arrayList.add(new KVPair<>("dv", String.valueOf(deviceHelper.devEnable() ? 1 : 0)));
                arrayList.add(new KVPair<>("vp", String.valueOf(deviceHelper.vpn() ? 1 : 0)));
                arrayList.add(new KVPair<>("wp", String.valueOf(deviceHelper.isWifiProxy() ? 1 : 0)));
                arrayList.add(new KVPair<>("rt", String.valueOf(deviceHelper.isRooted() ? 1 : 0)));
                arrayList.add(new KVPair<>("xp", String.valueOf(deviceHelper.cx() ? 1 : 0)));
                arrayList.add(new KVPair<>("ad", String.valueOf(deviceHelper.debugable() ? 1 : 0)));
                NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                networkTimeOut.readTimout = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
                networkTimeOut.connectionTimeout = 10000;
                ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
                arrayList2.add(new KVPair<>("User-Identity", MobProductCollector.getUserIdentity()));
                arrayList2.add(new KVPair<>(j.a(68), com.mob.commons.b.a.c(MobSDK.getContext())));
                String httpGet = networkHelper.httpGet(ad(), arrayList, arrayList2, networkTimeOut);
                Hashon hashon = new Hashon();
                HashMap fromJson = hashon.fromJson(httpGet);
                if (fromJson == null) {
                    return null;
                }
                if ("200".equals(String.valueOf(fromJson.get("status")))) {
                    String str = (String) ResHelper.forceCast(fromJson.get("sr"));
                    byte[] rawMD5 = Data.rawMD5((appkey + ":" + packageName + ":" + fromJson.get("timestamp")).getBytes("utf-8"));
                    String str2 = (String) ResHelper.forceCast(fromJson.get("sc"));
                    if (str2 != null) {
                        HashMap fromJson2 = hashon.fromJson(new String(Data.AES128Decode(rawMD5, Base64.decode(str2, 2)), "utf-8"));
                        if (fromJson2 != null) {
                            a(fromJson2.get("illegalMacs"));
                            long longValue = ((Long) ResHelper.forceCast(fromJson.get("timestamp"), 0L)).longValue();
                            fromJson2.put("deviceTime", Long.valueOf(SystemClock.elapsedRealtime()));
                            fromJson2.put("serverTime", Long.valueOf(longValue));
                            return hashon.fromHashMap(fromJson2);
                        }
                        throw new Throwable("response is illegal: " + httpGet);
                    }
                    throw new Throwable("response is illegal: " + httpGet);
                }
                throw new Throwable("response is illegal: " + httpGet);
            }
            return null;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            try {
                h.b((String) null);
                h.c((String) null);
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
            return null;
        }
    }

    private static void ab() {
        HashMap<String, Object> hashMap = new HashMap<>();
        f5873g = hashMap;
        hashMap.put("conn", 0);
        f5873g.put("in", 0);
        f5873g.put(PortalFollowFeeds.TYPE_ALL, 0);
        f5873g.put("aspa", 2592000L);
        f5873g.put("un", 0);
        f5873g.put("rt", 0);
        f5873g.put("rtsr", Integer.valueOf((int) BaseBlurEffect.ROTATION_180));
        f5873g.put("ext", 0);
        f5873g.put("bs", 0);
        HashMap<String, Object> hashMap2 = f5873g;
        Integer valueOf = Integer.valueOf((int) TaskDetailPresenter.TIME_SECOND);
        hashMap2.put("bsgap", valueOf);
        f5873g.put("di", 0);
        f5873g.put("l", 0);
        f5873g.put("lgap", valueOf);
        f5873g.put("wi", 0);
        f5873g.put("wigap", 3600L);
        f5873g.put("wl", 0);
        f5873g.put("wlsr", Integer.valueOf((int) IjkMediaCodecInfo.RANK_SECURE));
        f5873g.put("wlgap", 7200);
        f5873g.put("adle", 0);
        f5873g.put("rtgap", 3600);
        f5873g.put(ContextChain.TAG_PRODUCT, 0);
        f5873g.put("ol", 0);
        f5873g.put("olgapl", 3600L);
        f5873g.put("olgaph", 60L);
        f5873g.put("xmar", 0);
        f5873g.put("bi", 0);
        f5873g.put("bigap", 30L);
        f5873g.put("pl", 0);
        f5873g.put("plgap", 86400L);
        f5873g.put("le", 0L);
        f5873g.put("legap", 86400L);
        f5873g.put("sd", 0L);
        f5873g.put("deup", 2);
        f5873g.put("digap", 2592000L);
        f5873g.put("illegalMacs", null);
        f5873g.put("pe", 0L);
        f5873g.put("pegap", 86400L);
        f5873g.put("ac", 0L);
        f5873g.put("acgap", 86400L);
        f5873g.put(NotificationCompat.CATEGORY_SYSTEM, 0L);
        f5873g.put("sysgap", 2592000L);
        f5873g.put("arpl", 0L);
        f5873g.put("arplgap", 604800L);
        f5873g.put("mph", 0L);
        f5873g.put("aw", null);
        f5873g.put("to", 0);
        f5873g.put("gm", 0);
        f5873g.put("gmgap", 900);
        f5873g.put("aa", 0L);
        f5873g.put("aagap", 86400L);
        f5873g.put("rs", 0L);
        f5873g.put("rsgap", 86400L);
        f5873g.put("cl", null);
        f5873g.put(InspireMsg.TYPE_AT, 0L);
        f5873g.put("atgap", 900L);
        f5873g.put("bt", 0L);
        f5873g.put("bts", 0L);
        f5873g.put("btsgap", 7200L);
        f5873g.put(PeopleEvent.TYPE_NAME, 0L);
        f5873g.put("lno", 0);
        f5873g.put("dv", 0L);
        f5873g.put("dvch", 3600L);
        f5873g.put("dvuh", 3600L);
        f5873g.put("cerr", 1);
        f5873g.put("serr", 0);
        f5873g.put("strategyId", 0L);
        f5873g.put("apm", 0);
        f5873g.put("apmhuh", 300L);
        f5873g.put("apmauh", 300L);
        f5873g.put("oid", 0);
    }

    private static boolean ac() {
        try {
            String detailNetworkTypeForStatic = DeviceHelper.getInstance(MobSDK.getContext()).getDetailNetworkTypeForStatic();
            if (!"wifi".equals(detailNetworkTypeForStatic) && !"5g".equals(detailNetworkTypeForStatic) && !"4g".equals(detailNetworkTypeForStatic) && !"3g".equals(detailNetworkTypeForStatic)) {
                if (!"2g".equals(detailNetworkTypeForStatic)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String ad() {
        /*
            java.lang.String r0 = com.mob.commons.h.c()     // Catch: java.lang.Throwable -> Lb
            java.lang.String r0 = com.mob.commons.i.b(r0)     // Catch: java.lang.Throwable -> L9
            goto L14
        L9:
            r1 = move-exception
            goto Ld
        Lb:
            r1 = move-exception
            r0 = 0
        Ld:
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            r2.w(r1)
        L14:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L2f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.mob.commons.i.a()
            r0.append(r1)
            java.lang.String r1 = "/v5/gcf"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L2f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.b.ad():java.lang.String");
    }

    private static void ae() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("apm", Integer.valueOf(L()));
            hashMap.put("apmhuh", Long.valueOf(M()));
            hashMap.put("apmauh", Long.valueOf(N()));
            String fromHashMap = new Hashon().fromHashMap(hashMap);
            ReflectHelper.invokeStaticMethod(ReflectHelper.importClass("com.mob.mobapm.MobAPM"), "setJson", fromHashMap);
            NLog mobLog = MobLog.getInstance();
            mobLog.d(">>>>> Has APM <<<<< conf: " + fromHashMap, new Object[0]);
        } catch (Throwable unused) {
            MobLog.getInstance().d(">>>>> No APM <<<<<", new Object[0]);
        }
    }

    public static boolean c() {
        return 1 == ((Integer) a("rt", 0)).intValue();
    }

    public static boolean d() {
        return 1 == ((Integer) a("in", 0)).intValue();
    }

    public static boolean e() {
        return 1 == ((Integer) a(PortalFollowFeeds.TYPE_ALL, 0)).intValue();
    }

    public static boolean f() {
        return 1 == ((Integer) a("un", 0)).intValue();
    }

    public static boolean g() {
        return 1 == ((Integer) a("di", 0)).intValue();
    }

    public static boolean h() {
        return 1 == ((Integer) a("ext", 0)).intValue();
    }

    public static boolean i() {
        return 1 == ((Integer) a("bs", 0)).intValue();
    }

    public static boolean j() {
        return 1 == ((Integer) a("l", 0)).intValue();
    }

    public static boolean k() {
        return 1 == ((Integer) a("wi", 0)).intValue();
    }

    public static boolean l() {
        return ((Integer) a("wl", 0)).intValue() > 0;
    }

    public static boolean m() {
        return 1 == ((Integer) a(ContextChain.TAG_PRODUCT, 0)).intValue();
    }

    public static boolean n() {
        return 1 == ((Integer) a("ol", 0)).intValue();
    }

    public static long o() {
        return ((Long) a("xmar", 0L)).longValue() * 1000;
    }

    public static boolean p() {
        return 1 == ((Integer) a("bi", 0)).intValue();
    }

    public static long q() {
        return ((Long) a("bigap", 30L)).longValue();
    }

    public static long r() {
        return ((Long) a("le", 0L)).longValue();
    }

    public static long s() {
        return ((Long) a("sd", 0L)).longValue();
    }

    public static boolean t() {
        return a(480000L);
    }

    public static boolean u() {
        return a(480000L);
    }

    public static long v() {
        return ((Integer) a("deup", 2)).intValue() * 1000;
    }

    public static long w() {
        return ((Integer) a("digap", 2592000)).intValue() * 1000;
    }

    public static long x() {
        return ((Long) a("pe", 0L)).longValue();
    }

    public static long y() {
        return ((Long) a("ac", 0L)).longValue();
    }

    public static long z() {
        return ((Long) a(NotificationCompat.CATEGORY_SYSTEM, 0L)).longValue();
    }

    public static long a() {
        long j2;
        try {
            j2 = Long.valueOf(String.valueOf(f5873g.get("serverTime"))).longValue();
        } catch (Throwable unused) {
            j2 = 0;
        }
        if (j2 == 0) {
            return System.currentTimeMillis();
        }
        return j2 + V();
    }

    public static boolean b() {
        return 1 == ((Integer) a("conn", 0)).intValue();
    }

    private static boolean c(boolean z) {
        boolean z2 = V() >= AdvTimeUtils.MILLIS_OF_A_DAY;
        if (z || z2) {
            if (W()) {
                if (z || z2) {
                    a((a) null);
                }
                com.mob.commons.a.a(1);
                return true;
            }
            return false;
        }
        return true;
    }

    private static <T> T b(String str, T t) {
        synchronized (f5875i) {
            if (f5874h == null) {
                MobLog.getInstance().d("wait onlineLock", new Object[0]);
                f5875i.wait(600000L);
            }
            HashMap<String, Object> hashMap = f5874h;
            if (hashMap == null) {
                return t;
            }
            return (T) ResHelper.forceCast(hashMap.get(str), t);
        }
    }

    public static void a(long j2, boolean z) {
        f5876j = j2;
        if (!z && j2 == 0) {
            z = DeviceHelper.getInstance(MobSDK.getContext()).amIOnForeground();
        }
        if (z) {
            h.a(j2);
        }
    }

    public static void a(final a aVar) {
        if (b) {
            return;
        }
        b = true;
        new Thread() { // from class: com.mob.commons.b.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    if (!b.X()) {
                        b.Y();
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                }
                boolean unused = b.b = false;
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
        }.start();
    }

    private static synchronized void b(HashMap<String, Object> hashMap) {
        synchronized (b.class) {
            if (hashMap != null) {
                if (!hashMap.isEmpty()) {
                    f5873g = hashMap;
                }
            }
            HashMap<String, Object> hashMap2 = f5873g;
            if (hashMap2 == null || hashMap2.isEmpty()) {
                ab();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static <T> T a(java.lang.String r6, T r7) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.b.a(java.lang.String, java.lang.Object):java.lang.Object");
    }

    public static void a(HashMap<String, Object> hashMap) {
        synchronized (f5875i) {
            HashMap<String, Object> hashMap2 = new HashMap<>();
            f5874h = hashMap2;
            if (hashMap != null) {
                hashMap2.putAll(hashMap);
            }
            MobLog.getInstance().d("notify onlineLock", new Object[0]);
            f5875i.notifyAll();
        }
    }

    private static void a(int i2) {
        if (f5870d < i2) {
            synchronized (f5871e) {
                f5870d = i2;
            }
        }
    }

    private static void a(Object obj) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("list", obj);
            File dataCacheFile = ResHelper.getDataCacheFile(MobSDK.getContext(), ".mcli");
            ResHelper.saveObjectToFile(dataCacheFile.getPath(), Data.AES128Encode("1234567890abcdfi", new Hashon().fromHashMap(hashMap)));
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }
}
