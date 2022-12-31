package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref$ObjectRef;
/* compiled from: Collect.kt */
/* loaded from: classes3.dex */
public final class FlowKt__ReduceKt$reduce$$inlined$collect$1 implements d<T> {
    final /* synthetic */ Ref$ObjectRef a;
    final /* synthetic */ kotlin.jvm.b.q b;

    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1", f = "Reduce.kt", i = {}, l = {137}, m = "emit", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ReduceKt$reduce$$inlined$collect$1.this.emit(null, this);
        }
    }

    public FlowKt__ReduceKt$reduce$$inlined$collect$1(Ref$ObjectRef ref$ObjectRef, kotlin.jvm.b.q qVar) {
        this.a = ref$ObjectRef;
        this.b = qVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    @Override // kotlinx.coroutines.flow.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object emit(T r7, kotlin.coroutines.Continuation<? super kotlin.u> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref$ObjectRef) r7
            kotlin.j.b(r8)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L58
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            kotlin.j.b(r8)
            kotlin.jvm.internal.Ref$ObjectRef r8 = r6.a
            T r2 = r8.element
            kotlinx.coroutines.internal.c0 r4 = kotlinx.coroutines.flow.internal.n.a
            if (r2 == r4) goto L58
            kotlin.jvm.b.q r4 = r6.b
            r0.L$0 = r8
            r0.label = r3
            r3 = 6
            kotlin.jvm.internal.r.c(r3)
            java.lang.Object r7 = r4.invoke(r2, r7, r0)
            r0 = 7
            kotlin.jvm.internal.r.c(r0)
            if (r7 != r1) goto L58
            return r1
        L58:
            r8.element = r7
            kotlin.u r7 = kotlin.u.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
