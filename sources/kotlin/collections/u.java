package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collections.kt */
/* loaded from: classes3.dex */
public class u extends t {
    public static <T> ArrayList<T> f(T... elements) {
        kotlin.jvm.internal.s.h(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new h(elements, true));
    }

    public static final <T> Collection<T> g(T[] tArr) {
        kotlin.jvm.internal.s.h(tArr, "<this>");
        return new h(tArr, false);
    }

    public static <T> List<T> h() {
        return EmptyList.INSTANCE;
    }

    public static <T> int i(List<? extends T> list) {
        kotlin.jvm.internal.s.h(list, "<this>");
        return list.size() - 1;
    }

    public static <T> List<T> j(T... elements) {
        List<T> h2;
        List<T> b;
        kotlin.jvm.internal.s.h(elements, "elements");
        if (elements.length > 0) {
            b = m.b(elements);
            return b;
        }
        h2 = h();
        return h2;
    }

    public static <T> List<T> k(T... elements) {
        kotlin.jvm.internal.s.h(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new h(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> l(List<? extends T> list) {
        List<T> h2;
        List<T> e2;
        kotlin.jvm.internal.s.h(list, "<this>");
        int size = list.size();
        if (size == 0) {
            h2 = h();
            return h2;
        } else if (size != 1) {
            return list;
        } else {
            e2 = t.e(list.get(0));
            return e2;
        }
    }

    public static void m() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void n() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
