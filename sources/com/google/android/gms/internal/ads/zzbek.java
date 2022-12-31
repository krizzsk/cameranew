package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbek implements com.google.android.gms.ads.internal.overlay.zzq {
    @Nullable
    private com.google.android.gms.ads.internal.overlay.zzq zzdsv;
    private zzbeb zzerq;

    public zzbek(zzbeb zzbebVar, @Nullable com.google.android.gms.ads.internal.overlay.zzq zzqVar) {
        this.zzerq = zzbebVar;
        this.zzdsv = zzqVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onUserLeaveHint() {
        com.google.android.gms.ads.internal.overlay.zzq zzqVar = this.zzdsv;
        if (zzqVar != null) {
            zzqVar.onUserLeaveHint();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void zza(com.google.android.gms.ads.internal.overlay.zzn zznVar) {
        com.google.android.gms.ads.internal.overlay.zzq zzqVar = this.zzdsv;
        if (zzqVar != null) {
            zzqVar.zza(zznVar);
        }
        this.zzerq.zzacq();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void zzvo() {
        com.google.android.gms.ads.internal.overlay.zzq zzqVar = this.zzdsv;
        if (zzqVar != null) {
            zzqVar.zzvo();
        }
        this.zzerq.zzwb();
    }
}
