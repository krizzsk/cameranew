package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
/* loaded from: classes2.dex */
public final class CircleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CircleOptions> CREATOR = new f();
    private int fillColor;
    private int strokeColor;
    private LatLng zzcp;
    private double zzcq;
    private float zzcr;
    private float zzcs;
    private boolean zzct;
    private boolean zzcu;
    @Nullable
    private List<PatternItem> zzcv;

    public CircleOptions() {
        this.zzcp = null;
        this.zzcq = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.zzcr = 10.0f;
        this.strokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.fillColor = 0;
        this.zzcs = 0.0f;
        this.zzct = true;
        this.zzcu = false;
        this.zzcv = null;
    }

    public final LatLng Q() {
        return this.zzcp;
    }

    public final int R() {
        return this.fillColor;
    }

    public final double S() {
        return this.zzcq;
    }

    public final int T() {
        return this.strokeColor;
    }

    @Nullable
    public final List<PatternItem> U() {
        return this.zzcv;
    }

    public final float V() {
        return this.zzcr;
    }

    public final float W() {
        return this.zzcs;
    }

    public final boolean X() {
        return this.zzcu;
    }

    public final boolean Y() {
        return this.zzct;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, Q(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.h(parcel, 3, S());
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 4, V());
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 5, T());
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 6, R());
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 7, W());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 8, Y());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 9, X());
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 10, U(), false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleOptions(LatLng latLng, double d2, float f2, int i2, int i3, float f3, boolean z, boolean z2, @Nullable List<PatternItem> list) {
        this.zzcp = null;
        this.zzcq = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.zzcr = 10.0f;
        this.strokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.fillColor = 0;
        this.zzcs = 0.0f;
        this.zzct = true;
        this.zzcu = false;
        this.zzcv = null;
        this.zzcp = latLng;
        this.zzcq = d2;
        this.zzcr = f2;
        this.strokeColor = i2;
        this.fillColor = i3;
        this.zzcs = f3;
        this.zzct = z;
        this.zzcu = z2;
        this.zzcv = list;
    }
}
