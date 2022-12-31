package com.google.android.gms.ads.nonagon.transaction.omid;

import androidx.annotation.Nullable;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class OmidSettings {
    private final JSONObject a;

    public OmidSettings(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public OmidMediaType getMediaType() {
        int optInt = this.a.optInt("media_type", -1);
        if (optInt != 0) {
            if (optInt != 1) {
                return OmidMediaType.UNKNOWN;
            }
            return OmidMediaType.VIDEO;
        }
        return OmidMediaType.DISPLAY;
    }

    @Nullable
    public String getVideoEventsOwner() {
        if (a.a[getMediaType().ordinal()] != 1) {
            return "javascript";
        }
        return null;
    }
}
