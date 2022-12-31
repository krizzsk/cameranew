package kotlin.coroutines.intrinsics;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import kotlin.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IntrinsicsJvm.kt */
/* loaded from: classes3.dex */
public class IntrinsicsKt__IntrinsicsJvmKt {
    private static final <T> Continuation<u> createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(final Continuation<? super T> continuation, final l<? super Continuation<? super T>, ? extends Object> lVar) {
        final CoroutineContext context = continuation.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(continuation, lVar) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1
                final /* synthetic */ l<Continuation<? super T>, Object> $block;
                private int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(continuation);
                    this.$block = lVar;
                    s.f(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object obj) {
                    int i2 = this.label;
                    if (i2 == 0) {
                        this.label = 1;
                        j.b(obj);
                        return this.$block.invoke(this);
                    } else if (i2 == 1) {
                        this.label = 2;
                        j.b(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        }
        return new ContinuationImpl(continuation, context, lVar) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2
            final /* synthetic */ l<Continuation<? super T>, Object> $block;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(continuation, context);
                this.$block = lVar;
                s.f(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj) {
                int i2 = this.label;
                if (i2 == 0) {
                    this.label = 1;
                    j.b(obj);
                    return this.$block.invoke(this);
                } else if (i2 == 1) {
                    this.label = 2;
                    j.b(obj);
                    return obj;
                } else {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
            }
        };
    }

    public static <T> Continuation<u> createCoroutineUnintercepted(final l<? super Continuation<? super T>, ? extends Object> lVar, Continuation<? super T> completion) {
        s.h(lVar, "<this>");
        s.h(completion, "completion");
        final Continuation<?> probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(completion);
        if (lVar instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) lVar).create(probeCoroutineCreated);
        }
        final CoroutineContext context = probeCoroutineCreated.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(probeCoroutineCreated, lVar) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
                final /* synthetic */ l $this_createCoroutineUnintercepted$inlined;
                private int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(probeCoroutineCreated);
                    this.$this_createCoroutineUnintercepted$inlined = lVar;
                    s.f(probeCoroutineCreated, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object obj) {
                    int i2 = this.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            this.label = 2;
                            j.b(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    j.b(obj);
                    s.f(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda-0>, kotlin.Any?>");
                    l lVar2 = this.$this_createCoroutineUnintercepted$inlined;
                    y.d(lVar2, 1);
                    return lVar2.invoke(this);
                }
            };
        }
        return new ContinuationImpl(probeCoroutineCreated, context, lVar) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
            final /* synthetic */ l $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(probeCoroutineCreated, context);
                this.$this_createCoroutineUnintercepted$inlined = lVar;
                s.f(probeCoroutineCreated, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj) {
                int i2 = this.label;
                if (i2 != 0) {
                    if (i2 == 1) {
                        this.label = 2;
                        j.b(obj);
                        return obj;
                    }
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 1;
                j.b(obj);
                s.f(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda-0>, kotlin.Any?>");
                l lVar2 = this.$this_createCoroutineUnintercepted$inlined;
                y.d(lVar2, 1);
                return lVar2.invoke(this);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Continuation<T> intercepted(Continuation<? super T> continuation) {
        Continuation<T> continuation2;
        s.h(continuation, "<this>");
        ContinuationImpl continuationImpl = continuation instanceof ContinuationImpl ? (ContinuationImpl) continuation : null;
        return (continuationImpl == null || (continuation2 = (Continuation<T>) continuationImpl.intercepted()) == null) ? continuation : continuation2;
    }

    private static final <T> Object startCoroutineUninterceptedOrReturn(l<? super Continuation<? super T>, ? extends Object> lVar, Continuation<? super T> completion) {
        s.h(lVar, "<this>");
        s.h(completion, "completion");
        y.d(lVar, 1);
        return lVar.invoke(completion);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R, T> Object startCoroutineUninterceptedOrReturn(p<? super R, ? super Continuation<? super T>, ? extends Object> pVar, R r, Continuation<? super T> completion) {
        s.h(pVar, "<this>");
        s.h(completion, "completion");
        y.d(pVar, 2);
        return pVar.invoke(r, completion);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R, P, T> Object startCoroutineUninterceptedOrReturn(q<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> qVar, R r, P p, Continuation<? super T> completion) {
        s.h(qVar, "<this>");
        s.h(completion, "completion");
        y.d(qVar, 3);
        return qVar.invoke(r, p, completion);
    }

    public static <R, T> Continuation<u> createCoroutineUnintercepted(final p<? super R, ? super Continuation<? super T>, ? extends Object> pVar, final R r, Continuation<? super T> completion) {
        s.h(pVar, "<this>");
        s.h(completion, "completion");
        final Continuation<?> probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(completion);
        if (pVar instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) pVar).create(r, probeCoroutineCreated);
        }
        final CoroutineContext context = probeCoroutineCreated.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(probeCoroutineCreated, pVar, r) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
                final /* synthetic */ Object $receiver$inlined;
                final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
                private int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(probeCoroutineCreated);
                    this.$this_createCoroutineUnintercepted$inlined = pVar;
                    this.$receiver$inlined = r;
                    s.f(probeCoroutineCreated, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object obj) {
                    int i2 = this.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            this.label = 2;
                            j.b(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    j.b(obj);
                    s.f(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda-1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda-1>, kotlin.Any?>");
                    p pVar2 = this.$this_createCoroutineUnintercepted$inlined;
                    y.d(pVar2, 2);
                    return pVar2.invoke(this.$receiver$inlined, this);
                }
            };
        }
        return new ContinuationImpl(probeCoroutineCreated, context, pVar, r) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
            final /* synthetic */ Object $receiver$inlined;
            final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(probeCoroutineCreated, context);
                this.$this_createCoroutineUnintercepted$inlined = pVar;
                this.$receiver$inlined = r;
                s.f(probeCoroutineCreated, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj) {
                int i2 = this.label;
                if (i2 != 0) {
                    if (i2 == 1) {
                        this.label = 2;
                        j.b(obj);
                        return obj;
                    }
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 1;
                j.b(obj);
                s.f(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda-1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda-1>, kotlin.Any?>");
                p pVar2 = this.$this_createCoroutineUnintercepted$inlined;
                y.d(pVar2, 2);
                return pVar2.invoke(this.$receiver$inlined, this);
            }
        };
    }
}
