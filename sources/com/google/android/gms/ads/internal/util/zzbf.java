package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.ads.zzgx;
import com.google.android.gms.internal.ads.zzgy;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzbf extends zzgy implements zzbg {
    public zzbf() {
        super("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            boolean zzd = zzd(b.a.x0(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            zzgx.writeBoolean(parcel2, zzd);
        } else if (i2 != 2) {
            return false;
        } else {
            zzap(b.a.x0(parcel.readStrongBinder()));
            parcel2.writeNoException();
        }
        return true;
    }
}
