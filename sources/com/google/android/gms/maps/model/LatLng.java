package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public final class LatLng extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLng> CREATOR = new i();
    public final double latitude;
    public final double longitude;

    public LatLng(double d2, double d3) {
        if (-180.0d <= d3 && d3 < 180.0d) {
            this.longitude = d3;
        } else {
            this.longitude = ((((d3 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        }
        this.latitude = Math.max(-90.0d, Math.min(90.0d, d2));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LatLng) {
            LatLng latLng = (LatLng) obj;
            return Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(latLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(latLng.longitude);
        }
        return false;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public final String toString() {
        double d2 = this.latitude;
        double d3 = this.longitude;
        StringBuilder sb = new StringBuilder(60);
        sb.append("lat/lng: (");
        sb.append(d2);
        sb.append(",");
        sb.append(d3);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.h(parcel, 2, this.latitude);
        com.google.android.gms.common.internal.safeparcel.a.h(parcel, 3, this.longitude);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
