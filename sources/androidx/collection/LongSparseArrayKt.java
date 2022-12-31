package androidx.collection;

import java.util.Iterator;
import kotlin.collections.i0;
import kotlin.jvm.b.a;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: LongSparseArray.kt */
/* loaded from: classes.dex */
public final class LongSparseArrayKt {
    public static final <T> boolean contains(LongSparseArray<T> receiver$0, long j2) {
        s.i(receiver$0, "receiver$0");
        return receiver$0.containsKey(j2);
    }

    public static final <T> void forEach(LongSparseArray<T> receiver$0, p<? super Long, ? super T, u> action) {
        s.i(receiver$0, "receiver$0");
        s.i(action, "action");
        int size = receiver$0.size();
        for (int i2 = 0; i2 < size; i2++) {
            action.invoke(Long.valueOf(receiver$0.keyAt(i2)), receiver$0.valueAt(i2));
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> receiver$0, long j2, T t) {
        s.i(receiver$0, "receiver$0");
        return receiver$0.get(j2, t);
    }

    public static final <T> T getOrElse(LongSparseArray<T> receiver$0, long j2, a<? extends T> defaultValue) {
        s.i(receiver$0, "receiver$0");
        s.i(defaultValue, "defaultValue");
        T t = receiver$0.get(j2);
        return t != null ? t : defaultValue.invoke();
    }

    public static final <T> int getSize(LongSparseArray<T> receiver$0) {
        s.i(receiver$0, "receiver$0");
        return receiver$0.size();
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> receiver$0) {
        s.i(receiver$0, "receiver$0");
        return !receiver$0.isEmpty();
    }

    public static final <T> i0 keyIterator(final LongSparseArray<T> receiver$0) {
        s.i(receiver$0, "receiver$0");
        return new i0() { // from class: androidx.collection.LongSparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < receiver$0.size();
            }

            @Override // kotlin.collections.i0
            public long nextLong() {
                LongSparseArray longSparseArray = receiver$0;
                int i2 = this.index;
                this.index = i2 + 1;
                return longSparseArray.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> receiver$0, LongSparseArray<T> other) {
        s.i(receiver$0, "receiver$0");
        s.i(other, "other");
        LongSparseArray<T> longSparseArray = new LongSparseArray<>(receiver$0.size() + other.size());
        longSparseArray.putAll(receiver$0);
        longSparseArray.putAll(other);
        return longSparseArray;
    }

    public static final <T> boolean remove(LongSparseArray<T> receiver$0, long j2, T t) {
        s.i(receiver$0, "receiver$0");
        return receiver$0.remove(j2, t);
    }

    public static final <T> void set(LongSparseArray<T> receiver$0, long j2, T t) {
        s.i(receiver$0, "receiver$0");
        receiver$0.put(j2, t);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> receiver$0) {
        s.i(receiver$0, "receiver$0");
        return new LongSparseArrayKt$valueIterator$1(receiver$0);
    }
}
