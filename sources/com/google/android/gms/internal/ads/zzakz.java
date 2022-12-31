package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzakz {
    private final Context context;
    private final Object lock;
    private int status;
    private final zzazn zzbpn;
    private final String zzdjn;
    private com.google.android.gms.ads.internal.util.zzar<zzakm> zzdjo;
    private com.google.android.gms.ads.internal.util.zzar<zzakm> zzdjp;
    @Nullable
    private zzalq zzdjq;

    private zzakz(Context context, zzazn zzaznVar, String str) {
        this.lock = new Object();
        this.status = 1;
        this.zzdjn = str;
        this.context = context.getApplicationContext();
        this.zzbpn = zzaznVar;
        this.zzdjo = new zzaln();
        this.zzdjp = new zzaln();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzalq zza(@Nullable final zzei zzeiVar) {
        final zzalq zzalqVar = new zzalq(this.zzdjp);
        zzazp.zzeig.execute(new Runnable(this, zzeiVar, zzalqVar) { // from class: com.google.android.gms.internal.ads.zzaky
            private final zzakz zzdjk;
            private final zzei zzdjl;
            private final zzalq zzdjm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdjk = this;
                this.zzdjl = zzeiVar;
                this.zzdjm = zzalqVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdjk.zza(this.zzdjl, this.zzdjm);
            }
        });
        zzalqVar.zza(new zzali(this, zzalqVar), new zzall(this, zzalqVar));
        return zzalqVar;
    }

    public final zzalm zzb(@Nullable zzei zzeiVar) {
        synchronized (this.lock) {
            synchronized (this.lock) {
                zzalq zzalqVar = this.zzdjq;
                if (zzalqVar != null && this.status == 0) {
                    zzalqVar.zza(new zzbae(this) { // from class: com.google.android.gms.internal.ads.zzalb
                        private final zzakz zzdjk;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzdjk = this;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbae
                        public final void zzg(Object obj) {
                            this.zzdjk.zza((zzakm) obj);
                        }
                    }, zzala.zzdjr);
                }
            }
            zzalq zzalqVar2 = this.zzdjq;
            if (zzalqVar2 != null && zzalqVar2.getStatus() != -1) {
                int i2 = this.status;
                if (i2 == 0) {
                    return this.zzdjq.zzum();
                } else if (i2 == 1) {
                    this.status = 2;
                    zza((zzei) null);
                    return this.zzdjq.zzum();
                } else if (i2 == 2) {
                    return this.zzdjq.zzum();
                } else {
                    return this.zzdjq.zzum();
                }
            }
            this.status = 2;
            zzalq zza = zza((zzei) null);
            this.zzdjq = zza;
            return zza.zzum();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzakm zzakmVar) {
        if (zzakmVar.isDestroyed()) {
            this.status = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzei zzeiVar, final zzalq zzalqVar) {
        try {
            final zzako zzakoVar = new zzako(this.context, this.zzbpn, zzeiVar, null);
            zzakoVar.zza(new zzakp(this, zzalqVar, zzakoVar) { // from class: com.google.android.gms.internal.ads.zzald
                private final zzakz zzdjk;
                private final zzalq zzdjs;
                private final zzakm zzdjt;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdjk = this;
                    this.zzdjs = zzalqVar;
                    this.zzdjt = zzakoVar;
                }

                @Override // com.google.android.gms.internal.ads.zzakp
                public final void zzuk() {
                    com.google.android.gms.ads.internal.util.zzj.zzeen.postDelayed(new Runnable(this.zzdjk, this.zzdjs, this.zzdjt) { // from class: com.google.android.gms.internal.ads.zzalc
                        private final zzakz zzdjk;
                        private final zzalq zzdjs;
                        private final zzakm zzdjt;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzdjk = r1;
                            this.zzdjs = r2;
                            this.zzdjt = r3;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzdjk.zza(this.zzdjs, this.zzdjt);
                        }
                    }, zzalk.zzdkc);
                }
            });
            zzakoVar.zza("/jsLoaded", new zzale(this, zzalqVar, zzakoVar));
            com.google.android.gms.ads.internal.util.zzbs zzbsVar = new com.google.android.gms.ads.internal.util.zzbs();
            zzalh zzalhVar = new zzalh(this, zzeiVar, zzakoVar, zzbsVar);
            zzbsVar.set(zzalhVar);
            zzakoVar.zza("/requestReload", zzalhVar);
            if (this.zzdjn.endsWith(".js")) {
                zzakoVar.zzcw(this.zzdjn);
            } else if (this.zzdjn.startsWith("<html>")) {
                zzakoVar.zzcy(this.zzdjn);
            } else {
                zzakoVar.zzcx(this.zzdjn);
            }
            com.google.android.gms.ads.internal.util.zzj.zzeen.postDelayed(new zzalg(this, zzalqVar, zzakoVar), zzalk.zzdkb);
        } catch (Throwable th) {
            zzazk.zzc("Error creating webview.", th);
            com.google.android.gms.ads.internal.zzr.zzkv().zza(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzalqVar.reject();
        }
    }

    public zzakz(Context context, zzazn zzaznVar, String str, com.google.android.gms.ads.internal.util.zzar<zzakm> zzarVar, com.google.android.gms.ads.internal.util.zzar<zzakm> zzarVar2) {
        this(context, zzaznVar, str);
        this.zzdjo = zzarVar;
        this.zzdjp = zzarVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzalq zzalqVar, zzakm zzakmVar) {
        synchronized (this.lock) {
            if (zzalqVar.getStatus() != -1 && zzalqVar.getStatus() != 1) {
                zzalqVar.reject();
                zzdzv zzdzvVar = zzazp.zzeig;
                zzakmVar.getClass();
                zzdzvVar.execute(zzalf.zzb(zzakmVar));
                com.google.android.gms.ads.internal.util.zzd.zzeb("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}
