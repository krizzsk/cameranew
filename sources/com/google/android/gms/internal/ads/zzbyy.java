package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbyy extends zzbnt {
    private final Context context;
    private final zzcag zzfui;
    private boolean zzfuj;
    private final WeakReference<zzbeb> zzgbe;
    private final zzbxo zzgbf;
    private final zzboq zzgbg;
    private final zzdtm zzgbh;
    private final zzbrt zzgbi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbyy(zzbnw zzbnwVar, Context context, @Nullable zzbeb zzbebVar, zzbxo zzbxoVar, zzcag zzcagVar, zzboq zzboqVar, zzdtm zzdtmVar, zzbrt zzbrtVar) {
        super(zzbnwVar);
        this.zzfuj = false;
        this.context = context;
        this.zzgbe = new WeakReference<>(zzbebVar);
        this.zzgbf = zzbxoVar;
        this.zzfui = zzcagVar;
        this.zzgbg = zzboqVar;
        this.zzgbh = zzdtmVar;
        this.zzgbi = zzbrtVar;
    }

    public final void finalize() throws Throwable {
        try {
            zzbeb zzbebVar = this.zzgbe.get();
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcyw)).booleanValue()) {
                if (!this.zzfuj && zzbebVar != null) {
                    zzdzv zzdzvVar = zzazp.zzeig;
                    zzbebVar.getClass();
                    zzdzvVar.execute(zzbyx.zze(zzbebVar));
                }
            } else if (zzbebVar != null) {
                zzbebVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean isClosed() {
        return this.zzgbg.isClosed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.content.Context] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzb(boolean r5, @javax.annotation.Nullable android.app.Activity r6) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzaba<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabp.zzcov
            com.google.android.gms.internal.ads.zzabl r1 = com.google.android.gms.internal.ads.zzwr.zzqr()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L49
            com.google.android.gms.ads.internal.zzr.zzkr()
            android.content.Context r0 = r4.context
            boolean r0 = com.google.android.gms.ads.internal.util.zzj.zzaq(r0)
            if (r0 == 0) goto L49
            java.lang.String r0 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.internal.ads.zzazk.zzex(r0)
            com.google.android.gms.internal.ads.zzbrt r0 = r4.zzgbi
            r0.zzalp()
            com.google.android.gms.internal.ads.zzaba<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabp.zzcow
            com.google.android.gms.internal.ads.zzabl r3 = com.google.android.gms.internal.ads.zzwr.zzqr()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L4f
            com.google.android.gms.internal.ads.zzdtm r0 = r4.zzgbh
            com.google.android.gms.internal.ads.zzdnl r3 = r4.zzfrd
            com.google.android.gms.internal.ads.zzdnj r3 = r3.zzhks
            com.google.android.gms.internal.ads.zzdnb r3 = r3.zzess
            java.lang.String r3 = r3.zzbvs
            r0.zzhf(r3)
            goto L4f
        L49:
            boolean r0 = r4.zzfuj
            if (r0 != 0) goto L4f
            r0 = 1
            goto L50
        L4f:
            r0 = 0
        L50:
            if (r0 != 0) goto L53
            return r2
        L53:
            com.google.android.gms.internal.ads.zzbxo r0 = r4.zzgbf
            r0.zzalf()
            if (r6 != 0) goto L5c
            android.content.Context r6 = r4.context
        L5c:
            com.google.android.gms.internal.ads.zzcag r0 = r4.zzfui     // Catch: com.google.android.gms.internal.ads.zzcaf -> L69
            r0.zza(r5, r6)     // Catch: com.google.android.gms.internal.ads.zzcaf -> L69
            com.google.android.gms.internal.ads.zzbxo r5 = r4.zzgbf     // Catch: com.google.android.gms.internal.ads.zzcaf -> L69
            r5.zzald()     // Catch: com.google.android.gms.internal.ads.zzcaf -> L69
            r4.zzfuj = r1
            return r1
        L69:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzbrt r6 = r4.zzgbi
            r6.zza(r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbyy.zzb(boolean, android.app.Activity):boolean");
    }
}
