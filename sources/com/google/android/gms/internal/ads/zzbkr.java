package com.google.android.gms.internal.ads;

import android.view.View;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbkr implements zzeqb<View> {
    private final zzbks zzftm;

    public zzbkr(zzbks zzbksVar) {
        this.zzftm = zzbksVar;
    }

    public static View zza(zzbks zzbksVar) {
        return (View) zzeqh.zza(zzbksVar.zzajf(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zza(this.zzftm);
    }
}
