package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzciw {
    public static String zza(JSONObject jSONObject, String str, String str2) {
        JSONArray optJSONArray;
        if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcrb)).booleanValue() || jSONObject == null || (optJSONArray = jSONObject.optJSONArray(str2)) == null) {
            return "";
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("including");
                JSONArray optJSONArray3 = optJSONObject.optJSONArray("excluding");
                if (zza(optJSONArray2, str) && !zza(optJSONArray3, str)) {
                    return optJSONObject.optString("effective_ad_unit_id", "");
                }
            }
        }
        return "";
    }

    private static boolean zza(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                } catch (PatternSyntaxException e2) {
                    com.google.android.gms.ads.internal.zzr.zzkv().zza(e2, "RtbAdapterMap.hasAtleastOneRegexMatch");
                }
                if (Pattern.compile(jSONArray.optString(i2)).matcher(str).lookingAt()) {
                    return true;
                }
            }
        }
        return false;
    }
}
