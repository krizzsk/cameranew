package com.google.android.gms.ads.rewarded;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class ServerSideVerificationOptions {
    private final String a;
    private final String b;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class Builder {
        private String a = "";
        private String b = "";

        public final ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public final Builder setCustomData(String str) {
            this.b = str;
            return this;
        }

        public final Builder setUserId(String str) {
            this.a = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
    }

    public String getCustomData() {
        return this.b;
    }

    public String getUserId() {
        return this.a;
    }
}
