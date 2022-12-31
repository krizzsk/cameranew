package us.pinguo.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
/* loaded from: classes6.dex */
public class CornerViewGroup extends FrameLayout {
    Canvas a;
    private Bitmap b;

    public CornerViewGroup(Context context) {
        super(context);
        this.a = null;
    }

    Canvas a(int i2, int i3) {
        if (this.a == null) {
            Path path = new Path();
            float a = us.pinguo.foundation.t.b.a.a(getContext(), 10.0f);
            path.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), a, a, Path.Direction.CW);
            this.b = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
            this.a = new Canvas(this.b);
        }
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(a(getMeasuredHeight(), getMeasuredWidth()));
        int a = us.pinguo.foundation.t.b.a.a(getContext(), 10.0f);
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        Paint paint = new Paint();
        Bitmap bitmap = this.b;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        float f2 = a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
    }

    public CornerViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
    }

    public CornerViewGroup(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = null;
    }
}
