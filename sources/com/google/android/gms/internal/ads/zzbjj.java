package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbjj implements zzbjf {
    private final com.google.android.gms.ads.internal.util.zzf zzeaw = com.google.android.gms.ads.internal.zzr.zzkv().zzxs();

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void zzm(Map<String, String> map) {
        if (map.isEmpty()) {
            return;
        }
        String str = map.get("gad_idless");
        if (str != null) {
            map.remove("gad_idless");
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcos)).booleanValue()) {
                this.zzeaw.zzar(Boolean.parseBoolean(str));
            }
        }
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcor)).booleanValue()) {
            com.google.android.gms.ads.internal.zzr.zzlp().setConsent(bundle);
        }
    }
}
