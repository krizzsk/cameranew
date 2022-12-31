package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaa> CREATOR = new b();
    @Nullable
    public String zza;
    public String zzb;
    public zzkg zzc;
    public long zzd;
    public boolean zze;
    @Nullable
    public String zzf;
    @Nullable
    public final zzas zzg;
    public long zzh;
    @Nullable
    public zzas zzi;
    public final long zzj;
    @Nullable
    public final zzas zzk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(zzaa zzaaVar) {
        com.google.android.gms.common.internal.q.j(zzaaVar);
        this.zza = zzaaVar.zza;
        this.zzb = zzaaVar.zzb;
        this.zzc = zzaaVar.zzc;
        this.zzd = zzaaVar.zzd;
        this.zze = zzaaVar.zze;
        this.zzf = zzaaVar.zzf;
        this.zzg = zzaaVar.zzg;
        this.zzh = zzaaVar.zzh;
        this.zzi = zzaaVar.zzi;
        this.zzj = zzaaVar.zzj;
        this.zzk = zzaaVar.zzk;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, this.zza, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 3, this.zzb, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 4, this.zzc, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 5, this.zzd);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 6, this.zze);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 7, this.zzf, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 8, this.zzg, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 9, this.zzh);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 10, this.zzi, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 11, this.zzj);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 12, this.zzk, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(@Nullable String str, String str2, zzkg zzkgVar, long j2, boolean z, @Nullable String str3, @Nullable zzas zzasVar, long j3, @Nullable zzas zzasVar2, long j4, @Nullable zzas zzasVar3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzkgVar;
        this.zzd = j2;
        this.zze = z;
        this.zzf = str3;
        this.zzg = zzasVar;
        this.zzh = j3;
        this.zzi = zzasVar2;
        this.zzj = j4;
        this.zzk = zzasVar3;
    }
}
