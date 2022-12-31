package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdgh implements zzdfj<JSONObject> {
    private final JSONObject zzhee;

    public zzdgh(JSONObject jSONObject) {
        this.zzhee = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            JSONObject zzb = com.google.android.gms.ads.internal.util.zzbh.zzb(jSONObject, "content_info");
            JSONObject jSONObject2 = this.zzhee;
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzb.put(next, jSONObject2.get(next));
            }
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zzd.zzeb("Failed putting app indexing json.");
        }
    }
}
