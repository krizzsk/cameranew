package com.google.android.gms.internal.ads;

import com.tapjoy.TapjoyConstants;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbkf implements zzeqb<zzqt> {
    private final zzeqo<JSONObject> zzfja;
    private final zzeqo<zzdmw> zzfta;
    private final zzeqo<zzazn> zzftb;
    private final zzeqo<String> zzftc;

    private zzbkf(zzeqo<zzdmw> zzeqoVar, zzeqo<zzazn> zzeqoVar2, zzeqo<JSONObject> zzeqoVar3, zzeqo<String> zzeqoVar4) {
        this.zzfta = zzeqoVar;
        this.zzftb = zzeqoVar2;
        this.zzfja = zzeqoVar3;
        this.zzftc = zzeqoVar4;
    }

    public static zzbkf zza(zzeqo<zzdmw> zzeqoVar, zzeqo<zzazn> zzeqoVar2, zzeqo<JSONObject> zzeqoVar3, zzeqo<String> zzeqoVar4) {
        return new zzbkf(zzeqoVar, zzeqoVar2, zzeqoVar3, zzeqoVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        this.zzfta.get();
        zzazn zzaznVar = this.zzftb.get();
        JSONObject jSONObject = this.zzfja.get();
        String str = this.zzftc.get();
        boolean equals = TapjoyConstants.TJC_PLUGIN_NATIVE.equals(str);
        com.google.android.gms.ads.internal.zzr.zzkr();
        return (zzqt) zzeqh.zza(new zzqt(com.google.android.gms.ads.internal.util.zzj.zzyy(), zzaznVar, str, jSONObject, false, equals), "Cannot return null from a non-@Nullable @Provides method");
    }
}
