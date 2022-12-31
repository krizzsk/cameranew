package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.common.kt */
/* loaded from: classes3.dex */
public class t0<T> extends c<T> implements s0<T>, kotlinx.coroutines.selects.d<T> {
    public t0(CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, true, z);
    }

    @Override // kotlinx.coroutines.selects.d
    public <R> void c(kotlinx.coroutines.selects.f<? super R> fVar, kotlin.jvm.b.p<? super T, ? super Continuation<? super R>, ? extends Object> pVar) {
        A0(fVar, pVar);
    }

    @Override // kotlinx.coroutines.s0
    public Object i(Continuation<? super T> continuation) {
        return L(continuation);
    }
}
