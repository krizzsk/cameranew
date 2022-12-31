package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzavw extends zzgw implements zzavu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void onRewardedAdFailedToLoad(int i2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i2);
        zzb(2, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void onRewardedAdLoaded() throws RemoteException {
        zzb(1, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzj(zzvg zzvgVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzvgVar);
        zzb(3, zzdo);
    }
}
