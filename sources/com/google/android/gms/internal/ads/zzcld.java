package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcld implements zzeqb<Set<zzbya<zzbrm>>> {
    private final zzeqo<Executor> zzewf;
    private final zzeqo<zzclo> zzgjp;
    private final zzcle zzgmn;

    private zzcld(zzcle zzcleVar, zzeqo<zzclo> zzeqoVar, zzeqo<Executor> zzeqoVar2) {
        this.zzgmn = zzcleVar;
        this.zzgjp = zzeqoVar;
        this.zzewf = zzeqoVar2;
    }

    public static zzcld zza(zzcle zzcleVar, zzeqo<zzclo> zzeqoVar, zzeqo<Executor> zzeqoVar2) {
        return new zzcld(zzcleVar, zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (Set) zzeqh.zza(zzcle.zze(this.zzgjp.get(), this.zzewf.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
