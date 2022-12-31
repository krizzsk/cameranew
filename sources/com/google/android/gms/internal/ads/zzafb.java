package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzafb extends zzgy implements zzaey {
    public zzafb() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    public static zzaey zzq(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
        if (queryLocalInterface instanceof zzaey) {
            return (zzaey) queryLocalInterface;
        }
        return new zzafa(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zza(b.a.x0(parcel.readStrongBinder()));
        } else if (i2 == 2) {
            unregisterNativeAd();
        } else if (i2 != 3) {
            return false;
        } else {
            zzf(b.a.x0(parcel.readStrongBinder()));
        }
        parcel2.writeNoException();
        return true;
    }
}
