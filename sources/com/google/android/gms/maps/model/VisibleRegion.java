package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public final class VisibleRegion extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VisibleRegion> CREATOR = new x();
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;
    public final LatLng nearLeft;
    public final LatLng nearRight;

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.nearLeft = latLng;
        this.nearRight = latLng2;
        this.farLeft = latLng3;
        this.farRight = latLng4;
        this.latLngBounds = latLngBounds;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VisibleRegion) {
            VisibleRegion visibleRegion = (VisibleRegion) obj;
            return this.nearLeft.equals(visibleRegion.nearLeft) && this.nearRight.equals(visibleRegion.nearRight) && this.farLeft.equals(visibleRegion.farLeft) && this.farRight.equals(visibleRegion.farRight) && this.latLngBounds.equals(visibleRegion.latLngBounds);
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.b(this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds);
    }

    public final String toString() {
        p.a c = com.google.android.gms.common.internal.p.c(this);
        c.a("nearLeft", this.nearLeft);
        c.a("nearRight", this.nearRight);
        c.a("farLeft", this.farLeft);
        c.a("farRight", this.farRight);
        c.a("latLngBounds", this.latLngBounds);
        return c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, this.nearLeft, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 3, this.nearRight, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 4, this.farLeft, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 5, this.farRight, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 6, this.latLngBounds, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
