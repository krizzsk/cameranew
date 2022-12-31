package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdak {
    public final String zzhae;
    public String zzhaf;
    public Bundle zzhag = new Bundle();

    public zzdak(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        Map<String, String> hashMap = new HashMap<>();
        jsonReader.beginObject();
        String str = "";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName = nextName == null ? "" : nextName;
            nextName.hashCode();
            if (nextName.equals("params")) {
                str = jsonReader.nextString();
            } else if (!nextName.equals("signal_dictionary")) {
                jsonReader.skipValue();
            } else {
                hashMap = com.google.android.gms.ads.internal.util.zzbh.zzb(jsonReader);
            }
        }
        this.zzhae = str;
        jsonReader.endObject();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                this.zzhag.putString(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdak zzn(Bundle bundle) {
        try {
            this.zzhaf = com.google.android.gms.ads.internal.zzr.zzkr().zzc(bundle).toString();
        } catch (JSONException unused) {
            this.zzhaf = "{}";
        }
        return this;
    }
}
