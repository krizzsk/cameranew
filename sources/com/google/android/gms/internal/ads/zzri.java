package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzri {
    private int zzbsg;
    private final Object lock = new Object();
    private List<zzrj> zzbsh = new LinkedList();

    public final boolean zza(zzrj zzrjVar) {
        synchronized (this.lock) {
            return this.zzbsh.contains(zzrjVar);
        }
    }

    public final boolean zzb(zzrj zzrjVar) {
        synchronized (this.lock) {
            Iterator<zzrj> it = this.zzbsh.iterator();
            while (it.hasNext()) {
                zzrj next = it.next();
                if (!com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzyi()) {
                    if (zzrjVar != next && next.zzlz().equals(zzrjVar.zzlz())) {
                        it.remove();
                        return true;
                    }
                } else if (!com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzyk() && zzrjVar != next && next.zzmb().equals(zzrjVar.zzmb())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void zzc(zzrj zzrjVar) {
        synchronized (this.lock) {
            if (this.zzbsh.size() >= 10) {
                int size = this.zzbsh.size();
                StringBuilder sb = new StringBuilder(41);
                sb.append("Queue is full, current size = ");
                sb.append(size);
                zzazk.zzdy(sb.toString());
                this.zzbsh.remove(0);
            }
            int i2 = this.zzbsg;
            this.zzbsg = i2 + 1;
            zzrjVar.zzbt(i2);
            zzrjVar.zzmf();
            this.zzbsh.add(zzrjVar);
        }
    }

    @Nullable
    public final zzrj zzo(boolean z) {
        synchronized (this.lock) {
            zzrj zzrjVar = null;
            if (this.zzbsh.size() == 0) {
                zzazk.zzdy("Queue empty");
                return null;
            }
            int i2 = 0;
            if (this.zzbsh.size() >= 2) {
                int i3 = Integer.MIN_VALUE;
                int i4 = 0;
                for (zzrj zzrjVar2 : this.zzbsh) {
                    int score = zzrjVar2.getScore();
                    if (score > i3) {
                        i2 = i4;
                        zzrjVar = zzrjVar2;
                        i3 = score;
                    }
                    i4++;
                }
                this.zzbsh.remove(i2);
                return zzrjVar;
            }
            zzrj zzrjVar3 = this.zzbsh.get(0);
            if (z) {
                this.zzbsh.remove(0);
            } else {
                zzrjVar3.zzmc();
            }
            return zzrjVar3;
        }
    }
}
