package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new d();
    private final int zza;
    private final long zzb;
    private int zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final int zzg;
    private final List<String> zzh;
    private final String zzi;
    private final long zzj;
    private int zzk;
    private final String zzl;
    private final float zzm;
    private final long zzn;
    private final boolean zzo;
    private long zzp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WakeLockEvent(int i2, long j2, int i3, String str, int i4, List<String> list, String str2, long j3, int i5, String str3, String str4, float f2, long j4, String str5, boolean z) {
        this.zza = i2;
        this.zzb = j2;
        this.zzc = i3;
        this.zzd = str;
        this.zze = str3;
        this.zzf = str5;
        this.zzg = i4;
        this.zzp = -1L;
        this.zzh = list;
        this.zzi = str2;
        this.zzj = j3;
        this.zzk = i5;
        this.zzl = str4;
        this.zzm = f2;
        this.zzn = j4;
        this.zzo = z;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long Q() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int R() {
        return this.zzc;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long S() {
        return this.zzp;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String T() {
        String str = this.zzd;
        int i2 = this.zzg;
        List<String> list = this.zzh;
        String join = list == null ? "" : TextUtils.join(",", list);
        int i3 = this.zzk;
        String str2 = this.zze;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.zzl;
        if (str3 == null) {
            str3 = "";
        }
        float f2 = this.zzm;
        String str4 = this.zzf;
        String str5 = str4 != null ? str4 : "";
        boolean z = this.zzo;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(join).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str5).length());
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i3);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(f2);
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zza);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 2, Q());
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 4, this.zzd, false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 5, this.zzg);
        com.google.android.gms.common.internal.safeparcel.a.x(parcel, 6, this.zzh, false);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 8, this.zzj);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 10, this.zze, false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 11, R());
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 12, this.zzi, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 13, this.zzl, false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 14, this.zzk);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 15, this.zzm);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 16, this.zzn);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 17, this.zzf, false);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 18, this.zzo);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public WakeLockEvent(long j2, int i2, String str, int i3, List<String> list, String str2, long j3, int i4, String str3, String str4, float f2, long j4, String str5, boolean z) {
        this(2, j2, i2, str, i3, list, str2, j3, i4, str3, str4, f2, j4, str5, z);
    }
}
