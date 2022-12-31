package com.mob.commons;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.MobSDK;
import com.mob.OperationCallback;
import com.mob.commons.a.l;
import com.mob.commons.a.n;
import com.mob.commons.a.o;
import com.mob.commons.a.p;
import com.mob.commons.a.q;
import com.mob.commons.a.r;
import com.mob.commons.a.s;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.b;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.UIHandler;
import java.util.ArrayList;
import java.util.HashMap;
/* compiled from: CltsInitializer.java */
/* loaded from: classes2.dex */
public final class a {
    private static final String a;
    private static final String b;
    private static final String c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f5849d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f5850e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f5851f;

    /* renamed from: g  reason: collision with root package name */
    private static Boolean f5852g;

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f5853h;

    /* renamed from: i  reason: collision with root package name */
    private static int f5854i;

    /* renamed from: j  reason: collision with root package name */
    private static Boolean f5855j;

    /* renamed from: k  reason: collision with root package name */
    private static Boolean f5856k;

    /* renamed from: l  reason: collision with root package name */
    private static int f5857l;
    private static int m;
    private static int n;
    private static Boolean o;
    private static Boolean p;
    private static Boolean q;
    private static Boolean r;
    private static byte[] s;
    private static byte[] t;
    private static volatile int u;

    static {
        String a2 = i.a();
        a = a2;
        String b2 = i.b();
        b = b2;
        c = a2 + "/privacy/policy/ms/version";
        f5849d = a2 + "/privacy/policy/rejection/strategy";
        f5850e = b2 + "/privacy/policy/authorization/status";
        f5851f = b2 + "/privacy/policy/permission/window/status";
        f5857l = -1;
        m = -1;
        s = new byte[0];
        t = new byte[0];
        u = -1;
    }

    public static Boolean e() {
        return f5852g;
    }

    public static Boolean f() {
        return f5853h;
    }

    public static int g() {
        return f5854i;
    }

    public static int h() {
        return n;
    }

    public static synchronized boolean i() {
        boolean booleanValue;
        synchronized (a.class) {
            if (o == null) {
                int m2 = h.m();
                if (m2 == 1) {
                    o = Boolean.TRUE;
                } else if (m2 == 0) {
                    o = Boolean.FALSE;
                } else {
                    o = Boolean.FALSE;
                }
            }
            booleanValue = o.booleanValue();
        }
        return booleanValue;
    }

    public static boolean j() {
        if (p == null) {
            synchronized (s) {
                if (p == null) {
                    int n2 = h.n();
                    if (n2 == -1) {
                        v();
                    } else if (n2 == 1) {
                        p = Boolean.TRUE;
                    } else if (n2 == 0) {
                        p = Boolean.FALSE;
                    } else {
                        p = Boolean.FALSE;
                    }
                }
            }
        }
        return p.booleanValue();
    }

