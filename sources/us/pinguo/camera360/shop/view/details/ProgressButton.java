package us.pinguo.camera360.shop.view.details;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.Button;
import us.pinguo.foundation.utils.n0;
import vStudio.Android.Camera360.R;
/* loaded from: classes4.dex */
public class ProgressButton extends Button {
    private int a;
    private int b;
    private Drawable c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f9745d;

    /* renamed from: e  reason: collision with root package name */
    private Rect f9746e;

    /* renamed from: f  reason: collision with root package name */
    private int f9747f;

    public ProgressButton(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        this.f9746e.set(0, 0, getWidth(), getHeight());
        this.c.setBounds(this.f9746e);
        this.f9745d.setBounds(this.f9746e);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.c.draw(canvas);
        Rect rect = new Rect((int) ((this.b / 100.0f) * measuredWidth), 0, measuredWidth, measuredHeight);
        canvas.save();
        canvas.clipRect(rect);
        this.f9745d.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.b = this.a;
        a(canvas);
        super.draw(canvas);
    }

    public void setProgress(int i2) {
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > 100) {
            i2 = 100;
        }
        if (i2 != this.a) {
            this.a = i2;
            this.b = i2;
            invalidate();
        }
    }

    public void setProgressDrawableColor(int i2) {
        if (i2 != this.f9747f) {
            this.f9747f = i2;
            float c = n0.c(4);
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{c, c, c, c, c, c, c, c}, null, null));
            this.f9745d = shapeDrawable;
            shapeDrawable.getPaint().setColor(i2);
            invalidate();
        }
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9746e = new Rect();
        this.f9747f = -670440;
        new Paint().setAntiAlias(true);
        Resources resources = getResources();
        this.c = resources.getDrawable(R.drawable.foreground_btn_install_progress);
        this.f9745d = resources.getDrawable(R.drawable.background_btn_install_progress);
    }
}
