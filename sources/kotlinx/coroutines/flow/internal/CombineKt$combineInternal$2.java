package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.g0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.m0;
/* compiled from: Combine.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {57, 79, 82}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
/* loaded from: classes3.dex */
final class CombineKt$combineInternal$2 extends SuspendLambda implements kotlin.jvm.b.p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ kotlin.jvm.b.a<T[]> $arrayFactory;
    final /* synthetic */ kotlinx.coroutines.flow.c<T>[] $flows;
    final /* synthetic */ kotlinx.coroutines.flow.d<R> $this_combineInternal;
    final /* synthetic */ kotlin.jvm.b.q<kotlinx.coroutines.flow.d<? super R>, T[], Continuation<? super u>, Object> $transform;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Combine.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ kotlinx.coroutines.flow.c<T>[] $flows;
        final /* synthetic */ int $i;
        final /* synthetic */ AtomicInteger $nonClosed;
        final /* synthetic */ kotlinx.coroutines.channels.e<g0<Object>> $resultChannel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(kotlinx.coroutines.flow.c<? extends T>[] cVarArr, int i2, AtomicInteger atomicInteger, kotlinx.coroutines.channels.e<g0<Object>> eVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$flows = cVarArr;
            this.$i = i2;
            this.$nonClosed = atomicInteger;
            this.$resultChannel = eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            AtomicInteger atomicInteger;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    kotlin.j.b(obj);
                    kotlinx.coroutines.flow.c[] cVarArr = this.$flows;
                    int i3 = this.$i;
                    kotlinx.coroutines.flow.c cVar = cVarArr[i3];
                    CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 = new CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1(this.$resultChannel, i3);
                    this.label = 1;
                    if (cVar.d(combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    kotlin.j.b(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    s.a.a(this.$resultChannel, null, 1, null);
                }
                return u.a;
            } finally {
                if (this.$nonClosed.decrementAndGet() == 0) {
                    s.a.a(this.$resultChannel, null, 1, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(kotlinx.coroutines.flow.c<? extends T>[] cVarArr, kotlin.jvm.b.a<T[]> aVar, kotlin.jvm.b.q<? super kotlinx.coroutines.flow.d<? super R>, ? super T[], ? super Continuation<? super u>, ? extends Object> qVar, kotlinx.coroutines.flow.d<? super R> dVar, Continuation<? super CombineKt$combineInternal$2> continuation) {
        super(2, continuation);
        this.$flows = cVarArr;
        this.$arrayFactory = aVar;
        this.$transform = qVar;
        this.$this_combineInternal = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, continuation);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((CombineKt$combineInternal$2) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f1 A[LOOP:0: B:32:0x00f1->B:39:0x0115, LOOP_START, PHI: r3 r10 
      PHI: (r3v3 int) = (r3v2 int), (r3v4 int) binds: [B:29:0x00ec, B:39:0x0115] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r10v5 kotlin.collections.g0) = (r10v4 kotlin.collections.g0), (r10v18 kotlin.collections.g0) binds: [B:29:0x00ec, B:39:0x0115] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.flow.c<T>[]] */
    /* JADX WARN: Type inference failed for: r7v4, types: [kotlinx.coroutines.flow.c[], kotlinx.coroutines.flow.c<T>[]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x013a -> B:24:0x00cc). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x016f -> B:50:0x016b). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
