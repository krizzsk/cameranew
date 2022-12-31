package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcuv implements zzdzl<T> {
    private final /* synthetic */ zzdnb zzgjc;
    private final /* synthetic */ long zzgvc;
    private final /* synthetic */ String zzgvd;
    private final /* synthetic */ zzdmw zzgve;
    private final /* synthetic */ zzcuw zzgvf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcuv(zzcuw zzcuwVar, long j2, String str, zzdmw zzdmwVar, zzdnb zzdnbVar) {
        this.zzgvf = zzcuwVar;
        this.zzgvc = j2;
        this.zzgvd = str;
        this.zzgve = zzdmwVar;
        this.zzgjc = zzdnbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void onSuccess(T t) {
        Clock clock;
        boolean z;
        zzcrq zzcrqVar;
        zzcuy zzcuyVar;
        clock = this.zzgvf.zzbqg;
        long a = clock.a() - this.zzgvc;
        this.zzgvf.zza(this.zzgvd, 0, a, this.zzgve.zzhjw);
        z = this.zzgvf.zzgvi;
        if (z) {
            zzcuyVar = this.zzgvf.zzgvg;
            zzcuyVar.zza(this.zzgjc, this.zzgve, 0, null, a);
        }
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdab)).booleanValue()) {
            zzcrqVar = this.zzgvf.zzfxh;
            zzcrqVar.zza(this.zzgve, a, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        Clock clock;
        int i2;
        boolean z;
        zzvg zzvgVar;
        zzcrq zzcrqVar;
        zzcuy zzcuyVar;
        clock = this.zzgvf.zzbqg;
        long a = clock.a() - this.zzgvc;
        if (th instanceof TimeoutException) {
            i2 = 2;
        } else if (th instanceof zzcum) {
            i2 = 3;
        } else if (th instanceof CancellationException) {
            i2 = 4;
        } else if (th instanceof zzdnt) {
            i2 = 5;
        } else {
            i2 = ((th instanceof zzcmb) && zzdok.zzh(th).errorCode == 3) ? 1 : 6;
        }
        this.zzgvf.zza(this.zzgvd, i2, a, this.zzgve.zzhjw);
        z = this.zzgvf.zzgvi;
        if (z) {
            zzcuyVar = this.zzgvf.zzgvg;
            zzcuyVar.zza(this.zzgjc, this.zzgve, i2, th instanceof zzcrn ? (zzcrn) th : null, a);
        }
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdab)).booleanValue()) {
            zzvg zzh = zzdok.zzh(th);
            int i3 = zzh.errorCode;
            if ((i3 == 3 || i3 == 0) && (zzvgVar = zzh.zzchi) != null && !zzvgVar.zzchh.equals(MobileAds.ERROR_DOMAIN)) {
                zzh = zzdok.zzh(new zzcrn(zzdom.MEDIATION_NO_FILL, zzh.zzchi));
            }
            zzcrqVar = this.zzgvf.zzfxh;
            zzcrqVar.zza(this.zzgve, a, zzh);
        }
    }
}
