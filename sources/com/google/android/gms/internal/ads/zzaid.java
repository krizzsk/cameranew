package com.google.android.gms.internal.ads;

import com.tapjoy.TJAdUnitConstants;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzaid implements zzaif<zzbeb> {
    @Override // com.google.android.gms.internal.ads.zzaif
    public final /* synthetic */ void zza(zzbeb zzbebVar, Map map) {
        zzbeb zzbebVar2 = zzbebVar;
        if (map.keySet().contains(TJAdUnitConstants.String.VIDEO_START)) {
            zzbebVar2.zzba(true);
        }
        if (map.keySet().contains("stop")) {
            zzbebVar2.zzba(false);
        }
    }
}
