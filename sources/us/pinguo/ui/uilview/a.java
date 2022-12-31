package us.pinguo.ui.uilview;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.c;
import us.pinguo.ui.a;
import us.pinguo.ui.uilview.b;
import us.pinguo.ui.uilview.d;
/* compiled from: CirclePhotoImgDrawable.java */
/* loaded from: classes6.dex */
public class a extends b {
    protected int a;
    protected int b = -1;
    protected final Paint c;

    public a() {
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.a);
        paint.setColor(this.b);
    }

    public void a(int i2) {
        this.a = i2;
        this.c.setStrokeWidth(i2);
    }

    @Override // us.pinguo.ui.uilview.b, us.pinguo.foundation.t.a.b, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), (this.mRect.width() / 2.0f) - this.a, this.mPaint);
        if (this.a > 0) {
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), (this.mRect.width() / 2.0f) - (this.a / 2), this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.b, us.pinguo.ui.uilview.d
    public void init() {
        this.mImageAware = new d.a();
        c.b bVar = new c.b();
        bVar.u(true);
        bVar.v(true);
        bVar.A(ImageScaleType.EXACTLY);
        a.C0453a c0453a = new a.C0453a();
        c0453a.b(true);
        c0453a.d(false);
        c0453a.e(true);
        bVar.z(c0453a);
        bVar.y(new b.a(500, true, true, false));
        bVar.D(true);
        this.mDisplayImageOptions = bVar.t();
    }
}
