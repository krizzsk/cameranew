package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import kotlin.collections.h0;
import kotlin.collections.i0;
import kotlin.jvm.b.a;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: SparseLongArray.kt */
/* loaded from: classes.dex */
public final class SparseLongArrayKt {
    @RequiresApi(18)
    public static final boolean contains(SparseLongArray sparseLongArray, int i2) {
        s.h(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i2) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsKey(SparseLongArray sparseLongArray, int i2) {
        s.h(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i2) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsValue(SparseLongArray sparseLongArray, long j2) {
        s.h(sparseLongArray, "<this>");
        return sparseLongArray.indexOfValue(j2) >= 0;
    }

    @RequiresApi(18)
    public static final void forEach(SparseLongArray sparseLongArray, p<? super Integer, ? super Long, u> action) {
        s.h(sparseLongArray, "<this>");
        s.h(action, "action");
        int size = sparseLongArray.size();
        if (size <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            action.invoke(Integer.valueOf(sparseLongArray.keyAt(i2)), Long.valueOf(sparseLongArray.valueAt(i2)));
            if (i3 >= size) {
                return;
            }
            i2 = i3;
        }
    }

    @RequiresApi(18)
    public static final long getOrDefault(SparseLongArray sparseLongArray, int i2, long j2) {
        s.h(sparseLongArray, "<this>");
        return sparseLongArray.get(i2, j2);
    }

    @RequiresApi(18)
    public static final long getOrElse(SparseLongArray sparseLongArray, int i2, a<Long> defaultValue) {
        s.h(sparseLongArray, "<this>");
        s.h(defaultValue, "defaultValue");
        int indexOfKey = sparseLongArray.indexOfKey(i2);
        return indexOfKey >= 0 ? sparseLongArray.valueAt(indexOfKey) : defaultValue.invoke().longValue();
    }

    @RequiresApi(18)
    public static final int getSize(SparseLongArray sparseLongArray) {
        s.h(sparseLongArray, "<this>");
        return sparseLongArray.size();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(SparseLongArray sparseLongArray) {
        s.h(sparseLongArray, "<this>");
        return sparseLongArray.size() == 0;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(SparseLongArray sparseLongArray) {
        s.h(sparseLongArray, "<this>");
        return sparseLongArray.size() != 0;
    }

    @RequiresApi(18)
    public static final h0 keyIterator(final SparseLongArray sparseLongArray) {
        s.h(sparseLongArray, "<this>");
        return new h0() { // from class: androidx.core.util.SparseLongArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // kotlin.collections.h0
            public int nextInt() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseLongArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    @RequiresApi(18)
    public static final SparseLongArray plus(SparseLongArray sparseLongArray, SparseLongArray other) {
        s.h(sparseLongArray, "<this>");
        s.h(other, "other");
        SparseLongArray sparseLongArray2 = new SparseLongArray(sparseLongArray.size() + other.size());
        putAll(sparseLongArray2, sparseLongArray);
        putAll(sparseLongArray2, other);
        return sparseLongArray2;
    }

    @RequiresApi(18)
    public static final void putAll(SparseLongArray sparseLongArray, SparseLongArray other) {
        s.h(sparseLongArray, "<this>");
        s.h(other, "other");
        int size = other.size();
        if (size <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            sparseLongArray.put(other.keyAt(i2), other.valueAt(i2));
            if (i3 >= size) {
                return;
            }
            i2 = i3;
        }
    }

    @RequiresApi(18)
    public static final boolean remove(SparseLongArray sparseLongArray, int i2, long j2) {
        s.h(sparseLongArray, "<this>");
        int indexOfKey = sparseLongArray.indexOfKey(i2);
        if (indexOfKey < 0 || j2 != sparseLongArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(18)
    public static final void set(SparseLongArray sparseLongArray, int i2, long j2) {
        s.h(sparseLongArray, "<this>");
        sparseLongArray.put(i2, j2);
    }

    @RequiresApi(18)
    public static final i0 valueIterator(final SparseLongArray sparseLongArray) {
        s.h(sparseLongArray, "<this>");
        return new i0() { // from class: androidx.core.util.SparseLongArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // kotlin.collections.i0
            public long nextLong() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseLongArray2.valueAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }
}
