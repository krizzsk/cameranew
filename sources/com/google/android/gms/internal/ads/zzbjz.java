package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbjz implements com.google.android.gms.ads.internal.overlay.zzq, zzbse, zzbsh, zzqw {
    private final Clock zzbqg;
    private final zzbju zzfsf;
    private final zzbjx zzfsg;
    private final zzamv<JSONObject, JSONObject> zzfsi;
    private final Executor zzfsj;
    private final Set<zzbeb> zzfsh = new HashSet();
    private final AtomicBoolean zzfsk = new AtomicBoolean(false);
    @GuardedBy("this")
    private final zzbkb zzfsl = new zzbkb();
    private boolean zzfsm = false;
    private WeakReference<?> zzfsn = new WeakReference<>(this);

    public zzbjz(zzamo zzamoVar, zzbjx zzbjxVar, Executor executor, zzbju zzbjuVar, Clock clock) {
        this.zzfsf = zzbjuVar;
        zzamf<JSONObject> zzamfVar = zzame.zzdks;
        this.zzfsi = zzamoVar.zzb("google.afma.activeView.handleUpdate", zzamfVar, zzamfVar);
        this.zzfsg = zzbjxVar;
        this.zzfsj = executor;
        this.zzbqg = clock;
    }

    private final void zzaiz() {
        for (zzbeb zzbebVar : this.zzfsh) {
            this.zzfsf.zzb(zzbebVar);
        }
        this.zzfsf.zzaix();
    }

    @Override // com.google.android.gms.internal.ads.zzbse
    public final synchronized void onAdImpression() {
        if (this.zzfsk.compareAndSet(false, true)) {
            this.zzfsf.zza(this);
            zzaiy();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final synchronized void onPause() {
        this.zzfsl.zzfsp = true;
        zzaiy();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final synchronized void onResume() {
        this.zzfsl.zzfsp = false;
        zzaiy();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onUserLeaveHint() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void zza(com.google.android.gms.ads.internal.overlay.zzn zznVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final synchronized void zza(zzqx zzqxVar) {
        zzbkb zzbkbVar = this.zzfsl;
        zzbkbVar.zzbrj = zzqxVar.zzbrj;
        zzbkbVar.zzfss = zzqxVar;
        zzaiy();
    }

    public final synchronized void zzaiy() {
        if (!(this.zzfsn.get() != null)) {
            zzaja();
            return;
        }
        if (!this.zzfsm && this.zzfsk.get()) {
            try {
                this.zzfsl.timestamp = this.zzbqg.a();
                final JSONObject zzi = this.zzfsg.zzi(this.zzfsl);
                for (final zzbeb zzbebVar : this.zzfsh) {
                    this.zzfsj.execute(new Runnable(zzbebVar, zzi) { // from class: com.google.android.gms.internal.ads.zzbkc
                        private final zzbeb zzeuk;
                        private final JSONObject zzfst;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzeuk = zzbebVar;
                            this.zzfst = zzi;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzeuk.zzb("AFMA_updateActiveView", this.zzfst);
                        }
                    });
                }
                zzazw.zzb(this.zzfsi.zzf(zzi), "ActiveViewListener.callActiveViewJs");
            } catch (Exception e2) {
                com.google.android.gms.ads.internal.util.zzd.zza("Failed to call ActiveViewJS", e2);
            }
        }
    }

    public final synchronized void zzaja() {
        zzaiz();
        this.zzfsm = true;
    }

    public final synchronized void zzc(zzbeb zzbebVar) {
        this.zzfsh.add(zzbebVar);
        this.zzfsf.zza(zzbebVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbsh
    public final synchronized void zzcb(@Nullable Context context) {
        this.zzfsl.zzfsp = true;
        zzaiy();
    }

    @Override // com.google.android.gms.internal.ads.zzbsh
    public final synchronized void zzcc(@Nullable Context context) {
        this.zzfsl.zzfsp = false;
        zzaiy();
    }

    @Override // com.google.android.gms.internal.ads.zzbsh
    public final synchronized void zzcd(@Nullable Context context) {
        this.zzfsl.zzfsr = "u";
        zzaiy();
        zzaiz();
        this.zzfsm = true;
    }

    public final void zzn(Object obj) {
        this.zzfsn = new WeakReference<>(obj);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void zzvo() {
    }
}
