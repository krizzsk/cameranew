package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzhk implements zzhh {
    private int repeatMode;
    private final zzhy[] zzaeq;
    private final zzoh zzaer;
    private final zzoi zzaes;
    private final Handler zzaet;
    private final zzhm zzaeu;
    private final CopyOnWriteArraySet<zzhg> zzaev;
    private final zzie zzaew;
    private final zzif zzaex;
    private boolean zzaey;
    private boolean zzaez;
    private int zzafa;
    private int zzafb;
    private int zzafc;
    private boolean zzafd;
    private zzid zzafe;
    private Object zzaff;
    private zznu zzafg;
    private zzoi zzafh;
    private zzhz zzafi;
    private zzho zzafj;
    private int zzafk;
    private int zzafl;
    private long zzafm;

    @SuppressLint({"HandlerLeak"})
    public zzhk(zzhy[] zzhyVarArr, zzoh zzohVar, zzhx zzhxVar) {
        String str = zzpt.zzbkn;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26);
        sb.append("Init ExoPlayerLib/2.4.2 [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        zzpg.checkState(zzhyVarArr.length > 0);
        this.zzaeq = (zzhy[]) zzpg.checkNotNull(zzhyVarArr);
        this.zzaer = (zzoh) zzpg.checkNotNull(zzohVar);
        this.zzaez = false;
        this.repeatMode = 0;
        this.zzafa = 1;
        this.zzaev = new CopyOnWriteArraySet<>();
        zzoi zzoiVar = new zzoi(new zzog[zzhyVarArr.length]);
        this.zzaes = zzoiVar;
        this.zzafe = zzid.zzaig;
        this.zzaew = new zzie();
        this.zzaex = new zzif();
        this.zzafg = zznu.zzbgv;
        this.zzafh = zzoiVar;
        this.zzafi = zzhz.zzaia;
        zzhn zzhnVar = new zzhn(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.zzaet = zzhnVar;
        zzho zzhoVar = new zzho(0, 0L);
        this.zzafj = zzhoVar;
        this.zzaeu = new zzhm(zzhyVarArr, zzohVar, zzhxVar, this.zzaez, 0, zzhnVar, zzhoVar, this);
    }

    private final int zzeo() {
        if (!this.zzafe.isEmpty() && this.zzafb <= 0) {
            this.zzafe.zza(this.zzafj.zzagi, this.zzaex, false);
            return 0;
        }
        return this.zzafk;
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final long getBufferedPosition() {
        if (!this.zzafe.isEmpty() && this.zzafb <= 0) {
            this.zzafe.zza(this.zzafj.zzagi, this.zzaex, false);
            return this.zzaex.zzfh() + zzhf.zzdo(this.zzafj.zzagl);
        }
        return this.zzafm;
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final long getDuration() {
        if (this.zzafe.isEmpty()) {
            return -9223372036854775807L;
        }
        return zzhf.zzdo(this.zzafe.zza(zzeo(), this.zzaew, false).zzaip);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final int getPlaybackState() {
        return this.zzafa;
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void release() {
        this.zzaeu.release();
        this.zzaet.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void seekTo(long j2) {
        int zzeo = zzeo();
        if (zzeo >= 0 && (this.zzafe.isEmpty() || zzeo < this.zzafe.zzff())) {
            this.zzafb++;
            this.zzafk = zzeo;
            if (!this.zzafe.isEmpty()) {
                this.zzafe.zza(zzeo, this.zzaew, false);
                long zzdp = (j2 == -9223372036854775807L ? 0L : zzhf.zzdp(j2)) + 0;
                long j3 = this.zzafe.zza(0, this.zzaex, false).zzaip;
                if (j3 != -9223372036854775807L) {
                    int i2 = (zzdp > j3 ? 1 : (zzdp == j3 ? 0 : -1));
                }
            }
            this.zzafl = 0;
            if (j2 == -9223372036854775807L) {
                this.zzafm = 0L;
                this.zzaeu.zza(this.zzafe, zzeo, -9223372036854775807L);
                return;
            }
            this.zzafm = j2;
            this.zzaeu.zza(this.zzafe, zzeo, zzhf.zzdp(j2));
            Iterator<zzhg> it = this.zzaev.iterator();
            while (it.hasNext()) {
                it.next().zzek();
            }
            return;
        }
        throw new zzhu(this.zzafe, zzeo, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void stop() {
        this.zzaeu.stop();
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zza(zzhg zzhgVar) {
        this.zzaev.add(zzhgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zzb(zzhg zzhgVar) {
        this.zzaev.remove(zzhgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final boolean zzel() {
        return this.zzaez;
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final int zzem() {
        return this.zzaeq.length;
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final long zzen() {
        if (!this.zzafe.isEmpty() && this.zzafb <= 0) {
            this.zzafe.zza(this.zzafj.zzagi, this.zzaex, false);
            return this.zzaex.zzfh() + zzhf.zzdo(this.zzafj.zzagk);
        }
        return this.zzafm;
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zzg(boolean z) {
        if (this.zzaez != z) {
            this.zzaez = z;
            this.zzaeu.zzg(z);
            Iterator<zzhg> it = this.zzaev.iterator();
            while (it.hasNext()) {
                it.next().zza(z, this.zzafa);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zza(zzne zzneVar) {
        if (!this.zzafe.isEmpty() || this.zzaff != null) {
            this.zzafe = zzid.zzaig;
            this.zzaff = null;
            Iterator<zzhg> it = this.zzaev.iterator();
            while (it.hasNext()) {
                it.next().zza(this.zzafe, this.zzaff);
            }
        }
        if (this.zzaey) {
            this.zzaey = false;
            this.zzafg = zznu.zzbgv;
            this.zzafh = this.zzaes;
            this.zzaer.zzd(null);
            Iterator<zzhg> it2 = this.zzaev.iterator();
            while (it2.hasNext()) {
                it2.next().zza(this.zzafg, this.zzafh);
            }
        }
        this.zzafc++;
        this.zzaeu.zza(zzneVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zzb(zzhi... zzhiVarArr) {
        this.zzaeu.zzb(zzhiVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zza(zzhi... zzhiVarArr) {
        this.zzaeu.zza(zzhiVarArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Message message) {
        switch (message.what) {
            case 0:
                this.zzafc--;
                return;
            case 1:
                this.zzafa = message.arg1;
                Iterator<zzhg> it = this.zzaev.iterator();
                while (it.hasNext()) {
                    it.next().zza(this.zzaez, this.zzafa);
                }
                return;
            case 2:
                this.zzafd = message.arg1 != 0;
                Iterator<zzhg> it2 = this.zzaev.iterator();
                while (it2.hasNext()) {
                    it2.next().zzf(this.zzafd);
                }
                return;
            case 3:
                if (this.zzafc == 0) {
                    zzoj zzojVar = (zzoj) message.obj;
                    this.zzaey = true;
                    this.zzafg = zzojVar.zzbhx;
                    this.zzafh = zzojVar.zzbhy;
                    this.zzaer.zzd(zzojVar.zzbhz);
                    Iterator<zzhg> it3 = this.zzaev.iterator();
                    while (it3.hasNext()) {
                        it3.next().zza(this.zzafg, this.zzafh);
                    }
                    return;
                }
                return;
            case 4:
                int i2 = this.zzafb - 1;
                this.zzafb = i2;
                if (i2 == 0) {
                    this.zzafj = (zzho) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzhg> it4 = this.zzaev.iterator();
                        while (it4.hasNext()) {
                            it4.next().zzek();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.zzafb == 0) {
                    this.zzafj = (zzho) message.obj;
                    Iterator<zzhg> it5 = this.zzaev.iterator();
                    while (it5.hasNext()) {
                        it5.next().zzek();
                    }
                    return;
                }
                return;
            case 6:
                zzhq zzhqVar = (zzhq) message.obj;
                this.zzafb -= zzhqVar.zzagx;
                if (this.zzafc == 0) {
                    this.zzafe = zzhqVar.zzafe;
                    this.zzaff = zzhqVar.zzaff;
                    this.zzafj = zzhqVar.zzafj;
                    Iterator<zzhg> it6 = this.zzaev.iterator();
                    while (it6.hasNext()) {
                        it6.next().zza(this.zzafe, this.zzaff);
                    }
                    return;
                }
                return;
            case 7:
                zzhz zzhzVar = (zzhz) message.obj;
                if (this.zzafi.equals(zzhzVar)) {
                    return;
                }
                this.zzafi = zzhzVar;
                Iterator<zzhg> it7 = this.zzaev.iterator();
                while (it7.hasNext()) {
                    it7.next().zza(zzhzVar);
                }
                return;
            case 8:
                zzhe zzheVar = (zzhe) message.obj;
                Iterator<zzhg> it8 = this.zzaev.iterator();
                while (it8.hasNext()) {
                    it8.next().zza(zzheVar);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
