package com.growingio.android.sdk.monitor;

import android.content.Context;
import androidx.annotation.NonNull;
import com.growingio.android.sdk.monitor.MonitorClient;
import com.growingio.android.sdk.monitor.connection.cache.DataHelper;
import com.growingio.android.sdk.monitor.event.EventBuilder;
import com.growingio.android.sdk.monitor.log.MLog;
import com.growingio.android.sdk.monitor.util.Util;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public final class Monitor {
    private static final String TAG = "Monitor";
    private static Context appContext;
    private static MonitorUncaughtExceptionHandler uncaughtExceptionHandler;
    private static ConcurrentHashMap<String, MonitorClient> storedClients = new ConcurrentHashMap<>();
    private static volatile boolean mIsInit = false;
    private static volatile int priority = 0;

    private Monitor() {
    }

    public static void addIgnoresException(Class cls) {
        MonitorUncaughtExceptionHandler monitorUncaughtExceptionHandler = uncaughtExceptionHandler;
        if (monitorUncaughtExceptionHandler == null) {
            MLog.d(TAG, "Please init monitor first!");
        } else {
            monitorUncaughtExceptionHandler.addIgnoresException(cls);
        }
    }

    public static void capture(@NonNull String str, @NonNull Throwable th) {
        getStoredClient(str).sendException(th);
    }

    public static void clearContext(@NonNull String str) {
        getStoredClient(str).clearContext();
    }

    public static void close(@NonNull String str) {
        if (storedClients.containsKey(str)) {
            getStoredClient(str).closeConnection();
        }
    }

    public static ConcurrentHashMap<String, MonitorClient> getAllStoredClients() {
        ConcurrentHashMap<String, MonitorClient> concurrentHashMap = storedClients;
        if (concurrentHashMap != null) {
            return concurrentHashMap;
        }
        throw new IllegalArgumentException("Please init monitor first!");
    }

    public static Context getAppContext() {
        Context context = appContext;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Please init monitor first!");
    }

    public static com.growingio.android.sdk.monitor.context.Context getContext(@NonNull String str) {
        return getStoredClient(str).getContext();
    }

    public static MonitorClient getStoredClient(@NonNull String str) {
        if (storedClients.containsKey(str)) {
            return storedClients.get(str);
        }
        MLog.e(TAG, "Please init monitor with alias " + str + " first!");
        return EmptyMonitorClient.EMPTY_MONITOR_CLIENT;
    }

    private static void init(Context context) {
        if (mIsInit) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        appContext = applicationContext;
        DataHelper.init(applicationContext);
        if (uncaughtExceptionHandler == null) {
            setupUncaughtExceptionHandler();
        }
    }

    public static boolean isContainsClient(@NonNull String str) {
        return storedClients.containsKey(str);
    }

    public static synchronized MonitorClient register(@NonNull String str, @NonNull String str2, @NonNull Context context, MonitorClient.FilterThrowableRule filterThrowableRule) {
        MonitorClient monitorClient;
        synchronized (Monitor.class) {
            if (context != null) {
                if (!Util.isNullOrEmpty(str) && !Util.isNullOrEmpty(str2)) {
                    init(context);
                    monitorClient = MonitorClientFactory.monitorClient(str, str2, new AndroidMonitorClientFactory(context));
                    int i2 = priority;
                    priority = i2 + 1;
                    monitorClient.setPriority(i2);
                    if (filterThrowableRule != null) {
                        monitorClient.setFilterThrowable(filterThrowableRule);
                    }
                    setStoredClient(str, monitorClient);
                }
            }
            throw new IllegalArgumentException("alias, dsn and appContext can't be null");
        }
        return monitorClient;
    }

    private static void setStoredClient(String str, MonitorClient monitorClient) {
        if (storedClients.containsKey(str)) {
            storedClients.get(str).stopSyncCachedEvent();
            MLog.e(TAG, "Overwriting statically stored MonitorClient instance, alias is " + str + ", unregister the previous client");
        }
        storedClients.put(str, monitorClient);
    }

    private static void setupUncaughtExceptionHandler() {
        uncaughtExceptionHandler = MonitorUncaughtExceptionHandler.setup();
    }

    public static synchronized void unregister(@NonNull String str) {
        synchronized (Monitor.class) {
            if (storedClients.containsKey(str) && storedClients.get(str) != null) {
                storedClients.get(str).stopSyncCachedEvent();
                storedClients.remove(str);
                return;
            }
            MLog.d(TAG, "alias " + str + " not exist when call unregister");
        }
    }

    public static void capture(@NonNull String str, String str2) {
        getStoredClient(str).sendMessage(str2);
    }

    public static void capture(@NonNull String str, @NonNull EventBuilder eventBuilder) {
        getStoredClient(str).sendEvent(eventBuilder);
    }
}
