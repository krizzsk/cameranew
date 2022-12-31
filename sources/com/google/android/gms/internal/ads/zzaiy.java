package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaiy extends zzgw implements zzaiz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaiy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    @Override // com.google.android.gms.internal.ads.zzaiz
    public final void zza(zzait zzaitVar, zzaix zzaixVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzaitVar);
        zzgx.zza(zzdo, zzaixVar);
        zzc(2, zzdo);
    }
}
