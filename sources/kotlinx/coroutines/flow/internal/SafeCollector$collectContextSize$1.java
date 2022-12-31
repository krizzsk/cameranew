package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
/* compiled from: SafeCollector.kt */
/* loaded from: classes3.dex */
final class SafeCollector$collectContextSize$1 extends Lambda implements kotlin.jvm.b.p<Integer, CoroutineContext.Element, Integer> {
    public static final SafeCollector$collectContextSize$1 INSTANCE = new SafeCollector$collectContextSize$1();

    SafeCollector$collectContextSize$1() {
        super(2);
    }

    public final Integer invoke(int i2, CoroutineContext.Element element) {
        return Integer.valueOf(i2 + 1);
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.Element element) {
        return invoke(num.intValue(), element);
    }
}
