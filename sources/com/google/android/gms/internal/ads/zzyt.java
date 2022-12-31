package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzyt extends zzgw implements zzyr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final void onAdMetadataChanged() throws RemoteException {
        zzb(1, zzdo());
    }
}
