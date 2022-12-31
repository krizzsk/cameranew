package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class i implements Parcelable.Creator<PlacePhotoMetadataResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlacePhotoMetadataResult createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        Status status = null;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                status = (Status) SafeParcelReader.o(parcel, D, Status.CREATOR);
            } else if (v != 2) {
                SafeParcelReader.M(parcel, D);
            } else {
                dataHolder = (DataHolder) SafeParcelReader.o(parcel, D, DataHolder.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new PlacePhotoMetadataResult(status, dataHolder);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlacePhotoMetadataResult[] newArray(int i2) {
        return new PlacePhotoMetadataResult[i2];
    }
}
