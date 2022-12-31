package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.collections.h0;
import kotlin.jvm.b.a;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: SparseBooleanArray.kt */
/* loaded from: classes.dex */
public final class SparseBooleanArrayKt {
    public static final boolean contains(SparseBooleanArray sparseBooleanArray, int i2) {
        s.h(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsKey(SparseBooleanArray sparseBooleanArray, int i2) {
        s.h(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsValue(SparseBooleanArray sparseBooleanArray, boolean z) {
        s.h(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfValue(z) >= 0;
    }

    public static final void forEach(SparseBooleanArray sparseBooleanArray, p<? super Integer, ? super Boolean, u> action) {
        s.h(sparseBooleanArray, "<this>");
        s.h(action, "action");
        int size = sparseBooleanArray.size();
        if (size <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            action.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i2)), Boolean.valueOf(sparseBooleanArray.valueAt(i2)));
            if (i3 >= size) {
                return;
            }
            i2 = i3;
        }
    }

    public static final boolean getOrDefault(SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        s.h(sparseBooleanArray, "<this>");
        return sparseBooleanArray.get(i2, z);
    }

    public static final boolean getOrElse(SparseBooleanArray sparseBooleanArray, int i2, a<Boolean> defaultValue) {
        s.h(sparseBooleanArray, "<this>");
        s.h(defaultValue, "defaultValue");
        int indexOfKey = sparseBooleanArray.indexOfKey(i2);
        return indexOfKey >= 0 ? sparseBooleanArray.valueAt(indexOfKey) : defaultValue.invoke().booleanValue();
    }

    public static final int getSize(SparseBooleanArray sparseBooleanArray) {
        s.h(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(SparseBooleanArray sparseBooleanArray) {
        s.h(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseBooleanArray sparseBooleanArray) {
        s.h(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() != 0;
    }

    public static final h0 keyIterator(final SparseBooleanArray sparseBooleanArray) {
        s.h(sparseBooleanArray, "<this>");
        return new h0() { // from class: androidx.core.util.SparseBooleanArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // kotlin.collections.h0
            public int nextInt() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseBooleanArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    public static final SparseBooleanArray plus(SparseBooleanArray sparseBooleanArray, SparseBooleanArray other) {
        s.h(sparseBooleanArray, "<this>");
        s.h(other, "other");
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(sparseBooleanArray.size() + other.size());
        putAll(sparseBooleanArray2, sparseBooleanArray);
        putAll(sparseBooleanArray2, other);
        return sparseBooleanArray2;
    }

    public static final void putAll(SparseBooleanArray sparseBooleanArray, SparseBooleanArray other) {
        s.h(sparseBooleanArray, "<this>");
        s.h(other, "other");
        int size = other.size();
        if (size <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            sparseBooleanArray.put(other.keyAt(i2), other.valueAt(i2));
            if (i3 >= size) {
                return;
            }
            i2 = i3;
        }
    }

    public static final boolean remove(SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        s.h(sparseBooleanArray, "<this>");
        int indexOfKey = sparseBooleanArray.indexOfKey(i2);
        if (indexOfKey < 0 || z != sparseBooleanArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i2);
        return true;
    }

    public static final void set(SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        s.h(sparseBooleanArray, "<this>");
        sparseBooleanArray.put(i2, z);
    }

    public static final kotlin.collections.p valueIterator(final SparseBooleanArray sparseBooleanArray) {
        s.h(sparseBooleanArray, "<this>");
        return new kotlin.collections.p() { // from class: androidx.core.util.SparseBooleanArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // kotlin.collections.p
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseBooleanArray2.valueAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }
}
