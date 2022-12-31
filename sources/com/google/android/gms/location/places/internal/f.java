package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class f implements Parcelable.Creator<zzau> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzau createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v == 2) {
                str2 = SafeParcelReader.p(parcel, D);
            } else if (v == 3) {
                str3 = SafeParcelReader.p(parcel, D);
            } else if (v == 4) {
                str4 = SafeParcelReader.p(parcel, D);
            } else if (v == 6) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v != 7) {
                SafeParcelReader.M(parcel, D);
            } else {
                i3 = SafeParcelReader.F(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzau(str, str2, str3, str4, i2, i3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzau[] newArray(int i2) {
        return new zzau[i2];
    }
}
