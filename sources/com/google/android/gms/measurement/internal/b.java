package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class b implements Parcelable.Creator<zzaa> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzaa createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        String str = null;
        String str2 = null;
        zzkg zzkgVar = null;
        String str3 = null;
        zzas zzasVar = null;
        zzas zzasVar2 = null;
        zzas zzasVar3 = null;
        boolean z = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 2:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 3:
                    str2 = SafeParcelReader.p(parcel, D);
                    break;
                case 4:
                    zzkgVar = (zzkg) SafeParcelReader.o(parcel, D, zzkg.CREATOR);
                    break;
                case 5:
                    j2 = SafeParcelReader.I(parcel, D);
                    break;
                case 6:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 7:
                    str3 = SafeParcelReader.p(parcel, D);
                    break;
                case 8:
                    zzasVar = (zzas) SafeParcelReader.o(parcel, D, zzas.CREATOR);
                    break;
                case 9:
                    j3 = SafeParcelReader.I(parcel, D);
                    break;
                case 10:
                    zzasVar2 = (zzas) SafeParcelReader.o(parcel, D, zzas.CREATOR);
                    break;
                case 11:
                    j4 = SafeParcelReader.I(parcel, D);
                    break;
                case 12:
                    zzasVar3 = (zzas) SafeParcelReader.o(parcel, D, zzas.CREATOR);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzaa(str, str2, zzkgVar, j2, z, str3, zzasVar, j3, zzasVar2, j4, zzasVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzaa[] newArray(int i2) {
        return new zzaa[i2];
    }
}
