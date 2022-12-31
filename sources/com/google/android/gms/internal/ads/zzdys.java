package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdyk;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
abstract class zzdys<OutputT> extends zzdyk.zzh<OutputT> {
    private static final Logger zzhzc = Logger.getLogger(zzdys.class.getName());
    private static final zza zzhzy;
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions = null;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    private static abstract class zza {
        private zza() {
        }

        abstract void zza(zzdys zzdysVar, Set<Throwable> set, Set<Throwable> set2);

        abstract int zzc(zzdys zzdysVar);
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    private static final class zzb extends zza {
        private zzb() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.zzdys.zza
        final void zza(zzdys zzdysVar, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (zzdysVar) {
                if (zzdysVar.seenExceptions == null) {
                    zzdysVar.seenExceptions = set2;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdys.zza
        final int zzc(zzdys zzdysVar) {
            int zzb;
            synchronized (zzdysVar) {
                zzb = zzdys.zzb(zzdysVar);
            }
            return zzb;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    private static final class zzc extends zza {
        private final AtomicReferenceFieldUpdater<zzdys, Set<Throwable>> zziac;
        private final AtomicIntegerFieldUpdater<zzdys> zziad;

        zzc(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.zziac = atomicReferenceFieldUpdater;
            this.zziad = atomicIntegerFieldUpdater;
        }

        @Override // com.google.android.gms.internal.ads.zzdys.zza
        final void zza(zzdys zzdysVar, Set<Throwable> set, Set<Throwable> set2) {
            this.zziac.compareAndSet(zzdysVar, null, set2);
        }

        @Override // com.google.android.gms.internal.ads.zzdys.zza
        final int zzc(zzdys zzdysVar) {
            return this.zziad.decrementAndGet(zzdysVar);
        }
    }

    static {
        Throwable th;
        zza zzbVar;
        try {
            zzbVar = new zzc(AtomicReferenceFieldUpdater.newUpdater(zzdys.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzdys.class, "remaining"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzbVar = new zzb();
        }
        zzhzy = zzbVar;
        if (th != null) {
            zzhzc.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdys(int i2) {
        this.remaining = i2;
    }

    static /* synthetic */ int zzb(zzdys zzdysVar) {
        int i2 = zzdysVar.remaining - 1;
        zzdysVar.remaining = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Throwable> zzazy() {
        Set<Throwable> set = this.seenExceptions;
        if (set == null) {
            Set<Throwable> newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
            zzh(newSetFromMap);
            zzhzy.zza(this, null, newSetFromMap);
            return this.seenExceptions;
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzazz() {
        return zzhzy.zzc(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzbaa() {
        this.seenExceptions = null;
    }

    abstract void zzh(Set<Throwable> set);
}
