package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdgv implements zzdfi<zzdfj<JSONObject>> {
    private final JSONObject zzhem;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdgv(Context context) {
        this.zzhem = zzauc.zzw(context);
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdfj<JSONObject>> zzasy() {
        return zzdzk.zzag(new zzdfj(this) { // from class: com.google.android.gms.internal.ads.zzdgu
            private final zzdgv zzhel;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhel = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdfj
            public final void zzr(Object obj) {
                this.zzhel.zzq((JSONObject) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zzhem);
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zzd.zzeb("Failed putting version constants.");
        }
    }
}
