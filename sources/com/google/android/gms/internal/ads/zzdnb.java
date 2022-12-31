package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdnb {
    public final int responseCode;
    public final String zzbvs;
    public final List<String> zzdms;
    public final String zzdwy;
    public final boolean zzeeb;
    public final long zzgqe;
    public final int zzhkg;
    @Nullable
    public final zzdmy zzhkh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdnb(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        List<String> emptyList = Collections.emptyList();
        jsonReader.beginObject();
        String str = "";
        String str2 = "";
        long j2 = 0;
        zzdmy zzdmyVar = null;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("nofill_urls".equals(nextName)) {
                emptyList = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
            } else if ("refresh_interval".equals(nextName)) {
                i2 = jsonReader.nextInt();
            } else if ("gws_query_id".equals(nextName)) {
                str = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(nextName)) {
                str2 = jsonReader.nextString();
            } else if ("is_idless".equals(nextName)) {
                z = jsonReader.nextBoolean();
            } else if ("response_code".equals(nextName)) {
                i3 = jsonReader.nextInt();
            } else if ("latency".equals(nextName)) {
                j2 = jsonReader.nextLong();
            } else {
                if (((Boolean) zzwr.zzqr().zzd(zzabp.zzczz)).booleanValue() && "public_error".equals(nextName) && jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                    zzdmyVar = new zzdmy(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
        }
        jsonReader.endObject();
        this.zzdms = emptyList;
        this.zzhkg = i2;
        this.zzbvs = str;
        this.zzdwy = str2;
        this.responseCode = i3;
        this.zzgqe = j2;
        this.zzhkh = zzdmyVar;
        this.zzeeb = z;
    }
}
