package com.google.android.gms.internal.ads;

import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcbn implements zzeqb<zzqt> {
    private final zzeqo<zzazn> zzftb;
    private final zzeqo<String> zzftc;

    public zzcbn(zzeqo<zzazn> zzeqoVar, zzeqo<String> zzeqoVar2) {
        this.zzftb = zzeqoVar;
        this.zzftc = zzeqoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        com.google.android.gms.ads.internal.zzr.zzkr();
        return (zzqt) zzeqh.zza(new zzqt(com.google.android.gms.ads.internal.util.zzj.zzyy(), this.zzftb.get(), this.zzftc.get(), new JSONObject(), false, true), "Cannot return null from a non-@Nullable @Provides method");
    }
}
