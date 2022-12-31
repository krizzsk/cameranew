package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class j implements Parcelable.Creator<PlacePhotoResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlacePhotoResult createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        Status status = null;
        BitmapTeleporter bitmapTeleporter = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                status = (Status) SafeParcelReader.o(parcel, D, Status.CREATOR);
            } else if (v != 2) {
                SafeParcelReader.M(parcel, D);
            } else {
                bitmapTeleporter = (BitmapTeleporter) SafeParcelReader.o(parcel, D, BitmapTeleporter.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new PlacePhotoResult(status, bitmapTeleporter);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlacePhotoResult[] newArray(int i2) {
        return new PlacePhotoResult[i2];
    }
}
