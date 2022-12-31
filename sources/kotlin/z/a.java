package kotlin.z;

import java.lang.Comparable;
import kotlin.jvm.internal.s;
/* compiled from: Range.kt */
/* loaded from: classes3.dex */
public interface a<T extends Comparable<? super T>> {

    /* compiled from: Range.kt */
    /* renamed from: kotlin.z.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0321a {
        public static <T extends Comparable<? super T>> boolean a(a<T> aVar, T value) {
            s.h(value, "value");
            return value.compareTo(aVar.getStart()) >= 0 && value.compareTo(aVar.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean b(a<T> aVar) {
            return aVar.getStart().compareTo(aVar.getEndInclusive()) > 0;
        }
    }

    T getEndInclusive();

    T getStart();
}
