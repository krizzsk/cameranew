package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class k9 implements Parcelable.Creator<zzkg> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(zzkg zzkgVar, Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, zzkgVar.zza);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, zzkgVar.zzb, false);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 3, zzkgVar.zzc);
        com.google.android.gms.common.internal.safeparcel.a.r(parcel, 4, zzkgVar.zzd, false);
        com.google.android.gms.common.internal.safeparcel.a.k(parcel, 5, null, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 6, zzkgVar.zze, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 7, zzkgVar.zzf, false);
        com.google.android.gms.common.internal.safeparcel.a.i(parcel, 8, zzkgVar.zzg, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzkg createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        Long l2 = null;
        Float f2 = null;
        String str2 = null;
        String str3 = null;
        Double d2 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 2:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 3:
                    j2 = SafeParcelReader.I(parcel, D);
                    break;
                case 4:
                    l2 = SafeParcelReader.J(parcel, D);
                    break;
                case 5:
                    f2 = SafeParcelReader.C(parcel, D);
                    break;
                case 6:
                    str2 = SafeParcelReader.p(parcel, D);
                    break;
                case 7:
                    str3 = SafeParcelReader.p(parcel, D);
                    break;
                case 8:
                    d2 = SafeParcelReader.A(parcel, D);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzkg(i2, str, j2, l2, f2, str2, str3, d2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzkg[] newArray(int i2) {
        return new zzkg[i2];
    }
}
