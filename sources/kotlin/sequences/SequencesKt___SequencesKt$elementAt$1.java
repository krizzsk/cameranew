package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
/* compiled from: _Sequences.kt */
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$elementAt$1 extends Lambda implements kotlin.jvm.b.l<Integer, T> {
    final /* synthetic */ int $index;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$elementAt$1(int i2) {
        super(1);
        this.$index = i2;
    }

    public final T invoke(int i2) {
        throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + this.$index + '.');
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }
}
