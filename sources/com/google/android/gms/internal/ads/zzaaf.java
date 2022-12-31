package com.google.android.gms.internal.ads;

import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzaaf implements Runnable {
    private final /* synthetic */ zzaac zzclm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaaf(zzaac zzaacVar) {
        this.zzclm = zzaacVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzwx zzwxVar;
        zzwx zzwxVar2;
        zzwxVar = this.zzclm.zzbps;
        if (zzwxVar != null) {
            try {
                zzwxVar2 = this.zzclm.zzbps;
                zzwxVar2.onAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzazk.zzd("Could not notify onAdFailedToLoad event.", e2);
            }
        }
    }
}
