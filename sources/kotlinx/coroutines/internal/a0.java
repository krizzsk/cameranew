package kotlinx.coroutines.internal;

import java.util.Objects;
import kotlinx.coroutines.internal.z;
/* compiled from: ConcurrentLinkedList.kt */
/* loaded from: classes3.dex */
public final class a0<S extends z<S>> {
    public static <S extends z<S>> Object a(Object obj) {
        return obj;
    }

    public static final S b(Object obj) {
        c0 c0Var;
        c0Var = f.a;
        if (obj != c0Var) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
            return (S) obj;
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static final boolean c(Object obj) {
        c0 c0Var;
        c0Var = f.a;
        return obj == c0Var;
    }
}
