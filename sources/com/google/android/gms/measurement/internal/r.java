package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class r implements Parcelable.Creator<zzas> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(zzas zzasVar, Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, zzasVar.zza, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 3, zzasVar.zzb, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 4, zzasVar.zzc, false);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 5, zzasVar.zzd);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzas createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        zzaq zzaqVar = null;
        String str2 = null;
        long j2 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 2) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v == 3) {
                zzaqVar = (zzaq) SafeParcelReader.o(parcel, D, zzaq.CREATOR);
            } else if (v == 4) {
                str2 = SafeParcelReader.p(parcel, D);
            } else if (v != 5) {
                SafeParcelReader.M(parcel, D);
            } else {
                j2 = SafeParcelReader.I(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzas(str, zzaqVar, str2, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzas[] newArray(int i2) {
        return new zzas[i2];
    }
}
