package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.maps.zzaf;
import com.google.android.gms.internal.maps.zzag;
/* loaded from: classes2.dex */
public final class TileOverlayOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new w();
    private float zzcs;
    private boolean zzct;
    private float zzda;
    private zzaf zzei;
    private c zzej;
    private boolean zzek;

    public TileOverlayOptions() {
        this.zzct = true;
        this.zzek = true;
        this.zzda = 0.0f;
    }

    public final boolean Q() {
        return this.zzek;
    }

    public final float R() {
        return this.zzda;
    }

    public final float S() {
        return this.zzcs;
    }

    public final boolean T() {
        return this.zzct;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 2, this.zzei.asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 3, T());
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 4, S());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 5, Q());
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 6, R());
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TileOverlayOptions(IBinder iBinder, boolean z, float f2, boolean z2, float f3) {
        this.zzct = true;
        this.zzek = true;
        this.zzda = 0.0f;
        zzaf zzk = zzag.zzk(iBinder);
        this.zzei = zzk;
        this.zzej = zzk == null ? null : new v(this);
        this.zzct = z;
        this.zzcs = f2;
        this.zzek = z2;
        this.zzda = f3;
    }
}
