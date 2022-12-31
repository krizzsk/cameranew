package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: Deprecated.kt */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1", f = "Deprecated.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$filterNot$1 extends SuspendLambda implements kotlin.jvm.b.p<E, Continuation<? super Boolean>, Object> {
    final /* synthetic */ kotlin.jvm.b.p<E, Continuation<? super Boolean>, Object> $predicate;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__DeprecatedKt$filterNot$1(kotlin.jvm.b.p<? super E, ? super Continuation<? super Boolean>, ? extends Object> pVar, Continuation<? super ChannelsKt__DeprecatedKt$filterNot$1> continuation) {
        super(2, continuation);
        this.$predicate = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$filterNot$1 channelsKt__DeprecatedKt$filterNot$1 = new ChannelsKt__DeprecatedKt$filterNot$1(this.$predicate, continuation);
        channelsKt__DeprecatedKt$filterNot$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterNot$1;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Boolean> continuation) {
        return invoke2((ChannelsKt__DeprecatedKt$filterNot$1) obj, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(E e2, Continuation<? super Boolean> continuation) {
        return ((ChannelsKt__DeprecatedKt$filterNot$1) create(e2, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            Object obj2 = this.L$0;
            kotlin.jvm.b.p<E, Continuation<? super Boolean>, Object> pVar = this.$predicate;
            this.label = 1;
            obj = pVar.invoke(obj2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        return Boxing.boxBoolean(!((Boolean) obj).booleanValue());
    }
}
