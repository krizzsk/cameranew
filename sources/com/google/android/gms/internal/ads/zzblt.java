package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzblt implements zzeqb<ViewGroup> {
    private final zzblu zzful;

    private zzblt(zzblu zzbluVar) {
        this.zzful = zzbluVar;
    }

    public static zzblt zze(zzblu zzbluVar) {
        return new zzblt(zzbluVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzful.zzajy();
    }
}
