package kotlinx.coroutines.internal;
/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes3.dex */
public class n extends p {
    @Override // kotlinx.coroutines.internal.p
    public boolean K() {
        return false;
    }

    @Override // kotlinx.coroutines.internal.p
    public final boolean L() {
        throw new IllegalStateException("head cannot be removed".toString());
    }

    public final boolean Q() {
        return E() == this;
    }
}
