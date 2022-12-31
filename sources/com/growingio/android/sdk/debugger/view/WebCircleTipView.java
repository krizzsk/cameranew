package com.growingio.android.sdk.debugger.view;

import android.content.Context;
/* loaded from: classes2.dex */
public class WebCircleTipView extends CircleTipView {
    public WebCircleTipView(Context context) {
        super(context);
    }

    @Override // com.growingio.android.sdk.debugger.view.CircleTipView
    public void doing() {
        setError(false);
        setContent("正在进行GrowingIO移动端圈选");
    }

    @Override // com.growingio.android.sdk.debugger.view.CircleTipView
    public String getStrDialogCancel() {
        return "继续圈选";
    }

    @Override // com.growingio.android.sdk.debugger.view.CircleTipView
    public String getStrDialogOk() {
        return "退出圈选";
    }

    @Override // com.growingio.android.sdk.debugger.view.CircleTipView
    public String getStrDialogTittle() {
        return "正在进行圈选";
    }

    @Override // com.growingio.android.sdk.debugger.view.CircleTipView
    public void show() {
        super.show();
    }
}
