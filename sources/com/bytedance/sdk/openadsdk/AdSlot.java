package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.json.JSONObject;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
/* loaded from: classes.dex */
public class AdSlot {
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_CACHED_SPLASH = 4;
    public static final int TYPE_DRAW_FEED = 9;
    public static final int TYPE_FEED = 5;
    public static final int TYPE_FULL_SCREEN_VIDEO = 8;
    public static final int TYPE_INTERACTION_AD = 2;
    public static final int TYPE_REWARD_VIDEO = 7;
    public static final int TYPE_SPLASH = 3;
    private String a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private float f1298d;

    /* renamed from: e  reason: collision with root package name */
    private float f1299e;

    /* renamed from: f  reason: collision with root package name */
    private int f1300f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1301g;

    /* renamed from: h  reason: collision with root package name */
    private String f1302h;

    /* renamed from: i  reason: collision with root package name */
    private int f1303i;

    /* renamed from: j  reason: collision with root package name */
    private String f1304j;

    /* renamed from: k  reason: collision with root package name */
    private String f1305k;

    /* renamed from: l  reason: collision with root package name */
    private int f1306l;
    private int m;
    private boolean n;
    private boolean o;
    private String p;

    /* loaded from: classes.dex */
    public static class Builder {
        private String a;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1307d;

        /* renamed from: f  reason: collision with root package name */
        private String f1309f;

        /* renamed from: g  reason: collision with root package name */
        private int f1310g;

        /* renamed from: h  reason: collision with root package name */
        private String f1311h;

        /* renamed from: i  reason: collision with root package name */
        private String f1312i;

        /* renamed from: j  reason: collision with root package name */
        private int f1313j;

        /* renamed from: k  reason: collision with root package name */
        private int f1314k;

        /* renamed from: l  reason: collision with root package name */
        private float f1315l;
        private float m;
        private boolean n;
        private String o;
        private int b = VideoEdit2Activity.MIN_SCALED_SIZE;
        private int c = 320;

        /* renamed from: e  reason: collision with root package name */
        private int f1308e = 1;
        private boolean p = true;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.a = this.a;
            adSlot.f1300f = this.f1308e;
            adSlot.f1301g = this.f1307d;
            adSlot.b = this.b;
            adSlot.c = this.c;
            adSlot.f1298d = this.f1315l;
            adSlot.f1299e = this.m;
            adSlot.f1302h = this.f1309f;
            adSlot.f1303i = this.f1310g;
            adSlot.f1304j = this.f1311h;
            adSlot.f1305k = this.f1312i;
            adSlot.f1306l = this.f1313j;
            adSlot.m = this.f1314k;
            adSlot.n = this.p;
            adSlot.o = this.n;
            adSlot.p = this.o;
            return adSlot;
        }

        public Builder isExpressAd(boolean z) {
            this.n = z;
            return this;
        }

        public Builder setAdCount(int i2) {
            this.f1308e = i2;
            return this;
        }

        public Builder setCodeId(String str) {
            this.a = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f2, float f3) {
            this.f1315l = f2;
            this.m = f3;
            return this;
        }

        public Builder setImageAcceptedSize(int i2, int i3) {
            this.b = i2;
            this.c = i3;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.p = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.f1311h = str;
            return this;
        }

        public Builder setNativeAdType(int i2) {
            this.f1314k = i2;
            return this;
        }

        public Builder setOrientation(int i2) {
            this.f1313j = i2;
            return this;
        }

        public Builder setRewardAmount(int i2) {
            this.f1310g = i2;
            return this;
        }

        public Builder setRewardName(String str) {
            this.f1309f = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.f1307d = z;
            return this;
        }

        public Builder setUserID(String str) {
            this.f1312i = str;
            return this;
        }

