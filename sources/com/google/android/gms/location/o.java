package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class o implements Parcelable.Creator<LocationSettingsStates> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsStates createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 2:
                    z2 = SafeParcelReader.w(parcel, D);
                    break;
                case 3:
                    z3 = SafeParcelReader.w(parcel, D);
                    break;
                case 4:
                    z4 = SafeParcelReader.w(parcel, D);
                    break;
                case 5:
                    z5 = SafeParcelReader.w(parcel, D);
                    break;
                case 6:
                    z6 = SafeParcelReader.w(parcel, D);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new LocationSettingsStates(z, z2, z3, z4, z5, z6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsStates[] newArray(int i2) {
        return new LocationSettingsStates[i2];
    }
}
