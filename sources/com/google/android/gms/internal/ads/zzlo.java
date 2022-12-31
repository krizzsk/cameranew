package com.google.android.gms.internal.ads;

import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzlo implements zzka, zzkf {
    private static final zzkb zzapk = new zzln();
    private static final int zzazz = zzpt.zzbh("qt  ");
    private long zzaip;
    private int zzarg;
    private int zzarh;
    private zzkc zzark;
    private int zzaxv;
    private int zzaxw;
    private long zzaxx;
    private int zzaxy;
    private zzpn zzaxz;
    private zzlq[] zzbaa;
    private boolean zzbab;
    private final zzpn zzaxr = new zzpn(16);
    private final Stack<zzkv> zzaxt = new Stack<>();
    private final zzpn zzapr = new zzpn(zzpm.zzbjt);
    private final zzpn zzaps = new zzpn(4);

    private final void zzeb(long j2) throws zzhw {
        zzmh zzmhVar;
        zzke zzkeVar;
        zzls zza;
        while (!this.zzaxt.isEmpty() && this.zzaxt.peek().zzasu == j2) {
            zzkv pop = this.zzaxt.pop();
            if (pop.type == zzkw.zzaty) {
                long j3 = -9223372036854775807L;
                ArrayList arrayList = new ArrayList();
                long j4 = LocationRequestCompat.PASSIVE_INTERVAL;
                zzmh zzmhVar2 = null;
                zzke zzkeVar2 = new zzke();
                zzky zzap = pop.zzap(zzkw.zzavx);
                if (zzap != null && (zzmhVar2 = zzkx.zza(zzap, this.zzbab)) != null) {
                    zzkeVar2.zzb(zzmhVar2);
                }
                int i2 = 0;
                while (i2 < pop.zzasw.size()) {
                    zzkv zzkvVar = pop.zzasw.get(i2);
                    if (zzkvVar.type == zzkw.zzaua && (zza = zzkx.zza(zzkvVar, pop.zzap(zzkw.zzatz), -9223372036854775807L, (zzjo) null, this.zzbab)) != null) {
                        zzlt zza2 = zzkx.zza(zza, zzkvVar.zzaq(zzkw.zzaub).zzaq(zzkw.zzauc).zzaq(zzkw.zzaud), zzkeVar2);
                        if (zza2.zzaxc != 0) {
                            zzlq zzlqVar = new zzlq(zza, zza2, this.zzark.zzc(i2, zza.type));
                            zzht zzv = zza.zzahz.zzv(zza2.zzayj + 30);
                            if (zza.type == 1) {
                                if (zzkeVar2.zzgt()) {
                                    zzv = zzv.zzb(zzkeVar2.zzahr, zzkeVar2.zzahs);
                                }
                                if (zzmhVar2 != null) {
                                    zzv = zzv.zza(zzmhVar2);
                                }
                            }
                            zzlqVar.zzbae.zze(zzv);
                            zzmhVar = zzmhVar2;
                            zzkeVar = zzkeVar2;
                            j3 = Math.max(j3, zza.zzaip);
                            arrayList.add(zzlqVar);
                            long j5 = zza2.zzaov[0];
                            if (j5 < j4) {
                                j4 = j5;
                            }
                            i2++;
                            zzkeVar2 = zzkeVar;
                            zzmhVar2 = zzmhVar;
                        }
                    }
                    zzmhVar = zzmhVar2;
                    zzkeVar = zzkeVar2;
                    i2++;
                    zzkeVar2 = zzkeVar;
                    zzmhVar2 = zzmhVar;
                }
                this.zzaip = j3;
                this.zzbaa = (zzlq[]) arrayList.toArray(new zzlq[arrayList.size()]);
                this.zzark.zzgs();
                this.zzark.zza(this);
                this.zzaxt.clear();
                this.zzaxv = 2;
            } else if (!this.zzaxt.isEmpty()) {
                this.zzaxt.peek().zza(pop);
            }
        }
        if (this.zzaxv != 2) {
            zzhb();
        }
    }

    private final void zzhb() {
        this.zzaxv = 0;
        this.zzaxy = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final long getDurationUs() {
        return this.zzaip;
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final boolean isSeekable() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final boolean zza(zzjz zzjzVar) throws IOException, InterruptedException {
        return zzlp.zze(zzjzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void zzc(long j2, long j3) {
        this.zzaxt.clear();
        this.zzaxy = 0;
        this.zzarh = 0;
        this.zzarg = 0;
        if (j2 == 0) {
            zzhb();
            return;
        }
        zzlq[] zzlqVarArr = this.zzbaa;
        if (zzlqVarArr != null) {
            for (zzlq zzlqVar : zzlqVarArr) {
                zzlt zzltVar = zzlqVar.zzbad;
                int zzec = zzltVar.zzec(j3);
                if (zzec == -1) {
                    zzec = zzltVar.zzed(j3);
                }
                zzlqVar.zzaxg = zzec;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final long zzdz(long j2) {
        zzlq[] zzlqVarArr = this.zzbaa;
        long j3 = LocationRequestCompat.PASSIVE_INTERVAL;
        for (zzlq zzlqVar : zzlqVarArr) {
            zzlt zzltVar = zzlqVar.zzbad;
            int zzec = zzltVar.zzec(j2);
            if (zzec == -1) {
                zzec = zzltVar.zzed(j2);
            }
            long j4 = zzltVar.zzaov[zzec];
            if (j4 < j3) {
                j3 = j4;
            }
        }
        return j3;
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void zza(zzkc zzkcVar) {
        this.zzark = zzkcVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x0188 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0293 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0006 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzka
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(com.google.android.gms.internal.ads.zzjz r24, com.google.android.gms.internal.ads.zzkg r25) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlo.zza(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzkg):int");
    }
}
