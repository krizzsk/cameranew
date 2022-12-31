package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class zzp implements Parcelable.Creator<zzo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        zzm zzmVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        int i2 = 1;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v == 2) {
                zzmVar = (zzm) SafeParcelReader.o(parcel, D, zzm.CREATOR);
            } else if (v == 3) {
                iBinder = SafeParcelReader.E(parcel, D);
            } else if (v != 4) {
                SafeParcelReader.M(parcel, D);
            } else {
                iBinder2 = SafeParcelReader.E(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzo(i2, zzmVar, iBinder, iBinder2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo[] newArray(int i2) {
        return new zzo[i2];
    }
}
