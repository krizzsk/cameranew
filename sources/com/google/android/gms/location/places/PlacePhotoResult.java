package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
@Deprecated
/* loaded from: classes2.dex */
public class PlacePhotoResult extends AbstractSafeParcelable implements com.google.android.gms.common.api.g {
    public static final Parcelable.Creator<PlacePhotoResult> CREATOR = new j();
    private final BitmapTeleporter zzah;
    private final Bitmap zzai;
    private final Status zzp;

    public PlacePhotoResult(Status status, BitmapTeleporter bitmapTeleporter) {
        this.zzp = status;
        this.zzah = bitmapTeleporter;
        if (bitmapTeleporter != null) {
            this.zzai = bitmapTeleporter.Q();
        } else {
            this.zzai = null;
        }
    }

    @Override // com.google.android.gms.common.api.g
    public Status getStatus() {
        return this.zzp;
    }

    public String toString() {
        p.a c = p.c(this);
        c.a("status", this.zzp);
        c.a("bitmap", this.zzai);
        return c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 1, getStatus(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, this.zzah, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
