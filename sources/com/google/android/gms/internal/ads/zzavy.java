package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzavy extends zzgw implements zzavz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    @Override // com.google.android.gms.internal.ads.zzavz
    public final void zza(zzavl zzavlVar, String str, String str2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzavlVar);
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzb(2, zzdo);
    }
}
