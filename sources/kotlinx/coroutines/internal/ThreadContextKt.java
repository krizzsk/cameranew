package kotlinx.coroutines.internal;

import java.util.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.t2;
/* compiled from: ThreadContext.kt */
/* loaded from: classes3.dex */
public final class ThreadContextKt {
    public static final c0 a = new c0("NO_THREAD_ELEMENTS");
    private static final kotlin.jvm.b.p<Object, CoroutineContext.Element, Object> b = ThreadContextKt$countAll$1.INSTANCE;
    private static final kotlin.jvm.b.p<t2<?>, CoroutineContext.Element, t2<?>> c = ThreadContextKt$findOne$1.INSTANCE;

    /* renamed from: d  reason: collision with root package name */
    private static final kotlin.jvm.b.p<k0, CoroutineContext.Element, k0> f8764d = ThreadContextKt$updateState$1.INSTANCE;

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj == a) {
            return;
        }
        if (obj instanceof k0) {
            ((k0) obj).b(coroutineContext);
            return;
        }
        Object fold = coroutineContext.fold(null, c);
        Objects.requireNonNull(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((t2) fold).n(coroutineContext, obj);
    }

    public static final Object b(CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, b);
        kotlin.jvm.internal.s.e(fold);
        return fold;
    }

    public static final Object c(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new k0(coroutineContext, ((Number) obj).intValue()), f8764d);
        }
        return ((t2) obj).N(coroutineContext);
    }
}
