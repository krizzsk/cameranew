package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcit implements zzeqb<zzcip> {
    private final zzeqo<Executor> zzewf;

    public zzcit(zzeqo<Executor> zzeqoVar) {
        this.zzewf = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcip(this.zzewf.get());
    }
}
