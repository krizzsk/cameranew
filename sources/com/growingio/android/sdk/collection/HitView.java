package com.growingio.android.sdk.collection;

import android.view.View;
import com.growingio.android.sdk.models.Screenshot;
/* loaded from: classes2.dex */
public class HitView {
    private boolean mInFullScreenWindow;
    private String mIndex;
    private Screenshot mScreenshot;
    private View mView;
    private String mXPath;

    public String getIndex() {
        return this.mIndex;
    }

    public Screenshot getScreenshot() {
        return this.mScreenshot;
    }

    public View getView() {
        return this.mView;
    }

    public String getXPath() {
        return this.mXPath;
    }

    public boolean isInFullScreenWindow() {
        return this.mInFullScreenWindow;
    }

    public void setInFullScreenWindow(boolean z) {
        this.mInFullScreenWindow = z;
    }

    public void setIndex(String str) {
        this.mIndex = str;
    }

    public void setScreenshot(Screenshot screenshot) {
        this.mScreenshot = screenshot;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void setXPath(String str) {
        this.mXPath = str;
    }
}
