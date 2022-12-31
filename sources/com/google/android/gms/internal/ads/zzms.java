package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzms implements zzkc, zznc, zzno, zzoz<zzmv> {
    private final Uri uri;
    private final Handler zzaet;
    private boolean zzafw;
    private boolean zzags;
    private long zzaip;
    private final zzon zzaop;
    private final int zzbdm;
    private final zzmz zzbdn;
    private final zznd zzbdo;
    private final zzol zzbdp;
    private final long zzbdr;
    private final zzmy zzbdt;
    private zznb zzbdy;
    private zzkf zzbdz;
    private boolean zzbea;
    private boolean zzbeb;
    private boolean zzbec;
    private int zzbed;
    private zznu zzbee;
    private boolean[] zzbef;
    private boolean[] zzbeg;
    private boolean zzbeh;
    private long zzbei;
    private int zzbek;
    private boolean zzbel;
    private final String zzbdq = null;
    private final zzpa zzbds = new zzpa("Loader:ExtractorMediaPeriod");
    private final zzpi zzbdu = new zzpi();
    private final Runnable zzbdv = new zzmr(this);
    private final Runnable zzbdw = new zzmu(this);
    private final Handler handler = new Handler();
    private long zzbej = -9223372036854775807L;
    private final SparseArray<zznm> zzbdx = new SparseArray<>();
    private long zzco = -1;

    public zzms(Uri uri, zzon zzonVar, zzka[] zzkaVarArr, int i2, Handler handler, zzmz zzmzVar, zznd zzndVar, zzol zzolVar, String str, int i3) {
        this.uri = uri;
        this.zzaop = zzonVar;
        this.zzbdm = i2;
        this.zzaet = handler;
        this.zzbdn = zzmzVar;
        this.zzbdo = zzndVar;
        this.zzbdp = zzolVar;
        this.zzbdr = i3;
        this.zzbdt = new zzmy(zzkaVarArr, this);
    }

    private final void startLoading() {
        zzkf zzkfVar;
        zzmv zzmvVar = new zzmv(this, this.uri, this.zzaop, this.zzbdt, this.zzbdu);
        if (this.zzags) {
            zzpg.checkState(zzhw());
            long j2 = this.zzaip;
            if (j2 != -9223372036854775807L && this.zzbej >= j2) {
                this.zzbel = true;
                this.zzbej = -9223372036854775807L;
                return;
            }
            zzmvVar.zze(this.zzbdz.zzdz(this.zzbej), this.zzbej);
            this.zzbej = -9223372036854775807L;
        }
        this.zzbek = zzhu();
        int i2 = this.zzbdm;
        if (i2 == -1) {
            i2 = (this.zzags && this.zzco == -1 && ((zzkfVar = this.zzbdz) == null || zzkfVar.getDurationUs() == -9223372036854775807L)) ? 6 : 3;
        }
        this.zzbds.zza(zzmvVar, this, i2);
    }

    public final void zzht() {
        if (this.zzafw || this.zzags || this.zzbdz == null || !this.zzbea) {
            return;
        }
        int size = this.zzbdx.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.zzbdx.valueAt(i2).zzif() == null) {
                return;
            }
        }
        this.zzbdu.zziu();
        zznr[] zznrVarArr = new zznr[size];
        this.zzbeg = new boolean[size];
        this.zzbef = new boolean[size];
        this.zzaip = this.zzbdz.getDurationUs();
        int i3 = 0;
        while (true) {
            boolean z = true;
            if (i3 < size) {
                zzht zzif = this.zzbdx.valueAt(i3).zzif();
                zznrVarArr[i3] = new zznr(zzif);
                String str = zzif.zzahe;
                if (!zzpj.zzbd(str) && !zzpj.zzbc(str)) {
                    z = false;
                }
                this.zzbeg[i3] = z;
                this.zzbeh = z | this.zzbeh;
                i3++;
            } else {
                this.zzbee = new zznu(zznrVarArr);
                this.zzags = true;
                this.zzbdo.zzb(new zzns(this.zzaip, this.zzbdz.isSeekable()), null);
                this.zzbdy.zza((zznc) this);
                return;
            }
        }
    }

    private final int zzhu() {
        int size = this.zzbdx.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += this.zzbdx.valueAt(i3).zzid();
        }
        return i2;
    }

    private final long zzhv() {
        int size = this.zzbdx.size();
        long j2 = Long.MIN_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            j2 = Math.max(j2, this.zzbdx.valueAt(i2).zzhv());
        }
        return j2;
    }

    private final boolean zzhw() {
        return this.zzbej != -9223372036854775807L;
    }

    public final void release() {
        this.zzbds.zza(new zzmt(this, this.zzbdt));
        this.handler.removeCallbacksAndMessages(null);
        this.zzafw = true;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zza(zznb zznbVar, long j2) {
        this.zzbdy = zznbVar;
        this.zzbdu.open();
        startLoading();
    }

    public final boolean zzaz(int i2) {
        if (this.zzbel) {
            return true;
        }
        return !zzhw() && this.zzbdx.valueAt(i2).zzie();
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final zzkh zzc(int i2, int i3) {
        zznm zznmVar = this.zzbdx.get(i2);
        if (zznmVar == null) {
            zznm zznmVar2 = new zznm(this.zzbdp);
            zznmVar2.zza(this);
            this.zzbdx.put(i2, zznmVar2);
            return zznmVar2;
        }
        return zznmVar;
    }

    public final void zze(int i2, long j2) {
        zznm valueAt = this.zzbdx.valueAt(i2);
        if (this.zzbel && j2 > valueAt.zzhv()) {
            valueAt.zzii();
        } else {
            valueAt.zze(j2, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznc, com.google.android.gms.internal.ads.zznq
    public final boolean zzee(long j2) {
        if (this.zzbel) {
            return false;
        }
        if (this.zzags && this.zzbed == 0) {
            return false;
        }
        boolean open = this.zzbdu.open();
        if (this.zzbds.isLoading()) {
            return open;
        }
        startLoading();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zzef(long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final long zzeg(long j2) {
        if (!this.zzbdz.isSeekable()) {
            j2 = 0;
        }
        this.zzbei = j2;
        int size = this.zzbdx.size();
        boolean z = !zzhw();
        for (int i2 = 0; z && i2 < size; i2++) {
            if (this.zzbef[i2]) {
                z = this.zzbdx.valueAt(i2).zze(j2, false);
            }
        }
        if (!z) {
            this.zzbej = j2;
            this.zzbel = false;
            if (this.zzbds.isLoading()) {
                this.zzbds.zzit();
            } else {
                for (int i3 = 0; i3 < size; i3++) {
                    this.zzbdx.valueAt(i3).zzk(this.zzbef[i3]);
                }
            }
        }
        this.zzbec = false;
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final void zzf(zzht zzhtVar) {
        this.handler.post(this.zzbdv);
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final void zzgs() {
        this.zzbea = true;
        this.handler.post(this.zzbdv);
    }

    @Override // com.google.android.gms.internal.ads.zznc, com.google.android.gms.internal.ads.zznq
    public final long zzhn() {
        if (this.zzbed == 0) {
            return Long.MIN_VALUE;
        }
        return zzhr();
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zzho() throws IOException {
        this.zzbds.zzbg(Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final zznu zzhp() {
        return this.zzbee;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final long zzhq() {
        if (this.zzbec) {
            this.zzbec = false;
            return this.zzbei;
        }
        return -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final long zzhr() {
        long zzhv;
        if (this.zzbel) {
            return Long.MIN_VALUE;
        }
        if (zzhw()) {
            return this.zzbej;
        }
        if (this.zzbeh) {
            zzhv = LocationRequestCompat.PASSIVE_INTERVAL;
            int size = this.zzbdx.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.zzbeg[i2]) {
                    zzhv = Math.min(zzhv, this.zzbdx.valueAt(i2).zzhv());
                }
            }
        } else {
            zzhv = zzhv();
        }
        return zzhv == Long.MIN_VALUE ? this.zzbei : zzhv;
    }

    public final void zzhs() throws IOException {
        this.zzbds.zzbg(Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final long zza(zzog[] zzogVarArr, boolean[] zArr, zznn[] zznnVarArr, boolean[] zArr2, long j2) {
        int i2;
        zzpg.checkState(this.zzags);
        for (int i3 = 0; i3 < zzogVarArr.length; i3++) {
            if (zznnVarArr[i3] != null && (zzogVarArr[i3] == null || !zArr[i3])) {
                i2 = ((zzmx) zznnVarArr[i3]).track;
                zzpg.checkState(this.zzbef[i2]);
                this.zzbed--;
                this.zzbef[i2] = false;
                this.zzbdx.valueAt(i2).disable();
                zznnVarArr[i3] = null;
            }
        }
        boolean z = false;
        for (int i4 = 0; i4 < zzogVarArr.length; i4++) {
            if (zznnVarArr[i4] == null && zzogVarArr[i4] != null) {
                zzog zzogVar = zzogVarArr[i4];
                zzpg.checkState(zzogVar.length() == 1);
                zzpg.checkState(zzogVar.zzbd(0) == 0);
                int zza = this.zzbee.zza(zzogVar.zzil());
                zzpg.checkState(!this.zzbef[zza]);
                this.zzbed++;
                this.zzbef[zza] = true;
                zznnVarArr[i4] = new zzmx(this, zza);
                zArr2[i4] = true;
                z = true;
            }
        }
        if (!this.zzbeb) {
            int size = this.zzbdx.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (!this.zzbef[i5]) {
                    this.zzbdx.valueAt(i5).disable();
                }
            }
        }
        if (this.zzbed == 0) {
            this.zzbec = false;
            if (this.zzbds.isLoading()) {
                this.zzbds.zzit();
            }
        } else if (!this.zzbeb ? j2 != 0 : z) {
            j2 = zzeg(j2);
            for (int i6 = 0; i6 < zznnVarArr.length; i6++) {
                if (zznnVarArr[i6] != null) {
                    zArr2[i6] = true;
                }
            }
        }
        this.zzbeb = true;
        return j2;
    }

    public final int zza(int i2, zzhv zzhvVar, zzjp zzjpVar, boolean z) {
        if (this.zzbec || zzhw()) {
            return -3;
        }
        return this.zzbdx.valueAt(i2).zza(zzhvVar, zzjpVar, z, this.zzbel, this.zzbei);
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final void zza(zzkf zzkfVar) {
        this.zzbdz = zzkfVar;
        this.handler.post(this.zzbdv);
    }

    private final void zza(zzmv zzmvVar) {
        long j2;
        if (this.zzco == -1) {
            j2 = zzmvVar.zzco;
            this.zzco = j2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final /* synthetic */ int zza(zzmv zzmvVar, long j2, long j3, IOException iOException) {
        zzkf zzkfVar;
        zzmv zzmvVar2 = zzmvVar;
        zza(zzmvVar2);
        Handler handler = this.zzaet;
        if (handler != null && this.zzbdn != null) {
            handler.post(new zzmw(this, iOException));
        }
        if (iOException instanceof zznt) {
            return 3;
        }
        boolean z = zzhu() > this.zzbek;
        if (this.zzco == -1 && ((zzkfVar = this.zzbdz) == null || zzkfVar.getDurationUs() == -9223372036854775807L)) {
            this.zzbei = 0L;
            this.zzbec = this.zzags;
            int size = this.zzbdx.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.zzbdx.valueAt(i2).zzk(!this.zzags || this.zzbef[i2]);
            }
            zzmvVar2.zze(0L, 0L);
        }
        this.zzbek = zzhu();
        return z ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final /* synthetic */ void zza(zzmv zzmvVar, long j2, long j3, boolean z) {
        zza(zzmvVar);
        if (z || this.zzbed <= 0) {
            return;
        }
        int size = this.zzbdx.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.zzbdx.valueAt(i2).zzk(this.zzbef[i2]);
        }
        this.zzbdy.zza((zznb) this);
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final /* synthetic */ void zza(zzmv zzmvVar, long j2, long j3) {
        zza(zzmvVar);
        this.zzbel = true;
        if (this.zzaip == -9223372036854775807L) {
            long zzhv = zzhv();
            this.zzaip = zzhv == Long.MIN_VALUE ? 0L : zzhv + 10000;
            this.zzbdo.zzb(new zzns(this.zzaip, this.zzbdz.isSeekable()), null);
        }
        this.zzbdy.zza((zznb) this);
    }
}
