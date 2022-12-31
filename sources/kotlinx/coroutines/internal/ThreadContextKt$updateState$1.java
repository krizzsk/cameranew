package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.t2;
/* compiled from: ThreadContext.kt */
/* loaded from: classes3.dex */
final class ThreadContextKt$updateState$1 extends Lambda implements kotlin.jvm.b.p<k0, CoroutineContext.Element, k0> {
    public static final ThreadContextKt$updateState$1 INSTANCE = new ThreadContextKt$updateState$1();

    ThreadContextKt$updateState$1() {
        super(2);
    }

    @Override // kotlin.jvm.b.p
    public final k0 invoke(k0 k0Var, CoroutineContext.Element element) {
        if (element instanceof t2) {
            t2<?> t2Var = (t2) element;
            k0Var.a(t2Var, t2Var.N(k0Var.a));
        }
        return k0Var;
    }
}
