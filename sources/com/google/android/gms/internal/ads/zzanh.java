package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzanh extends zzgy implements zzane {
    public zzanh() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzane zzac(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (queryLocalInterface instanceof zzane) {
            return (zzane) queryLocalInterface;
        }
        return new zzang(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzanj zzdd = zzdd(parcel.readString());
            parcel2.writeNoException();
            zzgx.zza(parcel2, zzdd);
        } else if (i2 == 2) {
            boolean zzde = zzde(parcel.readString());
            parcel2.writeNoException();
            zzgx.writeBoolean(parcel2, zzde);
        } else if (i2 != 3) {
            return false;
        } else {
            zzapk zzdf = zzdf(parcel.readString());
            parcel2.writeNoException();
            zzgx.zza(parcel2, zzdf);
        }
        return true;
    }
}
