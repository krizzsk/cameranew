package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class p implements Parcelable.Creator<zzaj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaj createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        long j2 = -1;
        long j3 = -1;
        int i2 = 1;
        int i3 = 1;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v == 2) {
                i3 = SafeParcelReader.F(parcel, D);
            } else if (v == 3) {
                j2 = SafeParcelReader.I(parcel, D);
            } else if (v != 4) {
                SafeParcelReader.M(parcel, D);
            } else {
                j3 = SafeParcelReader.I(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzaj(i2, i3, j2, j3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaj[] newArray(int i2) {
        return new zzaj[i2];
    }
}
