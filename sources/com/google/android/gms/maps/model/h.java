package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class h implements Parcelable.Creator<LatLngBounds> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LatLngBounds createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        LatLng latLng = null;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 2) {
                latLng = (LatLng) SafeParcelReader.o(parcel, D, LatLng.CREATOR);
            } else if (v != 3) {
                SafeParcelReader.M(parcel, D);
            } else {
                latLng2 = (LatLng) SafeParcelReader.o(parcel, D, LatLng.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new LatLngBounds(latLng, latLng2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LatLngBounds[] newArray(int i2) {
        return new LatLngBounds[i2];
    }
}
