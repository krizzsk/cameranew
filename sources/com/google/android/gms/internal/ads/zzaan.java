package com.google.android.gms.internal.ads;

import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzaan implements Runnable {
    private final /* synthetic */ zzaak zzclr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaan(zzaak zzaakVar) {
        this.zzclr = zzaakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzauu zzauuVar;
        zzauu zzauuVar2;
        zzauuVar = this.zzclr.zzclo;
        if (zzauuVar != null) {
            try {
                zzauuVar2 = this.zzclr.zzclo;
                zzauuVar2.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzazk.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", e2);
            }
        }
    }
}
