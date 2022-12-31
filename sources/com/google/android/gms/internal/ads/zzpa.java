package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzpa {
    private final ExecutorService zzbji;
    private zzpc<? extends zzpb> zzbjj;
    private IOException zzbjk;

    public zzpa(String str) {
        this.zzbji = zzpt.zzbf(str);
    }

    public final boolean isLoading() {
        return this.zzbjj != null;
    }

    public final <T extends zzpb> long zza(T t, zzoz<T> zzozVar, int i2) {
        Looper myLooper = Looper.myLooper();
        zzpg.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzpc(this, myLooper, t, zzozVar, i2, elapsedRealtime).zzek(0L);
        return elapsedRealtime;
    }

    public final void zzbg(int i2) throws IOException {
        IOException iOException = this.zzbjk;
        if (iOException == null) {
            zzpc<? extends zzpb> zzpcVar = this.zzbjj;
            if (zzpcVar != null) {
                zzpcVar.zzbg(zzpcVar.zzbjn);
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void zzit() {
        this.zzbjj.zzl(false);
    }

    public final void zza(Runnable runnable) {
        zzpc<? extends zzpb> zzpcVar = this.zzbjj;
        if (zzpcVar != null) {
            zzpcVar.zzl(true);
        }
        this.zzbji.execute(runnable);
        this.zzbji.shutdown();
    }
}
