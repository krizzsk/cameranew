package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class t implements Parcelable.Creator<StreetViewSource> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewSource createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            if (SafeParcelReader.v(D) != 2) {
                SafeParcelReader.M(parcel, D);
            } else {
                i2 = SafeParcelReader.F(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new StreetViewSource(i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewSource[] newArray(int i2) {
        return new StreetViewSource[i2];
    }
}
