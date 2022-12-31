package kotlin.coroutines.intrinsics;

import kotlin.NotImplementedError;
import kotlin.coroutines.Continuation;
import kotlin.jvm.b.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Intrinsics.kt */
/* loaded from: classes3.dex */
public class IntrinsicsKt__IntrinsicsKt extends IntrinsicsKt__IntrinsicsJvmKt {
    public static Object getCOROUTINE_SUSPENDED() {
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    public static /* synthetic */ void getCOROUTINE_SUSPENDED$annotations() {
    }

    private static final <T> Object suspendCoroutineUninterceptedOrReturn(l<? super Continuation<? super T>, ? extends Object> lVar, Continuation<? super T> continuation) {
        throw new NotImplementedError("Implementation of suspendCoroutineUninterceptedOrReturn is intrinsic");
    }
}
