package com.growingio.android.sdk.debugger.view;

import android.content.Context;
/* loaded from: classes2.dex */
public class DebuggerCircleTipView extends CircleTipView {
    public DebuggerCircleTipView(Context context) {
        super(context);
    }

    @Override // com.growingio.android.sdk.debugger.view.CircleTipView
    public void doing() {
        setContent("正在进行Debugger...");
    }

    @Override // com.growingio.android.sdk.debugger.view.CircleTipView
    public String getStrDialogCancel() {
        return "继续Debugger";
    }

    @Override // com.growingio.android.sdk.debugger.view.CircleTipView
    public String getStrDialogOk() {
        return "退出Debugger";
    }

    @Override // com.growingio.android.sdk.debugger.view.CircleTipView
    public String getStrDialogTittle() {
        return "正在进行Debugger";
    }
}
