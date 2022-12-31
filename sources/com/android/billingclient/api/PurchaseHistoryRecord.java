package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public class PurchaseHistoryRecord {
    private final String zza;
    private final String zzb;
    private final JSONObject zzc;

    public PurchaseHistoryRecord(@NonNull String str, @NonNull String str2) throws JSONException {
        this.zza = str;
        this.zzb = str2;
        this.zzc = new JSONObject(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PurchaseHistoryRecord) {
            PurchaseHistoryRecord purchaseHistoryRecord = (PurchaseHistoryRecord) obj;
            return TextUtils.equals(this.zza, purchaseHistoryRecord.getOriginalJson()) && TextUtils.equals(this.zzb, purchaseHistoryRecord.getSignature());
        }
        return false;
    }

    public String getDeveloperPayload() {
        return this.zzc.optString("developerPayload");
    }

    public String getOriginalJson() {
        return this.zza;
    }

    public long getPurchaseTime() {
        return this.zzc.optLong("purchaseTime");
    }

    public String getPurchaseToken() {
        JSONObject jSONObject = this.zzc;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public String getSignature() {
        return this.zzb;
    }

    public String getSku() {
        return this.zzc.optString("productId");
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.zza);
        return valueOf.length() != 0 ? "PurchaseHistoryRecord. Json: ".concat(valueOf) : new String("PurchaseHistoryRecord. Json: ");
    }
}
