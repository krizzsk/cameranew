package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public final class zzak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzak> CREATOR = new c();
    private final PlaceEntity zzcj;
    private final float zzck;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzak(PlaceEntity placeEntity, float f2) {
        this.zzcj = placeEntity;
        this.zzck = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzak) {
            zzak zzakVar = (zzak) obj;
            return this.zzcj.equals(zzakVar.zzcj) && this.zzck == zzakVar.zzck;
        }
        return false;
    }

    public final int hashCode() {
        return p.b(this.zzcj, Float.valueOf(this.zzck));
    }

    public final String toString() {
        p.a c = p.c(this);
        c.a("place", this.zzcj);
        c.a("likelihood", Float.valueOf(this.zzck));
        return c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 1, this.zzcj, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 2, this.zzck);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
