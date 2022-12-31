package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.t2;
/* compiled from: ThreadContext.kt */
/* loaded from: classes3.dex */
final class ThreadContextKt$findOne$1 extends Lambda implements kotlin.jvm.b.p<t2<?>, CoroutineContext.Element, t2<?>> {
    public static final ThreadContextKt$findOne$1 INSTANCE = new ThreadContextKt$findOne$1();

    ThreadContextKt$findOne$1() {
        super(2);
    }

    @Override // kotlin.jvm.b.p
    public final t2<?> invoke(t2<?> t2Var, CoroutineContext.Element element) {
        if (t2Var != null) {
            return t2Var;
        }
        if (element instanceof t2) {
            return (t2) element;
        }
        return null;
    }
}
