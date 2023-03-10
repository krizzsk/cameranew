package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zztl extends zzgw implements zzti {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zztl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    @Override // com.google.android.gms.internal.ads.zzti
    public final zztc zza(zzth zzthVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzthVar);
        Parcel zza = zza(1, zzdo);
        zztc zztcVar = (zztc) zzgx.zza(zza, zztc.CREATOR);
        zza.recycle();
        return zztcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzti
    public final long zzb(zzth zzthVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzthVar);
        Parcel zza = zza(3, zzdo);
        long readLong = zza.readLong();
        zza.recycle();
        return readLong;
    }

    @Override // com.google.android.gms.internal.ads.zzti
    public final zztc zzc(zzth zzthVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzthVar);
        Parcel zza = zza(2, zzdo);
        zztc zztcVar = (zztc) zzgx.zza(zza, zztc.CREATOR);
        zza.recycle();
        return zztcVar;
    }
}
