package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzauw extends zzgw implements zzauu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzauw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzauu
    public final void onRewardedVideoAdClosed() throws RemoteException {
        zzb(4, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzauu
    public final void onRewardedVideoAdFailedToLoad(int i2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i2);
        zzb(7, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzauu
    public final void onRewardedVideoAdLeftApplication() throws RemoteException {
        zzb(6, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzauu
    public final void onRewardedVideoAdLoaded() throws RemoteException {
        zzb(1, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzauu
    public final void onRewardedVideoAdOpened() throws RemoteException {
        zzb(2, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzauu
    public final void onRewardedVideoCompleted() throws RemoteException {
        zzb(8, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzauu
    public final void onRewardedVideoStarted() throws RemoteException {
        zzb(3, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzauu
    public final void zza(zzauk zzaukVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzaukVar);
        zzb(5, zzdo);
    }
}
