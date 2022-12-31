package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcng implements zzeqb<zzcnc> {
    private final zzeqo<zzdzv> zzewf;
    private final zzeqo<zzcqb> zzfaa;
    private final zzeqo<zzcme> zzfea;
    private final zzeqo<ScheduledExecutorService> zzfrq;
    private final zzeqo<zzdnp> zzfvf;

    private zzcng(zzeqo<zzdnp> zzeqoVar, zzeqo<zzcme> zzeqoVar2, zzeqo<zzdzv> zzeqoVar3, zzeqo<ScheduledExecutorService> zzeqoVar4, zzeqo<zzcqb> zzeqoVar5) {
        this.zzfvf = zzeqoVar;
        this.zzfea = zzeqoVar2;
        this.zzewf = zzeqoVar3;
        this.zzfrq = zzeqoVar4;
        this.zzfaa = zzeqoVar5;
    }

    public static zzcng zzf(zzeqo<zzdnp> zzeqoVar, zzeqo<zzcme> zzeqoVar2, zzeqo<zzdzv> zzeqoVar3, zzeqo<ScheduledExecutorService> zzeqoVar4, zzeqo<zzcqb> zzeqoVar5) {
        return new zzcng(zzeqoVar, zzeqoVar2, zzeqoVar3, zzeqoVar4, zzeqoVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcnc(this.zzfvf.get(), this.zzfea.get(), this.zzewf.get(), this.zzfrq.get(), this.zzfaa.get());
    }
}
