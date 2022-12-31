package us.pinguo.widget.discreteseekbar.internal.b;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
/* compiled from: MarkerDrawable.java */
/* loaded from: classes6.dex */
public class b extends c implements Animatable {

    /* renamed from: e  reason: collision with root package name */
    private float f12562e;

    /* renamed from: f  reason: collision with root package name */
    private Interpolator f12563f;

    /* renamed from: g  reason: collision with root package name */
    private long f12564g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12565h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12566i;

    /* renamed from: j  reason: collision with root package name */
    private int f12567j;

    /* renamed from: k  reason: collision with root package name */
    private float f12568k;

    /* renamed from: l  reason: collision with root package name */
    private float f12569l;
    private int m;
    private int n;
    private int o;
    Path p;
    RectF q;
    Matrix r;
    private InterfaceC0469b s;
    private final Runnable t;

    /* compiled from: MarkerDrawable.java */
    /* loaded from: classes6.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j2 = uptimeMillis - b.this.f12564g;
            if (j2 < b.this.f12567j) {
                float interpolation = b.this.f12563f.getInterpolation(((float) j2) / b.this.f12567j);
                b bVar = b.this;
                bVar.scheduleSelf(bVar.t, uptimeMillis + 16);
                b.this.v(interpolation);
                return;
            }
            b bVar2 = b.this;
            bVar2.unscheduleSelf(bVar2.t);
            b.this.f12566i = false;
            b.this.v(1.0f);
            b.this.r();
        }
    }

    /* compiled from: MarkerDrawable.java */
    /* renamed from: us.pinguo.widget.discreteseekbar.internal.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0469b {
        void a();

        void b();
    }

    public b(@NonNull ColorStateList colorStateList, int i2) {
        super(colorStateList);
        this.f12562e = 0.0f;
        this.f12565h = false;
        this.f12566i = false;
        this.f12567j = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        this.p = new Path();
        this.q = new RectF();
        this.r = new Matrix();
        this.t = new a();
        this.f12563f = new AccelerateDecelerateInterpolator();
        this.f12568k = i2;
        this.n = colorStateList.getColorForState(new int[]{16842910, 16842919}, colorStateList.getDefaultColor());
        this.o = colorStateList.getDefaultColor();
    }

    private static int o(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i2) * f2) + (Color.alpha(i3) * f3)), (int) ((Color.red(i2) * f2) + (Color.red(i3) * f3)), (int) ((Color.green(i2) * f2) + (Color.green(i3) * f3)), (int) ((Color.blue(i2) * f2) + (Color.blue(i3) * f3)));
    }

    private void p(Rect rect) {
        float f2 = this.f12562e;
        Path path = this.p;
        RectF rectF = this.q;
        Matrix matrix = this.r;
        path.reset();
        int min = Math.min(rect.width(), rect.height());
        float f3 = this.f12568k;
        float f4 = f3 + ((min - f3) * f2);
        float f5 = f4 / 2.0f;
        float f6 = 1.0f - f2;
        float f7 = f5 * f6;
        float[] fArr = {f5, f5, f5, f5, f5, f5, f7, f7};
        int i2 = rect.left;
        int i3 = rect.top;
        rectF.set(i2, i3, i2 + f4, i3 + f4);
        path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        matrix.reset();
        matrix.postRotate(-45.0f, rect.left + f5, rect.top + f5);
        matrix.postTranslate((rect.width() - f4) / 2.0f, 0.0f);
        matrix.postTranslate(0.0f, ((rect.bottom - f4) - this.m) * f6);
        path.transform(matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        InterfaceC0469b interfaceC0469b = this.s;
        if (interfaceC0469b != null) {
            if (this.f12565h) {
                interfaceC0469b.a();
            } else {
                interfaceC0469b.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f2) {
        float f3 = this.f12569l;
        this.f12562e = f3 + (((this.f12565h ? 0.0f : 1.0f) - f3) * f2);
        p(getBounds());
        invalidateSelf();
    }

    @Override // us.pinguo.widget.discreteseekbar.internal.b.c
    void a(Canvas canvas, Paint paint) {
        if (this.p.isEmpty()) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(o(this.n, this.o, this.f12562e));
        canvas.drawPath(this.p, paint);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f12566i;
    }

    public void m() {
        this.f12565h = true;
        unscheduleSelf(this.t);
        float f2 = this.f12562e;
        if (f2 > 0.0f) {
            this.f12566i = true;
            this.f12569l = f2;
            this.f12567j = 250 - ((int) ((1.0f - f2) * 250.0f));
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f12564g = uptimeMillis;
            scheduleSelf(this.t, uptimeMillis + 16);
            return;
        }
        r();
    }

    public void n() {
        unscheduleSelf(this.t);
        this.f12565h = false;
        float f2 = this.f12562e;
        if (f2 < 1.0f) {
            this.f12566i = true;
            this.f12569l = f2;
            this.f12567j = (int) ((1.0f - f2) * 250.0f);
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f12564g = uptimeMillis;
            scheduleSelf(this.t, uptimeMillis + 16);
            return;
        }
        r();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        p(rect);
    }

    public Path q() {
        return this.p;
    }

    public void s(int i2, int i3) {
        this.n = i2;
        this.o = i3;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        unscheduleSelf(this.t);
    }

    public void t(int i2) {
        this.m = i2;
    }

    public void u(InterfaceC0469b interfaceC0469b) {
        this.s = interfaceC0469b;
    }
}
