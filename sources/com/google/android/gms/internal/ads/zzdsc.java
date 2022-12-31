package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdsc implements zzeqb<zzdrz> {
    private final zzeqo<zzdsf> zzewu;
    private final zzeqo<ScheduledExecutorService> zzfrq;
    private final zzeqo<zzdso> zzhrp;

    public zzdsc(zzeqo<zzdsf> zzeqoVar, zzeqo<zzdso> zzeqoVar2, zzeqo<ScheduledExecutorService> zzeqoVar3) {
        this.zzewu = zzeqoVar;
        this.zzhrp = zzeqoVar2;
        this.zzfrq = zzeqoVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        Object obj;
        zzepv zzav = zzeqc.zzav(this.zzewu);
        zzepv zzav2 = zzeqc.zzav(this.zzhrp);
        ScheduledExecutorService scheduledExecutorService = this.zzfrq.get();
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdam)).booleanValue()) {
            obj = new zzdsb((zzdrz) zzav.get(), scheduledExecutorService);
        } else {
            obj = (zzdrz) zzav2.get();
        }
        return (zzdrz) zzeqh.zza(obj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
