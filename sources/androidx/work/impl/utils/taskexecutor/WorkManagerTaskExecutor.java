package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.SerialExecutor;
import java.util.concurrent.Executor;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class WorkManagerTaskExecutor implements TaskExecutor {
    private final Executor mBackgroundExecutor;
    private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
    private final Executor mMainThreadExecutor = new Executor() { // from class: androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor.1
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            WorkManagerTaskExecutor.this.postToMainThread(runnable);
        }
    };

    public WorkManagerTaskExecutor(@NonNull Executor executor) {
        this.mBackgroundExecutor = new SerialExecutor(executor);
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public void executeOnBackgroundThread(Runnable runnable) {
        this.mBackgroundExecutor.execute(runnable);
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public Executor getBackgroundExecutor() {
        return this.mBackgroundExecutor;
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public Executor getMainThreadExecutor() {
        return this.mMainThreadExecutor;
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public void postToMainThread(Runnable runnable) {
        this.mMainThreadHandler.post(runnable);
    }
}
