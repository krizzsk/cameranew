package com.pinguo.camera360.lib.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class WebviewToolbar extends Toolbar {
    public WebviewToolbar(Context context) {
        super(context);
        View.inflate(context, R.layout.layout_webview_actionbar, this);
    }

    public WebviewToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R.layout.layout_webview_actionbar, this);
    }

    public WebviewToolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        View.inflate(context, R.layout.layout_webview_actionbar, this);
    }
}
