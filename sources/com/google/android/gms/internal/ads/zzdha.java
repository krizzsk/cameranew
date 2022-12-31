package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdha implements zzdfj<JSONObject> {
    private List<String> zzduo;

    public zzdha(List<String> list) {
        this.zzduo = list;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            jSONObject.put("eid", TextUtils.join(",", this.zzduo));
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zzd.zzeb("Failed putting experiment ids.");
        }
    }
}
