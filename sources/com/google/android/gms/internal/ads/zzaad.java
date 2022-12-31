package com.google.android.gms.internal.ads;

import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzaad implements Runnable {
    private final /* synthetic */ zzaaa zzclk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaad(zzaaa zzaaaVar) {
        this.zzclk = zzaaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzzy.zza(this.zzclk.zzclj) != null) {
            try {
                zzzy.zza(this.zzclk.zzclj).onAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzazk.zzd("Could not notify onAdFailedToLoad event.", e2);
            }
        }
    }
}
