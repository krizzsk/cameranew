package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class m implements Parcelable.Creator<PointOfInterest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PointOfInterest createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 2) {
                latLng = (LatLng) SafeParcelReader.o(parcel, D, LatLng.CREATOR);
            } else if (v == 3) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v != 4) {
                SafeParcelReader.M(parcel, D);
            } else {
                str2 = SafeParcelReader.p(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new PointOfInterest(latLng, str, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PointOfInterest[] newArray(int i2) {
        return new PointOfInterest[i2];
    }
}
