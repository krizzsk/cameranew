package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
/* loaded from: classes3.dex */
public final class BackpressureUtils {
    private BackpressureUtils() {
        throw new IllegalStateException("No instances!");
    }

    public static long addCap(long j2, long j3) {
        long j4 = j2 + j3;
        return j4 < 0 ? LocationRequestCompat.PASSIVE_INTERVAL : j4;
    }

    public static <T> long getAndAddRequest(AtomicLongFieldUpdater<T> atomicLongFieldUpdater, T t, long j2) {
        long j3;
        do {
            j3 = atomicLongFieldUpdater.get(t);
        } while (!atomicLongFieldUpdater.compareAndSet(t, j3, addCap(j3, j2)));
        return j3;
    }

    public static long multiplyCap(long j2, long j3) {
        long j4 = j2 * j3;
        return (((j2 | j3) >>> 31) == 0 || j3 == 0 || j4 / j3 == j2) ? j4 : LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public static long getAndAddRequest(AtomicLong atomicLong, long j2) {
        long j3;
        do {
            j3 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j3, addCap(j3, j2)));
        return j3;
    }
}
