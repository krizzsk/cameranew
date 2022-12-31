package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class zzae implements Parcelable.Creator<zzad> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzad createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        Status status = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            if (SafeParcelReader.v(D) != 1) {
                SafeParcelReader.M(parcel, D);
            } else {
                status = (Status) SafeParcelReader.o(parcel, D, Status.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzad(status);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzad[] newArray(int i2) {
        return new zzad[i2];
    }
}
