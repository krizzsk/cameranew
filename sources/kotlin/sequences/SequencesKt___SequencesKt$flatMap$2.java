package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.s;
/* compiled from: _Sequences.kt */
/* loaded from: classes3.dex */
final /* synthetic */ class SequencesKt___SequencesKt$flatMap$2 extends FunctionReferenceImpl implements kotlin.jvm.b.l<e<? extends R>, Iterator<? extends R>> {
    public static final SequencesKt___SequencesKt$flatMap$2 INSTANCE = new SequencesKt___SequencesKt$flatMap$2();

    SequencesKt___SequencesKt$flatMap$2() {
        super(1, e.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.b.l
    public final Iterator<R> invoke(e<? extends R> p0) {
        s.h(p0, "p0");
        return p0.iterator();
    }
}
