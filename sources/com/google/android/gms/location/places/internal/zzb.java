package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new g();
    final int a;
    final int b;

    public zzb(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzb) {
            zzb zzbVar = (zzb) obj;
            return p.a(Integer.valueOf(this.a), Integer.valueOf(zzbVar.a)) && p.a(Integer.valueOf(this.b), Integer.valueOf(zzbVar.b));
        }
        return false;
    }

    public final int hashCode() {
        return p.b(Integer.valueOf(this.a), Integer.valueOf(this.b));
    }

    public final String toString() {
        p.a c = p.c(this);
        c.a("offset", Integer.valueOf(this.a));
        c.a("length", Integer.valueOf(this.b));
        return c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.a);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, this.b);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
