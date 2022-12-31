package com.ironsource.environment;

import android.os.Build;
import java.lang.Thread;
/* compiled from: CrashHandler.java */
/* loaded from: classes2.dex */
public class d implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        StackTraceElement[] stackTrace;
        if (Build.VERSION.SDK_INT >= 19) {
            StackTraceElement[] stackTrace2 = th.getStackTrace();
            StringBuilder sb = new StringBuilder();
            sb.append(th.toString());
            sb.append(System.lineSeparator());
            boolean z = false;
            for (StackTraceElement stackTraceElement : stackTrace2) {
                sb.append(stackTraceElement.toString());
                sb.append(";" + System.lineSeparator());
                if (stackTraceElement.toString().contains(CrashReporter.getInstance().h())) {
                    z = true;
                }
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                sb.append("--CAUSE");
                sb.append(System.lineSeparator());
                sb.append(cause.toString());
                sb.append(System.lineSeparator());
                for (StackTraceElement stackTraceElement2 : cause.getStackTrace()) {
                    sb.append(stackTraceElement2.toString());
                    sb.append(";" + System.lineSeparator());
                    if (stackTraceElement2.toString().contains(CrashReporter.getInstance().h())) {
                        z = true;
                    }
                }
            }
            if (z) {
                new f(sb.toString(), "" + System.currentTimeMillis(), "Crash").a();
            }
            this.a.uncaughtException(thread, th);
        }
    }
}
