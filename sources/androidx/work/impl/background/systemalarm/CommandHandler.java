package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class CommandHandler implements ExecutionListener {
    static final String ACTION_CONSTRAINTS_CHANGED = "ACTION_CONSTRAINTS_CHANGED";
    static final String ACTION_DELAY_MET = "ACTION_DELAY_MET";
    static final String ACTION_EXECUTION_COMPLETED = "ACTION_EXECUTION_COMPLETED";
    static final String ACTION_RESCHEDULE = "ACTION_RESCHEDULE";
    static final String ACTION_SCHEDULE_WORK = "ACTION_SCHEDULE_WORK";
    static final String ACTION_STOP_WORK = "ACTION_STOP_WORK";
    private static final String KEY_NEEDS_RESCHEDULE = "KEY_NEEDS_RESCHEDULE";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    private static final String TAG = Logger.tagWithPrefix("CommandHandler");
    static final long WORK_PROCESSING_TIME_IN_MS = 600000;
    private final Context mContext;
    private final Map<String, ExecutionListener> mPendingDelayMet = new HashMap();
    private final Object mLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public CommandHandler(@NonNull Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent createConstraintsChangedIntent(@NonNull Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction(ACTION_CONSTRAINTS_CHANGED);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent createDelayMetIntent(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction(ACTION_DELAY_MET);
        intent.putExtra(KEY_WORKSPEC_ID, str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent createExecutionCompletedIntent(@NonNull Context context, @NonNull String str, boolean z) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction(ACTION_EXECUTION_COMPLETED);
        intent.putExtra(KEY_WORKSPEC_ID, str);
        intent.putExtra(KEY_NEEDS_RESCHEDULE, z);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent createRescheduleIntent(@NonNull Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction(ACTION_RESCHEDULE);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent createScheduleWorkIntent(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction(ACTION_SCHEDULE_WORK);
        intent.putExtra(KEY_WORKSPEC_ID, str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent createStopWorkIntent(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction(ACTION_STOP_WORK);
        intent.putExtra(KEY_WORKSPEC_ID, str);
        return intent;
    }

    private void handleConstraintsChanged(@NonNull Intent intent, int i2, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.get().debug(TAG, String.format("Handling constraints changed %s", intent), new Throwable[0]);
        new ConstraintsCommandHandler(this.mContext, i2, systemAlarmDispatcher).handleConstraintsChanged();
    }

    private void handleDelayMet(@NonNull Intent intent, int i2, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        Bundle extras = intent.getExtras();
        synchronized (this.mLock) {
            String string = extras.getString(KEY_WORKSPEC_ID);
            Logger logger = Logger.get();
            String str = TAG;
            logger.debug(str, String.format("Handing delay met for %s", string), new Throwable[0]);
            if (!this.mPendingDelayMet.containsKey(string)) {
                DelayMetCommandHandler delayMetCommandHandler = new DelayMetCommandHandler(this.mContext, i2, string, systemAlarmDispatcher);
                this.mPendingDelayMet.put(string, delayMetCommandHandler);
                delayMetCommandHandler.handleProcessWork();
            } else {
                Logger.get().debug(str, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", string), new Throwable[0]);
            }
        }
    }

    private void handleExecutionCompleted(@NonNull Intent intent, int i2, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        Bundle extras = intent.getExtras();
        String string = extras.getString(KEY_WORKSPEC_ID);
        boolean z = extras.getBoolean(KEY_NEEDS_RESCHEDULE);
        Logger.get().debug(TAG, String.format("Handling onExecutionCompleted %s, %s", intent, Integer.valueOf(i2)), new Throwable[0]);
        onExecuted(string, z);
    }

    private void handleReschedule(@NonNull Intent intent, int i2, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.get().debug(TAG, String.format("Handling reschedule %s, %s", intent, Integer.valueOf(i2)), new Throwable[0]);
        systemAlarmDispatcher.getWorkManager().rescheduleEligibleWork();
    }

    private void handleScheduleWorkIntent(@NonNull Intent intent, int i2, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        String string = intent.getExtras().getString(KEY_WORKSPEC_ID);
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, String.format("Handling schedule work for %s", string), new Throwable[0]);
        WorkDatabase workDatabase = systemAlarmDispatcher.getWorkManager().getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            WorkSpec workSpec = workDatabase.workSpecDao().getWorkSpec(string);
            if (workSpec == null) {
                Logger logger2 = Logger.get();
                logger2.warning(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
            } else if (workSpec.state.isFinished()) {
                Logger logger3 = Logger.get();
                logger3.warning(str, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
            } else {
                long calculateNextRunTime = workSpec.calculateNextRunTime();
                if (!workSpec.hasConstraints()) {
                    Logger.get().debug(str, String.format("Setting up Alarms for %s at %s", string, Long.valueOf(calculateNextRunTime)), new Throwable[0]);
                    Alarms.setAlarm(this.mContext, systemAlarmDispatcher.getWorkManager(), string, calculateNextRunTime);
                } else {
                    Logger.get().debug(str, String.format("Opportunistically setting an alarm for %s at %s", string, Long.valueOf(calculateNextRunTime)), new Throwable[0]);
                    Alarms.setAlarm(this.mContext, systemAlarmDispatcher.getWorkManager(), string, calculateNextRunTime);
                    systemAlarmDispatcher.postOnMainThread(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, createConstraintsChangedIntent(this.mContext), i2));
                }
                workDatabase.setTransactionSuccessful();
            }
        } finally {
            workDatabase.endTransaction();
        }
    }

    private void handleStopWork(@NonNull Intent intent, int i2, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        String string = intent.getExtras().getString(KEY_WORKSPEC_ID);
        Logger.get().debug(TAG, String.format("Handing stopWork work for %s", string), new Throwable[0]);
        systemAlarmDispatcher.getWorkManager().stopWork(string);
        Alarms.cancelAlarm(this.mContext, systemAlarmDispatcher.getWorkManager(), string);
        systemAlarmDispatcher.onExecuted(string, false);
    }

    private static boolean hasKeys(@Nullable Bundle bundle, @NonNull String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasPendingCommands() {
        boolean z;
        synchronized (this.mLock) {
            z = !this.mPendingDelayMet.isEmpty();
        }
        return z;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull String str, boolean z) {
        synchronized (this.mLock) {
            ExecutionListener remove = this.mPendingDelayMet.remove(str);
            if (remove != null) {
                remove.onExecuted(str, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public void onHandleIntent(@NonNull Intent intent, int i2, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        String action = intent.getAction();
        if (ACTION_CONSTRAINTS_CHANGED.equals(action)) {
            handleConstraintsChanged(intent, i2, systemAlarmDispatcher);
        } else if (ACTION_RESCHEDULE.equals(action)) {
            handleReschedule(intent, i2, systemAlarmDispatcher);
        } else if (!hasKeys(intent.getExtras(), KEY_WORKSPEC_ID)) {
            Logger.get().error(TAG, String.format("Invalid request for %s, requires %s.", action, KEY_WORKSPEC_ID), new Throwable[0]);
        } else if (ACTION_SCHEDULE_WORK.equals(action)) {
            handleScheduleWorkIntent(intent, i2, systemAlarmDispatcher);
        } else if (ACTION_DELAY_MET.equals(action)) {
            handleDelayMet(intent, i2, systemAlarmDispatcher);
        } else if (ACTION_STOP_WORK.equals(action)) {
            handleStopWork(intent, i2, systemAlarmDispatcher);
        } else if (ACTION_EXECUTION_COMPLETED.equals(action)) {
            handleExecutionCompleted(intent, i2, systemAlarmDispatcher);
        } else {
            Logger.get().warning(TAG, String.format("Ignoring intent %s", intent), new Throwable[0]);
        }
    }
}
