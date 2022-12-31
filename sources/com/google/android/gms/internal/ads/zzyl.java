package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzyl extends zzgw implements zzyj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzyj
    public final void onAdMuted() throws RemoteException {
        zzb(1, zzdo());
    }
}
