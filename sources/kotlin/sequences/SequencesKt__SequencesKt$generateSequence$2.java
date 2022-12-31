package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
final class SequencesKt__SequencesKt$generateSequence$2 extends Lambda implements kotlin.jvm.b.a<T> {
    final /* synthetic */ T $seed;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt__SequencesKt$generateSequence$2(T t) {
        super(0);
        this.$seed = t;
    }

    @Override // kotlin.jvm.b.a
    public final T invoke() {
        return this.$seed;
    }
}
