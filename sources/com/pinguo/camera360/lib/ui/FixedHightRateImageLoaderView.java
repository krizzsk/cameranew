package com.pinguo.camera360.lib.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.common.imageloader.widget.ImageLoaderView;
/* loaded from: classes3.dex */
public class FixedHightRateImageLoaderView extends ImageLoaderView {

    /* renamed from: d  reason: collision with root package name */
    private float f6830d;

    public FixedHightRateImageLoaderView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec((int) (size * this.f6830d), 1073741824), View.MeasureSpec.makeMeasureSpec(size, 1073741824));
    }

    public void setRate(float f2) {
        this.f6830d = f2;
    }

    public FixedHightRateImageLoaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6830d = 2.0255184f;
    }
}
