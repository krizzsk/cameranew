package kotlin.jvm.internal;

import java.util.Iterator;
/* compiled from: ArrayIterator.kt */
/* loaded from: classes3.dex */
public final class h {
    public static final <T> Iterator<T> a(T[] array) {
        s.h(array, "array");
        return new g(array);
    }
}
