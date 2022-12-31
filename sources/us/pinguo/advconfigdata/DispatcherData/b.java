package us.pinguo.advconfigdata.DispatcherData;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: AdvTask.java */
/* loaded from: classes3.dex */
public abstract class b {
    public static final Executor THREAD_POOL_EXECUTOR;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    private final AtomicBoolean mFinished = new AtomicBoolean();
    private final Runnable mWorkerRunnable = new a();

    /* compiled from: AdvTask.java */
    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!b.this.isCancelled()) {
                    b.this.doInBackground();
                }
            } catch (Exception unused) {
            }
            if (!b.this.isCancelled()) {
                b.this.onPostExecute();
            } else {
                b.this.onCancelled();
            }
        }
    }

    static {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        sPoolWorkQueue = linkedBlockingQueue;
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(2, 6, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    public final boolean cancel() {
        this.mCancelled.set(true);
        sPoolWorkQueue.remove(this.mWorkerRunnable);
        return true;
    }

    protected abstract void doInBackground();

    public void execute() {
        THREAD_POOL_EXECUTOR.execute(this.mWorkerRunnable);
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    public final boolean isFinished() {
        return this.mFinished.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCancelled() {
        this.mFinished.set(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPostExecute() {
        this.mFinished.set(true);
    }
}
