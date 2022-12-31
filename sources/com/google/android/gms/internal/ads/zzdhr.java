package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdhr implements zzdfj<JSONObject> {
    private final Map<String, Object> zzhew;

    public zzdhr(Map<String, Object> map) {
        this.zzhew = map;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            jSONObject.put("video_decoders", com.google.android.gms.ads.internal.zzr.zzkr().zzj(this.zzhew));
        } catch (JSONException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            com.google.android.gms.ads.internal.util.zzd.zzeb(valueOf.length() != 0 ? "Could not encode video decoder properties: ".concat(valueOf) : new String("Could not encode video decoder properties: "));
        }
    }
}
