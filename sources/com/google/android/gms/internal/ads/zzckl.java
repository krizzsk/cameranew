package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public final class zzckl {
    private final zzayy zzebw;
    private ConcurrentHashMap<String, String> zzglq;

    public zzckl(zzckw zzckwVar, zzayy zzayyVar) {
        this.zzglq = new ConcurrentHashMap<>(zzckwVar.zzgls);
        this.zzebw = zzayyVar;
    }

    public final void zzc(zzdnl zzdnlVar) {
        if (zzdnlVar.zzhks.zzhkp.size() > 0) {
            switch (zzdnlVar.zzhks.zzhkp.get(0).zzhiy) {
                case 1:
                    this.zzglq.put(FirebaseAnalytics.Param.AD_FORMAT, "banner");
                    break;
                case 2:
                    this.zzglq.put(FirebaseAnalytics.Param.AD_FORMAT, "interstitial");
                    break;
                case 3:
                    this.zzglq.put(FirebaseAnalytics.Param.AD_FORMAT, "native_express");
                    break;
                case 4:
                    this.zzglq.put(FirebaseAnalytics.Param.AD_FORMAT, "native_advanced");
                    break;
                case 5:
                    this.zzglq.put(FirebaseAnalytics.Param.AD_FORMAT, "rewarded");
                    break;
                case 6:
                    this.zzglq.put(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
                    this.zzglq.put("as", this.zzebw.zzyf() ? "1" : "0");
                    break;
                default:
                    this.zzglq.put(FirebaseAnalytics.Param.AD_FORMAT, "unknown");
                    break;
            }
        }
        if (TextUtils.isEmpty(zzdnlVar.zzhks.zzess.zzbvs)) {
            return;
        }
        this.zzglq.put("gqi", zzdnlVar.zzhks.zzess.zzbvs);
    }

    public final void zzi(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zzglq.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zzglq.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }

    public final Map<String, String> zzso() {
        return this.zzglq;
    }
}
