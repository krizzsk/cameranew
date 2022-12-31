package com.growingio.android.sdk.base.event;
/* loaded from: classes2.dex */
public class SocketStatusEvent {
    public SocketStatus event_type;
    public Object obj;

    /* loaded from: classes2.dex */
    public enum SocketStatus {
        ERROR,
        SERVER_STARTED,
        REMOTE_CLOSE,
        EDITOR_READY,
        EDITOR_QUIT,
        HYBRID_MESSAGE,
        OTHER_MESSAGE,
        CLIENT_QUIT
    }

    private SocketStatusEvent(SocketStatus socketStatus, Object obj) {
        this.event_type = socketStatus;
        this.obj = obj;
    }

    public static SocketStatusEvent ofStatus(SocketStatus socketStatus) {
        return new SocketStatusEvent(socketStatus, null);
    }

    public static SocketStatusEvent ofStatusAndObj(SocketStatus socketStatus, Object obj) {
        return new SocketStatusEvent(socketStatus, obj);
    }
}
