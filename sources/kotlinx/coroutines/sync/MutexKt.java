package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.c0;
/* compiled from: Mutex.kt */
/* loaded from: classes3.dex */
public final class MutexKt {
    private static final c0 a = new c0("LOCK_FAIL");
    private static final c0 b = new c0("UNLOCK_FAIL");
    private static final c0 c;

    /* renamed from: d */
    private static final c0 f8830d;

    /* renamed from: e */
    private static final b f8831e;

    /* renamed from: f */
    private static final b f8832f;

    static {
        c0 c0Var = new c0("LOCKED");
        c = c0Var;
        c0 c0Var2 = new c0("UNLOCKED");
        f8830d = c0Var2;
        f8831e = new b(c0Var);
        f8832f = new b(c0Var2);
    }

    public static final c a(boolean z) {
        return new MutexImpl(z);
    }

    public static /* synthetic */ c b(boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return a(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object h(kotlinx.coroutines.sync.c r4, java.lang.Object r5, kotlin.jvm.b.a<? extends T> r6, kotlin.coroutines.Continuation<? super T> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.sync.MutexKt$withLock$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = (kotlinx.coroutines.sync.MutexKt$withLock$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = new kotlinx.coroutines.sync.MutexKt$withLock$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$2
            r6 = r4
            kotlin.jvm.b.a r6 = (kotlin.jvm.b.a) r6
            java.lang.Object r5 = r0.L$1
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.c r4 = (kotlinx.coroutines.sync.c) r4
            kotlin.j.b(r7)
            goto L4e
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.j.b(r7)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r7 = r4.a(r5, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            java.lang.Object r6 = r6.invoke()     // Catch: java.lang.Throwable -> L5c
            kotlin.jvm.internal.r.b(r3)
            r4.b(r5)
            kotlin.jvm.internal.r.a(r3)
            return r6
        L5c:
            r6 = move-exception
            kotlin.jvm.internal.r.b(r3)
            r4.b(r5)
            kotlin.jvm.internal.r.a(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexKt.h(kotlinx.coroutines.sync.c, java.lang.Object, kotlin.jvm.b.a, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
