package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.AdSDKNotificationListener;
import com.google.android.gms.ads.MobileAds;
import com.tencent.tauth.AuthActivity;
import java.util.regex.Pattern;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzckb implements zzbrq, zzbse, zzbvq, zzvc {
    private final Context context;
    private final zzckn zzdib;
    private final zzcqr zzdie;
    private final zzdnl zzeyz;
    private final zzdmw zzfrj;
    private final zzdoc zzglj;
    @Nullable
    private Boolean zzglk;
    private final boolean zzgll = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcyz)).booleanValue();

    public zzckb(Context context, zzdoc zzdocVar, zzckn zzcknVar, zzdnl zzdnlVar, zzdmw zzdmwVar, zzcqr zzcqrVar) {
        this.context = context;
        this.zzglj = zzdocVar;
        this.zzdib = zzcknVar;
        this.zzeyz = zzdnlVar;
        this.zzfrj = zzdmwVar;
        this.zzdie = zzcqrVar;
    }

    private final boolean zzaqo() {
        if (this.zzglk == null) {
            synchronized (this) {
                if (this.zzglk == null) {
                    zzaba<String> zzabaVar = zzabp.zzcrc;
                    com.google.android.gms.ads.internal.zzr.zzkr();
                    this.zzglk = Boolean.valueOf(zze((String) zzwr.zzqr().zzd(zzabaVar), com.google.android.gms.ads.internal.util.zzj.zzay(this.context)));
                }
            }
        }
        return this.zzglk.booleanValue();
    }

    private static boolean zze(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e2) {
                com.google.android.gms.ads.internal.zzr.zzkv().zza(e2, "CsiActionsListener.isPatternMatched");
            }
        }
        return false;
    }

    private final zzckq zzge(String str) {
        zzckq zzc = this.zzdib.zzaqr().zza(this.zzeyz.zzhks.zzess).zzc(this.zzfrj);
        zzc.zzr(AuthActivity.ACTION_KEY, str);
        if (!this.zzfrj.zzhjh.isEmpty()) {
            zzc.zzr("ancn", this.zzfrj.zzhjh.get(0));
        }
        if (this.zzfrj.zzhjz) {
            com.google.android.gms.ads.internal.zzr.zzkr();
            zzc.zzr("device_connectivity", com.google.android.gms.ads.internal.util.zzj.zzba(this.context) ? "online" : "offline");
            zzc.zzr("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis()));
            zzc.zzr("offline_ad", "1");
        }
        return zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzvc
    public final void onAdClicked() {
        if (this.zzfrj.zzhjz) {
            zza(zzge("click"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbse
    public final void onAdImpression() {
        if (zzaqo() || this.zzfrj.zzhjz) {
            zza(zzge(AdSDKNotificationListener.IMPRESSION_EVENT));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrq
    public final void zza(zzcaf zzcafVar) {
        if (this.zzgll) {
            zzckq zzge = zzge("ifts");
            zzge.zzr("reason", "exception");
            if (!TextUtils.isEmpty(zzcafVar.getMessage())) {
                zzge.zzr("msg", zzcafVar.getMessage());
            }
            zzge.zzaqt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final void zzale() {
        if (zzaqo()) {
            zzge("adapter_impression").zzaqt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final void zzalg() {
        if (zzaqo()) {
            zzge("adapter_shown").zzaqt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrq
    public final void zzalp() {
        if (this.zzgll) {
            zzckq zzge = zzge("ifts");
            zzge.zzr("reason", "blocked");
            zzge.zzaqt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrq
    public final void zzl(zzvg zzvgVar) {
        zzvg zzvgVar2;
        if (this.zzgll) {
            zzckq zzge = zzge("ifts");
            zzge.zzr("reason", "adapter");
            int i2 = zzvgVar.errorCode;
            String str = zzvgVar.zzchg;
            if (zzvgVar.zzchh.equals(MobileAds.ERROR_DOMAIN) && (zzvgVar2 = zzvgVar.zzchi) != null && !zzvgVar2.zzchh.equals(MobileAds.ERROR_DOMAIN)) {
                zzvg zzvgVar3 = zzvgVar.zzchi;
                i2 = zzvgVar3.errorCode;
                str = zzvgVar3.zzchg;
            }
            if (i2 >= 0) {
                zzge.zzr("arec", String.valueOf(i2));
            }
            String zzgt = this.zzglj.zzgt(str);
            if (zzgt != null) {
                zzge.zzr("areec", zzgt);
            }
            zzge.zzaqt();
        }
    }

    private final void zza(zzckq zzckqVar) {
        if (this.zzfrj.zzhjz) {
            this.zzdie.zza(new zzcrc(com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis(), this.zzeyz.zzhks.zzess.zzbvs, zzckqVar.zzaqu(), zzcqs.zzgru));
            return;
        }
        zzckqVar.zzaqt();
    }
}
