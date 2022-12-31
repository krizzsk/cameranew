package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class d implements Parcelable.Creator<CameraPosition> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CameraPosition createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        float f2 = 0.0f;
        LatLng latLng = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 2) {
                latLng = (LatLng) SafeParcelReader.o(parcel, D, LatLng.CREATOR);
            } else if (v == 3) {
                f2 = SafeParcelReader.B(parcel, D);
            } else if (v == 4) {
                f3 = SafeParcelReader.B(parcel, D);
            } else if (v != 5) {
                SafeParcelReader.M(parcel, D);
            } else {
                f4 = SafeParcelReader.B(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new CameraPosition(latLng, f2, f3, f4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CameraPosition[] newArray(int i2) {
        return new CameraPosition[i2];
    }
}
