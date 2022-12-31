package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcsx implements zzeqb<zzcsw> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<Executor> zzfux;
    private final zzeqo<zzbzy> zzgtg;
    private final zzeqo<zzdmu> zzgua;

    public zzcsx(zzeqo<Context> zzeqoVar, zzeqo<Executor> zzeqoVar2, zzeqo<zzbzy> zzeqoVar3, zzeqo<zzdmu> zzeqoVar4) {
        this.zzewk = zzeqoVar;
        this.zzfux = zzeqoVar2;
        this.zzgtg = zzeqoVar3;
        this.zzgua = zzeqoVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcsw(this.zzewk.get(), this.zzfux.get(), this.zzgtg.get(), this.zzgua.get());
    }
}
