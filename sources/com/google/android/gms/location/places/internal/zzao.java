package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new k();
    private final int zzcs;
    private final int zzct;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzao(int i2, int i3) {
        this.zzcs = i2;
        this.zzct = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zzcs);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, this.zzct);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
