package com.google.android.gms.internal.ads;

import com.google.android.gms.common.c;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzdhp implements zzdfj {
    static final zzdfj zzhde = new zzdhp();

    private zzdhp() {
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final void zzr(Object obj) {
        try {
            ((JSONObject) obj).getJSONObject("sdk_env").put("container_version", c.a);
        } catch (JSONException unused) {
        }
    }
}
