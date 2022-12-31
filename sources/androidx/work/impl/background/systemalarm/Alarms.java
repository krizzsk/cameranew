package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.utils.IdGenerator;
import com.growingio.android.sdk.autoburry.VdsAgent;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
class Alarms {
    private static final String TAG = Logger.tagWithPrefix("Alarms");

    private Alarms() {
    }

    public static void cancelAlarm(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl, @NonNull String str) {
        SystemIdInfoDao systemIdInfoDao = workManagerImpl.getWorkDatabase().systemIdInfoDao();
        SystemIdInfo systemIdInfo = systemIdInfoDao.getSystemIdInfo(str);
        if (systemIdInfo != null) {
            cancelExactAlarm(context, str, systemIdInfo.systemId);
            Logger.get().debug(TAG, String.format("Removing SystemIdInfo for workSpecId (%s)", str), new Throwable[0]);
            systemIdInfoDao.removeSystemIdInfo(str);
        }
    }

    private static void cancelExactAlarm(@NonNull Context context, @NonNull String str, int i2) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent createDelayMetIntent = CommandHandler.createDelayMetIntent(context, str);
        VdsAgent.onPendingIntentGetServiceBefore(context, i2, createDelayMetIntent, 536870912);
        PendingIntent service = PendingIntent.getService(context, i2, createDelayMetIntent, 536870912);
        VdsAgent.onPendingIntentGetServiceAfter(context, i2, createDelayMetIntent, 536870912, service);
        if (service == null || alarmManager == null) {
            return;
        }
        Logger.get().debug(TAG, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", str, Integer.valueOf(i2)), new Throwable[0]);
        alarmManager.cancel(service);
    }

    public static void setAlarm(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl, @NonNull String str, long j2) {
        SystemIdInfoDao systemIdInfoDao = workManagerImpl.getWorkDatabase().systemIdInfoDao();
        SystemIdInfo systemIdInfo = systemIdInfoDao.getSystemIdInfo(str);
        if (systemIdInfo != null) {
            cancelExactAlarm(context, str, systemIdInfo.systemId);
            setExactAlarm(context, str, systemIdInfo.systemId, j2);
            return;
        }
        int nextAlarmManagerId = new IdGenerator(context).nextAlarmManagerId();
        systemIdInfoDao.insertSystemIdInfo(new SystemIdInfo(str, nextAlarmManagerId));
        setExactAlarm(context, str, nextAlarmManagerId, j2);
    }

    private static void setExactAlarm(@NonNull Context context, @NonNull String str, int i2, long j2) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent createDelayMetIntent = CommandHandler.createDelayMetIntent(context, str);
        VdsAgent.onPendingIntentGetServiceBefore(context, i2, createDelayMetIntent, 1073741824);
        PendingIntent service = PendingIntent.getService(context, i2, createDelayMetIntent, 1073741824);
        VdsAgent.onPendingIntentGetServiceAfter(context, i2, createDelayMetIntent, 1073741824, service);
        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(0, j2, service);
            } else {
                alarmManager.set(0, j2, service);
            }
        }
    }
}
