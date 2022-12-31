package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcvg implements zzeqb<zzcve> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<Executor> zzfux;
    private final zzeqo<zzchi> zzgtg;

    public zzcvg(zzeqo<Context> zzeqoVar, zzeqo<Executor> zzeqoVar2, zzeqo<zzchi> zzeqoVar3) {
        this.zzewk = zzeqoVar;
        this.zzfux = zzeqoVar2;
        this.zzgtg = zzeqoVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcve(this.zzewk.get(), this.zzfux.get(), this.zzgtg.get());
    }
}
