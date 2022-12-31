package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;
/* loaded from: classes2.dex */
public final class l implements Parcelable.Creator<StreetViewPanoramaOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaOptions createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        String str = null;
        LatLng latLng = null;
        Integer num = null;
        StreetViewSource streetViewSource = null;
        byte b = 0;
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) SafeParcelReader.o(parcel, D, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 4:
                    latLng = (LatLng) SafeParcelReader.o(parcel, D, LatLng.CREATOR);
                    break;
                case 5:
                    num = SafeParcelReader.G(parcel, D);
                    break;
                case 6:
                    b = SafeParcelReader.y(parcel, D);
                    break;
                case 7:
                    b2 = SafeParcelReader.y(parcel, D);
                    break;
                case 8:
                    b3 = SafeParcelReader.y(parcel, D);
                    break;
                case 9:
                    b4 = SafeParcelReader.y(parcel, D);
                    break;
                case 10:
                    b5 = SafeParcelReader.y(parcel, D);
                    break;
                case 11:
                    streetViewSource = (StreetViewSource) SafeParcelReader.o(parcel, D, StreetViewSource.CREATOR);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new StreetViewPanoramaOptions(streetViewPanoramaCamera, str, latLng, num, b, b2, b3, b4, b5, streetViewSource);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaOptions[] newArray(int i2) {
        return new StreetViewPanoramaOptions[i2];
    }
}
