package com.google.android.gms.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzvg;
import com.google.android.gms.internal.ads.zzvw;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class AdapterResponseInfo {
    private final zzvw a;
    private final AdError b;

    private AdapterResponseInfo(zzvw zzvwVar) {
        this.a = zzvwVar;
        zzvg zzvgVar = zzvwVar.zzciq;
        this.b = zzvgVar == null ? null : zzvgVar.zzqb();
    }

    @Nullable
    public static AdapterResponseInfo zza(@Nullable zzvw zzvwVar) {
        if (zzvwVar != null) {
            return new AdapterResponseInfo(zzvwVar);
        }
        return null;
    }

    @Nullable
    public final AdError getAdError() {
        return this.b;
    }

    public final String getAdapterClassName() {
        return this.a.zzcio;
    }

    public final Bundle getCredentials() {
        return this.a.zzcir;
    }

    public final long getLatencyMillis() {
        return this.a.zzcip;
    }

    public final String toString() {
        try {
            return zzdr().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final JSONObject zzdr() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Adapter", this.a.zzcio);
        jSONObject.put("Latency", this.a.zzcip);
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.a.zzcir.keySet()) {
            jSONObject2.put(str, this.a.zzcir.get(str));
        }
        jSONObject.put("Credentials", jSONObject2);
        AdError adError = this.b;
        if (adError == null) {
            jSONObject.put("Ad Error", "null");
        } else {
            jSONObject.put("Ad Error", adError.zzdr());
        }
        return jSONObject;
    }
}
