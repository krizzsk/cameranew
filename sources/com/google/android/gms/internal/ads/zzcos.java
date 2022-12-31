package com.google.android.gms.internal.ads;

import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzcos implements zzdqu {
    static final zzdqu zzgnx = new zzcos();

    private zzcos() {
    }

    @Override // com.google.android.gms.internal.ads.zzdqu
    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        com.google.android.gms.ads.internal.util.zzd.zzeb("Ad request signals:");
        com.google.android.gms.ads.internal.util.zzd.zzeb(jSONObject.toString(2));
        return jSONObject;
    }
}
