package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzang extends zzgw implements zzane {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzang(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzane
    public final zzanj zzdd(String str) throws RemoteException {
        zzanj zzanlVar;
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        Parcel zza = zza(1, zzdo);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzanlVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (queryLocalInterface instanceof zzanj) {
                zzanlVar = (zzanj) queryLocalInterface;
            } else {
                zzanlVar = new zzanl(readStrongBinder);
            }
        }
        zza.recycle();
        return zzanlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzane
    public final boolean zzde(String str) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        Parcel zza = zza(2, zzdo);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzane
    public final zzapk zzdf(String str) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        Parcel zza = zza(3, zzdo);
        zzapk zzaf = zzapn.zzaf(zza.readStrongBinder());
        zza.recycle();
        return zzaf;
    }
}
