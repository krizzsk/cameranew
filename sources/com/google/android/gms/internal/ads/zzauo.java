package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzauo extends zzgw implements zzaup {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzauo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaup
    public final void zza(zzauk zzaukVar, String str, String str2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzaukVar);
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzb(2, zzdo);
    }
}
