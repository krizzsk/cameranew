package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class g implements Parcelable.Creator<GroundOverlayOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GroundOverlayOptions createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        IBinder iBinder = null;
        LatLng latLng = null;
        LatLngBounds latLngBounds = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        boolean z = false;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        boolean z2 = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 2:
                    iBinder = SafeParcelReader.E(parcel, D);
                    break;
                case 3:
                    latLng = (LatLng) SafeParcelReader.o(parcel, D, LatLng.CREATOR);
                    break;
                case 4:
                    f2 = SafeParcelReader.B(parcel, D);
                    break;
                case 5:
                    f3 = SafeParcelReader.B(parcel, D);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) SafeParcelReader.o(parcel, D, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f4 = SafeParcelReader.B(parcel, D);
                    break;
                case 8:
                    f5 = SafeParcelReader.B(parcel, D);
                    break;
                case 9:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 10:
                    f6 = SafeParcelReader.B(parcel, D);
                    break;
                case 11:
                    f7 = SafeParcelReader.B(parcel, D);
                    break;
                case 12:
                    f8 = SafeParcelReader.B(parcel, D);
                    break;
                case 13:
                    z2 = SafeParcelReader.w(parcel, D);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new GroundOverlayOptions(iBinder, latLng, f2, f3, latLngBounds, f4, f5, z, f6, f7, f8, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GroundOverlayOptions[] newArray(int i2) {
        return new GroundOverlayOptions[i2];
    }
}
