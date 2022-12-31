package com.growingio.android.sdk.base.event;
/* loaded from: classes2.dex */
public class HeatMapEvent {
    public EVENT_TYPE type;

    /* loaded from: classes2.dex */
    public enum EVENT_TYPE {
        INIT,
        STATE_OFF,
        STATE_ON,
        SHOW,
        HIDE,
        UPDATE
    }

    public HeatMapEvent(EVENT_TYPE event_type) {
        this.type = event_type;
    }
}
