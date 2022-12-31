package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new h();
    public final LatLng northeast;
    public final LatLng southwest;

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        com.google.android.gms.common.internal.q.k(latLng, "null southwest");
        com.google.android.gms.common.internal.q.k(latLng2, "null northeast");
        double d2 = latLng2.latitude;
        double d3 = latLng.latitude;
        com.google.android.gms.common.internal.q.c(d2 >= d3, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(d3), Double.valueOf(latLng2.latitude));
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LatLngBounds) {
            LatLngBounds latLngBounds = (LatLngBounds) obj;
            return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.b(this.southwest, this.northeast);
    }

    public final String toString() {
        p.a c = com.google.android.gms.common.internal.p.c(this);
        c.a("southwest", this.southwest);
        c.a("northeast", this.northeast);
        return c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, this.southwest, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 3, this.northeast, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
