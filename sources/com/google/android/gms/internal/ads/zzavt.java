package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzavt extends zzgw implements zzavr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedAdClosed() throws RemoteException {
        zzb(2, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedAdFailedToShow(int i2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i2);
        zzb(4, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedAdOpened() throws RemoteException {
        zzb(1, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void zza(zzavl zzavlVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzavlVar);
        zzb(3, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void zzi(zzvg zzvgVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzvgVar);
        zzb(5, zzdo);
    }
}
