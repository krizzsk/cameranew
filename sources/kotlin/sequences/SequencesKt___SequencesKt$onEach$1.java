package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
import kotlin.u;
/* compiled from: _Sequences.kt */
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$onEach$1 extends Lambda implements kotlin.jvm.b.l<T, T> {
    final /* synthetic */ kotlin.jvm.b.l<T, u> $action;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt___SequencesKt$onEach$1(kotlin.jvm.b.l<? super T, u> lVar) {
        super(1);
        this.$action = lVar;
    }

    @Override // kotlin.jvm.b.l
    public final T invoke(T t) {
        this.$action.invoke(t);
        return t;
    }
}
