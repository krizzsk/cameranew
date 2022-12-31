package com.facebook.appevents.codeless.internal;

import com.coremedia.iso.boxes.TrackReferenceTypeBox;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyAuctionFlags;
import com.tencent.matrix.report.Issue;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class PathComponent {
    public final String a;
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2285d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2286e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2287f;

    /* renamed from: g  reason: collision with root package name */
    public final String f2288g;

    /* renamed from: h  reason: collision with root package name */
    public final int f2289h;

    /* loaded from: classes.dex */
    public enum MatchBitmaskType {
        ID(1),
        TEXT(2),
        TAG(4),
        DESCRIPTION(8),
        HINT(16);
        
        private final int value;

        MatchBitmaskType(int i2) {
            this.value = i2;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PathComponent(JSONObject jSONObject) throws JSONException {
        this.a = jSONObject.getString("class_name");
        this.b = jSONObject.optInt(FirebaseAnalytics.Param.INDEX, -1);
        this.c = jSONObject.optInt(TapjoyAuctionFlags.AUCTION_ID);
        this.f2285d = jSONObject.optString("text");
        this.f2286e = jSONObject.optString(Issue.ISSUE_REPORT_TAG);
        this.f2287f = jSONObject.optString(SocialConstants.PARAM_COMMENT);
        this.f2288g = jSONObject.optString(TrackReferenceTypeBox.TYPE1);
        this.f2289h = jSONObject.optInt("match_bitmask");
    }
}
