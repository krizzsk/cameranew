package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class h implements Parcelable.Creator<PlaceFilter> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceFilter createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        ArrayList<Integer> arrayList = null;
        ArrayList<String> arrayList2 = null;
        ArrayList arrayList3 = null;
        boolean z = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                arrayList = SafeParcelReader.k(parcel, D);
            } else if (v == 6) {
                arrayList2 = SafeParcelReader.r(parcel, D);
            } else if (v == 3) {
                z = SafeParcelReader.w(parcel, D);
            } else if (v != 4) {
                SafeParcelReader.M(parcel, D);
            } else {
                arrayList3 = SafeParcelReader.t(parcel, D, zzp.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new PlaceFilter((List<Integer>) arrayList, z, (List<String>) arrayList2, (List<zzp>) arrayList3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceFilter[] newArray(int i2) {
        return new PlaceFilter[i2];
    }
}
