package com.android.billingclient.api;

import androidx.annotation.NonNull;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public class PriceChangeFlowParams {
    private SkuDetails zza;

    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    /* loaded from: classes.dex */
    public static class Builder {
        private SkuDetails zza;

        public PriceChangeFlowParams build() {
            if (this.zza != null) {
                PriceChangeFlowParams priceChangeFlowParams = new PriceChangeFlowParams();
                priceChangeFlowParams.zza = this.zza;
                return priceChangeFlowParams;
            }
            throw new IllegalArgumentException("SkuDetails must be set");
        }

        public Builder setSkuDetails(@NonNull SkuDetails skuDetails) {
            this.zza = skuDetails;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public SkuDetails getSkuDetails() {
        return this.zza;
    }
}
