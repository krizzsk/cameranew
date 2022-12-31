package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzblq extends zzbnt {
    private final Context context;
    @Nullable
    private final zzbeb zzdjd;
    private final int zzfto;
    private final zzbkv zzfud;
    private final zzcag zzfui;
    private boolean zzfuj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzblq(zzbnw zzbnwVar, Context context, @Nullable zzbeb zzbebVar, int i2, zzbkv zzbkvVar, zzcag zzcagVar) {
        super(zzbnwVar);
        this.zzfuj = false;
        this.zzdjd = zzbebVar;
        this.context = context;
        this.zzfto = i2;
        this.zzfud = zzbkvVar;
        this.zzfui = zzcagVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnt
    public final void destroy() {
        super.destroy();
        zzbeb zzbebVar = this.zzdjd;
        if (zzbebVar != null) {
            zzbebVar.destroy();
        }
    }

    public final void zza(zzsh zzshVar) {
        zzbeb zzbebVar = this.zzdjd;
        if (zzbebVar != null) {
            zzbebVar.zza(zzshVar);
        }
    }

    public final int zzajh() {
        return this.zzfto;
    }

    public final void zzb(long j2, int i2) {
        this.zzfud.zzb(j2, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r6 = r6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.content.Context] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(android.app.Activity r6, com.google.android.gms.internal.ads.zzsv r7, boolean r8) throws android.os.RemoteException {
        /*
            r5 = this;
            if (r6 != 0) goto L4
            android.content.Context r6 = r5.context
        L4:
            com.google.android.gms.internal.ads.zzaba<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabp.zzcov
            com.google.android.gms.internal.ads.zzabl r1 = com.google.android.gms.internal.ads.zzwr.zzqr()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L5f
            com.google.android.gms.ads.internal.zzr.zzkr()
            boolean r0 = com.google.android.gms.ads.internal.util.zzj.zzaq(r6)
            if (r0 == 0) goto L5f
            java.lang.String r0 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.internal.ads.zzazk.zzex(r0)
            com.google.android.gms.internal.ads.zzdom r0 = com.google.android.gms.internal.ads.zzdom.APP_NOT_FOREGROUND
            r3 = 0
            com.google.android.gms.internal.ads.zzvg r0 = com.google.android.gms.internal.ads.zzdok.zza(r0, r3, r3)
            r7.zzb(r0)
            com.google.android.gms.internal.ads.zzaba<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabp.zzcow
            com.google.android.gms.internal.ads.zzabl r3 = com.google.android.gms.internal.ads.zzwr.zzqr()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L6d
            com.google.android.gms.internal.ads.zzdtm r0 = new com.google.android.gms.internal.ads.zzdtm
            android.content.Context r3 = r6.getApplicationContext()
            com.google.android.gms.ads.internal.util.zzbl r4 = com.google.android.gms.ads.internal.zzr.zzlf()
            android.os.Looper r4 = r4.zzzp()
            r0.<init>(r3, r4)
            com.google.android.gms.internal.ads.zzdnl r3 = r5.zzfrd
            com.google.android.gms.internal.ads.zzdnj r3 = r3.zzhks
            com.google.android.gms.internal.ads.zzdnb r3 = r3.zzess
            java.lang.String r3 = r3.zzbvs
            r0.zzhf(r3)
            goto L6d
        L5f:
            boolean r0 = r5.zzfuj
            if (r0 == 0) goto L68
            java.lang.String r0 = "App open interstitial ad is already visible."
            com.google.android.gms.internal.ads.zzazk.zzex(r0)
        L68:
            boolean r0 = r5.zzfuj
            if (r0 != 0) goto L6d
            r2 = 1
        L6d:
            if (r2 != 0) goto L70
            return
        L70:
            com.google.android.gms.internal.ads.zzcag r0 = r5.zzfui     // Catch: com.google.android.gms.internal.ads.zzcaf -> L78
            r0.zza(r8, r6)     // Catch: com.google.android.gms.internal.ads.zzcaf -> L78
            r5.zzfuj = r1
            return
        L78:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzvg r6 = com.google.android.gms.internal.ads.zzdok.zzh(r6)
            r7.zzb(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzblq.zza(android.app.Activity, com.google.android.gms.internal.ads.zzsv, boolean):void");
    }
}
