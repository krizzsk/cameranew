package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.common.kt */
/* loaded from: classes3.dex */
public final class f2 extends q2 {
    private final Continuation<kotlin.u> c;

    public f2(CoroutineContext coroutineContext, kotlin.jvm.b.p<? super m0, ? super Continuation<? super kotlin.u>, ? extends Object> pVar) {
        super(coroutineContext, false);
        Continuation<kotlin.u> createCoroutineUnintercepted;
        createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(pVar, this, this);
        this.c = createCoroutineUnintercepted;
    }

    @Override // kotlinx.coroutines.c2
    protected void x0() {
        kotlinx.coroutines.d3.a.c(this.c, this);
    }
}
