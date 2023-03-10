package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdbf implements zzeqb<zzdbd> {
    private final zzeqo<Set<String>> zzhax;

    private zzdbf(zzeqo<Set<String>> zzeqoVar) {
        this.zzhax = zzeqoVar;
    }

    public static zzdbf zzam(zzeqo<Set<String>> zzeqoVar) {
        return new zzdbf(zzeqoVar);
    }

    public static zzdbd zzd(Set<String> set) {
        return new zzdbd(set);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zzd(this.zzhax.get());
    }
}
