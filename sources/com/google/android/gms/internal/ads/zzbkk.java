package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbkk implements zzeqb<Set<zzbya<zzqw>>> {
    private final zzeqo<zzbjz> zzewe;
    private final zzeqo<Executor> zzewf;
    private final zzeqo<JSONObject> zzftd;

    private zzbkk(zzeqo<zzbjz> zzeqoVar, zzeqo<Executor> zzeqoVar2, zzeqo<JSONObject> zzeqoVar3) {
        this.zzewe = zzeqoVar;
        this.zzewf = zzeqoVar2;
        this.zzftd = zzeqoVar3;
    }

    public static zzbkk zze(zzeqo<zzbjz> zzeqoVar, zzeqo<Executor> zzeqoVar2, zzeqo<JSONObject> zzeqoVar3) {
        return new zzbkk(zzeqoVar, zzeqoVar2, zzeqoVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        Set singleton;
        zzbjz zzbjzVar = this.zzewe.get();
        Executor executor = this.zzewf.get();
        if (this.zzftd.get() == null) {
            singleton = Collections.emptySet();
        } else {
            singleton = Collections.singleton(new zzbya(zzbjzVar, executor));
        }
        return (Set) zzeqh.zza(singleton, "Cannot return null from a non-@Nullable @Provides method");
    }
}
