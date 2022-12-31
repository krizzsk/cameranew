package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzagi extends zzgw implements zzagg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void zza(zzagr zzagrVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzagrVar);
        zzb(1, zzdo);
    }
}
