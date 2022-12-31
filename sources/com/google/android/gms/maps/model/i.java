package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* loaded from: classes2.dex */
public final class i implements Parcelable.Creator<LatLng> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LatLng createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d3 = 0.0d;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 2) {
                d2 = SafeParcelReader.z(parcel, D);
            } else if (v != 3) {
                SafeParcelReader.M(parcel, D);
            } else {
                d3 = SafeParcelReader.z(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new LatLng(d2, d3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LatLng[] newArray(int i2) {
        return new LatLng[i2];
    }
}
