package kotlinx.coroutines.channels;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.h;
import kotlinx.coroutines.m0;
/* compiled from: Channels.kt */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements kotlin.jvm.b.p<m0, Continuation<? super h<? extends kotlin.u>>, Object> {
    final /* synthetic */ E $element;
    final /* synthetic */ s<E> $this_trySendBlocking;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__ChannelsKt$trySendBlocking$2(s<? super E> sVar, E e2, Continuation<? super ChannelsKt__ChannelsKt$trySendBlocking$2> continuation) {
        super(2, continuation);
        this.$this_trySendBlocking = sVar;
        this.$element = e2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 channelsKt__ChannelsKt$trySendBlocking$2 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.$this_trySendBlocking, this.$element, continuation);
        channelsKt__ChannelsKt$trySendBlocking$2.L$0 = obj;
        return channelsKt__ChannelsKt$trySendBlocking$2;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Object invoke(m0 m0Var, Continuation<? super h<? extends kotlin.u>> continuation) {
        return invoke2(m0Var, (Continuation<? super h<kotlin.u>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(m0 m0Var, Continuation<? super h<kotlin.u>> continuation) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object m41constructorimpl;
        Object a;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        try {
            if (i2 == 0) {
                kotlin.j.b(obj);
                m0 m0Var = (m0) this.L$0;
                s<E> sVar = this.$this_trySendBlocking;
                E e2 = this.$element;
                Result.a aVar = Result.Companion;
                this.label = 1;
                if (sVar.D(e2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                kotlin.j.b(obj);
            }
            m41constructorimpl = Result.m41constructorimpl(kotlin.u.a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(kotlin.j.a(th));
        }
        if (Result.m48isSuccessimpl(m41constructorimpl)) {
            h.b bVar = h.b;
            a = kotlin.u.a;
            bVar.c(a);
        } else {
            a = h.b.a(Result.m44exceptionOrNullimpl(m41constructorimpl));
        }
        return h.b(a);
    }
}
