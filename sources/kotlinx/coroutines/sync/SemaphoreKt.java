package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.f0;
/* compiled from: Semaphore.kt */
/* loaded from: classes3.dex */
public final class SemaphoreKt {
    private static final int a;
    private static final c0 b;
    private static final c0 c;

    /* renamed from: d  reason: collision with root package name */
    private static final c0 f8833d;

    /* renamed from: e  reason: collision with root package name */
    private static final c0 f8834e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f8835f;

    static {
        int d2;
        int d3;
        d2 = f0.d("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        a = d2;
        b = new c0("PERMIT");
        c = new c0("TAKEN");
        f8833d = new c0("BROKEN");
        f8834e = new c0("CANCELLED");
        d3 = f0.d("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
        f8835f = d3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f h(long j2, f fVar) {
        return new f(j2, fVar, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object i(kotlinx.coroutines.sync.d r4, kotlin.jvm.b.a<? extends T> r5, kotlin.coroutines.Continuation<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = (kotlinx.coroutines.sync.SemaphoreKt$withPermit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = new kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r5 = r4
            kotlin.jvm.b.a r5 = (kotlin.jvm.b.a) r5
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.d r4 = (kotlinx.coroutines.sync.d) r4
            kotlin.j.b(r6)
            goto L4a
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.j.b(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.a(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            java.lang.Object r5 = r5.invoke()     // Catch: java.lang.Throwable -> L58
            kotlin.jvm.internal.r.b(r3)
            r4.release()
            kotlin.jvm.internal.r.a(r3)
            return r5
        L58:
            r5 = move-exception
            kotlin.jvm.internal.r.b(r3)
            r4.release()
            kotlin.jvm.internal.r.a(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreKt.i(kotlinx.coroutines.sync.d, kotlin.jvm.b.a, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
