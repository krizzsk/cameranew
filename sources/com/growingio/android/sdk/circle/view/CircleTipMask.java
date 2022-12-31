package com.growingio.android.sdk.circle.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.growingio.android.sdk.utils.ScreenshotHelper;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.view.FloatViewContainer;
/* loaded from: classes2.dex */
public class CircleTipMask extends FloatViewContainer {
    private int arrowHeight;
    private ImageView arrowImageView;
    private int arrowWidth;
    private int[] location;

    public CircleTipMask(Context context) {
        super(context);
        this.location = new int[2];
        init();
    }

    private void init() {
        setBackgroundColor(-1090519040);
        this.arrowImageView = new AppCompatImageView(getContext()) { // from class: com.growingio.android.sdk.circle.view.CircleTipMask.1
            Paint bgPaint;

            {
                Paint paint = new Paint();
                this.bgPaint = paint;
                paint.setColor(-1);
                this.bgPaint.setStyle(Paint.Style.FILL);
            }

            @Override // android.view.View
            @SuppressLint({"MissingSuperCall"})
            public void draw(Canvas canvas) {
                Path path = new Path();
                path.moveTo(getWidth() * 0.4f, 0.0f);
                path.lineTo(getWidth() * 0.6f, 0.0f);
                path.lineTo(getWidth() * 0.6f, getHeight() * 0.7f);
                path.lineTo(getWidth(), getHeight() * 0.7f);
                path.lineTo(getWidth() * 0.5f, getHeight());
                path.lineTo(0.0f, getHeight() * 0.7f);
                path.lineTo(getWidth() * 0.4f, getHeight() * 0.7f);
                path.close();
                canvas.drawPath(path, this.bgPaint);
            }
        };
        this.arrowWidth = Util.dp2Px(getContext(), 42.0f);
        this.arrowHeight = Util.dp2Px(getContext(), 80.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.arrowWidth, this.arrowHeight);
        layoutParams.gravity = 51;
        addView(this.arrowImageView, layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        getLocationOnScreen(this.location);
        boolean z2 = getContext().getResources().getConfiguration().orientation == 1;
        int screenShort = (((z2 ? ScreenshotHelper.getScreenShort() : ScreenshotHelper.getScreenLong()) - this.arrowWidth) / 2) - this.location[0];
        int screenLong = z2 ? ScreenshotHelper.getScreenLong() : ScreenshotHelper.getScreenShort();
        int i6 = this.arrowHeight;
        int i7 = (((screenLong - CircleAnchorView.ANCHOR_VIEW_SIZE) / 2) - i6) - this.location[1];
        this.arrowImageView.layout(screenShort, i7, this.arrowWidth + screenShort, i6 + i7);
    }
}
