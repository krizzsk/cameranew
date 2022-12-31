package us.pinguo.advsdk.network;

import android.content.Context;
import android.util.Base64;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class AbsAdvBaseTask {
    public static final Executor THREAD_POOL_EXECUTOR;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    protected WeakReference<Context> mContext;
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    private final AtomicBoolean mFinished = new AtomicBoolean();
    private final Runnable mWorkerRunnable = new a();

    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!AbsAdvBaseTask.this.isCancelled()) {
                    AbsAdvBaseTask.this.doInBackground();
                }
            } catch (Exception e2) {
                us.pinguo.advsdk.utils.b.a("mWorkerRunnable Exception = " + e2);
            }
            if (!AbsAdvBaseTask.this.isCancelled()) {
                AbsAdvBaseTask.this.onPostExecute();
            } else {
                AbsAdvBaseTask.this.onCancelled();
            }
        }
    }

    static {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        sPoolWorkQueue = linkedBlockingQueue;
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(2, 6, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    public AbsAdvBaseTask(Context context) {
        this.mContext = new WeakReference<>(context);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public String getEntryData(String str, boolean z) {
        try {
            String d2 = us.pinguo.advsdk.utils.d.d(this.mContext.get());
            String encodeToString = Base64.encodeToString(us.pinguo.advsdk.utils.e.c(str.getBytes("UTF-8"), d2.substring(d2.length() - 8, d2.length())), 0);
            return z ? URLEncoder.encode(encodeToString, "UTF-8") : encodeToString;
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    public final boolean isFinished() {
        return this.mFinished.get();
    }

    protected void onCancelled() {
        this.mFinished.set(true);
    }

    protected void onPostExecute() {
        this.mFinished.set(true);
    }
}
