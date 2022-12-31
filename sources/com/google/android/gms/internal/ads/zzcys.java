package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcys implements zzvc {
    @GuardedBy("this")
    private zzww zzgyk;

    @Override // com.google.android.gms.internal.ads.zzvc
    public final synchronized void onAdClicked() {
        zzww zzwwVar = this.zzgyk;
        if (zzwwVar != null) {
            try {
                zzwwVar.onAdClicked();
            } catch (RemoteException e2) {
                zzazk.zzd("Remote Exception at onAdClicked.", e2);
            }
        }
    }

    public final synchronized void zzb(zzww zzwwVar) {
        this.zzgyk = zzwwVar;
    }
}
