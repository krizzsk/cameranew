package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class p {

    /* compiled from: SafeCollector.common.kt */
    /* loaded from: classes3.dex */
    public static final class a implements c<T> {
        final /* synthetic */ Object a;

        public a(Object obj) {
            this.a = obj;
        }

        @Override // kotlinx.coroutines.flow.c
        public Object d(d<? super T> dVar, Continuation<? super kotlin.u> continuation) {
            Object coroutine_suspended;
            Object emit = dVar.emit(this.a, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return emit == coroutine_suspended ? emit : kotlin.u.a;
        }
    }

    public static final <T> c<T> a(kotlin.jvm.b.p<? super kotlinx.coroutines.channels.n<? super T>, ? super Continuation<? super kotlin.u>, ? extends Object> pVar) {
        return new CallbackFlowBuilder(pVar, null, 0, null, 14, null);
    }

    public static final <T> c<T> b(kotlin.jvm.b.p<? super d<? super T>, ? super Continuation<? super kotlin.u>, ? extends Object> pVar) {
        return new a1(pVar);
    }

    public static final <T> c<T> c(T t) {
        return new a(t);
    }
}
