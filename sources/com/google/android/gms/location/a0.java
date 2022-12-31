package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class a0 implements Parcelable.Creator<zzj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzj createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        long j2 = 50;
        long j3 = Long.MAX_VALUE;
        boolean z = true;
        float f2 = 0.0f;
        int i2 = Integer.MAX_VALUE;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                z = SafeParcelReader.w(parcel, D);
            } else if (v == 2) {
                j2 = SafeParcelReader.I(parcel, D);
            } else if (v == 3) {
                f2 = SafeParcelReader.B(parcel, D);
            } else if (v == 4) {
                j3 = SafeParcelReader.I(parcel, D);
            } else if (v != 5) {
                SafeParcelReader.M(parcel, D);
            } else {
                i2 = SafeParcelReader.F(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzj(z, j2, f2, j3, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzj[] newArray(int i2) {
        return new zzj[i2];
    }
}
