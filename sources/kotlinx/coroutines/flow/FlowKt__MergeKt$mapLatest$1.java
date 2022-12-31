package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Merge.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", i = {}, l = {217, 217}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class FlowKt__MergeKt$mapLatest$1 extends SuspendLambda implements kotlin.jvm.b.q<d<? super R>, T, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ kotlin.jvm.b.p<T, Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__MergeKt$mapLatest$1(kotlin.jvm.b.p<? super T, ? super Continuation<? super R>, ? extends Object> pVar, Continuation<? super FlowKt__MergeKt$mapLatest$1> continuation) {
        super(3, continuation);
        this.$transform = pVar;
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Continuation<? super kotlin.u> continuation) {
        return invoke((d) obj, (d) obj2, continuation);
    }

    public final Object invoke(d<? super R> dVar, T t, Continuation<? super kotlin.u> continuation) {
        FlowKt__MergeKt$mapLatest$1 flowKt__MergeKt$mapLatest$1 = new FlowKt__MergeKt$mapLatest$1(this.$transform, continuation);
        flowKt__MergeKt$mapLatest$1.L$0 = dVar;
        flowKt__MergeKt$mapLatest$1.L$1 = t;
        return flowKt__MergeKt$mapLatest$1.invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        d dVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            dVar = (d) this.L$0;
            Object obj2 = this.L$1;
            kotlin.jvm.b.p<T, Continuation<? super R>, Object> pVar = this.$transform;
            this.L$0 = dVar;
            this.label = 1;
            obj = pVar.invoke(obj2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                kotlin.j.b(obj);
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            dVar = (d) this.L$0;
            kotlin.j.b(obj);
        }
        this.L$0 = null;
        this.label = 2;
        if (dVar.emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return kotlin.u.a;
    }
}
