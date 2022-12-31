package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzagz extends zzafw {
    private final /* synthetic */ zzagx zzdgn;

    private zzagz(zzagx zzagxVar) {
        this.zzdgn = zzagxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafx
    public final void zza(zzafn zzafnVar, String str) {
        NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener;
        NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener2;
        NativeCustomTemplateAd zzb;
        onCustomClickListener = this.zzdgn.zzdgl;
        if (onCustomClickListener == null) {
            return;
        }
        onCustomClickListener2 = this.zzdgn.zzdgl;
        zzb = this.zzdgn.zzb(zzafnVar);
        onCustomClickListener2.onCustomClick(zzb, str);
    }
}
