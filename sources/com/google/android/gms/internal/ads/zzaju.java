package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzaju extends zzgy implements zzajv {
    public zzaju() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzajw zzajyVar;
        if (i2 == 3) {
            zzzc videoController = getVideoController();
            parcel2.writeNoException();
            zzgx.zza(parcel2, videoController);
            return true;
        } else if (i2 == 4) {
            destroy();
            parcel2.writeNoException();
            return true;
        } else if (i2 != 5) {
            if (i2 == 6) {
                zzr(b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i2 != 7) {
                return false;
            } else {
                zzaem zzty = zzty();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzty);
                return true;
            }
        } else {
            b x0 = b.a.x0(parcel.readStrongBinder());
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzajyVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                if (queryLocalInterface instanceof zzajw) {
                    zzajyVar = (zzajw) queryLocalInterface;
                } else {
                    zzajyVar = new zzajy(readStrongBinder);
                }
            }
            zza(x0, zzajyVar);
            parcel2.writeNoException();
            return true;
        }
    }
}
