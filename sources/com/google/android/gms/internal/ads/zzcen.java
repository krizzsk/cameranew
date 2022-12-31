package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyConstants;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcen {
    private final zzdzv zzghl;
    private final zzcer zzghm;
    private final zzcfb zzghn;

    public zzcen(zzdzv zzdzvVar, zzcer zzcerVar, zzcfb zzcfbVar) {
        this.zzghl = zzdzvVar;
        this.zzghm = zzcerVar;
        this.zzghn = zzcfbVar;
    }

    public final zzdzw<zzccd> zza(final zzdnl zzdnlVar, final zzdmw zzdmwVar, final JSONObject jSONObject) {
        zzdzw zzb;
        final zzdzw zze = this.zzghl.zze(new Callable(this, zzdnlVar, zzdmwVar, jSONObject) { // from class: com.google.android.gms.internal.ads.zzceq
            private final zzdmw zzfva;
            private final zzcen zzgho;
            private final zzdnl zzghw;
            private final JSONObject zzghx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgho = this;
                this.zzghw = zzdnlVar;
                this.zzfva = zzdmwVar;
                this.zzghx = jSONObject;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdnl zzdnlVar2 = this.zzghw;
                zzdmw zzdmwVar2 = this.zzfva;
                JSONObject jSONObject2 = this.zzghx;
                zzccd zzccdVar = new zzccd();
                zzccdVar.zzdz(jSONObject2.optInt("template_id", -1));
                zzccdVar.zzfx(jSONObject2.optString("custom_template_id"));
                JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
                zzccdVar.zzfy(optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null);
                zzdnp zzdnpVar = zzdnlVar2.zzhkr.zzfwy;
                if (zzdnpVar.zzhky.contains(Integer.toString(zzccdVar.zzanu()))) {
                    if (zzccdVar.zzanu() == 3) {
                        if (zzccdVar.getCustomTemplateId() != null) {
                            if (!zzdnpVar.zzhkz.contains(zzccdVar.getCustomTemplateId())) {
                                throw new zzcva(zzdom.INTERNAL_ERROR, "Unexpected custom template id in the response.");
                            }
                        } else {
                            throw new zzcva(zzdom.INTERNAL_ERROR, "No custom template id for custom template ad response.");
                        }
                    }
                    zzccdVar.setStarRating(jSONObject2.optDouble("rating", -1.0d));
                    String optString = jSONObject2.optString("headline", null);
                    if (zzdmwVar2.zzdxt) {
                        com.google.android.gms.ads.internal.zzr.zzkr();
                        String zzzb = com.google.android.gms.ads.internal.util.zzj.zzzb();
                        StringBuilder sb = new StringBuilder(String.valueOf(zzzb).length() + 3 + String.valueOf(optString).length());
                        sb.append(zzzb);
                        sb.append(" : ");
                        sb.append(optString);
                        optString = sb.toString();
                    }
                    zzccdVar.zzn("headline", optString);
                    zzccdVar.zzn("body", jSONObject2.optString("body", null));
                    zzccdVar.zzn("call_to_action", jSONObject2.optString("call_to_action", null));
                    zzccdVar.zzn(TapjoyConstants.TJC_STORE, jSONObject2.optString(TapjoyConstants.TJC_STORE, null));
                    zzccdVar.zzn(FirebaseAnalytics.Param.PRICE, jSONObject2.optString(FirebaseAnalytics.Param.PRICE, null));
                    zzccdVar.zzn("advertiser", jSONObject2.optString("advertiser", null));
                    return zzccdVar;
                }
                zzdom zzdomVar = zzdom.INTERNAL_ERROR;
                int zzanu = zzccdVar.zzanu();
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Invalid template ID: ");
                sb2.append(zzanu);
                throw new zzcva(zzdomVar, sb2.toString());
            }
        });
        final zzdzw<List<zzaed>> zzd = this.zzghm.zzd(jSONObject, "images");
        final zzdzw<zzaed> zzc = this.zzghm.zzc(jSONObject, "secondary_image");
        final zzdzw<zzaed> zzc2 = this.zzghm.zzc(jSONObject, "app_icon");
        final zzdzw<zzady> zze2 = this.zzghm.zze(jSONObject, "attribution");
        final zzdzw<zzbeb> zzm = this.zzghm.zzm(jSONObject);
        final zzcer zzcerVar = this.zzghm;
        if (!jSONObject.optBoolean("enable_omid")) {
            zzb = zzdzk.zzag(null);
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzb = zzdzk.zzag(null);
            } else {
                final String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzb = zzdzk.zzag(null);
                } else {
                    zzb = zzdzk.zzb(zzdzk.zzag(null), new zzdyu(zzcerVar, optString) { // from class: com.google.android.gms.internal.ads.zzcev
                        private final String zzdjf;
                        private final zzcer zzgie;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzgie = zzcerVar;
                            this.zzdjf = optString;
                        }

                        @Override // com.google.android.gms.internal.ads.zzdyu
                        public final zzdzw zzf(Object obj) {
                            return this.zzgie.zza(this.zzdjf, obj);
                        }
                    }, zzazp.zzeig);
                }
            }
        }
        final zzdzw zzdzwVar = zzb;
        final zzdzw<List<zzcfg>> zzg = this.zzghn.zzg(jSONObject, "custom_assets");
        return zzdzk.zza(zze, zzd, zzc, zzc2, zze2, zzm, zzdzwVar, zzg).zzb(new Callable(this, zze, zzd, zzc2, zzc, zze2, jSONObject, zzm, zzdzwVar, zzg) { // from class: com.google.android.gms.internal.ads.zzcep
            private final zzdzw zzfwq;
            private final zzdzw zzfym;
            private final zzcen zzgho;
            private final zzdzw zzghp;
            private final zzdzw zzghq;
            private final zzdzw zzghr;
            private final JSONObject zzghs;
            private final zzdzw zzght;
            private final zzdzw zzghu;
            private final zzdzw zzghv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgho = this;
                this.zzfym = zze;
                this.zzfwq = zzd;
                this.zzghp = zzc2;
                this.zzghq = zzc;
                this.zzghr = zze2;
                this.zzghs = jSONObject;
                this.zzght = zzm;
                this.zzghu = zzdzwVar;
                this.zzghv = zzg;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdzw zzdzwVar2 = this.zzfym;
                zzdzw zzdzwVar3 = this.zzfwq;
                zzdzw zzdzwVar4 = this.zzghp;
                zzdzw zzdzwVar5 = this.zzghq;
                zzdzw zzdzwVar6 = this.zzghr;
                JSONObject jSONObject2 = this.zzghs;
                zzdzw zzdzwVar7 = this.zzght;
                zzdzw zzdzwVar8 = this.zzghu;
                zzdzw zzdzwVar9 = this.zzghv;
                zzccd zzccdVar = (zzccd) zzdzwVar2.get();
                zzccdVar.setImages((List) zzdzwVar3.get());
                zzccdVar.zza((zzaer) zzdzwVar4.get());
                zzccdVar.zzb((zzaer) zzdzwVar5.get());
                zzccdVar.zza((zzaej) zzdzwVar6.get());
                zzccdVar.zzh(zzcer.zzj(jSONObject2));
                zzccdVar.zza(zzcer.zzk(jSONObject2));
                zzbeb zzbebVar = (zzbeb) zzdzwVar7.get();
                if (zzbebVar != null) {
                    zzccdVar.zzf(zzbebVar);
                    zzccdVar.zzac(zzbebVar.getView());
                    zzccdVar.zzb(zzbebVar.zzabc());
                }
                zzbeb zzbebVar2 = (zzbeb) zzdzwVar8.get();
                if (zzbebVar2 != null) {
                    zzccdVar.zzg(zzbebVar2);
                }
                for (zzcfg zzcfgVar : (List) zzdzwVar9.get()) {
                    int i2 = zzcfgVar.type;
                    if (i2 == 1) {
                        zzccdVar.zzn(zzcfgVar.zzcm, zzcfgVar.zzdre);
                    } else if (i2 == 2) {
                        zzccdVar.zza(zzcfgVar.zzcm, zzcfgVar.zzgij);
                    }
                }
                return zzccdVar;
            }
        }, this.zzghl);
    }
}
