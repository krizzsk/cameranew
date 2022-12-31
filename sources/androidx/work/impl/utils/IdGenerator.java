package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class IdGenerator {
    public static final int INITIAL_ID = 0;
    static final String NEXT_ALARM_MANAGER_ID_KEY = "next_alarm_manager_id";
    static final String NEXT_JOB_SCHEDULER_ID_KEY = "next_job_scheduler_id";
    static final String PREFERENCE_FILE_KEY = "androidx.work.util.id";
    private final Context mContext;
    private boolean mLoadedPreferences;
    private SharedPreferences mSharedPrefs;

    public IdGenerator(Context context) {
        this.mContext = context;
    }

    private void loadPreferencesIfNecessary() {
        if (this.mLoadedPreferences) {
            return;
        }
        this.mSharedPrefs = this.mContext.getSharedPreferences(PREFERENCE_FILE_KEY, 0);
        this.mLoadedPreferences = true;
    }

    private int nextId(String str) {
        int i2 = this.mSharedPrefs.getInt(str, 0);
        update(str, i2 != Integer.MAX_VALUE ? i2 + 1 : 0);
        return i2;
    }

    private void update(String str, int i2) {
        this.mSharedPrefs.edit().putInt(str, i2).apply();
    }

    public int nextAlarmManagerId() {
        int nextId;
        synchronized (IdGenerator.class) {
            loadPreferencesIfNecessary();
            nextId = nextId(NEXT_ALARM_MANAGER_ID_KEY);
        }
        return nextId;
    }

    public int nextJobSchedulerIdWithRange(int i2, int i3) {
        synchronized (IdGenerator.class) {
            loadPreferencesIfNecessary();
            int nextId = nextId(NEXT_JOB_SCHEDULER_ID_KEY);
            if (nextId >= i2 && nextId <= i3) {
                i2 = nextId;
            }
            update(NEXT_JOB_SCHEDULER_ID_KEY, i2 + 1);
        }
        return i2;
    }
}
