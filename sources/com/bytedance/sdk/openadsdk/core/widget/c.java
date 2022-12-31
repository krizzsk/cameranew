package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.t;
/* compiled from: TTCustomShadowBackground.java */
/* loaded from: classes.dex */
public class c extends Drawable {
    @ColorInt
    private int a;
    @ColorInt
    private int b;
    @Nullable
    private int[] c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private float[] f1882d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private LinearGradient f1883e;

    /* renamed from: f  reason: collision with root package name */
    private int f1884f;

    /* renamed from: g  reason: collision with root package name */
    private int f1885g;

    /* renamed from: h  reason: collision with root package name */
    private int f1886h;

    /* renamed from: i  reason: collision with root package name */
    private int f1887i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private RectF f1888j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private Paint f1889k;

    /* compiled from: TTCustomShadowBackground.java */
    /* loaded from: classes.dex */
    public static class a {
        private int[] c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private float[] f1890d;

        /* renamed from: e  reason: collision with root package name */
        private LinearGradient f1891e;

        /* renamed from: h  reason: collision with root package name */
        private int f1894h;

        /* renamed from: i  reason: collision with root package name */
        private int f1895i;
        @ColorInt
        private int a = t.j(o.a(), "tt_ssxinmian8");
        @ColorInt
        private int b = t.j(o.a(), "tt_ssxinxian3");

        /* renamed from: f  reason: collision with root package name */
        private int f1892f = 10;

        /* renamed from: g  reason: collision with root package name */
        private int f1893g = 16;

        public a() {
            this.f1894h = 0;
            this.f1895i = 0;
            this.f1894h = 0;
            this.f1895i = 0;
        }

        public a a(@ColorInt int i2) {
            this.a = i2;
            return this;
        }

        public a b(@ColorInt int i2) {
            this.b = i2;
            return this;
        }

        public a c(int i2) {
            this.f1892f = i2;
            return this;
        }

        public a d(int i2) {
            this.f1894h = i2;
            return this;
        }

        public a e(int i2) {
            this.f1895i = i2;
            return this;
        }

        public a a(@Nullable int[] iArr) {
            this.c = iArr;
            return this;
        }

        public c a() {
            return new c(this.a, this.c, this.f1890d, this.b, this.f1891e, this.f1892f, this.f1893g, this.f1894h, this.f1895i);
        }
    }

    public c(@ColorInt int i2, @Nullable int[] iArr, @Nullable float[] fArr, @ColorInt int i3, @Nullable LinearGradient linearGradient, int i4, int i5, int i6, int i7) {
        this.a = i2;
        this.c = iArr;
        this.f1882d = fArr;
        this.b = i3;
        this.f1883e = linearGradient;
        this.f1884f = i4;
        this.f1885g = i5;
        this.f1886h = i6;
        this.f1887i = i7;
    }

    private void a() {
        int[] iArr;
        Paint paint = new Paint();
        this.f1889k = paint;
        boolean z = true;
        paint.setAntiAlias(true);
        this.f1889k.setShadowLayer(this.f1885g, this.f1886h, this.f1887i, this.b);
        if (this.f1888j != null && (iArr = this.c) != null && iArr.length > 1) {
            float[] fArr = this.f1882d;
            z = (fArr == null || fArr.length <= 0 || fArr.length != iArr.length) ? false : false;
            Paint paint2 = this.f1889k;
            LinearGradient linearGradient = this.f1883e;
            if (linearGradient == null) {
                RectF rectF = this.f1888j;
                linearGradient = new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, this.c, z ? this.f1882d : null, Shader.TileMode.CLAMP);
            }
            paint2.setShader(linearGradient);
            return;
        }
        this.f1889k.setColor(this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f1888j == null) {
            Rect bounds = getBounds();
            int i2 = bounds.left;
            int i3 = this.f1885g;
            int i4 = this.f1886h;
            int i5 = this.f1887i;
            this.f1888j = new RectF((i2 + i3) - i4, (bounds.top + i3) - i5, (bounds.right - i3) - i4, (bounds.bottom - i3) - i5);
        }
        if (this.f1889k == null) {
            a();
        }
        RectF rectF = this.f1888j;
        int i6 = this.f1884f;
        canvas.drawRoundRect(rectF, i6, i6, this.f1889k);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Paint paint = this.f1889k;
        if (paint != null) {
            paint.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Paint paint = this.f1889k;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    public static void a(View view, a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, aVar.a());
    }
}
