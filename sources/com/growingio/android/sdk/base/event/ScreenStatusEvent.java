package com.growingio.android.sdk.base.event;
/* loaded from: classes2.dex */
public class ScreenStatusEvent {
    public ScreenStatusType type;

    /* loaded from: classes2.dex */
    public enum ScreenStatusType {
        SCREEN_ON,
        SCREEN_OFF,
        SCREEN_PRESENT
    }

    public ScreenStatusEvent(ScreenStatusType screenStatusType) {
        this.type = screenStatusType;
    }
}
