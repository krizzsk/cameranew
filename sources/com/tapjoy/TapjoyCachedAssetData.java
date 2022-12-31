package com.tapjoy;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* loaded from: classes3.dex */
public class TapjoyCachedAssetData implements Serializable {
    private long a;
    private long b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f7264d;

    /* renamed from: e  reason: collision with root package name */
    private String f7265e;

    /* renamed from: f  reason: collision with root package name */
    private long f7266f;

    /* renamed from: g  reason: collision with root package name */
    private String f7267g;

    /* renamed from: h  reason: collision with root package name */
    private String f7268h;

    public TapjoyCachedAssetData(String str, String str2, long j2) {
        this(str, str2, j2, System.currentTimeMillis() / 1000);
    }

    public static TapjoyCachedAssetData fromJSONObject(JSONObject jSONObject) {
        TapjoyCachedAssetData tapjoyCachedAssetData;
        try {
            tapjoyCachedAssetData = new TapjoyCachedAssetData(jSONObject.getString("assetURL"), jSONObject.getString("localFilePath"), jSONObject.getLong(TapjoyConstants.TJC_TIME_TO_LIVE), jSONObject.getLong("timestamp"));
        } catch (JSONException unused) {
            tapjoyCachedAssetData = null;
        }
        try {
            tapjoyCachedAssetData.setOfferID(jSONObject.optString("offerID"));
        } catch (JSONException unused2) {
            TapjoyLog.i("TapjoyCachedAssetData", "Can not build TapjoyVideoObject -- not enough data.");
            return tapjoyCachedAssetData;
        }
        return tapjoyCachedAssetData;
    }

    public static TapjoyCachedAssetData fromRawJSONString(String str) {
        try {
            return fromJSONObject(new JSONObject(str));
        } catch (JSONException unused) {
            TapjoyLog.i("TapjoyCachedAssetData", "Can not build TapjoyVideoObject -- error reading json string");
            return null;
        }
    }

    public String getAssetURL() {
        return this.c;
    }

    public String getLocalFilePath() {
        return this.f7264d;
    }

    public String getLocalURL() {
        return this.f7265e;
    }

    public String getMimeType() {
        return this.f7267g;
    }

    public String getOfferId() {
        return this.f7268h;
    }

    public long getTimeOfDeathInSeconds() {
        return this.f7266f;
    }

    public long getTimeToLiveInSeconds() {
        return this.b;
    }

    public long getTimestampInSeconds() {
        return this.a;
    }

    public void resetTimeToLive(long j2) {
        this.b = j2;
        this.f7266f = (System.currentTimeMillis() / 1000) + j2;
    }

    public void setAssetURL(String str) {
        this.c = str;
        this.f7267g = TapjoyUtil.determineMimeType(str);
    }

    public void setLocalFilePath(String str) {
        this.f7264d = str;
        this.f7265e = InspirePublishFragment.FILE_HEADER + str;
    }

    public void setOfferID(String str) {
        this.f7268h = str;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", getTimestampInSeconds());
            jSONObject.put(TapjoyConstants.TJC_TIME_TO_LIVE, getTimeToLiveInSeconds());
            jSONObject.put("assetURL", getAssetURL());
            jSONObject.put("localFilePath", getLocalFilePath());
            jSONObject.put("offerID", getOfferId());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String toRawJSONString() {
        return toJSON().toString();
    }

    public String toString() {
        return "\nURL=" + this.f7265e + "\nAssetURL=" + this.c + "\nMimeType=" + this.f7267g + "\nTimestamp=" + getTimestampInSeconds() + "\nTimeOfDeath=" + this.f7266f + "\nTimeToLive=" + this.b + "\n";
    }

    public TapjoyCachedAssetData(String str, String str2, long j2, long j3) {
        setAssetURL(str);
        setLocalFilePath(str2);
        this.b = j2;
        this.a = j3;
        this.f7266f = j3 + j2;
    }
}
