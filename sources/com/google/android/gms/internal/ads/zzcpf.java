package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.ads.AdSDKNotificationListener;
import com.google.android.gms.ads.MobileAds;
import java.util.regex.Pattern;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcpf implements zzbrq, zzbse, zzbvq, zzvc {
    private final Context context;
    @NonNull
    private final zzdrz zzdic;
    private final zzcqr zzdie;
    private final String zzdun;
    private final zzdnl zzeyz;
    private final zzdmw zzfrj;
    private final zzdoc zzglj;
    @Nullable
    private Boolean zzglk;
    private final boolean zzgll = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcyz)).booleanValue();

    public zzcpf(Context context, zzdoc zzdocVar, zzdnl zzdnlVar, zzdmw zzdmwVar, zzcqr zzcqrVar, @NonNull zzdrz zzdrzVar, String str) {
        this.context = context;
        this.zzglj = zzdocVar;
        this.zzeyz = zzdnlVar;
        this.zzfrj = zzdmwVar;
        this.zzdie = zzcqrVar;
        this.zzdic = zzdrzVar;
        this.zzdun = str;
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

    private final zzdsa zzgk(String str) {
        zzdsa zzu = zzdsa.zzgx(str).zza(this.zzeyz, null).zzf(this.zzfrj).zzu("request_id", this.zzdun);
        if (!this.zzfrj.zzhjh.isEmpty()) {
            zzu.zzu("ancn", this.zzfrj.zzhjh.get(0));
        }
        if (this.zzfrj.zzhjz) {
            com.google.android.gms.ads.internal.zzr.zzkr();
            zzu.zzu("device_connectivity", com.google.android.gms.ads.internal.util.zzj.zzba(this.context) ? "online" : "offline");
            zzu.zzu("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis()));
            zzu.zzu("offline_ad", "1");
        }
        return zzu;
    }

    @Override // com.google.android.gms.internal.ads.zzvc
    public final void onAdClicked() {
        if (this.zzfrj.zzhjz) {
            zza(zzgk("click"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbse
    public final void onAdImpression() {
        if (zzaqo() || this.zzfrj.zzhjz) {
            zza(zzgk(AdSDKNotificationListener.IMPRESSION_EVENT));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrq
    public final void zza(zzcaf zzcafVar) {
        if (this.zzgll) {
            zzdsa zzu = zzgk("ifts").zzu("reason", "exception");
            if (!TextUtils.isEmpty(zzcafVar.getMessage())) {
                zzu.zzu("msg", zzcafVar.getMessage());
            }
            this.zzdic.zzb(zzu);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final void zzale() {
        if (zzaqo()) {
            this.zzdic.zzb(zzgk("adapter_impression"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final void zzalg() {
        if (zzaqo()) {
            this.zzdic.zzb(zzgk("adapter_shown"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrq
    public final void zzalp() {
        if (this.zzgll) {
            this.zzdic.zzb(zzgk("ifts").zzu("reason", "blocked"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrq
    public final void zzl(zzvg zzvgVar) {
        zzvg zzvgVar2;
        if (this.zzgll) {
            int i2 = zzvgVar.errorCode;
            String str = zzvgVar.zzchg;
            if (zzvgVar.zzchh.equals(MobileAds.ERROR_DOMAIN) && (zzvgVar2 = zzvgVar.zzchi) != null && !zzvgVar2.zzchh.equals(MobileAds.ERROR_DOMAIN)) {
                zzvg zzvgVar3 = zzvgVar.zzchi;
                i2 = zzvgVar3.errorCode;
                str = zzvgVar3.zzchg;
            }
            String zzgt = this.zzglj.zzgt(str);
            zzdsa zzu = zzgk("ifts").zzu("reason", "adapter");
            if (i2 >= 0) {
                zzu.zzu("arec", String.valueOf(i2));
            }
            if (zzgt != null) {
                zzu.zzu("areec", zzgt);
            }
            this.zzdic.zzb(zzu);
        }
    }

    private final void zza(zzdsa zzdsaVar) {
        if (this.zzfrj.zzhjz) {
            this.zzdie.zza(new zzcrc(com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis(), this.zzeyz.zzhks.zzess.zzbvs, this.zzdic.zzc(zzdsaVar), zzcqs.zzgru));
            return;
        }
        this.zzdic.zzb(zzdsaVar);
    }
}
