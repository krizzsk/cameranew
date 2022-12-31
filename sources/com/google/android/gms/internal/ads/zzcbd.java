package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzcbd implements zzaif<Object> {
    private WeakReference<zzcbc> zzgcw;

    private zzcbd(zzcbc zzcbcVar) {
        this.zzgcw = new WeakReference<>(zzcbcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zza(Object obj, Map<String, String> map) {
        zzcbc zzcbcVar = this.zzgcw.get();
        if (zzcbcVar == null) {
            return;
        }
        zzcbc.zzb(zzcbcVar).onAdClicked();
    }
}
