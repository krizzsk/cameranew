package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest$ErrorCode;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzaoo implements Runnable {
    private final /* synthetic */ zzaol zzdoh;
    private final /* synthetic */ AdRequest$ErrorCode zzdoi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaoo(zzaol zzaolVar, AdRequest$ErrorCode adRequest$ErrorCode) {
        this.zzdoh = zzaolVar;
        this.zzdoi = adRequest$ErrorCode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzank zzankVar;
        try {
            zzankVar = this.zzdoh.zzdnw;
            zzankVar.onAdFailedToLoad(zzaox.zza(this.zzdoi));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }
}
