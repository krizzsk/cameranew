package kotlinx.coroutines;

import androidx.core.location.LocationRequestCompat;
/* compiled from: EventLoop.common.kt */
/* loaded from: classes3.dex */
public final class j1 {
    private static final kotlinx.coroutines.internal.c0 a = new kotlinx.coroutines.internal.c0("REMOVED_TASK");
    private static final kotlinx.coroutines.internal.c0 b = new kotlinx.coroutines.internal.c0("CLOSED_EMPTY");

    public static final long c(long j2) {
        return j2 / 1000000;
    }

    public static final long d(long j2) {
        if (j2 <= 0) {
            return 0L;
        }
        return j2 >= 9223372036854L ? LocationRequestCompat.PASSIVE_INTERVAL : 1000000 * j2;
    }
}
