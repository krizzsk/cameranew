package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.OnUndeliveredElementKt;
/* compiled from: AbstractChannel.kt */
/* loaded from: classes3.dex */
public final class u<E> extends t<E> {

    /* renamed from: f  reason: collision with root package name */
    public final kotlin.jvm.b.l<E, kotlin.u> f8730f;

    /* JADX WARN: Multi-variable type inference failed */
    public u(E e2, kotlinx.coroutines.p<? super kotlin.u> pVar, kotlin.jvm.b.l<? super E, kotlin.u> lVar) {
        super(e2, pVar);
        this.f8730f = lVar;
    }

    @Override // kotlinx.coroutines.internal.p
    public boolean L() {
        if (super.L()) {
            U();
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.r
    public void U() {
        OnUndeliveredElementKt.b(this.f8730f, R(), this.f8729e.getContext());
    }
}
