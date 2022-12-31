package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.s;
/* compiled from: _Sequences.kt */
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$minus$1$iterator$1 extends Lambda implements kotlin.jvm.b.l<T, Boolean> {
    final /* synthetic */ T $element;
    final /* synthetic */ Ref$BooleanRef $removed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$minus$1$iterator$1(Ref$BooleanRef ref$BooleanRef, T t) {
        super(1);
        this.$removed = ref$BooleanRef;
        this.$element = t;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.l
    public final Boolean invoke(T t) {
        boolean z = true;
        if (!this.$removed.element && s.c(t, this.$element)) {
            this.$removed.element = true;
            z = false;
        }
        return Boolean.valueOf(z);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return invoke((SequencesKt___SequencesKt$minus$1$iterator$1) obj);
    }
}
