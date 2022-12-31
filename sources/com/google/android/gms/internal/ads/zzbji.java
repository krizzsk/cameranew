package com.google.android.gms.internal.ads;

import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbji implements zzbjf {
    private com.google.android.gms.ads.internal.util.zzf zzedg;

    public zzbji(com.google.android.gms.ads.internal.util.zzf zzfVar) {
        this.zzedg = zzfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void zzm(Map<String, String> map) {
        this.zzedg.zzap(Boolean.parseBoolean(map.get("content_url_opted_out")));
    }
}
