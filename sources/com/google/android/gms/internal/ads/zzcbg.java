package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcbg implements zzaif<Object> {
    private WeakReference<zzcbc> zzgcw;

    private zzcbg(zzcbc zzcbcVar) {
        this.zzgcw = new WeakReference<>(zzcbcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zza(Object obj, Map<String, String> map) {
        zzbsd zzbsdVar;
        zzcbc zzcbcVar = this.zzgcw.get();
        if (zzcbcVar == null) {
            return;
        }
        zzbsdVar = zzcbcVar.zzgci;
        zzbsdVar.onAdImpression();
    }
}
