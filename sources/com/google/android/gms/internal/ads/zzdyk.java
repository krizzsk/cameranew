package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzdyk<V> extends zzeao implements zzdzw<V> {
    private static final boolean GENERATE_CANCELLATION_CAUSES;
    private static final Object NULL;
    private static final Logger zzhzc;
    private static final zzb zzhzd;
    @NullableDecl
    private volatile zze listeners;
    @NullableDecl
    private volatile Object value;
    @NullableDecl
    private volatile zzk waiters;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza {
        static final zza zzhze;
        static final zza zzhzf;
        @NullableDecl
        final Throwable cause;
        final boolean wasInterrupted;

        static {
            if (zzdyk.GENERATE_CANCELLATION_CAUSES) {
                zzhzf = null;
                zzhze = null;
                return;
            }
            zzhzf = new zza(false, null);
            zzhze = new zza(true, null);
        }

        zza(boolean z, @NullableDecl Throwable th) {
            this.wasInterrupted = z;
            this.cause = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static abstract class zzb {
        private zzb() {
        }

        abstract void zza(zzk zzkVar, zzk zzkVar2);

        abstract void zza(zzk zzkVar, Thread thread);

        abstract boolean zza(zzdyk<?> zzdykVar, zze zzeVar, zze zzeVar2);

        abstract boolean zza(zzdyk<?> zzdykVar, zzk zzkVar, zzk zzkVar2);

        abstract boolean zza(zzdyk<?> zzdykVar, Object obj, Object obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zzc {
        static final zzc zzhzg = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.ads.zzdyk.zzc.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable exception;

        zzc(Throwable th) {
            this.exception = (Throwable) zzdwl.checkNotNull(th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    private static final class zzd extends zzb {
        final AtomicReferenceFieldUpdater<zzdyk, zze> listenersUpdater;
        final AtomicReferenceFieldUpdater<zzdyk, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<zzk, zzk> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<zzk, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<zzdyk, zzk> waitersUpdater;

        zzd(AtomicReferenceFieldUpdater<zzk, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<zzk, zzk> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<zzdyk, zzk> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<zzdyk, zze> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<zzdyk, Object> atomicReferenceFieldUpdater5) {
            super();
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.gms.internal.ads.zzdyk.zzb
        final void zza(zzk zzkVar, Thread thread) {
            this.waiterThreadUpdater.lazySet(zzkVar, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzdyk.zzb
        final void zza(zzk zzkVar, zzk zzkVar2) {
            this.waiterNextUpdater.lazySet(zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdyk.zzb
        final boolean zza(zzdyk<?> zzdykVar, zzk zzkVar, zzk zzkVar2) {
            return this.waitersUpdater.compareAndSet(zzdykVar, zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdyk.zzb
        final boolean zza(zzdyk<?> zzdykVar, zze zzeVar, zze zzeVar2) {
            return this.listenersUpdater.compareAndSet(zzdykVar, zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdyk.zzb
        final boolean zza(zzdyk<?> zzdykVar, Object obj, Object obj2) {
            return this.valueUpdater.compareAndSet(zzdykVar, obj, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zze {
        static final zze zzhzh = new zze(null, null);
        final Executor executor;
        @NullableDecl
        zze next;
        final Runnable task;

        zze(Runnable runnable, Executor executor) {
            this.task = runnable;
            this.executor = executor;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    private static final class zzf extends zzb {
        private zzf() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.zzdyk.zzb
        final void zza(zzk zzkVar, Thread thread) {
            zzkVar.thread = thread;
        }

        @Override // com.google.android.gms.internal.ads.zzdyk.zzb
        final void zza(zzk zzkVar, zzk zzkVar2) {
            zzkVar.next = zzkVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzdyk.zzb
        final boolean zza(zzdyk<?> zzdykVar, zzk zzkVar, zzk zzkVar2) {
            synchronized (zzdykVar) {
                if (((zzdyk) zzdykVar).waiters == zzkVar) {
                    ((zzdyk) zzdykVar).waiters = zzkVar2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdyk.zzb
        final boolean zza(zzdyk<?> zzdykVar, zze zzeVar, zze zzeVar2) {
            synchronized (zzdykVar) {
                if (((zzdyk) zzdykVar).listeners == zzeVar) {
                    ((zzdyk) zzdykVar).listeners = zzeVar2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdyk.zzb
        final boolean zza(zzdyk<?> zzdykVar, Object obj, Object obj2) {
            synchronized (zzdykVar) {
                if (((zzdyk) zzdykVar).value == obj) {
                    ((zzdyk) zzdykVar).value = obj2;
                    return true;
                }
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zzg<V> implements Runnable {
        final zzdzw<? extends V> future;
        final zzdyk<V> zzhzi;

        zzg(zzdyk<V> zzdykVar, zzdzw<? extends V> zzdzwVar) {
            this.zzhzi = zzdykVar;
            this.future = zzdzwVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (((zzdyk) this.zzhzi).value != this) {
                return;
            }
            if (zzdyk.zzhzd.zza((zzdyk<?>) this.zzhzi, (Object) this, zzdyk.getFutureValue(this.future))) {
                zzdyk.zza((zzdyk<?>) this.zzhzi);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    static abstract class zzh<V> extends zzdyk<V> implements zzi<V> {
        @Override // com.google.android.gms.internal.ads.zzdyk, java.util.concurrent.Future
        public final V get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(j2, timeUnit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public interface zzi<V> extends zzdzw<V> {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    private static final class zzj extends zzb {
        static final Unsafe zzhzj;
        static final long zzhzk;
        static final long zzhzl;
        static final long zzhzm;
        static final long zzhzn;
        static final long zzhzo;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.android.gms.internal.ads.zzdyk.zzj.1
                    @Override // java.security.PrivilegedExceptionAction
                    public /* synthetic */ Unsafe run() throws Exception {
                        Field[] declaredFields;
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
            try {
                zzhzl = unsafe.objectFieldOffset(zzdyk.class.getDeclaredField("waiters"));
                zzhzk = unsafe.objectFieldOffset(zzdyk.class.getDeclaredField("listeners"));
                zzhzm = unsafe.objectFieldOffset(zzdyk.class.getDeclaredField(FirebaseAnalytics.Param.VALUE));
                zzhzn = unsafe.objectFieldOffset(zzk.class.getDeclaredField("thread"));
                zzhzo = unsafe.objectFieldOffset(zzk.class.getDeclaredField("next"));
                zzhzj = unsafe;
            } catch (Exception e3) {
                zzdwv.zzi(e3);
                throw new RuntimeException(e3);
            }
        }

        private zzj() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.zzdyk.zzb
        final void zza(zzk zzkVar, Thread thread) {
            zzhzj.putObject(zzkVar, zzhzn, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzdyk.zzb
        final void zza(zzk zzkVar, zzk zzkVar2) {
            zzhzj.putObject(zzkVar, zzhzo, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdyk.zzb
        final boolean zza(zzdyk<?> zzdykVar, zzk zzkVar, zzk zzkVar2) {
            return zzhzj.compareAndSwapObject(zzdykVar, zzhzl, zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdyk.zzb
        final boolean zza(zzdyk<?> zzdykVar, zze zzeVar, zze zzeVar2) {
            return zzhzj.compareAndSwapObject(zzdykVar, zzhzk, zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdyk.zzb
        final boolean zza(zzdyk<?> zzdykVar, Object obj, Object obj2) {
            return zzhzj.compareAndSwapObject(zzdykVar, zzhzm, obj, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zzk {
        static final zzk zzhzp = new zzk(false);
        @NullableDecl
        volatile zzk next;
        @NullableDecl
        volatile Thread thread;

        private zzk(boolean z) {
        }

        final void zzb(zzk zzkVar) {
            zzdyk.zzhzd.zza(this, zzkVar);
        }

        zzk() {
            zzdyk.zzhzd.zza(this, Thread.currentThread());
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zzb zzfVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        GENERATE_CANCELLATION_CAUSES = z;
        zzhzc = Logger.getLogger(zzdyk.class.getName());
        try {
            zzfVar = new zzj();
            th2 = null;
            th = null;
        } catch (Throwable th3) {
            try {
                th2 = th3;
                zzfVar = new zzd(AtomicReferenceFieldUpdater.newUpdater(zzk.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(zzk.class, zzk.class, "next"), AtomicReferenceFieldUpdater.newUpdater(zzdyk.class, zzk.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(zzdyk.class, zze.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(zzdyk.class, Object.class, FirebaseAnalytics.Param.VALUE));
                th = null;
            } catch (Throwable th4) {
                th = th4;
                th2 = th3;
                zzfVar = new zzf();
            }
        }
        zzhzd = zzfVar;
        if (th != null) {
            Logger logger = zzhzc;
            Level level = Level.SEVERE;
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        NULL = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getFutureValue(zzdzw<?> zzdzwVar) {
        Throwable zza2;
        if (zzdzwVar instanceof zzi) {
            Object obj = ((zzdyk) zzdzwVar).value;
            if (obj instanceof zza) {
                zza zzaVar = (zza) obj;
                if (zzaVar.wasInterrupted) {
                    if (zzaVar.cause != null) {
                        return new zza(false, zzaVar.cause);
                    }
                    return zza.zzhzf;
                }
                return obj;
            }
            return obj;
        } else if ((zzdzwVar instanceof zzeao) && (zza2 = zzean.zza((zzeao) zzdzwVar)) != null) {
            return new zzc(zza2);
        } else {
            boolean isCancelled = zzdzwVar.isCancelled();
            if ((!GENERATE_CANCELLATION_CAUSES) & isCancelled) {
                return zza.zzhzf;
            }
            try {
                Object uninterruptibly = getUninterruptibly(zzdzwVar);
                if (!isCancelled) {
                    return uninterruptibly == null ? NULL : uninterruptibly;
                }
                String valueOf = String.valueOf(zzdzwVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 84);
                sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb.append(valueOf);
                return new zza(false, new IllegalArgumentException(sb.toString()));
            } catch (CancellationException e2) {
                if (!isCancelled) {
                    String valueOf2 = String.valueOf(zzdzwVar);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 77);
                    sb2.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
                    sb2.append(valueOf2);
                    return new zzc(new IllegalArgumentException(sb2.toString(), e2));
                }
                return new zza(false, e2);
            } catch (ExecutionException e3) {
                if (isCancelled) {
                    String valueOf3 = String.valueOf(zzdzwVar);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 84);
                    sb3.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                    sb3.append(valueOf3);
                    return new zza(false, new IllegalArgumentException(sb3.toString(), e3));
                }
                return new zzc(e3.getCause());
            } catch (Throwable th) {
                return new zzc(th);
            }
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    private final void zza(zzk zzkVar) {
        zzkVar.thread = null;
        while (true) {
            zzk zzkVar2 = this.waiters;
            if (zzkVar2 == zzk.zzhzp) {
                return;
            }
            zzk zzkVar3 = null;
            while (zzkVar2 != null) {
                zzk zzkVar4 = zzkVar2.next;
                if (zzkVar2.thread != null) {
                    zzkVar3 = zzkVar2;
                } else if (zzkVar3 != null) {
                    zzkVar3.next = zzkVar4;
                    if (zzkVar3.thread == null) {
                        break;
                    }
                } else if (zzhzd.zza((zzdyk<?>) this, zzkVar2, zzkVar4)) {
                }
                zzkVar2 = zzkVar4;
            }
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static V zzaf(Object obj) throws ExecutionException {
        if (!(obj instanceof zza)) {
            if (!(obj instanceof zzc)) {
                if (obj == NULL) {
                    return null;
                }
                return obj;
            }
            throw new ExecutionException(((zzc) obj).exception);
        }
        Throwable th = ((zza) obj).cause;
        CancellationException cancellationException = new CancellationException("Task was cancelled.");
        cancellationException.initCause(th);
        throw cancellationException;
    }

    @Override // com.google.android.gms.internal.ads.zzdzw
    public void addListener(Runnable runnable, Executor executor) {
        zze zzeVar;
        zzdwl.checkNotNull(runnable, "Runnable was null.");
        zzdwl.checkNotNull(executor, "Executor was null.");
        if (!isDone() && (zzeVar = this.listeners) != zze.zzhzh) {
            zze zzeVar2 = new zze(runnable, executor);
            do {
                zzeVar2.next = zzeVar;
                if (zzhzd.zza((zzdyk<?>) this, zzeVar, zzeVar2)) {
                    return;
                }
                zzeVar = this.listeners;
            } while (zzeVar != zze.zzhzh);
            zza(runnable, executor);
        }
        zza(runnable, executor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        zza zzaVar;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof zzg)) {
            return false;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            zzaVar = new zza(z, new CancellationException("Future.cancel() was called."));
        } else if (z) {
            zzaVar = zza.zzhze;
        } else {
            zzaVar = zza.zzhzf;
        }
        boolean z2 = false;
        zzdyk<V> zzdykVar = this;
        while (true) {
            if (zzhzd.zza((zzdyk<?>) zzdykVar, obj, (Object) zzaVar)) {
                if (z) {
                    zzdykVar.interruptTask();
                }
                zza((zzdyk<?>) zzdykVar);
                if (!(obj instanceof zzg)) {
                    return true;
                }
                zzdzw<? extends V> zzdzwVar = ((zzg) obj).future;
                if (zzdzwVar instanceof zzi) {
                    zzdykVar = (zzdyk) zzdzwVar;
                    obj = zzdykVar.value;
                    if (!(obj == null) && !(obj instanceof zzg)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    zzdzwVar.cancel(z);
                    return true;
                }
            } else {
                obj = zzdykVar.value;
                if (!(obj instanceof zzg)) {
                    return z2;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if ((obj != null) & (!(obj instanceof zzg))) {
                return (V) zzaf(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                zzk zzkVar = this.waiters;
                if (zzkVar != zzk.zzhzp) {
                    zzk zzkVar2 = new zzk();
                    do {
                        zzkVar2.zzb(zzkVar);
                        if (zzhzd.zza((zzdyk<?>) this, zzkVar, zzkVar2)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) & (!(obj2 instanceof zzg))) {
                                        return (V) zzaf(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    zza(zzkVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            zza(zzkVar2);
                        } else {
                            zzkVar = this.waiters;
                        }
                    } while (zzkVar != zzk.zzhzp);
                    return (V) zzaf(this.value);
                }
                return (V) zzaf(this.value);
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null) & (!(obj3 instanceof zzg))) {
                    return (V) zzaf(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String zzdykVar = toString();
            String timeUnit2 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = timeUnit2.toLowerCase(locale);
            String lowerCase2 = timeUnit.toString().toLowerCase(locale);
            StringBuilder sb = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
            sb.append("Waited ");
            sb.append(j2);
            sb.append(" ");
            sb.append(lowerCase2);
            String sb2 = sb.toString();
            if (nanos + 1000 < 0) {
                String concat = String.valueOf(sb2).concat(" (plus ");
                long j3 = -nanos;
                long convert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit.toNanos(convert);
                int i2 = (convert > 0L ? 1 : (convert == 0L ? 0 : -1));
                boolean z = i2 == 0 || nanos2 > 1000;
                if (i2 > 0) {
                    String valueOf = String.valueOf(concat);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 21 + String.valueOf(lowerCase).length());
                    sb3.append(valueOf);
                    sb3.append(convert);
                    sb3.append(" ");
                    sb3.append(lowerCase);
                    String sb4 = sb3.toString();
                    if (z) {
                        sb4 = String.valueOf(sb4).concat(",");
                    }
                    concat = String.valueOf(sb4).concat(" ");
                }
                if (z) {
                    String valueOf2 = String.valueOf(concat);
                    StringBuilder sb5 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
                    sb5.append(valueOf2);
                    sb5.append(nanos2);
                    sb5.append(" nanoseconds ");
                    concat = sb5.toString();
                }
                sb2 = String.valueOf(concat).concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(String.valueOf(sb2).concat(" but future completed as timeout expired"));
            }
            StringBuilder sb6 = new StringBuilder(String.valueOf(sb2).length() + 5 + String.valueOf(zzdykVar).length());
            sb6.append(sb2);
            sb6.append(" for ");
            sb6.append(zzdykVar);
            throw new TimeoutException(sb6.toString());
        }
        throw new InterruptedException();
    }

    protected void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof zza;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof zzg)) & (obj != null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void maybePropagateCancellationTo(@NullableDecl Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NullableDecl
    public String pendingToString() {
        if (this instanceof ScheduledFuture) {
            long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
            StringBuilder sb = new StringBuilder(41);
            sb.append("remaining delay=[");
            sb.append(delay);
            sb.append(" ms]");
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean set(@NullableDecl V v) {
        if (v == null) {
            v = (V) NULL;
        }
        if (zzhzd.zza((zzdyk<?>) this, (Object) null, (Object) v)) {
            zza((zzdyk<?>) this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setException(Throwable th) {
        if (zzhzd.zza((zzdyk<?>) this, (Object) null, (Object) new zzc((Throwable) zzdwl.checkNotNull(th)))) {
            zza((zzdyk<?>) this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean setFuture(zzdzw<? extends V> zzdzwVar) {
        zzc zzcVar;
        zzdwl.checkNotNull(zzdzwVar);
        Object obj = this.value;
        if (obj == null) {
            if (zzdzwVar.isDone()) {
                if (zzhzd.zza((zzdyk<?>) this, (Object) null, getFutureValue(zzdzwVar))) {
                    zza((zzdyk<?>) this);
                    return true;
                }
                return false;
            }
            zzg zzgVar = new zzg(this, zzdzwVar);
            if (zzhzd.zza((zzdyk<?>) this, (Object) null, (Object) zzgVar)) {
                try {
                    zzdzwVar.addListener(zzgVar, zzdzd.INSTANCE);
                } catch (Throwable th) {
                    try {
                        zzcVar = new zzc(th);
                    } catch (Throwable unused) {
                        zzcVar = zzc.zzhzg;
                    }
                    zzhzd.zza((zzdyk<?>) this, (Object) zzgVar, (Object) zzcVar);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof zza) {
            zzdzwVar.cancel(((zza) obj).wasInterrupted);
        }
        return false;
    }

    public String toString() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb2.append(getClass().getSimpleName());
        } else {
            sb2.append(getClass().getName());
        }
        sb2.append('@');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            zza(sb2);
        } else {
            int length = sb2.length();
            sb2.append("PENDING");
            Object obj = this.value;
            if (obj instanceof zzg) {
                sb2.append(", setFuture=[");
                zza(sb2, ((zzg) obj).future);
                sb2.append("]");
            } else {
                try {
                    sb = zzdwt.emptyToNull(pendingToString());
                } catch (RuntimeException | StackOverflowError e2) {
                    String valueOf = String.valueOf(e2.getClass());
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 38);
                    sb3.append("Exception thrown from implementation: ");
                    sb3.append(valueOf);
                    sb = sb3.toString();
                }
                if (sb != null) {
                    sb2.append(", info=[");
                    sb2.append(sb);
                    sb2.append("]");
                }
            }
            if (isDone()) {
                sb2.delete(length, sb2.length());
                zza(sb2);
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof zza) && ((zza) obj).wasInterrupted;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeao
    @NullableDecl
    public final Throwable zzazt() {
        if (this instanceof zzi) {
            Object obj = this.value;
            if (obj instanceof zzc) {
                return ((zzc) obj).exception;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.google.android.gms.internal.ads.zzdyk$zzb] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.android.gms.internal.ads.zzdyk<?>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.gms.internal.ads.zzdyk] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.google.android.gms.internal.ads.zzdyk<V>, com.google.android.gms.internal.ads.zzdyk] */
    public static void zza(zzdyk<?> zzdykVar) {
        zze zzeVar;
        zze zzeVar2;
        zze zzeVar3 = null;
        while (true) {
            zzk zzkVar = ((zzdyk) zzdykVar).waiters;
            if (zzhzd.zza((zzdyk) zzdykVar, zzkVar, zzk.zzhzp)) {
                while (zzkVar != null) {
                    Thread thread = zzkVar.thread;
                    if (thread != null) {
                        zzkVar.thread = null;
                        LockSupport.unpark(thread);
                    }
                    zzkVar = zzkVar.next;
                }
                ((zzdyk) zzdykVar).afterDone();
                do {
                    zzeVar = ((zzdyk) zzdykVar).listeners;
                } while (!zzhzd.zza((zzdyk) zzdykVar, zzeVar, zze.zzhzh));
                while (true) {
                    zzeVar2 = zzeVar3;
                    zzeVar3 = zzeVar;
                    if (zzeVar3 == null) {
                        break;
                    }
                    zzeVar = zzeVar3.next;
                    zzeVar3.next = zzeVar2;
                }
                while (zzeVar2 != null) {
                    zzeVar3 = zzeVar2.next;
                    Runnable runnable = zzeVar2.task;
                    if (runnable instanceof zzg) {
                        zzg zzgVar = (zzg) runnable;
                        zzdykVar = zzgVar.zzhzi;
                        if (((zzdyk) zzdykVar).value == zzgVar) {
                            if (!zzhzd.zza(zzdykVar, zzgVar, getFutureValue(zzgVar.future))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        zza(runnable, zzeVar2.executor);
                    }
                    zzeVar2 = zzeVar3;
                }
                return;
            }
        }
    }

    private final void zza(StringBuilder sb) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            zza(sb, uninterruptibly);
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    private final void zza(StringBuilder sb, Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (RuntimeException | StackOverflowError e2) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e2.getClass());
        }
    }

    private static void zza(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = zzhzc;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", sb.toString(), (Throwable) e2);
        }
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) & (!(obj2 instanceof zzg))) {
                return (V) zzaf(obj2);
            }
            zzk zzkVar = this.waiters;
            if (zzkVar != zzk.zzhzp) {
                zzk zzkVar2 = new zzk();
                do {
                    zzkVar2.zzb(zzkVar);
                    if (zzhzd.zza((zzdyk<?>) this, zzkVar, zzkVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                zza(zzkVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof zzg))));
                        return (V) zzaf(obj);
                    }
                    zzkVar = this.waiters;
                } while (zzkVar != zzk.zzhzp);
                return (V) zzaf(this.value);
            }
            return (V) zzaf(this.value);
        }
        throw new InterruptedException();
    }
}
