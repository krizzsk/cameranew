package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.u;
/* compiled from: SafeCollector.kt */
/* loaded from: classes3.dex */
/* synthetic */ class SafeCollectorKt$emitFun$1 extends FunctionReferenceImpl implements kotlin.jvm.b.q<kotlinx.coroutines.flow.d<? super Object>, Object, u>, SuspendFunction {
    public static final SafeCollectorKt$emitFun$1 INSTANCE = new SafeCollectorKt$emitFun$1();

    SafeCollectorKt$emitFun$1() {
        super(3, kotlinx.coroutines.flow.d.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.b.q
    public final Object invoke(kotlinx.coroutines.flow.d<Object> dVar, Object obj, Continuation<? super u> continuation) {
        return dVar.emit(obj, continuation);
    }
}
