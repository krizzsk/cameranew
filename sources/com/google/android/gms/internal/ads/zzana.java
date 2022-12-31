package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzana {
    private final String zzdlr;
    private final String zzdls;
    public final List<String> zzdlt;
    private final String zzdlu;
    private final String zzdlv;
    private final List<String> zzdlw;
    private final List<String> zzdlx;
    private final List<String> zzdly;
    private final List<String> zzdlz;
    private final List<String> zzdma;
    public final String zzdmb;
    private final List<String> zzdmc;
    private final List<String> zzdmd;
    private final List<String> zzdme;
    private final String zzdmf;
    private final String zzdmg;
    @Nullable
    private final String zzdmh;
    @Nullable
    private final String zzdmi;
    private final String zzdmj;
    @Nullable
    private final List<String> zzdmk;
    private final String zzdml;
    @Nullable
    public final String zzdmm;
    private final long zzdmn;

    public zzana(JSONObject jSONObject) throws JSONException {
        List<String> list;
        this.zzdls = jSONObject.optString(TapjoyAuctionFlags.AUCTION_ID);
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.getString(i2));
        }
        this.zzdlt = Collections.unmodifiableList(arrayList);
        this.zzdlu = jSONObject.optString("allocation_id", null);
        com.google.android.gms.ads.internal.zzr.zzlj();
        this.zzdlw = zzanc.zza(jSONObject, "clickurl");
        com.google.android.gms.ads.internal.zzr.zzlj();
        this.zzdlx = zzanc.zza(jSONObject, "imp_urls");
        com.google.android.gms.ads.internal.zzr.zzlj();
        this.zzdly = zzanc.zza(jSONObject, "downloaded_imp_urls");
        com.google.android.gms.ads.internal.zzr.zzlj();
        this.zzdma = zzanc.zza(jSONObject, "fill_urls");
        com.google.android.gms.ads.internal.zzr.zzlj();
        this.zzdmc = zzanc.zza(jSONObject, "video_start_urls");
        com.google.android.gms.ads.internal.zzr.zzlj();
        this.zzdme = zzanc.zza(jSONObject, "video_complete_urls");
        com.google.android.gms.ads.internal.zzr.zzlj();
        this.zzdmd = zzanc.zza(jSONObject, "video_reward_urls");
        this.zzdmf = jSONObject.optString(FirebaseAnalytics.Param.TRANSACTION_ID);
        this.zzdmg = jSONObject.optString("valid_from_timestamp");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            com.google.android.gms.ads.internal.zzr.zzlj();
            list = zzanc.zza(optJSONObject, "manual_impression_urls");
        } else {
            list = null;
        }
        this.zzdlz = list;
        this.zzdlr = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.zzdmb = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.zzdlv = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.zzdmh = jSONObject.optString("html_template", null);
        this.zzdmi = jSONObject.optString("ad_base_url", null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        this.zzdmj = optJSONObject3 != null ? optJSONObject3.toString() : null;
        com.google.android.gms.ads.internal.zzr.zzlj();
        this.zzdmk = zzanc.zza(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.zzdml = optJSONObject4 != null ? optJSONObject4.toString() : null;
        this.zzdmm = jSONObject.optString(ParamKeyConstants.WebViewConstants.QUERY_RESPONSE_TYPE, null);
        this.zzdmn = jSONObject.optLong("ad_network_timeout_millis", -1L);
    }
}
