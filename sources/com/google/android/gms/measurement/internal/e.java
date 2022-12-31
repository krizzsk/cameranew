package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzmp;
import java.lang.reflect.InvocationTargetException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class e extends i5 {
    private Boolean b;
    private d c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f3778d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(o4 o4Var) {
        super(o4Var);
        this.c = c.a;
    }

    public static final long G() {
        return x2.f3964d.b(null).longValue();
    }

    public static final long g() {
        return x2.D.b(null).longValue();
    }

    private final String h(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            com.google.android.gms.common.internal.q.j(str3);
            return str3;
        } catch (ClassNotFoundException e2) {
            this.a.a().m().b("Could not find SystemProperties class", e2);
            return "";
        } catch (IllegalAccessException e3) {
            this.a.a().m().b("Could not access SystemProperties.get()", e3);
            return "";
        } catch (NoSuchMethodException e4) {
            this.a.a().m().b("Could not find SystemProperties.get() method", e4);
            return "";
        } catch (InvocationTargetException e5) {
            this.a.a().m().b("SystemProperties.get() threw an exception", e5);
            return "";
        }
    }

    public final boolean A() {
        Boolean w;
        zzmp.zzb();
        return !u(null, x2.t0) || (w = w("google_analytics_automatic_screen_reporting_enabled")) == null || w.booleanValue();
    }

    public final String B() {
        return h("debug.firebase.analytics.app", "");
    }

    public final String C() {
        return h("debug.deferred.deeplink", "");
    }

    public final boolean D(String str) {
        return "1".equals(this.c.b(str, "gaia_collection_enabled"));
    }

    public final boolean E(String str) {
        return "1".equals(this.c.b(str, "measurement.event_sampling_enabled"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean F() {
        if (this.b == null) {
            Boolean w = w("app_measurement_lite");
            this.b = w;
            if (w == null) {
                this.b = Boolean.FALSE;
            }
        }
        return this.b.booleanValue() || !this.a.M();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(d dVar) {
        this.c = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String j() {
        this.a.d();
        return "FA";
    }

    public final int k() {
        n9 E = this.a.E();
        Boolean o = E.a.P().o();
        if (E.L() < 201500) {
            return (o == null || o.booleanValue()) ? 25 : 100;
        }
        return 100;
    }

    public final int l(@Size(min = 1) String str) {
        return s(str, x2.I, 25, 100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int m(@Size(min = 1) String str) {
        return s(str, x2.H, 500, 2000);
    }

    public final long n() {
        this.a.d();
        return 39000L;
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean o() {
        if (this.f3778d == null) {
            synchronized (this) {
                if (this.f3778d == null) {
                    ApplicationInfo applicationInfo = this.a.zzaw().getApplicationInfo();
                    String a = com.google.android.gms.common.util.q.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = false;
                        if (str != null && str.equals(a)) {
                            z = true;
                        }
                        this.f3778d = Boolean.valueOf(z);
                    }
                    if (this.f3778d == null) {
                        this.f3778d = Boolean.TRUE;
                        this.a.a().m().a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f3778d.booleanValue();
    }

    @WorkerThread
    public final String p(String str, w2<String> w2Var) {
        if (str == null) {
            return w2Var.b(null);
        }
        return w2Var.b(this.c.b(str, w2Var.a()));
    }

    @WorkerThread
    public final long q(String str, w2<Long> w2Var) {
        if (str == null) {
            return w2Var.b(null).longValue();
        }
        String b = this.c.b(str, w2Var.a());
        if (TextUtils.isEmpty(b)) {
            return w2Var.b(null).longValue();
        }
        try {
            return w2Var.b(Long.valueOf(Long.parseLong(b))).longValue();
        } catch (NumberFormatException unused) {
            return w2Var.b(null).longValue();
        }
    }

    @WorkerThread
    public final int r(String str, w2<Integer> w2Var) {
        if (str == null) {
            return w2Var.b(null).intValue();
        }
        String b = this.c.b(str, w2Var.a());
        if (TextUtils.isEmpty(b)) {
            return w2Var.b(null).intValue();
        }
        try {
            return w2Var.b(Integer.valueOf(Integer.parseInt(b))).intValue();
        } catch (NumberFormatException unused) {
            return w2Var.b(null).intValue();
        }
    }

    @WorkerThread
    public final int s(String str, w2<Integer> w2Var, int i2, int i3) {
        return Math.max(Math.min(r(str, w2Var), i3), i2);
    }

    @WorkerThread
    public final double t(String str, w2<Double> w2Var) {
        if (str == null) {
            return w2Var.b(null).doubleValue();
        }
        String b = this.c.b(str, w2Var.a());
        if (TextUtils.isEmpty(b)) {
            return w2Var.b(null).doubleValue();
        }
        try {
            return w2Var.b(Double.valueOf(Double.parseDouble(b))).doubleValue();
        } catch (NumberFormatException unused) {
            return w2Var.b(null).doubleValue();
        }
    }

    @WorkerThread
    public final boolean u(String str, w2<Boolean> w2Var) {
        if (str == null) {
            return w2Var.b(null).booleanValue();
        }
        String b = this.c.b(str, w2Var.a());
        if (TextUtils.isEmpty(b)) {
            return w2Var.b(null).booleanValue();
        }
        return w2Var.b(Boolean.valueOf(Boolean.parseBoolean(b))).booleanValue();
    }

    final Bundle v() {
        try {
            if (this.a.zzaw().getPackageManager() == null) {
                this.a.a().m().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo c = com.google.android.gms.common.wrappers.b.a(this.a.zzaw()).c(this.a.zzaw().getPackageName(), 128);
            if (c == null) {
                this.a.a().m().a("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            return c.metaData;
        } catch (PackageManager.NameNotFoundException e2) {
            this.a.a().m().b("Failed to load metadata: Package name not found", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean w(@Size(min = 1) String str) {
        com.google.android.gms.common.internal.q.f(str);
        Bundle v = v();
        if (v == null) {
            this.a.a().m().a("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (v.containsKey(str)) {
            return Boolean.valueOf(v.getBoolean(str));
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<java.lang.String> x(@androidx.annotation.Size(min = 1) java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = "analytics.safelisted_events"
            com.google.android.gms.common.internal.q.f(r4)
            android.os.Bundle r0 = r3.v()
            r1 = 0
            if (r0 != 0) goto L1d
            com.google.android.gms.measurement.internal.o4 r4 = r3.a
            com.google.android.gms.measurement.internal.k3 r4 = r4.a()
            com.google.android.gms.measurement.internal.i3 r4 = r4.m()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.a(r0)
        L1b:
            r4 = r1
            goto L2c
        L1d:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L24
            goto L1b
        L24:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L2c:
            if (r4 == 0) goto L58
            com.google.android.gms.measurement.internal.o4 r0 = r3.a     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.Context r0 = r0.zzaw()     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L48
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L48
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            if (r4 != 0) goto L43
            return r1
        L43:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            return r4
        L48:
            r4 = move-exception
            com.google.android.gms.measurement.internal.o4 r0 = r3.a
            com.google.android.gms.measurement.internal.k3 r0 = r0.a()
            com.google.android.gms.measurement.internal.i3 r0 = r0.m()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.b(r2, r4)
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e.x(java.lang.String):java.util.List");
    }

    public final boolean y() {
        this.a.d();
        Boolean w = w("firebase_analytics_collection_deactivated");
        return w != null && w.booleanValue();
    }

    public final boolean z() {
        Boolean w = w("google_analytics_adid_collection_enabled");
        return w == null || w.booleanValue();
    }
}
