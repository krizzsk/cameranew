package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.open.SocialConstants;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public class SkuDetails {
    private final String zza;
    private final JSONObject zzb;

    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    /* loaded from: classes.dex */
    static class zza {
        private final List<SkuDetails> zza;
        private final int zzb;
        private final String zzc;

        public zza(int i2, String str, @Nullable List<SkuDetails> list) {
            this.zzb = i2;
            this.zzc = str;
            this.zza = list;
        }

        public final List<SkuDetails> zza() {
            return this.zza;
        }

        public final int zzb() {
            return this.zzb;
        }

        public final String zzc() {
            return this.zzc;
        }
    }

    public SkuDetails(@NonNull String str) throws JSONException {
        this.zza = str;
        this.zzb = new JSONObject(str);
        if (!TextUtils.isEmpty(getSku())) {
            if (TextUtils.isEmpty(getType())) {
                throw new IllegalArgumentException("SkuType cannot be empty.");
            }
            return;
        }
        throw new IllegalArgumentException("SKU cannot be empty.");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkuDetails) {
            return TextUtils.equals(this.zza, ((SkuDetails) obj).zza);
        }
        return false;
    }

    public String getDescription() {
        return this.zzb.optString(SocialConstants.PARAM_COMMENT);
    }

    public String getFreeTrialPeriod() {
        return this.zzb.optString("freeTrialPeriod");
    }

    public String getIconUrl() {
        return this.zzb.optString("iconUrl");
    }

    public String getIntroductoryPrice() {
        return this.zzb.optString("introductoryPrice");
    }

    public long getIntroductoryPriceAmountMicros() {
        return this.zzb.optLong("introductoryPriceAmountMicros");
    }

    public int getIntroductoryPriceCycles() {
        return this.zzb.optInt("introductoryPriceCycles");
    }

    public String getIntroductoryPricePeriod() {
        return this.zzb.optString("introductoryPricePeriod");
    }

    public String getOriginalJson() {
        return this.zza;
    }

    public String getOriginalPrice() {
        if (this.zzb.has("original_price")) {
            return this.zzb.optString("original_price");
        }
        return getPrice();
    }

    public long getOriginalPriceAmountMicros() {
        if (this.zzb.has("original_price_micros")) {
            return this.zzb.optLong("original_price_micros");
        }
        return getPriceAmountMicros();
    }

    public String getPrice() {
        return this.zzb.optString(FirebaseAnalytics.Param.PRICE);
    }

    public long getPriceAmountMicros() {
        return this.zzb.optLong("price_amount_micros");
    }

    public String getPriceCurrencyCode() {
        return this.zzb.optString("price_currency_code");
    }

    public String getSku() {
        return this.zzb.optString("productId");
    }

    public String getSubscriptionPeriod() {
        return this.zzb.optString("subscriptionPeriod");
    }

    public String getTitle() {
        return this.zzb.optString("title");
    }

    public String getType() {
        return this.zzb.optString("type");
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.zza);
        return valueOf.length() != 0 ? "SkuDetails: ".concat(valueOf) : new String("SkuDetails: ");
    }

    public final String zza() {
        return this.zzb.optString("packageName");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzb.optString("skuDetailsToken");
    }
}
