package com.google.android.gms.internal.ads;

import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzaom implements Runnable {
    private final /* synthetic */ zzaol zzdoh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaom(zzaol zzaolVar) {
        this.zzdoh = zzaolVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzank zzankVar;
        try {
            zzankVar = this.zzdoh.zzdnw;
            zzankVar.onAdLoaded();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }
}
