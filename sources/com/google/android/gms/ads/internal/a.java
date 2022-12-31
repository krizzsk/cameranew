package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzdyu;
import com.google.android.gms.internal.ads.zzdzk;
import com.google.android.gms.internal.ads.zzdzw;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements zzdyu {
    static final zzdyu a = new a();

    private a() {
    }

    @Override // com.google.android.gms.internal.ads.zzdyu
    public final zzdzw zzf(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            zzr.zzkv().zzxs().zzee(jSONObject.getString("appSettingsJson"));
        }
        return zzdzk.zzag(null);
    }
}
