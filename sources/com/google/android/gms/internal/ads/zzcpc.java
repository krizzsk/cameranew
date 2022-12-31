package com.google.android.gms.internal.ads;

import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzcpc implements zzamc<zzcoz> {
    @Override // com.google.android.gms.internal.ads.zzamc
    public final /* synthetic */ JSONObject zzi(zzcoz zzcozVar) throws JSONException {
        zzcoz zzcozVar2 = zzcozVar;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", zzcozVar2.zzgpv.zzwm());
        jSONObject2.put("signals", zzcozVar2.zzgpu);
        jSONObject3.put("body", zzcozVar2.zzgpt.zzdvw);
        jSONObject3.put("headers", com.google.android.gms.ads.internal.zzr.zzkr().zzj(zzcozVar2.zzgpt.zzaj));
        jSONObject3.put("response_code", zzcozVar2.zzgpt.zzgqd);
        jSONObject3.put("latency", zzcozVar2.zzgpt.zzgqe);
        jSONObject.put(SocialConstants.TYPE_REQUEST, jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzcozVar2.zzgpv.zzwq());
        return jSONObject;
    }
}
