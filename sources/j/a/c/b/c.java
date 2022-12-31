package j.a.c.b;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: AsyncFutureAdapter.java */
/* loaded from: classes.dex */
public abstract class c<DST, SRC> implements b<DST> {
    private b<SRC> mTaskFuture;

    /* compiled from: AsyncFutureAdapter.java */
    /* loaded from: classes.dex */
    class a extends d<SRC> {
        final /* synthetic */ d a;

        a(d dVar) {
            this.a = dVar;
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
            this.a.onError(exc);
        }

        @Override // j.a.c.b.d
        public void onProgress(int i2) {
            this.a.onProgress(i2);
            super.onProgress(i2);
        }

        @Override // j.a.c.b.d
        public void onSuccess(SRC src) {
            try {
                this.a.onSuccess(c.this.adapte(src));
            } catch (Exception e2) {
                onError(e2);
            }
        }
    }

    public c(b<SRC> bVar) {
        this.mTaskFuture = bVar;
    }

    public abstract DST adapte(SRC src) throws Exception;

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.mTaskFuture.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public DST get() throws InterruptedException, ExecutionException {
        try {
            return adapte(this.mTaskFuture.get());
        } catch (Exception e2) {
            throw new ExecutionException(e2);
        }
    }

    public b<SRC> getSource() {
        return this.mTaskFuture;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.mTaskFuture.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mTaskFuture.isDone();
    }

    @Override // java.util.concurrent.Future
    public DST get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        try {
            return adapte(this.mTaskFuture.get(j2, timeUnit));
        } catch (Exception e2) {
            throw new ExecutionException(e2);
        }
    }

    @Override // j.a.c.b.b
    public void get(d<DST> dVar) {
        this.mTaskFuture.get(new a(dVar));
    }
}
