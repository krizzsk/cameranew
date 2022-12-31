package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
@Deprecated
/* loaded from: classes2.dex */
public class PlacePhotoMetadataResult extends AbstractSafeParcelable implements com.google.android.gms.common.api.g {
    public static final Parcelable.Creator<PlacePhotoMetadataResult> CREATOR = new i();
    private final DataHolder zzaf;
    private final c zzag;
    private final Status zzp;

    public PlacePhotoMetadataResult(Status status, DataHolder dataHolder) {
        this.zzp = status;
        this.zzaf = dataHolder;
        if (dataHolder == null) {
            this.zzag = null;
        } else {
            this.zzag = new c(dataHolder);
        }
    }

    @Override // com.google.android.gms.common.api.g
    public Status getStatus() {
        return this.zzp;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 1, getStatus(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, this.zzaf, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
