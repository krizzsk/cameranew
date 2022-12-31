package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class n implements Parcelable.Creator<PolygonOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolygonOptions createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        float f2 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        float f3 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i4 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 2:
                    arrayList2 = SafeParcelReader.t(parcel, D, LatLng.CREATOR);
                    break;
                case 3:
                    SafeParcelReader.H(parcel, D, arrayList, n.class.getClassLoader());
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
                    z3 = SafeParcelReader.w(parcel, D);
                    break;
                case 11:
                    i4 = SafeParcelReader.F(parcel, D);
                    break;
                case 12:
                    arrayList3 = SafeParcelReader.t(parcel, D, PatternItem.CREATOR);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new PolygonOptions(arrayList2, arrayList, f2, i2, i3, f3, z, z2, z3, i4, arrayList3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolygonOptions[] newArray(int i2) {
        return new PolygonOptions[i2];
    }
}
