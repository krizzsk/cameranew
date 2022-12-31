package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbgv implements zzeqb<zzaue> {
    private final zzeqo<Context> zzewk;

    public zzbgv(zzeqo<Context> zzeqoVar) {
        this.zzewk = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        Context context = this.zzewk.get();
        return (zzaue) zzeqh.zza(new zzauc(context, new zzauj(context).zzwk()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
