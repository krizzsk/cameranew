package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* compiled from: Collect.kt */
/* loaded from: classes3.dex */
public final class CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 implements kotlinx.coroutines.flow.d<T> {
    final /* synthetic */ kotlinx.coroutines.channels.e a;
    final /* synthetic */ int b;

    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1", f = "Combine.kt", i = {}, l = {135, 136}, m = "emit", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1$1  reason: invalid class name */
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
            return CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1(kotlinx.coroutines.channels.e eVar, int i2) {
        this.a = eVar;
        this.b = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0055 A[RETURN] */
    @Override // kotlinx.coroutines.flow.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object emit(T r7, kotlin.coroutines.Continuation<? super kotlin.u> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.j.b(r8)
            goto L56
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            kotlin.j.b(r8)
            goto L4d
        L38:
            kotlin.j.b(r8)
            kotlinx.coroutines.channels.e r8 = r6.a
            kotlin.collections.g0 r2 = new kotlin.collections.g0
            int r5 = r6.b
            r2.<init>(r5, r7)
            r0.label = r4
            java.lang.Object r7 = r8.D(r2, r0)
            if (r7 != r1) goto L4d
            return r1
        L4d:
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.c3.a(r0)
            if (r7 != r1) goto L56
            return r1
        L56:
            kotlin.u r7 = kotlin.u.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
