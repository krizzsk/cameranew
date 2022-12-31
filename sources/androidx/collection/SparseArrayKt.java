package androidx.collection;

import java.util.Iterator;
import kotlin.collections.h0;
import kotlin.jvm.b.a;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: SparseArray.kt */
/* loaded from: classes.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArrayCompat<T> receiver$0, int i2) {
        s.i(receiver$0, "receiver$0");
        return receiver$0.containsKey(i2);
    }

    public static final <T> void forEach(SparseArrayCompat<T> receiver$0, p<? super Integer, ? super T, u> action) {
        s.i(receiver$0, "receiver$0");
        s.i(action, "action");
        int size = receiver$0.size();
        for (int i2 = 0; i2 < size; i2++) {
            action.invoke(Integer.valueOf(receiver$0.keyAt(i2)), receiver$0.valueAt(i2));
        }
    }

    public static final <T> T getOrDefault(SparseArrayCompat<T> receiver$0, int i2, T t) {
        s.i(receiver$0, "receiver$0");
        return receiver$0.get(i2, t);
    }

    public static final <T> T getOrElse(SparseArrayCompat<T> receiver$0, int i2, a<? extends T> defaultValue) {
        s.i(receiver$0, "receiver$0");
        s.i(defaultValue, "defaultValue");
        T t = receiver$0.get(i2);
        return t != null ? t : defaultValue.invoke();
    }

    public static final <T> int getSize(SparseArrayCompat<T> receiver$0) {
        s.i(receiver$0, "receiver$0");
        return receiver$0.size();
    }

    public static final <T> boolean isNotEmpty(SparseArrayCompat<T> receiver$0) {
        s.i(receiver$0, "receiver$0");
        return !receiver$0.isEmpty();
    }

    public static final <T> h0 keyIterator(final SparseArrayCompat<T> receiver$0) {
        s.i(receiver$0, "receiver$0");
        return new h0() { // from class: androidx.collection.SparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < receiver$0.size();
            }

            @Override // kotlin.collections.h0
            public int nextInt() {
                SparseArrayCompat sparseArrayCompat = receiver$0;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseArrayCompat.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    public static final <T> SparseArrayCompat<T> plus(SparseArrayCompat<T> receiver$0, SparseArrayCompat<T> other) {
        s.i(receiver$0, "receiver$0");
        s.i(other, "other");
        SparseArrayCompat<T> sparseArrayCompat = new SparseArrayCompat<>(receiver$0.size() + other.size());
        sparseArrayCompat.putAll(receiver$0);
        sparseArrayCompat.putAll(other);
        return sparseArrayCompat;
    }

    public static final <T> boolean remove(SparseArrayCompat<T> receiver$0, int i2, T t) {
        s.i(receiver$0, "receiver$0");
        return receiver$0.remove(i2, t);
    }

    public static final <T> void set(SparseArrayCompat<T> receiver$0, int i2, T t) {
        s.i(receiver$0, "receiver$0");
        receiver$0.put(i2, t);
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> receiver$0) {
        s.i(receiver$0, "receiver$0");
        return new SparseArrayKt$valueIterator$1(receiver$0);
    }
}
