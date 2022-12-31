package us.pinguo.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
/* loaded from: classes6.dex */
public class CommonFixRateRoundImageView extends FixedRateImageLoaderView {

    /* renamed from: e  reason: collision with root package name */
    private g f12113e;

    public CommonFixRateRoundImageView(Context context) {
        super(context);
        this.f12113e = new g(this, context, null, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f12113e.d(canvas);
    }

    public void setBorderRadius(int i2) {
        this.f12113e.e(i2);
    }

    public CommonFixRateRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12113e = new g(this, context, attributeSet, 0);
    }

    public CommonFixRateRoundImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12113e = new g(this, context, attributeSet, i2);
    }
}
