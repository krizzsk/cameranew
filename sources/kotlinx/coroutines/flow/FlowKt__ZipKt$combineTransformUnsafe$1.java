package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: Zip.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class FlowKt__ZipKt$combineTransformUnsafe$1 extends SuspendLambda implements kotlin.jvm.b.p<d<? super R>, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ c<T>[] $flows;
    final /* synthetic */ kotlin.jvm.b.q<d<? super R>, T[], Continuation<? super kotlin.u>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: Zip.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.q<d<? super R>, T[], Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ kotlin.jvm.b.q<d<? super R>, T[], Continuation<? super kotlin.u>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(kotlin.jvm.b.q<? super d<? super R>, ? super T[], ? super Continuation<? super kotlin.u>, ? extends Object> qVar, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.$transform = qVar;
        }

        @Override // kotlin.jvm.b.q
        public final Object invoke(d<? super R> dVar, T[] tArr, Continuation<? super kotlin.u> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, continuation);
            anonymousClass1.L$0 = dVar;
            anonymousClass1.L$1 = tArr;
            return anonymousClass1.invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                kotlin.jvm.b.q<d<? super R>, T[], Continuation<? super kotlin.u>, Object> qVar = this.$transform;
                this.L$0 = null;
                this.label = 1;
                if (qVar.invoke((d) this.L$0, (Object[]) this.L$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                kotlin.j.b(obj);
            }
            return kotlin.u.a;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            this.$transform.invoke((d) this.L$0, (Object[]) this.L$1, this);
            return kotlin.u.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combineTransformUnsafe$1(c<? extends T>[] cVarArr, kotlin.jvm.b.q<? super d<? super R>, ? super T[], ? super Continuation<? super kotlin.u>, ? extends Object> qVar, Continuation<? super FlowKt__ZipKt$combineTransformUnsafe$1> continuation) {
        super(2, continuation);
        this.$flows = cVarArr;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        FlowKt__ZipKt$combineTransformUnsafe$1 flowKt__ZipKt$combineTransformUnsafe$1 = new FlowKt__ZipKt$combineTransformUnsafe$1(this.$flows, this.$transform, continuation);
        flowKt__ZipKt$combineTransformUnsafe$1.L$0 = obj;
        return flowKt__ZipKt$combineTransformUnsafe$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(d<? super R> dVar, Continuation<? super kotlin.u> continuation) {
        return ((FlowKt__ZipKt$combineTransformUnsafe$1) create(dVar, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                kotlin.j.b(obj);
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.j.b(obj);
        d dVar = (d) this.L$0;
        FlowKt__ZipKt.b();
        kotlin.jvm.internal.s.m();
        throw null;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        d dVar = (d) this.L$0;
        FlowKt__ZipKt.b();
        kotlin.jvm.internal.s.m();
        throw null;
    }
}
