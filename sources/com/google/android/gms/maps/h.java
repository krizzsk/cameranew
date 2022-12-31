package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;
/* loaded from: classes2.dex */
public final class h implements Parcelable.Creator<GoogleMapOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleMapOptions createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        CameraPosition cameraPosition = null;
        Float f2 = null;
        Float f3 = null;
        LatLngBounds latLngBounds = null;
        byte b = -1;
        byte b2 = -1;
        int i2 = 0;
        byte b3 = -1;
        byte b4 = -1;
        byte b5 = -1;
        byte b6 = -1;
        byte b7 = -1;
        byte b8 = -1;
        byte b9 = -1;
        byte b10 = -1;
        byte b11 = -1;
        byte b12 = -1;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 2:
                    b = SafeParcelReader.y(parcel, D);
                    break;
                case 3:
                    b2 = SafeParcelReader.y(parcel, D);
                    break;
                case 4:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) SafeParcelReader.o(parcel, D, CameraPosition.CREATOR);
                    break;
                case 6:
                    b3 = SafeParcelReader.y(parcel, D);
                    break;
                case 7:
                    b4 = SafeParcelReader.y(parcel, D);
                    break;
                case 8:
                    b5 = SafeParcelReader.y(parcel, D);
                    break;
                case 9:
                    b6 = SafeParcelReader.y(parcel, D);
                    break;
                case 10:
                    b7 = SafeParcelReader.y(parcel, D);
                    break;
                case 11:
                    b8 = SafeParcelReader.y(parcel, D);
                    break;
                case 12:
                    b9 = SafeParcelReader.y(parcel, D);
                    break;
                case 13:
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
                case 14:
                    b10 = SafeParcelReader.y(parcel, D);
                    break;
                case 15:
                    b11 = SafeParcelReader.y(parcel, D);
                    break;
                case 16:
                    f2 = SafeParcelReader.C(parcel, D);
                    break;
                case 17:
                    f3 = SafeParcelReader.C(parcel, D);
                    break;
                case 18:
                    latLngBounds = (LatLngBounds) SafeParcelReader.o(parcel, D, LatLngBounds.CREATOR);
                    break;
                case 19:
                    b12 = SafeParcelReader.y(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new GoogleMapOptions(b, b2, i2, cameraPosition, b3, b4, b5, b6, b7, b8, b9, b10, b11, f2, f3, latLngBounds, b12);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleMapOptions[] newArray(int i2) {
        return new GoogleMapOptions[i2];
    }
}
