package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public final class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new o();
    private final boolean zzbn;
    private final boolean zzbo;
    private final boolean zzbp;
    private final boolean zzbq;
    private final boolean zzbr;
    private final boolean zzbs;

    public LocationSettingsStates(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.zzbn = z;
        this.zzbo = z2;
        this.zzbp = z3;
        this.zzbq = z4;
        this.zzbr = z5;
        this.zzbs = z6;
    }

    public final boolean Q() {
        return this.zzbs;
    }

    public final boolean R() {
        return this.zzbp;
    }

    public final boolean S() {
        return this.zzbq;
    }

    public final boolean T() {
        return this.zzbn;
    }

    public final boolean U() {
        return this.zzbr;
    }

    public final boolean V() {
        return this.zzbo;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 1, T());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 2, V());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 3, R());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 4, S());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 5, U());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 6, Q());
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
