package com.growingio.android.sdk.monitor.log;

import android.util.Log;
import com.growingio.android.sdk.monitor.Monitor;
import com.growingio.android.sdk.monitor.MonitorClient;
/* loaded from: classes2.dex */
public class MLog {
    public static void d(String str, String str2) {
        Log.d(str, str2);
        for (MonitorClient monitorClient : Monitor.getAllStoredClients().values()) {
            MonitorLogger.d(monitorClient.getAlias(), str, str2);
        }
    }

    public static void e(String str, String str2) {
        for (MonitorClient monitorClient : Monitor.getAllStoredClients().values()) {
            MonitorLogger.e(monitorClient.getAlias(), str, str2);
        }
        Log.e(str, str2);
    }

    public static void d(String str, String str2, Throwable th) {
        for (MonitorClient monitorClient : Monitor.getAllStoredClients().values()) {
            MonitorLogger.d(monitorClient.getAlias(), str, str2, th);
        }
        Log.d(str, str2 + ", " + th);
    }

    public static void e(String str, String str2, Throwable th) {
        for (MonitorClient monitorClient : Monitor.getAllStoredClients().values()) {
            MonitorLogger.e(monitorClient.getAlias(), str, str2, th);
        }
        Log.e(str, str2 + ", " + th);
    }

    public static void e(String str, Throwable th) {
        for (MonitorClient monitorClient : Monitor.getAllStoredClients().values()) {
            MonitorLogger.e(monitorClient.getAlias(), str, th);
        }
        Log.e(str, th.toString());
    }
}
