package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzamj {
    private static final com.google.android.gms.ads.internal.util.zzar<zzakm> zzdkv = new zzami();
    private static final com.google.android.gms.ads.internal.util.zzar<zzakm> zzdkw = new zzaml();
    private final zzakz zzdkx;

    public zzamj(Context context, zzazn zzaznVar, String str) {
        this.zzdkx = new zzakz(context, zzaznVar, str, zzdkv, zzdkw);
    }

    public final <I, O> zzamb<I, O> zza(String str, zzamc<I> zzamcVar, zzamd<O> zzamdVar) {
        return new zzamk(this.zzdkx, str, zzamcVar, zzamdVar);
    }

    public final zzamo zzur() {
        return new zzamo(this.zzdkx);
    }
}
