package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public final class LocationSettingsResult extends AbstractSafeParcelable implements com.google.android.gms.common.api.g {
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new n();
    private final Status zzbl;
    private final LocationSettingsStates zzbm;

    public LocationSettingsResult(Status status) {
        this(status, null);
    }

    public LocationSettingsResult(Status status, LocationSettingsStates locationSettingsStates) {
        this.zzbl = status;
        this.zzbm = locationSettingsStates;
    }

    public final LocationSettingsStates Q() {
        return this.zzbm;
    }

    @Override // com.google.android.gms.common.api.g
    public final Status getStatus() {
        return this.zzbl;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 1, getStatus(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, Q(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
