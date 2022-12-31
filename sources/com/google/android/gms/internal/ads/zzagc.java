package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzagc extends zzgw implements zzagd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzagd
    public final void zztw() throws RemoteException {
        zzb(2, zzdo());
    }
}
