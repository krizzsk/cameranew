package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzbwf<ListenerT> {
    @GuardedBy("this")
    private final Map<ListenerT, Executor> zzgaf = new HashMap();

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbwf(Set<zzbya<ListenerT>> set) {
        zzb(set);
    }

    private final synchronized void zzb(Set<zzbya<ListenerT>> set) {
        for (zzbya<ListenerT> zzbyaVar : set) {
            zza(zzbyaVar);
        }
    }

    public final synchronized void zza(zzbya<ListenerT> zzbyaVar) {
        zza(zzbyaVar.zzgba, zzbyaVar.executor);
    }

    public final synchronized void zza(ListenerT listenert, Executor executor) {
        this.zzgaf.put(listenert, executor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void zza(final zzbwh<ListenerT> zzbwhVar) {
        for (Map.Entry<ListenerT, Executor> entry : this.zzgaf.entrySet()) {
            final ListenerT key = entry.getKey();
            entry.getValue().execute(new Runnable(zzbwhVar, key) { // from class: com.google.android.gms.internal.ads.zzbwe
                private final Object zzdlk;
                private final zzbwh zzgae;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgae = zzbwhVar;
                    this.zzdlk = key;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        this.zzgae.zzo(this.zzdlk);
                    } catch (Throwable th) {
                        com.google.android.gms.ads.internal.zzr.zzkv().zzb(th, "EventEmitter.notify");
                        com.google.android.gms.ads.internal.util.zzd.zza("Event emitter exception.", th);
                    }
                }
            });
        }
    }
}
