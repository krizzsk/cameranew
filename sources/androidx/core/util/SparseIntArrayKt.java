package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.collections.h0;
import kotlin.jvm.b.a;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: SparseIntArray.kt */
/* loaded from: classes.dex */
public final class SparseIntArrayKt {
    public static final boolean contains(SparseIntArray sparseIntArray, int i2) {
        s.h(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsKey(SparseIntArray sparseIntArray, int i2) {
        s.h(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsValue(SparseIntArray sparseIntArray, int i2) {
        s.h(sparseIntArray, "<this>");
        return sparseIntArray.indexOfValue(i2) >= 0;
    }

    public static final void forEach(SparseIntArray sparseIntArray, p<? super Integer, ? super Integer, u> action) {
        s.h(sparseIntArray, "<this>");
        s.h(action, "action");
        int size = sparseIntArray.size();
        if (size <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            action.invoke(Integer.valueOf(sparseIntArray.keyAt(i2)), Integer.valueOf(sparseIntArray.valueAt(i2)));
            if (i3 >= size) {
                return;
            }
            i2 = i3;
        }
    }

    public static final int getOrDefault(SparseIntArray sparseIntArray, int i2, int i3) {
        s.h(sparseIntArray, "<this>");
        return sparseIntArray.get(i2, i3);
    }

    public static final int getOrElse(SparseIntArray sparseIntArray, int i2, a<Integer> defaultValue) {
        s.h(sparseIntArray, "<this>");
        s.h(defaultValue, "defaultValue");
        int indexOfKey = sparseIntArray.indexOfKey(i2);
        return indexOfKey >= 0 ? sparseIntArray.valueAt(indexOfKey) : defaultValue.invoke().intValue();
    }

    public static final int getSize(SparseIntArray sparseIntArray) {
        s.h(sparseIntArray, "<this>");
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(SparseIntArray sparseIntArray) {
        s.h(sparseIntArray, "<this>");
        return sparseIntArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseIntArray sparseIntArray) {
        s.h(sparseIntArray, "<this>");
        return sparseIntArray.size() != 0;
    }

    public static final h0 keyIterator(final SparseIntArray sparseIntArray) {
        s.h(sparseIntArray, "<this>");
        return new h0() { // from class: androidx.core.util.SparseIntArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // kotlin.collections.h0
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseIntArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    public static final SparseIntArray plus(SparseIntArray sparseIntArray, SparseIntArray other) {
        s.h(sparseIntArray, "<this>");
        s.h(other, "other");
        SparseIntArray sparseIntArray2 = new SparseIntArray(sparseIntArray.size() + other.size());
        putAll(sparseIntArray2, sparseIntArray);
        putAll(sparseIntArray2, other);
        return sparseIntArray2;
    }

    public static final void putAll(SparseIntArray sparseIntArray, SparseIntArray other) {
        s.h(sparseIntArray, "<this>");
        s.h(other, "other");
        int size = other.size();
        if (size <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            sparseIntArray.put(other.keyAt(i2), other.valueAt(i2));
            if (i3 >= size) {
                return;
            }
            i2 = i3;
        }
    }

    public static final boolean remove(SparseIntArray sparseIntArray, int i2, int i3) {
        s.h(sparseIntArray, "<this>");
        int indexOfKey = sparseIntArray.indexOfKey(i2);
        if (indexOfKey < 0 || i3 != sparseIntArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(indexOfKey);
        return true;
    }

    public static final void set(SparseIntArray sparseIntArray, int i2, int i3) {
        s.h(sparseIntArray, "<this>");
        sparseIntArray.put(i2, i3);
    }

    public static final h0 valueIterator(final SparseIntArray sparseIntArray) {
        s.h(sparseIntArray, "<this>");
        return new h0() { // from class: androidx.core.util.SparseIntArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // kotlin.collections.h0
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseIntArray2.valueAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }
}
