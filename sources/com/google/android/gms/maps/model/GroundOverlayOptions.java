package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.b;
/* loaded from: classes2.dex */
public final class GroundOverlayOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new g();
    public static final float NO_DIMENSION = -1.0f;
    private float bearing;
    private float height;
    private float width;
    private float zzcs;
    private boolean zzct;
    private boolean zzcu;
    @NonNull
    private a zzcx;
    private LatLng zzcy;
    private LatLngBounds zzcz;
    private float zzda;
    private float zzdb;
    private float zzdc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GroundOverlayOptions(IBinder iBinder, LatLng latLng, float f2, float f3, LatLngBounds latLngBounds, float f4, float f5, boolean z, float f6, float f7, float f8, boolean z2) {
        this.zzct = true;
        this.zzda = 0.0f;
        this.zzdb = 0.5f;
        this.zzdc = 0.5f;
        this.zzcu = false;
        this.zzcx = new a(b.a.x0(iBinder));
        this.zzcy = latLng;
        this.width = f2;
        this.height = f3;
        this.zzcz = latLngBounds;
        this.bearing = f4;
        this.zzcs = f5;
        this.zzct = z;
        this.zzda = f6;
        this.zzdb = f7;
        this.zzdc = f8;
        this.zzcu = z2;
    }

    public final float Q() {
        return this.zzdb;
    }

    public final float R() {
        return this.zzdc;
    }

    public final float S() {
        return this.bearing;
    }

    public final LatLngBounds T() {
        return this.zzcz;
    }

    public final float U() {
        return this.height;
    }

    public final LatLng V() {
        return this.zzcy;
    }

    public final float W() {
        return this.zzda;
    }

    public final float X() {
        return this.width;
    }

    public final float Y() {
        return this.zzcs;
    }

    public final boolean Z() {
        return this.zzcu;
    }

    public final boolean a0() {
        return this.zzct;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 2, this.zzcx.a().asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 3, V(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 4, X());
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 5, U());
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 6, T(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 7, S());
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 8, Y());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 9, a0());
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 10, W());
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 11, Q());
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 12, R());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 13, Z());
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public GroundOverlayOptions() {
        this.zzct = true;
        this.zzda = 0.0f;
        this.zzdb = 0.5f;
        this.zzdc = 0.5f;
        this.zzcu = false;
    }
}
