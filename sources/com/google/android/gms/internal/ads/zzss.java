package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzss extends zzgw implements zzsq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzss(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void onAppOpenAdClosed() throws RemoteException {
        zzb(1, zzdo());
    }
}
