package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzlr;
import com.google.android.gms.internal.measurement.zzlx;
import com.google.android.gms.internal.measurement.zznb;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class r6 extends c4 {
    protected q6 c;

    /* renamed from: d  reason: collision with root package name */
    private p5 f3927d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<q5> f3928e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3929f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference<String> f3930g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f3931h;
    @GuardedBy("consentLock")

    /* renamed from: i  reason: collision with root package name */
    private f f3932i;
    @GuardedBy("consentLock")

    /* renamed from: j  reason: collision with root package name */
    private int f3933j;

    /* renamed from: k  reason: collision with root package name */
    private final AtomicLong f3934k;

    /* renamed from: l  reason: collision with root package name */
    private long f3935l;
    private int m;
    final v9 n;
    protected boolean o;
    private final m9 p;

    /* JADX INFO: Access modifiers changed from: protected */
    public r6(o4 o4Var) {
        super(o4Var);
        this.f3928e = new CopyOnWriteArraySet();
        this.f3931h = new Object();
        this.o = true;
        this.p = new g6(this);
        this.f3930g = new AtomicReference<>();
        this.f3932i = new f(null, null);
        this.f3933j = 100;
        this.f3935l = -1L;
        this.m = 100;
        this.f3934k = new AtomicLong(0L);
        this.n = new v9(o4Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void H(r6 r6Var, f fVar, int i2, long j2, boolean z, boolean z2) {
        r6Var.f();
        r6Var.h();
        if (j2 <= r6Var.f3935l && f.m(r6Var.m, i2)) {
            r6Var.a.a().s().b("Dropped out-of-date consent setting, proposed settings", fVar);
            return;
        }
        z3 y = r6Var.a.y();
        zzlc.zzb();
        if (y.a.x().u(null, x2.w0)) {
            o4 o4Var = y.a;
            y.f();
            if (y.q(i2)) {
                SharedPreferences.Editor edit = y.n().edit();
                edit.putString("consent_settings", fVar.d());
                edit.putInt("consent_source", i2);
                edit.apply();
                r6Var.f3935l = j2;
                r6Var.m = i2;
                r6Var.a.P().H(z);
                if (z2) {
                    r6Var.a.P().R(new AtomicReference<>());
                    return;
                }
                return;
            }
        }
        r6Var.a.a().s().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void J(Boolean bool, boolean z) {
        f();
        h();
        this.a.a().t().b("Setting app measurement enabled (FE)", bool);
        this.a.y().o(bool);
        zzlc.zzb();
        e x = this.a.x();
        w2<Boolean> w2Var = x2.w0;
        if (x.u(null, w2Var) && z) {
            z3 y = this.a.y();
            zzlc.zzb();
            if (y.a.x().u(null, w2Var)) {
                o4 o4Var = y.a;
                y.f();
                SharedPreferences.Editor edit = y.n().edit();
                if (bool != null) {
                    edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
                } else {
                    edit.remove("measurement_enabled_from_api");
                }
                edit.apply();
            }
        }
        zzlc.zzb();
        if (this.a.x().u(null, w2Var) && !this.a.l() && (bool == null || bool.booleanValue())) {
            return;
        }
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void K() {
        f();
        String a = this.a.y().r.a();
        if (a != null) {
            if ("unset".equals(a)) {
                n("app", "_npa", null, this.a.zzax().currentTimeMillis());
            } else {
                n("app", "_npa", Long.valueOf(true != "true".equals(a) ? 0L : 1L), this.a.zzax().currentTimeMillis());
            }
        }
        if (this.a.i() && this.o) {
            this.a.a().t().a("Recording app launch after enabling measurement for the first time (FE)");
            s();
            zzlx.zzb();
            if (this.a.x().u(null, x2.p0)) {
                this.a.A().f3948d.a();
            }
            zzlr.zzb();
            if (this.a.x().u(null, x2.s0)) {
                d4 B = this.a.B();
                com.google.android.gms.common.internal.q.j(B);
                if (B.a.y().f4008k.a() <= 0) {
                    B.a(B.a.zzaw().getPackageName());
                }
            }
            this.a.c().p(new v5(this));
            return;
        }
        this.a.a().t().a("Updating Scion state (FE)");
        this.a.P().G();
    }

    public final ArrayList<Bundle> A(String str, String str2) {
        if (this.a.c().m()) {
            this.a.a().m().a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        this.a.d();
        if (da.a()) {
            this.a.a().m().a("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.a.c().q(atomicReference, 5000L, "get conditional user properties", new e6(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list == null) {
            this.a.a().m().b("Timed out waiting for get conditional user properties", null);
            return new ArrayList<>();
        }
        return n9.W(list);
    }

    public final Map<String, Object> B(String str, String str2, boolean z) {
        if (this.a.c().m()) {
            this.a.a().m().a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        this.a.d();
        if (da.a()) {
            this.a.a().m().a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.a.c().q(atomicReference, 5000L, "get user properties", new f6(this, atomicReference, null, str, str2, z));
        List<zzkg> list = (List) atomicReference.get();
        if (list == null) {
            this.a.a().m().b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzkg zzkgVar : list) {
            Object Q = zzkgVar.Q();
            if (Q != null) {
                arrayMap.put(zzkgVar.zzb, Q);
            }
        }
        return arrayMap;
    }

    public final String C() {
        y6 u = this.a.O().u();
        if (u != null) {
            return u.a;
        }
        return null;
    }

    public final String D() {
        y6 u = this.a.O().u();
        if (u != null) {
            return u.b;
        }
        return null;
    }

    public final String E() {
        if (this.a.J() == null) {
            try {
                zznb.zzb();
                if (this.a.x().u(null, x2.B0)) {
                    return x6.b(this.a.zzaw(), "google_app_id", this.a.N());
                }
                return x6.a(this.a.zzaw(), "google_app_id");
            } catch (IllegalStateException e2) {
                this.a.a().m().b("getGoogleAppId failed with exception", e2);
                return null;
            }
        }
        return this.a.J();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void F(Bundle bundle) {
        if (bundle == null) {
            this.a.y().B.b(new Bundle());
            return;
        }
        Bundle a = this.a.y().B.a();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                if (this.a.E().q0(obj)) {
                    this.a.E().y(this.p, null, 27, null, null, 0);
                }
                this.a.a().r().c("Invalid default event parameter type. Name, value", str, obj);
            } else if (n9.D(str)) {
                this.a.a().r().b("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                a.remove(str);
            } else {
                n9 E = this.a.E();
                this.a.x();
                if (E.r0("param", str, 100, obj)) {
                    this.a.E().x(a, str, obj);
                }
            }
        }
        this.a.E();
        int k2 = this.a.x().k();
        if (a.size() > k2) {
            int i2 = 0;
            for (String str2 : new TreeSet(a.keySet())) {
                i2++;
                if (i2 > k2) {
                    a.remove(str2);
                }
            }
            this.a.E().y(this.p, null, 26, null, null, 0);
            this.a.a().r().a("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        this.a.y().B.b(a);
        this.a.P().m(a);
    }

    public final void L() {
        if (!(this.a.zzaw().getApplicationContext() instanceof Application) || this.c == null) {
            return;
        }
        ((Application) this.a.zzaw().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.c);
    }

    public final Boolean M() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.a.c().q(atomicReference, 15000L, "boolean test flag value", new c6(this, atomicReference));
    }

    public final String N() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.a.c().q(atomicReference, 15000L, "String test flag value", new h6(this, atomicReference));
    }

    public final Long O() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.a.c().q(atomicReference, 15000L, "long test flag value", new i6(this, atomicReference));
    }

    public final Integer P() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.a.c().q(atomicReference, 15000L, "int test flag value", new j6(this, atomicReference));
    }

    public final Double Q() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.a.c().q(atomicReference, 15000L, "double test flag value", new k6(this, atomicReference));
    }

    public final void R(Boolean bool) {
        h();
        this.a.c().p(new l6(this, bool));
    }

    public final void S(Bundle bundle, int i2, long j2) {
        zzlc.zzb();
        if (this.a.x().u(null, x2.w0)) {
            h();
            String a = f.a(bundle);
            if (a != null) {
                this.a.a().r().b("Ignoring invalid consent setting", a);
                this.a.a().r().a("Valid consent values are 'granted', 'denied'");
            }
            T(f.b(bundle), i2, j2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ac, code lost:
        if (r6 == 20) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T(com.google.android.gms.measurement.internal.f r16, int r17, long r18) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.r6.T(com.google.android.gms.measurement.internal.f, int, long):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void U(f fVar) {
        f();
        boolean z = (fVar.h() && fVar.f()) || this.a.P().t();
        if (z != this.a.l()) {
            this.a.k(z);
            z3 y = this.a.y();
            zzlc.zzb();
            Boolean bool = null;
            if (y.a.x().u(null, x2.w0)) {
                o4 o4Var = y.a;
                y.f();
                if (y.n().contains("measurement_enabled_from_api")) {
                    bool = Boolean.valueOf(y.n().getBoolean("measurement_enabled_from_api", true));
                }
            }
            if (!z || bool == null || bool.booleanValue()) {
                J(Boolean.valueOf(z), false);
            }
        }
    }

    public final void V(String str, String str2, Bundle bundle) {
        Y(str, str2, bundle, true, true, this.a.zzax().currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void W(String str, String str2, long j2, Bundle bundle) {
        f();
        X(str, str2, j2, bundle, true, this.f3927d == null || n9.D(str2), false, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0491  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void X(java.lang.String r21, java.lang.String r22, long r23, android.os.Bundle r25, boolean r26, boolean r27, boolean r28, java.lang.String r29) {
        /*
            Method dump skipped, instructions count: 1335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.r6.X(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void Y(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2) {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (this.a.x().u(null, x2.u0) && n9.E(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            this.a.O().s(bundle2, j2);
            return;
        }
        Z(str3, str2, j2, bundle2, z2, !z2 || this.f3927d == null || n9.D(str2), !z, null);
    }

    protected final void Z(String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i2 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i2 < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i2];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i2] = new Bundle((Bundle) parcelable);
                        }
                        i2++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i2 < list.size()) {
                        Object obj2 = list.get(i2);
                        if (obj2 instanceof Bundle) {
                            list.set(i2, new Bundle((Bundle) obj2));
                        }
                        i2++;
                    }
                }
            }
        }
        this.a.c().p(new x5(this, str, str2, j2, bundle2, z, z2, z3, str3));
    }

    public final void a0(String str, String str2, Object obj, boolean z) {
        b0("auto", str2, obj, true, this.a.zzax().currentTimeMillis());
    }

    public final void b0(String str, String str2, Object obj, boolean z, long j2) {
        int i2;
        String str3 = str == null ? "app" : str;
        if (z) {
            i2 = this.a.E().n0(str2);
        } else {
            n9 E = this.a.E();
            if (E.i0("user property", str2)) {
                if (E.k0("user property", o5.a, null, str2)) {
                    E.a.x();
                    if (E.l0("user property", 24, str2)) {
                        i2 = 0;
                    }
                } else {
                    i2 = 15;
                }
            }
            i2 = 6;
        }
        if (i2 != 0) {
            n9 E2 = this.a.E();
            this.a.x();
            this.a.E().y(this.p, null, i2, "_ev", E2.o(str2, 24, true), str2 != null ? str2.length() : 0);
        } else if (obj != null) {
            int v = this.a.E().v(str2, obj);
            if (v != 0) {
                n9 E3 = this.a.E();
                this.a.x();
                this.a.E().y(this.p, null, v, "_ev", E3.o(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0);
                return;
            }
            Object w = this.a.E().w(str2, obj);
            if (w != null) {
                m(str3, str2, j2, w);
            }
        } else {
            m(str3, str2, j2, null);
        }
    }

    @Override // com.google.android.gms.measurement.internal.c4
    protected final boolean k() {
        return false;
    }

    final void m(String str, String str2, long j2, Object obj) {
        this.a.c().p(new y5(this, str, str2, obj, j2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.q.f(r9)
            com.google.android.gms.common.internal.q.f(r10)
            r8.f()
            r8.h()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L64
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L52
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L52
            r10 = 1
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r11 = r0.toLowerCase(r11)
            java.lang.String r0 = "false"
            boolean r11 = r0.equals(r11)
            r2 = 1
            if (r10 == r11) goto L37
            r10 = 0
            goto L38
        L37:
            r10 = r2
        L38:
            java.lang.Long r11 = java.lang.Long.valueOf(r10)
            com.google.android.gms.measurement.internal.o4 r10 = r8.a
            com.google.android.gms.measurement.internal.z3 r10 = r10.y()
            com.google.android.gms.measurement.internal.y3 r10 = r10.r
            long r4 = r11.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L4e
            java.lang.String r0 = "true"
        L4e:
            r10.b(r0)
            goto L61
        L52:
            if (r11 != 0) goto L64
            com.google.android.gms.measurement.internal.o4 r10 = r8.a
            com.google.android.gms.measurement.internal.z3 r10 = r10.y()
            com.google.android.gms.measurement.internal.y3 r10 = r10.r
            java.lang.String r0 = "unset"
            r10.b(r0)
        L61:
            r6 = r11
            r3 = r1
            goto L66
        L64:
            r3 = r10
            r6 = r11
        L66:
            com.google.android.gms.measurement.internal.o4 r10 = r8.a
            boolean r10 = r10.i()
            if (r10 != 0) goto L7e
            com.google.android.gms.measurement.internal.o4 r9 = r8.a
            com.google.android.gms.measurement.internal.k3 r9 = r9.a()
            com.google.android.gms.measurement.internal.i3 r9 = r9.u()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.a(r10)
            return
        L7e:
            com.google.android.gms.measurement.internal.o4 r10 = r8.a
            boolean r10 = r10.o()
            if (r10 != 0) goto L87
            return
        L87:
            com.google.android.gms.measurement.internal.zzkg r10 = new com.google.android.gms.measurement.internal.zzkg
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.o4 r9 = r8.a
            com.google.android.gms.measurement.internal.g8 r9 = r9.P()
            r9.P(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.r6.n(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final String o() {
        return this.f3930g.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void p(String str) {
        this.f3930g.set(str);
    }

    public final void q(long j2) {
        this.f3930g.set(null);
        this.a.c().p(new z5(this, j2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r(long j2, boolean z) {
        f();
        h();
        this.a.a().t().a("Resetting analytics data (FE)");
        u8 A = this.a.A();
        A.f();
        t8 t8Var = A.f3948d;
        A.f3949e.c();
        boolean i2 = this.a.i();
        z3 y = this.a.y();
        y.f4007j.b(j2);
        if (!TextUtils.isEmpty(y.a.y().y.a())) {
            y.y.b(null);
        }
        zzlx.zzb();
        e x = y.a.x();
        w2<Boolean> w2Var = x2.p0;
        if (x.u(null, w2Var)) {
            y.t.b(0L);
        }
        if (!y.a.x().y()) {
            y.s(!i2);
        }
        y.z.b(null);
        y.A.b(0L);
        y.B.b(null);
        if (z) {
            this.a.P().Q();
        }
        zzlx.zzb();
        if (this.a.x().u(null, w2Var)) {
            this.a.A().f3948d.a();
        }
        this.o = !i2;
    }

    @WorkerThread
    public final void s() {
        f();
        h();
        if (this.a.o()) {
            if (this.a.x().u(null, x2.c0)) {
                e x = this.a.x();
                x.a.d();
                Boolean w = x.w("google_analytics_deferred_deep_link_enabled");
                if (w != null && w.booleanValue()) {
                    this.a.a().t().a("Deferred Deep Link feature enabled.");
                    this.a.c().p(new Runnable(this) { // from class: com.google.android.gms.measurement.internal.t5
                        private final r6 a;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.a = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            r6 r6Var = this.a;
                            r6Var.f();
                            if (!r6Var.a.y().w.a()) {
                                long a = r6Var.a.y().x.a();
                                r6Var.a.y().x.b(1 + a);
                                r6Var.a.x();
                                if (a >= 5) {
                                    r6Var.a.a().p().a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                    r6Var.a.y().w.b(true);
                                    return;
                                }
                                r6Var.a.p();
                                return;
                            }
                            r6Var.a.a().t().a("Deferred Deep Link already retrieved. Not fetching again.");
                        }
                    });
                }
            }
            this.a.P().T();
            this.o = false;
            z3 y = this.a.y();
            y.f();
            String string = y.n().getString("previous_os_version", null);
            y.a.Q().j();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = y.n().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.a.Q().j();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            V("auto", "_ou", bundle);
        }
    }

    @WorkerThread
    public final void t(p5 p5Var) {
        p5 p5Var2;
        f();
        h();
        if (p5Var != null && p5Var != (p5Var2 = this.f3927d)) {
            com.google.android.gms.common.internal.q.n(p5Var2 == null, "EventInterceptor already set.");
        }
        this.f3927d = p5Var;
    }

    public final void u(q5 q5Var) {
        h();
        com.google.android.gms.common.internal.q.j(q5Var);
        if (this.f3928e.add(q5Var)) {
            return;
        }
        this.a.a().p().a("OnEventListener already registered");
    }

    public final void v(q5 q5Var) {
        h();
        com.google.android.gms.common.internal.q.j(q5Var);
        if (this.f3928e.remove(q5Var)) {
            return;
        }
        this.a.a().p().a("OnEventListener had not been registered");
    }

    public final int w(String str) {
        com.google.android.gms.common.internal.q.f(str);
        this.a.x();
        return 25;
    }

    public final void x(Bundle bundle) {
        y(bundle, this.a.zzax().currentTimeMillis());
    }

    public final void y(Bundle bundle, long j2) {
        com.google.android.gms.common.internal.q.j(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString(TapjoyConstants.TJC_APP_ID))) {
            this.a.a().p().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove(TapjoyConstants.TJC_APP_ID);
        com.google.android.gms.common.internal.q.j(bundle2);
        l5.b(bundle2, TapjoyConstants.TJC_APP_ID, String.class, null);
        l5.b(bundle2, FirebaseAnalytics.Param.ORIGIN, String.class, null);
        l5.b(bundle2, "name", String.class, null);
        l5.b(bundle2, FirebaseAnalytics.Param.VALUE, Object.class, null);
        l5.b(bundle2, "trigger_event_name", String.class, null);
        l5.b(bundle2, "trigger_timeout", Long.class, 0L);
        l5.b(bundle2, "timed_out_event_name", String.class, null);
        l5.b(bundle2, "timed_out_event_params", Bundle.class, null);
        l5.b(bundle2, "triggered_event_name", String.class, null);
        l5.b(bundle2, "triggered_event_params", Bundle.class, null);
        l5.b(bundle2, "time_to_live", Long.class, 0L);
        l5.b(bundle2, "expired_event_name", String.class, null);
        l5.b(bundle2, "expired_event_params", Bundle.class, null);
        com.google.android.gms.common.internal.q.f(bundle2.getString("name"));
        com.google.android.gms.common.internal.q.f(bundle2.getString(FirebaseAnalytics.Param.ORIGIN));
        com.google.android.gms.common.internal.q.j(bundle2.get(FirebaseAnalytics.Param.VALUE));
        bundle2.putLong("creation_timestamp", j2);
        String string = bundle2.getString("name");
        Object obj = bundle2.get(FirebaseAnalytics.Param.VALUE);
        if (this.a.E().n0(string) == 0) {
            if (this.a.E().v(string, obj) == 0) {
                Object w = this.a.E().w(string, obj);
                if (w == null) {
                    this.a.a().m().c("Unable to normalize conditional user property value", this.a.F().p(string), obj);
                    return;
                }
                l5.a(bundle2, w);
                long j3 = bundle2.getLong("trigger_timeout");
                if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name"))) {
                    this.a.x();
                    if (j3 > 15552000000L || j3 < 1) {
                        this.a.a().m().c("Invalid conditional user property timeout", this.a.F().p(string), Long.valueOf(j3));
                        return;
                    }
                }
                long j4 = bundle2.getLong("time_to_live");
                this.a.x();
                if (j4 <= 15552000000L && j4 >= 1) {
                    this.a.c().p(new a6(this, bundle2));
                    return;
                } else {
                    this.a.a().m().c("Invalid conditional user property time to live", this.a.F().p(string), Long.valueOf(j4));
                    return;
                }
            }
            this.a.a().m().c("Invalid conditional user property value", this.a.F().p(string), obj);
            return;
        }
        this.a.a().m().b("Invalid conditional user property name", this.a.F().p(string));
    }

    public final void z(String str, String str2, Bundle bundle) {
        long currentTimeMillis = this.a.zzax().currentTimeMillis();
        com.google.android.gms.common.internal.q.f(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", currentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        this.a.c().p(new b6(this, bundle2));
    }
}
