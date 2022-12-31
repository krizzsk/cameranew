package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.c;
/* compiled from: CircularRevealHelper.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: j  reason: collision with root package name */
    public static final int f4192j;
    private final a a;
    @NonNull
    private final View b;
    @NonNull
    private final Path c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Paint f4193d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final Paint f4194e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private c.e f4195f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Drawable f4196g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4197h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4198i;

    /* compiled from: CircularRevealHelper.java */
    /* loaded from: classes2.dex */
    public interface a {
        void e(Canvas canvas);

        boolean f();
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f4192j = 2;
        } else if (i2 >= 18) {
            f4192j = 1;
        } else {
            f4192j = 0;
        }
    }

    public b(a aVar) {
        this.a = aVar;
        View view = (View) aVar;
        this.b = view;
        view.setWillNotDraw(false);
        this.c = new Path();
        this.f4193d = new Paint(7);
        Paint paint = new Paint(1);
        this.f4194e = paint;
        paint.setColor(0);
    }

    private void d(@NonNull Canvas canvas) {
        if (n()) {
            Rect bounds = this.f4196g.getBounds();
            float width = this.f4195f.a - (bounds.width() / 2.0f);
            float height = this.f4195f.b - (bounds.height() / 2.0f);
            canvas.translate(width, height);
            this.f4196g.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    private float f(@NonNull c.e eVar) {
        return com.google.android.material.e.a.b(eVar.a, eVar.b, 0.0f, 0.0f, this.b.getWidth(), this.b.getHeight());
    }

    private void h() {
        if (f4192j == 1) {
            this.c.rewind();
            c.e eVar = this.f4195f;
            if (eVar != null) {
                this.c.addCircle(eVar.a, eVar.b, eVar.c, Path.Direction.CW);
            }
        }
        this.b.invalidate();
    }

    private boolean m() {
        c.e eVar = this.f4195f;
        boolean z = eVar == null || eVar.a();
        return f4192j == 0 ? !z && this.f4198i : !z;
    }

    private boolean n() {
        return (this.f4197h || this.f4196g == null || this.f4195f == null) ? false : true;
    }

    private boolean o() {
        return (this.f4197h || Color.alpha(this.f4194e.getColor()) == 0) ? false : true;
    }

    public void a() {
        if (f4192j == 0) {
            this.f4197h = true;
            this.f4198i = false;
            this.b.buildDrawingCache();
            Bitmap drawingCache = this.b.getDrawingCache();
            if (drawingCache == null && this.b.getWidth() != 0 && this.b.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.b.getWidth(), this.b.getHeight(), Bitmap.Config.ARGB_8888);
                this.b.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f4193d;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.f4197h = false;
            this.f4198i = true;
        }
    }

    public void b() {
        if (f4192j == 0) {
            this.f4198i = false;
            this.b.destroyDrawingCache();
            this.f4193d.setShader(null);
            this.b.invalidate();
        }
    }

    public void c(@NonNull Canvas canvas) {
        if (m()) {
            int i2 = f4192j;
            if (i2 == 0) {
                c.e eVar = this.f4195f;
                canvas.drawCircle(eVar.a, eVar.b, eVar.c, this.f4193d);
                if (o()) {
                    c.e eVar2 = this.f4195f;
                    canvas.drawCircle(eVar2.a, eVar2.b, eVar2.c, this.f4194e);
                }
            } else if (i2 == 1) {
                int save = canvas.save();
                canvas.clipPath(this.c);
                this.a.e(canvas);
                if (o()) {
                    canvas.drawRect(0.0f, 0.0f, this.b.getWidth(), this.b.getHeight(), this.f4194e);
                }
                canvas.restoreToCount(save);
            } else if (i2 == 2) {
                this.a.e(canvas);
                if (o()) {
                    canvas.drawRect(0.0f, 0.0f, this.b.getWidth(), this.b.getHeight(), this.f4194e);
                }
            } else {
                throw new IllegalStateException("Unsupported strategy " + i2);
            }
        } else {
            this.a.e(canvas);
            if (o()) {
                canvas.drawRect(0.0f, 0.0f, this.b.getWidth(), this.b.getHeight(), this.f4194e);
            }
        }
        d(canvas);
    }

    @ColorInt
    public int e() {
        return this.f4194e.getColor();
    }

    @Nullable
    public c.e g() {
        c.e eVar = this.f4195f;
        if (eVar == null) {
            return null;
        }
        c.e eVar2 = new c.e(eVar);
        if (eVar2.a()) {
            eVar2.c = f(eVar2);
        }
        return eVar2;
    }

    public boolean i() {
        return this.a.f() && !m();
    }

    public void j(@Nullable Drawable drawable) {
        this.f4196g = drawable;
        this.b.invalidate();
    }

    public void k(@ColorInt int i2) {
        this.f4194e.setColor(i2);
        this.b.invalidate();
    }

    public void l(@Nullable c.e eVar) {
        if (eVar == null) {
            this.f4195f = null;
        } else {
            c.e eVar2 = this.f4195f;
            if (eVar2 == null) {
                this.f4195f = new c.e(eVar);
            } else {
                eVar2.c(eVar);
            }
            if (com.google.android.material.e.a.c(eVar.c, f(eVar), 1.0E-4f)) {
                this.f4195f.c = Float.MAX_VALUE;
            }
        }
        h();
    }
}
