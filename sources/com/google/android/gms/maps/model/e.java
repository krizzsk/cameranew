package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class e implements Parcelable.Creator<Cap> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Cap createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        IBinder iBinder = null;
        Float f2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 2) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v == 3) {
                iBinder = SafeParcelReader.E(parcel, D);
            } else if (v != 4) {
                SafeParcelReader.M(parcel, D);
            } else {
                f2 = SafeParcelReader.C(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new Cap(i2, iBinder, f2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Cap[] newArray(int i2) {
        return new Cap[i2];
    }
}
