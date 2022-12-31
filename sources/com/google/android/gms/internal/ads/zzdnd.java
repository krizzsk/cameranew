package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonWriter;
import androidx.annotation.Nullable;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdnd implements com.google.android.gms.ads.internal.util.zzbm {
    @Nullable
    public final String zzdsw;
    @Nullable
    public final String zzdsy;
    public final JSONObject zzgcf;
    private final JSONObject zzhkj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdnd(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        JSONObject zzc = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader);
        this.zzhkj = zzc;
        this.zzdsy = zzc.optString("ad_html", null);
        this.zzdsw = zzc.optString("ad_base_url", null);
        this.zzgcf = zzc.optJSONObject("ad_json");
    }

    @Override // com.google.android.gms.ads.internal.util.zzbm
    public final void zza(JsonWriter jsonWriter) throws IOException {
        com.google.android.gms.ads.internal.util.zzbh.zza(jsonWriter, this.zzhkj);
    }
}
