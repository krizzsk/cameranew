package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;
/* loaded from: classes2.dex */
public final class j implements Parcelable.Creator<LocationResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationResult createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        List<Location> list = LocationResult.a;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            if (SafeParcelReader.v(D) != 1) {
                SafeParcelReader.M(parcel, D);
            } else {
                list = SafeParcelReader.t(parcel, D, Location.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new LocationResult(list);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationResult[] newArray(int i2) {
        return new LocationResult[i2];
    }
}
