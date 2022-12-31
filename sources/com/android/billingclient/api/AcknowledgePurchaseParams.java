package com.android.billingclient.api;

import androidx.annotation.NonNull;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public final class AcknowledgePurchaseParams {
    private String zza;

    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    /* loaded from: classes.dex */
    public static final class Builder {
        private String zza;

        private Builder() {
        }

        public final AcknowledgePurchaseParams build() {
            if (this.zza != null) {
                AcknowledgePurchaseParams acknowledgePurchaseParams = new AcknowledgePurchaseParams();
                acknowledgePurchaseParams.zza = this.zza;
                return acknowledgePurchaseParams;
            }
            throw new IllegalArgumentException("Purchase token must be set");
        }

        public final Builder setPurchaseToken(@NonNull String str) {
            this.zza = str;
            return this;
        }
    }

    private AcknowledgePurchaseParams() {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public final String getPurchaseToken() {
        return this.zza;
    }
}
