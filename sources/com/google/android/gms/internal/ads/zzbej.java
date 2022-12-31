package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzbej {
    public static zzdzw<zzbeb> zza(final Context context, final zzazn zzaznVar, final String str, final zzei zzeiVar, final com.google.android.gms.ads.internal.zzb zzbVar) {
        return zzdzk.zzb(zzdzk.zzag(null), new zzdyu(context, zzeiVar, zzaznVar, zzbVar, str) { // from class: com.google.android.gms.internal.ads.zzbem
            private final Context zzcmi;
            private final zzei zzdjl;
            private final zzazn zzesd;
            private final com.google.android.gms.ads.internal.zzb zzese;
            private final String zzesf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcmi = context;
                this.zzdjl = zzeiVar;
                this.zzesd = zzaznVar;
                this.zzese = zzbVar;
                this.zzesf = str;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                Context context2 = this.zzcmi;
                zzei zzeiVar2 = this.zzdjl;
                zzazn zzaznVar2 = this.zzesd;
                com.google.android.gms.ads.internal.zzb zzbVar2 = this.zzese;
                String str2 = this.zzesf;
                com.google.android.gms.ads.internal.zzr.zzks();
                zzbeb zza = zzbej.zza(context2, zzbft.zzael(), "", false, false, zzeiVar2, null, zzaznVar2, null, null, zzbVar2, zztu.zznf(), null, null);
                final zzazx zzk = zzazx.zzk(zza);
                zza.zzacx().zza(new zzbfq(zzk) { // from class: com.google.android.gms.internal.ads.zzbeo
                    private final zzazx zzesg;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzesg = zzk;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbfq
                    public final void zzal(boolean z) {
                        this.zzesg.zzaac();
                    }
                });
                zza.loadUrl(str2);
                return zzk;
            }
        }, zzazp.zzeig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ zzbeb zzb(Context context, zzbft zzbftVar, String str, boolean z, boolean z2, zzei zzeiVar, zzacq zzacqVar, zzazn zzaznVar, zzacc zzaccVar, com.google.android.gms.ads.internal.zzm zzmVar, com.google.android.gms.ads.internal.zzb zzbVar, zztu zztuVar, zzdmw zzdmwVar, zzdnb zzdnbVar) {
        try {
            TrafficStats.setThreadStatsTag(264);
            zzbeq zzbeqVar = new zzbeq(zzber.zzc(context, zzbftVar, str, z, z2, zzeiVar, zzacqVar, zzaznVar, zzaccVar, zzmVar, zzbVar, zztuVar, zzdmwVar, zzdnbVar));
            zzbeqVar.setWebViewClient(com.google.android.gms.ads.internal.zzr.zzkt().zza(zzbeqVar, zztuVar, z2));
            zzbeqVar.setWebChromeClient(new zzbdt(zzbeqVar));
            return zzbeqVar;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }

    public static zzbeb zza(final Context context, final zzbft zzbftVar, final String str, final boolean z, final boolean z2, @Nullable final zzei zzeiVar, final zzacq zzacqVar, final zzazn zzaznVar, zzacc zzaccVar, final com.google.android.gms.ads.internal.zzm zzmVar, final com.google.android.gms.ads.internal.zzb zzbVar, final zztu zztuVar, final zzdmw zzdmwVar, final zzdnb zzdnbVar) throws zzben {
        zzabp.initialize(context);
        try {
            return (zzbeb) com.google.android.gms.ads.internal.util.zzbr.zza(new zzdws(context, zzbftVar, str, z, z2, zzeiVar, zzacqVar, zzaznVar, null, zzmVar, zzbVar, zztuVar, zzdmwVar, zzdnbVar) { // from class: com.google.android.gms.internal.ads.zzbel
                private final Context zzcmi;
                private final String zzdlo;
                private final zzbft zzerr;
                private final boolean zzers;
                private final boolean zzert;
                private final zzei zzeru;
                private final zzacq zzerv;
                private final zzazn zzerw;
                private final zzacc zzerx = null;
                private final com.google.android.gms.ads.internal.zzm zzery;
                private final com.google.android.gms.ads.internal.zzb zzerz;
                private final zztu zzesa;
                private final zzdmw zzesb;
                private final zzdnb zzesc;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzcmi = context;
                    this.zzerr = zzbftVar;
                    this.zzdlo = str;
                    this.zzers = z;
                    this.zzert = z2;
                    this.zzeru = zzeiVar;
                    this.zzerv = zzacqVar;
                    this.zzerw = zzaznVar;
                    this.zzery = zzmVar;
                    this.zzerz = zzbVar;
                    this.zzesa = zztuVar;
                    this.zzesb = zzdmwVar;
                    this.zzesc = zzdnbVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdws
                public final Object get() {
                    return zzbej.zzb(this.zzcmi, this.zzerr, this.zzdlo, this.zzers, this.zzert, this.zzeru, this.zzerv, this.zzerw, null, this.zzery, this.zzerz, this.zzesa, this.zzesb, this.zzesc);
                }
            });
        } catch (Throwable th) {
            throw new zzben("Webview initialization failed.", th);
        }
    }
}
