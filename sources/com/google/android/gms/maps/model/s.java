package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class s implements Parcelable.Creator<StreetViewPanoramaOrientation> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaOrientation createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 2) {
                f2 = SafeParcelReader.B(parcel, D);
            } else if (v != 3) {
                SafeParcelReader.M(parcel, D);
            } else {
                f3 = SafeParcelReader.B(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new StreetViewPanoramaOrientation(f2, f3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaOrientation[] newArray(int i2) {
        return new StreetViewPanoramaOrientation[i2];
    }
}
