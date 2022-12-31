package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class f implements Parcelable.Creator<CircleOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CircleOptions createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        LatLng latLng = null;
        ArrayList arrayList = null;
        double d2 = 0.0d;
        float f2 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        float f3 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 2:
                    latLng = (LatLng) SafeParcelReader.o(parcel, D, LatLng.CREATOR);
                    break;
                case 3:
                    d2 = SafeParcelReader.z(parcel, D);
                    break;
                case 4:
                    f2 = SafeParcelReader.B(parcel, D);
                    break;
                case 5:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 6:
                    i3 = SafeParcelReader.F(parcel, D);
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
                    arrayList = SafeParcelReader.t(parcel, D, PatternItem.CREATOR);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new CircleOptions(latLng, d2, f2, i2, i3, f3, z, z2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CircleOptions[] newArray(int i2) {
        return new CircleOptions[i2];
    }
}
