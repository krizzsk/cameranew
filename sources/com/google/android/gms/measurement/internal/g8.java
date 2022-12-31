package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzs;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class g8 extends c4 {
    private final f8 c;

    /* renamed from: d  reason: collision with root package name */
    private a3 f3807d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Boolean f3808e;

    /* renamed from: f  reason: collision with root package name */
    private final l f3809f;

    /* renamed from: g  reason: collision with root package name */
    private final v8 f3810g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Runnable> f3811h;

    /* renamed from: i  reason: collision with root package name */
    private final l f3812i;

    /* JADX INFO: Access modifiers changed from: protected */
    public g8(o4 o4Var) {
        super(o4Var);
        this.f3811h = new ArrayList();
        this.f3810g = new v8(o4Var.zzax());
        this.c = new f8(this);
        this.f3809f = new p7(this, o4Var);
        this.f3812i = new r7(this, o4Var);
    }

    private final boolean A() {
        this.a.d();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void B() {
        f();
        this.f3810g.a();
        l lVar = this.f3809f;
        this.a.x();
        lVar.b(x2.J.b(null).longValue());
    }

    @WorkerThread
    private final void C(Runnable runnable) throws IllegalStateException {
        f();
        if (F()) {
            runnable.run();
            return;
        }
        int size = this.f3811h.size();
        this.a.x();
        if (size >= 1000) {
            this.a.a().m().a("Discarding data. Max runnable queue size reached");
            return;
        }
        this.f3811h.add(runnable);
        this.f3812i.b(60000L);
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void D() {
        f();
        this.a.a().u().b("Processing queued up service tasks", Integer.valueOf(this.f3811h.size()));
        for (Runnable runnable : this.f3811h) {
            try {
                runnable.run();
            } catch (Exception e2) {
                this.a.a().m().b("Task exception while flushing queue", e2);
            }
        }
        this.f3811h.clear();
        this.f3812i.d();
    }

    @WorkerThread
    private final zzp E(boolean z) {
        Pair<String, Long> b;
        this.a.d();
        c3 b2 = this.a.b();
        String str = null;
        if (z) {
            k3 a = this.a.a();
            if (a.a.y().f4001d != null && (b = a.a.y().f4001d.b()) != null && b != z3.C) {
                String valueOf = String.valueOf(b.second);
                String str2 = (String) b.first;
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str2).length());
                sb.append(valueOf);
                sb.append(":");
                sb.append(str2);
                str = sb.toString();
            }
        }
        return b2.m(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void v(g8 g8Var, ComponentName componentName) {
        g8Var.f();
        if (g8Var.f3807d != null) {
            g8Var.f3807d = null;
            g8Var.a.a().u().b("Disconnected from device MeasurementService", componentName);
            g8Var.f();
            g8Var.n();
        }
    }

    @WorkerThread
    public final boolean F() {
        f();
        h();
        return this.f3807d != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void G() {
        f();
        h();
        C(new s7(this, E(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void H(boolean z) {
        zzlc.zzb();
        if (this.a.x().u(null, x2.w0)) {
            f();
            h();
            if (z) {
                A();
                this.a.G().m();
            }
            if (t()) {
                C(new t7(this, E(false)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void I(a3 a3Var, AbstractSafeParcelable abstractSafeParcelable, zzp zzpVar) {
        int i2;
        f();
        h();
        A();
        this.a.x();
        int i3 = 0;
        int i4 = 100;
        while (i3 < 1001 && i4 == 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> q = this.a.G().q(100);
            if (q != null) {
                arrayList.addAll(q);
                i2 = q.size();
            } else {
                i2 = 0;
            }
            if (abstractSafeParcelable != null && i2 < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) arrayList.get(i5);
                if (abstractSafeParcelable2 instanceof zzas) {
                    try {
                        a3Var.C((zzas) abstractSafeParcelable2, zzpVar);
                    } catch (RemoteException e2) {
                        this.a.a().m().b("Failed to send event to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkg) {
                    try {
                        a3Var.x((zzkg) abstractSafeParcelable2, zzpVar);
                    } catch (RemoteException e3) {
                        this.a.a().m().b("Failed to send user property to the service", e3);
                    }
                } else if (abstractSafeParcelable2 instanceof zzaa) {
                    try {
                        a3Var.n((zzaa) abstractSafeParcelable2, zzpVar);
                    } catch (RemoteException e4) {
                        this.a.a().m().b("Failed to send conditional user property to the service", e4);
                    }
                } else {
                    this.a.a().m().a("Discarding data. Unrecognized parcel type.");
                }
            }
            i3++;
            i4 = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void J(zzas zzasVar, String str) {
        com.google.android.gms.common.internal.q.j(zzasVar);
        f();
        h();
        A();
        C(new u7(this, true, E(true), this.a.G().n(zzasVar), zzasVar, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void K(zzaa zzaaVar) {
        com.google.android.gms.common.internal.q.j(zzaaVar);
        f();
        h();
        this.a.d();
        C(new v7(this, true, E(true), this.a.G().p(zzaaVar), new zzaa(zzaaVar), zzaaVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void L(AtomicReference<List<zzaa>> atomicReference, String str, String str2, String str3) {
        f();
        h();
        C(new w7(this, atomicReference, null, str2, str3, E(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void M(zzs zzsVar, String str, String str2) {
        f();
        h();
        C(new x7(this, str, str2, E(false), zzsVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void N(AtomicReference<List<zzkg>> atomicReference, String str, String str2, String str3, boolean z) {
        f();
        h();
        C(new y7(this, atomicReference, null, str2, str3, E(false), z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void O(zzs zzsVar, String str, String str2, boolean z) {
        f();
        h();
        C(new h7(this, str, str2, E(false), z, zzsVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void P(zzkg zzkgVar) {
        f();
        h();
        A();
        C(new i7(this, E(true), this.a.G().o(zzkgVar), zzkgVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void Q() {
        f();
        h();
        zzp E = E(false);
        A();
        this.a.G().m();
        C(new j7(this, E));
    }

    @WorkerThread
    public final void R(AtomicReference<String> atomicReference) {
        f();
        h();
        C(new k7(this, atomicReference, E(false)));
    }

    @WorkerThread
    public final void S(zzs zzsVar) {
        f();
        h();
        C(new l7(this, E(false), zzsVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void T() {
        f();
        h();
        zzp E = E(true);
        this.a.G().r();
        C(new m7(this, E));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void U(y6 y6Var) {
        f();
        h();
        C(new n7(this, y6Var));
    }

    @Override // com.google.android.gms.measurement.internal.c4
    protected final boolean k() {
        return false;
    }

    @WorkerThread
    public final void m(Bundle bundle) {
        f();
        h();
        C(new o7(this, E(false), bundle));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void n() {
        f();
        h();
        if (F()) {
            return;
        }
        if (!p()) {
            if (this.a.x().F()) {
                return;
            }
            this.a.d();
            List<ResolveInfo> queryIntentServices = this.a.zzaw().getPackageManager().queryIntentServices(new Intent().setClassName(this.a.zzaw(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                Context zzaw = this.a.zzaw();
                this.a.d();
                intent.setComponent(new ComponentName(zzaw, "com.google.android.gms.measurement.AppMeasurementService"));
                this.c.a(intent);
                return;
            }
            this.a.a().m().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        this.c.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean o() {
        return this.f3808e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012b  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p() {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.g8.p():boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void q(a3 a3Var) {
        f();
        com.google.android.gms.common.internal.q.j(a3Var);
        this.f3807d = a3Var;
        B();
        D();
    }

    @WorkerThread
    public final void r() {
        f();
        h();
        this.c.b();
        try {
            ConnectionTracker.getInstance().b(this.a.zzaw(), this.c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f3807d = null;
    }

    @WorkerThread
    public final void s(zzs zzsVar, zzas zzasVar, String str) {
        f();
        h();
        if (this.a.E().M(com.google.android.gms.common.c.a) != 0) {
            this.a.a().p().a("Not bundling data. Service unavailable or out of date");
            this.a.E().S(zzsVar, new byte[0]);
            return;
        }
        C(new q7(this, zzasVar, str, zzsVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean t() {
        f();
        h();
        if (this.a.x().u(null, x2.y0)) {
            return !p() || this.a.E().L() >= x2.z0.b(null).intValue();
        }
        return false;
    }
}
