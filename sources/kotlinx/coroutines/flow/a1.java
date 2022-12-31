package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.kt */
/* loaded from: classes3.dex */
public final class a1<T> extends AbstractFlow<T> {
    private final kotlin.jvm.b.p<d<? super T>, Continuation<? super kotlin.u>, Object> a;

    /* JADX WARN: Multi-variable type inference failed */
    public a1(kotlin.jvm.b.p<? super d<? super T>, ? super Continuation<? super kotlin.u>, ? extends Object> pVar) {
        this.a = pVar;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    public Object e(d<? super T> dVar, Continuation<? super kotlin.u> continuation) {
        Object coroutine_suspended;
        Object invoke = this.a.invoke(dVar, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return invoke == coroutine_suspended ? invoke : kotlin.u.a;
    }
}
