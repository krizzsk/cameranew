package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class j implements Parcelable.Creator<MapStyleOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MapStyleOptions createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            if (SafeParcelReader.v(D) != 2) {
                SafeParcelReader.M(parcel, D);
            } else {
                str = SafeParcelReader.p(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new MapStyleOptions(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MapStyleOptions[] newArray(int i2) {
        return new MapStyleOptions[i2];
    }
}
