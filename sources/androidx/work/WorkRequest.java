package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public abstract class WorkRequest {
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000;
    public static final long MAX_BACKOFF_MILLIS = 18000000;
    public static final long MIN_BACKOFF_MILLIS = 10000;
    @NonNull
    private UUID mId;
    @NonNull
    private Set<String> mTags;
    @NonNull
    private WorkSpec mWorkSpec;

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkRequest(@NonNull UUID uuid, @NonNull WorkSpec workSpec, @NonNull Set<String> set) {
        this.mId = uuid;
        this.mWorkSpec = workSpec;
        this.mTags = set;
    }

    @NonNull
    public UUID getId() {
        return this.mId;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getStringId() {
        return this.mId.toString();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<String> getTags() {
        return this.mTags;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkSpec getWorkSpec() {
        return this.mWorkSpec;
    }

    /* loaded from: classes.dex */
    public static abstract class Builder<B extends Builder, W extends WorkRequest> {
        WorkSpec mWorkSpec;
        boolean mBackoffCriteriaSet = false;
        Set<String> mTags = new HashSet();
        UUID mId = UUID.randomUUID();

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(@NonNull Class<? extends ListenableWorker> cls) {
            this.mWorkSpec = new WorkSpec(this.mId.toString(), cls.getName());
            addTag(cls.getName());
        }

        @NonNull
        public final B addTag(@NonNull String str) {
            this.mTags.add(str);
            return getThis();
        }

        @NonNull
        public final W build() {
            W buildInternal = buildInternal();
            this.mId = UUID.randomUUID();
            WorkSpec workSpec = new WorkSpec(this.mWorkSpec);
            this.mWorkSpec = workSpec;
            workSpec.id = this.mId.toString();
            return buildInternal;
        }

        @NonNull
        abstract W buildInternal();

        @NonNull
        abstract B getThis();

        @NonNull
        public final B keepResultsForAtLeast(long j2, @NonNull TimeUnit timeUnit) {
            this.mWorkSpec.minimumRetentionDuration = timeUnit.toMillis(j2);
            return getThis();
        }

        @NonNull
        public final B setBackoffCriteria(@NonNull BackoffPolicy backoffPolicy, long j2, @NonNull TimeUnit timeUnit) {
            this.mBackoffCriteriaSet = true;
            WorkSpec workSpec = this.mWorkSpec;
            workSpec.backoffPolicy = backoffPolicy;
            workSpec.setBackoffDelayDuration(timeUnit.toMillis(j2));
            return getThis();
        }

        @NonNull
        public final B setConstraints(@NonNull Constraints constraints) {
            this.mWorkSpec.constraints = constraints;
            return getThis();
        }

        @NonNull
        public B setInitialDelay(long j2, @NonNull TimeUnit timeUnit) {
            this.mWorkSpec.initialDelay = timeUnit.toMillis(j2);
            return getThis();
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public final B setInitialRunAttemptCount(int i2) {
            this.mWorkSpec.runAttemptCount = i2;
            return getThis();
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public final B setInitialState(@NonNull WorkInfo.State state) {
            this.mWorkSpec.state = state;
            return getThis();
        }

        @NonNull
        public final B setInputData(@NonNull Data data) {
            this.mWorkSpec.input = data;
            return getThis();
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public final B setPeriodStartTime(long j2, @NonNull TimeUnit timeUnit) {
            this.mWorkSpec.periodStartTime = timeUnit.toMillis(j2);
            return getThis();
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public final B setScheduleRequestedAt(long j2, @NonNull TimeUnit timeUnit) {
            this.mWorkSpec.scheduleRequestedAt = timeUnit.toMillis(j2);
            return getThis();
        }

        @NonNull
        @RequiresApi(26)
        public final B keepResultsForAtLeast(@NonNull Duration duration) {
            this.mWorkSpec.minimumRetentionDuration = duration.toMillis();
            return getThis();
        }

        @NonNull
        @RequiresApi(26)
        public B setInitialDelay(@NonNull Duration duration) {
            this.mWorkSpec.initialDelay = duration.toMillis();
            return getThis();
        }

        @NonNull
        @RequiresApi(26)
        public final B setBackoffCriteria(@NonNull BackoffPolicy backoffPolicy, @NonNull Duration duration) {
            this.mBackoffCriteriaSet = true;
            WorkSpec workSpec = this.mWorkSpec;
            workSpec.backoffPolicy = backoffPolicy;
            workSpec.setBackoffDelayDuration(duration.toMillis());
            return getThis();
        }
    }
}
