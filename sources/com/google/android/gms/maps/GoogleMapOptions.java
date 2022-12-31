package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
/* loaded from: classes2.dex */
public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new h();
    private int mapType;
    private Boolean zzaj;
    private Boolean zzak;
    private CameraPosition zzal;
    private Boolean zzam;
    private Boolean zzan;
    private Boolean zzao;
    private Boolean zzap;
    private Boolean zzaq;
    private Boolean zzar;
    private Boolean zzas;
    private Boolean zzat;
    private Boolean zzau;
    private Float zzav;
    private Float zzaw;
    private LatLngBounds zzax;
    private Boolean zzay;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleMapOptions(byte b, byte b2, int i2, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, Float f2, Float f3, LatLngBounds latLngBounds, byte b12) {
        this.mapType = -1;
        this.zzav = null;
        this.zzaw = null;
        this.zzax = null;
        this.zzaj = com.google.android.gms.maps.g.h.b(b);
        this.zzak = com.google.android.gms.maps.g.h.b(b2);
        this.mapType = i2;
        this.zzal = cameraPosition;
        this.zzam = com.google.android.gms.maps.g.h.b(b3);
        this.zzan = com.google.android.gms.maps.g.h.b(b4);
        this.zzao = com.google.android.gms.maps.g.h.b(b5);
        this.zzap = com.google.android.gms.maps.g.h.b(b6);
        this.zzaq = com.google.android.gms.maps.g.h.b(b7);
        this.zzar = com.google.android.gms.maps.g.h.b(b8);
        this.zzas = com.google.android.gms.maps.g.h.b(b9);
        this.zzat = com.google.android.gms.maps.g.h.b(b10);
        this.zzau = com.google.android.gms.maps.g.h.b(b11);
        this.zzav = f2;
        this.zzaw = f3;
        this.zzax = latLngBounds;
        this.zzay = com.google.android.gms.maps.g.h.b(b12);
    }

    public static LatLngBounds j0(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        int i2 = R.styleable.MapAttrs_latLngBoundsSouthWestLatitude;
        Float valueOf = obtainAttributes.hasValue(i2) ? Float.valueOf(obtainAttributes.getFloat(i2, 0.0f)) : null;
        int i3 = R.styleable.MapAttrs_latLngBoundsSouthWestLongitude;
        Float valueOf2 = obtainAttributes.hasValue(i3) ? Float.valueOf(obtainAttributes.getFloat(i3, 0.0f)) : null;
        int i4 = R.styleable.MapAttrs_latLngBoundsNorthEastLatitude;
        Float valueOf3 = obtainAttributes.hasValue(i4) ? Float.valueOf(obtainAttributes.getFloat(i4, 0.0f)) : null;
        int i5 = R.styleable.MapAttrs_latLngBoundsNorthEastLongitude;
        Float valueOf4 = obtainAttributes.hasValue(i5) ? Float.valueOf(obtainAttributes.getFloat(i5, 0.0f)) : null;
        obtainAttributes.recycle();
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng(valueOf.floatValue(), valueOf2.floatValue()), new LatLng(valueOf3.floatValue(), valueOf4.floatValue()));
    }

    public static CameraPosition k0(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        int i2 = R.styleable.MapAttrs_cameraTargetLat;
        float f2 = obtainAttributes.hasValue(i2) ? obtainAttributes.getFloat(i2, 0.0f) : 0.0f;
        int i3 = R.styleable.MapAttrs_cameraTargetLng;
        LatLng latLng = new LatLng(f2, obtainAttributes.hasValue(i3) ? obtainAttributes.getFloat(i3, 0.0f) : 0.0f);
        CameraPosition.a Q = CameraPosition.Q();
        Q.c(latLng);
        int i4 = R.styleable.MapAttrs_cameraZoom;
        if (obtainAttributes.hasValue(i4)) {
            Q.e(obtainAttributes.getFloat(i4, 0.0f));
        }
        int i5 = R.styleable.MapAttrs_cameraBearing;
        if (obtainAttributes.hasValue(i5)) {
            Q.a(obtainAttributes.getFloat(i5, 0.0f));
        }
        int i6 = R.styleable.MapAttrs_cameraTilt;
        if (obtainAttributes.hasValue(i6)) {
            Q.d(obtainAttributes.getFloat(i6, 0.0f));
        }
        obtainAttributes.recycle();
        return Q.b();
    }

    public static GoogleMapOptions n(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        int i2 = R.styleable.MapAttrs_mapType;
        if (obtainAttributes.hasValue(i2)) {
            googleMapOptions.Y(obtainAttributes.getInt(i2, -1));
        }
        int i3 = R.styleable.MapAttrs_zOrderOnTop;
        if (obtainAttributes.hasValue(i3)) {
            googleMapOptions.g0(obtainAttributes.getBoolean(i3, false));
        }
        int i4 = R.styleable.MapAttrs_useViewLifecycle;
        if (obtainAttributes.hasValue(i4)) {
            googleMapOptions.f0(obtainAttributes.getBoolean(i4, false));
        }
        int i5 = R.styleable.MapAttrs_uiCompass;
        if (obtainAttributes.hasValue(i5)) {
            googleMapOptions.m(obtainAttributes.getBoolean(i5, true));
        }
        int i6 = R.styleable.MapAttrs_uiRotateGestures;
        if (obtainAttributes.hasValue(i6)) {
            googleMapOptions.b0(obtainAttributes.getBoolean(i6, true));
        }
        int i7 = R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom;
        if (obtainAttributes.hasValue(i7)) {
            googleMapOptions.d0(obtainAttributes.getBoolean(i7, true));
        }
        int i8 = R.styleable.MapAttrs_uiScrollGestures;
        if (obtainAttributes.hasValue(i8)) {
            googleMapOptions.c0(obtainAttributes.getBoolean(i8, true));
        }
        int i9 = R.styleable.MapAttrs_uiTiltGestures;
        if (obtainAttributes.hasValue(i9)) {
            googleMapOptions.e0(obtainAttributes.getBoolean(i9, true));
        }
        int i10 = R.styleable.MapAttrs_uiZoomGestures;
        if (obtainAttributes.hasValue(i10)) {
            googleMapOptions.i0(obtainAttributes.getBoolean(i10, true));
        }
        int i11 = R.styleable.MapAttrs_uiZoomControls;
        if (obtainAttributes.hasValue(i11)) {
            googleMapOptions.h0(obtainAttributes.getBoolean(i11, true));
        }
        int i12 = R.styleable.MapAttrs_liteMode;
        if (obtainAttributes.hasValue(i12)) {
            googleMapOptions.W(obtainAttributes.getBoolean(i12, false));
        }
        int i13 = R.styleable.MapAttrs_uiMapToolbar;
        if (obtainAttributes.hasValue(i13)) {
            googleMapOptions.X(obtainAttributes.getBoolean(i13, true));
        }
        int i14 = R.styleable.MapAttrs_ambientEnabled;
        if (obtainAttributes.hasValue(i14)) {
            googleMapOptions.h(obtainAttributes.getBoolean(i14, false));
        }
        int i15 = R.styleable.MapAttrs_cameraMinZoomPreference;
        if (obtainAttributes.hasValue(i15)) {
            googleMapOptions.a0(obtainAttributes.getFloat(i15, Float.NEGATIVE_INFINITY));
        }
        if (obtainAttributes.hasValue(i15)) {
            googleMapOptions.Z(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
        }
        googleMapOptions.V(j0(context, attributeSet));
        googleMapOptions.j(k0(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public final CameraPosition Q() {
        return this.zzal;
    }

    public final LatLngBounds R() {
        return this.zzax;
    }

    public final int S() {
        return this.mapType;
    }

    public final Float T() {
        return this.zzaw;
    }

    public final Float U() {
        return this.zzav;
    }

    public final GoogleMapOptions V(LatLngBounds latLngBounds) {
        this.zzax = latLngBounds;
        return this;
    }

    public final GoogleMapOptions W(boolean z) {
        this.zzas = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions X(boolean z) {
        this.zzat = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions Y(int i2) {
        this.mapType = i2;
        return this;
    }

    public final GoogleMapOptions Z(float f2) {
        this.zzaw = Float.valueOf(f2);
        return this;
    }

    public final GoogleMapOptions a0(float f2) {
        this.zzav = Float.valueOf(f2);
        return this;
    }

    public final GoogleMapOptions b0(boolean z) {
        this.zzar = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions c0(boolean z) {
        this.zzao = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions d0(boolean z) {
        this.zzay = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions e0(boolean z) {
        this.zzaq = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions f0(boolean z) {
        this.zzak = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions g0(boolean z) {
        this.zzaj = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions h(boolean z) {
        this.zzau = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions h0(boolean z) {
        this.zzam = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions i0(boolean z) {
        this.zzap = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions j(CameraPosition cameraPosition) {
        this.zzal = cameraPosition;
        return this;
    }

    public final GoogleMapOptions m(boolean z) {
        this.zzan = Boolean.valueOf(z);
        return this;
    }

    public final String toString() {
        p.a c = p.c(this);
        c.a("MapType", Integer.valueOf(this.mapType));
        c.a("LiteMode", this.zzas);
        c.a("Camera", this.zzal);
        c.a("CompassEnabled", this.zzan);
        c.a("ZoomControlsEnabled", this.zzam);
        c.a("ScrollGesturesEnabled", this.zzao);
        c.a("ZoomGesturesEnabled", this.zzap);
        c.a("TiltGesturesEnabled", this.zzaq);
        c.a("RotateGesturesEnabled", this.zzar);
        c.a("ScrollGesturesEnabledDuringRotateOrZoom", this.zzay);
        c.a("MapToolbarEnabled", this.zzat);
        c.a("AmbientEnabled", this.zzau);
        c.a("MinZoomPreference", this.zzav);
        c.a("MaxZoomPreference", this.zzaw);
        c.a("LatLngBoundsForCameraTarget", this.zzax);
        c.a("ZOrderOnTop", this.zzaj);
        c.a("UseViewLifecycleInFragment", this.zzak);
        return c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.f(parcel, 2, com.google.android.gms.maps.g.h.a(this.zzaj));
        com.google.android.gms.common.internal.safeparcel.a.f(parcel, 3, com.google.android.gms.maps.g.h.a(this.zzak));
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 4, S());
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 5, Q(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.f(parcel, 6, com.google.android.gms.maps.g.h.a(this.zzam));
        com.google.android.gms.common.internal.safeparcel.a.f(parcel, 7, com.google.android.gms.maps.g.h.a(this.zzan));
        com.google.android.gms.common.internal.safeparcel.a.f(parcel, 8, com.google.android.gms.maps.g.h.a(this.zzao));
        com.google.android.gms.common.internal.safeparcel.a.f(parcel, 9, com.google.android.gms.maps.g.h.a(this.zzap));
        com.google.android.gms.common.internal.safeparcel.a.f(parcel, 10, com.google.android.gms.maps.g.h.a(this.zzaq));
        com.google.android.gms.common.internal.safeparcel.a.f(parcel, 11, com.google.android.gms.maps.g.h.a(this.zzar));
        com.google.android.gms.common.internal.safeparcel.a.f(parcel, 12, com.google.android.gms.maps.g.h.a(this.zzas));
        com.google.android.gms.common.internal.safeparcel.a.f(parcel, 14, com.google.android.gms.maps.g.h.a(this.zzat));
        com.google.android.gms.common.internal.safeparcel.a.f(parcel, 15, com.google.android.gms.maps.g.h.a(this.zzau));
        com.google.android.gms.common.internal.safeparcel.a.k(parcel, 16, U(), false);
        com.google.android.gms.common.internal.safeparcel.a.k(parcel, 17, T(), false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 18, R(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.f(parcel, 19, com.google.android.gms.maps.g.h.a(this.zzay));
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public GoogleMapOptions() {
        this.mapType = -1;
        this.zzav = null;
        this.zzaw = null;
        this.zzax = null;
    }
}
