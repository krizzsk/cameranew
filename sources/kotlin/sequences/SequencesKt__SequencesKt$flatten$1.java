package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
final class SequencesKt__SequencesKt$flatten$1 extends Lambda implements kotlin.jvm.b.l<e<? extends T>, Iterator<? extends T>> {
    public static final SequencesKt__SequencesKt$flatten$1 INSTANCE = new SequencesKt__SequencesKt$flatten$1();

    SequencesKt__SequencesKt$flatten$1() {
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.b.l
    public final Iterator<T> invoke(e<? extends T> it) {
        s.h(it, "it");
        return it.iterator();
    }
}
