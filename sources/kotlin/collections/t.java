package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.collections.builders.ListBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionsJVM.kt */
/* loaded from: classes3.dex */
public class t {
    public static <E> List<E> a(List<E> builder) {
        kotlin.jvm.internal.s.h(builder, "builder");
        return ((ListBuilder) builder).build();
    }

    public static final <T> Object[] b(T[] tArr, boolean z) {
        kotlin.jvm.internal.s.h(tArr, "<this>");
        if (z && kotlin.jvm.internal.s.c(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        kotlin.jvm.internal.s.g(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    public static <E> List<E> c() {
        return new ListBuilder();
    }

    public static <E> List<E> d(int i2) {
        return new ListBuilder(i2);
    }

    public static <T> List<T> e(T t) {
        List<T> singletonList = Collections.singletonList(t);
        kotlin.jvm.internal.s.g(singletonList, "singletonList(element)");
        return singletonList;
    }
}
