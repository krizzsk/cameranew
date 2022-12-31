package us.pinguo.inspire.module.feeds.view;

import android.graphics.drawable.GradientDrawable;
/* loaded from: classes9.dex */
public class FeedsGradientDrawable extends GradientDrawable {
    private int mBgColor;
    private int mStrokeColor;

    public int getBgColor() {
        return this.mBgColor;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    @Override // android.graphics.drawable.GradientDrawable
    public void setColor(int i2) {
        super.setColor(i2);
        this.mBgColor = i2;
    }

    @Override // android.graphics.drawable.GradientDrawable
    public void setStroke(int i2, int i3) {
        super.setStroke(i2, i3);
        this.mStrokeColor = i3;
    }
}
