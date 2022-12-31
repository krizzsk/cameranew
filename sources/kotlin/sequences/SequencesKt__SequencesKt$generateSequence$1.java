package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
final class SequencesKt__SequencesKt$generateSequence$1 extends Lambda implements kotlin.jvm.b.l<T, T> {
    final /* synthetic */ kotlin.jvm.b.a<T> $nextFunction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt__SequencesKt$generateSequence$1(kotlin.jvm.b.a<? extends T> aVar) {
        super(1);
        this.$nextFunction = aVar;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
    @Override // kotlin.jvm.b.l
    public final T invoke(T it) {
        s.h(it, "it");
        return this.$nextFunction.invoke();
    }
}
