package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.h;
/* compiled from: Delay.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {0}, l = {245}, m = "invokeSuspend", n = {"$this$onFailure$iv"}, s = {"L$0"})
/* loaded from: classes3.dex */
final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.channels.h<? extends Object>, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ d<T> $downstream;
    final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1$3$2(Ref$ObjectRef<Object> ref$ObjectRef, d<? super T> dVar, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$2> continuation) {
        super(2, continuation);
        this.$lastValue = ref$ObjectRef;
        this.$downstream = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, continuation);
        flowKt__DelayKt$debounceInternal$1$3$2.L$0 = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.h<? extends Object> hVar, Continuation<? super kotlin.u> continuation) {
        return m53invokeWpGqRn0(hVar.l(), continuation);
    }

    /* renamed from: invoke-WpGqRn0  reason: not valid java name */
    public final Object m53invokeWpGqRn0(Object obj, Continuation<? super kotlin.u> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(kotlinx.coroutines.channels.h.b(obj), continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6, types: [kotlinx.coroutines.internal.c0, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Ref$ObjectRef<Object> ref$ObjectRef;
        Ref$ObjectRef<Object> ref$ObjectRef2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            ?? l2 = ((kotlinx.coroutines.channels.h) this.L$0).l();
            ref$ObjectRef = this.$lastValue;
            boolean z = l2 instanceof h.c;
            if (!z) {
                ref$ObjectRef.element = l2;
            }
            d<T> dVar = this.$downstream;
            if (z) {
                Throwable e2 = kotlinx.coroutines.channels.h.e(l2);
                if (e2 == null) {
                    Object obj2 = ref$ObjectRef.element;
                    if (obj2 != null) {
                        if (obj2 == kotlinx.coroutines.flow.internal.n.a) {
                            obj2 = null;
                        }
                        this.L$0 = l2;
                        this.L$1 = ref$ObjectRef;
                        this.label = 1;
                        if (dVar.emit(obj2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ref$ObjectRef2 = ref$ObjectRef;
                    }
                    ref$ObjectRef.element = kotlinx.coroutines.flow.internal.n.c;
                } else {
                    throw e2;
                }
            }
            return kotlin.u.a;
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ref$ObjectRef2 = (Ref$ObjectRef) this.L$1;
            kotlin.j.b(obj);
        }
        ref$ObjectRef = ref$ObjectRef2;
        ref$ObjectRef.element = kotlinx.coroutines.flow.internal.n.c;
        return kotlin.u.a;
    }
}
