package us.pinguo.edit2020.utils;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerExtension.kt */
@DebugMetadata(c = "us.pinguo.edit2020.utils.FlowObserver$1$1", f = "StaticStickerExtension.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class FlowObserver$1$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int label;
    final /* synthetic */ FlowObserver<T> this$0;

    /* compiled from: Collect.kt */
    /* loaded from: classes4.dex */
    public static final class a implements kotlinx.coroutines.flow.d<T> {
        final /* synthetic */ FlowObserver a;

        public a(FlowObserver flowObserver) {
            this.a = flowObserver;
        }

        @Override // kotlinx.coroutines.flow.d
        public Object emit(T t, Continuation<? super u> continuation) {
            p pVar;
            Object coroutine_suspended;
            pVar = this.a.b;
            Object invoke = pVar.invoke(t, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return invoke == coroutine_suspended ? invoke : u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowObserver$1$1(FlowObserver<T> flowObserver, Continuation<? super FlowObserver$1$1> continuation) {
        super(2, continuation);
        this.this$0 = flowObserver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FlowObserver$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FlowObserver$1$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        kotlinx.coroutines.flow.c cVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            cVar = ((FlowObserver) this.this$0).a;
            a aVar = new a(this.this$0);
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
