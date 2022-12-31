package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.b;
/* loaded from: classes2.dex */
public final class MarkerOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new k();
    private float alpha;
    private LatLng position;
    private float zzcs;
    private boolean zzct;
    private float zzdb;
    private float zzdc;
    private String zzdn;
    private String zzdo;
    private a zzdp;
    private boolean zzdq;
    private boolean zzdr;
    private float zzds;
    private float zzdt;
    private float zzdu;

    public MarkerOptions() {
        this.zzdb = 0.5f;
        this.zzdc = 1.0f;
        this.zzct = true;
        this.zzdr = false;
        this.zzds = 0.0f;
        this.zzdt = 0.5f;
        this.zzdu = 0.0f;
        this.alpha = 1.0f;
    }

    public final float Q() {
        return this.alpha;
    }

    public final float R() {
        return this.zzdb;
    }

    public final float S() {
        return this.zzdc;
    }

    public final float T() {
        return this.zzdt;
    }

    public final float U() {
        return this.zzdu;
    }

    public final LatLng V() {
        return this.position;
    }

    public final float W() {
        return this.zzds;
    }

    public final String X() {
        return this.zzdo;
    }

    public final String Y() {
        return this.zzdn;
    }

    public final float Z() {
        return this.zzcs;
    }

    public final boolean a0() {
        return this.zzdq;
    }

    public final boolean b0() {
        return this.zzdr;
    }

    public final boolean c0() {
        return this.zzct;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, V(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 3, Y(), false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 4, X(), false);
        a aVar = this.zzdp;
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 5, aVar == null ? null : aVar.a().asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 6, R());
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 7, S());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 8, a0());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 9, c0());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 10, b0());
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 11, W());
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 12, T());
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 13, U());
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 14, Q());
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 15, Z());
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkerOptions(LatLng latLng, String str, String str2, IBinder iBinder, float f2, float f3, boolean z, boolean z2, boolean z3, float f4, float f5, float f6, float f7, float f8) {
        this.zzdb = 0.5f;
        this.zzdc = 1.0f;
        this.zzct = true;
        this.zzdr = false;
        this.zzds = 0.0f;
        this.zzdt = 0.5f;
        this.zzdu = 0.0f;
        this.alpha = 1.0f;
        this.position = latLng;
        this.zzdn = str;
        this.zzdo = str2;
        if (iBinder == null) {
            this.zzdp = null;
        } else {
            this.zzdp = new a(b.a.x0(iBinder));
        }
        this.zzdb = f2;
        this.zzdc = f3;
        this.zzdq = z;
        this.zzct = z2;
        this.zzdr = z3;
        this.zzds = f4;
        this.zzdt = f5;
        this.zzdu = f6;
        this.alpha = f7;
        this.zzcs = f8;
    }
}
