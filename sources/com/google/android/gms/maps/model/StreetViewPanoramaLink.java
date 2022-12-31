package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* loaded from: classes2.dex */
public class StreetViewPanoramaLink extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaLink> CREATOR = new q();
    public final float bearing;
    public final String panoId;

    public StreetViewPanoramaLink(String str, float f2) {
        this.panoId = str;
        this.bearing = (((double) f2) <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? (f2 % 360.0f) + 360.0f : f2) % 360.0f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StreetViewPanoramaLink) {
            StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) obj;
            return this.panoId.equals(streetViewPanoramaLink.panoId) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaLink.bearing);
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.b(this.panoId, Float.valueOf(this.bearing));
    }

    public String toString() {
        p.a c = com.google.android.gms.common.internal.p.c(this);
        c.a("panoId", this.panoId);
        c.a("bearing", Float.valueOf(this.bearing));
        return c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, this.panoId, false);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 3, this.bearing);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
