package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.v1;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collect.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class FlowKt__CollectKt {
    public static final Object a(c<?> cVar, Continuation<? super kotlin.u> continuation) {
        Object coroutine_suspended;
        Object d2 = cVar.d(kotlinx.coroutines.flow.internal.m.a, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return d2 == coroutine_suspended ? d2 : kotlin.u.a;
    }

    public static final <T> Object b(c<? extends T> cVar, kotlin.jvm.b.p<? super T, ? super Continuation<? super kotlin.u>, ? extends Object> pVar, Continuation<? super kotlin.u> continuation) {
        c b;
        Object coroutine_suspended;
        b = s.b(e.x(cVar, pVar), 0, null, 2, null);
        Object e2 = e.e(b, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return e2 == coroutine_suspended ? e2 : kotlin.u.a;
    }

    public static final <T> Object c(d<? super T> dVar, c<? extends T> cVar, Continuation<? super kotlin.u> continuation) {
        Object coroutine_suspended;
        e.l(dVar);
        Object d2 = cVar.d(dVar, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return d2 == coroutine_suspended ? d2 : kotlin.u.a;
    }

    public static final <T> v1 d(c<? extends T> cVar, kotlinx.coroutines.m0 m0Var) {
        v1 d2;
        d2 = kotlinx.coroutines.l.d(m0Var, null, null, new FlowKt__CollectKt$launchIn$1(cVar, null), 3, null);
        return d2;
    }
}
