package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzmv implements zzpb {
    private final Uri uri;
    private final zzon zzaop;
    private final /* synthetic */ zzms zzbdl;
    private final zzmy zzbdt;
    private final zzpi zzbdu;
    private volatile boolean zzbeo;
    private long zzbeq;
    private final zzkg zzben = new zzkg();
    private boolean zzbep = true;
    private long zzco = -1;

    public zzmv(zzms zzmsVar, Uri uri, zzon zzonVar, zzmy zzmyVar, zzpi zzpiVar) {
        this.zzbdl = zzmsVar;
        this.uri = (Uri) zzpg.checkNotNull(uri);
        this.zzaop = (zzon) zzpg.checkNotNull(zzonVar);
        this.zzbdt = (zzmy) zzpg.checkNotNull(zzmyVar);
        this.zzbdu = zzpiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpb
    public final void cancelLoad() {
        this.zzbeo = true;
    }

    public final void zze(long j2, long j3) {
        this.zzben.position = j2;
        this.zzbeq = j3;
        this.zzbep = true;
    }

    @Override // com.google.android.gms.internal.ads.zzpb
    public final boolean zzhx() {
        return this.zzbeo;
    }

    @Override // com.google.android.gms.internal.ads.zzpb
    public final void zzhy() throws IOException, InterruptedException {
        long j2;
        zzjx zzjxVar;
        int i2 = 0;
        while (i2 == 0 && !this.zzbeo) {
            zzjx zzjxVar2 = null;
            try {
                j2 = this.zzben.position;
                long zza = this.zzaop.zza(new zzos(this.uri, j2, -1L, zzms.zzf(this.zzbdl)));
                this.zzco = zza;
                if (zza != -1) {
                    this.zzco = zza + j2;
                }
                zzjxVar = new zzjx(this.zzaop, j2, this.zzco);
            } catch (Throwable th) {
                th = th;
            }
            try {
                zzka zza2 = this.zzbdt.zza(zzjxVar, this.zzaop.getUri());
                if (this.zzbep) {
                    zza2.zzc(j2, this.zzbeq);
                    this.zzbep = false;
                }
                while (i2 == 0 && !this.zzbeo) {
                    this.zzbdu.block();
                    i2 = zza2.zza(zzjxVar, this.zzben);
                    if (zzjxVar.getPosition() > zzms.zzg(this.zzbdl) + j2) {
                        j2 = zzjxVar.getPosition();
                        this.zzbdu.zziu();
                        zzms.zzi(this.zzbdl).post(zzms.zzh(this.zzbdl));
                    }
                }
                if (i2 == 1) {
                    i2 = 0;
                } else {
                    this.zzben.position = zzjxVar.getPosition();
                }
                zzpt.zza(this.zzaop);
            } catch (Throwable th2) {
                th = th2;
                zzjxVar2 = zzjxVar;
                if (i2 != 1 && zzjxVar2 != null) {
                    this.zzben.position = zzjxVar2.getPosition();
                }
                zzpt.zza(this.zzaop);
                throw th;
            }
        }
    }
}
