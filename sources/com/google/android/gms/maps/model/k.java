package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class k implements Parcelable.Creator<MarkerOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MarkerOptions createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f4 = 0.0f;
        float f5 = 0.5f;
        float f6 = 0.0f;
        float f7 = 1.0f;
        float f8 = 0.0f;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 2:
                    latLng = (LatLng) SafeParcelReader.o(parcel, D, LatLng.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 4:
                    str2 = SafeParcelReader.p(parcel, D);
                    break;
                case 5:
                    iBinder = SafeParcelReader.E(parcel, D);
                    break;
                case 6:
                    f2 = SafeParcelReader.B(parcel, D);
                    break;
                case 7:
                    f3 = SafeParcelReader.B(parcel, D);
                    break;
                case 8:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 9:
                    z2 = SafeParcelReader.w(parcel, D);
                    break;
                case 10:
                    z3 = SafeParcelReader.w(parcel, D);
                    break;
                case 11:
                    f4 = SafeParcelReader.B(parcel, D);
                    break;
                case 12:
                    f5 = SafeParcelReader.B(parcel, D);
                    break;
                case 13:
                    f6 = SafeParcelReader.B(parcel, D);
                    break;
                case 14:
                    f7 = SafeParcelReader.B(parcel, D);
                    break;
                case 15:
                    f8 = SafeParcelReader.B(parcel, D);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new MarkerOptions(latLng, str, str2, iBinder, f2, f3, z, z2, z3, f4, f5, f6, f7, f8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MarkerOptions[] newArray(int i2) {
        return new MarkerOptions[i2];
    }
}
