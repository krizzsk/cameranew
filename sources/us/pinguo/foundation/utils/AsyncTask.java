package us.pinguo.foundation.utils;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public abstract class AsyncTask<Params, Progress, Result> {
    private static final int CORE_POOL_SIZE = 5;
    public static final Executor DUAL_THREAD_EXECUTOR;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor SERIAL_EXECUTOR;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static volatile Executor sDefaultExecutor;
    private static final f sHandler;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    private final FutureTask<Result> mFuture;
    private final h<Params, Result> mWorker;
    private volatile Status mStatus = Status.PENDING;
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    private final AtomicBoolean mTaskInvoked = new AtomicBoolean();

    /* loaded from: classes4.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* loaded from: classes4.dex */
    class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.a.getAndIncrement());
        }
    }

    /* loaded from: classes4.dex */
    class b extends h<Params, Result> {
        b() {
            super(null);
        }

        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            AsyncTask.this.mTaskInvoked.set(true);
            Process.setThreadPriority(10);
            AsyncTask asyncTask = AsyncTask.this;
            return (Result) asyncTask.postResult(asyncTask.doInBackground(this.a));
        }
    }

    /* loaded from: classes4.dex */
    class c extends FutureTask<Result> {
        c(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                AsyncTask.this.postResultIfNotInvoked(get());
            } catch (InterruptedException e2) {
                us.pinguo.common.log.a.t(e2);
            } catch (CancellationException unused) {
                AsyncTask.this.postResultIfNotInvoked(null);
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occured while executing doInBackground()", e3.getCause());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Status.values().length];
            a = iArr;
            try {
                iArr[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class e<Data> {
        final AsyncTask a;
        final Data[] b;

        e(AsyncTask asyncTask, Data... dataArr) {
            this.a = asyncTask;
            this.b = dataArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class f extends Handler {
        private f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                eVar.a.finish(eVar.b[0]);
            } else if (i2 != 2) {
                us.pinguo.common.log.a.u("", "Invalid message:" + message.what, new Object[0]);
            } else {
                eVar.a.onProgressUpdate(eVar.b);
            }
        }

        /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static abstract class h<Params, Result> implements Callable<Result> {
        Params[] a;

        private h() {
        }

        /* synthetic */ h(a aVar) {
            this();
        }
    }

    static {
        a aVar = new a();
        sThreadFactory = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        sPoolWorkQueue = linkedBlockingQueue;
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar, new ThreadPoolExecutor.DiscardOldestPolicy());
        Executor gVar = Build.VERSION.SDK_INT >= 11 ? new g(null) : Executors.newSingleThreadExecutor(aVar);
        SERIAL_EXECUTOR = gVar;
        DUAL_THREAD_EXECUTOR = Executors.newFixedThreadPool(2, aVar);
        sHandler = new f(null);
        sDefaultExecutor = gVar;
    }

    public AsyncTask() {
        b bVar = new b();
        this.mWorker = bVar;
        this.mFuture = new c(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.mStatus = Status.FINISHED;
    }

    public static void init() {
        sHandler.getLooper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result postResult(Result result) {
        sHandler.obtainMessage(1, new e(this, result)).sendToTarget();
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postResultIfNotInvoked(Result result) {
        if (this.mTaskInvoked.get()) {
            return;
        }
        postResult(result);
    }

    public static void setDefaultExecutor(Executor executor) {
        sDefaultExecutor = executor;
    }

    public final boolean cancel(boolean z) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(z);
    }

    protected abstract Result doInBackground(Params... paramsArr) throws PackageManager.NameNotFoundException;

    public final AsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(THREAD_POOL_EXECUTOR, paramsArr);
    }

    public final AsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.mStatus != Status.PENDING) {
            int i2 = d.a[this.mStatus.ordinal()];
            if (i2 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i2 == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.mStatus = Status.RUNNING;
        onPreExecute();
        this.mWorker.a = paramsArr;
        executor.execute(this.mFuture);
        return this;
    }

    public final AsyncTask<Params, Progress, Result> executeOnPoolExecutor(Params... paramsArr) {
        return executeOnExecutor(THREAD_POOL_EXECUTOR, paramsArr);
    }

    public final AsyncTask<Params, Progress, Result> executeOnSerialExecutor(Params... paramsArr) {
        return executeOnExecutor(sDefaultExecutor, paramsArr);
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.mFuture.get();
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    protected void onCancelled() {
    }

    protected void onCancelled(Result result) {
        onCancelled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPostExecute(Result result) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPreExecute() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onProgressUpdate(Progress... progressArr) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void publishProgress(Progress... progressArr) {
        if (isCancelled()) {
            return;
        }
        sHandler.obtainMessage(2, new e(this, progressArr)).sendToTarget();
    }

    @TargetApi(11)
    /* loaded from: classes4.dex */
    private static class g implements Executor {
        final ArrayDeque<Runnable> a;
        Runnable b;

        /* loaded from: classes4.dex */
        class a implements Runnable {
            final /* synthetic */ Runnable a;

            a(Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.a.run();
                } finally {
                    g.this.a();
                }
            }
        }

        private g() {
            this.a = new ArrayDeque<>();
        }

        protected synchronized void a() {
            Runnable poll = this.a.poll();
            this.b = poll;
            if (poll != null) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            this.a.offer(new a(runnable));
            if (this.b == null) {
                a();
            }
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    public final Result get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mFuture.get(j2, timeUnit);
    }
}
