package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new h();
    @Deprecated
    private int zzar;
    @Deprecated
    private int zzas;
    private long zzat;
    private int zzau;
    private zzaj[] zzav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationAvailability(int i2, int i3, int i4, long j2, zzaj[] zzajVarArr) {
        this.zzau = i2;
        this.zzar = i3;
        this.zzas = i4;
        this.zzat = j2;
        this.zzav = zzajVarArr;
    }

    public final boolean Q() {
        return this.zzau < 1000;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && LocationAvailability.class == obj.getClass()) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.zzar == locationAvailability.zzar && this.zzas == locationAvailability.zzas && this.zzat == locationAvailability.zzat && this.zzau == locationAvailability.zzau && Arrays.equals(this.zzav, locationAvailability.zzav)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.b(Integer.valueOf(this.zzau), Integer.valueOf(this.zzar), Integer.valueOf(this.zzas), Long.valueOf(this.zzat), this.zzav);
    }

    public final String toString() {
        boolean Q = Q();
        StringBuilder sb = new StringBuilder(48);
        sb.append("LocationAvailability[isLocationAvailable: ");
        sb.append(Q);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zzar);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, this.zzas);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 3, this.zzat);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 4, this.zzau);
        com.google.android.gms.common.internal.safeparcel.a.y(parcel, 5, this.zzav, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
