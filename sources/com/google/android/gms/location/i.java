package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class i implements Parcelable.Creator<LocationRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationRequest createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        long j2 = 3600000;
        long j3 = 600000;
        long j4 = Long.MAX_VALUE;
        long j5 = 0;
        int i2 = 102;
        boolean z = false;
        int i3 = Integer.MAX_VALUE;
        float f2 = 0.0f;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 2:
                    j2 = SafeParcelReader.I(parcel, D);
                    break;
                case 3:
                    j3 = SafeParcelReader.I(parcel, D);
                    break;
                case 4:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 5:
                    j4 = SafeParcelReader.I(parcel, D);
                    break;
                case 6:
                    i3 = SafeParcelReader.F(parcel, D);
                    break;
                case 7:
                    f2 = SafeParcelReader.B(parcel, D);
                    break;
                case 8:
                    j5 = SafeParcelReader.I(parcel, D);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new LocationRequest(i2, j2, j3, z, j4, i3, f2, j5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationRequest[] newArray(int i2) {
        return new LocationRequest[i2];
    }
}
