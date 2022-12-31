package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaf {
    private final zzu zzai;
    private final AtomicInteger zzbi;
    private final Set<zzab<?>> zzbj;
    private final PriorityBlockingQueue<zzab<?>> zzbk;
    private final PriorityBlockingQueue<zzab<?>> zzbl;
    private final zzx[] zzbm;
    private zzm zzbn;
    private final List<zzah> zzbo;
    private final List<zzae> zzbp;
    private final zzk zzn;
    private final zzal zzo;

    private zzaf(zzk zzkVar, zzu zzuVar, int i2, zzal zzalVar) {
        this.zzbi = new AtomicInteger();
        this.zzbj = new HashSet();
        this.zzbk = new PriorityBlockingQueue<>();
        this.zzbl = new PriorityBlockingQueue<>();
        this.zzbo = new ArrayList();
        this.zzbp = new ArrayList();
        this.zzn = zzkVar;
        this.zzai = zzuVar;
        this.zzbm = new zzx[4];
        this.zzo = zzalVar;
    }

    public final void start() {
        zzx[] zzxVarArr;
        zzm zzmVar = this.zzbn;
        if (zzmVar != null) {
            zzmVar.quit();
        }
        for (zzx zzxVar : this.zzbm) {
            if (zzxVar != null) {
                zzxVar.quit();
            }
        }
        zzm zzmVar2 = new zzm(this.zzbk, this.zzbl, this.zzn, this.zzo);
        this.zzbn = zzmVar2;
        zzmVar2.start();
        for (int i2 = 0; i2 < this.zzbm.length; i2++) {
            zzx zzxVar2 = new zzx(this.zzbl, this.zzai, this.zzn, this.zzo);
            this.zzbm[i2] = zzxVar2;
            zzxVar2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzab<?> zzabVar, int i2) {
        synchronized (this.zzbp) {
            for (zzae zzaeVar : this.zzbp) {
                zzaeVar.zza(zzabVar, i2);
            }
        }
    }

    public final <T> zzab<T> zzd(zzab<T> zzabVar) {
        zzabVar.zza(this);
        synchronized (this.zzbj) {
            this.zzbj.add(zzabVar);
        }
        zzabVar.zze(this.zzbi.incrementAndGet());
        zzabVar.zzc("add-to-queue");
        zzb(zzabVar, 0);
        if (!zzabVar.zzh()) {
            this.zzbl.add(zzabVar);
        } else {
            this.zzbk.add(zzabVar);
        }
        return zzabVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> void zze(zzab<T> zzabVar) {
        synchronized (this.zzbj) {
            this.zzbj.remove(zzabVar);
        }
        synchronized (this.zzbo) {
            for (zzah zzahVar : this.zzbo) {
                zzahVar.zzf(zzabVar);
            }
        }
        zzb(zzabVar, 5);
    }

    private zzaf(zzk zzkVar, zzu zzuVar, int i2) {
        this(zzkVar, zzuVar, 4, new zzq(new Handler(Looper.getMainLooper())));
    }

    public zzaf(zzk zzkVar, zzu zzuVar) {
        this(zzkVar, zzuVar, 4);
    }
}
