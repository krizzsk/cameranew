package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbis implements zzeqb<com.google.android.gms.ads.internal.util.zzay> {
    private final zzeqo<Context> zzewk;

    public zzbis(zzeqo<Context> zzeqoVar) {
        this.zzewk = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (com.google.android.gms.ads.internal.util.zzay) zzeqh.zza(new com.google.android.gms.ads.internal.util.zzay(this.zzewk.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
