package androidx.core.util;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import kotlin.collections.i0;
import kotlin.jvm.b.a;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: LongSparseArray.kt */
/* loaded from: classes.dex */
public final class LongSparseArrayKt {
    @RequiresApi(16)
    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j2) {
        s.h(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j2) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsKey(LongSparseArray<T> longSparseArray, long j2) {
        s.h(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j2) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsValue(LongSparseArray<T> longSparseArray, T t) {
        s.h(longSparseArray, "<this>");
        return longSparseArray.indexOfValue(t) >= 0;
    }

    @RequiresApi(16)
    public static final <T> void forEach(LongSparseArray<T> longSparseArray, p<? super Long, ? super T, u> action) {
        s.h(longSparseArray, "<this>");
        s.h(action, "action");
        int size = longSparseArray.size();
        if (size <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            action.invoke(Long.valueOf(longSparseArray.keyAt(i2)), longSparseArray.valueAt(i2));
            if (i3 >= size) {
                return;
            }
            i2 = i3;
        }
    }

    @RequiresApi(16)
    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j2, T t) {
        s.h(longSparseArray, "<this>");
        T t2 = longSparseArray.get(j2);
        return t2 == null ? t : t2;
    }

    @RequiresApi(16)
    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j2, a<? extends T> defaultValue) {
        s.h(longSparseArray, "<this>");
        s.h(defaultValue, "defaultValue");
        T t = longSparseArray.get(j2);
        return t == null ? defaultValue.invoke() : t;
    }

    @RequiresApi(16)
    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        s.h(longSparseArray, "<this>");
        return longSparseArray.size();
    }

    @RequiresApi(16)
    public static final <T> boolean isEmpty(LongSparseArray<T> longSparseArray) {
        s.h(longSparseArray, "<this>");
        return longSparseArray.size() == 0;
    }

    @RequiresApi(16)
    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        s.h(longSparseArray, "<this>");
        return longSparseArray.size() != 0;
    }

    @RequiresApi(16)
    public static final <T> i0 keyIterator(final LongSparseArray<T> longSparseArray) {
        s.h(longSparseArray, "<this>");
        return new i0() { // from class: androidx.core.util.LongSparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            @Override // kotlin.collections.i0
            public long nextLong() {
                LongSparseArray<T> longSparseArray2 = longSparseArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return longSparseArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    @RequiresApi(16)
    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> other) {
        s.h(longSparseArray, "<this>");
        s.h(other, "other");
        LongSparseArray<T> longSparseArray2 = new LongSparseArray<>(longSparseArray.size() + other.size());
        putAll(longSparseArray2, longSparseArray);
        putAll(longSparseArray2, other);
        return longSparseArray2;
    }

    @RequiresApi(16)
    public static final <T> void putAll(LongSparseArray<T> longSparseArray, LongSparseArray<T> other) {
        s.h(longSparseArray, "<this>");
        s.h(other, "other");
        int size = other.size();
        if (size <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            longSparseArray.put(other.keyAt(i2), other.valueAt(i2));
            if (i3 >= size) {
                return;
            }
            i2 = i3;
        }
    }

    @RequiresApi(16)
    public static final <T> boolean remove(LongSparseArray<T> longSparseArray, long j2, T t) {
        s.h(longSparseArray, "<this>");
        int indexOfKey = longSparseArray.indexOfKey(j2);
        if (indexOfKey < 0 || !s.c(t, longSparseArray.valueAt(indexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(16)
    public static final <T> void set(LongSparseArray<T> longSparseArray, long j2, T t) {
        s.h(longSparseArray, "<this>");
        longSparseArray.put(j2, t);
    }

    @RequiresApi(16)
    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        s.h(longSparseArray, "<this>");
        return new LongSparseArrayKt$valueIterator$1(longSparseArray);
    }
}
