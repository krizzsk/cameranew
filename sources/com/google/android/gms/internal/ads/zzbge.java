package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbge implements zzeqb<Context> {
    private final zzbgb zzewc;

    public zzbge(zzbgb zzbgbVar) {
        this.zzewc = zzbgbVar;
    }

    public static Context zza(zzbgb zzbgbVar) {
        return (Context) zzeqh.zza(zzbgbVar.zzaeu(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zza(this.zzewc);
    }
}
