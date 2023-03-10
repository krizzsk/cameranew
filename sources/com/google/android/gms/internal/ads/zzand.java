package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzand {
    private final long zzdmn;
    public final List<zzana> zzdmo;
    private final List<String> zzdmp;
    private final List<String> zzdmq;
    private final List<String> zzdmr;
    private final List<String> zzdms;
    private final List<String> zzdmt;
    private final boolean zzdmu;
    private final String zzdmv;
    private final long zzdmw;
    private final String zzdmx;
    private final int zzdmy;
    private final int zzdmz;
    private final long zzdna;
    private final boolean zzdnb;
    private final boolean zzdnc;
    private final boolean zzdnd;
    private final boolean zzdne;
    private int zzdnf;
    private int zzdng;
    private boolean zzdnh;

    public zzand(JSONObject jSONObject) throws JSONException {
        if (zzazk.isLoggable(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            com.google.android.gms.ads.internal.util.zzd.zzeb(valueOf.length() != 0 ? "Mediation Response JSON: ".concat(valueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i2 = -1;
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                zzana zzanaVar = new zzana(jSONArray.getJSONObject(i3));
                boolean z = true;
                if ("banner".equalsIgnoreCase(zzanaVar.zzdmm)) {
                    this.zzdnh = true;
                }
                arrayList.add(zzanaVar);
                if (i2 < 0) {
                    Iterator<String> it = zzanaVar.zzdlt.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        i2 = i3;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        this.zzdnf = i2;
        this.zzdng = jSONArray.length();
        this.zzdmo = Collections.unmodifiableList(arrayList);
        this.zzdmv = jSONObject.optString("qdata");
        this.zzdmz = jSONObject.optInt("fs_model_type", -1);
        this.zzdna = jSONObject.optLong("timeout_ms", -1L);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.zzdmn = optJSONObject.optLong("ad_network_timeout_millis", -1L);
            com.google.android.gms.ads.internal.zzr.zzlj();
            this.zzdmp = zzanc.zza(optJSONObject, "click_urls");
            com.google.android.gms.ads.internal.zzr.zzlj();
            this.zzdmq = zzanc.zza(optJSONObject, "imp_urls");
            com.google.android.gms.ads.internal.zzr.zzlj();
            this.zzdmr = zzanc.zza(optJSONObject, "downloaded_imp_urls");
            com.google.android.gms.ads.internal.zzr.zzlj();
            this.zzdms = zzanc.zza(optJSONObject, "nofill_urls");
            com.google.android.gms.ads.internal.zzr.zzlj();
            this.zzdmt = zzanc.zza(optJSONObject, "remote_ping_urls");
            this.zzdmu = optJSONObject.optBoolean("render_in_browser", false);
            long optLong = optJSONObject.optLong("refresh", -1L);
            this.zzdmw = optLong > 0 ? 1000 * optLong : -1L;
            zzavj zza = zzavj.zza(optJSONObject.optJSONArray("rewards"));
            if (zza == null) {
                this.zzdmx = null;
                this.zzdmy = 0;
            } else {
                this.zzdmx = zza.type;
                this.zzdmy = zza.zzdzc;
            }
            this.zzdnb = optJSONObject.optBoolean("use_displayed_impression", false);
            this.zzdnc = optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            this.zzdnd = optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            this.zzdne = optJSONObject.optBoolean("allow_custom_click_gesture", false);
            return;
        }
        this.zzdmn = -1L;
        this.zzdmp = null;
        this.zzdmq = null;
        this.zzdmr = null;
        this.zzdms = null;
        this.zzdmt = null;
        this.zzdmw = -1L;
        this.zzdmx = null;
        this.zzdmy = 0;
        this.zzdnb = false;
        this.zzdmu = false;
        this.zzdnc = false;
        this.zzdnd = false;
        this.zzdne = false;
    }
}
