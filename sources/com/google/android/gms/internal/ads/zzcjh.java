package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcjh implements zzeqb<Set<zzbya<zzdrp>>> {
    private final zzeqo<zzcjx> zzewe;
    private final zzeqo<Executor> zzewf;

    private zzcjh(zzeqo<Executor> zzeqoVar, zzeqo<zzcjx> zzeqoVar2) {
        this.zzewf = zzeqoVar;
        this.zzewe = zzeqoVar2;
    }

    public static zzcjh zzac(zzeqo<Executor> zzeqoVar, zzeqo<zzcjx> zzeqoVar2) {
        return new zzcjh(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        Set emptySet;
        Executor executor = this.zzewf.get();
        zzcjx zzcjxVar = this.zzewe.get();
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvg)).booleanValue()) {
            emptySet = Collections.singleton(new zzbya(zzcjxVar, executor));
        } else {
            emptySet = Collections.emptySet();
        }
        return (Set) zzeqh.zza(emptySet, "Cannot return null from a non-@Nullable @Provides method");
    }
}
