package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class c implements Parcelable.Creator<zzak> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzak createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        PlaceEntity placeEntity = null;
        float f2 = 0.0f;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                placeEntity = (PlaceEntity) SafeParcelReader.o(parcel, D, PlaceEntity.CREATOR);
            } else if (v != 2) {
                SafeParcelReader.M(parcel, D);
            } else {
                f2 = SafeParcelReader.B(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzak(placeEntity, f2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzak[] newArray(int i2) {
        return new zzak[i2];
    }
}
