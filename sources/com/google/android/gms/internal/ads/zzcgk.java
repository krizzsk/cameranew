package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcgk {
    private final Context context;
    private final zzbej zzbqa;
    private final zzckn zzdib;
    private final zzdrz zzdic;
    private final zzcqr zzdie;
    private final zzazn zzdtx;
    private final zzei zzesm;
    private final zzdss zzfrf;
    private final Executor zzfsj;
    private final com.google.android.gms.ads.internal.zzb zzghz;
    private final zzcgs zzgiw = new zzcgs(null);
    private final zzain zzgix = new zzain();
    private zzdzw<zzbeb> zzgiy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcgk(zzcgt zzcgtVar) {
        this.context = zzcgt.zza(zzcgtVar);
        this.zzfsj = zzcgt.zzb(zzcgtVar);
        this.zzesm = zzcgt.zzc(zzcgtVar);
        this.zzdtx = zzcgt.zzd(zzcgtVar);
        this.zzghz = zzcgt.zze(zzcgtVar);
        this.zzbqa = zzcgt.zzf(zzcgtVar);
        this.zzdie = zzcgt.zzg(zzcgtVar);
        this.zzfrf = zzcgt.zzh(zzcgtVar);
        this.zzdib = zzcgt.zzi(zzcgtVar);
        this.zzdic = zzcgt.zzj(zzcgtVar);
    }

    public final synchronized void destroy() {
        zzdzw<zzbeb> zzdzwVar = this.zzgiy;
        if (zzdzwVar == null) {
            return;
        }
        zzdzk.zza(zzdzwVar, new zzcgl(this), this.zzfsj);
        this.zzgiy = null;
    }

    public final synchronized void zza(String str, zzaif<Object> zzaifVar) {
        zzdzw<zzbeb> zzdzwVar = this.zzgiy;
        if (zzdzwVar == null) {
            return;
        }
        zzdzk.zza(zzdzwVar, new zzcgo(this, str, zzaifVar), this.zzfsj);
    }

    public final synchronized void zzapo() {
        zzdzw<zzbeb> zzb = zzdzk.zzb(zzbej.zza(this.context, this.zzdtx, (String) zzwr.zzqr().zzd(zzabp.zzcsw), this.zzesm, this.zzghz), new zzdvz(this) { // from class: com.google.android.gms.internal.ads.zzcgj
            private final zzcgk zzgiv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgiv = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdvz
            public final Object apply(Object obj) {
                return this.zzgiv.zzj((zzbeb) obj);
            }
        }, this.zzfsj);
        this.zzgiy = zzb;
        zzazw.zza(zzb, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzb(String str, zzaif<Object> zzaifVar) {
        zzdzw<zzbeb> zzdzwVar = this.zzgiy;
        if (zzdzwVar == null) {
            return;
        }
        zzdzk.zza(zzdzwVar, new zzcgn(this, str, zzaifVar), this.zzfsj);
    }

    public final synchronized zzdzw<JSONObject> zzc(final String str, final JSONObject jSONObject) {
        zzdzw<zzbeb> zzdzwVar = this.zzgiy;
        if (zzdzwVar == null) {
            return zzdzk.zzag(null);
        }
        return zzdzk.zzb(zzdzwVar, new zzdyu(this, str, jSONObject) { // from class: com.google.android.gms.internal.ads.zzcgm
            private final String zzdjf;
            private final zzcgk zzgiv;
            private final JSONObject zzgiz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgiv = this;
                this.zzdjf = str;
                this.zzgiz = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzgiv.zza(this.zzdjf, this.zzgiz, (zzbeb) obj);
            }
        }, this.zzfsj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbeb zzj(zzbeb zzbebVar) {
        zzbebVar.zza("/result", this.zzgix);
        zzbfn zzacx = zzbebVar.zzacx();
        zzcgs zzcgsVar = this.zzgiw;
        zzacx.zza(null, zzcgsVar, zzcgsVar, zzcgsVar, zzcgsVar, false, null, new com.google.android.gms.ads.internal.zza(this.context, null, null), null, null, this.zzdie, this.zzfrf, this.zzdib, this.zzdic);
        return zzbebVar;
    }

    public final synchronized void zza(String str, Map<String, ?> map) {
        zzdzw<zzbeb> zzdzwVar = this.zzgiy;
        if (zzdzwVar == null) {
            return;
        }
        zzdzk.zza(zzdzwVar, new zzcgq(this, str, map), this.zzfsj);
    }

    public final synchronized void zza(zzdmw zzdmwVar, zzdnb zzdnbVar) {
        zzdzw<zzbeb> zzdzwVar = this.zzgiy;
        if (zzdzwVar == null) {
            return;
        }
        zzdzk.zza(zzdzwVar, new zzcgp(this, zzdmwVar, zzdnbVar), this.zzfsj);
    }

    public final <T> void zza(WeakReference<T> weakReference, String str, zzaif<T> zzaifVar) {
        zza(str, new zzcgw(this, weakReference, str, zzaifVar, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zza(String str, JSONObject jSONObject, zzbeb zzbebVar) throws Exception {
        return this.zzgix.zza(zzbebVar, str, jSONObject);
    }
}
