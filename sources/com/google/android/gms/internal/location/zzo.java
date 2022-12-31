package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.location.c0;
import com.google.android.gms.location.d0;
/* loaded from: classes2.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();
    private int zzcg;
    private zzm zzch;
    private c0 zzci;
    private zzaj zzcj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(int i2, zzm zzmVar, IBinder iBinder, IBinder iBinder2) {
        this.zzcg = i2;
        this.zzch = zzmVar;
        zzaj zzajVar = null;
        this.zzci = iBinder == null ? null : d0.zza(iBinder);
        if (iBinder2 != null && iBinder2 != null) {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzajVar = queryLocalInterface instanceof zzaj ? (zzaj) queryLocalInterface : new zzal(iBinder2);
        }
        this.zzcj = zzajVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 1, this.zzcg);
        a.t(parcel, 2, this.zzch, i2, false);
        c0 c0Var = this.zzci;
        a.l(parcel, 3, c0Var == null ? null : c0Var.asBinder(), false);
        zzaj zzajVar = this.zzcj;
        a.l(parcel, 4, zzajVar != null ? zzajVar.asBinder() : null, false);
        a.b(parcel, a);
    }
}
