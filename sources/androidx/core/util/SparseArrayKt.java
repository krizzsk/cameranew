package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.collections.h0;
import kotlin.jvm.b.a;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: SparseArray.kt */
/* loaded from: classes.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArray<T> sparseArray, int i2) {
        s.h(sparseArray, "<this>");
        return sparseArray.indexOfKey(i2) >= 0;
    }

    public static final <T> boolean containsKey(SparseArray<T> sparseArray, int i2) {
        s.h(sparseArray, "<this>");
        return sparseArray.indexOfKey(i2) >= 0;
    }

    public static final <T> boolean containsValue(SparseArray<T> sparseArray, T t) {
        s.h(sparseArray, "<this>");
        return sparseArray.indexOfValue(t) >= 0;
    }

    public static final <T> void forEach(SparseArray<T> sparseArray, p<? super Integer, ? super T, u> action) {
        s.h(sparseArray, "<this>");
        s.h(action, "action");
        int size = sparseArray.size();
        if (size <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            action.invoke(Integer.valueOf(sparseArray.keyAt(i2)), sparseArray.valueAt(i2));
            if (i3 >= size) {
                return;
            }
            i2 = i3;
        }
    }

    public static final <T> T getOrDefault(SparseArray<T> sparseArray, int i2, T t) {
        s.h(sparseArray, "<this>");
        T t2 = sparseArray.get(i2);
        return t2 == null ? t : t2;
    }

    public static final <T> T getOrElse(SparseArray<T> sparseArray, int i2, a<? extends T> defaultValue) {
        s.h(sparseArray, "<this>");
        s.h(defaultValue, "defaultValue");
        T t = sparseArray.get(i2);
        return t == null ? defaultValue.invoke() : t;
    }

    public static final <T> int getSize(SparseArray<T> sparseArray) {
        s.h(sparseArray, "<this>");
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(SparseArray<T> sparseArray) {
        s.h(sparseArray, "<this>");
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> sparseArray) {
        s.h(sparseArray, "<this>");
        return sparseArray.size() != 0;
    }

    public static final <T> h0 keyIterator(final SparseArray<T> sparseArray) {
        s.h(sparseArray, "<this>");
        return new h0() { // from class: androidx.core.util.SparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArray.size();
            }

            @Override // kotlin.collections.h0
            public int nextInt() {
                SparseArray<T> sparseArray2 = sparseArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> sparseArray, SparseArray<T> other) {
        s.h(sparseArray, "<this>");
        s.h(other, "other");
        SparseArray<T> sparseArray2 = new SparseArray<>(sparseArray.size() + other.size());
        putAll(sparseArray2, sparseArray);
        putAll(sparseArray2, other);
        return sparseArray2;
    }

    public static final <T> void putAll(SparseArray<T> sparseArray, SparseArray<T> other) {
        s.h(sparseArray, "<this>");
        s.h(other, "other");
        int size = other.size();
        if (size <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            sparseArray.put(other.keyAt(i2), other.valueAt(i2));
            if (i3 >= size) {
                return;
            }
            i2 = i3;
        }
    }

    public static final <T> boolean remove(SparseArray<T> sparseArray, int i2, T t) {
        s.h(sparseArray, "<this>");
        int indexOfKey = sparseArray.indexOfKey(i2);
        if (indexOfKey < 0 || !s.c(t, sparseArray.valueAt(indexOfKey))) {
            return false;
        }
        sparseArray.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(SparseArray<T> sparseArray, int i2, T t) {
        s.h(sparseArray, "<this>");
        sparseArray.put(i2, t);
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> sparseArray) {
        s.h(sparseArray, "<this>");
        return new SparseArrayKt$valueIterator$1(sparseArray);
    }
}
