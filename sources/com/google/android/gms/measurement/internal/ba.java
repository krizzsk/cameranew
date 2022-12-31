package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzby;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzdu;
import com.google.android.gms.internal.measurement.zzlo;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class ba extends aa {

    /* renamed from: g  reason: collision with root package name */
    private final zzcf f3753g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ ca f3754h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(ca caVar, String str, int i2, zzcf zzcfVar) {
        super(str, i2);
        this.f3754h = caVar;
        this.f3753g = zzcfVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.aa
    public final int a() {
        return this.f3753g.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.aa
    public final boolean b() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.aa
    public final boolean c() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k(Long l2, Long l3, zzdu zzduVar, boolean z) {
        zzlo.zzb();
        boolean u = this.f3754h.a.x().u(this.a, x2.Z);
        boolean zze = this.f3753g.zze();
        boolean zzf = this.f3753g.zzf();
        boolean zzh = this.f3753g.zzh();
        boolean z2 = zze || zzf || zzh;
        Boolean bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (z && !z2) {
            this.f3754h.a.a().u().c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.b), this.f3753g.zza() ? Integer.valueOf(this.f3753g.zzb()) : null);
            return true;
        }
        zzby zzd = this.f3753g.zzd();
        boolean zzf2 = zzd.zzf();
        if (zzduVar.zzf()) {
            if (!zzd.zzc()) {
                this.f3754h.a.a().p().b("No number filter for long property. property", this.f3754h.a.F().p(zzduVar.zzc()));
            } else {
                bool = aa.e(aa.g(zzduVar.zzg(), zzd.zzd()), zzf2);
            }
        } else if (zzduVar.zzh()) {
            if (!zzd.zzc()) {
                this.f3754h.a.a().p().b("No number filter for double property. property", this.f3754h.a.F().p(zzduVar.zzc()));
            } else {
                bool = aa.e(aa.h(zzduVar.zzi(), zzd.zzd()), zzf2);
            }
        } else if (zzduVar.zzd()) {
            if (!zzd.zza()) {
                if (!zzd.zzc()) {
                    this.f3754h.a.a().p().b("No string or number filter defined. property", this.f3754h.a.F().p(zzduVar.zzc()));
                } else if (j9.z(zzduVar.zze())) {
                    bool = aa.e(aa.i(zzduVar.zze(), zzd.zzd()), zzf2);
                } else {
                    this.f3754h.a.a().p().c("Invalid user property value for Numeric number filter. property, value", this.f3754h.a.F().p(zzduVar.zzc()), zzduVar.zze());
                }
            } else {
                bool = aa.e(aa.f(zzduVar.zze(), zzd.zzb(), this.f3754h.a.a()), zzf2);
            }
        } else {
            this.f3754h.a.a().p().b("User property has no value, property", this.f3754h.a.F().p(zzduVar.zzc()));
        }
        this.f3754h.a.a().u().b("Property filter result", bool == null ? "null" : bool);
        if (bool == null) {
            return false;
        }
        this.c = Boolean.TRUE;
        if (!zzh || bool.booleanValue()) {
            if (!z || this.f3753g.zze()) {
                this.f3750d = bool;
            }
            if (bool.booleanValue() && z2 && zzduVar.zza()) {
                long zzb = zzduVar.zzb();
                if (l2 != null) {
                    zzb = l2.longValue();
                }
                if (u && this.f3753g.zze() && !this.f3753g.zzf() && l3 != null) {
                    zzb = l3.longValue();
                }
                if (this.f3753g.zzf()) {
                    this.f3752f = Long.valueOf(zzb);
                } else {
                    this.f3751e = Long.valueOf(zzb);
                }
            }
            return true;
        }
        return true;
    }
}
