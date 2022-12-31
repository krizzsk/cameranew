package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class n implements Parcelable.Creator<LocationSettingsResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsResult createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        Status status = null;
        LocationSettingsStates locationSettingsStates = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                status = (Status) SafeParcelReader.o(parcel, D, Status.CREATOR);
            } else if (v != 2) {
                SafeParcelReader.M(parcel, D);
            } else {
                locationSettingsStates = (LocationSettingsStates) SafeParcelReader.o(parcel, D, LocationSettingsStates.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new LocationSettingsResult(status, locationSettingsStates);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsResult[] newArray(int i2) {
        return new LocationSettingsResult[i2];
    }
}
