package kotlin.sequences;

import kotlin.collections.g0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
/* compiled from: _Sequences.kt */
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$filterIndexed$2 extends Lambda implements kotlin.jvm.b.l<g0<? extends T>, T> {
    public static final SequencesKt___SequencesKt$filterIndexed$2 INSTANCE = new SequencesKt___SequencesKt$filterIndexed$2();

    SequencesKt___SequencesKt$filterIndexed$2() {
        super(1);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((g0<? extends Object>) obj);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    public final T invoke(g0<? extends T> it) {
        s.h(it, "it");
        return it.b();
    }
}
