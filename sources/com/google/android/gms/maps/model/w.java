package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class w implements Parcelable.Creator<TileOverlayOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TileOverlayOptions createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        IBinder iBinder = null;
        boolean z = false;
        float f2 = 0.0f;
        boolean z2 = true;
        float f3 = 0.0f;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 2) {
                iBinder = SafeParcelReader.E(parcel, D);
            } else if (v == 3) {
                z = SafeParcelReader.w(parcel, D);
            } else if (v == 4) {
                f2 = SafeParcelReader.B(parcel, D);
            } else if (v == 5) {
                z2 = SafeParcelReader.w(parcel, D);
            } else if (v != 6) {
                SafeParcelReader.M(parcel, D);
            } else {
                f3 = SafeParcelReader.B(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new TileOverlayOptions(iBinder, z, f2, z2, f3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TileOverlayOptions[] newArray(int i2) {
        return new TileOverlayOptions[i2];
    }
}
