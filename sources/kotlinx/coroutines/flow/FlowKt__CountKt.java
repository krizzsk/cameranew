package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref$IntRef;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Count.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class FlowKt__CountKt {

    /* compiled from: Collect.kt */
    /* loaded from: classes3.dex */
    public static final class a implements d<T> {
        final /* synthetic */ Ref$IntRef a;

        public a(Ref$IntRef ref$IntRef) {
            this.a = ref$IntRef;
        }

        @Override // kotlinx.coroutines.flow.d
        public Object emit(T t, Continuation<? super kotlin.u> continuation) {
            this.a.element++;
            return kotlin.u.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object a(kotlinx.coroutines.flow.c<? extends T> r4, kotlin.coroutines.Continuation<? super java.lang.Integer> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__CountKt$count$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__CountKt$count$1 r0 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__CountKt$count$1 r0 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref$IntRef) r4
            kotlin.j.b(r5)
            goto L4e
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.j.b(r5)
            kotlin.jvm.internal.Ref$IntRef r5 = new kotlin.jvm.internal.Ref$IntRef
            r5.<init>()
            kotlinx.coroutines.flow.FlowKt__CountKt$a r2 = new kotlinx.coroutines.flow.FlowKt__CountKt$a
            r2.<init>(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.d(r2, r0)
            if (r4 != r1) goto L4d
            return r1
        L4d:
            r4 = r5
        L4e:
            int r4 = r4.element
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CountKt.a(kotlinx.coroutines.flow.c, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object b(kotlinx.coroutines.flow.c<? extends T> r4, kotlin.jvm.b.p<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super java.lang.Integer> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__CountKt$count$3
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__CountKt$count$3 r0 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__CountKt$count$3 r0 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$3
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref$IntRef) r4
            kotlin.j.b(r6)
            goto L4e
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.j.b(r6)
            kotlin.jvm.internal.Ref$IntRef r6 = new kotlin.jvm.internal.Ref$IntRef
            r6.<init>()
            kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2 r2 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2
            r2.<init>(r5, r6)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r4 = r4.d(r2, r0)
            if (r4 != r1) goto L4d
            return r1
        L4d:
            r4 = r6
        L4e:
            int r4 = r4.element
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CountKt.b(kotlinx.coroutines.flow.c, kotlin.jvm.b.p, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
