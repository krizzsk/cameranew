package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.tauth.AuthActivity;
import com.zhy.android.percent.support.PercentLayoutHelper;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbkv {
    private final zzckn zzdib;
    private final zzdrz zzdic;
    private final zzdnl zzeyz;

    public zzbkv(zzckn zzcknVar, zzdnl zzdnlVar, zzdrz zzdrzVar) {
        this.zzdic = zzdrzVar;
        this.zzdib = zzcknVar;
        this.zzeyz = zzdnlVar;
    }

    private static String zzdw(int i2) {
        int i3 = zzbky.zzftz[i2 - 1];
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? "u" : "cb" : "ac" : "cc" : PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H : "bb";
    }

    public final void zzb(long j2, int i2) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdal)).booleanValue()) {
            this.zzdic.zzb(zzdsa.zzgx("ad_closed").zzb(this.zzeyz.zzhks.zzess).zzu("show_time", String.valueOf(j2)).zzu(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad").zzu("acr", zzdw(i2)));
        } else {
            this.zzdib.zzaqr().zza(this.zzeyz.zzhks.zzess).zzr(AuthActivity.ACTION_KEY, "ad_closed").zzr("show_time", String.valueOf(j2)).zzr(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad").zzr("acr", zzdw(i2)).zzaqt();
        }
    }
}
