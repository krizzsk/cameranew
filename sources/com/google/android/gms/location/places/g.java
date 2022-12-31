package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class g implements Parcelable.Creator<AutocompleteFilter> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AutocompleteFilter createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        ArrayList<Integer> arrayList = null;
        String str = null;
        int i2 = 0;
        boolean z = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                z = SafeParcelReader.w(parcel, D);
            } else if (v == 2) {
                arrayList = SafeParcelReader.k(parcel, D);
            } else if (v == 3) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v != 1000) {
                SafeParcelReader.M(parcel, D);
            } else {
                i2 = SafeParcelReader.F(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new AutocompleteFilter(i2, z, arrayList, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AutocompleteFilter[] newArray(int i2) {
        return new AutocompleteFilter[i2];
    }
}
