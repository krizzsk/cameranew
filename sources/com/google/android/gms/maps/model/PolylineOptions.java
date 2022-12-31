package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class PolylineOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new o();
    private int color;
    private float width;
    private float zzcs;
    private boolean zzct;
    private boolean zzcu;
    private final List<LatLng> zzdx;
    private boolean zzdz;
    @NonNull
    private Cap zzec;
    @NonNull
    private Cap zzed;
    private int zzee;
    @Nullable
    private List<PatternItem> zzef;

    public PolylineOptions() {
        this.width = 10.0f;
        this.color = ViewCompat.MEASURED_STATE_MASK;
        this.zzcs = 0.0f;
        this.zzct = true;
        this.zzdz = false;
        this.zzcu = false;
        this.zzec = new ButtCap();
        this.zzed = new ButtCap();
        this.zzee = 0;
        this.zzef = null;
        this.zzdx = new ArrayList();
    }

    public final int Q() {
        return this.color;
    }

    @NonNull
    public final Cap R() {
        return this.zzed;
    }

    public final int S() {
        return this.zzee;
    }

    @Nullable
    public final List<PatternItem> T() {
        return this.zzef;
    }

    public final List<LatLng> U() {
        return this.zzdx;
    }

    @NonNull
    public final Cap V() {
        return this.zzec;
    }

    public final float W() {
        return this.width;
    }

    public final float X() {
        return this.zzcs;
    }

    public final boolean Y() {
        return this.zzcu;
    }

    public final boolean Z() {
        return this.zzdz;
    }

    public final boolean a0() {
        return this.zzct;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 2, U(), false);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 3, W());
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 4, Q());
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 5, X());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 6, a0());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 7, Z());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 8, Y());
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 9, V(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 10, R(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 11, S());
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 12, T(), false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolylineOptions(List list, float f2, int i2, float f3, boolean z, boolean z2, boolean z3, @Nullable Cap cap, @Nullable Cap cap2, int i3, @Nullable List<PatternItem> list2) {
        this.width = 10.0f;
        this.color = ViewCompat.MEASURED_STATE_MASK;
        this.zzcs = 0.0f;
        this.zzct = true;
        this.zzdz = false;
        this.zzcu = false;
        this.zzec = new ButtCap();
        this.zzed = new ButtCap();
        this.zzee = 0;
        this.zzef = null;
        this.zzdx = list;
        this.width = f2;
        this.color = i2;
        this.zzcs = f3;
        this.zzct = z;
        this.zzdz = z2;
        this.zzcu = z3;
        if (cap != null) {
            this.zzec = cap;
        }
        if (cap2 != null) {
            this.zzed = cap2;
        }
        this.zzee = i3;
        this.zzef = list2;
    }
}
