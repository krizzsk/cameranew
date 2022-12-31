package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public class StreetViewPanoramaLocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaLocation> CREATOR = new r();
    public final StreetViewPanoramaLink[] links;
    public final String panoId;
    public final LatLng position;

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this.links = streetViewPanoramaLinkArr;
        this.position = latLng;
        this.panoId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StreetViewPanoramaLocation) {
            StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
            return this.panoId.equals(streetViewPanoramaLocation.panoId) && this.position.equals(streetViewPanoramaLocation.position);
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.b(this.position, this.panoId);
    }

    public String toString() {
        p.a c = com.google.android.gms.common.internal.p.c(this);
        c.a("panoId", this.panoId);
        c.a("position", this.position.toString());
        return c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.y(parcel, 2, this.links, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 3, this.position, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 4, this.panoId, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
