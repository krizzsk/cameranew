package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzsr extends zzgw implements zzsp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void onAppOpenAdFailedToLoad(int i2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i2);
        zzb(2, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(zzsk zzskVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzskVar);
        zzb(1, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(zzvg zzvgVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzvgVar);
        zzb(3, zzdo);
    }
}
