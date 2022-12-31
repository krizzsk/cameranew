package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzxr extends zzgy implements zzxs {
    public zzxr() {
        super("com.google.android.gms.ads.internal.client.IAdMetadataListener");
    }

    public static zzxs zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
        if (queryLocalInterface instanceof zzxs) {
            return (zzxs) queryLocalInterface;
        }
        return new zzxu(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            onAdMetadataChanged();
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
