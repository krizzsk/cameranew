package com.google.android.gms.ads;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class AdValue {
    private final int a;
    private final String b;
    private final long c;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface PrecisionType {
        public static final int ESTIMATED = 1;
        public static final int PRECISE = 3;
        public static final int PUBLISHER_PROVIDED = 2;
        public static final int UNKNOWN = 0;
    }

    private AdValue(int i2, String str, long j2) {
        this.a = i2;
        this.b = str;
        this.c = j2;
    }

    public static AdValue zza(int i2, String str, long j2) {
        return new AdValue(i2, str, j2);
    }

    public final String getCurrencyCode() {
        return this.b;
    }

    public final int getPrecisionType() {
        return this.a;
    }

    public final long getValueMicros() {
        return this.c;
    }
}
