package us.pinguo.ui.widget.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
public class DrawableIndicator extends BaseIndicator {

    /* renamed from: i  reason: collision with root package name */
    private Drawable f12262i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f12263j;

    public DrawableIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setGapWidth((int) (getResources().getDisplayMetrics().density * 4.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DrawableIndicator, 0, 0);
        this.f12262i = getResources().getDrawable(obtainStyledAttributes.getResourceId(R.styleable.DrawableIndicator_indicator, R.drawable.page_indicator));
        this.f12263j = getResources().getDrawable(obtainStyledAttributes.getResourceId(R.styleable.DrawableIndicator_indicator_selected, R.drawable.page_indicator_focused));
        Drawable drawable = this.f12262i;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f12262i.getIntrinsicHeight());
        Drawable drawable2 = this.f12263j;
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.f12263j.getIntrinsicHeight());
        obtainStyledAttributes.recycle();
    }

    private void h(Canvas canvas, Drawable drawable) {
        canvas.save();
        canvas.translate((e() - drawable.getIntrinsicWidth()) / 2, (d() - drawable.getIntrinsicHeight()) / 2);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // us.pinguo.ui.widget.banner.BaseIndicator
    protected void b(Canvas canvas, int i2, int i3, int i4, float f2) {
        if (this.f12262i == null || this.f12263j == null) {
            return;
        }
        canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        canvas.translate((e() + g()) * i2, 0.0f);
        if (i2 == f()) {
            h(canvas, this.f12263j);
        } else {
            h(canvas, this.f12262i);
        }
        canvas.restore();
    }

    @Override // us.pinguo.ui.widget.banner.BaseIndicator
    public int d() {
        Drawable drawable = this.f12262i;
        if (drawable == null || this.f12263j == null) {
            return 0;
        }
        return Math.max(drawable.getIntrinsicHeight(), this.f12263j.getIntrinsicHeight());
    }

    @Override // us.pinguo.ui.widget.banner.BaseIndicator
    public int e() {
        Drawable drawable = this.f12262i;
        if (drawable == null || this.f12263j == null) {
            return 0;
        }
        return Math.max(drawable.getIntrinsicWidth(), this.f12263j.getIntrinsicWidth());
    }

    public void setCellDrawable(Drawable drawable, Drawable drawable2) {
        this.f12262i = drawable;
        this.f12263j = drawable2;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f12262i.getIntrinsicHeight());
        Drawable drawable3 = this.f12263j;
        drawable3.setBounds(0, 0, drawable3.getIntrinsicWidth(), this.f12263j.getIntrinsicHeight());
        requestLayout();
    }

    public DrawableIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawableIndicator(Context context) {
        this(context, null);
    }
}
