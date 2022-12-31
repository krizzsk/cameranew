package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import java.util.Objects;
/* compiled from: GlideBitmapDrawable.java */
/* loaded from: classes.dex */
public class f extends com.bumptech.glide.load.h.e.b {
    private final Rect a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f779d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f780e;

    /* renamed from: f  reason: collision with root package name */
    private a f781f;

    /* compiled from: GlideBitmapDrawable.java */
    /* loaded from: classes.dex */
    static class a extends Drawable.ConstantState {

        /* renamed from: d  reason: collision with root package name */
        private static final Paint f782d = new Paint(6);
        final Bitmap a;
        int b;
        Paint c;

        public a(Bitmap bitmap) {
            this.c = f782d;
            this.a = bitmap;
        }

        void a() {
            if (f782d == this.c) {
                this.c = new Paint(6);
            }
        }

        void b(int i2) {
            a();
            this.c.setAlpha(i2);
        }

        void c(ColorFilter colorFilter) {
            a();
            this.c.setColorFilter(colorFilter);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new f((Resources) null, this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new f(resources, this);
        }

        a(a aVar) {
            this(aVar.a);
            this.b = aVar.b;
        }
    }

    public f(Resources resources, Bitmap bitmap) {
        this(resources, new a(bitmap));
    }

    @Override // com.bumptech.glide.load.h.e.b
    public boolean b() {
        return false;
    }

    @Override // com.bumptech.glide.load.h.e.b
    public void c(int i2) {
    }

    public Bitmap d() {
        return this.f781f.a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f779d) {
            Gravity.apply(119, this.b, this.c, getBounds(), this.a);
            this.f779d = false;
        }
        a aVar = this.f781f;
        canvas.drawBitmap(aVar.a, (Rect) null, this.a, aVar.c);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f781f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap = this.f781f.a;
        return (bitmap == null || bitmap.hasAlpha() || this.f781f.c.getAlpha() < 255) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f780e && super.mutate() == this) {
            this.f781f = new a(this.f781f);
            this.f780e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f779d = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.f781f.c.getAlpha() != i2) {
            this.f781f.b(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f781f.c(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
    }

    f(Resources resources, a aVar) {
        int i2;
        this.a = new Rect();
        Objects.requireNonNull(aVar, "BitmapState must not be null");
        this.f781f = aVar;
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
            i2 = i2 == 0 ? 160 : i2;
            aVar.b = i2;
        } else {
            i2 = aVar.b;
        }
        this.b = aVar.a.getScaledWidth(i2);
        this.c = aVar.a.getScaledHeight(i2);
    }
}
