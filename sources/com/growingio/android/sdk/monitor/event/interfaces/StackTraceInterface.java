package com.growingio.android.sdk.monitor.event.interfaces;

import com.growingio.android.sdk.monitor.jvmti.Frame;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class StackTraceInterface implements MonitorInterface {
    public static final String STACKTRACE_INTERFACE = "sentry.interfaces.Stacktrace";
    private final int framesCommonWithEnclosing;
    private final MonitorStackTraceElement[] stackTrace;

    public StackTraceInterface(StackTraceElement[] stackTraceElementArr) {
        this(stackTraceElementArr, new StackTraceElement[0], null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.stackTrace, ((StackTraceInterface) obj).stackTrace);
    }

    public int getFramesCommonWithEnclosing() {
        return this.framesCommonWithEnclosing;
    }

    @Override // com.growingio.android.sdk.monitor.event.interfaces.MonitorInterface
    public String getInterfaceName() {
        return STACKTRACE_INTERFACE;
    }

    public MonitorStackTraceElement[] getStackTrace() {
        MonitorStackTraceElement[] monitorStackTraceElementArr = this.stackTrace;
        return (MonitorStackTraceElement[]) Arrays.copyOf(monitorStackTraceElementArr, monitorStackTraceElementArr.length);
    }

    public int hashCode() {
        return Arrays.hashCode(this.stackTrace);
    }

    public String toString() {
        return "StackTraceInterface{stackTrace=" + Arrays.toString(this.stackTrace) + '}';
    }

    public StackTraceInterface(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        this(stackTraceElementArr, stackTraceElementArr2, null);
    }

    public StackTraceInterface(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2, Frame[] frameArr) {
        this.stackTrace = MonitorStackTraceElement.fromStackTraceElements(stackTraceElementArr, frameArr);
        int length = stackTraceElementArr.length - 1;
        for (int length2 = stackTraceElementArr2.length - 1; length >= 0 && length2 >= 0 && stackTraceElementArr[length].equals(stackTraceElementArr2[length2]); length2--) {
            length--;
        }
        this.framesCommonWithEnclosing = (stackTraceElementArr.length - 1) - length;
    }

    public StackTraceInterface(MonitorStackTraceElement[] monitorStackTraceElementArr) {
        this.stackTrace = (MonitorStackTraceElement[]) Arrays.copyOf(monitorStackTraceElementArr, monitorStackTraceElementArr.length);
        this.framesCommonWithEnclosing = 0;
    }
}
