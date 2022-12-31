package j.a.c.b;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: AsyncSuccess.java */
/* loaded from: classes.dex */
public class e<V> implements b<V> {
    private V a;

    public e(V v) {
        this.a = v;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return true;
    }

    @Override // j.a.c.b.b
    public void get(d<V> dVar) {
        if (dVar != null) {
            dVar.onSuccess(this.a);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return this.a;
    }

    @Override // java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.a;
    }
}
