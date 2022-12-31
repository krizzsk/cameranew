package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzcnd implements zzdzl<zzdnl> {
    private final /* synthetic */ zzcnc zzgoj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcnd(zzcnc zzcncVar) {
        this.zzgoj = zzcncVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(zzdnl zzdnlVar) {
        zzcqb zzcqbVar;
        zzcqb zzcqbVar2;
        zzdnl zzdnlVar2 = zzdnlVar;
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcxy)).booleanValue()) {
            zzcqbVar = this.zzgoj.zzgoh;
            zzcqbVar.zzea(zzdnlVar2.zzhks.zzess.responseCode);
            zzcqbVar2 = this.zzgoj.zzgoh;
            zzcqbVar2.zzeq(zzdnlVar2.zzhks.zzess.zzgqe);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        Pattern pattern;
        zzcqb zzcqbVar;
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcxy)).booleanValue()) {
            pattern = zzcnc.zzgoi;
            Matcher matcher = pattern.matcher(th.getMessage());
            if (matcher.matches()) {
                String group = matcher.group(1);
                zzcqbVar = this.zzgoj.zzgoh;
                zzcqbVar.zzea(Integer.parseInt(group));
            }
        }
    }
}
