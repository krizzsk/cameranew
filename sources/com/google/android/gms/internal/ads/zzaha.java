package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzaha implements Runnable {
    private final /* synthetic */ AdManagerAdView zzdgo;
    private final /* synthetic */ zzxl zzdgp;
    private final /* synthetic */ zzahb zzdgq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaha(zzahb zzahbVar, AdManagerAdView adManagerAdView, zzxl zzxlVar) {
        this.zzdgq = zzahbVar;
        this.zzdgo = adManagerAdView;
        this.zzdgp = zzxlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener;
        if (!this.zzdgo.zza(this.zzdgp)) {
            zzazk.zzex("Could not bind.");
            return;
        }
        onAdManagerAdViewLoadedListener = this.zzdgq.zzdgr;
        onAdManagerAdViewLoadedListener.onAdManagerAdViewLoaded(this.zzdgo);
    }
}
