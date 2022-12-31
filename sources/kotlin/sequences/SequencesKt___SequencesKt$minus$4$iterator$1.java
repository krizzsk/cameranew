package kotlin.sequences;

import java.util.Collection;
import kotlin.jvm.internal.Lambda;
/* compiled from: _Sequences.kt */
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$minus$4$iterator$1 extends Lambda implements kotlin.jvm.b.l<T, Boolean> {
    final /* synthetic */ Collection<T> $other;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt___SequencesKt$minus$4$iterator$1(Collection<? extends T> collection) {
        super(1);
        this.$other = collection;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.l
    public final Boolean invoke(T t) {
        return Boolean.valueOf(this.$other.contains(t));
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return invoke((SequencesKt___SequencesKt$minus$4$iterator$1) obj);
    }
}
