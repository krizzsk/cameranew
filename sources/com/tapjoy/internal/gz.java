package com.tapjoy.internal;

import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Base64;
import com.facebook.ads.AdSDKNotificationListener;
import com.tapjoy.internal.ev;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public final class gz {
    private static final gz q;
    private static gz r;
    private static Handler w;
    private static File x;
    public hi b;

    /* renamed from: e  reason: collision with root package name */
    public Context f7594e;

    /* renamed from: f  reason: collision with root package name */
    public hc f7595f;

    /* renamed from: g  reason: collision with root package name */
    public gy f7596g;

    /* renamed from: h  reason: collision with root package name */
    public hm f7597h;

    /* renamed from: i  reason: collision with root package name */
    public gx f7598i;

    /* renamed from: j  reason: collision with root package name */
    public String f7599j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f7600k;

    /* renamed from: l  reason: collision with root package name */
    public String f7601l;
    public String m;
    public String o;
    private String u;
    private String v;
    public boolean c = false;
    private boolean s = false;

    /* renamed from: d  reason: collision with root package name */
    public String f7593d = null;
    private boolean t = false;
    public boolean n = false;
    public ha p = ha.a((go) null);
    public final hh a = new hh(this);

    static {
        gz gzVar = new gz();
        q = gzVar;
        r = gzVar;
    }

    private gz() {
    }

    public final synchronized void b(Context context) {
        if (this.f7594e == null) {
            Context applicationContext = context.getApplicationContext();
            this.f7594e = applicationContext;
            ga.a().a(applicationContext);
            this.f7595f = hc.a(applicationContext);
            File file = new File(c(applicationContext), "events2");
            if (this.f7598i == null) {
                this.f7598i = new gx(file);
            }
            gy gyVar = new gy(this.f7595f, this.f7598i);
            this.f7596g = gyVar;
            this.f7597h = new hm(gyVar);
            this.b = new hi(applicationContext);
            gf.a(new gh(new File(c(applicationContext), "usages"), this.f7596g));
            ht htVar = ht.a;
            htVar.b = applicationContext.getApplicationContext();
            htVar.c = applicationContext.getSharedPreferences("tapjoyCacheDataMMF2E", 0);
            htVar.f7638d = applicationContext.getSharedPreferences("tapjoyCacheDataMMF2U", 0);
            htVar.a();
        }
    }

    public final Set c() {
        if (!d("getUserTags")) {
            return new HashSet();
        }
        return this.f7595f.e();
    }

    public final boolean d(String str) {
        if (this.f7594e == null) {
            if (gw.a) {
                gw.b(str + ": Should be called after initializing the SDK");
                return false;
            }
            return false;
        }
        return true;
    }

    public final boolean e() {
        boolean z;
        hm hmVar = this.f7597h;
        ScheduledFuture scheduledFuture = hmVar.c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            hmVar.c = null;
        }
        if (hmVar.b.compareAndSet(false, true)) {
            gw.a("New session started");
            gy gyVar = hmVar.a;
            fc d2 = gyVar.a.d();
            hc hcVar = gyVar.a;
            synchronized (hcVar) {
                int b = hcVar.c.f7621h.b() + 1;
                hcVar.c.f7621h.a(b);
                hcVar.b.f7533h = Integer.valueOf(b);
            }
            ev.a a = gyVar.a(ey.APP, "bootup");
            gyVar.c = SystemClock.elapsedRealtime();
            if (d2 != null) {
                a.s = d2;
            }
            gyVar.a(a);
            fs.c.notifyObservers();
            z = true;
        } else {
            z = false;
        }
        if (z) {
            hh hhVar = this.a;
            synchronized (hhVar) {
                hhVar.b = null;
            }
            ht.a.a();
            return true;
        }
        return false;
    }

    public static gz a() {
        return r;
    }

    public final fb a(boolean z) {
        if (z) {
            this.f7595f.a();
        }
        return this.f7595f.b();
    }

    public final boolean c(String str) {
        if ((this.f7600k || this.f7599j != null) && this.f7594e != null) {
            return true;
        }
        if (gw.a) {
            gw.b(str + ": Should be called after initializing the SDK");
            return false;
        }
        return false;
    }

    public final boolean d() {
        hm hmVar = this.f7597h;
        return hmVar != null && hmVar.b.get();
    }

    public final synchronized void a(@Nullable final String str) {
        String str2;
        if (this.f7600k) {
            if (str == null && (str2 = this.o) != null) {
                str = str2;
            }
            this.o = null;
            if (str != null) {
                fb b = this.f7595f.b();
                gw.a("GCM registration id of device {} updated for sender {}: {}", b.f7483d.f7469h, this.f7593d, str);
                new il(b, str).a(new cf() { // from class: com.tapjoy.internal.gz.1
                    @Override // com.tapjoy.internal.cf
                    public final void a(ca caVar) {
                    }

                    @Override // com.tapjoy.internal.cf
                    public final /* synthetic */ void a(ca caVar, Object obj) {
                        hb b2 = hb.b(gz.this.f7594e);
                        if (str.equals(b2.b.b(b2.a))) {
                            b2.b.b(b2.a, true);
                            b2.b.a(b2.a, 0L);
                        }
                    }
                }, ca.a);
            }
        } else if (str != null) {
            this.o = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File d(Context context) {
        return new File(c(context), "install");
    }

    public static synchronized File c(Context context) {
        File file;
        synchronized (gz.class) {
            if (x == null) {
                x = context.getDir("fiverocks", 0);
            }
            file = x;
        }
        return file;
    }

    public final boolean a(Context context, String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        b(context);
        if (this.f7595f.a(str, currentTimeMillis, z)) {
            gy gyVar = this.f7596g;
            ev.a a = gyVar.a(ey.APP, "push_show");
            a.s = new fc(null, null, str);
            gyVar.a(a);
            return true;
        }
        return false;
    }

    public final synchronized void b() {
        if (this.f7600k) {
            hb.b(this.f7594e).e(this.f7593d);
            a((String) null);
        }
    }

    public static void a(GLSurfaceView gLSurfaceView) {
        if (gw.a(gLSurfaceView, "setGLSurfaceView: The given GLSurfaceView was null")) {
            gr.a(gLSurfaceView);
        }
    }

    public final void a(Set set) {
        if (d("setUserTags")) {
            if (set != null && !set.isEmpty()) {
                HashSet hashSet = new HashSet();
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (str != null) {
                        String trim = str.trim();
                        if (!trim.isEmpty() && trim.length() <= 200) {
                            hashSet.add(trim);
                            if (hashSet.size() >= 200) {
                                break;
                            }
                        }
                    }
                }
                set = hashSet;
            }
            hc hcVar = this.f7595f;
            synchronized (hcVar) {
                if (set != null) {
                    if (!set.isEmpty()) {
                        hcVar.c.z.a(Base64.encodeToString(fg.c.b(new fg(new ArrayList(set))), 2));
                        hcVar.b.A.clear();
                        hcVar.b.A.addAll(set);
                    }
                }
                hcVar.c.z.c();
                hcVar.b.A.clear();
            }
        }
    }

    public final void b(String str) {
        gy gyVar = this.f7596g;
        ev.a a = gyVar.a(ey.APP, "push_ignore");
        a.s = new fc(null, null, str);
        gyVar.a(a);
    }

    public final synchronized void a(Context context, String str, String str2, String str3, String str4, String str5) {
        boolean z;
        boolean z2;
        if (this.f7600k) {
            return;
        }
        b(context);
        boolean z3 = true;
        if (gw.a(this.f7594e != null, "The given context was null")) {
            if (str4 != null && str4.length() == 24 && str4.matches("[0-9a-f]{24}")) {
                z = true;
            } else {
                gw.b("Invalid App ID: {}", str4);
                z = false;
            }
            if (z) {
                if (str5 != null && str5.length() == 20 && str5.matches("[0-9A-Za-z\\-_]{20}")) {
                    z2 = true;
                } else {
                    gw.b("Invalid App Key: {}", str5);
                    z2 = false;
                }
                if (z2) {
                    this.f7601l = str;
                    this.m = str2;
                    this.u = str4;
                    this.v = str5;
                    try {
                        URL url = new URL(str3);
                        ce ceVar = new ce("TapjoySDK " + str2 + " (" + Build.MODEL + "; Android " + Build.VERSION.RELEASE + "; " + Locale.getDefault() + ")", url);
                        ca.b = ceVar;
                        ca.a = Executors.newCachedThreadPool();
                        gx gxVar = this.f7598i;
                        gxVar.b = ceVar;
                        gxVar.a();
                        this.f7600k = true;
                        hd hdVar = new hd(d(this.f7594e));
                        if (hdVar.b() == null) {
                            z3 = false;
                        }
                        if (!z3 && hdVar.a()) {
                            gy gyVar = this.f7596g;
                            gyVar.a(gyVar.a(ey.APP, "install"));
                        }
                        hc hcVar = this.f7595f;
                        if (!jq.c(str4) && !str4.equals(hcVar.c.D.a())) {
                            hcVar.c.D.a(str4);
                            hcVar.c.a(false);
                        }
                        b();
                    } catch (MalformedURLException e2) {
                        throw new IllegalArgumentException(e2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Map map) {
        gy gyVar = this.f7596g;
        ev.a a = gyVar.a(ey.CAMPAIGN, AdSDKNotificationListener.IMPRESSION_EVENT);
        if (map != null) {
            a.r = bh.a((Object) map);
        }
        gyVar.a(a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Map map, long j2) {
        gy gyVar = this.f7596g;
        ev.a a = gyVar.a(ey.CAMPAIGN, "view");
        a.f7446i = Long.valueOf(j2);
        if (map != null) {
            a.r = bh.a((Object) map);
        }
        gyVar.a(a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Map map, String str) {
        gy gyVar = this.f7596g;
        ev.a a = gyVar.a(ey.CAMPAIGN, "click");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put("region", str);
        a.r = bh.a((Object) linkedHashMap);
        gyVar.a(a);
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (gz.class) {
            if (w == null) {
                w = new Handler(Looper.getMainLooper());
            }
            w.post(runnable);
        }
    }

    public static String a(Context context, Intent intent) {
        String a = d.a(intent);
        if (a != null) {
            gz gzVar = r;
            gzVar.b(context);
            if (jq.c(gzVar.f7595f.c()) || intent.getBooleanExtra("fiverocks:force", false)) {
                hc hcVar = gzVar.f7595f;
                synchronized (hcVar) {
                    hcVar.c.f7617d.a(a);
                    hcVar.b.f7529d = a;
                }
                if (a.length() > 0) {
                    gy gyVar = gzVar.f7596g;
                    gyVar.a(gyVar.a(ey.APP, "referrer"));
                }
            }
        }
        return a;
    }

    public static gz a(Context context) {
        gz gzVar = r;
        gzVar.b(context);
        return gzVar;
    }
}
