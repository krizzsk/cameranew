package vStudio.Android.Camera360.guide.view.morphingbutton;

import android.graphics.drawable.GradientDrawable;
/* loaded from: classes7.dex */
public class StrokeGradientDrawable {
    private int mColor;
    private GradientDrawable mGradientDrawable;
    private float mRadius;
    private int mStrokeColor;
    private int mStrokeWidth;

    public StrokeGradientDrawable(GradientDrawable gradientDrawable) {
        this.mGradientDrawable = gradientDrawable;
    }

    public int getColor() {
        return this.mColor;
    }

    public GradientDrawable getGradientDrawable() {
        return this.mGradientDrawable;
    }

    public float getRadius() {
        return this.mRadius;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    public int getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public void setColor(int i2) {
        this.mColor = i2;
        this.mGradientDrawable.setColor(i2);
    }

    public void setCornerRadius(float f2) {
        this.mRadius = f2;
        this.mGradientDrawable.setCornerRadius(f2);
    }

    public void setStrokeColor(int i2) {
        this.mStrokeColor = i2;
        this.mGradientDrawable.setStroke(getStrokeWidth(), i2);
    }

    public void setStrokeWidth(int i2) {
        this.mStrokeWidth = i2;
        this.mGradientDrawable.setStroke(i2, getStrokeColor());
    }
}
