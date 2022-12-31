package com.android.billingclient.api;

import androidx.annotation.NonNull;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public final class BillingResult {
    private int zza;
    private String zzb;

    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    /* loaded from: classes.dex */
    public static class Builder {
        private int zza;
        private String zzb;

        private Builder() {
            this.zzb = "";
        }

        public BillingResult build() {
            BillingResult billingResult = new BillingResult();
            billingResult.zza = this.zza;
            billingResult.zzb = this.zzb;
            return billingResult;
        }

        public Builder setDebugMessage(@NonNull String str) {
            this.zzb = str;
            return this;
        }

        public Builder setResponseCode(int i2) {
            this.zza = i2;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public final String getDebugMessage() {
        return this.zzb;
    }

    public final int getResponseCode() {
        return this.zza;
    }
}
