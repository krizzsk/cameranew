package com.growingio.android.sdk.base.event.message;
/* loaded from: classes2.dex */
public class MessageEvent {
    public MessageType messageType;

    /* loaded from: classes2.dex */
    public enum MessageType {
        IMP
    }

    public MessageEvent(MessageType messageType) {
        this.messageType = messageType;
    }
}
