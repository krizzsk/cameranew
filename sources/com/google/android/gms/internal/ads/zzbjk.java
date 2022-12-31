package com.google.android.gms.internal.ads;

import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbjk implements zzbjf {
    private com.google.android.gms.ads.internal.util.zzf zzedg;

    public zzbjk(com.google.android.gms.ads.internal.util.zzf zzfVar) {
        this.zzedg = zzfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void zzm(Map<String, String> map) {
        this.zzedg.zzaq(Boolean.parseBoolean(map.get("content_vertical_opted_out")));
    }
}
