package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbxm implements zzeqb<zzbxg> {
    private final zzeqo<Set<zzbya<zzbxl>>> zzfvd;

    public zzbxm(zzeqo<Set<zzbya<zzbxl>>> zzeqoVar) {
        this.zzfvd = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzbxg(this.zzfvd.get());
    }
}
