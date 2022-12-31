package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcaw implements zzeqb<Set<String>> {
    private final zzeqo<zzcco> zzfuw;

    public zzcaw(zzeqo<zzcco> zzeqoVar) {
        this.zzfuw = zzeqoVar;
    }

    public static Set<String> zza(zzcco zzccoVar) {
        Set emptySet;
        if (zzccoVar.zzaom() != null) {
            emptySet = Collections.singleton("banner");
        } else {
            emptySet = Collections.emptySet();
        }
        return (Set) zzeqh.zza(emptySet, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zza(this.zzfuw.get());
    }
}
