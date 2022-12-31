package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* loaded from: classes2.dex */
public final class zzad extends AbstractSafeParcelable implements g {
    private final Status zzbl;
    private static final zzad zzcr = new zzad(Status.RESULT_SUCCESS);
    public static final Parcelable.Creator<zzad> CREATOR = new zzae();

    public zzad(Status status) {
        this.zzbl = status;
    }

    @Override // com.google.android.gms.common.api.g
    public final Status getStatus() {
        return this.zzbl;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.t(parcel, 1, getStatus(), i2, false);
        a.b(parcel, a);
    }
}
