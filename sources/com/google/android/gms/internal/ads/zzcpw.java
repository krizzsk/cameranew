package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcpw implements zzeqb<zzcpt> {
    private final zzeqo<Context> zzewk;

    private zzcpw(zzeqo<Context> zzeqoVar) {
        this.zzewk = zzeqoVar;
    }

    public static zzcpw zzaf(zzeqo<Context> zzeqoVar) {
        return new zzcpw(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcpt(this.zzewk.get());
    }
}
