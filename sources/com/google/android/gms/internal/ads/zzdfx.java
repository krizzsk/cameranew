package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdfx implements zzdfj<JSONObject> {
    private final AdvertisingIdClient.Info zzhdw;
    private final String zzhdx;

    public zzdfx(AdvertisingIdClient.Info info, String str) {
        this.zzhdw = info;
        this.zzhdx = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            JSONObject zzb = com.google.android.gms.ads.internal.util.zzbh.zzb(jSONObject, "pii");
            AdvertisingIdClient.Info info = this.zzhdw;
            if (info != null && !TextUtils.isEmpty(info.getId())) {
                zzb.put("rdid", this.zzhdw.getId());
                zzb.put("is_lat", this.zzhdw.isLimitAdTrackingEnabled());
                zzb.put("idtype", "adid");
                return;
            }
            zzb.put("pdid", this.zzhdx);
            zzb.put("pdidtype", "ssaid");
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zza("Failed putting Ad ID.", e2);
        }
    }
}
