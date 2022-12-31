package com.google.android.gms.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzwr;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class LoadAdError extends AdError {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final ResponseInfo f3440e;

    public LoadAdError(int i2, @NonNull String str, @NonNull String str2, @Nullable AdError adError, @Nullable ResponseInfo responseInfo) {
        super(i2, str, str2, adError);
        this.f3440e = responseInfo;
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdab)).booleanValue()) {
            return this.f3440e;
        }
        return null;
    }

    @Override // com.google.android.gms.ads.AdError
    public final String toString() {
        try {
            return zzdr().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    @Override // com.google.android.gms.ads.AdError
    public final JSONObject zzdr() throws JSONException {
        JSONObject zzdr = super.zzdr();
        ResponseInfo responseInfo = getResponseInfo();
        if (responseInfo == null) {
            zzdr.put("Response Info", "null");
        } else {
            zzdr.put("Response Info", responseInfo.zzdr());
        }
        return zzdr;
    }
}
