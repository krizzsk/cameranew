package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzahb extends zzage {
    private final OnAdManagerAdViewLoadedListener zzdgr;

    public zzahb(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener) {
        this.zzdgr = onAdManagerAdViewLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzagf
    public final void zza(zzxl zzxlVar, b bVar) {
        if (zzxlVar == null || bVar == null) {
            return;
        }
        AdManagerAdView adManagerAdView = new AdManagerAdView((Context) d.y0(bVar));
        try {
            if (zzxlVar.zzkk() instanceof zzvi) {
                zzvi zzviVar = (zzvi) zzxlVar.zzkk();
                adManagerAdView.setAdListener(zzviVar != null ? zzviVar.getAdListener() : null);
            }
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
        try {
            if (zzxlVar.zzkj() instanceof zzrg) {
                zzrg zzrgVar = (zzrg) zzxlVar.zzkj();
                adManagerAdView.setAppEventListener(zzrgVar != null ? zzrgVar.getAppEventListener() : null);
            }
        } catch (RemoteException e3) {
            zzazk.zzc("", e3);
        }
        zzaza.zzaac.post(new zzaha(this, adManagerAdView, zzxlVar));
    }
}
