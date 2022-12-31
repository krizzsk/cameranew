package com.growingio.android.sdk.monitor.event.interfaces;

import java.util.Deque;
/* loaded from: classes2.dex */
public class ExceptionInterface implements MonitorInterface {
    public static final String EXCEPTION_INTERFACE = "sentry.interfaces.Exception";
    private final Deque<MonitorException> exceptions;

    public ExceptionInterface(Throwable th) {
        this(MonitorException.extractExceptionQueue(th));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.exceptions.equals(((ExceptionInterface) obj).exceptions);
    }

    public Deque<MonitorException> getExceptions() {
        return this.exceptions;
    }

    @Override // com.growingio.android.sdk.monitor.event.interfaces.MonitorInterface
    public String getInterfaceName() {
        return EXCEPTION_INTERFACE;
    }

    public int hashCode() {
        return this.exceptions.hashCode();
    }

    public String toString() {
        return "ExceptionInterface{exceptions=" + this.exceptions + '}';
    }

    public ExceptionInterface(Deque<MonitorException> deque) {
        this.exceptions = deque;
    }
}
