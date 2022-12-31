package kotlin.sequences;

import kotlin.collections.g0;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
/* compiled from: _Sequences.kt */
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$filterIndexed$1 extends Lambda implements kotlin.jvm.b.l<g0<? extends T>, Boolean> {
    final /* synthetic */ p<Integer, T, Boolean> $predicate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt___SequencesKt$filterIndexed$1(p<? super Integer, ? super T, Boolean> pVar) {
        super(1);
        this.$predicate = pVar;
    }

    @Override // kotlin.jvm.b.l
    public final Boolean invoke(g0<? extends T> it) {
        s.h(it, "it");
        return this.$predicate.invoke(Integer.valueOf(it.a()), it.b());
    }
}
