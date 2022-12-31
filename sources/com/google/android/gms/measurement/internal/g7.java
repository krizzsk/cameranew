package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class g7 extends c4 {
    private volatile y6 c;

    /* renamed from: d  reason: collision with root package name */
    private y6 f3798d;

    /* renamed from: e  reason: collision with root package name */
    protected y6 f3799e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Activity, y6> f3800f;
    @GuardedBy("activityLock")

    /* renamed from: g  reason: collision with root package name */
    private Activity f3801g;
    @GuardedBy("activityLock")

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f3802h;

    /* renamed from: i  reason: collision with root package name */
    private volatile y6 f3803i;

    /* renamed from: j  reason: collision with root package name */
    private y6 f3804j;
    @GuardedBy("activityLock")

    /* renamed from: k  reason: collision with root package name */
    private boolean f3805k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f3806l;
    @GuardedBy("this")
    private String m;

    public g7(o4 o4Var) {
        super(o4Var);
        this.f3806l = new Object();
        this.f3800f = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void C(g7 g7Var, Bundle bundle, y6 y6Var, y6 y6Var2, long j2) {
        bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        g7Var.n(y6Var, y6Var2, j2, true, g7Var.a.E().r(null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, null, true));
    }

    @MainThread
    private final void m(Activity activity, y6 y6Var, boolean z) {
        y6 y6Var2;
        y6 y6Var3 = this.c == null ? this.f3798d : this.c;
        if (y6Var.b == null) {
            y6Var2 = new y6(y6Var.a, activity != null ? r(activity.getClass(), "Activity") : null, y6Var.c, y6Var.f3995e, y6Var.f3996f);
        } else {
            y6Var2 = y6Var;
        }
        this.f3798d = this.c;
        this.c = y6Var2;
        this.a.c().p(new a7(this, y6Var2, y6Var3, this.a.zzax().a(), z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void n(y6 y6Var, y6 y6Var2, long j2, boolean z, Bundle bundle) {
        long j3;
        f();
        boolean z2 = false;
        if (z && this.f3799e != null) {
            z2 = true;
        }
        if (z2) {
            o(this.f3799e, true, j2);
        }
        if (y6Var2 == null || y6Var2.c != y6Var.c || !n9.E(y6Var2.b, y6Var.b) || !n9.E(y6Var2.a, y6Var.a)) {
            Bundle bundle2 = new Bundle();
            e x = this.a.x();
            w2<Boolean> w2Var = x2.u0;
            if (x.u(null, w2Var)) {
                if (bundle != null) {
                    bundle2 = new Bundle(bundle);
                } else {
                    bundle2 = new Bundle();
                }
            }
            v(y6Var, bundle2, true);
            if (y6Var2 != null) {
                String str = y6Var2.a;
                if (str != null) {
                    bundle2.putString("_pn", str);
                }
                String str2 = y6Var2.b;
                if (str2 != null) {
                    bundle2.putString("_pc", str2);
                }
                bundle2.putLong("_pi", y6Var2.c);
            }
            if (z2) {
                s8 s8Var = this.a.A().f3949e;
                long j4 = j2 - s8Var.b;
                s8Var.b = j2;
                if (j4 > 0) {
                    this.a.E().O(bundle2, j4);
                }
            }
            String str3 = "auto";
            if (this.a.x().u(null, w2Var)) {
                if (!this.a.x().A()) {
                    bundle2.putLong("_mst", 1L);
                }
                if (true == y6Var.f3995e) {
                    str3 = "app";
                }
            }
            if (this.a.x().u(null, w2Var)) {
                long currentTimeMillis = this.a.zzax().currentTimeMillis();
                if (y6Var.f3995e) {
                    long j5 = y6Var.f3996f;
                    if (j5 != 0) {
                        j3 = j5;
                        this.a.D().W(str3, "_vs", j3, bundle2);
                    }
                }
                j3 = currentTimeMillis;
                this.a.D().W(str3, "_vs", j3, bundle2);
            } else {
                r6 D = this.a.D();
                o4 o4Var = D.a;
                D.f();
                D.W(str3, "_vs", D.a.zzax().currentTimeMillis(), bundle2);
            }
        }
        this.f3799e = y6Var;
        if (this.a.x().u(null, x2.u0) && y6Var.f3995e) {
            this.f3804j = y6Var;
        }
        this.a.P().U(y6Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void o(y6 y6Var, boolean z, long j2) {
        this.a.e().i(this.a.zzax().a());
        if (!this.a.A().f3949e.d(y6Var != null && y6Var.f3994d, z, j2) || y6Var == null) {
            return;
        }
        y6Var.f3994d = false;
    }

    @MainThread
    private final y6 p(@NonNull Activity activity) {
        com.google.android.gms.common.internal.q.j(activity);
        y6 y6Var = this.f3800f.get(activity);
        if (y6Var == null) {
            y6 y6Var2 = new y6(null, r(activity.getClass(), "Activity"), this.a.E().e0());
            this.f3800f.put(activity, y6Var2);
            y6Var = y6Var2;
        }
        return (this.a.x().u(null, x2.u0) && this.f3803i != null) ? this.f3803i : y6Var;
    }

    public static void v(y6 y6Var, Bundle bundle, boolean z) {
        if (y6Var != null) {
            if (!bundle.containsKey("_sc") || z) {
                String str = y6Var.a;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = y6Var.b;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", y6Var.c);
                return;
            }
            z = false;
        }
        if (y6Var == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    @MainThread
    public final void A(Activity activity, Bundle bundle) {
        y6 y6Var;
        if (!this.a.x().A() || bundle == null || (y6Var = this.f3800f.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(TapjoyAuctionFlags.AUCTION_ID, y6Var.c);
        bundle2.putString("name", y6Var.a);
        bundle2.putString("referrer_name", y6Var.b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @MainThread
    public final void B(Activity activity) {
        synchronized (this.f3806l) {
            if (activity == this.f3801g) {
                this.f3801g = null;
            }
        }
        if (this.a.x().A()) {
            this.f3800f.remove(activity);
        }
    }

    @Override // com.google.android.gms.measurement.internal.c4
    protected final boolean k() {
        return false;
    }

    @WorkerThread
    public final y6 q(boolean z) {
        h();
        f();
        if (this.a.x().u(null, x2.u0) && z) {
            y6 y6Var = this.f3799e;
            return y6Var != null ? y6Var : this.f3804j;
        }
        return this.f3799e;
    }

    final String r(Class<?> cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] split = canonicalName.split("\\.");
        int length = split.length;
        String str2 = length > 0 ? split[length - 1] : "";
        int length2 = str2.length();
        this.a.x();
        if (length2 > 100) {
            this.a.x();
            return str2.substring(0, 100);
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
        if (r2 > 100) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
        if (r4 > 100) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(android.os.Bundle r13, long r14) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.g7.s(android.os.Bundle, long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
        if (r1 <= 100) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b4, code lost:
        if (r1 <= 100) goto L36;
     */
    @androidx.annotation.MainThread
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(@androidx.annotation.NonNull android.app.Activity r4, @androidx.annotation.Size(max = 36, min = 1) java.lang.String r5, @androidx.annotation.Size(max = 36, min = 1) java.lang.String r6) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.o4 r0 = r3.a
            com.google.android.gms.measurement.internal.e r0 = r0.x()
            boolean r0 = r0.A()
            if (r0 != 0) goto L1c
            com.google.android.gms.measurement.internal.o4 r4 = r3.a
            com.google.android.gms.measurement.internal.k3 r4 = r4.a()
            com.google.android.gms.measurement.internal.i3 r4 = r4.r()
            java.lang.String r5 = "setCurrentScreen cannot be called while screen reporting is disabled."
            r4.a(r5)
            return
        L1c:
            com.google.android.gms.measurement.internal.y6 r0 = r3.c
            if (r0 != 0) goto L30
            com.google.android.gms.measurement.internal.o4 r4 = r3.a
            com.google.android.gms.measurement.internal.k3 r4 = r4.a()
            com.google.android.gms.measurement.internal.i3 r4 = r4.r()
            java.lang.String r5 = "setCurrentScreen cannot be called while no activity active"
            r4.a(r5)
            return
        L30:
            java.util.Map<android.app.Activity, com.google.android.gms.measurement.internal.y6> r1 = r3.f3800f
            java.lang.Object r1 = r1.get(r4)
            if (r1 != 0) goto L48
            com.google.android.gms.measurement.internal.o4 r4 = r3.a
            com.google.android.gms.measurement.internal.k3 r4 = r4.a()
            com.google.android.gms.measurement.internal.i3 r4 = r4.r()
            java.lang.String r5 = "setCurrentScreen must be called with an activity in the activity lifecycle"
            r4.a(r5)
            return
        L48:
            if (r6 != 0) goto L54
            java.lang.Class r6 = r4.getClass()
            java.lang.String r1 = "Activity"
            java.lang.String r6 = r3.r(r6, r1)
        L54:
            java.lang.String r1 = r0.b
            boolean r1 = com.google.android.gms.measurement.internal.n9.E(r1, r6)
            java.lang.String r0 = r0.a
            boolean r0 = com.google.android.gms.measurement.internal.n9.E(r0, r5)
            if (r1 == 0) goto L75
            if (r0 != 0) goto L65
            goto L75
        L65:
            com.google.android.gms.measurement.internal.o4 r4 = r3.a
            com.google.android.gms.measurement.internal.k3 r4 = r4.a()
            com.google.android.gms.measurement.internal.i3 r4 = r4.r()
            java.lang.String r5 = "setCurrentScreen cannot be called with the same class and name"
            r4.a(r5)
            return
        L75:
            r0 = 100
            if (r5 == 0) goto La3
            int r1 = r5.length()
            if (r1 <= 0) goto L8b
            int r1 = r5.length()
            com.google.android.gms.measurement.internal.o4 r2 = r3.a
            r2.x()
            if (r1 > r0) goto L8b
            goto La3
        L8b:
            com.google.android.gms.measurement.internal.o4 r4 = r3.a
            com.google.android.gms.measurement.internal.k3 r4 = r4.a()
            com.google.android.gms.measurement.internal.i3 r4 = r4.r()
            int r5 = r5.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid screen name length in setCurrentScreen. Length"
            r4.b(r6, r5)
            return
        La3:
            if (r6 == 0) goto Lcf
            int r1 = r6.length()
            if (r1 <= 0) goto Lb7
            int r1 = r6.length()
            com.google.android.gms.measurement.internal.o4 r2 = r3.a
            r2.x()
            if (r1 > r0) goto Lb7
            goto Lcf
        Lb7:
            com.google.android.gms.measurement.internal.o4 r4 = r3.a
            com.google.android.gms.measurement.internal.k3 r4 = r4.a()
            com.google.android.gms.measurement.internal.i3 r4 = r4.r()
            int r5 = r6.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid class name length in setCurrentScreen. Length"
            r4.b(r6, r5)
            return
        Lcf:
            com.google.android.gms.measurement.internal.o4 r0 = r3.a
            com.google.android.gms.measurement.internal.k3 r0 = r0.a()
            com.google.android.gms.measurement.internal.i3 r0 = r0.u()
            if (r5 != 0) goto Lde
            java.lang.String r1 = "null"
            goto Ldf
        Lde:
            r1 = r5
        Ldf:
            java.lang.String r2 = "Setting current screen to name, class"
            r0.c(r2, r1, r6)
            com.google.android.gms.measurement.internal.y6 r0 = new com.google.android.gms.measurement.internal.y6
            com.google.android.gms.measurement.internal.o4 r1 = r3.a
            com.google.android.gms.measurement.internal.n9 r1 = r1.E()
            long r1 = r1.e0()
            r0.<init>(r5, r6, r1)
            java.util.Map<android.app.Activity, com.google.android.gms.measurement.internal.y6> r5 = r3.f3800f
            r5.put(r4, r0)
            r5 = 1
            r3.m(r4, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.g7.t(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    public final y6 u() {
        return this.c;
    }

    @WorkerThread
    public final void w(String str, y6 y6Var) {
        f();
        synchronized (this) {
            String str2 = this.m;
            if (str2 == null || str2.equals(str) || y6Var != null) {
                this.m = str;
            }
        }
    }

    @MainThread
    public final void x(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!this.a.x().A() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f3800f.put(activity, new y6(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong(TapjoyAuctionFlags.AUCTION_ID)));
    }

    @MainThread
    public final void y(Activity activity) {
        if (this.a.x().u(null, x2.u0)) {
            synchronized (this.f3806l) {
                this.f3805k = true;
                if (activity != this.f3801g) {
                    synchronized (this.f3806l) {
                        this.f3801g = activity;
                        this.f3802h = false;
                    }
                    if (this.a.x().u(null, x2.t0) && this.a.x().A()) {
                        this.f3803i = null;
                        this.a.c().p(new f7(this));
                    }
                }
            }
        }
        if (this.a.x().u(null, x2.t0) && !this.a.x().A()) {
            this.c = this.f3803i;
            this.a.c().p(new b7(this));
            return;
        }
        m(activity, p(activity), false);
        a2 e2 = this.a.e();
        e2.a.c().p(new z0(e2, e2.a.zzax().a()));
    }

    @MainThread
    public final void z(Activity activity) {
        if (this.a.x().u(null, x2.u0)) {
            synchronized (this.f3806l) {
                this.f3805k = false;
                this.f3802h = true;
            }
        }
        long a = this.a.zzax().a();
        if (this.a.x().u(null, x2.t0) && !this.a.x().A()) {
            this.c = null;
            this.a.c().p(new c7(this, a));
            return;
        }
        y6 p = p(activity);
        this.f3798d = this.c;
        this.c = null;
        this.a.c().p(new d7(this, p, a));
    }
}
