package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.q;
import com.tencent.matrix.report.Issue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdar implements zzdfj<Bundle> {
    private final zzdnp zzfwy;

    public zzdar(zzdnp zzdnpVar) {
        q.k(zzdnpVar, "the targeting must not be null");
        this.zzfwy = zzdnpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzvl zzvlVar = this.zzfwy.zzhkw;
        bundle2.putInt("http_timeout_millis", zzvlVar.zzcic);
        bundle2.putString("slotname", this.zzfwy.zzhkx);
        int i2 = zzdaq.zzgju[this.zzfwy.zzhle.zzhki - 1];
        if (i2 == 1) {
            bundle2.putBoolean("is_new_rewarded", true);
        } else if (i2 == 2) {
            bundle2.putBoolean("is_rewarded_interstitial", true);
        }
        zzdnz.zza(bundle2, "cust_age", new SimpleDateFormat(AdvTimeUtils.DATE_FORMAT_DAY, Locale.US).format(new Date(zzvlVar.zzchn)), zzvlVar.zzchn != -1);
        zzdnz.zza(bundle2, "extras", zzvlVar.extras);
        zzdnz.zza(bundle2, "cust_gender", Integer.valueOf(zzvlVar.zzcho), zzvlVar.zzcho != -1);
        zzdnz.zza(bundle2, "kw", zzvlVar.zzchp);
        zzdnz.zza(bundle2, "tag_for_child_directed_treatment", Integer.valueOf(zzvlVar.zzado), zzvlVar.zzado != -1);
        boolean z = zzvlVar.zzchq;
        if (z) {
            bundle2.putBoolean("test_request", z);
        }
        zzdnz.zza(bundle2, "d_imp_hdr", (Integer) 1, zzvlVar.versionCode >= 2 && zzvlVar.zzbni);
        String str = zzvlVar.zzchr;
        zzdnz.zza(bundle2, "ppid", str, zzvlVar.versionCode >= 2 && !TextUtils.isEmpty(str));
        Location location = zzvlVar.zznb;
        if (location != null) {
            Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
            Long valueOf2 = Long.valueOf(location.getTime() * 1000);
            Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
            Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
            Bundle bundle3 = new Bundle();
            bundle3.putFloat("radius", valueOf.floatValue());
            bundle3.putLong("lat", valueOf3.longValue());
            bundle3.putLong(Constants.LONG, valueOf4.longValue());
            bundle3.putLong(Issue.ISSUE_REPORT_TIME, valueOf2.longValue());
            bundle2.putBundle("uule", bundle3);
        }
        zzdnz.zza(bundle2, "url", zzvlVar.zzcht);
        zzdnz.zza(bundle2, "neighboring_content_urls", zzvlVar.zzcib);
        zzdnz.zza(bundle2, "custom_targeting", zzvlVar.zzchv);
        zzdnz.zza(bundle2, "category_exclusions", zzvlVar.zzchw);
        zzdnz.zza(bundle2, "request_agent", zzvlVar.zzchx);
        zzdnz.zza(bundle2, "request_pkg", zzvlVar.zzchy);
        zzdnz.zza(bundle2, "is_designed_for_families", Boolean.valueOf(zzvlVar.zzchz), zzvlVar.versionCode >= 7);
        if (zzvlVar.versionCode >= 8) {
            zzdnz.zza(bundle2, "tag_for_under_age_of_consent", Integer.valueOf(zzvlVar.zzadp), zzvlVar.zzadp != -1);
            zzdnz.zza(bundle2, "max_ad_content_rating", zzvlVar.zzadq);
        }
    }
}
