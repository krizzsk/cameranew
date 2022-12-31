package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref$BooleanRef;
/* compiled from: Collect.kt */
/* loaded from: classes3.dex */
public final class StartedLazily$command$1$invokeSuspend$$inlined$collect$1 implements d<Integer> {
    final /* synthetic */ Ref$BooleanRef a;
    final /* synthetic */ d b;

    @DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1", f = "SharingStarted.kt", i = {}, l = {137}, m = "emit", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StartedLazily$command$1$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public StartedLazily$command$1$invokeSuspend$$inlined$collect$1(Ref$BooleanRef ref$BooleanRef, d dVar) {
        this.a = ref$BooleanRef;
        this.b = dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @Override // kotlinx.coroutines.flow.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object emit(java.lang.Integer r5, kotlin.coroutines.Continuation<? super kotlin.u> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1$1 r0 = (kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1$1 r0 = new kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.j.b(r6)
            goto L51
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.j.b(r6)
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            if (r5 <= 0) goto L51
            kotlin.jvm.internal.Ref$BooleanRef r5 = r4.a
            boolean r6 = r5.element
            if (r6 != 0) goto L51
            r5.element = r3
            kotlinx.coroutines.flow.d r5 = r4.b
            kotlinx.coroutines.flow.SharingCommand r6 = kotlinx.coroutines.flow.SharingCommand.START
            r0.label = r3
            java.lang.Object r5 = r5.emit(r6, r0)
            if (r5 != r1) goto L51
            return r1
        L51:
            kotlin.u r5 = kotlin.u.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
