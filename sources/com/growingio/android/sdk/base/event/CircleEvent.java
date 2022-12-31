package com.growingio.android.sdk.base.event;

import com.growingio.android.sdk.models.ViewNode;
/* loaded from: classes2.dex */
public class CircleEvent {
    public String type;
    public ViewNode viewNode;

    public CircleEvent(String str) {
        this.type = str;
    }

    public CircleEvent(String str, ViewNode viewNode) {
        this.type = str;
        this.viewNode = viewNode;
    }
}
