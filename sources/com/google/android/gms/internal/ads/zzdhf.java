package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.tapjoy.TapjoyConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdhf implements zzdfj<JSONObject> {
    private Bundle zzhet;

    public zzdhf(Bundle bundle) {
        this.zzhet = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (this.zzhet != null) {
            try {
                com.google.android.gms.ads.internal.util.zzbh.zzb(com.google.android.gms.ads.internal.util.zzbh.zzb(jSONObject2, TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX), "play_store").put("parental_controls", com.google.android.gms.ads.internal.zzr.zzkr().zzc(this.zzhet));
            } catch (JSONException unused) {
                com.google.android.gms.ads.internal.util.zzd.zzeb("Failed putting parental controls bundle.");
            }
        }
    }
}
