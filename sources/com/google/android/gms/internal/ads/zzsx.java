package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzsx extends zzgw implements zzsv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void onAdDismissedFullScreenContent() throws RemoteException {
        zzb(2, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void onAdShowedFullScreenContent() throws RemoteException {
        zzb(1, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzb(zzvg zzvgVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzvgVar);
        zzb(3, zzdo);
    }
}
