package androidx.work;

import android.os.Build;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class Configuration {
    public static final int MIN_SCHEDULER_LIMIT = 20;
    @NonNull
    private final Executor mExecutor;
    private final int mLoggingLevel;
    private final int mMaxJobSchedulerId;
    private final int mMaxSchedulerLimit;
    private final int mMinJobSchedulerId;
    @NonNull
    private final Executor mTaskExecutor;
    @NonNull
    private final WorkerFactory mWorkerFactory;

    /* loaded from: classes.dex */
    public static final class Builder {
        Executor mExecutor;
        Executor mTaskExecutor;
        WorkerFactory mWorkerFactory;
        int mLoggingLevel = 4;
        int mMinJobSchedulerId = 0;
        int mMaxJobSchedulerId = Integer.MAX_VALUE;
        int mMaxSchedulerLimit = 20;

        @NonNull
        public Configuration build() {
            return new Configuration(this);
        }

        @NonNull
        public Builder setExecutor(@NonNull Executor executor) {
            this.mExecutor = executor;
            return this;
        }

        @NonNull
        public Builder setJobSchedulerJobIdRange(int i2, int i3) {
            if (i3 - i2 >= 1000) {
                this.mMinJobSchedulerId = i2;
                this.mMaxJobSchedulerId = i3;
                return this;
            }
            throw new IllegalArgumentException("WorkManager needs a range of at least 1000 job ids.");
        }

        @NonNull
        public Builder setMaxSchedulerLimit(int i2) {
            if (i2 >= 20) {
                this.mMaxSchedulerLimit = Math.min(i2, 50);
                return this;
            }
            throw new IllegalArgumentException("WorkManager needs to be able to schedule at least 20 jobs in JobScheduler.");
        }

        @NonNull
        public Builder setMinimumLoggingLevel(int i2) {
            this.mLoggingLevel = i2;
            return this;
        }

        @NonNull
        public Builder setTaskExecutor(@NonNull Executor executor) {
            this.mTaskExecutor = executor;
            return this;
        }

        @NonNull
        public Builder setWorkerFactory(@NonNull WorkerFactory workerFactory) {
            this.mWorkerFactory = workerFactory;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface Provider {
        @NonNull
        Configuration getWorkManagerConfiguration();
    }

    Configuration(@NonNull Builder builder) {
        Executor executor = builder.mExecutor;
        if (executor == null) {
            this.mExecutor = createDefaultExecutor();
        } else {
            this.mExecutor = executor;
        }
        Executor executor2 = builder.mTaskExecutor;
        if (executor2 == null) {
            this.mTaskExecutor = createDefaultExecutor();
        } else {
            this.mTaskExecutor = executor2;
        }
        WorkerFactory workerFactory = builder.mWorkerFactory;
        if (workerFactory == null) {
            this.mWorkerFactory = WorkerFactory.getDefaultWorkerFactory();
        } else {
            this.mWorkerFactory = workerFactory;
        }
        this.mLoggingLevel = builder.mLoggingLevel;
        this.mMinJobSchedulerId = builder.mMinJobSchedulerId;
        this.mMaxJobSchedulerId = builder.mMaxJobSchedulerId;
        this.mMaxSchedulerLimit = builder.mMaxSchedulerLimit;
    }

    @NonNull
    private Executor createDefaultExecutor() {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)));
    }

    @NonNull
    public Executor getExecutor() {
        return this.mExecutor;
    }

    public int getMaxJobSchedulerId() {
        return this.mMaxJobSchedulerId;
    }

    @IntRange(from = 20, to = 50)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxSchedulerLimit() {
        if (Build.VERSION.SDK_INT == 23) {
            return this.mMaxSchedulerLimit / 2;
        }
        return this.mMaxSchedulerLimit;
    }

    public int getMinJobSchedulerId() {
        return this.mMinJobSchedulerId;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMinimumLoggingLevel() {
        return this.mLoggingLevel;
    }

    @NonNull
    public Executor getTaskExecutor() {
        return this.mTaskExecutor;
    }

    @NonNull
    public WorkerFactory getWorkerFactory() {
        return this.mWorkerFactory;
    }
}
