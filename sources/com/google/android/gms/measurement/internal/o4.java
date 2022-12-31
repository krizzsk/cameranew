package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfg;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zzy;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class o4 implements k5 {
    private static volatile o4 I;
    private long A;
    private volatile Boolean B;
    protected Boolean C;
    protected Boolean D;
    private volatile boolean E;
    private int F;
    final long H;
    private final Context a;
    private final String b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private final String f3900d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f3901e;

    /* renamed from: f  reason: collision with root package name */
    private final da f3902f;

    /* renamed from: g  reason: collision with root package name */
    private final e f3903g;

    /* renamed from: h  reason: collision with root package name */
    private final z3 f3904h;

    /* renamed from: i  reason: collision with root package name */
    private final k3 f3905i;

    /* renamed from: j  reason: collision with root package name */
    private final l4 f3906j;

    /* renamed from: k  reason: collision with root package name */
    private final u8 f3907k;

    /* renamed from: l  reason: collision with root package name */
    private final n9 f3908l;
    private final f3 m;
    private final Clock n;
    private final g7 o;
    private final r6 p;
    private final a2 q;
    private final v6 r;
    private final String s;
    private e3 t;
    private g8 u;
    private m v;
    private c3 w;
    private d4 x;
    private Boolean z;
    private boolean y = false;
    private final AtomicInteger G = new AtomicInteger(0);

    o4(r5 r5Var) {
        long currentTimeMillis;
        Bundle bundle;
        boolean z = false;
        com.google.android.gms.common.internal.q.j(r5Var);
        Context context = r5Var.a;
        da daVar = new da(context);
        this.f3902f = daVar;
        v2.a = daVar;
        this.a = context;
        this.b = r5Var.b;
        this.c = r5Var.c;
        this.f3900d = r5Var.f3920d;
        this.f3901e = r5Var.f3924h;
        this.B = r5Var.f3921e;
        this.s = r5Var.f3926j;
        this.E = true;
        zzy zzyVar = r5Var.f3923g;
        if (zzyVar != null && (bundle = zzyVar.zzg) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.C = (Boolean) obj;
            }
            Object obj2 = zzyVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.D = (Boolean) obj2;
            }
        }
        zzfg.zzb(context);
        Clock hVar = com.google.android.gms.common.util.h.getInstance();
        this.n = hVar;
        Long l2 = r5Var.f3925i;
        if (l2 != null) {
            currentTimeMillis = l2.longValue();
        } else {
            currentTimeMillis = hVar.currentTimeMillis();
        }
        this.H = currentTimeMillis;
        this.f3903g = new e(this);
        z3 z3Var = new z3(this);
        z3Var.k();
        this.f3904h = z3Var;
        k3 k3Var = new k3(this);
        k3Var.k();
        this.f3905i = k3Var;
        n9 n9Var = new n9(this);
        n9Var.k();
        this.f3908l = n9Var;
        f3 f3Var = new f3(this);
        f3Var.k();
        this.m = f3Var;
        this.q = new a2(this);
        g7 g7Var = new g7(this);
        g7Var.i();
        this.o = g7Var;
        r6 r6Var = new r6(this);
        r6Var.i();
        this.p = r6Var;
        u8 u8Var = new u8(this);
        u8Var.i();
        this.f3907k = u8Var;
        v6 v6Var = new v6(this);
        v6Var.k();
        this.r = v6Var;
        l4 l4Var = new l4(this);
        l4Var.k();
        this.f3906j = l4Var;
        zzy zzyVar2 = r5Var.f3923g;
        z = (zzyVar2 == null || zzyVar2.zzb == 0) ? true : true;
        if (context.getApplicationContext() instanceof Application) {
            r6 D = D();
            if (D.a.a.getApplicationContext() instanceof Application) {
                Application application = (Application) D.a.a.getApplicationContext();
                if (D.c == null) {
                    D.c = new q6(D, null);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(D.c);
                    application.registerActivityLifecycleCallbacks(D.c);
                    D.a.a().u().a("Registered activity lifecycle callback");
                }
            }
        } else {
            a().p().a("Application context is not an Application");
        }
        l4Var.p(new n4(this, r5Var));
    }

    public static o4 f(Context context, zzy zzyVar, Long l2) {
        Bundle bundle;
        if (zzyVar != null && (zzyVar.zze == null || zzyVar.zzf == null)) {
            zzyVar = new zzy(zzyVar.zza, zzyVar.zzb, zzyVar.zzc, zzyVar.zzd, null, null, zzyVar.zzg, null);
        }
        com.google.android.gms.common.internal.q.j(context);
        com.google.android.gms.common.internal.q.j(context.getApplicationContext());
        if (I == null) {
            synchronized (o4.class) {
                if (I == null) {
                    I = new o4(new r5(context, zzyVar, l2));
                }
            }
        } else if (zzyVar != null && (bundle = zzyVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            com.google.android.gms.common.internal.q.j(I);
            I.B = Boolean.valueOf(zzyVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        com.google.android.gms.common.internal.q.j(I);
        return I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void r(o4 o4Var, r5 r5Var) {
        o4Var.c().f();
        o4Var.f3903g.j();
        m mVar = new m(o4Var);
        mVar.k();
        o4Var.v = mVar;
        c3 c3Var = new c3(o4Var, r5Var.f3922f);
        c3Var.i();
        o4Var.w = c3Var;
        e3 e3Var = new e3(o4Var);
        e3Var.i();
        o4Var.t = e3Var;
        g8 g8Var = new g8(o4Var);
        g8Var.i();
        o4Var.u = g8Var;
        o4Var.f3908l.l();
        o4Var.f3904h.l();
        o4Var.x = new d4(o4Var);
        o4Var.w.j();
        i3 s = o4Var.a().s();
        o4Var.f3903g.n();
        s.b("App measurement initialized, version", 39000L);
        o4Var.a().s().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String n = c3Var.n();
        if (TextUtils.isEmpty(o4Var.b)) {
            if (o4Var.E().F(n)) {
                o4Var.a().s().a("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                i3 s2 = o4Var.a().s();
                String valueOf = String.valueOf(n);
                s2.a(valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app "));
            }
        }
        o4Var.a().t().a("Debug-level message logging enabled");
        if (o4Var.F != o4Var.G.get()) {
            o4Var.a().m().c("Not all components initialized", Integer.valueOf(o4Var.F), Integer.valueOf(o4Var.G.get()));
        }
        o4Var.y = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void s() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void t(i5 i5Var) {
        if (i5Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void u(c4 c4Var) {
        if (c4Var != null) {
            if (c4Var.g()) {
                return;
            }
            String valueOf = String.valueOf(c4Var.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
        throw new IllegalStateException("Component not created");
    }

    private static final void v(j5 j5Var) {
        if (j5Var != null) {
            if (j5Var.i()) {
                return;
            }
            String valueOf = String.valueOf(j5Var.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
        throw new IllegalStateException("Component not created");
    }

    @Pure
    public final u8 A() {
        u(this.f3907k);
        return this.f3907k;
    }

    @SideEffectFree
    public final d4 B() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SideEffectFree
    public final l4 C() {
        return this.f3906j;
    }

    @Pure
    public final r6 D() {
        u(this.p);
        return this.p;
    }

    @Pure
    public final n9 E() {
        t(this.f3908l);
        return this.f3908l;
    }

    @Pure
    public final f3 F() {
        t(this.m);
        return this.m;
    }

    @Pure
    public final e3 G() {
        u(this.t);
        return this.t;
    }

    @Pure
    public final v6 H() {
        v(this.r);
        return this.r;
    }

    @Pure
    public final boolean I() {
        return TextUtils.isEmpty(this.b);
    }

    @Pure
    public final String J() {
        return this.b;
    }

    @Pure
    public final String K() {
        return this.c;
    }

    @Pure
    public final String L() {
        return this.f3900d;
    }

    @Pure
    public final boolean M() {
        return this.f3901e;
    }

    @Pure
    public final String N() {
        return this.s;
    }

    @Pure
    public final g7 O() {
        u(this.o);
        return this.o;
    }

    @Pure
    public final g8 P() {
        u(this.u);
        return this.u;
    }

    @Pure
    public final m Q() {
        v(this.v);
        return this.v;
    }

    @Override // com.google.android.gms.measurement.internal.k5
    @Pure
    public final k3 a() {
        v(this.f3905i);
        return this.f3905i;
    }

    @Pure
    public final c3 b() {
        u(this.w);
        return this.w;
    }

    @Override // com.google.android.gms.measurement.internal.k5
    @Pure
    public final l4 c() {
        v(this.f3906j);
        return this.f3906j;
    }

    @Override // com.google.android.gms.measurement.internal.k5
    @Pure
    public final da d() {
        return this.f3902f;
    }

    @Pure
    public final a2 e() {
        a2 a2Var = this.q;
        if (a2Var != null) {
            return a2Var;
        }
        throw new IllegalStateException("Component not created");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void g(boolean z) {
        this.B = Boolean.valueOf(z);
    }

    @WorkerThread
    public final boolean h() {
        return this.B != null && this.B.booleanValue();
    }

    @WorkerThread
    public final boolean i() {
        return j() == 0;
    }

    @WorkerThread
    public final int j() {
        c().f();
        if (this.f3903g.y()) {
            return 1;
        }
        Boolean bool = this.D;
        if (bool == null || !bool.booleanValue()) {
            zzlc.zzb();
            if (this.f3903g.u(null, x2.w0)) {
                c().f();
                if (!this.E) {
                    return 8;
                }
            }
            Boolean p = y().p();
            if (p != null) {
                return p.booleanValue() ? 0 : 3;
            }
            e eVar = this.f3903g;
            da daVar = eVar.a.f3902f;
            Boolean w = eVar.w("firebase_analytics_collection_enabled");
            if (w != null) {
                return w.booleanValue() ? 0 : 4;
            }
            Boolean bool2 = this.C;
            return bool2 != null ? bool2.booleanValue() ? 0 : 5 : (!this.f3903g.u(null, x2.T) || this.B == null || this.B.booleanValue()) ? 0 : 7;
        }
        return 2;
    }

    @WorkerThread
    public final void k(boolean z) {
        c().f();
        this.E = z;
    }

    @WorkerThread
    public final boolean l() {
        c().f();
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m() {
        this.F++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n() {
        this.G.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final boolean o() {
        if (this.y) {
            c().f();
            Boolean bool = this.z;
            if (bool == null || this.A == 0 || (!bool.booleanValue() && Math.abs(this.n.a() - this.A) > 1000)) {
                this.A = this.n.a();
                boolean z = true;
                Boolean valueOf = Boolean.valueOf(E().C("android.permission.INTERNET") && E().C("android.permission.ACCESS_NETWORK_STATE") && (com.google.android.gms.common.wrappers.b.a(this.a).f() || this.f3903g.F() || (f4.a(this.a) && n9.B(this.a, false))));
                this.z = valueOf;
                if (valueOf.booleanValue()) {
                    if (!E().m(b().o(), b().p(), b().q()) && TextUtils.isEmpty(b().p())) {
                        z = false;
                    }
                    this.z = Boolean.valueOf(z);
                }
            }
            return this.z.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    @WorkerThread
    public final void p() {
        c().f();
        v(H());
        String n = b().n();
        Pair<String, Boolean> m = y().m(n);
        if (this.f3903g.z() && !((Boolean) m.second).booleanValue() && !TextUtils.isEmpty((CharSequence) m.first)) {
            v6 H = H();
            H.j();
            ConnectivityManager connectivityManager = (ConnectivityManager) H.a.a.getSystemService("connectivity");
            NetworkInfo networkInfo = null;
            if (connectivityManager != null) {
                try {
                    networkInfo = connectivityManager.getActiveNetworkInfo();
                } catch (SecurityException unused) {
                }
            }
            if (networkInfo != null && networkInfo.isConnected()) {
                n9 E = E();
                b().a.f3903g.n();
                URL X = E.X(39000L, n, (String) m.first, y().x.a() - 1);
                if (X != null) {
                    v6 H2 = H();
                    m4 m4Var = new m4(this);
                    H2.f();
                    H2.j();
                    com.google.android.gms.common.internal.q.j(X);
                    com.google.android.gms.common.internal.q.j(m4Var);
                    H2.a.c().s(new u6(H2, n, X, null, null, m4Var, null));
                    return;
                }
                return;
            }
            a().p().a("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        a().t().a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void q(String str, int i2, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        if (i2 != 200 && i2 != 204) {
            if (i2 == 304) {
                i2 = 304;
            }
            a().p().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
        }
        if (th == null) {
            y().w.b(true);
            if (bArr == null || bArr.length == 0) {
                a().t().a("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String optString = jSONObject.optString(Constants.DEEPLINK, "");
                String optString2 = jSONObject.optString("gclid", "");
                double optDouble = jSONObject.optDouble("timestamp", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                if (TextUtils.isEmpty(optString)) {
                    a().t().a("Deferred Deep Link is empty.");
                    return;
                }
                n9 E = E();
                o4 o4Var = E.a;
                if (!TextUtils.isEmpty(optString) && (queryIntentActivities = E.a.a.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) != null && !queryIntentActivities.isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("gclid", optString2);
                    bundle.putString("_cis", "ddp");
                    this.p.V("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
                    n9 E2 = E();
                    if (TextUtils.isEmpty(optString)) {
                        return;
                    }
                    try {
                        SharedPreferences.Editor edit = E2.a.a.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                        edit.putString(com.adjust.sdk.Constants.DEEPLINK, optString);
                        edit.putLong("timestamp", Double.doubleToRawLongBits(optDouble));
                        if (edit.commit()) {
                            E2.a.a.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        E2.a.a().m().b("Failed to persist Deferred Deep Link. exception", e2);
                        return;
                    }
                }
                a().p().c("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            } catch (JSONException e3) {
                a().m().b("Failed to parse the Deferred Deep Link response. exception", e3);
                return;
            }
        }
        a().p().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void w(zzy zzyVar) {
        f b;
        c().f();
        zzlc.zzb();
        e eVar = this.f3903g;
        w2<Boolean> w2Var = x2.w0;
        if (eVar.u(null, w2Var)) {
            f r = y().r();
            z3 y = y();
            o4 o4Var = y.a;
            y.f();
            int i2 = 100;
            int i3 = y.n().getInt("consent_source", 100);
            e eVar2 = this.f3903g;
            w2<Boolean> w2Var2 = x2.x0;
            if (eVar2.u(null, w2Var2)) {
                e eVar3 = this.f3903g;
                o4 o4Var2 = eVar3.a;
                zzlc.zzb();
                Boolean w = !eVar3.u(null, w2Var2) ? null : eVar3.w("google_analytics_default_allow_ad_storage");
                e eVar4 = this.f3903g;
                o4 o4Var3 = eVar4.a;
                zzlc.zzb();
                Boolean w2 = !eVar4.u(null, w2Var2) ? null : eVar4.w("google_analytics_default_allow_analytics_storage");
                if ((w != null || w2 != null) && y().q(20)) {
                    b = new f(w, w2);
                    i2 = 20;
                } else {
                    if (!TextUtils.isEmpty(b().o()) && (i3 == 30 || i3 == 40)) {
                        D().T(f.c, 20, this.H);
                    } else if (zzyVar != null && zzyVar.zzg != null && y().q(40)) {
                        b = f.b(zzyVar.zzg);
                        if (!b.equals(f.c)) {
                            i2 = 40;
                        }
                    }
                    b = null;
                }
                if (b != null) {
                    D().T(b, i2, this.H);
                    r = b;
                }
                D().U(r);
            } else {
                if (zzyVar != null && zzyVar.zzg != null && y().q(40)) {
                    b = f.b(zzyVar.zzg);
                    if (!b.equals(f.c)) {
                        D().T(b, 40, this.H);
                        r = b;
                    }
                }
                D().U(r);
            }
        }
        if (y().f4002e.a() == 0) {
            y().f4002e.b(this.n.currentTimeMillis());
        }
        if (Long.valueOf(y().f4007j.a()).longValue() == 0) {
            a().u().b("Persisting first open", Long.valueOf(this.H));
            y().f4007j.b(this.H);
        }
        D().n.c();
        if (!o()) {
            if (i()) {
                if (!E().C("android.permission.INTERNET")) {
                    a().m().a("App is missing INTERNET permission");
                }
                if (!E().C("android.permission.ACCESS_NETWORK_STATE")) {
                    a().m().a("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!com.google.android.gms.common.wrappers.b.a(this.a).f() && !this.f3903g.F()) {
                    if (!f4.a(this.a)) {
                        a().m().a("AppMeasurementReceiver not registered/enabled");
                    }
                    if (!n9.B(this.a, false)) {
                        a().m().a("AppMeasurementService not registered/enabled");
                    }
                }
                a().m().a("Uploading is not possible. App measurement disabled");
            }
        } else {
            if (!TextUtils.isEmpty(b().o()) || !TextUtils.isEmpty(b().p())) {
                n9 E = E();
                String o = b().o();
                z3 y2 = y();
                y2.f();
                String string = y2.n().getString("gmp_app_id", null);
                String p = b().p();
                z3 y3 = y();
                y3.f();
                if (E.n(o, string, p, y3.n().getString("admob_app_id", null))) {
                    a().s().a("Rechecking which service to use due to a GMP App Id change");
                    z3 y4 = y();
                    y4.f();
                    Boolean p2 = y4.p();
                    SharedPreferences.Editor edit = y4.n().edit();
                    edit.clear();
                    edit.apply();
                    if (p2 != null) {
                        y4.o(p2);
                    }
                    G().m();
                    this.u.r();
                    this.u.n();
                    y().f4007j.b(this.H);
                    y().f4009l.b(null);
                }
                z3 y5 = y();
                String o2 = b().o();
                y5.f();
                SharedPreferences.Editor edit2 = y5.n().edit();
                edit2.putString("gmp_app_id", o2);
                edit2.apply();
                z3 y6 = y();
                String p3 = b().p();
                y6.f();
                SharedPreferences.Editor edit3 = y6.n().edit();
                edit3.putString("admob_app_id", p3);
                edit3.apply();
            }
            zzlc.zzb();
            if (this.f3903g.u(null, w2Var) && !y().r().h()) {
                y().f4009l.b(null);
            }
            D().p(y().f4009l.a());
            zzll.zzb();
            if (this.f3903g.u(null, x2.o0)) {
                try {
                    E().a.a.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                } catch (ClassNotFoundException unused) {
                    if (!TextUtils.isEmpty(y().y.a())) {
                        a().p().a("Remote config removed with active feature rollouts");
                        y().y.b(null);
                    }
                }
            }
            if (!TextUtils.isEmpty(b().o()) || !TextUtils.isEmpty(b().p())) {
                boolean i4 = i();
                if (!y().t() && !this.f3903g.y()) {
                    y().s(!i4);
                }
                if (i4) {
                    D().s();
                }
                A().f3948d.a();
                P().R(new AtomicReference<>());
                P().m(y().B.a());
            }
        }
        y().s.b(this.f3903g.u(null, x2.X));
    }

    @Pure
    public final e x() {
        return this.f3903g;
    }

    @Pure
    public final z3 y() {
        t(this.f3904h);
        return this.f3904h;
    }

    public final k3 z() {
        k3 k3Var = this.f3905i;
        if (k3Var == null || !k3Var.i()) {
            return null;
        }
        return this.f3905i;
    }

    @Override // com.google.android.gms.measurement.internal.k5
    @Pure
    public final Context zzaw() {
        return this.a;
    }

    @Override // com.google.android.gms.measurement.internal.k5
    @Pure
    public final Clock zzax() {
        return this.n;
    }
}
