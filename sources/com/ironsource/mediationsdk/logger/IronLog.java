package com.ironsource.mediationsdk.logger;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
/* loaded from: classes2.dex */
public enum IronLog {
    API(IronSourceLogger.IronSourceTag.API),
    CALLBACK(IronSourceLogger.IronSourceTag.CALLBACK),
    ADAPTER_API(IronSourceLogger.IronSourceTag.ADAPTER_API),
    ADAPTER_CALLBACK(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK),
    NETWORK(IronSourceLogger.IronSourceTag.NETWORK),
    INTERNAL(IronSourceLogger.IronSourceTag.INTERNAL),
    NATIVE(IronSourceLogger.IronSourceTag.NATIVE),
    EVENT(IronSourceLogger.IronSourceTag.EVENT);
    
    IronSourceLogger.IronSourceTag mTag;

    IronLog(IronSourceLogger.IronSourceTag ironSourceTag) {
        this.mTag = ironSourceTag;
    }

    private String createLogMessage(String str) {
        return str.isEmpty() ? getLogPrefix() : String.format("%s - %s", getLogPrefix(), str);
    }

    private String getClassName(StackTraceElement[] stackTraceElementArr, int i2) {
        String[] split = stackTraceElementArr[i2].getClassName().split("\\.");
        String str = split[split.length - 1];
        return str.contains("$") ? str.split("\\$")[0] : str;
    }

    private String getLogPrefix() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return String.format("%s %s", getClassName(stackTrace, 5), getMethodName(stackTrace, 5));
    }

    private String getMethodName(StackTraceElement[] stackTraceElementArr, int i2) {
        String[] split = stackTraceElementArr[i2].getClassName().split("\\.");
        String str = split[split.length - 1];
        if (str.contains("$")) {
            String[] split2 = str.split("\\$");
            return split2[1] + "." + stackTraceElementArr[i2].getMethodName();
        } else if (stackTraceElementArr[i2].getMethodName().contains("$")) {
            int i3 = i2 + 1;
            String[] split3 = stackTraceElementArr[i3].getClassName().split("\\$");
            if (split3.length > 1) {
                return split3[1] + "." + stackTraceElementArr[i3].getMethodName();
            }
            return stackTraceElementArr[i3].getMethodName();
        } else {
            return stackTraceElementArr[i2].getMethodName();
        }
    }

    public void error(String str) {
        c.i().d(this.mTag, createLogMessage(str), 3);
    }

    public void info(String str) {
        c.i().d(this.mTag, createLogMessage(str), 1);
    }

    public void verbose(String str) {
        c.i().d(this.mTag, createLogMessage(str), 0);
    }

    public void warning(String str) {
        c.i().d(this.mTag, createLogMessage(str), 2);
    }
}