    public static Boolean k() {
        int l2;
        if (f5856k == null && (l2 = h.l()) != -1) {
            f5856k = Boolean.valueOf(l2 == 1);
        }
        return f5856k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s() {
        if (b.H()) {
            Log.w("MobSDK/Policy", "您好！依照国家对网络安全及数据安全的要求，请您运营的APP集成并向终端用户展示Mob SDK的隐私政策。");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t() {
        com.mob.commons.a.d.a(com.mob.commons.a.a.class, com.mob.commons.a.k.class, o.class, q.class, com.mob.commons.a.b.class, s.class, com.mob.commons.a.h.class, r.class, p.class, n.class, com.mob.commons.a.j.class, com.mob.commons.a.i.class, com.mob.commons.a.e.class, com.mob.commons.a.c.class, com.mob.commons.a.f.class, com.mob.commons.a.g.class, l.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u() {
        new Thread(new Runnable() { // from class: com.mob.commons.a.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
                    ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                    arrayList.add(new KVPair<>("appkey", MobSDK.getAppkey()));
                    arrayList.add(new KVPair<>("apppkg", deviceHelper.getPackageName()));
                    arrayList.add(new KVPair<>("appver", deviceHelper.getAppVersionName()));
                    arrayList.add(new KVPair<>("plat", String.valueOf(deviceHelper.getPlatformCode())));
                    arrayList.add(new KVPair<>("networktype", deviceHelper.getDetailNetworkTypeForStatic()));
                    String authorizeForOnce = DeviceAuthorizer.authorizeForOnce();
                    if (!TextUtils.isEmpty(authorizeForOnce)) {
                        arrayList.add(new KVPair<>("duid", authorizeForOnce));
                    }
                    NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                    networkTimeOut.readTimout = 10000;
                    networkTimeOut.connectionTimeout = 5000;
                    ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
                    arrayList2.add(new KVPair<>("User-Identity", MobProductCollector.getUserIdentity()));
                    NLog mobLog = MobLog.getInstance();
                    mobLog.d("Request: " + a.c + "\nHeaders: " + arrayList2 + "\nValues: " + arrayList, new Object[0]);
                    String httpGet = new NetworkHelper().httpGet(a.c, arrayList, arrayList2, networkTimeOut);
                    NLog mobLog2 = MobLog.getInstance();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Response: ");
                    sb.append(httpGet);
                    mobLog2.d(sb.toString(), new Object[0]);
                    Hashon hashon = new Hashon();
                    HashMap fromJson = hashon.fromJson(httpGet);
                    if (fromJson != null) {
                        if ("200".equals(String.valueOf(fromJson.get("code")))) {
                            Object obj = fromJson.get("data");
                            if (obj != null) {
                                HashMap hashMap = (HashMap) obj;
                                if (hashMap != null) {
                                    String str = (String) hashMap.get(FirebaseAnalytics.Param.CONTENT);
                                    Long l2 = (Long) hashMap.get("timestamp");
                                    if (TextUtils.isEmpty(str)) {
                                        return;
                                    }
                                    String b2 = a.b(l2.longValue(), str);
                                    NLog mobLog3 = MobLog.getInstance();
                                    mobLog3.d("contentDe: " + b2 + " (ppms->ppNece)", new Object[0]);
                                    HashMap fromJson2 = hashon.fromJson(b2);
                                    if (fromJson2 == null || fromJson2.isEmpty()) {
                                        return;
                                    }
                                    if (((Integer) fromJson2.get("ppms")) != null) {
                                        boolean z = true;
                                        Integer num = 1;
                                        if (num.intValue() != 1) {
                                            z = false;
                                        }
                                        Boolean unused = a.f5855j = Boolean.valueOf(z);
                                        h.a(a.f5855j.booleanValue());
                                    }
                                    Integer num2 = (Integer) fromJson2.get("ppVersion");
                                    if (num2 != null) {
                                        int unused2 = a.n = num2.intValue();
                                        a.e(a.n);
                                        return;
                                    }
                                    return;
                                }
                                throw new Throwable("Response is illegal: " + httpGet);
                            }
                            throw new Throwable("Response is illegal: " + httpGet);
                        }
                        throw new Throwable("Response code is not 200: " + httpGet);
                    }
                    throw new Throwable("Response is illegal: " + httpGet);
                } catch (Throwable th) {
                    MobLog.getInstance().e(th, "Request total switch error", new Object[0]);
                }
            }
        }).start();
    }

    private static void v() {
        try {
            DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>("appkey", MobSDK.getAppkey()));
            arrayList.add(new KVPair<>("apppkg", deviceHelper.getPackageName()));
            arrayList.add(new KVPair<>("appver", deviceHelper.getAppVersionName()));
            arrayList.add(new KVPair<>("plat", String.valueOf(deviceHelper.getPlatformCode())));
            arrayList.add(new KVPair<>("networktype", deviceHelper.getDetailNetworkTypeForStatic()));
            String authorizeForOnce = DeviceAuthorizer.authorizeForOnce();
            if (!TextUtils.isEmpty(authorizeForOnce)) {
                arrayList.add(new KVPair<>("duid", authorizeForOnce));
            }
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 10000;
            networkTimeOut.connectionTimeout = 5000;
            ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
            arrayList2.add(new KVPair<>("User-Identity", MobProductCollector.getUserIdentity()));
            NLog mobLog = MobLog.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append("Request: ");
            String str = f5849d;
            sb.append(str);
            sb.append("\nHeaders: ");
            sb.append(arrayList2);
            sb.append("\nValues: ");
            sb.append(arrayList);
            mobLog.d(sb.toString(), new Object[0]);
            String httpGet = new NetworkHelper().httpGet(str, arrayList, arrayList2, networkTimeOut);
            NLog mobLog2 = MobLog.getInstance();
            mobLog2.d("Response: " + httpGet, new Object[0]);
            Hashon hashon = new Hashon();
            HashMap fromJson = hashon.fromJson(httpGet);
            if (fromJson != null) {
                if ("200".equals(String.valueOf(fromJson.get("code")))) {
                    Object obj = fromJson.get("data");
                    if (obj != null) {
                        HashMap hashMap = (HashMap) obj;
                        if (hashMap != null) {
                            String str2 = (String) hashMap.get(FirebaseAnalytics.Param.CONTENT);
                            Long l2 = (Long) hashMap.get("timestamp");
                            if (TextUtils.isEmpty(str2)) {
                                return;
                            }
                            String b2 = b(l2.longValue(), str2);
                            NLog mobLog3 = MobLog.getInstance();
                            mobLog3.d("contentDe: " + b2 + " (pprdms->clt, pprfms->func, pprsbs->cover, pprspw->dialog)", new Object[0]);
                            HashMap fromJson2 = hashon.fromJson(b2);
                            if (fromJson2 == null || fromJson2.isEmpty()) {
                                return;
                            }
                            boolean z = true;
                            if (((Integer) fromJson2.get("pprdms")) != null) {
                                Integer num = 0;
                                p = Boolean.valueOf(num.intValue() == 1);
                                h.e(num.intValue());
                            }
                            if (((Integer) fromJson2.get("pprfms")) != null) {
                                Integer num2 = 0;
                                o = Boolean.valueOf(num2.intValue() == 1);
                                h.d(num2.intValue());
                            }
                            Integer num3 = (Integer) fromJson2.get("pprsbs");
                            if (num3 != null) {
                                q = Boolean.valueOf(num3.intValue() == 1);
                                h.f(num3.intValue());
                            }
                            Integer num4 = (Integer) fromJson2.get("pprspw");
                            if (num4 != null) {
                                if (num4.intValue() != 1) {
                                    z = false;
                                }
                                r = Boolean.valueOf(z);
                                h.g(num4.intValue());
                                return;
                            }
                            return;
                        }
                        throw new Throwable("Response is illegal: " + httpGet);
                    }
                    throw new Throwable("Response is illegal: " + httpGet);
                }
                throw new Throwable("Response code is not 200: " + httpGet);
            }
            throw new Throwable("Response is illegal: " + httpGet);
        } catch (Throwable th) {
            MobLog.getInstance().e(th, "Request total switch error", new Object[0]);
            Boolean bool = Boolean.FALSE;
            p = bool;
            o = bool;
            Boolean bool2 = Boolean.TRUE;
            q = bool2;
            r = bool2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int w() {
        if (f5857l == -1) {
            f5857l = h.g();
        }
        if (m == -1) {
            m = h.i();
        }
        int i2 = f5857l;
        int i3 = m;
        return i2 >= i3 ? i2 : i3;
    }

    public static boolean d() {
        Boolean k2 = k();
        if (k2 == null) {
            k2 = Boolean.FALSE;
        }
        return k2.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(int i2) {
        if (f5857l == -1) {
            f5857l = h.g();
        }
        if (m == -1) {
            m = h.i();
        }
        try {
            if (f5857l != i2) {
                f5857l = new g().b(2, null).getPpVersion();
            }
            if (m != i2) {
                m = new g().b(1, null).getPpVersion();
            }
        } catch (Throwable unused) {
            MobLog.getInstance().d("Update privacy policy err.", new Object[0]);
        }
    }

    public static boolean c() {
        if (f5855j == null) {
            f5855j = Boolean.valueOf(h.k());
        }
        return f5855j.booleanValue();
    }

    public static final void a() {
        new Thread(new Runnable() { // from class: com.mob.commons.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.u();
                    boolean c2 = a.c();
                    NLog mobLog = MobLog.getInstance();
                    mobLog.d("====> ppNece: " + c2, new Object[0]);
                    if (!c2) {
                        MobLog.getInstance().d("====> Entr 1", new Object[0]);
                        Boolean unused = a.f5853h = null;
                        Boolean unused2 = a.f5852g = null;
                        int unused3 = a.f5854i = a.w();
                        a.t();
                        return;
                    }
                    boolean d2 = a.d();
                    NLog mobLog2 = MobLog.getInstance();
                    mobLog2.d("====> isAgrPp: " + d2, new Object[0]);
                    if (d2) {
                        MobLog.getInstance().d("====> Entr 2", new Object[0]);
                        Boolean unused4 = a.f5852g = Boolean.TRUE;
                        Boolean unused5 = a.f5853h = null;
                        int unused6 = a.f5854i = a.w();
                        a.t();
                        return;
                    }
                    boolean j2 = a.j();
                    NLog mobLog3 = MobLog.getInstance();
                    mobLog3.d("====> cltStch: " + j2, new Object[0]);
                    if (j2) {
                        MobLog.getInstance().d("====> Entr 3", new Object[0]);
                        Boolean unused7 = a.f5852g = a.k();
                        Boolean unused8 = a.f5853h = null;
                        int unused9 = a.f5854i = a.w();
                        a.t();
                    } else {
                        MobLog.getInstance().d("====> Entr cltSwth=false", new Object[0]);
                        b.P();
                        b.a((HashMap<String, Object>) null);
                        a.a(1);
                    }
                    a.s();
                } catch (Throwable th) {
                    MobLog.getInstance().e(th, "Clt init error", new Object[0]);
                }
            }
        }).start();
        new Thread(new Runnable() { // from class: com.mob.commons.a.2
            @Override // java.lang.Runnable
            public void run() {
                Boolean o2 = h.o();
                if (o2 != null) {
                    a.c(o2.booleanValue(), null);
                }
            }
        }).start();
    }

    public static boolean b() {
        if (u != -1) {
            return u == 1;
        }
        synchronized (t) {
            if (u == -1) {
                MobLog.getInstance().d("Wait initLock", new Object[0]);
                t.wait();
            }
        }
        return u == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final boolean z, final OperationCallback<Void> operationCallback) {
        new Thread(new Runnable() { // from class: com.mob.commons.a.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.b(0, z);
                    h.a((Boolean) null);
                    if (operationCallback != null) {
                        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.commons.a.6.1
                            @Override // android.os.Handler.Callback
                            public boolean handleMessage(Message message) {
                                operationCallback.onComplete(null);
                                return false;
                            }
                        });
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().e(th, "Submit privacy grant result error", new Object[0]);
                    h.a(Boolean.valueOf(z));
                    if (operationCallback != null) {
                        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.commons.a.6.2
                            @Override // android.os.Handler.Callback
                            public boolean handleMessage(Message message) {
                                operationCallback.onFailure(th);
                                return false;
                            }
                        });
                    }
                }
            }
        }).start();
    }

    public static void a(int i2) {
        NLog mobLog = MobLog.getInstance();
        mobLog.d("Notify initLock. initialized: " + i2, new Object[0]);
        synchronized (t) {
            try {
                u = i2;
                t.notifyAll();
            }
        }
    }

    public static void a(boolean z, final OperationCallback<Void> operationCallback) {
        Boolean isGpAvailable = MobSDK.isGpAvailable();
        if (isGpAvailable != null && isGpAvailable.booleanValue()) {
            if (z) {
                c(z, operationCallback);
            }
            MobLog.getInstance().d("submitPpResult().", new Object[0]);
            NLog mobLog = MobLog.getInstance();
            mobLog.d("grtd: " + z, new Object[0]);
            if (!z) {
                f5856k = Boolean.FALSE;
                h.c(0);
                return;
            }
            boolean d2 = d();
            NLog mobLog2 = MobLog.getInstance();
            mobLog2.d("bfdIsAgrPp: " + d2, new Object[0]);
            if (d2) {
                return;
            }
            MobProductCollector.collect();
            f5856k = Boolean.TRUE;
            h.c(1);
            MobLog.getInstance().d("====> Entr 5", new Object[0]);
            f5852g = Boolean.valueOf(d());
            f5853h = null;
            f5854i = w();
            b.a(new b.a() { // from class: com.mob.commons.a.4
                @Override // com.mob.commons.b.a
                public void a() {
                    a.a(1);
                    a.t();
                }
            });
            return;
        }
        MobLog.getInstance().w("Service unavailable due to Google Play Services is unavailable!");
        if (operationCallback != null) {
            UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.commons.a.3
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    OperationCallback.this.onFailure(ForbThrowable.obtainGpThrowable());
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i2, boolean z) throws Throwable {
        int i3 = i2 + 1;
        try {
            DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>("appkey", MobSDK.getAppkey()));
            arrayList.add(new KVPair<>("apppkg", deviceHelper.getPackageName()));
            arrayList.add(new KVPair<>("appver", deviceHelper.getAppVersionName()));
            arrayList.add(new KVPair<>("plat", String.valueOf(deviceHelper.getPlatformCode())));
            arrayList.add(new KVPair<>("networktype", deviceHelper.getDetailNetworkTypeForStatic()));
            String authorizeForOnce = DeviceAuthorizer.authorizeForOnce();
            if (!TextUtils.isEmpty(authorizeForOnce)) {
                arrayList.add(new KVPair<>("duid", authorizeForOnce));
            }
            arrayList.add(new KVPair<>("isAgreePp", String.valueOf(z)));
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 10000;
            networkTimeOut.connectionTimeout = 5000;
            ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
            arrayList2.add(new KVPair<>("User-Identity", MobProductCollector.getUserIdentity()));
            NLog mobLog = MobLog.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append("Request: ");
            String str = f5850e;
            sb.append(str);
            sb.append("\nHeaders: ");
            sb.append(arrayList2);
            sb.append("\nValues: ");
            sb.append(arrayList);
            mobLog.d(sb.toString(), new Object[0]);
            String httpGet = new NetworkHelper().httpGet(str, arrayList, arrayList2, networkTimeOut);
            NLog mobLog2 = MobLog.getInstance();
            mobLog2.d("Response: " + httpGet, new Object[0]);
            HashMap fromJson = new Hashon().fromJson(httpGet);
            if (fromJson == null) {
                if (i3 < 2) {
                    b(i3, z);
                } else {
                    throw new Throwable("Response is illegal: " + httpGet);
                }
            }
            if ("200".equals(String.valueOf(fromJson.get("code")))) {
                return;
            }
            if (i3 < 2) {
                b(i3, z);
                return;
            }
            throw new Throwable("Response code is not 200: " + httpGet);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            if (i3 < 2) {
                b(i3, z);
                return;
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(long j2, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String appkey = MobSDK.getAppkey();
            String packageName = DeviceHelper.getInstance(MobSDK.getContext()).getPackageName();
            return new String(Data.AES128Decode(Data.rawMD5(appkey + ":" + packageName + ":" + j2), Base64.decode(str, 0)), "UTF-8");
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }
}
