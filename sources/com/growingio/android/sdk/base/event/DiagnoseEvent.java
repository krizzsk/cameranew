package com.growingio.android.sdk.base.event;
/* loaded from: classes2.dex */
public class DiagnoseEvent {
    public int count;
    public String type;

    public DiagnoseEvent(String str, int i2) {
        this.count = -1;
        this.type = str;
        this.count = i2;
    }

    public DiagnoseEvent(String str) {
        this.count = -1;
        this.type = str;
    }
}
