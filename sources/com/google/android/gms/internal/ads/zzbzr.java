package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbzr implements zzeqb<View> {
    private final zzbyz zzgbk;

    private zzbzr(zzbyz zzbyzVar) {
        this.zzgbk = zzbyzVar;
    }

    public static zzbzr zzc(zzbyz zzbyzVar) {
        return new zzbzr(zzbyzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzgbk.zzamu();
    }
}
