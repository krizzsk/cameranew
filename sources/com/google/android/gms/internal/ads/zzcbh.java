package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcbh implements zzeqb<JSONObject> {
    private final zzeqo<zzcch> zzfih;
    private final zzcbi zzgdb;

    public zzcbh(zzcbi zzcbiVar, zzeqo<zzcch> zzeqoVar) {
        this.zzgdb = zzcbiVar;
        this.zzfih = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzfih.get().zzaof();
    }
}
