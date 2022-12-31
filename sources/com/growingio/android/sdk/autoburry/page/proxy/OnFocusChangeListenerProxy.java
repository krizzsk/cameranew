package com.growingio.android.sdk.autoburry.page.proxy;

import android.view.View;
import android.widget.EditText;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ViewHelper;
/* loaded from: classes2.dex */
public class OnFocusChangeListenerProxy implements View.OnFocusChangeListener {
    private static final String TAG = "GIO.OnFocusChangeListenerProxy";
    private View.OnFocusChangeListener object;

    public OnFocusChangeListenerProxy(View.OnFocusChangeListener onFocusChangeListener) {
        this.object = onFocusChangeListener;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        LogUtil.i(TAG, view.toString());
        if (view instanceof EditText) {
            ViewHelper.changeOn(view);
        }
        View.OnFocusChangeListener onFocusChangeListener = this.object;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view, z);
        }
    }
}
