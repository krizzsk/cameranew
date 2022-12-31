package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class o implements Parcelable.Creator<PolylineOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolylineOptions createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        ArrayList arrayList = null;
        Cap cap = null;
        Cap cap2 = null;
        ArrayList arrayList2 = null;
        float f2 = 0.0f;
        int i2 = 0;
        float f3 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i3 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 2:
                    arrayList = SafeParcelReader.t(parcel, D, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = SafeParcelReader.B(parcel, D);
                    break;
                case 4:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 5:
                    f3 = SafeParcelReader.B(parcel, D);
                    break;
                case 6:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 7:
                    z2 = SafeParcelReader.w(parcel, D);
                    break;
                case 8:
                    z3 = SafeParcelReader.w(parcel, D);
                    break;
                case 9:
                    cap = (Cap) SafeParcelReader.o(parcel, D, Cap.CREATOR);
                    break;
                case 10:
                    cap2 = (Cap) SafeParcelReader.o(parcel, D, Cap.CREATOR);
                    break;
                case 11:
                    i3 = SafeParcelReader.F(parcel, D);
                    break;
                case 12:
                    arrayList2 = SafeParcelReader.t(parcel, D, PatternItem.CREATOR);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new PolylineOptions(arrayList, f2, i2, f3, z, z2, z3, cap, cap2, i3, arrayList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolylineOptions[] newArray(int i2) {
        return new PolylineOptions[i2];
    }
}
