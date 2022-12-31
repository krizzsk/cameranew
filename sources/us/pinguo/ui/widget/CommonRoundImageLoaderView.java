package us.pinguo.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import us.pinguo.common.imageloader.widget.ImageLoaderView;
/* loaded from: classes6.dex */
public class CommonRoundImageLoaderView extends ImageLoaderView {

    /* renamed from: d  reason: collision with root package name */
    private g f12114d;

    public CommonRoundImageLoaderView(Context context) {
        super(context);
        this.f12114d = new g(this, context, null, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f12114d.d(canvas);
    }

    public void setBorderRadius(int i2) {
        this.f12114d.e(i2);
    }

    public CommonRoundImageLoaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12114d = new g(this, context, attributeSet, 0);
    }

    public CommonRoundImageLoaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12114d = new g(this, context, attributeSet, i2);
    }
}
