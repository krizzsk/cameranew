package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new p();
    private final int zzar;
    private final int zzas;
    private final long zzat;
    private final long zzbt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaj(int i2, int i3, long j2, long j3) {
        this.zzas = i2;
        this.zzar = i3;
        this.zzbt = j2;
        this.zzat = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaj.class == obj.getClass()) {
            zzaj zzajVar = (zzaj) obj;
            if (this.zzas == zzajVar.zzas && this.zzar == zzajVar.zzar && this.zzbt == zzajVar.zzbt && this.zzat == zzajVar.zzat) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.b(Integer.valueOf(this.zzar), Integer.valueOf(this.zzas), Long.valueOf(this.zzat), Long.valueOf(this.zzbt));
    }

    public final String toString() {
        return "NetworkLocationStatus: Wifi status: " + this.zzas + " Cell status: " + this.zzar + " elapsed time NS: " + this.zzat + " system time ms: " + this.zzbt;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zzas);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, this.zzar);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 3, this.zzbt);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 4, this.zzat);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
