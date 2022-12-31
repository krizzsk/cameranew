package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzakd extends zzgw implements zzakb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final void onInstreamAdFailedToLoad(int i2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i2);
        zzb(2, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final void zza(zzajv zzajvVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzajvVar);
        zzb(1, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final void zze(zzvg zzvgVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzvgVar);
        zzb(3, zzdo);
    }
}
