package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzwy extends zzgw implements zzww {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void onAdClicked() throws RemoteException {
        zzb(1, zzdo());
    }
}
