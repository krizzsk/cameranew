package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcuj implements zzeqb<zzcui> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<zzcau> zzgtg;

    public zzcuj(zzeqo<Context> zzeqoVar, zzeqo<zzcau> zzeqoVar2) {
        this.zzewk = zzeqoVar;
        this.zzgtg = zzeqoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcui(this.zzewk.get(), this.zzgtg.get());
    }
}
