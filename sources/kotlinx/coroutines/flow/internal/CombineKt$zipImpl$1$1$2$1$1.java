package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u;
import kotlinx.coroutines.channels.ReceiveChannel;
/* compiled from: Combine.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", i = {}, l = {132, 135, 135}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class CombineKt$zipImpl$1$1$2$1$1 extends SuspendLambda implements kotlin.jvm.b.p<u, Continuation<? super u>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $second;
    final /* synthetic */ kotlinx.coroutines.flow.d<R> $this_unsafeFlow;
    final /* synthetic */ kotlin.jvm.b.q<T1, T2, Continuation<? super R>, Object> $transform;
    final /* synthetic */ T1 $value;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1$2$1$1(ReceiveChannel<? extends Object> receiveChannel, kotlinx.coroutines.flow.d<? super R> dVar, kotlin.jvm.b.q<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> qVar, T1 t1, Continuation<? super CombineKt$zipImpl$1$1$2$1$1> continuation) {
        super(2, continuation);
        this.$second = receiveChannel;
        this.$this_unsafeFlow = dVar;
        this.$transform = qVar;
        this.$value = t1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new CombineKt$zipImpl$1$1$2$1$1(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(u uVar, Continuation<? super u> continuation) {
        return ((CombineKt$zipImpl$1$1$2$1$1) create(uVar, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006e A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L30
            if (r1 == r5) goto L26
            if (r1 == r4) goto L1e
            if (r1 != r3) goto L16
            kotlin.j.b(r9)
            goto L6f
        L16:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1e:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            kotlin.j.b(r9)
            goto L64
        L26:
            kotlin.j.b(r9)
            kotlinx.coroutines.channels.h r9 = (kotlinx.coroutines.channels.h) r9
            java.lang.Object r9 = r9.l()
            goto L3e
        L30:
            kotlin.j.b(r9)
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r9 = r8.$second
            r8.label = r5
            java.lang.Object r9 = r9.z(r8)
            if (r9 != r0) goto L3e
            return r0
        L3e:
            kotlinx.coroutines.flow.d<R> r1 = r8.$this_unsafeFlow
            boolean r5 = r9 instanceof kotlinx.coroutines.channels.h.c
            if (r5 == 0) goto L50
            java.lang.Throwable r9 = kotlinx.coroutines.channels.h.e(r9)
            if (r9 != 0) goto L4f
            kotlinx.coroutines.flow.internal.AbortFlowException r9 = new kotlinx.coroutines.flow.internal.AbortFlowException
            r9.<init>(r1)
        L4f:
            throw r9
        L50:
            kotlin.jvm.b.q<T1, T2, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r5 = r8.$transform
            T1 r6 = r8.$value
            kotlinx.coroutines.internal.c0 r7 = kotlinx.coroutines.flow.internal.n.a
            if (r9 != r7) goto L59
            r9 = r2
        L59:
            r8.L$0 = r1
            r8.label = r4
            java.lang.Object r9 = r5.invoke(r6, r9, r8)
            if (r9 != r0) goto L64
            return r0
        L64:
            r8.L$0 = r2
            r8.label = r3
            java.lang.Object r9 = r1.emit(r9, r8)
            if (r9 != r0) goto L6f
            return r0
        L6f:
            kotlin.u r9 = kotlin.u.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
