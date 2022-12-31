package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class a implements Parcelable.Creator<PlaceEntity> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceEntity createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        ArrayList<Integer> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        ArrayList<String> arrayList2 = null;
        LatLng latLng = null;
        LatLngBounds latLngBounds = null;
        String str5 = null;
        Uri uri = null;
        zzal zzalVar = null;
        zzai zzaiVar = null;
        String str6 = null;
        float f2 = 0.0f;
        boolean z = false;
        float f3 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 2:
                case 3:
                case 12:
                case 13:
                case 16:
                case 18:
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
                case 4:
                    latLng = (LatLng) SafeParcelReader.o(parcel, D, LatLng.CREATOR);
                    break;
                case 5:
                    f2 = SafeParcelReader.B(parcel, D);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) SafeParcelReader.o(parcel, D, LatLngBounds.CREATOR);
                    break;
                case 7:
                    str5 = SafeParcelReader.p(parcel, D);
                    break;
                case 8:
                    uri = (Uri) SafeParcelReader.o(parcel, D, Uri.CREATOR);
                    break;
                case 9:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 10:
                    f3 = SafeParcelReader.B(parcel, D);
                    break;
                case 11:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 14:
                    str3 = SafeParcelReader.p(parcel, D);
                    break;
                case 15:
                    str4 = SafeParcelReader.p(parcel, D);
                    break;
                case 17:
                    arrayList2 = SafeParcelReader.r(parcel, D);
                    break;
                case 19:
                    str2 = SafeParcelReader.p(parcel, D);
                    break;
                case 20:
                    arrayList = SafeParcelReader.k(parcel, D);
                    break;
                case 21:
                    zzalVar = (zzal) SafeParcelReader.o(parcel, D, zzal.CREATOR);
                    break;
                case 22:
                    zzaiVar = (zzai) SafeParcelReader.o(parcel, D, zzai.CREATOR);
                    break;
                case 23:
                    str6 = SafeParcelReader.p(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new PlaceEntity(str, arrayList, str2, str3, str4, arrayList2, latLng, f2, latLngBounds, str5, uri, z, f3, i2, zzalVar, zzaiVar, str6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceEntity[] newArray(int i2) {
        return new PlaceEntity[i2];
    }
}
