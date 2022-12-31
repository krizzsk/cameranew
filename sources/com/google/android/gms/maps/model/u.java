package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class u implements Parcelable.Creator<Tile> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Tile createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        int i2 = 0;
        byte[] bArr = null;
        int i3 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 2) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v == 3) {
                i3 = SafeParcelReader.F(parcel, D);
            } else if (v != 4) {
                SafeParcelReader.M(parcel, D);
            } else {
                bArr = SafeParcelReader.g(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new Tile(i2, i3, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Tile[] newArray(int i2) {
        return new Tile[i2];
    }
}
