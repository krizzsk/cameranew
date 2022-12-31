package com.growingio.android.sdk.crash;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.monitor.event.Event;
import com.growingio.android.sdk.monitor.event.EventBuilder;
import com.growingio.android.sdk.monitor.event.interfaces.ExceptionInterface;
import com.growingio.android.sdk.monitor.log.MonitorLogger;
import com.growingio.android.sdk.utils.LogUtil;
/* loaded from: classes2.dex */
public class CrashUtil extends LogUtil.Util {
    public static final int ALARM = 8;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SingleInstance {
        private static final CrashUtil INSTANCE = new CrashUtil();

        private SingleInstance() {
        }
    }

    public static CrashUtil getInstance() {
        return SingleInstance.INSTANCE;
    }

    @Override // com.growingio.android.sdk.utils.LogUtil.Util
    protected void log(int i2, @Nullable String str, @NonNull String str2, @Nullable Throwable th) {
        if (i2 > 8) {
            return;
        }
        if (i2 == 2) {
            MonitorLogger.v(CrashManager.ALIAS, str, str2);
        } else if (i2 == 3) {
            MonitorLogger.d(CrashManager.ALIAS, str, str2);
        } else if (i2 == 4 || i2 == 5) {
            MonitorLogger.i(CrashManager.ALIAS, str, str2);
        } else if (i2 == 6) {
            MonitorLogger.e(CrashManager.ALIAS, str, str2);
        } else if (i2 != 8) {
        } else {
            CrashManager.sendEvent(new EventBuilder().withMessage(str2).withLevel(Event.Level.ERROR).withMonitorInterface(new ExceptionInterface(th)));
        }
    }

    private CrashUtil() {
    }
}
