package us.pinguo.librouter.b;

import android.app.Application;
/* compiled from: BaseLib.java */
/* loaded from: classes5.dex */
public abstract class a<T> {
    private boolean mInited;
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

    public final void init(Application application) {
        if (this.mInited) {
            return;
        }
        this.mInited = true;
        initLib(application);
    }

    protected abstract T initInterface();

    protected abstract void initLib(Application application);
}
