package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class x implements Parcelable.Creator<VisibleRegion> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ VisibleRegion createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        LatLngBounds latLngBounds = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 2) {
                latLng = (LatLng) SafeParcelReader.o(parcel, D, LatLng.CREATOR);
            } else if (v == 3) {
                latLng2 = (LatLng) SafeParcelReader.o(parcel, D, LatLng.CREATOR);
            } else if (v == 4) {
                latLng3 = (LatLng) SafeParcelReader.o(parcel, D, LatLng.CREATOR);
            } else if (v == 5) {
                latLng4 = (LatLng) SafeParcelReader.o(parcel, D, LatLng.CREATOR);
            } else if (v != 6) {
                SafeParcelReader.M(parcel, D);
            } else {
                latLngBounds = (LatLngBounds) SafeParcelReader.o(parcel, D, LatLngBounds.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new VisibleRegion(latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ VisibleRegion[] newArray(int i2) {
        return new VisibleRegion[i2];
    }
}
