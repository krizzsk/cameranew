package us.pinguo.librouter.c;
/* compiled from: BaseModule.java */
/* loaded from: classes5.dex */
public abstract class a<T> implements b<T> {
    private T mInterface;

    public final T getInterface() {
        if (this.mInterface == null) {
            synchronized (this) {
                if (this.mInterface == null) {
                    this.mInterface = initInterface();
                }
            }
        }
        return this.mInterface;
    }

    protected abstract T initInterface();
}
