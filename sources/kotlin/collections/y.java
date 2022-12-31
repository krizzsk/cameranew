package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableCollectionsJVM.kt */
/* loaded from: classes3.dex */
public class y extends x {
    public static <T> void p(List<T> list, Comparator<? super T> comparator) {
        kotlin.jvm.internal.s.h(list, "<this>");
        kotlin.jvm.internal.s.h(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
