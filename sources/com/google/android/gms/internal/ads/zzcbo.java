package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcbo implements zzeqb<zzbxz> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<zzdmw> zzfvr;

    public zzcbo(zzeqo<Context> zzeqoVar, zzeqo<zzdmw> zzeqoVar2) {
        this.zzewk = zzeqoVar;
        this.zzfvr = zzeqoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzbxz) zzeqh.zza(new zzbxz(this.zzewk.get(), new HashSet(), this.zzfvr.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
