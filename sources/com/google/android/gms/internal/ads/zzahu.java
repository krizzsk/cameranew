package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzahu implements zzaif<zzbeb> {
    @Override // com.google.android.gms.internal.ads.zzaif
    public final /* synthetic */ void zza(zzbeb zzbebVar, Map map) {
        JSONObject zztk;
        zzbeb zzbebVar2 = zzbebVar;
        zzaef zzadi = zzbebVar2.zzadi();
        if (zzadi != null && (zztk = zzadi.zztk()) != null) {
            zzbebVar2.zza("nativeAdViewSignalsReady", zztk);
        } else {
            zzbebVar2.zza("nativeAdViewSignalsReady", new JSONObject());
        }
    }
}
