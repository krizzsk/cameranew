package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public class SkuDetailsParams {
    private String zza;
    private String zzb;
    private List<String> zzc;

    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    /* loaded from: classes.dex */
    public static class Builder {
        private String zza;
        private List<String> zzb;

        private Builder() {
        }

        public SkuDetailsParams build() {
            if (this.zza != null) {
                if (this.zzb != null) {
                    SkuDetailsParams skuDetailsParams = new SkuDetailsParams();
                    skuDetailsParams.zza = this.zza;
                    skuDetailsParams.zzc = this.zzb;
                    skuDetailsParams.zzb = null;
                    return skuDetailsParams;
                }
                throw new IllegalArgumentException("SKUs list must be set");
            }
            throw new IllegalArgumentException("SKU type must be set");
        }

        public Builder setSkusList(@NonNull List<String> list) {
            this.zzb = new ArrayList(list);
            return this;
        }

        public Builder setType(@NonNull String str) {
            this.zza = str;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getSkuType() {
        return this.zza;
    }

    public List<String> getSkusList() {
        return this.zzc;
    }

    @Nullable
    public final String zza() {
        return this.zzb;
    }
}
