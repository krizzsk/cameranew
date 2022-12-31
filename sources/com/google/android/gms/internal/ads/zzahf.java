package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzahf extends zzage {
    private final OnPublisherAdViewLoadedListener zzdgw;

    public zzahf(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.zzdgw = onPublisherAdViewLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzagf
    public final void zza(zzxl zzxlVar, b bVar) {
        if (zzxlVar == null || bVar == null) {
            return;
        }
        PublisherAdView publisherAdView = new PublisherAdView((Context) d.y0(bVar));
        try {
            if (zzxlVar.zzkk() instanceof zzvi) {
                zzvi zzviVar = (zzvi) zzxlVar.zzkk();
                publisherAdView.setAdListener(zzviVar != null ? zzviVar.getAdListener() : null);
            }
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
        try {
            if (zzxlVar.zzkj() instanceof zzvy) {
                zzvy zzvyVar = (zzvy) zzxlVar.zzkj();
                publisherAdView.setAppEventListener(zzvyVar != null ? zzvyVar.getAppEventListener() : null);
            }
        } catch (RemoteException e3) {
            zzazk.zzc("", e3);
        }
        zzaza.zzaac.post(new zzahe(this, publisherAdView, zzxlVar));
    }
}
