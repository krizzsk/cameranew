package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.v1;
/* compiled from: SafeCollector.common.kt */
/* loaded from: classes3.dex */
public final class SafeCollector_commonKt {
    public static final void a(SafeCollector<?> safeCollector, CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.fold(0, new SafeCollector_commonKt$checkContext$result$1(safeCollector))).intValue() == safeCollector.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final v1 b(v1 v1Var, v1 v1Var2) {
        while (v1Var != null) {
            if (v1Var == v1Var2 || !(v1Var instanceof y)) {
                return v1Var;
            }
            v1Var = ((y) v1Var).S0();
        }
        return null;
    }
}
