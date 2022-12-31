package kotlin.collections;

import java.util.Collection;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Iterables.kt */
/* loaded from: classes3.dex */
public class v extends u {
    public static <T> int o(Iterable<? extends T> iterable, int i2) {
        kotlin.jvm.internal.s.h(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }
}
