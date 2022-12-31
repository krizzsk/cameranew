package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class PolygonOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolygonOptions> CREATOR = new n();
    private int fillColor;
    private int strokeColor;
    private float zzcr;
    private float zzcs;
    private boolean zzct;
    private boolean zzcu;
    @Nullable
    private List<PatternItem> zzcv;
    private final List<LatLng> zzdx;
    private final List<List<LatLng>> zzdy;
    private boolean zzdz;
    private int zzea;

    public PolygonOptions() {
        this.zzcr = 10.0f;
        this.strokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.fillColor = 0;
        this.zzcs = 0.0f;
        this.zzct = true;
        this.zzdz = false;
        this.zzcu = false;
        this.zzea = 0;
        this.zzcv = null;
        this.zzdx = new ArrayList();
        this.zzdy = new ArrayList();
    }

    public final int Q() {
        return this.fillColor;
    }

    public final List<LatLng> R() {
        return this.zzdx;
    }

    public final int S() {
        return this.strokeColor;
    }

    public final int T() {
        return this.zzea;
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
        return this.zzdz;
    }

    public final boolean Z() {
        return this.zzct;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 2, R(), false);
        com.google.android.gms.common.internal.safeparcel.a.p(parcel, 3, this.zzdy, false);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 4, V());
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 5, S());
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 6, Q());
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 7, W());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 8, Z());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 9, Y());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 10, X());
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 11, T());
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 12, U(), false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolygonOptions(List<LatLng> list, List list2, float f2, int i2, int i3, float f3, boolean z, boolean z2, boolean z3, int i4, @Nullable List<PatternItem> list3) {
        this.zzcr = 10.0f;
        this.strokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.fillColor = 0;
        this.zzcs = 0.0f;
        this.zzct = true;
        this.zzdz = false;
        this.zzcu = false;
        this.zzea = 0;
        this.zzcv = null;
        this.zzdx = list;
        this.zzdy = list2;
        this.zzcr = f2;
        this.strokeColor = i2;
        this.fillColor = i3;
        this.zzcs = f3;
        this.zzct = z;
        this.zzdz = z2;
        this.zzcu = z3;
        this.zzea = i4;
        this.zzcv = list3;
    }
}
