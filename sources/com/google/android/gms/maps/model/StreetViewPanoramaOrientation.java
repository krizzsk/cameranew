package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* loaded from: classes2.dex */
public class StreetViewPanoramaOrientation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOrientation> CREATOR = new s();
    public final float bearing;
    public final float tilt;

    /* loaded from: classes2.dex */
    public static final class a {
        public float a;
        public float b;

        public final a a(float f2) {
            this.a = f2;
            return this;
        }

        public final StreetViewPanoramaOrientation b() {
            return new StreetViewPanoramaOrientation(this.b, this.a);
        }

        public final a c(float f2) {
            this.b = f2;
            return this;
        }
    }

    public StreetViewPanoramaOrientation(float f2, float f3) {
        boolean z = -90.0f <= f2 && f2 <= 90.0f;
        StringBuilder sb = new StringBuilder(62);
        sb.append("Tilt needs to be between -90 and 90 inclusive: ");
        sb.append(f2);
        com.google.android.gms.common.internal.q.b(z, sb.toString());
        this.tilt = f2 + 0.0f;
        this.bearing = (((double) f3) <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StreetViewPanoramaOrientation) {
            StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) obj;
            return Float.floatToIntBits(this.tilt) == Float.floatToIntBits(streetViewPanoramaOrientation.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaOrientation.bearing);
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.b(Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public String toString() {
        p.a c = com.google.android.gms.common.internal.p.c(this);
        c.a("tilt", Float.valueOf(this.tilt));
        c.a("bearing", Float.valueOf(this.bearing));
        return c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 2, this.tilt);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 3, this.bearing);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a2);
    }
}
