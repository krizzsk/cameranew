package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterRepository.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.FilterRepository$initInnerFilter$1", f = "FilterRepository.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {481, 344, 345}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "context", "filterDbFile", "zipSdcardPath", "$this$withLock_u24default$iv", "context", "filterDbFile", "zipSdcardPath"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes6.dex */
public final class FilterRepository$initInnerFilter$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilterRepository$initInnerFilter$1(Continuation<? super FilterRepository$initInnerFilter$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterRepository$initInnerFilter$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterRepository$initInnerFilter$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d7 A[Catch: all -> 0x0046, TryCatch #1 {all -> 0x0046, blocks: (B:37:0x00d1, B:39:0x00d7, B:41:0x00df, B:42:0x00e5, B:43:0x00ea, B:45:0x0103, B:49:0x0120, B:48:0x011d, B:15:0x0042, B:27:0x0092, B:29:0x009a, B:31:0x00a0), top: B:58:0x0042, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterRepository$initInnerFilter$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
