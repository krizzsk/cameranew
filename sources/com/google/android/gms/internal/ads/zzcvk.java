package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcvk implements zzeqb<zzcvf> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<zzchi> zzgtg;

    public zzcvk(zzeqo<Context> zzeqoVar, zzeqo<zzchi> zzeqoVar2) {
        this.zzewk = zzeqoVar;
        this.zzgtg = zzeqoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcvf(this.zzewk.get(), this.zzgtg.get());
    }
}
