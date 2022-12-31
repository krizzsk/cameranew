package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Ref$ObjectRef;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Distinct.kt */
/* loaded from: classes3.dex */
public final class DistinctFlowImpl<T> implements c<T> {
    private final c<T> a;
    public final kotlin.jvm.b.l<T, Object> b;
    public final kotlin.jvm.b.p<Object, Object, Boolean> c;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(c<? extends T> cVar, kotlin.jvm.b.l<? super T, ? extends Object> lVar, kotlin.jvm.b.p<Object, Object, Boolean> pVar) {
        this.a = cVar;
        this.b = lVar;
        this.c = pVar;
    }

    @Override // kotlinx.coroutines.flow.c
    public Object d(d<? super T> dVar, Continuation<? super kotlin.u> continuation) {
        Object coroutine_suspended;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = (T) kotlinx.coroutines.flow.internal.n.a;
        Object d2 = this.a.d(new DistinctFlowImpl$collect$$inlined$collect$1(this, ref$ObjectRef, dVar), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return d2 == coroutine_suspended ? d2 : kotlin.u.a;
    }
}
