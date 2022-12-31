package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* loaded from: classes2.dex */
public final class CameraPosition extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CameraPosition> CREATOR = new d();
    public final float bearing;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    /* loaded from: classes2.dex */
    public static final class a {
        private LatLng a;
        private float b;
        private float c;

        /* renamed from: d  reason: collision with root package name */
        private float f3746d;

        public final a a(float f2) {
            this.f3746d = f2;
            return this;
        }

        public final CameraPosition b() {
            return new CameraPosition(this.a, this.b, this.c, this.f3746d);
        }

        public final a c(LatLng latLng) {
            this.a = latLng;
            return this;
        }

        public final a d(float f2) {
            this.c = f2;
            return this;
        }

        public final a e(float f2) {
            this.b = f2;
            return this;
        }
    }

    public CameraPosition(LatLng latLng, float f2, float f3, float f4) {
        com.google.android.gms.common.internal.q.k(latLng, "null camera target");
        com.google.android.gms.common.internal.q.c(0.0f <= f3 && f3 <= 90.0f, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f3));
        this.target = latLng;
        this.zoom = f2;
        this.tilt = f3 + 0.0f;
        this.bearing = (((double) f4) <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? (f4 % 360.0f) + 360.0f : f4) % 360.0f;
    }

    public static a Q() {
        return new a();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CameraPosition) {
            CameraPosition cameraPosition = (CameraPosition) obj;
            return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.b(this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public final String toString() {
        p.a c = com.google.android.gms.common.internal.p.c(this);
        c.a(TypedValues.AttributesType.S_TARGET, this.target);
        c.a("zoom", Float.valueOf(this.zoom));
        c.a("tilt", Float.valueOf(this.tilt));
        c.a("bearing", Float.valueOf(this.bearing));
        return c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, this.target, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 3, this.zoom);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 4, this.tilt);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 5, this.bearing);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a2);
    }
}
