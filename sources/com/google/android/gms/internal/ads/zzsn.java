package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzsn extends zzgy implements zzsk {
    public zzsn() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 2) {
            zzxl zzdx = zzdx();
            parcel2.writeNoException();
            zzgx.zza(parcel2, zzdx);
            return true;
        }
        zzsq zzsqVar = null;
        zzsv zzsvVar = null;
        if (i2 == 3) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
                if (queryLocalInterface instanceof zzsq) {
                    zzsqVar = (zzsq) queryLocalInterface;
                } else {
                    zzsqVar = new zzss(readStrongBinder);
                }
            }
            zza(zzsqVar);
            parcel2.writeNoException();
            return true;
        } else if (i2 != 4) {
            if (i2 == 5) {
                zzyx zzki = zzki();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzki);
                return true;
            } else if (i2 != 6) {
                return false;
            } else {
                setImmersiveMode(zzgx.zza(parcel));
                parcel2.writeNoException();
                return true;
            }
        } else {
            b x0 = b.a.x0(parcel.readStrongBinder());
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
                if (queryLocalInterface2 instanceof zzsv) {
                    zzsvVar = (zzsv) queryLocalInterface2;
                } else {
                    zzsvVar = new zzsx(readStrongBinder2);
                }
            }
            zza(x0, zzsvVar);
            parcel2.writeNoException();
            return true;
        }
    }
}
