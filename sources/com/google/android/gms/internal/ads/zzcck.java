package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcck extends zzcch {
    private final boolean zzdnc;
    private final boolean zzdnd;
    private final boolean zzdww;
    private final JSONObject zzgev;
    private final boolean zzgew;

    public zzcck(zzdmw zzdmwVar, JSONObject jSONObject) {
        super(zzdmwVar);
        this.zzgev = com.google.android.gms.ads.internal.util.zzbh.zza(jSONObject, "tracking_urls_and_actions", "active_view");
        boolean z = false;
        this.zzdnd = com.google.android.gms.ads.internal.util.zzbh.zza(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzdnc = com.google.android.gms.ads.internal.util.zzbh.zza(false, jSONObject, "attribution", "allow_pub_rendering");
        this.zzdww = com.google.android.gms.ads.internal.util.zzbh.zza(false, jSONObject, "enable_omid");
        if (jSONObject != null && jSONObject.optJSONObject("overlay") != null) {
            z = true;
        }
        this.zzgew = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcch
    public final boolean zzanq() {
        return this.zzdww;
    }

    @Override // com.google.android.gms.internal.ads.zzcch
    public final JSONObject zzaof() {
        JSONObject jSONObject = this.zzgev;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zzgeu.zzdwg);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcch
    public final boolean zzaog() {
        return this.zzgew;
    }

    @Override // com.google.android.gms.internal.ads.zzcch
    public final boolean zzaoh() {
        return this.zzdnd;
    }

    @Override // com.google.android.gms.internal.ads.zzcch
    public final boolean zzaoi() {
        return this.zzdnc;
    }
}
