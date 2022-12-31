package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;
import org.json.JSONException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbrh extends zzza {
    private final List<zzvw> zzadw;
    private final String zzfzb;
    private final String zzfzc;

    public zzbrh(zzdmw zzdmwVar, String str, zzcrq zzcrqVar) {
        this.zzfzc = zzdmwVar == null ? null : zzdmwVar.zzfzc;
        String zzb = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) ? zzb(zzdmwVar) : null;
        this.zzfzb = zzb != null ? zzb : str;
        this.zzadw = zzcrqVar.getAdapterResponses();
    }

    private static String zzb(zzdmw zzdmwVar) {
        try {
            return zzdmwVar.zzhjj.getString("class_name");
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyx
    @Nullable
    public final List<zzvw> getAdapterResponses() {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdab)).booleanValue()) {
            return this.zzadw;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzyx
    public final String getMediationAdapterClassName() {
        return this.zzfzb;
    }

    @Override // com.google.android.gms.internal.ads.zzyx
    public final String getResponseId() {
        return this.zzfzc;
    }
}
