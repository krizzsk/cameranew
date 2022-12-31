package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzs;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class h7 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ zzp c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f3816d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzs f3817e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ g8 f3818f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h7(g8 g8Var, String str, String str2, zzp zzpVar, boolean z, zzs zzsVar) {
        this.f3818f = g8Var;
        this.a = str;
        this.b = str2;
        this.c = zzpVar;
        this.f3816d = z;
        this.f3817e = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        RemoteException e2;
        a3 a3Var;
        Bundle bundle2 = new Bundle();
        try {
            a3Var = this.f3818f.f3807d;
            if (a3Var == null) {
                this.f3818f.a.a().m().c("Failed to get user properties; not connected to service", this.a, this.b);
                this.f3818f.a.E().U(this.f3817e, bundle2);
                return;
            }
            com.google.android.gms.common.internal.q.j(this.c);
            List<zzkg> o = a3Var.o(this.a, this.b, this.f3816d, this.c);
            bundle = new Bundle();
            if (o != null) {
                for (zzkg zzkgVar : o) {
                    String str = zzkgVar.zze;
                    if (str != null) {
                        bundle.putString(zzkgVar.zzb, str);
                    } else {
                        Long l2 = zzkgVar.zzd;
                        if (l2 != null) {
                            bundle.putLong(zzkgVar.zzb, l2.longValue());
                        } else {
                            Double d2 = zzkgVar.zzg;
                            if (d2 != null) {
                                bundle.putDouble(zzkgVar.zzb, d2.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                try {
                    this.f3818f.B();
                    this.f3818f.a.E().U(this.f3817e, bundle);
                } catch (RemoteException e3) {
                    e2 = e3;
                    this.f3818f.a.a().m().c("Failed to get user properties; remote exception", this.a, e2);
                    this.f3818f.a.E().U(this.f3817e, bundle);
                }
            } catch (Throwable th) {
                th = th;
                bundle2 = bundle;
                this.f3818f.a.E().U(this.f3817e, bundle2);
                throw th;
            }
        } catch (RemoteException e4) {
            bundle = bundle2;
            e2 = e4;
        } catch (Throwable th2) {
            th = th2;
            this.f3818f.a.E().U(this.f3817e, bundle2);
            throw th;
        }
    }
}
