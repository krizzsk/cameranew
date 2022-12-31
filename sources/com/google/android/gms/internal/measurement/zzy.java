package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new zzz();
    public final long zza;
    public final long zzb;
    public final boolean zzc;
    @Nullable
    public final String zzd;
    @Nullable
    public final String zze;
    @Nullable
    public final String zzf;
    @Nullable
    public final Bundle zzg;
    @Nullable
    public final String zzh;

    public zzy(long j2, long j3, boolean z, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Bundle bundle, @Nullable String str4) {
        this.zza = j2;
        this.zzb = j3;
        this.zzc = z;
        this.zzd = str;
        this.zze = str2;
        this.zzf = str3;
        this.zzg = bundle;
        this.zzh = str4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.q(parcel, 1, this.zza);
        a.q(parcel, 2, this.zzb);
        a.c(parcel, 3, this.zzc);
        a.v(parcel, 4, this.zzd, false);
        a.v(parcel, 5, this.zze, false);
        a.v(parcel, 6, this.zzf, false);
        a.e(parcel, 7, this.zzg, false);
        a.v(parcel, 8, this.zzh, false);
        a.b(parcel, a);
    }
}
