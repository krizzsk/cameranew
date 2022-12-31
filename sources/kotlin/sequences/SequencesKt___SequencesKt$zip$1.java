package kotlin.sequences;

import kotlin.Pair;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
/* compiled from: _Sequences.kt */
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$zip$1 extends Lambda implements p<T, R, Pair<? extends T, ? extends R>> {
    public static final SequencesKt___SequencesKt$zip$1 INSTANCE = new SequencesKt___SequencesKt$zip$1();

    SequencesKt___SequencesKt$zip$1() {
        super(2);
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((SequencesKt___SequencesKt$zip$1) obj, obj2);
    }

    @Override // kotlin.jvm.b.p
    public final Pair<T, R> invoke(T t, R r) {
        return kotlin.k.a(t, r);
    }
}
