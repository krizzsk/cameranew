package com.pinguo.camera360.ui.view;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.ViewCompat;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class HighlightView {
    View a;
    boolean b;
    boolean c;

    /* renamed from: e  reason: collision with root package name */
    Rect f7030e;

    /* renamed from: f  reason: collision with root package name */
    private RectF f7031f;

    /* renamed from: g  reason: collision with root package name */
    RectF f7032g;

    /* renamed from: h  reason: collision with root package name */
    Matrix f7033h;

    /* renamed from: j  reason: collision with root package name */
    private float f7035j;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f7037l;
    private Drawable m;
    private Drawable n;

    /* renamed from: d  reason: collision with root package name */
    private ModifyMode f7029d = ModifyMode.None;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7034i = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7036k = false;
    private final Paint o = new Paint();
    private final Paint p = new Paint();
    private final Paint q = new Paint();

    /* loaded from: classes3.dex */
    public enum ModifyMode {
        None,
        Move,
        Grow
    }

    public HighlightView(View view) {
        this.a = view;
    }

    private Rect a() {
        RectF rectF = this.f7032g;
        RectF rectF2 = new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom);
        this.f7033h.mapRect(rectF2);
        return new Rect(Math.round(rectF2.left), Math.round(rectF2.top), Math.round(rectF2.right), Math.round(rectF2.bottom));
    }

    private void h() {
        Resources resources = this.a.getResources();
        this.f7037l = resources.getDrawable(R.drawable.camera_crop_width);
        this.m = resources.getDrawable(R.drawable.camera_crop_height);
        this.n = resources.getDrawable(R.drawable.indicator_autocrop);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public void b(Canvas canvas) {
        if (this.c) {
            return;
        }
        canvas.save();
        Path path = new Path();
        if (!g()) {
            this.q.setColor(ViewCompat.MEASURED_STATE_MASK);
            canvas.drawRect(this.f7030e, this.q);
            return;
        }
        Rect rect = new Rect();
        this.a.getDrawingRect(rect);
        if (this.f7036k) {
            Rect rect2 = this.f7030e;
            float width = this.f7030e.width() / 2.0f;
            path.addCircle(rect2.left + width, rect2.top + (this.f7030e.height() / 2.0f), width, Path.Direction.CW);
            this.q.setColor(-1112874);
        } else {
            path.addRect(new RectF(this.f7030e), Path.Direction.CW);
            this.q.setColor(-30208);
        }
        canvas.clipPath(path, Region.Op.DIFFERENCE);
        canvas.drawRect(rect, g() ? this.o : this.p);
        canvas.restore();
        canvas.drawPath(path, this.q);
        if (this.f7029d == ModifyMode.Grow) {
            if (this.f7036k) {
                int intrinsicWidth = this.n.getIntrinsicWidth();
                int intrinsicHeight = this.n.getIntrinsicHeight();
                int round = (int) Math.round(Math.cos(0.7853981633974483d) * (this.f7030e.width() / 2.0d));
                Rect rect3 = this.f7030e;
                int width2 = ((rect3.left + (rect3.width() / 2)) + round) - (intrinsicWidth / 2);
                Rect rect4 = this.f7030e;
                int height = ((rect4.top + (rect4.height() / 2)) - round) - (intrinsicHeight / 2);
                Drawable drawable = this.n;
                drawable.setBounds(width2, height, drawable.getIntrinsicWidth() + width2, this.n.getIntrinsicHeight() + height);
                this.n.draw(canvas);
                return;
            }
            Rect rect5 = this.f7030e;
            int i2 = rect5.left + 1;
            int i3 = rect5.right + 1;
            int i4 = rect5.top + 4;
            int i5 = rect5.bottom + 3;
            int intrinsicWidth2 = this.f7037l.getIntrinsicWidth() / 2;
            int intrinsicHeight2 = this.f7037l.getIntrinsicHeight() / 2;
            int intrinsicHeight3 = this.m.getIntrinsicHeight() / 2;
            int intrinsicWidth3 = this.m.getIntrinsicWidth() / 2;
            Rect rect6 = this.f7030e;
            int i6 = rect6.left;
            int i7 = i6 + ((rect6.right - i6) / 2);
            int i8 = rect6.top;
            int i9 = i8 + ((rect6.bottom - i8) / 2);
            int i10 = i9 - intrinsicHeight2;
            int i11 = i9 + intrinsicHeight2;
            this.f7037l.setBounds(i2 - intrinsicWidth2, i10, i2 + intrinsicWidth2, i11);
            this.f7037l.draw(canvas);
            this.f7037l.setBounds(i3 - intrinsicWidth2, i10, i3 + intrinsicWidth2, i11);
            this.f7037l.draw(canvas);
            int i12 = i7 - intrinsicWidth3;
            int i13 = i7 + intrinsicWidth3;
            this.m.setBounds(i12, i4 - intrinsicHeight3, i13, i4 + intrinsicHeight3);
            this.m.draw(canvas);
            this.m.setBounds(i12, i5 - intrinsicHeight3, i13, i5 + intrinsicHeight3);
            this.m.draw(canvas);
        }
    }

    public Rect c() {
        RectF rectF = this.f7032g;
        return new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public int d(float f2, float f3) {
        Rect a = a();
        if (this.f7036k) {
            float centerX = f2 - a.centerX();
            float centerY = f3 - a.centerY();
            int sqrt = (int) Math.sqrt((centerX * centerX) + (centerY * centerY));
            int width = this.f7030e.width() / 2;
            return ((float) Math.abs(sqrt - width)) <= 20.0f ? Math.abs(centerY) > Math.abs(centerX) ? centerY < 0.0f ? 8 : 16 : centerX < 0.0f ? 2 : 4 : sqrt < width ? 32 : 1;
        }
        boolean z = false;
        boolean z2 = f3 >= ((float) a.top) - 20.0f && f3 < ((float) a.bottom) + 20.0f;
        int i2 = a.left;
        if (f2 >= i2 - 20.0f && f2 < a.right + 20.0f) {
            z = true;
        }
        int i3 = (Math.abs(((float) i2) - f2) >= 20.0f || !z2) ? 1 : 3;
        if (Math.abs(a.right - f2) < 20.0f && z2) {
            i3 |= 4;
        }
        if (Math.abs(a.top - f3) < 20.0f && z) {
            i3 |= 8;
        }
        if (Math.abs(a.bottom - f3) < 20.0f && z) {
            i3 |= 16;
        }
        if (i3 == 1 && a.contains((int) f2, (int) f3)) {
            return 32;
        }
        return i3;
    }

    void e(float f2, float f3) {
        if (this.f7034i) {
            if (f2 != 0.0f) {
                f3 = f2 / this.f7035j;
            } else if (f3 != 0.0f) {
                f2 = this.f7035j * f3;
            }
        }
        RectF rectF = new RectF(this.f7032g);
        if (f2 > 0.0f && rectF.width() + (f2 * 2.0f) > this.f7031f.width()) {
            f2 = (this.f7031f.width() - rectF.width()) / 2.0f;
            if (this.f7034i) {
                f3 = f2 / this.f7035j;
            }
        }
        if (f3 > 0.0f && rectF.height() + (f3 * 2.0f) > this.f7031f.height()) {
            f3 = (this.f7031f.height() - rectF.height()) / 2.0f;
            if (this.f7034i) {
                f2 = this.f7035j * f3;
            }
        }
        rectF.inset(-f2, -f3);
        if (rectF.width() < 25.0f) {
            rectF.inset((-(25.0f - rectF.width())) / 2.0f, 0.0f);
        }
        float f4 = this.f7034i ? 25.0f / this.f7035j : 25.0f;
        if (rectF.height() < f4) {
            rectF.inset(0.0f, (-(f4 - rectF.height())) / 2.0f);
        }
        float f5 = rectF.left;
        RectF rectF2 = this.f7031f;
        float f6 = rectF2.left;
        if (f5 < f6) {
            rectF.offset(f6 - f5, 0.0f);
        } else {
            float f7 = rectF.right;
            float f8 = rectF2.right;
            if (f7 > f8) {
                rectF.offset(-(f7 - f8), 0.0f);
            }
        }
        float f9 = rectF.top;
        RectF rectF3 = this.f7031f;
        float f10 = rectF3.top;
        if (f9 < f10) {
            rectF.offset(0.0f, f10 - f9);
        } else {
            float f11 = rectF.bottom;
            float f12 = rectF3.bottom;
            if (f11 > f12) {
                rectF.offset(0.0f, -(f11 - f12));
            }
        }
        this.f7032g.set(rectF);
        this.f7030e = a();
        this.a.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i2, float f2, float f3) {
        Rect a = a();
        if (i2 == 1) {
            return;
        }
        if (i2 == 32) {
            j(f2 * (this.f7032g.width() / a.width()), f3 * (this.f7032g.height() / a.height()));
            return;
        }
        if ((i2 & 6) == 0) {
            f2 = 0.0f;
        }
        if ((i2 & 24) == 0) {
            f3 = 0.0f;
        }
        e(((i2 & 2) != 0 ? -1 : 1) * f2 * (this.f7032g.width() / a.width()), ((i2 & 8) != 0 ? -1 : 1) * f3 * (this.f7032g.height() / a.height()));
    }

    public boolean g() {
        return this.b;
    }

    public void i() {
        this.f7030e = a();
    }

    void j(float f2, float f3) {
        Rect rect = new Rect(this.f7030e);
        this.f7032g.offset(f2, f3);
        RectF rectF = this.f7032g;
        rectF.offset(Math.max(0.0f, this.f7031f.left - rectF.left), Math.max(0.0f, this.f7031f.top - this.f7032g.top));
        RectF rectF2 = this.f7032g;
        rectF2.offset(Math.min(0.0f, this.f7031f.right - rectF2.right), Math.min(0.0f, this.f7031f.bottom - this.f7032g.bottom));
        Rect a = a();
        this.f7030e = a;
        rect.union(a);
        rect.inset(-10, -10);
        this.a.invalidate(rect);
    }

    public void k(boolean z) {
        this.b = z;
    }

    public void l(boolean z) {
        this.c = z;
    }

    public void m(ModifyMode modifyMode) {
        if (modifyMode != this.f7029d) {
            this.f7029d = modifyMode;
            this.a.invalidate();
        }
    }

    public void n(Matrix matrix, Rect rect, RectF rectF, boolean z, boolean z2) {
        if (z) {
            z2 = true;
        }
        this.f7033h = new Matrix(matrix);
        this.f7032g = rectF;
        this.f7031f = new RectF(rect);
        this.f7034i = z2;
        this.f7036k = z;
        this.f7035j = this.f7032g.width() / this.f7032g.height();
        this.f7030e = a();
        this.o.setARGB(125, 50, 50, 50);
        this.p.setARGB(125, 50, 50, 50);
        this.q.setStrokeWidth(3.0f);
        this.q.setStyle(Paint.Style.STROKE);
        this.q.setAntiAlias(true);
        this.f7029d = ModifyMode.None;
        h();
    }
}
