package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.v1;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SafeCollector.common.kt */
/* loaded from: classes3.dex */
public final class SafeCollector_commonKt$checkContext$result$1 extends Lambda implements kotlin.jvm.b.p<Integer, CoroutineContext.Element, Integer> {
    final /* synthetic */ SafeCollector<?> $this_checkContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeCollector_commonKt$checkContext$result$1(SafeCollector<?> safeCollector) {
        super(2);
        this.$this_checkContext = safeCollector;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.Element element) {
        return invoke(num.intValue(), element);
    }

    public final Integer invoke(int i2, CoroutineContext.Element element) {
        CoroutineContext.Key<?> key = element.getKey();
        CoroutineContext.Element element2 = this.$this_checkContext.collectContext.get(key);
        if (key != v1.b0) {
            return Integer.valueOf(element != element2 ? Integer.MIN_VALUE : i2 + 1);
        }
        v1 v1Var = (v1) element2;
        v1 b = SafeCollector_commonKt.b((v1) element, v1Var);
        if (b == v1Var) {
            if (v1Var != null) {
                i2++;
            }
            return Integer.valueOf(i2);
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b + ", expected child of " + v1Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }
}
