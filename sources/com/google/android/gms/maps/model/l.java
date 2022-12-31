package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class l implements Parcelable.Creator<PatternItem> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PatternItem createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        int i2 = 0;
        Float f2 = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 2) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v != 3) {
                SafeParcelReader.M(parcel, D);
            } else {
                f2 = SafeParcelReader.C(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new PatternItem(i2, f2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PatternItem[] newArray(int i2) {
        return new PatternItem[i2];
    }
}
