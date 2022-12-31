package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR = new u9();
    @Nullable
    public final String zza;
    @Nullable
    public final String zzb;
    @Nullable
    public final String zzc;
    @Nullable
    public final String zzd;
    public final long zze;
    public final long zzf;
    @Nullable
    public final String zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final long zzj;
    @Nullable
    public final String zzk;
    public final long zzl;
    public final long zzm;
    public final int zzn;
    public final boolean zzo;
    public final boolean zzp;
    @Nullable
    public final String zzq;
    @Nullable
    public final Boolean zzr;
    public final long zzs;
    @Nullable
    public final List<String> zzt;
    @Nullable
    public final String zzu;
    public final String zzv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(@Nullable String str, @Nullable String str2, @Nullable String str3, long j2, @Nullable String str4, long j3, long j4, @Nullable String str5, boolean z, boolean z2, @Nullable String str6, long j5, long j6, int i2, boolean z3, boolean z4, @Nullable String str7, @Nullable Boolean bool, long j7, @Nullable List<String> list, @Nullable String str8, String str9) {
        com.google.android.gms.common.internal.q.f(str);
        this.zza = str;
        this.zzb = true != TextUtils.isEmpty(str2) ? str2 : null;
        this.zzc = str3;
        this.zzj = j2;
        this.zzd = str4;
        this.zze = j3;
        this.zzf = j4;
        this.zzg = str5;
        this.zzh = z;
        this.zzi = z2;
        this.zzk = str6;
        this.zzl = j5;
        this.zzm = j6;
        this.zzn = i2;
        this.zzo = z3;
        this.zzp = z4;
        this.zzq = str7;
        this.zzr = bool;
        this.zzs = j7;
        this.zzt = list;
        this.zzu = str8;
        this.zzv = str9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, this.zza, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 3, this.zzb, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 4, this.zzc, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 5, this.zzd, false);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 6, this.zze);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 7, this.zzf);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 8, this.zzg, false);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 9, this.zzh);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 10, this.zzi);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 11, this.zzj);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 12, this.zzk, false);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 13, this.zzl);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 14, this.zzm);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 15, this.zzn);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 16, this.zzo);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 18, this.zzp);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 19, this.zzq, false);
        com.google.android.gms.common.internal.safeparcel.a.d(parcel, 21, this.zzr, false);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 22, this.zzs);
        com.google.android.gms.common.internal.safeparcel.a.x(parcel, 23, this.zzt, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 24, this.zzu, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 25, this.zzv, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, long j2, long j3, @Nullable String str5, boolean z, boolean z2, long j4, @Nullable String str6, long j5, long j6, int i2, boolean z3, boolean z4, @Nullable String str7, @Nullable Boolean bool, long j7, @Nullable List<String> list, @Nullable String str8, String str9) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzj = j4;
        this.zzd = str4;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = str5;
        this.zzh = z;
        this.zzi = z2;
        this.zzk = str6;
        this.zzl = j5;
        this.zzm = j6;
        this.zzn = i2;
        this.zzo = z3;
        this.zzp = z4;
        this.zzq = str7;
        this.zzr = bool;
        this.zzs = j7;
        this.zzt = list;
        this.zzu = str8;
        this.zzv = str9;
    }
}
