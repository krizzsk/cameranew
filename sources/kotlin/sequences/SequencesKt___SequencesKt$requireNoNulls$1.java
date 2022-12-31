package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
/* compiled from: _Sequences.kt */
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$requireNoNulls$1 extends Lambda implements kotlin.jvm.b.l<T, T> {
    final /* synthetic */ e<T> $this_requireNoNulls;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt___SequencesKt$requireNoNulls$1(e<? extends T> eVar) {
        super(1);
        this.$this_requireNoNulls = eVar;
    }

    @Override // kotlin.jvm.b.l
    public final T invoke(T t) {
        if (t != 0) {
            return t;
        }
        throw new IllegalArgumentException("null element found in " + this.$this_requireNoNulls + '.');
    }
}
