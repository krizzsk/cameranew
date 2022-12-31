package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.t2;
/* compiled from: ThreadContext.kt */
/* loaded from: classes3.dex */
final class ThreadContextKt$countAll$1 extends Lambda implements kotlin.jvm.b.p<Object, CoroutineContext.Element, Object> {
    public static final ThreadContextKt$countAll$1 INSTANCE = new ThreadContextKt$countAll$1();

    ThreadContextKt$countAll$1() {
        super(2);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(Object obj, CoroutineContext.Element element) {
        if (element instanceof t2) {
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int intValue = num == null ? 1 : num.intValue();
            return intValue == 0 ? element : Integer.valueOf(intValue + 1);
        }
        return obj;
    }
}
