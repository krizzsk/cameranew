package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.BinderThread;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.firebase.messaging.Constants;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class h5 extends z2 {
    private final i9 a;
    private Boolean b;
    private String c;

    public h5(i9 i9Var, String str) {
        com.google.android.gms.common.internal.q.j(i9Var);
        this.a = i9Var;
        this.c = null;
    }

    @BinderThread
    private final void B0(zzp zzpVar, boolean z) {
        com.google.android.gms.common.internal.q.j(zzpVar);
        com.google.android.gms.common.internal.q.f(zzpVar.zza);
        C0(zzpVar.zza, false);
        this.a.e0().m(zzpVar.zzb, zzpVar.zzq, zzpVar.zzu);
    }

    @BinderThread
    private final void C0(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.b == null) {
                        if (!"com.google.android.gms".equals(this.c) && !com.google.android.gms.common.util.t.a(this.a.zzaw(), Binder.getCallingUid()) && !com.google.android.gms.common.d.a(this.a.zzaw()).c(Binder.getCallingUid())) {
                            z2 = false;
                            this.b = Boolean.valueOf(z2);
                        }
                        z2 = true;
                        this.b = Boolean.valueOf(z2);
                    }
                    if (this.b.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e2) {
                    this.a.a().m().b("Measurement Service called with invalid calling package. appId", k3.v(str));
                    throw e2;
                }
            }
            if (this.c == null && com.google.android.gms.common.c.k(this.a.zzaw(), Binder.getCallingUid(), str)) {
                this.c = str;
            }
            if (str.equals(this.c)) {
                return;
            }
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
        this.a.a().m().a("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final void C(zzas zzasVar, zzp zzpVar) {
        com.google.android.gms.common.internal.q.j(zzasVar);
        B0(zzpVar, false);
        y0(new z4(this, zzasVar, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final List<zzkg> E(String str, String str2, String str3, boolean z) {
        C0(str, true);
        try {
            List<l9> list = (List) this.a.c().n(new t4(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (l9 l9Var : list) {
                if (z || !n9.D(l9Var.c)) {
                    arrayList.add(new zzkg(l9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.a.a().m().c("Failed to get user properties as. appId", k3.v(str), e2);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final void H(zzp zzpVar) {
        zzlc.zzb();
        if (this.a.U().u(null, x2.y0)) {
            com.google.android.gms.common.internal.q.f(zzpVar.zza);
            com.google.android.gms.common.internal.q.j(zzpVar.zzv);
            y4 y4Var = new y4(this, zzpVar);
            com.google.android.gms.common.internal.q.j(y4Var);
            if (this.a.c().m()) {
                y4Var.run();
            } else {
                this.a.c().r(y4Var);
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final void S(long j2, String str, String str2, String str3) {
        y0(new g5(this, str2, str3, str, j2));
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final List<zzkg> U(zzp zzpVar, boolean z) {
        B0(zzpVar, false);
        String str = zzpVar.zza;
        com.google.android.gms.common.internal.q.j(str);
        try {
            List<l9> list = (List) this.a.c().n(new e5(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (l9 l9Var : list) {
                if (z || !n9.D(l9Var.c)) {
                    arrayList.add(new zzkg(l9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.a.a().m().c("Failed to get user properties. appId", k3.v(zzpVar.zza), e2);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final void W(zzp zzpVar) {
        com.google.android.gms.common.internal.q.f(zzpVar.zza);
        C0(zzpVar.zza, false);
        y0(new w4(this, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final void c0(final Bundle bundle, zzp zzpVar) {
        B0(zzpVar, false);
        final String str = zzpVar.zza;
        com.google.android.gms.common.internal.q.j(str);
        y0(new Runnable(this, str, bundle) { // from class: com.google.android.gms.measurement.internal.p4
            private final h5 a;
            private final String b;
            private final Bundle c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = str;
                this.c = bundle;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.z0(this.b, this.c);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final void d0(zzas zzasVar, String str, String str2) {
        com.google.android.gms.common.internal.q.j(zzasVar);
        com.google.android.gms.common.internal.q.f(str);
        C0(str, true);
        y0(new a5(this, zzasVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final byte[] e0(zzas zzasVar, String str) {
        com.google.android.gms.common.internal.q.f(str);
        com.google.android.gms.common.internal.q.j(zzasVar);
        C0(str, true);
        this.a.a().t().b("Log and bundle. event", this.a.d0().n(zzasVar.zza));
        long b = this.a.zzax().b() / 1000000;
        try {
            byte[] bArr = (byte[]) this.a.c().o(new b5(this, zzasVar, str)).get();
            if (bArr == null) {
                this.a.a().m().b("Log and bundle returned null. appId", k3.v(str));
                bArr = new byte[0];
            }
            this.a.a().t().d("Log and bundle processed. event, size, time_ms", this.a.d0().n(zzasVar.zza), Integer.valueOf(bArr.length), Long.valueOf((this.a.zzax().b() / 1000000) - b));
            return bArr;
        } catch (InterruptedException | ExecutionException e2) {
            this.a.a().m().d("Failed to log and bundle. appId, event, error", k3.v(str), this.a.d0().n(zzasVar.zza), e2);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final List<zzaa> k(String str, String str2, zzp zzpVar) {
        B0(zzpVar, false);
        String str3 = zzpVar.zza;
        com.google.android.gms.common.internal.q.j(str3);
        try {
            return (List) this.a.c().n(new u4(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.a.a().m().b("Failed to get conditional user properties", e2);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final void k0(zzp zzpVar) {
        B0(zzpVar, false);
        y0(new x4(this, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final String m(zzp zzpVar) {
        B0(zzpVar, false);
        return this.a.B(zzpVar);
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final void n(zzaa zzaaVar, zzp zzpVar) {
        com.google.android.gms.common.internal.q.j(zzaaVar);
        com.google.android.gms.common.internal.q.j(zzaaVar.zzc);
        B0(zzpVar, false);
        zzaa zzaaVar2 = new zzaa(zzaaVar);
        zzaaVar2.zza = zzpVar.zza;
        y0(new q4(this, zzaaVar2, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final List<zzkg> o(String str, String str2, boolean z, zzp zzpVar) {
        B0(zzpVar, false);
        String str3 = zzpVar.zza;
        com.google.android.gms.common.internal.q.j(str3);
        try {
            List<l9> list = (List) this.a.c().n(new s4(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (l9 l9Var : list) {
                if (z || !n9.D(l9Var.c)) {
                    arrayList.add(new zzkg(l9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.a.a().m().c("Failed to query user properties. appId", k3.v(zzpVar.zza), e2);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final List<zzaa> p(String str, String str2, String str3) {
        C0(str, true);
        try {
            return (List) this.a.c().n(new v4(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.a.a().m().b("Failed to get conditional user properties as", e2);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final void s(zzaa zzaaVar) {
        com.google.android.gms.common.internal.q.j(zzaaVar);
        com.google.android.gms.common.internal.q.j(zzaaVar.zzc);
        com.google.android.gms.common.internal.q.f(zzaaVar.zza);
        C0(zzaaVar.zza, true);
        y0(new r4(this, new zzaa(zzaaVar)));
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final void t0(zzp zzpVar) {
        B0(zzpVar, false);
        y0(new f5(this, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.a3
    @BinderThread
    public final void x(zzkg zzkgVar, zzp zzpVar) {
        com.google.android.gms.common.internal.q.j(zzkgVar);
        B0(zzpVar, false);
        y0(new c5(this, zzkgVar, zzpVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzas x0(zzas zzasVar, zzp zzpVar) {
        zzaq zzaqVar;
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzasVar.zza) && (zzaqVar = zzasVar.zzb) != null && zzaqVar.Q() != 0) {
            String n = zzasVar.zzb.n("_cis");
            if ("referrer broadcast".equals(n) || "referrer API".equals(n)) {
                this.a.a().s().b("Event has been filtered ", zzasVar.toString());
                return new zzas("_cmpx", zzasVar.zzb, zzasVar.zzc, zzasVar.zzd);
            }
        }
        return zzasVar;
    }

    final void y0(Runnable runnable) {
        com.google.android.gms.common.internal.q.j(runnable);
        if (this.a.c().m()) {
            runnable.run();
        } else {
            this.a.c().p(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void z0(String str, Bundle bundle) {
        i X = this.a.X();
        X.f();
        X.h();
        byte[] zzbp = X.b.c0().u(new n(X.a, "", str, "dep", 0L, 0L, bundle)).zzbp();
        X.a.a().u().c("Saving default event parameters, appId, data size", X.a.F().n(str), Integer.valueOf(zzbp.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put(TapjoyConstants.TJC_APP_ID, str);
        contentValues.put("parameters", zzbp);
        try {
            if (X.L().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                X.a.a().m().b("Failed to insert default event parameters (got -1). appId", k3.v(str));
            }
        } catch (SQLiteException e2) {
            X.a.a().m().c("Error storing default event parameters. appId", k3.v(str), e2);
        }
    }
}
