package kotlinx.coroutines.channels;
/* compiled from: RendezvousChannel.kt */
/* loaded from: classes3.dex */
public class q<E> extends AbstractChannel<E> {
    public q(kotlin.jvm.b.l<? super E, kotlin.u> lVar) {
        super(lVar);
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean Q() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean R() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.b
    protected final boolean t() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.b
    protected final boolean u() {
        return true;
    }
}