        public Builder withBid(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            this.o = str;
            return this;
        }
    }

    public static int getPosition(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return (i2 == 3 || i2 == 4 || i2 == 7 || i2 == 8) ? 5 : 3;
            }
            return 4;
        }
        return 2;
    }

    public static AdSlot getSlot(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        try {
            int optInt = jSONObject.optInt("mImgAcceptedWidth", VideoEdit2Activity.MIN_SCALED_SIZE);
            int optInt2 = jSONObject.optInt("mImgAcceptedHeight", 320);
            double optDouble = jSONObject.optDouble("mExpressViewAcceptedWidth", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            double optDouble2 = jSONObject.optDouble("mExpressViewAcceptedHeight", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            builder.setCodeId(jSONObject.optString("mCodeId", null));
            builder.setAdCount(jSONObject.optInt("mAdCount", 1));
            builder.setIsAutoPlay(jSONObject.optBoolean("mIsAutoPlay"));
            builder.setImageAcceptedSize(optInt, optInt2);
            builder.setExpressViewAcceptedSize(Double.valueOf(optDouble).floatValue(), Double.valueOf(optDouble2).floatValue());
            builder.setSupportDeepLink(jSONObject.optBoolean("mSupportDeepLink", false));
            builder.setRewardName(jSONObject.optString("mRewardName", null));
            builder.setRewardAmount(jSONObject.optInt("mRewardAmount"));
            builder.setMediaExtra(jSONObject.optString("mMediaExtra", null));
            builder.setUserID(jSONObject.optString("mUserID", null));
            builder.setOrientation(jSONObject.optInt("mOrientation"));
            builder.setNativeAdType(jSONObject.optInt("mNativeAdType"));
            builder.isExpressAd(jSONObject.optBoolean("mIsExpressAd"));
            builder.withBid(jSONObject.optString("mBidAdm"));
        } catch (Exception unused) {
        }
        return builder.build();
    }

    public int getAdCount() {
        return this.f1300f;
    }

    public String getBidAdm() {
        return this.p;
    }

    public String getCodeId() {
        return this.a;
    }

    public float getExpressViewAcceptedHeight() {
        return this.f1299e;
    }

    public float getExpressViewAcceptedWidth() {
        return this.f1298d;
    }

    public int getImgAcceptedHeight() {
        return this.c;
    }

    public int getImgAcceptedWidth() {
        return this.b;
    }

    public String getMediaExtra() {
        return this.f1304j;
    }

    public int getNativeAdType() {
        return this.m;
    }

    public int getOrientation() {
        return this.f1306l;
    }

    public int getRewardAmount() {
        return this.f1303i;
    }

    public String getRewardName() {
        return this.f1302h;
    }

    public String getUserID() {
        return this.f1305k;
    }

    public boolean isAutoPlay() {
        return this.n;
    }

    public boolean isExpressAd() {
        return this.o;
    }

    public boolean isSupportDeepLink() {
        return this.f1301g;
    }

    public void setAdCount(int i2) {
        this.f1300f = i2;
    }

    public void setNativeAdType(int i2) {
        this.m = i2;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.a);
            jSONObject.put("mAdCount", this.f1300f);
            jSONObject.put("mIsAutoPlay", this.n);
            jSONObject.put("mImgAcceptedWidth", this.b);
            jSONObject.put("mImgAcceptedHeight", this.c);
            jSONObject.put("mExpressViewAcceptedWidth", this.f1298d);
            jSONObject.put("mExpressViewAcceptedHeight", this.f1299e);
            jSONObject.put("mSupportDeepLink", this.f1301g);
            jSONObject.put("mRewardName", this.f1302h);
            jSONObject.put("mRewardAmount", this.f1303i);
            jSONObject.put("mMediaExtra", this.f1304j);
            jSONObject.put("mUserID", this.f1305k);
            jSONObject.put("mOrientation", this.f1306l);
            jSONObject.put("mNativeAdType", this.m);
            jSONObject.put("mIsExpressAd", this.o);
            jSONObject.put("mBidAdm", this.p);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.a + "', mImgAcceptedWidth=" + this.b + ", mImgAcceptedHeight=" + this.c + ", mExpressViewAcceptedWidth=" + this.f1298d + ", mExpressViewAcceptedHeight=" + this.f1299e + ", mAdCount=" + this.f1300f + ", mSupportDeepLink=" + this.f1301g + ", mRewardName='" + this.f1302h + "', mRewardAmount=" + this.f1303i + ", mMediaExtra='" + this.f1304j + "', mUserID='" + this.f1305k + "', mOrientation=" + this.f1306l + ", mNativeAdType=" + this.m + ", mIsAutoPlay=" + this.n + '}';
    }

    private AdSlot() {
        this.f1306l = 2;
        this.n = true;
        this.o = false;
    }
}
