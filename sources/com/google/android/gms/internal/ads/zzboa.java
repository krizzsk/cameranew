package com.google.android.gms.internal.ads;

import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzboa<AdT> implements zzeqb<zzbnx<AdT>> {
    private final zzeqo<Map<String, zzcrj<AdT>>> zzfwl;

    private zzboa(zzeqo<Map<String, zzcrj<AdT>>> zzeqoVar) {
        this.zzfwl = zzeqoVar;
    }

    public static <AdT> zzboa<AdT> zzd(zzeqo<Map<String, zzcrj<AdT>>> zzeqoVar) {
        return new zzboa<>(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzbnx(this.zzfwl.get());
    }
}
