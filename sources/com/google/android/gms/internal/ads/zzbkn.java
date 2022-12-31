package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbkn implements zzeqb<JSONObject> {
    private final zzeqo<zzdmw> zzfta;

    private zzbkn(zzeqo<zzdmw> zzeqoVar) {
        this.zzfta = zzeqoVar;
    }

    public static zzbkn zzc(zzeqo<zzdmw> zzeqoVar) {
        return new zzbkn(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    @Nullable
    public final /* synthetic */ Object get() {
        return zzbko.zza(this.zzfta.get());
    }
}
