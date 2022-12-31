package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaft extends zzgw implements zzafr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaft(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final void zza(zzaff zzaffVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzaffVar);
        zzb(1, zzdo);
    }
}
