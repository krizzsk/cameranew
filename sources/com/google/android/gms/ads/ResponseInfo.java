package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzvw;
import com.google.android.gms.internal.ads.zzwr;
import com.google.android.gms.internal.ads.zzyx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class ResponseInfo {
    private final zzyx a;
    private final List<AdapterResponseInfo> b = new ArrayList();

    private ResponseInfo(zzyx zzyxVar) {
        this.a = zzyxVar;
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdab)).booleanValue()) {
            try {
                List<zzvw> adapterResponses = zzyxVar.getAdapterResponses();
                if (adapterResponses != null) {
                    for (zzvw zzvwVar : adapterResponses) {
                        this.b.add(AdapterResponseInfo.zza(zzvwVar));
                    }
                }
            } catch (RemoteException e2) {
                zzazk.zzc("Could not forward getAdapterResponseInfo to ResponseInfo.", e2);
            }
        }
    }

    @Nullable
    public static ResponseInfo zza(@Nullable zzyx zzyxVar) {
        if (zzyxVar != null) {
            return new ResponseInfo(zzyxVar);
        }
        return null;
    }

    @NonNull
    public final List<AdapterResponseInfo> getAdapterResponses() {
        return this.b;
    }

    @Nullable
    public final String getMediationAdapterClassName() {
        try {
            return this.a.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzazk.zzc("Could not forward getMediationAdapterClassName to ResponseInfo.", e2);
            return null;
        }
    }

    @Nullable
    public final String getResponseId() {
        try {
            return this.a.getResponseId();
        } catch (RemoteException e2) {
            zzazk.zzc("Could not forward getResponseId to ResponseInfo.", e2);
            return null;
        }
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
        String responseId = getResponseId();
        if (responseId == null) {
            jSONObject.put("Response ID", "null");
        } else {
            jSONObject.put("Response ID", responseId);
        }
        String mediationAdapterClassName = getMediationAdapterClassName();
        if (mediationAdapterClassName == null) {
            jSONObject.put("Mediation Adapter Class Name", "null");
        } else {
            jSONObject.put("Mediation Adapter Class Name", mediationAdapterClassName);
        }
        JSONArray jSONArray = new JSONArray();
        for (AdapterResponseInfo adapterResponseInfo : this.b) {
            jSONArray.put(adapterResponseInfo.zzdr());
        }
        jSONObject.put("Adapter Responses", jSONArray);
        return jSONObject;
    }
}
