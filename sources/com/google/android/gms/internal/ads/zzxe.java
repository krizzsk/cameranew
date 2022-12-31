package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzxe extends zzgw implements zzxc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void onAdLoaded() throws RemoteException {
        zzb(1, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zzc(zzvg zzvgVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzvgVar);
        zzb(2, zzdo);
    }
}
