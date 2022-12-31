package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaeg implements Parcelable.Creator<zzaeh> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaeh createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        zzaau zzaauVar = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        boolean z3 = false;
        int i5 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 2:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 3:
                    i3 = SafeParcelReader.F(parcel, D);
                    break;
                case 4:
                    z2 = SafeParcelReader.w(parcel, D);
                    break;
                case 5:
                    i4 = SafeParcelReader.F(parcel, D);
                    break;
                case 6:
                    zzaauVar = (zzaau) SafeParcelReader.o(parcel, D, zzaau.CREATOR);
                    break;
                case 7:
                    z3 = SafeParcelReader.w(parcel, D);
                    break;
                case 8:
                    i5 = SafeParcelReader.F(parcel, D);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzaeh(i2, z, i3, z2, i4, zzaauVar, z3, i5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaeh[] newArray(int i2) {
        return new zzaeh[i2];
    }
}
