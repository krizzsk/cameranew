package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class h implements Parcelable.Creator<LocationAvailability> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationAvailability createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        long j2 = 0;
        zzaj[] zzajVarArr = null;
        int i2 = 1000;
        int i3 = 1;
        int i4 = 1;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i3 = SafeParcelReader.F(parcel, D);
            } else if (v == 2) {
                i4 = SafeParcelReader.F(parcel, D);
            } else if (v == 3) {
                j2 = SafeParcelReader.I(parcel, D);
            } else if (v == 4) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v != 5) {
                SafeParcelReader.M(parcel, D);
            } else {
                zzajVarArr = (zzaj[]) SafeParcelReader.s(parcel, D, zzaj.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new LocationAvailability(i2, i3, i4, j2, zzajVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationAvailability[] newArray(int i2) {
        return new LocationAvailability[i2];
    }
}
