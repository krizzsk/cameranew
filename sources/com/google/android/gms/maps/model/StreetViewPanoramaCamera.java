package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* loaded from: classes2.dex */
public class StreetViewPanoramaCamera extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaCamera> CREATOR = new p();
    public final float bearing;
    public final float tilt;
    public final float zoom;
    @NonNull
    private final StreetViewPanoramaOrientation zzeg;

    public StreetViewPanoramaCamera(float f2, float f3, float f4) {
        boolean z = -90.0f <= f3 && f3 <= 90.0f;
        StringBuilder sb = new StringBuilder(62);
        sb.append("Tilt needs to be between -90 and 90 inclusive: ");
        sb.append(f3);
        com.google.android.gms.common.internal.q.b(z, sb.toString());
        this.zoom = ((double) f2) <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0.0f : f2;
        this.tilt = 0.0f + f3;
        this.bearing = (((double) f4) <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? (f4 % 360.0f) + 360.0f : f4) % 360.0f;
        StreetViewPanoramaOrientation.a aVar = new StreetViewPanoramaOrientation.a();
        aVar.c(f3);
        aVar.a(f4);
        this.zzeg = aVar.b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StreetViewPanoramaCamera) {
            StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
            return Float.floatToIntBits(this.zoom) == Float.floatToIntBits(streetViewPanoramaCamera.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(streetViewPanoramaCamera.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaCamera.bearing);
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.b(Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public String toString() {
        p.a c = com.google.android.gms.common.internal.p.c(this);
        c.a("zoom", Float.valueOf(this.zoom));
        c.a("tilt", Float.valueOf(this.tilt));
        c.a("bearing", Float.valueOf(this.bearing));
        return c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 2, this.zoom);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 3, this.tilt);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 4, this.bearing);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
