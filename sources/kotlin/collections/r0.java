package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import kotlin.collections.builders.SetBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SetsJVM.kt */
/* loaded from: classes3.dex */
public class r0 {
    public static <E> Set<E> a(Set<E> builder) {
        kotlin.jvm.internal.s.h(builder, "builder");
        return ((SetBuilder) builder).build();
    }

    public static <E> Set<E> b(int i2) {
        return new SetBuilder(i2);
    }

    public static final <T> Set<T> c(T t) {
        Set<T> singleton = Collections.singleton(t);
        kotlin.jvm.internal.s.g(singleton, "singleton(element)");
        return singleton;
    }
}
