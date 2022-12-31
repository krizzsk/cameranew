package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzym extends zzgy implements zzyj {
    public zzym() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdListener");
    }

    public static zzyj zzf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdListener");
        if (queryLocalInterface instanceof zzyj) {
            return (zzyj) queryLocalInterface;
        }
        return new zzyl(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            onAdMuted();
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
