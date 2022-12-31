package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref$IntRef;
/* compiled from: Collect.kt */
/* loaded from: classes3.dex */
public final class FlowKt__CountKt$count$$inlined$collect$2 implements d<T> {
    final /* synthetic */ kotlin.jvm.b.p a;
    final /* synthetic */ Ref$IntRef b;

    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2", f = "Count.kt", i = {0}, l = {135}, m = "emit", n = {"this"}, s = {"L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2$1  reason: invalid class name */
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
            return FlowKt__CountKt$count$$inlined$collect$2.this.emit(null, this);
        }
    }

    public FlowKt__CountKt$count$$inlined$collect$2(kotlin.jvm.b.p pVar, Ref$IntRef ref$IntRef) {
        this.a = pVar;
        this.b = ref$IntRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    @Override // kotlinx.coroutines.flow.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object emit(T r5, kotlin.coroutines.Continuation<? super kotlin.u> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2 r5 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2) r5
            kotlin.j.b(r6)
            goto L4e
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.j.b(r6)
            kotlin.jvm.b.p r6 = r4.a
            r0.L$0 = r4
            r0.label = r3
            r2 = 6
            kotlin.jvm.internal.r.c(r2)
            java.lang.Object r6 = r6.invoke(r5, r0)
            r5 = 7
            kotlin.jvm.internal.r.c(r5)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            r5 = r4
        L4e:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L5d
            kotlin.jvm.internal.Ref$IntRef r5 = r5.b
            int r6 = r5.element
            int r6 = r6 + r3
            r5.element = r6
        L5d:
            kotlin.u r5 = kotlin.u.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
