package com.growingio.eventcenter.bus;
/* loaded from: classes2.dex */
public class EventCenterException extends RuntimeException {
    private static final long serialVersionUID = -2912559384646531479L;

    public EventCenterException(String str) {
        super(str);
    }

    public EventCenterException(Throwable th) {
        super(th);
    }

    public EventCenterException(String str, Throwable th) {
        super(str, th);
    }
}
