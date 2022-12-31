package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzahe implements Runnable {
    private final /* synthetic */ zzxl zzdgp;
    private final /* synthetic */ PublisherAdView zzdgu;
    private final /* synthetic */ zzahf zzdgv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahe(zzahf zzahfVar, PublisherAdView publisherAdView, zzxl zzxlVar) {
        this.zzdgv = zzahfVar;
        this.zzdgu = publisherAdView;
        this.zzdgp = zzxlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener;
        if (!this.zzdgu.zza(this.zzdgp)) {
            zzazk.zzex("Could not bind.");
            return;
        }
        onPublisherAdViewLoadedListener = this.zzdgv.zzdgw;
        onPublisherAdViewLoadedListener.onPublisherAdViewLoaded(this.zzdgu);
    }
}
