package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.u;
/* compiled from: SequenceBuilder.kt */
@RestrictsSuspension
/* loaded from: classes3.dex */
public abstract class g<T> {
    public abstract Object a(T t, Continuation<? super u> continuation);

    public abstract Object c(Iterator<? extends T> it, Continuation<? super u> continuation);

    public final Object d(e<? extends T> eVar, Continuation<? super u> continuation) {
        Object coroutine_suspended;
        Object c = c(eVar.iterator(), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return c == coroutine_suspended ? c : u.a;
    }
}
