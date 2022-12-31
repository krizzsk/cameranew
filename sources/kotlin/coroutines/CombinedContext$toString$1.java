package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes3.dex */
final class CombinedContext$toString$1 extends Lambda implements p<String, CoroutineContext.Element, String> {
    public static final CombinedContext$toString$1 INSTANCE = new CombinedContext$toString$1();

    CombinedContext$toString$1() {
        super(2);
    }

    @Override // kotlin.jvm.b.p
    public final String invoke(String acc, CoroutineContext.Element element) {
        s.h(acc, "acc");
        s.h(element, "element");
        if (acc.length() == 0) {
            return element.toString();
        }
        return acc + ", " + element;
    }
}
