package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.v1;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Errors.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class FlowKt__ErrorsKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object a(kotlinx.coroutines.flow.c<? extends T> r4, kotlinx.coroutines.flow.d<? super T> r5, kotlin.coroutines.Continuation<? super java.lang.Throwable> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref$ObjectRef) r4
            kotlin.j.b(r6)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r5 = move-exception
            goto L53
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.j.b(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1 r2 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1     // Catch: java.lang.Throwable -> L51
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L51
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L51
            r0.label = r3     // Catch: java.lang.Throwable -> L51
            java.lang.Object r4 = r4.d(r2, r0)     // Catch: java.lang.Throwable -> L51
            if (r4 != r1) goto L4f
            return r1
        L4f:
            r4 = 0
            return r4
        L51:
            r5 = move-exception
            r4 = r6
        L53:
            T r4 = r4.element
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r4 = c(r5, r4)
            if (r4 != 0) goto L68
            kotlin.coroutines.CoroutineContext r4 = r0.getContext()
            boolean r4 = b(r5, r4)
            if (r4 != 0) goto L68
            return r5
        L68:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt.a(kotlinx.coroutines.flow.c, kotlinx.coroutines.flow.d, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final boolean b(Throwable th, CoroutineContext coroutineContext) {
        v1 v1Var = (v1) coroutineContext.get(v1.b0);
        if (v1Var == null || !v1Var.isCancelled()) {
            return false;
        }
        return c(th, v1Var.t());
    }

    private static final boolean c(Throwable th, Throwable th2) {
        if (th2 != null) {
            if (kotlinx.coroutines.o0.d()) {
                th2 = kotlinx.coroutines.internal.b0.n(th2);
            }
            if (kotlinx.coroutines.o0.d()) {
                th = kotlinx.coroutines.internal.b0.n(th);
            }
            if (kotlin.jvm.internal.s.c(th2, th)) {
                return true;
            }
        }
        return false;
    }
}
