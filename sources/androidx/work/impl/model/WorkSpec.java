package androidx.work.impl.model;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import com.tapjoy.TapjoyAuctionFlags;
import com.tencent.matrix.report.Issue;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity(indices = {@Index({"schedule_requested_at"})})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class WorkSpec {
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1;
    private static final String TAG = Logger.tagWithPrefix("WorkSpec");
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER = new Function<List<WorkInfoPojo>, List<WorkInfo>>() { // from class: androidx.work.impl.model.WorkSpec.1
        @Override // androidx.arch.core.util.Function
        public List<WorkInfo> apply(List<WorkInfoPojo> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (WorkInfoPojo workInfoPojo : list) {
                arrayList.add(workInfoPojo.toWorkInfo());
            }
            return arrayList;
        }
    };
    @ColumnInfo(name = "backoff_delay_duration")
    public long backoffDelayDuration;
    @NonNull
    @ColumnInfo(name = "backoff_policy")
    public BackoffPolicy backoffPolicy;
    @NonNull
    @Embedded
    public Constraints constraints;
    @ColumnInfo(name = "flex_duration")
    public long flexDuration;
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = TapjoyAuctionFlags.AUCTION_ID)
    public String id;
    @ColumnInfo(name = "initial_delay")
    public long initialDelay;
    @NonNull
    @ColumnInfo(name = "input")
    public Data input;
    @ColumnInfo(name = "input_merger_class_name")
    public String inputMergerClassName;
    @ColumnInfo(name = "interval_duration")
    public long intervalDuration;
    @ColumnInfo(name = "minimum_retention_duration")
    public long minimumRetentionDuration;
    @NonNull
    @ColumnInfo(name = "output")
    public Data output;
    @ColumnInfo(name = "period_start_time")
    public long periodStartTime;
    @IntRange(from = 0)
    @ColumnInfo(name = "run_attempt_count")
    public int runAttemptCount;
    @ColumnInfo(name = "schedule_requested_at")
    public long scheduleRequestedAt;
    @NonNull
    @ColumnInfo(name = "state")
    public WorkInfo.State state;
    @NonNull
    @ColumnInfo(name = "worker_class_name")
    public String workerClassName;

    /* loaded from: classes.dex */
    public static class IdAndState {
        @ColumnInfo(name = TapjoyAuctionFlags.AUCTION_ID)
        public String id;
        @ColumnInfo(name = "state")
        public WorkInfo.State state;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            if (this.state != idAndState.state) {
                return false;
            }
            return this.id.equals(idAndState.id);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.state.hashCode();
        }
    }

    /* loaded from: classes.dex */
    public static class WorkInfoPojo {
        @ColumnInfo(name = TapjoyAuctionFlags.AUCTION_ID)
        public String id;
        @ColumnInfo(name = "output")
        public Data output;
        @ColumnInfo(name = "run_attempt_count")
        public int runAttemptCount;
        @ColumnInfo(name = "state")
        public WorkInfo.State state;
        @Relation(entity = WorkTag.class, entityColumn = "work_spec_id", parentColumn = TapjoyAuctionFlags.AUCTION_ID, projection = {Issue.ISSUE_REPORT_TAG})
        public List<String> tags;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) obj;
            if (this.runAttemptCount != workInfoPojo.runAttemptCount) {
                return false;
            }
            String str = this.id;
            if (str == null ? workInfoPojo.id == null : str.equals(workInfoPojo.id)) {
                if (this.state != workInfoPojo.state) {
                    return false;
                }
                Data data = this.output;
                if (data == null ? workInfoPojo.output == null : data.equals(workInfoPojo.output)) {
                    List<String> list = this.tags;
                    List<String> list2 = workInfoPojo.tags;
                    return list != null ? list.equals(list2) : list2 == null;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            String str = this.id;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            WorkInfo.State state = this.state;
            int hashCode2 = (hashCode + (state != null ? state.hashCode() : 0)) * 31;
            Data data = this.output;
            int hashCode3 = (((hashCode2 + (data != null ? data.hashCode() : 0)) * 31) + this.runAttemptCount) * 31;
            List<String> list = this.tags;
            return hashCode3 + (list != null ? list.hashCode() : 0);
        }

        public WorkInfo toWorkInfo() {
            return new WorkInfo(UUID.fromString(this.id), this.state, this.output, this.tags, this.runAttemptCount);
        }
    }

    public WorkSpec(@NonNull String str, @NonNull String str2) {
        this.state = WorkInfo.State.ENQUEUED;
        Data data = Data.EMPTY;
        this.input = data;
        this.output = data;
        this.constraints = Constraints.NONE;
        this.backoffPolicy = BackoffPolicy.EXPONENTIAL;
        this.backoffDelayDuration = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.scheduleRequestedAt = -1L;
        this.id = str;
        this.workerClassName = str2;
    }

    public long calculateNextRunTime() {
        long scalb;
        if (isBackedOff()) {
            if (this.backoffPolicy == BackoffPolicy.LINEAR) {
                scalb = this.backoffDelayDuration * this.runAttemptCount;
            } else {
                scalb = Math.scalb((float) this.backoffDelayDuration, this.runAttemptCount - 1);
            }
            return this.periodStartTime + Math.min((long) WorkRequest.MAX_BACKOFF_MILLIS, scalb);
        }
        if (isPeriodic()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.periodStartTime;
            long j3 = j2 == 0 ? currentTimeMillis + this.initialDelay : j2;
            long j4 = this.flexDuration;
            long j5 = this.intervalDuration;
            if (j4 != j5) {
                return j3 + j5 + (j2 == 0 ? j4 * (-1) : 0L);
            }
            return j3 + (j2 != 0 ? j5 : 0L);
        }
        long j6 = this.periodStartTime;
        if (j6 == 0) {
            j6 = System.currentTimeMillis();
        }
        return j6 + this.initialDelay;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        if (this.initialDelay == workSpec.initialDelay && this.intervalDuration == workSpec.intervalDuration && this.flexDuration == workSpec.flexDuration && this.runAttemptCount == workSpec.runAttemptCount && this.backoffDelayDuration == workSpec.backoffDelayDuration && this.periodStartTime == workSpec.periodStartTime && this.minimumRetentionDuration == workSpec.minimumRetentionDuration && this.scheduleRequestedAt == workSpec.scheduleRequestedAt && this.id.equals(workSpec.id) && this.state == workSpec.state && this.workerClassName.equals(workSpec.workerClassName)) {
            String str = this.inputMergerClassName;
            if (str == null ? workSpec.inputMergerClassName == null : str.equals(workSpec.inputMergerClassName)) {
                return this.input.equals(workSpec.input) && this.output.equals(workSpec.output) && this.constraints.equals(workSpec.constraints) && this.backoffPolicy == workSpec.backoffPolicy;
            }
            return false;
        }
        return false;
    }

    public boolean hasConstraints() {
        return !Constraints.NONE.equals(this.constraints);
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.workerClassName.hashCode()) * 31;
        String str = this.inputMergerClassName;
        int hashCode2 = str != null ? str.hashCode() : 0;
        long j2 = this.initialDelay;
        long j3 = this.intervalDuration;
        long j4 = this.flexDuration;
        long j5 = this.backoffDelayDuration;
        long j6 = this.periodStartTime;
        long j7 = this.minimumRetentionDuration;
        long j8 = this.scheduleRequestedAt;
        return ((((((((((((((((((((((((hashCode + hashCode2) * 31) + this.input.hashCode()) * 31) + this.output.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.constraints.hashCode()) * 31) + this.runAttemptCount) * 31) + this.backoffPolicy.hashCode()) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + ((int) (j8 ^ (j8 >>> 32)));
    }

    public boolean isBackedOff() {
        return this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
    }

    public boolean isPeriodic() {
        return this.intervalDuration != 0;
    }

    public void setBackoffDelayDuration(long j2) {
        if (j2 > WorkRequest.MAX_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value", new Throwable[0]);
            j2 = 18000000;
        }
        if (j2 < 10000) {
            Logger.get().warning(TAG, "Backoff delay duration less than minimum value", new Throwable[0]);
            j2 = 10000;
        }
        this.backoffDelayDuration = j2;
    }

    public void setPeriodic(long j2) {
        if (j2 < 900000) {
            Logger.get().warning(TAG, String.format("Interval duration lesser than minimum allowed value; Changed to %s", 900000L), new Throwable[0]);
            j2 = 900000;
        }
        setPeriodic(j2, j2);
    }

    @NonNull
    public String toString() {
        return "{WorkSpec: " + this.id + "}";
    }

    public void setPeriodic(long j2, long j3) {
        if (j2 < 900000) {
            Logger.get().warning(TAG, String.format("Interval duration lesser than minimum allowed value; Changed to %s", 900000L), new Throwable[0]);
            j2 = 900000;
        }
        if (j3 < PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            Logger.get().warning(TAG, String.format("Flex duration lesser than minimum allowed value; Changed to %s", Long.valueOf((long) PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS)), new Throwable[0]);
            j3 = 300000;
        }
        if (j3 > j2) {
            Logger.get().warning(TAG, String.format("Flex duration greater than interval duration; Changed to %s", Long.valueOf(j2)), new Throwable[0]);
            j3 = j2;
        }
        this.intervalDuration = j2;
        this.flexDuration = j3;
    }

    public WorkSpec(@NonNull WorkSpec workSpec) {
        this.state = WorkInfo.State.ENQUEUED;
        Data data = Data.EMPTY;
        this.input = data;
        this.output = data;
        this.constraints = Constraints.NONE;
        this.backoffPolicy = BackoffPolicy.EXPONENTIAL;
        this.backoffDelayDuration = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.scheduleRequestedAt = -1L;
        this.id = workSpec.id;
        this.workerClassName = workSpec.workerClassName;
        this.state = workSpec.state;
        this.inputMergerClassName = workSpec.inputMergerClassName;
        this.input = new Data(workSpec.input);
        this.output = new Data(workSpec.output);
        this.initialDelay = workSpec.initialDelay;
        this.intervalDuration = workSpec.intervalDuration;
        this.flexDuration = workSpec.flexDuration;
        this.constraints = new Constraints(workSpec.constraints);
        this.runAttemptCount = workSpec.runAttemptCount;
        this.backoffPolicy = workSpec.backoffPolicy;
        this.backoffDelayDuration = workSpec.backoffDelayDuration;
        this.periodStartTime = workSpec.periodStartTime;
        this.minimumRetentionDuration = workSpec.minimumRetentionDuration;
        this.scheduleRequestedAt = workSpec.scheduleRequestedAt;
    }
}
