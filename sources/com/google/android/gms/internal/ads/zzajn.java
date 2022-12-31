package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzajn extends zzgy implements zzajk {
    public zzajn() {
        super("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public static zzajk zzaa(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
        if (queryLocalInterface instanceof zzajk) {
            return (zzajk) queryLocalInterface;
        }
        return new zzajm(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zze(parcel.createTypedArrayList(zzajh.CREATOR));
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
