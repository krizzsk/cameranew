package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzafu extends zzgw implements zzafs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafs
    public final void zza(zzafj zzafjVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzafjVar);
        zzb(1, zzdo);
    }
}
