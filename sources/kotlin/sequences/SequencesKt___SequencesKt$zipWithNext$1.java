package kotlin.sequences;

import kotlin.Pair;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
/* compiled from: _Sequences.kt */
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$zipWithNext$1 extends Lambda implements p<T, T, Pair<? extends T, ? extends T>> {
    public static final SequencesKt___SequencesKt$zipWithNext$1 INSTANCE = new SequencesKt___SequencesKt$zipWithNext$1();

    SequencesKt___SequencesKt$zipWithNext$1() {
        super(2);
    }

    @Override // kotlin.jvm.b.p
    public final Pair<T, T> invoke(T t, T t2) {
        return kotlin.k.a(t, t2);
    }
}
