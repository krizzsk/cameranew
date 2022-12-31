package com.ironsource.mediationsdk.l0;

import com.google.firebase.messaging.Constants;
import com.ironsource.mediationsdk.logger.IronLog;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* compiled from: ImpressionData.java */
/* loaded from: classes2.dex */
public class b {
    private JSONObject a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f5570d;

    /* renamed from: e  reason: collision with root package name */
    private String f5571e;

    /* renamed from: f  reason: collision with root package name */
    private String f5572f;

    /* renamed from: g  reason: collision with root package name */
    private String f5573g;

    /* renamed from: h  reason: collision with root package name */
    private String f5574h;

    /* renamed from: i  reason: collision with root package name */
    private String f5575i;

    /* renamed from: j  reason: collision with root package name */
    private String f5576j;

    /* renamed from: k  reason: collision with root package name */
    private Double f5577k;

    /* renamed from: l  reason: collision with root package name */
    private String f5578l;
    private Double m;
    private String n;
    private DecimalFormat o = new DecimalFormat("#.#####");

    public b(JSONObject jSONObject) {
        Double d2 = null;
        this.b = null;
        this.c = null;
        this.f5570d = null;
        this.f5571e = null;
        this.f5572f = null;
        this.f5573g = null;
        this.f5574h = null;
        this.f5575i = null;
        this.f5576j = null;
        this.f5577k = null;
        this.f5578l = null;
        this.m = null;
        this.n = null;
        if (jSONObject != null) {
            try {
                this.a = jSONObject;
                this.b = jSONObject.optString("auctionId", null);
                this.c = jSONObject.optString("adUnit", null);
                this.f5570d = jSONObject.optString(BigAlbumStore.PhotoAddressColumns.COUNTRY, null);
                this.f5571e = jSONObject.optString("ab", null);
                this.f5572f = jSONObject.optString("segmentName", null);
                this.f5573g = jSONObject.optString("placement", null);
                this.f5574h = jSONObject.optString("adNetwork", null);
                this.f5575i = jSONObject.optString("instanceName", null);
                this.f5576j = jSONObject.optString(Constants.FirelogAnalytics.PARAM_INSTANCE_ID, null);
                this.f5578l = jSONObject.optString("precision", null);
                this.n = jSONObject.optString("encryptedCPM", null);
                double optDouble = jSONObject.optDouble("lifetimeRevenue");
                this.m = Double.isNaN(optDouble) ? null : Double.valueOf(optDouble);
                double optDouble2 = jSONObject.optDouble("revenue");
                if (!Double.isNaN(optDouble2)) {
                    d2 = Double.valueOf(optDouble2);
                }
                this.f5577k = d2;
            } catch (Exception e2) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("error parsing impression " + e2.getMessage());
            }
        }
    }

    public void a(String str, String str2) {
        String str3 = this.f5573g;
        if (str3 != null) {
            String replace = str3.replace(str, str2);
            this.f5573g = replace;
            JSONObject jSONObject = this.a;
            if (jSONObject != null) {
                try {
                    jSONObject.put("placement", replace);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImpressionData{auctionId='");
        sb.append(this.b);
        sb.append('\'');
        sb.append(", adUnit='");
        sb.append(this.c);
        sb.append('\'');
        sb.append(", country='");
        sb.append(this.f5570d);
        sb.append('\'');
        sb.append(", ab='");
        sb.append(this.f5571e);
        sb.append('\'');
        sb.append(", segmentName='");
        sb.append(this.f5572f);
        sb.append('\'');
        sb.append(", placement='");
        sb.append(this.f5573g);
        sb.append('\'');
        sb.append(", adNetwork='");
        sb.append(this.f5574h);
        sb.append('\'');
        sb.append(", instanceName='");
        sb.append(this.f5575i);
        sb.append('\'');
        sb.append(", instanceId='");
        sb.append(this.f5576j);
        sb.append('\'');
        sb.append(", revenue=");
        Double d2 = this.f5577k;
        sb.append(d2 == null ? null : this.o.format(d2));
        sb.append(", precision='");
        sb.append(this.f5578l);
        sb.append('\'');
        sb.append(", lifetimeRevenue=");
        Double d3 = this.m;
        sb.append(d3 != null ? this.o.format(d3) : null);
        sb.append(", encryptedCPM='");
        sb.append(this.n);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
