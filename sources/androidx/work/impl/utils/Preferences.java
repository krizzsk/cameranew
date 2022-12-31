package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class Preferences {
    private static final String KEY_LAST_CANCEL_ALL_TIME_MS = "last_cancel_all_time_ms";
    private static final String KEY_RESCHEDULE_NEEDED = "reschedule_needed";
    private static final String PREFERENCES_FILE_NAME = "androidx.work.util.preferences";
    private Context mContext;
    private SharedPreferences mSharedPreferences;

    /* loaded from: classes.dex */
    private static class LastCancelAllLiveData extends MutableLiveData<Long> implements SharedPreferences.OnSharedPreferenceChangeListener {
        private long mLastCancelAllTimeMillis;
        private SharedPreferences mSharedPreferences;

        LastCancelAllLiveData(SharedPreferences sharedPreferences) {
            this.mSharedPreferences = sharedPreferences;
            long j2 = sharedPreferences.getLong(Preferences.KEY_LAST_CANCEL_ALL_TIME_MS, 0L);
            this.mLastCancelAllTimeMillis = j2;
            postValue(Long.valueOf(j2));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            super.onActive();
            this.mSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.LiveData
        public void onInactive() {
            super.onInactive();
            this.mSharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (Preferences.KEY_LAST_CANCEL_ALL_TIME_MS.equals(str)) {
                long j2 = sharedPreferences.getLong(str, 0L);
                if (this.mLastCancelAllTimeMillis != j2) {
                    this.mLastCancelAllTimeMillis = j2;
                    setValue(Long.valueOf(j2));
                }
            }
        }
    }

    public Preferences(@NonNull Context context) {
        this.mContext = context;
    }

    private SharedPreferences getSharedPreferences() {
        SharedPreferences sharedPreferences;
        synchronized (Preferences.class) {
            if (this.mSharedPreferences == null) {
                this.mSharedPreferences = this.mContext.getSharedPreferences(PREFERENCES_FILE_NAME, 0);
            }
            sharedPreferences = this.mSharedPreferences;
        }
        return sharedPreferences;
    }

    public long getLastCancelAllTimeMillis() {
        return getSharedPreferences().getLong(KEY_LAST_CANCEL_ALL_TIME_MS, 0L);
    }

    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return new LastCancelAllLiveData(getSharedPreferences());
    }

    public boolean needsReschedule() {
        return getSharedPreferences().getBoolean(KEY_RESCHEDULE_NEEDED, false);
    }

    public void setLastCancelAllTimeMillis(long j2) {
        getSharedPreferences().edit().putLong(KEY_LAST_CANCEL_ALL_TIME_MS, j2).apply();
    }

    public void setNeedsReschedule(boolean z) {
        getSharedPreferences().edit().putBoolean(KEY_RESCHEDULE_NEEDED, z).apply();
    }

    @VisibleForTesting
    public Preferences(@NonNull SharedPreferences sharedPreferences) {
        this.mSharedPreferences = sharedPreferences;
    }
}
