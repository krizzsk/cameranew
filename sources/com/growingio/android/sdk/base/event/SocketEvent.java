package com.growingio.android.sdk.base.event;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SocketEvent {
    public String circleRoomNumber;
    public JSONObject debuggerJson;
    public String key;
    public Class<?> loadClass;
    public String message;
    public EVENT_TYPE type;
    public String wsUrl;

    /* loaded from: classes2.dex */
    public enum EVENT_TYPE {
        SEND,
        SEND_DEBUGGER,
        SCREEN_UPDATE
    }

    public SocketEvent(EVENT_TYPE event_type, String str, String str2, String str3) {
        this.type = event_type;
        this.circleRoomNumber = str;
        this.wsUrl = str2;
        this.key = str3;
    }

    public SocketEvent(EVENT_TYPE event_type, String str) {
        this.type = event_type;
        this.message = str;
    }

    public SocketEvent(EVENT_TYPE event_type, Class<?> cls) {
        this.type = event_type;
        this.loadClass = cls;
    }

    public SocketEvent(EVENT_TYPE event_type, JSONObject jSONObject) {
        this.type = event_type;
        this.debuggerJson = jSONObject;
    }

    public SocketEvent(EVENT_TYPE event_type) {
        this.type = event_type;
    }
}
