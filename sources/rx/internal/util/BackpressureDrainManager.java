package rx.internal.util;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.annotations.Experimental;
@Experimental
/* loaded from: classes3.dex */
public final class BackpressureDrainManager extends AtomicLong implements Producer {
    protected final BackpressureQueueCallback actual;
    protected boolean emitting;
    protected Throwable exception;
    protected volatile boolean terminated;

    /* loaded from: classes3.dex */
    public interface BackpressureQueueCallback {
        boolean accept(Object obj);

        void complete(Throwable th);

        Object peek();

        Object poll();
    }

    public BackpressureDrainManager(BackpressureQueueCallback backpressureQueueCallback) {
        this.actual = backpressureQueueCallback;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
        if (r9 == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0036, code lost:
        monitor-enter(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0037, code lost:
        r1 = r13.terminated;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
        if (r5.peek() == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003f, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0041, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (get() != androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004f, code lost:
        if (r2 != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0051, code lost:
        if (r1 != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0053, code lost:
        r13.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0055, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0056, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0057, code lost:
        r2 = Long.MAX_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x005b, code lost:
        r9 = addAndGet(-r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0061, code lost:
        if (r9 == 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0063, code lost:
        if (r2 != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0065, code lost:
        if (r1 == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0067, code lost:
        if (r2 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006a, code lost:
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x006d, code lost:
        r13.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x006f, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0070, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0071, code lost:
        r1 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0073, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0074, code lost:
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drain() {
        /*
            r13 = this;
            monitor-enter(r13)
            boolean r0 = r13.emitting     // Catch: java.lang.Throwable -> L91
            if (r0 == 0) goto L7
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L91
            return
        L7:
            r0 = 1
            r13.emitting = r0     // Catch: java.lang.Throwable -> L91
            boolean r1 = r13.terminated     // Catch: java.lang.Throwable -> L91
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L91
            long r2 = r13.get()
            r4 = 0
            rx.internal.util.BackpressureDrainManager$BackpressureQueueCallback r5 = r13.actual     // Catch: java.lang.Throwable -> L84
        L14:
            r6 = 0
        L15:
            r7 = 0
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 > 0) goto L1d
            if (r1 == 0) goto L36
        L1d:
            if (r1 == 0) goto L30
            java.lang.Object r10 = r5.peek()     // Catch: java.lang.Throwable -> L84
            if (r10 != 0) goto L2d
            java.lang.Throwable r1 = r13.exception     // Catch: java.lang.Throwable -> L2b
            r5.complete(r1)     // Catch: java.lang.Throwable -> L2b
            return
        L2b:
            r1 = move-exception
            goto L86
        L2d:
            if (r9 != 0) goto L30
            goto L36
        L30:
            java.lang.Object r9 = r5.poll()     // Catch: java.lang.Throwable -> L84
            if (r9 != 0) goto L77
        L36:
            monitor-enter(r13)     // Catch: java.lang.Throwable -> L84
            boolean r1 = r13.terminated     // Catch: java.lang.Throwable -> L71
            java.lang.Object r2 = r5.peek()     // Catch: java.lang.Throwable -> L71
            if (r2 == 0) goto L41
            r2 = 1
            goto L42
        L41:
            r2 = 0
        L42:
            long r9 = r13.get()     // Catch: java.lang.Throwable -> L71
            r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 != 0) goto L59
            if (r2 != 0) goto L57
            if (r1 != 0) goto L57
            r13.emitting = r4     // Catch: java.lang.Throwable -> L75
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L75
            return
        L57:
            r2 = r11
            goto L6b
        L59:
            int r3 = -r6
            long r9 = (long) r3
            long r9 = r13.addAndGet(r9)     // Catch: java.lang.Throwable -> L71
            int r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r3 == 0) goto L65
            if (r2 != 0) goto L6a
        L65:
            if (r1 == 0) goto L6d
            if (r2 == 0) goto L6a
            goto L6d
        L6a:
            r2 = r9
        L6b:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L71
            goto L14
        L6d:
            r13.emitting = r4     // Catch: java.lang.Throwable -> L75
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L75
            return
        L71:
            r1 = move-exception
            r0 = 0
        L73:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L75
            throw r1     // Catch: java.lang.Throwable -> L2b
        L75:
            r1 = move-exception
            goto L73
        L77:
            boolean r7 = r5.accept(r9)     // Catch: java.lang.Throwable -> L84
            if (r7 == 0) goto L7e
            return
        L7e:
            r7 = 1
            long r2 = r2 - r7
            int r6 = r6 + 1
            goto L15
        L84:
            r1 = move-exception
            r0 = 0
        L86:
            if (r0 != 0) goto L90
            monitor-enter(r13)
            r13.emitting = r4     // Catch: java.lang.Throwable -> L8d
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L8d
            goto L90
        L8d:
            r0 = move-exception
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L8d
            throw r0
        L90:
            throw r1
        L91:
            r0 = move-exception
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L91
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.BackpressureDrainManager.drain():void");
    }

    public final boolean isTerminated() {
        return this.terminated;
    }

    @Override // rx.Producer
    public final void request(long j2) {
        boolean z;
        if (j2 == 0) {
            return;
        }
        while (true) {
            long j3 = get();
            boolean z2 = true;
            z = j3 == 0;
            long j4 = LocationRequestCompat.PASSIVE_INTERVAL;
            if (j3 == LocationRequestCompat.PASSIVE_INTERVAL) {
                break;
            }
            if (j2 == LocationRequestCompat.PASSIVE_INTERVAL) {
                j4 = j2;
            } else {
                if (j3 <= LocationRequestCompat.PASSIVE_INTERVAL - j2) {
                    j4 = j3 + j2;
                }
                z2 = z;
            }
            if (compareAndSet(j3, j4)) {
                z = z2;
                break;
            }
        }
        if (z) {
            drain();
        }
    }

    public final void terminate() {
        this.terminated = true;
    }

    public final void terminateAndDrain() {
        this.terminated = true;
        drain();
    }

    public final void terminate(Throwable th) {
        if (this.terminated) {
            return;
        }
        this.exception = th;
        this.terminated = true;
    }

    public final void terminateAndDrain(Throwable th) {
        if (this.terminated) {
            return;
        }
        this.exception = th;
        this.terminated = true;
        drain();
    }
}
