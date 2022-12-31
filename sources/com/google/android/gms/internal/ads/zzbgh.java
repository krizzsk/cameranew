package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbgh implements zzeqb<WeakReference<Context>> {
    private final zzbgb zzewc;

    public zzbgh(zzbgb zzbgbVar) {
        this.zzewc = zzbgbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (WeakReference) zzeqh.zza(this.zzewc.zzaev(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
