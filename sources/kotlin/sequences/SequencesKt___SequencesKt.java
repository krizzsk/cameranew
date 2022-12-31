package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.u;
import kotlin.jvm.internal.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Sequences.kt */
/* loaded from: classes3.dex */
public class SequencesKt___SequencesKt extends k {

    /* compiled from: Iterables.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterable<T>, kotlin.jvm.internal.z.a {
        final /* synthetic */ e a;

        public a(e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.a.iterator();
        }
    }

    public static <T> Iterable<T> g(e<? extends T> eVar) {
        s.h(eVar, "<this>");
        return new a(eVar);
    }

    public static <T> int h(e<? extends T> eVar) {
        s.h(eVar, "<this>");
        Iterator<? extends T> it = eVar.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            it.next();
            i2++;
            if (i2 < 0) {
                kotlin.collections.s.m();
                throw null;
            }
        }
        return i2;
    }

    public static final <T> e<T> i(e<? extends T> eVar, kotlin.jvm.b.l<? super T, Boolean> predicate) {
        s.h(eVar, "<this>");
        s.h(predicate, "predicate");
        return new c(eVar, false, predicate);
    }

    public static <T> e<T> j(e<? extends T> eVar) {
        s.h(eVar, "<this>");
        e<T> i2 = i(eVar, SequencesKt___SequencesKt$filterNotNull$1.INSTANCE);
        s.f(i2, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return i2;
    }

    public static <T> T k(e<? extends T> eVar) {
        s.h(eVar, "<this>");
        Iterator<? extends T> it = eVar.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static <T, R> e<R> l(e<? extends T> eVar, kotlin.jvm.b.l<? super T, ? extends R> transform) {
        s.h(eVar, "<this>");
        s.h(transform, "transform");
        return new l(eVar, transform);
    }

    public static final <T, C extends Collection<? super T>> C m(e<? extends T> eVar, C destination) {
        s.h(eVar, "<this>");
        s.h(destination, "destination");
        for (T t : eVar) {
            destination.add(t);
        }
        return destination;
    }

    public static <T> List<T> n(e<? extends T> eVar) {
        List<T> l2;
        s.h(eVar, "<this>");
        l2 = u.l(o(eVar));
        return l2;
    }

    public static final <T> List<T> o(e<? extends T> eVar) {
        s.h(eVar, "<this>");
        ArrayList arrayList = new ArrayList();
        m(eVar, arrayList);
        return arrayList;
    }
}
