package com.growingio.android.sdk.base.event.message;
/* loaded from: classes2.dex */
public class HandleEvent {
    public long delayTime;
    public MessageHandleType handleType;
    public Runnable runnable;

    /* loaded from: classes2.dex */
    public enum MessageHandleType {
        POST,
        POSTDELAY
    }

    public HandleEvent(Runnable runnable, MessageHandleType messageHandleType) {
        this.runnable = runnable;
        this.handleType = messageHandleType;
    }

    public HandleEvent(Runnable runnable, MessageHandleType messageHandleType, long j2) {
        this.runnable = runnable;
        this.handleType = messageHandleType;
        this.delayTime = j2;
    }
}
