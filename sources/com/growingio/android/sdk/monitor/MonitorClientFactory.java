package com.growingio.android.sdk.monitor;

import com.growingio.android.sdk.monitor.dsn.Dsn;
/* loaded from: classes2.dex */
public abstract class MonitorClientFactory {
    public static MonitorClient monitorClient(String str, String str2, MonitorClientFactory monitorClientFactory) {
        Dsn resolveDsn = resolveDsn(str2);
        if (monitorClientFactory == null) {
            monitorClientFactory = new DefaultMonitorClientFactory();
        }
        return monitorClientFactory.createMonitorClient(str, resolveDsn);
    }

    private static Dsn resolveDsn(String str) {
        return new Dsn(str);
    }

    public abstract MonitorClient createMonitorClient(String str, Dsn dsn);

    public String toString() {
        return "MonitorClientFactory{name='" + getClass().getName() + "'}";
    }
}
