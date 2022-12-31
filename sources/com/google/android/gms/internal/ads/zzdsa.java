package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.tauth.AuthActivity;
import java.util.HashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdsa {
    private final HashMap<String, String> zzhrj = new HashMap<>();
    private final zzdsd zzhrk = new zzdsd(com.google.android.gms.ads.internal.zzr.zzky());

    private zzdsa() {
    }

    public static zzdsa zzgx(String str) {
        zzdsa zzdsaVar = new zzdsa();
        zzdsaVar.zzhrj.put(AuthActivity.ACTION_KEY, str);
        return zzdsaVar;
    }

    public static zzdsa zzgy(String str) {
        zzdsa zzdsaVar = new zzdsa();
        zzdsaVar.zzu("request_id", str);
        return zzdsaVar;
    }

    public final zzdsa zza(zzdnl zzdnlVar, @Nullable zzayy zzayyVar) {
        zzdnj zzdnjVar = zzdnlVar.zzhks;
        if (zzdnjVar == null) {
            return this;
        }
        zzdnb zzdnbVar = zzdnjVar.zzess;
        if (zzdnbVar != null) {
            zzb(zzdnbVar);
        }
        if (!zzdnjVar.zzhkp.isEmpty()) {
            switch (zzdnjVar.zzhkp.get(0).zzhiy) {
                case 1:
                    this.zzhrj.put(FirebaseAnalytics.Param.AD_FORMAT, "banner");
                    break;
                case 2:
                    this.zzhrj.put(FirebaseAnalytics.Param.AD_FORMAT, "interstitial");
                    break;
                case 3:
                    this.zzhrj.put(FirebaseAnalytics.Param.AD_FORMAT, "native_express");
                    break;
                case 4:
                    this.zzhrj.put(FirebaseAnalytics.Param.AD_FORMAT, "native_advanced");
                    break;
                case 5:
                    this.zzhrj.put(FirebaseAnalytics.Param.AD_FORMAT, "rewarded");
                    break;
                case 6:
                    this.zzhrj.put(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
                    if (zzayyVar != null) {
                        this.zzhrj.put("as", zzayyVar.zzyf() ? "1" : "0");
                        break;
                    }
                    break;
                default:
                    this.zzhrj.put(FirebaseAnalytics.Param.AD_FORMAT, "unknown");
                    break;
            }
        }
        return this;
    }

    public final zzdsa zzb(zzdnb zzdnbVar) {
        if (!TextUtils.isEmpty(zzdnbVar.zzbvs)) {
            this.zzhrj.put("gqi", zzdnbVar.zzbvs);
        }
        return this;
    }

    public final zzdsa zzf(zzdmw zzdmwVar) {
        this.zzhrj.put("aai", zzdmwVar.zzdlu);
        return this;
    }

    public final zzdsa zzgz(@NonNull String str) {
        this.zzhrk.zzha(str);
        return this;
    }

    public final Map<String, String> zzls() {
        HashMap hashMap = new HashMap(this.zzhrj);
        for (zzdsg zzdsgVar : this.zzhrk.zzaxl()) {
            hashMap.put(zzdsgVar.label, zzdsgVar.value);
        }
        return hashMap;
    }

    public final zzdsa zzq(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zzhrj.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zzhrj.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
        return this;
    }

    public final zzdsa zzu(@NonNull String str, @NonNull String str2) {
        this.zzhrj.put(str, str2);
        return this;
    }

    public final zzdsa zzv(@NonNull String str, @NonNull String str2) {
        this.zzhrk.zzw(str, str2);
        return this;
    }
}
