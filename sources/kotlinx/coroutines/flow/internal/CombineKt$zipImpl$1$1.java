package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.m0;
/* compiled from: Combine.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0}, l = {129}, m = "invokeSuspend", n = {"second"}, s = {"L$0"})
/* loaded from: classes3.dex */
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements kotlin.jvm.b.p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.c<T1> $flow;
    final /* synthetic */ kotlinx.coroutines.flow.c<T2> $flow2;
    final /* synthetic */ kotlinx.coroutines.flow.d<R> $this_unsafeFlow;
    final /* synthetic */ kotlin.jvm.b.q<T1, T2, Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Combine.kt */
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements kotlin.jvm.b.l<Throwable, u> {
        final /* synthetic */ a0 $collectJob;
        final /* synthetic */ kotlinx.coroutines.flow.d<R> $this_unsafeFlow;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(a0 a0Var, kotlinx.coroutines.flow.d<? super R> dVar) {
            super(1);
            this.$collectJob = a0Var;
            this.$this_unsafeFlow = dVar;
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ u invoke(Throwable th) {
            invoke2(th);
            return u.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            if (this.$collectJob.isActive()) {
                this.$collectJob.a(new AbortFlowException(this.$this_unsafeFlow));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Combine.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements kotlin.jvm.b.p<u, Continuation<? super u>, Object> {
        final /* synthetic */ Object $cnt;
        final /* synthetic */ kotlinx.coroutines.flow.c<T1> $flow;
        final /* synthetic */ CoroutineContext $scopeContext;
        final /* synthetic */ ReceiveChannel<Object> $second;
        final /* synthetic */ kotlinx.coroutines.flow.d<R> $this_unsafeFlow;
        final /* synthetic */ kotlin.jvm.b.q<T1, T2, Continuation<? super R>, Object> $transform;
        int label;

        /* compiled from: Collect.kt */
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$a */
        /* loaded from: classes3.dex */
        public static final class a implements kotlinx.coroutines.flow.d<T1> {
            final /* synthetic */ CoroutineContext a;
            final /* synthetic */ Object b;
            final /* synthetic */ ReceiveChannel c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.d f8754d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.b.q f8755e;

            public a(CoroutineContext coroutineContext, Object obj, ReceiveChannel receiveChannel, kotlinx.coroutines.flow.d dVar, kotlin.jvm.b.q qVar) {
                this.a = coroutineContext;
                this.b = obj;
                this.c = receiveChannel;
                this.f8754d = dVar;
                this.f8755e = qVar;
            }

            @Override // kotlinx.coroutines.flow.d
            public Object emit(T1 t1, Continuation<? super u> continuation) {
                Object coroutine_suspended;
                CoroutineContext coroutineContext = this.a;
                u uVar = u.a;
                Object b = d.b(coroutineContext, uVar, this.b, new CombineKt$zipImpl$1$1$2$1$1(this.c, this.f8754d, this.f8755e, t1, null), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return b == coroutine_suspended ? b : uVar;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(kotlinx.coroutines.flow.c<? extends T1> cVar, CoroutineContext coroutineContext, Object obj, ReceiveChannel<? extends Object> receiveChannel, kotlinx.coroutines.flow.d<? super R> dVar, kotlin.jvm.b.q<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> qVar, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$flow = cVar;
            this.$scopeContext = coroutineContext;
            this.$cnt = obj;
            this.$second = receiveChannel;
            this.$this_unsafeFlow = dVar;
            this.$transform = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$flow, this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(u uVar, Continuation<? super u> continuation) {
            return ((AnonymousClass2) create(uVar, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                kotlinx.coroutines.flow.c<T1> cVar = this.$flow;
                a aVar = new a(this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform);
                this.label = 1;
                if (cVar.d(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                kotlin.j.b(obj);
            }
            return u.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CombineKt$zipImpl$1$1(kotlinx.coroutines.flow.d<? super R> dVar, kotlinx.coroutines.flow.c<? extends T2> cVar, kotlinx.coroutines.flow.c<? extends T1> cVar2, kotlin.jvm.b.q<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> qVar, Continuation<? super CombineKt$zipImpl$1$1> continuation) {
        super(2, continuation);
        this.$this_unsafeFlow = dVar;
        this.$flow2 = cVar;
        this.$flow = cVar2;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.$this_unsafeFlow, this.$flow2, this.$flow, this.$transform, continuation);
        combineKt$zipImpl$1$1.L$0 = obj;
        return combineKt$zipImpl$1$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((CombineKt$zipImpl$1$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        a0 b;
        ReceiveChannel receiveChannel;
        ReceiveChannel receiveChannel2;
        CoroutineContext plus;
        u uVar;
        AnonymousClass2 anonymousClass2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ReceiveChannel receiveChannel3 = this.label;
        try {
            if (receiveChannel3 != 0) {
                if (receiveChannel3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                receiveChannel2 = (ReceiveChannel) this.L$0;
                try {
                    kotlin.j.b(obj);
                    receiveChannel3 = receiveChannel2;
                } catch (AbortFlowException e2) {
                    e = e2;
                }
                ReceiveChannel.DefaultImpls.a(receiveChannel3, null, 1, null);
                return u.a;
            }
            kotlin.j.b(obj);
            m0 m0Var = (m0) this.L$0;
            ReceiveChannel e3 = ProduceKt.e(m0Var, null, 0, new CombineKt$zipImpl$1$1$second$1(this.$flow2, null), 3, null);
            b = a2.b(null, 1, null);
            ((s) e3).m(new AnonymousClass1(b, this.$this_unsafeFlow));
            try {
                CoroutineContext coroutineContext = m0Var.getCoroutineContext();
                Object b2 = ThreadContextKt.b(coroutineContext);
                plus = m0Var.getCoroutineContext().plus(b);
                uVar = u.a;
                anonymousClass2 = new AnonymousClass2(this.$flow, coroutineContext, b2, e3, this.$this_unsafeFlow, this.$transform, null);
                this.L$0 = e3;
                this.label = 1;
                receiveChannel = e3;
                try {
                } catch (AbortFlowException e4) {
                    e = e4;
                    receiveChannel2 = receiveChannel;
                    j.a(e, this.$this_unsafeFlow);
                    receiveChannel3 = receiveChannel2;
                    ReceiveChannel.DefaultImpls.a(receiveChannel3, null, 1, null);
                    return u.a;
                } catch (Throwable th) {
                    th = th;
                    receiveChannel3 = receiveChannel;
                    ReceiveChannel.DefaultImpls.a(receiveChannel3, null, 1, null);
                    throw th;
                }
            } catch (AbortFlowException e5) {
                e = e5;
                receiveChannel = e3;
            } catch (Throwable th2) {
                th = th2;
                receiveChannel = e3;
            }
            if (d.c(plus, uVar, null, anonymousClass2, this, 4, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            receiveChannel3 = receiveChannel;
            ReceiveChannel.DefaultImpls.a(receiveChannel3, null, 1, null);
            return u.a;
            j.a(e, this.$this_unsafeFlow);
            receiveChannel3 = receiveChannel2;
            ReceiveChannel.DefaultImpls.a(receiveChannel3, null, 1, null);
            return u.a;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
