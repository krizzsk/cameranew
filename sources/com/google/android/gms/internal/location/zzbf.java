package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.location.f0;
import com.google.android.gms.location.g0;
import com.google.android.gms.location.i0;
import com.google.android.gms.location.j0;
/* loaded from: classes2.dex */
public final class zzbf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbf> CREATOR = new zzbg();
    private PendingIntent zzbv;
    private int zzcg;
    private zzaj zzcj;
    private zzbd zzdl;
    private i0 zzdm;
    private f0 zzdn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbf(int i2, zzbd zzbdVar, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        this.zzcg = i2;
        this.zzdl = zzbdVar;
        zzaj zzajVar = null;
        this.zzdm = iBinder == null ? null : j0.zzc(iBinder);
        this.zzbv = pendingIntent;
        this.zzdn = iBinder2 == null ? null : g0.zzb(iBinder2);
        if (iBinder3 != null && iBinder3 != null) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzajVar = queryLocalInterface instanceof zzaj ? (zzaj) queryLocalInterface : new zzal(iBinder3);
        }
        this.zzcj = zzajVar;
    }

    public static zzbf zza(f0 f0Var, @Nullable zzaj zzajVar) {
        return new zzbf(2, null, null, null, f0Var.asBinder(), zzajVar != null ? zzajVar.asBinder() : null);
    }

    public static zzbf zza(i0 i0Var, @Nullable zzaj zzajVar) {
        return new zzbf(2, null, i0Var.asBinder(), null, null, zzajVar != null ? zzajVar.asBinder() : null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 1, this.zzcg);
        a.t(parcel, 2, this.zzdl, i2, false);
        i0 i0Var = this.zzdm;
        a.l(parcel, 3, i0Var == null ? null : i0Var.asBinder(), false);
        a.t(parcel, 4, this.zzbv, i2, false);
        f0 f0Var = this.zzdn;
        a.l(parcel, 5, f0Var == null ? null : f0Var.asBinder(), false);
        zzaj zzajVar = this.zzcj;
        a.l(parcel, 6, zzajVar != null ? zzajVar.asBinder() : null, false);
        a.b(parcel, a);
    }
}
