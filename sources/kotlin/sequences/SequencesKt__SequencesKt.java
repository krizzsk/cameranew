package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public class SequencesKt__SequencesKt extends j {

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a implements e<T> {
        final /* synthetic */ Iterator a;

        public a(Iterator it) {
            this.a = it;
        }

        @Override // kotlin.sequences.e
        public Iterator<T> iterator() {
            return this.a;
        }
    }

    public static <T> e<T> c(Iterator<? extends T> it) {
        s.h(it, "<this>");
        return d(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> e<T> d(e<? extends T> eVar) {
        s.h(eVar, "<this>");
        return eVar instanceof kotlin.sequences.a ? eVar : new kotlin.sequences.a(eVar);
    }

    public static <T> e<T> e(T t, kotlin.jvm.b.l<? super T, ? extends T> nextFunction) {
        s.h(nextFunction, "nextFunction");
        if (t == null) {
            return b.a;
        }
        return new d(new SequencesKt__SequencesKt$generateSequence$2(t), nextFunction);
    }

    public static <T> e<T> f(kotlin.jvm.b.a<? extends T> seedFunction, kotlin.jvm.b.l<? super T, ? extends T> nextFunction) {
        s.h(seedFunction, "seedFunction");
        s.h(nextFunction, "nextFunction");
        return new d(seedFunction, nextFunction);
    }
}
