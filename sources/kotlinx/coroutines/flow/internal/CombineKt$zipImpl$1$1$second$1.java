package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.internal.c0;
/* compiled from: Combine.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1", f = "Combine.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class CombineKt$zipImpl$1$1$second$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.channels.n<? super Object>, Continuation<? super u>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.c<T2> $flow2;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: Collect.kt */
    /* loaded from: classes3.dex */
    public static final class a implements kotlinx.coroutines.flow.d<T2> {
        final /* synthetic */ kotlinx.coroutines.channels.n a;

        public a(kotlinx.coroutines.channels.n nVar) {
            this.a = nVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.d
        public Object emit(T2 t2, Continuation<? super u> continuation) {
            Object coroutine_suspended;
            s v = this.a.v();
            c0 c0Var = t2;
            if (t2 == 0) {
                c0Var = n.a;
            }
            Object D = v.D(c0Var, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return D == coroutine_suspended ? D : u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1$second$1(kotlinx.coroutines.flow.c<? extends T2> cVar, Continuation<? super CombineKt$zipImpl$1$1$second$1> continuation) {
        super(2, continuation);
        this.$flow2 = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        CombineKt$zipImpl$1$1$second$1 combineKt$zipImpl$1$1$second$1 = new CombineKt$zipImpl$1$1$second$1(this.$flow2, continuation);
        combineKt$zipImpl$1$1$second$1.L$0 = obj;
        return combineKt$zipImpl$1$1$second$1;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.n<? super Object> nVar, Continuation<? super u> continuation) {
        return invoke2((kotlinx.coroutines.channels.n<Object>) nVar, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.channels.n<Object> nVar, Continuation<? super u> continuation) {
        return ((CombineKt$zipImpl$1$1$second$1) create(nVar, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            kotlinx.coroutines.flow.c<T2> cVar = this.$flow2;
            a aVar = new a((kotlinx.coroutines.channels.n) this.L$0);
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
