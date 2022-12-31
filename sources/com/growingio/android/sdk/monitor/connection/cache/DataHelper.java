package com.growingio.android.sdk.monitor.connection.cache;

import android.content.Context;
import android.content.SharedPreferences;
import com.growingio.android.sdk.monitor.event.Event;
/* loaded from: classes2.dex */
public class DataHelper {
    private static final String MONITOR_SEND_EVENTS_COUNT = "MONITOR_SEND_EVENTS_COUNT";
    private static final long MONITOR_SEND_PERIOD = 86400000;
    private static final String MONITOR_SP_NAME = "growing_monitor_data";
    private static final String MONITOR_START_TIME = "MONITOR_START_TIME";
    private static volatile MonitorDatabase sMonitorDb;
    private static volatile SharedPreferences sMonitorSp;

    public static synchronized void addOneSendEventCount() {
        synchronized (DataHelper.class) {
            long j2 = sMonitorSp.getLong(MONITOR_START_TIME, 0L);
            if (j2 != 0 && System.currentTimeMillis() - j2 <= 86400000) {
                sMonitorSp.edit().putInt(MONITOR_SEND_EVENTS_COUNT, sMonitorSp.getInt(MONITOR_SEND_EVENTS_COUNT, 0) + 1).apply();
            }
            sMonitorSp.edit().putLong(MONITOR_START_TIME, System.currentTimeMillis()).putInt(MONITOR_SEND_EVENTS_COUNT, 1).apply();
        }
    }

    public static synchronized void deleteEvent(Event event) {
        synchronized (DataHelper.class) {
            sMonitorDb.deleteEvent(event);
        }
    }

    public static synchronized Event getLatelyEvent(String str) {
        Event latelyEvent;
        synchronized (DataHelper.class) {
            latelyEvent = sMonitorDb.getLatelyEvent(str);
        }
        return latelyEvent;
    }

    public static synchronized int getSendEventsCountDaily() {
        synchronized (DataHelper.class) {
            long j2 = sMonitorSp.getLong(MONITOR_START_TIME, 0L);
            if (j2 != 0 && System.currentTimeMillis() - j2 <= 86400000) {
                return sMonitorSp.getInt(MONITOR_SEND_EVENTS_COUNT, 0);
            }
            sMonitorSp.edit().putLong(MONITOR_START_TIME, System.currentTimeMillis()).putInt(MONITOR_SEND_EVENTS_COUNT, 0).apply();
            return 0;
        }
    }

    public static void init(Context context) {
        if (sMonitorDb == null) {
            sMonitorDb = new MonitorDatabase(context);
        }
        if (sMonitorSp == null) {
            sMonitorSp = context.getSharedPreferences(MONITOR_SP_NAME, 0);
        }
    }

    public static synchronized void saveEvent(Event event) {
        synchronized (DataHelper.class) {
            sMonitorDb.saveEvent(event);
        }
    }
}
