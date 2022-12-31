package kotlin.collections;

import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sets.kt */
/* loaded from: classes3.dex */
public class s0 extends r0 {
    public static <T> Set<T> d() {
        return EmptySet.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> e(Set<? extends T> set) {
        kotlin.jvm.internal.s.h(set, "<this>");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : r0.c(set.iterator().next());
        }
        return q0.d();
    }
}
