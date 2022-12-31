package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes3.dex */
final class CombinedContext$writeReplace$1 extends Lambda implements p<u, CoroutineContext.Element, u> {
    final /* synthetic */ CoroutineContext[] $elements;
    final /* synthetic */ Ref$IntRef $index;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombinedContext$writeReplace$1(CoroutineContext[] coroutineContextArr, Ref$IntRef ref$IntRef) {
        super(2);
        this.$elements = coroutineContextArr;
        this.$index = ref$IntRef;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(u uVar, CoroutineContext.Element element) {
        invoke2(uVar, element);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(u uVar, CoroutineContext.Element element) {
        s.h(uVar, "<anonymous parameter 0>");
        s.h(element, "element");
        CoroutineContext[] coroutineContextArr = this.$elements;
        Ref$IntRef ref$IntRef = this.$index;
        int i2 = ref$IntRef.element;
        ref$IntRef.element = i2 + 1;
        coroutineContextArr[i2] = element;
    }
}
