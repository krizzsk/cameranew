package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.u;
/* compiled from: Combine.kt */
/* loaded from: classes3.dex */
public final class CombineKt {
    public static final <R, T> Object a(kotlinx.coroutines.flow.d<? super R> dVar, kotlinx.coroutines.flow.c<? extends T>[] cVarArr, kotlin.jvm.b.a<T[]> aVar, kotlin.jvm.b.q<? super kotlinx.coroutines.flow.d<? super R>, ? super T[], ? super Continuation<? super u>, ? extends Object> qVar, Continuation<? super u> continuation) {
        Object coroutine_suspended;
        Object a = i.a(new CombineKt$combineInternal$2(cVarArr, aVar, qVar, dVar, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return a == coroutine_suspended ? a : u.a;
    }
}
