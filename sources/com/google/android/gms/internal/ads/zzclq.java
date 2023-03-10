package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzclq {
    private final Executor executor;
    private final zzazn zzboz;
    private final Context zzcmf;
    private final Executor zzfsj;
    private final ScheduledExecutorService zzfth;
    private final WeakReference<Context> zzgmv;
    private final zzcin zzgmw;
    private final zzcla zzgmx;
    private final zzbxg zzgmz;
    private boolean zzgmr = false;
    @GuardedBy("this")
    private boolean zzgms = false;
    private final zzbaa<Boolean> zzgmu = new zzbaa<>();
    private Map<String, zzajh> zzgmy = new ConcurrentHashMap();
    private boolean enabled = true;
    private final long zzgmt = com.google.android.gms.ads.internal.zzr.zzky().a();

    public zzclq(Executor executor, Context context, WeakReference<Context> weakReference, Executor executor2, zzcin zzcinVar, ScheduledExecutorService scheduledExecutorService, zzcla zzclaVar, zzazn zzaznVar, zzbxg zzbxgVar) {
        this.zzgmw = zzcinVar;
        this.zzcmf = context;
        this.zzgmv = weakReference;
        this.executor = executor2;
        this.zzfth = scheduledExecutorService;
        this.zzfsj = executor;
        this.zzgmx = zzclaVar;
        this.zzboz = zzaznVar;
        this.zzgmz = zzbxgVar;
        zza("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(String str, boolean z, String str2, int i2) {
        this.zzgmy.put(str, new zzajh(str, z, i2, str2));
    }

    private final synchronized zzdzw<String> zzard() {
        String zzxy = com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzyn().zzxy();
        if (!TextUtils.isEmpty(zzxy)) {
            return zzdzk.zzag(zzxy);
        }
        final zzbaa zzbaaVar = new zzbaa();
        com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzb(new Runnable(this, zzbaaVar) { // from class: com.google.android.gms.internal.ads.zzclr
            private final zzclq zzgmp;
            private final zzbaa zzgna;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgmp = this;
                this.zzgna = zzbaaVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgmp.zza(this.zzgna);
            }
        });
        return zzbaaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzgh(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                final String next = keys.next();
                final Object obj = new Object();
                final zzbaa zzbaaVar = new zzbaa();
                zzdzw zza = zzdzk.zza(zzbaaVar, ((Long) zzwr.zzqr().zzd(zzabp.zzcrk)).longValue(), TimeUnit.SECONDS, this.zzfth);
                this.zzgmx.zzgf(next);
                this.zzgmz.zzft(next);
                final long a = com.google.android.gms.ads.internal.zzr.zzky().a();
                Iterator<String> it = keys;
                zza.addListener(new Runnable(this, obj, zzbaaVar, next, a) { // from class: com.google.android.gms.internal.ads.zzclt
                    private final Object zzdlk;
                    private final String zzgkt;
                    private final zzclq zzgmp;
                    private final zzbaa zzgnb;
                    private final long zzgnc;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgmp = this;
                        this.zzdlk = obj;
                        this.zzgnb = zzbaaVar;
                        this.zzgkt = next;
                        this.zzgnc = a;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzgmp.zza(this.zzdlk, this.zzgnb, this.zzgkt, this.zzgnc);
                    }
                }, this.executor);
                arrayList.add(zza);
                final zzclz zzclzVar = new zzclz(this, obj, next, a, zzbaaVar);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                final ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            String optString = jSONObject2.optString(IjkMediaMeta.IJKM_KEY_FORMAT, "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                }
                            }
                            arrayList2.add(new zzajr(optString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                zza(next, false, "", 0);
                try {
                    try {
                        final zzdog zzd = this.zzgmw.zzd(next, new JSONObject());
                        this.zzfsj.execute(new Runnable(this, zzd, zzclzVar, arrayList2, next) { // from class: com.google.android.gms.internal.ads.zzclv
                            private final String zzesf;
                            private final zzclq zzgmp;
                            private final zzdog zzgnd;
                            private final zzajj zzgne;
                            private final List zzgnf;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.zzgmp = this;
                                this.zzgnd = zzd;
                                this.zzgne = zzclzVar;
                                this.zzgnf = arrayList2;
                                this.zzesf = next;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zzgmp.zza(this.zzgnd, this.zzgne, this.zzgnf, this.zzesf);
                            }
                        });
                    } catch (zzdnt unused2) {
                        zzclzVar.onInitializationFailed("Failed to create Adapter.");
                    }
                } catch (RemoteException e2) {
                    zzazk.zzc("", e2);
                }
                keys = it;
            }
            zzdzk.zzj(arrayList).zzb(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzclw
                private final zzclq zzgmp;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgmp = this;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzgmp.zzare();
                }
            }, this.executor);
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.util.zzd.zza("Malformed CLD response", e3);
        }
    }

    public final void disable() {
        this.enabled = false;
    }

    public final void zzarb() {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcri)).booleanValue() && !zzadn.zzdeg.get().booleanValue()) {
            if (this.zzboz.zzehz >= ((Integer) zzwr.zzqr().zzd(zzabp.zzcrj)).intValue() && this.enabled) {
                if (this.zzgmr) {
                    return;
                }
                synchronized (this) {
                    if (this.zzgmr) {
                        return;
                    }
                    this.zzgmx.zzaqy();
                    this.zzgmz.zzamm();
                    this.zzgmu.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcls
                        private final zzclq zzgmp;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzgmp = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzgmp.zzarg();
                        }
                    }, this.executor);
                    this.zzgmr = true;
                    zzdzw<String> zzard = zzard();
                    this.zzfth.schedule(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzclu
                        private final zzclq zzgmp;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzgmp = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzgmp.zzarf();
                        }
                    }, ((Long) zzwr.zzqr().zzd(zzabp.zzcrl)).longValue(), TimeUnit.SECONDS);
                    zzdzk.zza(zzard, new zzclx(this), this.executor);
                    return;
                }
            }
        }
        if (this.zzgmr) {
            return;
        }
        zza("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.zzgmu.set(Boolean.FALSE);
        this.zzgmr = true;
    }

    public final List<zzajh> zzarc() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzgmy.keySet()) {
            zzajh zzajhVar = this.zzgmy.get(str);
            arrayList.add(new zzajh(str, zzajhVar.zzdiu, zzajhVar.zzdiv, zzajhVar.description));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object zzare() throws Exception {
        this.zzgmu.set(Boolean.TRUE);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzarf() {
        synchronized (this) {
            if (this.zzgms) {
                return;
            }
            zza("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzr.zzky().a() - this.zzgmt));
            this.zzgmu.setException(new Exception());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzarg() {
        this.zzgmx.zzaqz();
        this.zzgmz.zzamn();
    }

    public final void zzb(final zzajk zzajkVar) {
        this.zzgmu.addListener(new Runnable(this, zzajkVar) { // from class: com.google.android.gms.internal.ads.zzclp
            private final zzclq zzgmp;
            private final zzajk zzgmq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgmp = this;
                this.zzgmq = zzajkVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgmp.zzc(this.zzgmq);
            }
        }, this.zzfsj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzajk zzajkVar) {
        try {
            zzajkVar.zze(zzarc());
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzdog zzdogVar, zzajj zzajjVar, List list, String str) {
        try {
            try {
                Context context = this.zzgmv.get();
                if (context == null) {
                    context = this.zzcmf;
                }
                zzdogVar.zza(context, zzajjVar, list);
            } catch (zzdnt unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74);
                sb.append("Failed to initialize adapter. ");
                sb.append(str);
                sb.append(" does not implement the initialize() method.");
                zzajjVar.onInitializationFailed(sb.toString());
            }
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzbaa zzbaaVar, String str, long j2) {
        synchronized (obj) {
            if (!zzbaaVar.isDone()) {
                zza(str, false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzr.zzky().a() - j2));
                this.zzgmx.zzs(str, "timeout");
                this.zzgmz.zzm(str, "timeout");
                zzbaaVar.set(Boolean.FALSE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(final zzbaa zzbaaVar) {
        this.executor.execute(new Runnable(this, zzbaaVar) { // from class: com.google.android.gms.internal.ads.zzcly
            private final zzclq zzgmp;
            private final zzbaa zzgna;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgmp = this;
                this.zzgna = zzbaaVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbaa zzbaaVar2 = this.zzgna;
                String zzxy = com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzyn().zzxy();
                if (!TextUtils.isEmpty(zzxy)) {
                    zzbaaVar2.set(zzxy);
                } else {
                    zzbaaVar2.setException(new Exception());
                }
            }
        });
    }
}
