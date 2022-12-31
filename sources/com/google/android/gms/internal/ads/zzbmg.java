package com.google.android.gms.internal.ads;

import android.view.View;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbmg implements zzeqb<View> {
    private final zzbmc zzfvc;

    public zzbmg(zzbmc zzbmcVar) {
        this.zzfvc = zzbmcVar;
    }

    public static View zzb(zzbmc zzbmcVar) {
        return (View) zzeqh.zza(zzbmcVar.zzajr(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zzb(this.zzfvc);
    }
}
