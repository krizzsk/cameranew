package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BorderDrawable.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class c extends Drawable {
    @NonNull
    private final Paint b;
    @Dimension

    /* renamed from: h  reason: collision with root package name */
    float f4288h;
    @ColorInt

    /* renamed from: i  reason: collision with root package name */
    private int f4289i;
    @ColorInt

    /* renamed from: j  reason: collision with root package name */
    private int f4290j;
    @ColorInt

    /* renamed from: k  reason: collision with root package name */
    private int f4291k;
    @ColorInt

    /* renamed from: l  reason: collision with root package name */
    private int f4292l;
    @ColorInt
    private int m;
    private m o;
    @Nullable
    private ColorStateList p;
    private final ShapeAppearancePathProvider a = ShapeAppearancePathProvider.getInstance();
    private final Path c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final Rect f4284d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final RectF f4285e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private final RectF f4286f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final b f4287g = new b();
    private boolean n = true;

    /* compiled from: BorderDrawable.java */
    /* loaded from: classes2.dex */
    private class b extends Drawable.ConstantState {
        private b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return c.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(m mVar) {
        this.o = mVar;
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @NonNull
    private Shader a() {
        Rect rect = this.f4284d;
        copyBounds(rect);
        float height = this.f4288h / rect.height();
        return new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{ColorUtils.compositeColors(this.f4289i, this.m), ColorUtils.compositeColors(this.f4290j, this.m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f4290j, 0), this.m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f4292l, 0), this.m), ColorUtils.compositeColors(this.f4292l, this.m), ColorUtils.compositeColors(this.f4291k, this.m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    @NonNull
    protected RectF b() {
        this.f4286f.set(getBounds());
        return this.f4286f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.m = colorStateList.getColorForState(getState(), this.m);
        }
        this.p = colorStateList;
        this.n = true;
        invalidateSelf();
    }

    public void d(@Dimension float f2) {
        if (this.f4288h != f2) {
            this.f4288h = f2;
            this.b.setStrokeWidth(f2 * 1.3333f);
            this.n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.n) {
            this.b.setShader(a());
            this.n = false;
        }
        float strokeWidth = this.b.getStrokeWidth() / 2.0f;
        copyBounds(this.f4284d);
        this.f4285e.set(this.f4284d);
        float min = Math.min(this.o.r().a(b()), this.f4285e.width() / 2.0f);
        if (this.o.u(b())) {
            this.f4285e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f4285e, min, min, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(@ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorInt int i5) {
        this.f4289i = i2;
        this.f4290j = i3;
        this.f4291k = i4;
        this.f4292l = i5;
    }

    public void f(m mVar) {
        this.o = mVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f4287g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f4288h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.o.u(b())) {
            outline.setRoundRect(getBounds(), this.o.r().a(b()));
            return;
        }
        copyBounds(this.f4284d);
        this.f4285e.set(this.f4284d);
        this.a.d(this.o, 1.0f, this.f4285e, this.c);
        if (this.c.isConvex()) {
            outline.setConvexPath(this.c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        if (this.o.u(b())) {
            int round = Math.round(this.f4288h);
            rect.set(round, round, round, round);
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.m)) != this.m) {
            this.n = true;
            this.m = colorForState;
        }
        if (this.n) {
            invalidateSelf();
        }
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.b.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
