package com.growingio.android.sdk.circle.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class TagMask extends View {
    public TagMask(Context context) {
        super(context);
    }

    public void updatePosition(Rect rect) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = rect.left;
        layoutParams.topMargin = rect.top;
        layoutParams.width = rect.width();
        layoutParams.height = rect.height();
        setLayoutParams(layoutParams);
    }
}
