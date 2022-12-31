package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzazk;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class RequestConfiguration {
    public static final String MAX_AD_CONTENT_RATING_G = "G";
    public static final String MAX_AD_CONTENT_RATING_MA = "MA";
    public static final String MAX_AD_CONTENT_RATING_PG = "PG";
    public static final String MAX_AD_CONTENT_RATING_T = "T";
    public static final String MAX_AD_CONTENT_RATING_UNSPECIFIED = "";
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;
    public static final List<String> zzads = Arrays.asList("MA", "T", "PG", "G");
    private final int a;
    private final int b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f3441d;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public static class Builder {
        private int a = -1;
        private int b = -1;
        private String c = null;

        /* renamed from: d  reason: collision with root package name */
        private final List<String> f3442d = new ArrayList();

        public RequestConfiguration build() {
            return new RequestConfiguration(this.a, this.b, this.c, this.f3442d);
        }

        public Builder setMaxAdContentRating(String str) {
            if (str != null && !"".equals(str)) {
                if (!"G".equals(str) && !"PG".equals(str) && !"T".equals(str) && !"MA".equals(str)) {
                    String valueOf = String.valueOf(str);
                    zzazk.zzex(valueOf.length() != 0 ? "Invalid value passed to setMaxAdContentRating: ".concat(valueOf) : new String("Invalid value passed to setMaxAdContentRating: "));
                } else {
                    this.c = str;
                }
            } else {
                this.c = null;
            }
            return this;
        }

        public Builder setTagForChildDirectedTreatment(int i2) {
            if (i2 != -1 && i2 != 0 && i2 != 1) {
                StringBuilder sb = new StringBuilder(68);
                sb.append("Invalid value passed to setTagForChildDirectedTreatment: ");
                sb.append(i2);
                zzazk.zzex(sb.toString());
            } else {
                this.a = i2;
            }
            return this;
        }

        public Builder setTagForUnderAgeOfConsent(int i2) {
            if (i2 != -1 && i2 != 0 && i2 != 1) {
                StringBuilder sb = new StringBuilder(63);
                sb.append("Invalid value passed to setTagForUnderAgeOfConsent: ");
                sb.append(i2);
                zzazk.zzex(sb.toString());
            } else {
                this.b = i2;
            }
            return this;
        }

        public Builder setTestDeviceIds(@Nullable List<String> list) {
            this.f3442d.clear();
            if (list != null) {
                this.f3442d.addAll(list);
            }
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface MaxAdContentRating {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface TagForChildDirectedTreatment {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface TagForUnderAgeOfConsent {
    }

    private RequestConfiguration(int i2, int i3, String str, List<String> list) {
        this.a = i2;
        this.b = i3;
        this.c = str;
        this.f3441d = list;
    }

    public String getMaxAdContentRating() {
        String str = this.c;
        return str == null ? "" : str;
    }

    public int getTagForChildDirectedTreatment() {
        return this.a;
    }

    public int getTagForUnderAgeOfConsent() {
        return this.b;
    }

    public List<String> getTestDeviceIds() {
        return new ArrayList(this.f3441d);
    }

    public Builder toBuilder() {
        return new Builder().setTagForChildDirectedTreatment(this.a).setTagForUnderAgeOfConsent(this.b).setMaxAdContentRating(this.c).setTestDeviceIds(this.f3441d);
    }
}
