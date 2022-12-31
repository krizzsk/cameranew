package com.pinguo.camera360.lib.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.common.imageloader.widget.ImageLoaderView;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class FixedRateImageLoaderView extends ImageLoaderView {

    /* renamed from: d  reason: collision with root package name */
    private float f6831d;

    public FixedRateImageLoaderView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(size, (int) (size / this.f6831d));
    }

    public void setRate(float f2) {
        this.f6831d = f2;
    }

    public FixedRateImageLoaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FixedRateImageLoaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6831d = 1.0f;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.FixedRateImageLoaderView);
        this.f6831d = obtainStyledAttributes.getFloat(0, 1.0f);
        obtainStyledAttributes.recycle();
    }
}
