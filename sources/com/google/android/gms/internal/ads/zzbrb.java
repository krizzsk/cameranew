package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbrb implements zzeqb<Context> {
    private final zzeqo<Context> zzfxw;
    private final zzbqx zzfyz;

    private zzbrb(zzbqx zzbqxVar, zzeqo<Context> zzeqoVar) {
        this.zzfyz = zzbqxVar;
        this.zzfxw = zzeqoVar;
    }

    public static zzbrb zza(zzbqx zzbqxVar, zzeqo<Context> zzeqoVar) {
        return new zzbrb(zzbqxVar, zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (Context) zzeqh.zza(this.zzfyz.zzce(this.zzfxw.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
