package com.google.android.gms.internal.ads;

import android.view.View;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcxb implements com.google.android.gms.ads.internal.zzg {
    @GuardedBy("this")
    private com.google.android.gms.ads.internal.zzg zzgxe;

    public final synchronized void zza(com.google.android.gms.ads.internal.zzg zzgVar) {
        this.zzgxe = zzgVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzh(View view) {
        com.google.android.gms.ads.internal.zzg zzgVar = this.zzgxe;
        if (zzgVar != null) {
            zzgVar.zzh(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzkc() {
        com.google.android.gms.ads.internal.zzg zzgVar = this.zzgxe;
        if (zzgVar != null) {
            zzgVar.zzkc();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzkd() {
        com.google.android.gms.ads.internal.zzg zzgVar = this.zzgxe;
        if (zzgVar != null) {
            zzgVar.zzkd();
        }
    }
}
