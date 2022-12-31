package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
/* compiled from: _Collections.kt */
/* loaded from: classes3.dex */
public class c0 extends b0 {

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a implements kotlin.sequences.e<T> {
        final /* synthetic */ Iterable a;

        public a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // kotlin.sequences.e
        public Iterator<T> iterator() {
            return this.a.iterator();
        }
    }

    public static final <T> T A(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.h(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) s.B((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T B(List<? extends T> list) {
        kotlin.jvm.internal.s.h(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T C(List<? extends T> list) {
        kotlin.jvm.internal.s.h(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> T D(List<? extends T> list, int i2) {
        int i3;
        kotlin.jvm.internal.s.h(list, "<this>");
        if (i2 >= 0) {
            i3 = u.i(list);
            if (i2 <= i3) {
                return list.get(i2);
            }
        }
        return null;
    }

    public static final <T> int E(Iterable<? extends T> iterable, T t) {
        kotlin.jvm.internal.s.h(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int i2 = 0;
        for (T t2 : iterable) {
            if (i2 >= 0) {
                if (kotlin.jvm.internal.s.c(t, t2)) {
                    return i2;
                }
                i2++;
            } else {
                s.n();
                throw null;
            }
        }
        return -1;
    }

    public static <T> int F(List<? extends T> list, T t) {
        kotlin.jvm.internal.s.h(list, "<this>");
        return list.indexOf(t);
    }

    public static final <T, A extends Appendable> A G(Iterable<? extends T> iterable, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, kotlin.jvm.b.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.s.h(iterable, "<this>");
        kotlin.jvm.internal.s.h(buffer, "buffer");
        kotlin.jvm.internal.s.h(separator, "separator");
        kotlin.jvm.internal.s.h(prefix, "prefix");
        kotlin.jvm.internal.s.h(postfix, "postfix");
        kotlin.jvm.internal.s.h(truncated, "truncated");
        buffer.append(prefix);
        int i3 = 0;
        for (T t : iterable) {
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            kotlin.text.m.a(buffer, t, lVar);
        }
        if (i2 >= 0 && i3 > i2) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> String I(Iterable<? extends T> iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, kotlin.jvm.b.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.s.h(iterable, "<this>");
        kotlin.jvm.internal.s.h(separator, "separator");
        kotlin.jvm.internal.s.h(prefix, "prefix");
        kotlin.jvm.internal.s.h(postfix, "postfix");
        kotlin.jvm.internal.s.h(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        G(iterable, sb, separator, prefix, postfix, i2, truncated, lVar);
        String sb2 = sb.toString();
        kotlin.jvm.internal.s.g(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static /* synthetic */ String J(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.jvm.b.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        String str = (i3 & 2) != 0 ? "" : charSequence2;
        String str2 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return I(iterable, charSequence, str, str2, i4, charSequence5, lVar);
    }

    public static <T> T K(List<? extends T> list) {
        int i2;
        kotlin.jvm.internal.s.h(list, "<this>");
        if (!list.isEmpty()) {
            i2 = u.i(list);
            return list.get(i2);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T L(List<? extends T> list) {
        kotlin.jvm.internal.s.h(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T M(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        kotlin.jvm.internal.s.h(iterable, "<this>");
        kotlin.jvm.internal.s.h(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            Object obj = (T) it.next();
            while (it.hasNext()) {
                T next = it.next();
                if (comparator.compare(obj, next) < 0) {
                    obj = next;
                }
            }
            return (T) obj;
        }
        return null;
    }

    public static <T extends Comparable<? super T>> T N(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.h(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (next.compareTo(next2) > 0) {
                    next = next2;
                }
            }
            return next;
        }
        return null;
    }

    public static <T> List<T> O(Iterable<? extends T> iterable) {
        List<T> U;
        kotlin.jvm.internal.s.h(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            U = U(iterable);
            return U;
        }
        List<T> V = V(iterable);
        b0.x(V);
        return V;
    }

    public static <T> T P(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.h(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) Q((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (it.hasNext()) {
                throw new IllegalArgumentException("Collection has more than one element.");
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T Q(List<? extends T> list) {
        kotlin.jvm.internal.s.h(list, "<this>");
        int size = list.size();
        if (size != 0) {
            if (size == 1) {
                return list.get(0);
            }
            throw new IllegalArgumentException("List has more than one element.");
        }
        throw new NoSuchElementException("List is empty.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> R(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        List<T> b;
        List<T> U;
        kotlin.jvm.internal.s.h(iterable, "<this>");
        kotlin.jvm.internal.s.h(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                U = U(iterable);
                return U;
            }
            Object[] array = collection.toArray(new Object[0]);
            kotlin.jvm.internal.s.f(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            kotlin.jvm.internal.s.f(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.CollectionsKt___CollectionsKt.sortedWith>");
            m.k(array, comparator);
            b = m.b(array);
            return b;
        }
        List<T> V = V(iterable);
        y.p(V, comparator);
        return V;
    }

    public static <T> List<T> S(Iterable<? extends T> iterable, int i2) {
        List<T> l2;
        List<T> e2;
        List<T> U;
        List<T> h2;
        kotlin.jvm.internal.s.h(iterable, "<this>");
        int i3 = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        } else if (i2 == 0) {
            h2 = u.h();
            return h2;
        } else {
            if (iterable instanceof Collection) {
                if (i2 >= ((Collection) iterable).size()) {
                    U = U(iterable);
                    return U;
                } else if (i2 == 1) {
                    e2 = t.e(A(iterable));
                    return e2;
                }
            }
            ArrayList arrayList = new ArrayList(i2);
            for (T t : iterable) {
                arrayList.add(t);
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            l2 = u.l(arrayList);
            return l2;
        }
    }

    public static final <T, C extends Collection<? super T>> C T(Iterable<? extends T> iterable, C destination) {
        kotlin.jvm.internal.s.h(iterable, "<this>");
        kotlin.jvm.internal.s.h(destination, "destination");
        for (T t : iterable) {
            destination.add(t);
        }
        return destination;
    }

    public static <T> List<T> U(Iterable<? extends T> iterable) {
        List<T> l2;
        List<T> h2;
        List<T> e2;
        List<T> W;
        kotlin.jvm.internal.s.h(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                h2 = u.h();
                return h2;
            } else if (size != 1) {
                W = W(collection);
                return W;
            } else {
                e2 = t.e(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
                return e2;
            }
        }
        l2 = u.l(V(iterable));
        return l2;
    }

    public static final <T> List<T> V(Iterable<? extends T> iterable) {
        List<T> W;
        kotlin.jvm.internal.s.h(iterable, "<this>");
        if (iterable instanceof Collection) {
            W = W((Collection) iterable);
            return W;
        }
        ArrayList arrayList = new ArrayList();
        T(iterable, arrayList);
        return arrayList;
    }

    public static <T> List<T> W(Collection<? extends T> collection) {
        kotlin.jvm.internal.s.h(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> Set<T> X(Iterable<? extends T> iterable) {
        Set<T> d2;
        int c;
        kotlin.jvm.internal.s.h(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                d2 = s0.d();
                return d2;
            } else if (size == 1) {
                return r0.c(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            } else {
                c = l0.c(collection.size());
                LinkedHashSet linkedHashSet = new LinkedHashSet(c);
                T(iterable, linkedHashSet);
                return linkedHashSet;
            }
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        T(iterable, linkedHashSet2);
        return s0.e(linkedHashSet2);
    }

    public static <T> kotlin.sequences.e<T> y(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.h(iterable, "<this>");
        return new a(iterable);
    }

    public static <T> boolean z(Iterable<? extends T> iterable, T t) {
        kotlin.jvm.internal.s.h(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t);
        }
        return E(iterable, t) >= 0;
    }
}
