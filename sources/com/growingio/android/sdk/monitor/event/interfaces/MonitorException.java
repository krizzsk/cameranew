package com.growingio.android.sdk.monitor.event.interfaces;

import com.growingio.android.sdk.monitor.jvmti.FrameCache;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
/* loaded from: classes2.dex */
public final class MonitorException implements Serializable {
    public static final String DEFAULT_PACKAGE_NAME = "(default)";
    private final String exceptionClassName;
    private final String exceptionMessage;
    private final String exceptionPackageName;
    private final StackTraceInterface stackTraceInterface;

    public MonitorException(Throwable th, StackTraceElement[] stackTraceElementArr) {
        this.exceptionMessage = th.getMessage();
        this.exceptionClassName = th.getClass().getSimpleName();
        Package r0 = th.getClass().getPackage();
        this.exceptionPackageName = r0 != null ? r0.getName() : null;
        this.stackTraceInterface = new StackTraceInterface(th.getStackTrace(), stackTraceElementArr, FrameCache.get(th));
    }

    public static Deque<MonitorException> extractExceptionQueue(Throwable th) {
        ArrayDeque arrayDeque = new ArrayDeque();
        HashSet hashSet = new HashSet();
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[0];
        while (th != null && hashSet.add(th)) {
            arrayDeque.add(new MonitorException(th, stackTraceElementArr));
            stackTraceElementArr = th.getStackTrace();
            th = th.getCause();
        }
        return arrayDeque;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MonitorException.class != obj.getClass()) {
            return false;
        }
        MonitorException monitorException = (MonitorException) obj;
        if (this.exceptionClassName.equals(monitorException.exceptionClassName)) {
            String str = this.exceptionMessage;
            if (str == null ? monitorException.exceptionMessage == null : str.equals(monitorException.exceptionMessage)) {
                String str2 = this.exceptionPackageName;
                if (str2 == null ? monitorException.exceptionPackageName == null : str2.equals(monitorException.exceptionPackageName)) {
                    return this.stackTraceInterface.equals(monitorException.stackTraceInterface);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public String getExceptionClassName() {
        return this.exceptionClassName;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }

    public String getExceptionPackageName() {
        String str = this.exceptionPackageName;
        return str != null ? str : DEFAULT_PACKAGE_NAME;
    }

    public StackTraceInterface getStackTraceInterface() {
        return this.stackTraceInterface;
    }

    public int hashCode() {
        String str = this.exceptionMessage;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.exceptionClassName.hashCode()) * 31;
        String str2 = this.exceptionPackageName;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "MonitorException{exceptionMessage='" + this.exceptionMessage + "', exceptionClassName='" + this.exceptionClassName + "', exceptionPackageName='" + this.exceptionPackageName + "', stackTraceInterface=" + this.stackTraceInterface + '}';
    }

    public MonitorException(String str, String str2, String str3, StackTraceInterface stackTraceInterface) {
        this.exceptionMessage = str;
        this.exceptionClassName = str2;
        this.exceptionPackageName = str3;
        this.stackTraceInterface = stackTraceInterface;
    }
}
