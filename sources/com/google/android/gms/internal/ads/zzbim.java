package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbim extends zzyf {
    private final Context context;
    private final zzazn zzbpn;
    private final zzaxc zzbqv;
    private final zzcin zzfqj;
    private final zzcro<zzdog, zzctg> zzfqk;
    private final zzcxj zzfql;
    private final zzclq zzfqm;
    private final zzcip zzfqn;
    @GuardedBy("this")
    private boolean zzzl = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbim(Context context, zzazn zzaznVar, zzcin zzcinVar, zzcro<zzdog, zzctg> zzcroVar, zzcxj zzcxjVar, zzclq zzclqVar, zzaxc zzaxcVar, zzcip zzcipVar) {
        this.context = context;
        this.zzbpn = zzaznVar;
        this.zzfqj = zzcinVar;
        this.zzfqk = zzcroVar;
        this.zzfql = zzcxjVar;
        this.zzfqm = zzclqVar;
        this.zzbqv = zzaxcVar;
        this.zzfqn = zzcipVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final String getVersionString() {
        return this.zzbpn.zzbrp;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final synchronized void initialize() {
        if (this.zzzl) {
            zzazk.zzex("Mobile ads is initialized already.");
            return;
        }
        zzabp.initialize(this.context);
        com.google.android.gms.ads.internal.zzr.zzkv().zzd(this.context, this.zzbpn);
        com.google.android.gms.ads.internal.zzr.zzkx().initialize(this.context);
        this.zzzl = true;
        this.zzfqm.zzarb();
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcra)).booleanValue()) {
            this.zzfql.zzapw();
        }
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzctt)).booleanValue()) {
            this.zzfqn.zzapw();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final synchronized void setAppMuted(boolean z) {
        com.google.android.gms.ads.internal.zzr.zzkw().setAppMuted(z);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final synchronized void setAppVolume(float f2) {
        com.google.android.gms.ads.internal.zzr.zzkw().setAppVolume(f2);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zza(@Nullable String str, b bVar) {
        String str2;
        zzabp.initialize(this.context);
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzctv)).booleanValue()) {
            com.google.android.gms.ads.internal.zzr.zzkr();
            str2 = com.google.android.gms.ads.internal.util.zzj.zzay(this.context);
        } else {
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean booleanValue = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcts)).booleanValue();
        zzaba<Boolean> zzabaVar = zzabp.zzcph;
        boolean booleanValue2 = booleanValue | ((Boolean) zzwr.zzqr().zzd(zzabaVar)).booleanValue();
        Runnable runnable = null;
        if (((Boolean) zzwr.zzqr().zzd(zzabaVar)).booleanValue()) {
            booleanValue2 = true;
            final Runnable runnable2 = (Runnable) d.y0(bVar);
            runnable = new Runnable(this, runnable2) { // from class: com.google.android.gms.internal.ads.zzbil
                private final zzbim zzfqh;
                private final Runnable zzfqi;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfqh = this;
                    this.zzfqi = runnable2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    final zzbim zzbimVar = this.zzfqh;
                    final Runnable runnable3 = this.zzfqi;
                    zzazp.zzeig.execute(new Runnable(zzbimVar, runnable3) { // from class: com.google.android.gms.internal.ads.zzbio
                        private final zzbim zzfqh;
                        private final Runnable zzfqi;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzfqh = zzbimVar;
                            this.zzfqi = runnable3;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzfqh.zzd(this.zzfqi);
                        }
                    });
                }
            };
        }
        if (booleanValue2) {
            com.google.android.gms.ads.internal.zzr.zzkz().zza(this.context, this.zzbpn, str, runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zzb(b bVar, String str) {
        if (bVar == null) {
            zzazk.zzev("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) d.y0(bVar);
        if (context == null) {
            zzazk.zzev("Context is null. Failed to open debug menu.");
            return;
        }
        com.google.android.gms.ads.internal.util.zzad zzadVar = new com.google.android.gms.ads.internal.util.zzad(context);
        zzadVar.setAdUnitId(str);
        zzadVar.zzu(this.zzbpn.zzbrp);
        zzadVar.showDialog();
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final synchronized void zzcd(String str) {
        zzabp.initialize(this.context);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcts)).booleanValue()) {
                com.google.android.gms.ads.internal.zzr.zzkz().zza(this.context, this.zzbpn, str, (Runnable) null);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zzce(String str) {
        this.zzfql.zzgp(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Runnable runnable) {
        q.e("Adapters must be initialized on the main thread.");
        Map<String, zzand> zzya = com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzyn().zzya();
        if (zzya == null || zzya.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzazk.zzd("Could not initialize rewarded ads.", th);
                return;
            }
        }
        if (this.zzfqj.zzapt()) {
            HashMap hashMap = new HashMap();
            for (zzand zzandVar : zzya.values()) {
                for (zzana zzanaVar : zzandVar.zzdmo) {
                    String str = zzanaVar.zzdmb;
                    for (String str2 : zzanaVar.zzdlt) {
                        if (!hashMap.containsKey(str2)) {
                            hashMap.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((Collection) hashMap.get(str2)).add(str);
                        }
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : hashMap.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzcrl<zzdog, zzctg> zzf = this.zzfqk.zzf(str3, jSONObject);
                    if (zzf != null) {
                        zzdog zzdogVar = zzf.zzdnl;
                        if (!zzdogVar.isInitialized() && zzdogVar.zzuz()) {
                            zzdogVar.zza(this.context, zzf.zzgsu, (List) entry.getValue());
                            String valueOf = String.valueOf(str3);
                            zzazk.zzdy(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                        }
                    }
                } catch (zzdnt e2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 56);
                    sb.append("Failed to initialize rewarded video mediation adapter \"");
                    sb.append(str3);
                    sb.append("\"");
                    zzazk.zzd(sb.toString(), e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final synchronized float zzra() {
        return com.google.android.gms.ads.internal.zzr.zzkw().zzra();
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final synchronized boolean zzrb() {
        return com.google.android.gms.ads.internal.zzr.zzkw().zzrb();
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final List<zzajh> zzrc() throws RemoteException {
        return this.zzfqm.zzarc();
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zzrd() {
        this.zzfqm.disable();
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zza(zzane zzaneVar) throws RemoteException {
        this.zzfqj.zzb(zzaneVar);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zza(zzajk zzajkVar) throws RemoteException {
        this.zzfqm.zzb(zzajkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zza(zzaao zzaaoVar) throws RemoteException {
        this.zzbqv.zza(this.context, zzaaoVar);
    }
}
