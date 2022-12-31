package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.o;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzctx implements zzcty<zzcbu> {
    private final zzdzv zzghl;
    private final zzcau zzgun;
    private final zzcen zzguo;
    private final zzdof<zzcgk> zzgup;

    public zzctx(zzcau zzcauVar, zzdzv zzdzvVar, zzcen zzcenVar, zzdof<zzcgk> zzdofVar) {
        this.zzgun = zzcauVar;
        this.zzghl = zzdzvVar;
        this.zzguo = zzcenVar;
        this.zzgup = zzdofVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrj
    public final boolean zza(zzdnl zzdnlVar, zzdmw zzdmwVar) {
        zzdnd zzdndVar = zzdmwVar.zzhjg;
        return (zzdndVar == null || zzdndVar.zzgcf == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcrj
    public final zzdzw<List<zzdzw<zzcbu>>> zzb(final zzdnl zzdnlVar, final zzdmw zzdmwVar) {
        return zzdzk.zzb(zzdzk.zzb(this.zzgup.zzavm(), new zzdyu(this, zzdmwVar) { // from class: com.google.android.gms.internal.ads.zzcua
            private final zzdmw zzgtb;
            private final zzctx zzguq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzguq = this;
                this.zzgtb = zzdmwVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzguq.zza(this.zzgtb, (zzcgk) obj);
            }
        }, this.zzghl), new zzdyu(this, zzdnlVar, zzdmwVar) { // from class: com.google.android.gms.internal.ads.zzctz
            private final zzdmw zzfva;
            private final zzdnl zzghw;
            private final zzctx zzguq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzguq = this;
                this.zzghw = zzdnlVar;
                this.zzfva = zzdmwVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzguq.zza(this.zzghw, this.zzfva, (JSONArray) obj);
            }
        }, this.zzghl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcbu zza(zzdzw zzdzwVar, zzdzw zzdzwVar2, zzdnl zzdnlVar, zzdmw zzdmwVar, JSONObject jSONObject) throws Exception {
        zzccd zzccdVar = (zzccd) zzdzwVar.get();
        zzcgk zzcgkVar = (zzcgk) zzdzwVar2.get();
        zzccf zza = this.zzgun.zza(new zzboj(zzdnlVar, zzdmwVar, null), new zzccp(zzccdVar), new zzcbi(jSONObject, zzcgkVar));
        zza.zzagv().zzapn();
        zza.zzagw().zzb(zzcgkVar);
        zza.zzagx().zzi(zzccdVar.zzanz());
        return zza.zzagu();
    }

    private final zzdzw<zzcbu> zzb(final zzdnl zzdnlVar, final zzdmw zzdmwVar, final JSONObject jSONObject) {
        final zzdzw<zzcgk> zzavm = this.zzgup.zzavm();
        final zzdzw<zzccd> zza = this.zzguo.zza(zzdnlVar, zzdmwVar, jSONObject);
        return zzdzk.zzb(zzavm, zza).zzb(new Callable(this, zza, zzavm, zzdnlVar, zzdmwVar, jSONObject) { // from class: com.google.android.gms.internal.ads.zzcue
            private final zzdzw zzfwq;
            private final zzdzw zzfym;
            private final zzctx zzguq;
            private final zzdnl zzgut;
            private final zzdmw zzguu;
            private final JSONObject zzguv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzguq = this;
                this.zzfym = zza;
                this.zzfwq = zzavm;
                this.zzgut = zzdnlVar;
                this.zzguu = zzdmwVar;
                this.zzguv = jSONObject;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzguq.zza(this.zzfym, this.zzfwq, this.zzgut, this.zzguu, this.zzguv);
            }
        }, this.zzghl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zza(zzcgk zzcgkVar, JSONObject jSONObject) throws Exception {
        this.zzgup.zzd(zzdzk.zzag(zzcgkVar));
        if (jSONObject.optBoolean(FirebaseAnalytics.Param.SUCCESS)) {
            return zzdzk.zzag(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzaly("process json failed");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zza(zzdnl zzdnlVar, zzdmw zzdmwVar, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzdzk.immediateFailedFuture(new zzcmb(zzdom.NO_FILL));
        }
        if (zzdnlVar.zzhkr.zzfwy.zzgzc > 1) {
            int length = jSONArray.length();
            this.zzgup.ensureSize(Math.min(length, zzdnlVar.zzhkr.zzfwy.zzgzc));
            ArrayList arrayList = new ArrayList(zzdnlVar.zzhkr.zzfwy.zzgzc);
            for (int i2 = 0; i2 < zzdnlVar.zzhkr.zzfwy.zzgzc; i2++) {
                if (i2 < length) {
                    arrayList.add(zzb(zzdnlVar, zzdmwVar, jSONArray.getJSONObject(i2)));
                } else {
                    arrayList.add(zzdzk.immediateFailedFuture(new zzcmb(zzdom.NO_FILL)));
                }
            }
            return zzdzk.zzag(arrayList);
        }
        return zzdzk.zzb(zzb(zzdnlVar, zzdmwVar, jSONArray.getJSONObject(0)), zzcub.zzeaj, this.zzghl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zza(zzdmw zzdmwVar, final zzcgk zzcgkVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdai)).booleanValue() && o.n()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzdmwVar.zzhjg.zzgcf);
        jSONObject2.put("sdk_params", jSONObject);
        return zzdzk.zzb(zzcgkVar.zzc("google.afma.nativeAds.preProcessJson", jSONObject2), new zzdyu(this, zzcgkVar) { // from class: com.google.android.gms.internal.ads.zzcuc
            private final zzctx zzguq;
            private final zzcgk zzgur;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzguq = this;
                this.zzgur = zzcgkVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzguq.zza(this.zzgur, (JSONObject) obj);
            }
        }, this.zzghl);
    }
}
