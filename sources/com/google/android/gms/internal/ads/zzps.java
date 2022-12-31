package com.google.android.gms.internal.ads;

import android.os.SystemClock;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzps implements zzpk {
    private boolean started;
    private zzhz zzafi = zzhz.zzaia;
    private long zzbkl;
    private long zzbkm;

    public final void start() {
        if (this.started) {
            return;
        }
        this.zzbkm = SystemClock.elapsedRealtime();
        this.started = true;
    }

    public final void stop() {
        if (this.started) {
            zzel(zzgc());
            this.started = false;
        }
    }

    public final void zza(zzpk zzpkVar) {
        zzel(zzpkVar.zzgc());
        this.zzafi = zzpkVar.zzfs();
    }

    @Override // com.google.android.gms.internal.ads.zzpk
    public final zzhz zzb(zzhz zzhzVar) {
        if (this.started) {
            zzel(zzgc());
        }
        this.zzafi = zzhzVar;
        return zzhzVar;
    }

    public final void zzel(long j2) {
        this.zzbkl = j2;
        if (this.started) {
            this.zzbkm = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpk
    public final zzhz zzfs() {
        return this.zzafi;
    }

    @Override // com.google.android.gms.internal.ads.zzpk
    public final long zzgc() {
        long zzdu;
        long j2 = this.zzbkl;
        if (this.started) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzbkm;
            zzhz zzhzVar = this.zzafi;
            if (zzhzVar.zzaib == 1.0f) {
                zzdu = zzhf.zzdp(elapsedRealtime);
            } else {
                zzdu = zzhzVar.zzdu(elapsedRealtime);
            }
            return j2 + zzdu;
        }
        return j2;
    }
}
