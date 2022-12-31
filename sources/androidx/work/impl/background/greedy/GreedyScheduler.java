package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class GreedyScheduler implements Scheduler, WorkConstraintsCallback, ExecutionListener {
    private static final String TAG = Logger.tagWithPrefix("GreedyScheduler");
    private List<WorkSpec> mConstrainedWorkSpecs = new ArrayList();
    private final Object mLock = new Object();
    private boolean mRegisteredExecutionListener;
    private WorkConstraintsTracker mWorkConstraintsTracker;
    private WorkManagerImpl mWorkManagerImpl;

    public GreedyScheduler(Context context, TaskExecutor taskExecutor, WorkManagerImpl workManagerImpl) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(context, taskExecutor, this);
    }

    private void registerExecutionListenerIfNeeded() {
        if (this.mRegisteredExecutionListener) {
            return;
        }
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
        this.mRegisteredExecutionListener = true;
    }

    private void removeConstraintTrackingFor(@NonNull String str) {
        synchronized (this.mLock) {
            int size = this.mConstrainedWorkSpecs.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (this.mConstrainedWorkSpecs.get(i2).id.equals(str)) {
                    Logger.get().debug(TAG, String.format("Stopping tracking for %s", str), new Throwable[0]);
                    this.mConstrainedWorkSpecs.remove(i2);
                    this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
                    break;
                } else {
                    i2++;
                }
            }
        }
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(@NonNull String str) {
        registerExecutionListenerIfNeeded();
        Logger.get().debug(TAG, String.format("Cancelling work ID %s", str), new Throwable[0]);
        this.mWorkManagerImpl.stopWork(str);
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(@NonNull List<String> list) {
        for (String str : list) {
            Logger.get().debug(TAG, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            this.mWorkManagerImpl.startWork(str);
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(@NonNull List<String> list) {
        for (String str : list) {
            Logger.get().debug(TAG, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.mWorkManagerImpl.stopWork(str);
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull String str, boolean z) {
        removeConstraintTrackingFor(str);
    }

    @Override // androidx.work.impl.Scheduler
    public void schedule(@NonNull WorkSpec... workSpecArr) {
        registerExecutionListenerIfNeeded();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (WorkSpec workSpec : workSpecArr) {
            if (workSpec.state == WorkInfo.State.ENQUEUED && !workSpec.isPeriodic() && workSpec.initialDelay == 0 && !workSpec.isBackedOff()) {
                if (workSpec.hasConstraints()) {
                    if (Build.VERSION.SDK_INT < 24 || !workSpec.constraints.hasContentUriTriggers()) {
                        arrayList.add(workSpec);
                        arrayList2.add(workSpec.id);
                    }
                } else {
                    Logger.get().debug(TAG, String.format("Starting work for %s", workSpec.id), new Throwable[0]);
                    this.mWorkManagerImpl.startWork(workSpec.id);
                }
            }
        }
        synchronized (this.mLock) {
            if (!arrayList.isEmpty()) {
                Logger.get().debug(TAG, String.format("Starting tracking for [%s]", TextUtils.join(",", arrayList2)), new Throwable[0]);
                this.mConstrainedWorkSpecs.addAll(arrayList);
                this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
            }
        }
    }

    @VisibleForTesting
    public GreedyScheduler(WorkManagerImpl workManagerImpl, WorkConstraintsTracker workConstraintsTracker) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkConstraintsTracker = workConstraintsTracker;
    }
}
