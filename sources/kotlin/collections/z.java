package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableCollections.kt */
/* loaded from: classes3.dex */
public class z extends y {
    public static <T> boolean q(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.s.h(collection, "<this>");
        kotlin.jvm.internal.s.h(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        boolean z = false;
        Iterator<? extends T> it = elements.iterator();
        while (it.hasNext()) {
            if (collection.add((T) it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static <T> boolean r(Collection<? super T> collection, T[] elements) {
        kotlin.jvm.internal.s.h(collection, "<this>");
        kotlin.jvm.internal.s.h(elements, "elements");
        return collection.addAll(j.b(elements));
    }

    private static final <T> boolean s(Iterable<? extends T> iterable, kotlin.jvm.b.l<? super T, Boolean> lVar, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (lVar.invoke((T) it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    private static final <T> boolean t(List<T> list, kotlin.jvm.b.l<? super T, Boolean> lVar, boolean z) {
        if (!(list instanceof RandomAccess)) {
            kotlin.jvm.internal.s.f(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return s(kotlin.jvm.internal.y.b(list), lVar, z);
        }
        h0 it = new kotlin.z.d(0, s.i(list)).iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            T t = list.get(nextInt);
            if (lVar.invoke(t).booleanValue() != z) {
                if (i2 != nextInt) {
                    list.set(i2, t);
                }
                i2++;
            }
        }
        if (i2 >= list.size()) {
            return false;
        }
        int i3 = s.i(list);
        if (i2 > i3) {
            return true;
        }
        while (true) {
            list.remove(i3);
            if (i3 == i2) {
                return true;
            }
            i3--;
        }
    }

    public static <T> boolean u(List<T> list, kotlin.jvm.b.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.s.h(list, "<this>");
        kotlin.jvm.internal.s.h(predicate, "predicate");
        return t(list, predicate, true);
    }

    public static <T> T v(List<T> list) {
        kotlin.jvm.internal.s.h(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(s.i(list));
    }

    public static <T> boolean w(Iterable<? extends T> iterable, kotlin.jvm.b.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.s.h(iterable, "<this>");
        kotlin.jvm.internal.s.h(predicate, "predicate");
        return s(iterable, predicate, false);
    }
}
