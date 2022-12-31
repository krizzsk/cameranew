package androidx.core.util;

import android.util.Range;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
import kotlin.z.a;
/* compiled from: Range.kt */
/* loaded from: classes.dex */
public final class RangeKt {
    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> range, Range<T> other) {
        s.h(range, "<this>");
        s.h(other, "other");
        Range<T> intersect = range.intersect(other);
        s.g(intersect, "intersect(other)");
        return intersect;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, T value) {
        s.h(range, "<this>");
        s.h(value, "value");
        Range<T> extend = range.extend((Range<T>) value);
        s.g(extend, "extend(value)");
        return extend;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T t, T that) {
        s.h(t, "<this>");
        s.h(that, "that");
        return new Range<>(t, that);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> a<T> toClosedRange(final Range<T> range) {
        s.h(range, "<this>");
        return (a<T>) new a<T>() { // from class: androidx.core.util.RangeKt$toClosedRange$1
            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            public boolean contains(Comparable comparable) {
                return a.C0321a.a(this, comparable);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.z.a
            public Comparable getEndInclusive() {
                return range.getUpper();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.z.a
            public Comparable getStart() {
                return range.getLower();
            }

            public boolean isEmpty() {
                return a.C0321a.b(this);
            }
        };
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> toRange(a<T> aVar) {
        s.h(aVar, "<this>");
        return new Range<>(aVar.getStart(), aVar.getEndInclusive());
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, Range<T> other) {
        s.h(range, "<this>");
        s.h(other, "other");
        Range<T> extend = range.extend(other);
        s.g(extend, "extend(other)");
        return extend;
    }
}
