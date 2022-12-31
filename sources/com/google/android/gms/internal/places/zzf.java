package com.google.android.gms.internal.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class zzf implements Parcelable.Creator<zzg> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzg createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            if (SafeParcelReader.v(D) != 1) {
                SafeParcelReader.M(parcel, D);
            } else {
                str = SafeParcelReader.p(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzg(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzg[] newArray(int i2) {
        return new zzg[i2];
    }
}
