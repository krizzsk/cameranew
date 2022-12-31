package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcol extends zzatg {
    private final Context context;
    private final Executor zzfsj;
    private final zzauh zzgpl;
    private final zzaue zzgpm;
    private final zzbjd zzgpn;
    private final HashMap<String, zzcpa> zzgpo;

    public zzcol(Context context, Executor executor, zzauh zzauhVar, zzbjd zzbjdVar, zzaue zzaueVar, HashMap<String, zzcpa> hashMap) {
        zzabp.initialize(context);
        this.context = context;
        this.zzfsj = executor;
        this.zzgpl = zzauhVar;
        this.zzgpm = zzaueVar;
        this.zzgpn = zzbjdVar;
        this.zzgpo = hashMap;
    }

    private static zzdzw<JSONObject> zza(zzatq zzatqVar, zzdrj zzdrjVar, final zzdga zzdgaVar) {
        zzdyu zzdyuVar = new zzdyu(zzdgaVar) { // from class: com.google.android.gms.internal.ads.zzcop
            private final zzdga zzgpp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgpp = zzdgaVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzgpp.zzaha().zzs(com.google.android.gms.ads.internal.zzr.zzkr().zzc((Bundle) obj));
            }
        };
        return zzdrjVar.zza((zzdrj) zzdrk.GMS_SIGNALS, zzdzk.zzag(zzatqVar.zzdxi)).zza(zzdyuVar).zzb(zzcos.zzgnx).zzaxj();
    }

    @Override // com.google.android.gms.internal.ads.zzath
    public final zzatd zza(zzatb zzatbVar) throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzath
    public final void zza(zzatb zzatbVar, zzati zzatiVar) throws RemoteException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzarq() {
        zzazw.zza(this.zzgpm.zzwt(), "persistFlags");
    }

    public final zzdzw<InputStream> zzb(zzatq zzatqVar, int i2) {
        zzamj zza = com.google.android.gms.ads.internal.zzr.zzle().zza(this.context, zzazn.zzaab());
        zzdga zza2 = this.zzgpn.zza(zzatqVar, i2);
        zzamb zza3 = zza.zza("google.afma.response.normalize", zzcoz.zzgpw, zzame.zzdkt);
        zzcpe zzcpeVar = new zzcpe(this.context, zzatqVar.zzdtx.zzbrp, this.zzgpl, zzatqVar.zzdux, i2);
        zzdrj zzahc = zza2.zzahc();
        zzcpa zzcpaVar = null;
        if (!zzadm.zzdef.get().booleanValue()) {
            String str = zzatqVar.zzdxl;
            if (str != null && !str.isEmpty()) {
                com.google.android.gms.ads.internal.util.zzd.zzeb("Request contained a PoolKey but split request is disabled.");
            }
        } else {
            String str2 = zzatqVar.zzdxl;
            if (str2 != null && !str2.isEmpty() && (zzcpaVar = this.zzgpo.remove(zzatqVar.zzdxl)) == null) {
                com.google.android.gms.ads.internal.util.zzd.zzeb("Request contained a PoolKey but no matching parameters were found.");
            }
        }
        if (zzcpaVar == null) {
            final zzdzw<JSONObject> zza4 = zza(zzatqVar, zzahc, zza2);
            final zzdzw<zzatw> zza5 = zza(zza4, zzahc, zza);
            final zzdqw zzaxj = zzahc.zza((zzdrj) zzdrk.HTTP, zza5, zza4).zzb(new Callable(zza4, zza5) { // from class: com.google.android.gms.internal.ads.zzcoo
                private final zzdzw zzfym;
                private final zzdzw zzgig;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgig = zza4;
                    this.zzfym = zza5;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzcpd((JSONObject) this.zzgig.get(), (zzatw) this.zzfym.get());
                }
            }).zzb(zzcpeVar).zzaxj();
            return zzahc.zza((zzdrj) zzdrk.PRE_PROCESS, zza4, zza5, zzaxj).zzb(new Callable(zzaxj, zza4, zza5) { // from class: com.google.android.gms.internal.ads.zzcon
                private final zzdzw zzfwq;
                private final zzdzw zzfym;
                private final zzdzw zzgig;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgig = zzaxj;
                    this.zzfym = zza4;
                    this.zzfwq = zza5;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzcoz((zzcpg) this.zzgig.get(), (JSONObject) this.zzfym.get(), (zzatw) this.zzfwq.get());
                }
            }).zza(zza3).zzaxj();
        }
        final zzdqw zzaxj2 = zzahc.zza((zzdrj) zzdrk.HTTP, zzdzk.zzag(new zzcpd(zzcpaVar.zzgpu, zzcpaVar.zzgpv))).zzb(zzcpeVar).zzaxj();
        final zzdzw<?> zzag = zzdzk.zzag(zzcpaVar);
        return zzahc.zza((zzdrj) zzdrk.PRE_PROCESS, zzaxj2, zzag).zzb(new Callable(zzaxj2, zzag) { // from class: com.google.android.gms.internal.ads.zzcoq
            private final zzdzw zzfym;
            private final zzdzw zzgig;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgig = zzaxj2;
                this.zzfym = zzag;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdzw zzdzwVar = this.zzgig;
                zzdzw zzdzwVar2 = this.zzfym;
                return new zzcoz((zzcpg) zzdzwVar.get(), ((zzcpa) zzdzwVar2.get()).zzgpu, ((zzcpa) zzdzwVar2.get()).zzgpv);
            }
        }).zza(zza3).zzaxj();
    }

    public final zzdzw<InputStream> zzc(zzatq zzatqVar, int i2) {
        if (!zzadm.zzdef.get().booleanValue()) {
            return zzdzk.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        zzdpf zzdpfVar = zzatqVar.zzdxk;
        if (zzdpfVar == null) {
            return zzdzk.immediateFailedFuture(new Exception("Pool configuration missing from request."));
        }
        if (zzdpfVar.zzhnn != 0 && zzdpfVar.zzhno != 0) {
            zzamj zza = com.google.android.gms.ads.internal.zzr.zzle().zza(this.context, zzazn.zzaab());
            zzdga zza2 = this.zzgpn.zza(zzatqVar, i2);
            zzdrj zzahc = zza2.zzahc();
            final zzdzw<JSONObject> zza3 = zza(zzatqVar, zzahc, zza2);
            final zzdzw<zzatw> zza4 = zza(zza3, zzahc, zza);
            return zzahc.zza((zzdrj) zzdrk.GET_URL_AND_CACHE_KEY, zza3, zza4).zzb(new Callable(this, zza4, zza3) { // from class: com.google.android.gms.internal.ads.zzcot
                private final zzdzw zzfwq;
                private final zzdzw zzfym;
                private final zzcol zzgpq;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgpq = this;
                    this.zzfym = zza4;
                    this.zzfwq = zza3;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzgpq.zza(this.zzfym, this.zzfwq);
                }
            }).zzaxj();
        }
        return zzdzk.immediateFailedFuture(new Exception("Caching is disabled."));
    }

    public final zzdzw<InputStream> zzd(zzatq zzatqVar, int i2) {
        zzamj zza = com.google.android.gms.ads.internal.zzr.zzle().zza(this.context, zzazn.zzaab());
        if (!zzads.zzdex.get().booleanValue()) {
            return zzdzk.immediateFailedFuture(new Exception("Signal collection disabled."));
        }
        zzdga zza2 = this.zzgpn.zza(zzatqVar, i2);
        final zzdfl<JSONObject> zzahb = zza2.zzahb();
        return zza2.zzahc().zza((zzdrj) zzdrk.GET_SIGNALS, zzdzk.zzag(zzatqVar.zzdxi)).zza(new zzdyu(zzahb) { // from class: com.google.android.gms.internal.ads.zzcow
            private final zzdfl zzgpr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgpr = zzahb;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzgpr.zzs(com.google.android.gms.ads.internal.zzr.zzkr().zzc((Bundle) obj));
            }
        }).zzv(zzdrk.JS_SIGNALS).zza(zza.zza("google.afma.request.getSignals", zzame.zzdks, zzame.zzdkt)).zzaxj();
    }

    public final zzdzw<InputStream> zzgj(String str) {
        if (!zzadm.zzdef.get().booleanValue()) {
            return zzdzk.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        zzcoy zzcoyVar = new zzcoy(this);
        if (this.zzgpo.remove(str) == null) {
            String valueOf = String.valueOf(str);
            return zzdzk.immediateFailedFuture(new Exception(valueOf.length() != 0 ? "URL to be removed not found for cache key: ".concat(valueOf) : new String("URL to be removed not found for cache key: ")));
        }
        return zzdzk.zzag(zzcoyVar);
    }

    private static zzdzw<zzatw> zza(zzdzw<JSONObject> zzdzwVar, zzdrj zzdrjVar, zzamj zzamjVar) {
        return zzdrjVar.zza((zzdrj) zzdrk.BUILD_URL, (zzdzw) zzdzwVar).zza(zzamjVar.zza("AFMA_getAdDictionary", zzame.zzdks, zzcor.zzdku)).zzaxj();
    }

    @Override // com.google.android.gms.internal.ads.zzath
    public final void zza(zzatq zzatqVar, zzatk zzatkVar) {
        zzdzw<InputStream> zzb = zzb(zzatqVar, Binder.getCallingUid());
        zza(zzb, zzatkVar);
        zzb.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcou
            private final zzcol zzgpq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgpq = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgpq.zzarq();
            }
        }, this.zzfsj);
    }

    @Override // com.google.android.gms.internal.ads.zzath
    public final void zza(String str, zzatk zzatkVar) {
        zza(zzgj(str), zzatkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzath
    public final void zzc(zzatq zzatqVar, zzatk zzatkVar) {
        zza(zzc(zzatqVar, Binder.getCallingUid()), zzatkVar);
    }

    private final void zza(zzdzw<InputStream> zzdzwVar, zzatk zzatkVar) {
        zzdzk.zza(zzdzk.zzb(zzdzwVar, new zzdyu(this) { // from class: com.google.android.gms.internal.ads.zzcov
            private final zzcol zzgpq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgpq = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return zzdzk.zzag(zzdoi.zze((InputStream) obj));
            }
        }, zzazp.zzeic), new zzcox(this, zzatkVar), zzazp.zzeih);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zza(zzdzw zzdzwVar, zzdzw zzdzwVar2) throws Exception {
        String zzwr = ((zzatw) zzdzwVar.get()).zzwr();
        this.zzgpo.put(zzwr, new zzcpa((zzatw) zzdzwVar.get(), (JSONObject) zzdzwVar2.get()));
        return new ByteArrayInputStream(zzwr.getBytes(zzdvx.UTF_8));
    }

    @Override // com.google.android.gms.internal.ads.zzath
    public final void zzb(zzatq zzatqVar, zzatk zzatkVar) {
        zza(zzd(zzatqVar, Binder.getCallingUid()), zzatkVar);
    }
}
