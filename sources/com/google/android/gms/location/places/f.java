package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class f implements Parcelable.Creator<AddPlaceRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AddPlaceRequest createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        LatLng latLng = null;
        String str2 = null;
        ArrayList<Integer> arrayList = null;
        String str3 = null;
        Uri uri = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 2:
                    latLng = (LatLng) SafeParcelReader.o(parcel, D, LatLng.CREATOR);
                    break;
                case 3:
                    str2 = SafeParcelReader.p(parcel, D);
                    break;
                case 4:
                    arrayList = SafeParcelReader.k(parcel, D);
                    break;
                case 5:
                    str3 = SafeParcelReader.p(parcel, D);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.o(parcel, D, Uri.CREATOR);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new AddPlaceRequest(str, latLng, str2, arrayList, str3, uri);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AddPlaceRequest[] newArray(int i2) {
        return new AddPlaceRequest[i2];
    }
}
