package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzaqc implements Runnable {
    private final /* synthetic */ AdOverlayInfoParcel zzdpa;
    private final /* synthetic */ zzaqa zzdpb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqc(zzaqa zzaqaVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdpb = zzaqaVar;
        this.zzdpa = adOverlayInfoParcel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        com.google.android.gms.ads.internal.zzr.zzkq();
        activity = this.zzdpb.zzdoy;
        com.google.android.gms.ads.internal.overlay.zzm.zza(activity, this.zzdpa, true);
    }
}
