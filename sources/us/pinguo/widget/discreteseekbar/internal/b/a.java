package us.pinguo.widget.discreteseekbar.internal.b;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
/* compiled from: AlmostRippleDrawable.java */
/* loaded from: classes6.dex */
public class a extends c implements Animatable {

    /* renamed from: e  reason: collision with root package name */
    private float f12554e;

    /* renamed from: f  reason: collision with root package name */
    private Interpolator f12555f;

    /* renamed from: g  reason: collision with root package name */
    private long f12556g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12557h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12558i;

    /* renamed from: j  reason: collision with root package name */
    private int f12559j;

    /* renamed from: k  reason: collision with root package name */
    private float f12560k;

    /* renamed from: l  reason: collision with root package name */
    private int f12561l;
    private int m;
    private int n;
    private int o;
    private int p;
    private final Runnable q;

    /* compiled from: AlmostRippleDrawable.java */
    /* renamed from: us.pinguo.widget.discreteseekbar.internal.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class RunnableC0468a implements Runnable {
        RunnableC0468a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j2 = uptimeMillis - a.this.f12556g;
            if (j2 < a.this.f12559j) {
                float interpolation = a.this.f12555f.getInterpolation(((float) j2) / a.this.f12559j);
                a aVar = a.this;
                aVar.scheduleSelf(aVar.q, uptimeMillis + 16);
                a.this.q(interpolation);
                return;
            }
            a aVar2 = a.this;
            aVar2.unscheduleSelf(aVar2.q);
            a.this.f12558i = false;
            a.this.q(1.0f);
        }
    }

    public a(@NonNull ColorStateList colorStateList) {
        super(colorStateList);
        this.f12554e = 0.0f;
        this.f12557h = false;
        this.f12558i = false;
        this.f12559j = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        this.q = new RunnableC0468a();
        this.f12555f = new AccelerateDecelerateInterpolator();
        p(colorStateList);
    }

    private int n(int i2) {
        return (i2 * 100) >> 8;
    }

    private static int o(int i2, int i3) {
        return Color.argb((Color.alpha(i3) * (i2 + (i2 >> 7))) >> 8, Color.red(i3), Color.green(i3), Color.blue(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(float f2) {
        float f3 = this.f12560k;
        this.f12554e = f3 + (((this.f12557h ? 0.0f : 1.0f) - f3) * f2);
        invalidateSelf();
    }

    @Override // us.pinguo.widget.discreteseekbar.internal.b.c
    public void a(Canvas canvas, Paint paint) {
        Rect bounds = getBounds();
        int min = Math.min(bounds.width(), bounds.height());
        float f2 = this.f12554e;
        int i2 = this.o;
        int i3 = this.p;
        float f3 = min / 2;
        float f4 = f3 * f2;
        if (f2 > 0.0f) {
            if (i3 != 0) {
                paint.setColor(i3);
                paint.setAlpha(n(Color.alpha(i3)));
                canvas.drawCircle(bounds.centerX(), bounds.centerY(), f3, paint);
            }
            if (i2 != 0) {
                paint.setColor(i2);
                paint.setAlpha(c(Color.alpha(i2)));
                canvas.drawCircle(bounds.centerX(), bounds.centerY(), f4, paint);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f12558i;
    }

    public void l() {
        unscheduleSelf(this.q);
        float f2 = this.f12554e;
        if (f2 > 0.0f) {
            this.f12557h = true;
            this.f12558i = true;
            this.f12560k = f2;
            this.f12559j = (int) ((1.0f - ((f2 - 1.0f) / (-1.0f))) * 250.0f);
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f12556g = uptimeMillis;
            scheduleSelf(this.q, uptimeMillis + 16);
        }
    }

    public void m() {
        unscheduleSelf(this.q);
        float f2 = this.f12554e;
        if (f2 < 1.0f) {
            this.f12557h = false;
            this.f12558i = true;
            this.f12560k = f2;
            this.f12559j = (int) ((1.0f - ((f2 - 0.0f) / 1.0f)) * 250.0f);
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f12556g = uptimeMillis;
            scheduleSelf(this.q, uptimeMillis + 16);
        }
    }

    public void p(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.m = colorStateList.getColorForState(new int[]{16842910, 16842908}, defaultColor);
        this.f12561l = colorStateList.getColorForState(new int[]{16842910, 16842919}, defaultColor);
        this.n = colorStateList.getColorForState(new int[]{-16842910}, defaultColor);
        this.m = o(130, this.m);
        this.f12561l = o(130, this.f12561l);
        this.n = o(130, this.n);
    }

    @Override // us.pinguo.widget.discreteseekbar.internal.b.c, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        boolean z = false;
        for (int i2 : getState()) {
            if (i2 == 16842919) {
                z = true;
            }
        }
        super.setState(iArr);
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        for (int i3 : iArr) {
            if (i3 == 16842908) {
                z4 = true;
            } else if (i3 == 16842919) {
                z3 = true;
            } else if (i3 == 16842910) {
                z2 = false;
            }
        }
        if (z2) {
            unscheduleSelf(this.q);
            this.o = this.n;
            this.p = 0;
            this.f12554e = 0.5f;
            invalidateSelf();
        } else if (z3) {
            m();
            int i4 = this.f12561l;
            this.p = i4;
            this.o = i4;
        } else if (z) {
            int i5 = this.f12561l;
            this.p = i5;
            this.o = i5;
            l();
        } else if (z4) {
            this.o = this.m;
            this.p = 0;
            this.f12554e = 1.0f;
            invalidateSelf();
        } else {
            this.o = 0;
            this.p = 0;
            this.f12554e = 0.0f;
            invalidateSelf();
        }
        return true;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
    }
}
