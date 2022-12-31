package kotlinx.coroutines.channels;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.j0;
/* compiled from: Produce.kt */
/* loaded from: classes3.dex */
public class m<E> extends f<E> implements n<E> {
    public m(CoroutineContext coroutineContext, e<E> eVar) {
        super(coroutineContext, eVar, true, true);
    }

    @Override // kotlinx.coroutines.c
    protected void P0(Throwable th, boolean z) {
        if (T0().C(th) || z) {
            return;
        }
        j0.a(getContext(), th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.c
    /* renamed from: U0 */
    public void Q0(kotlin.u uVar) {
        s.a.a(T0(), null, 1, null);
    }

    @Override // kotlinx.coroutines.c, kotlinx.coroutines.c2, kotlinx.coroutines.v1
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.channels.n
    public /* bridge */ /* synthetic */ s v() {
        S0();
        return this;
    }
}
