package com.growingio.android.sdk.base.event;

import android.view.View;
/* loaded from: classes2.dex */
public class ViewTreeStatusChangeEvent {
    private View newFocus;
    private View oldFocus;
    private StatusType statusType;

    /* loaded from: classes2.dex */
    public enum StatusType {
        FocusChanged,
        LayoutChanged,
        ScrollChanged
    }

    public ViewTreeStatusChangeEvent(StatusType statusType) {
        this.statusType = statusType;
    }

    public View getNewFocus() {
        return this.newFocus;
    }

    public View getOldFocus() {
        return this.oldFocus;
    }

    public StatusType getStatusType() {
        return this.statusType;
    }

    public ViewTreeStatusChangeEvent(StatusType statusType, View view, View view2) {
        this.statusType = statusType;
        this.oldFocus = view;
        this.newFocus = view2;
    }
}
