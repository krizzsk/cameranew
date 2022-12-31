package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdun extends zzgw implements zzduo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdun(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    @Override // com.google.android.gms.internal.ads.zzduo
    public final zzdum zza(zzduk zzdukVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzdukVar);
        Parcel zza = zza(1, zzdo);
        zzdum zzdumVar = (zzdum) zzgx.zza(zza, zzdum.CREATOR);
        zza.recycle();
        return zzdumVar;
    }

    @Override // com.google.android.gms.internal.ads.zzduo
    public final void zza(zzduf zzdufVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzdufVar);
        zzb(2, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzduo
    public final zzduw zza(zzduu zzduuVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzduuVar);
        Parcel zza = zza(3, zzdo);
        zzduw zzduwVar = (zzduw) zzgx.zza(zza, zzduw.CREATOR);
        zza.recycle();
        return zzduwVar;
    }
}
