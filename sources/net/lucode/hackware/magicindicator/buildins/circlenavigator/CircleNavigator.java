package net.lucode.hackware.magicindicator.buildins.circlenavigator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.d.b;
/* loaded from: classes3.dex */
public class CircleNavigator extends View implements net.lucode.hackware.magicindicator.c.a {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f8876d;

    /* renamed from: e  reason: collision with root package name */
    private int f8877e;

    /* renamed from: f  reason: collision with root package name */
    private int f8878f;

    /* renamed from: g  reason: collision with root package name */
    private Interpolator f8879g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f8880h;

    /* renamed from: i  reason: collision with root package name */
    private List<PointF> f8881i;

    /* renamed from: j  reason: collision with root package name */
    private float f8882j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8883k;

    /* renamed from: l  reason: collision with root package name */
    private a f8884l;
    private float m;
    private float n;
    private int o;
    private boolean p;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i2);
    }

    public CircleNavigator(Context context) {
        super(context);
        this.f8879g = new LinearInterpolator();
        this.f8880h = new Paint(1);
        this.f8881i = new ArrayList();
        this.p = true;
        c(context);
    }

    private void a(Canvas canvas) {
        this.f8880h.setStyle(Paint.Style.STROKE);
        this.f8880h.setStrokeWidth(this.c);
        int size = this.f8881i.size();
        for (int i2 = 0; i2 < size; i2++) {
            PointF pointF = this.f8881i.get(i2);
            canvas.drawCircle(pointF.x, pointF.y, this.a, this.f8880h);
        }
    }

    private void b(Canvas canvas) {
        this.f8880h.setStyle(Paint.Style.FILL);
        if (this.f8881i.size() > 0) {
            canvas.drawCircle(this.f8882j, (int) ((getHeight() / 2.0f) + 0.5f), this.a, this.f8880h);
        }
    }

    private void c(Context context) {
        this.o = ViewConfiguration.get(context).getScaledTouchSlop();
        this.a = b.a(context, 3.0d);
        this.f8876d = b.a(context, 8.0d);
        this.c = b.a(context, 1.0d);
    }

    private int d(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return (this.a * 2) + (this.c * 2) + getPaddingTop() + getPaddingBottom();
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    private int g(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i3 = this.f8878f;
            return (this.c * 2) + (this.a * i3 * 2) + ((i3 - 1) * this.f8876d) + getPaddingLeft() + getPaddingRight();
        } else if (mode != 1073741824) {
            return 0;
        } else {
            return size;
        }
    }

    private void h() {
        this.f8881i.clear();
        if (this.f8878f > 0) {
            int height = (int) ((getHeight() / 2.0f) + 0.5f);
            int i2 = this.a;
            int i3 = (i2 * 2) + this.f8876d;
            int paddingLeft = i2 + ((int) ((this.c / 2.0f) + 0.5f)) + getPaddingLeft();
            for (int i4 = 0; i4 < this.f8878f; i4++) {
                this.f8881i.add(new PointF(paddingLeft, height));
                paddingLeft += i3;
            }
            this.f8882j = this.f8881i.get(this.f8877e).x;
        }
    }

    @Override // net.lucode.hackware.magicindicator.c.a
    public void e() {
    }

    @Override // net.lucode.hackware.magicindicator.c.a
    public void f() {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f8880h.setColor(this.b);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        h();
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        setMeasuredDimension(g(i2), d(i3));
    }

    @Override // net.lucode.hackware.magicindicator.c.a
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // net.lucode.hackware.magicindicator.c.a
    public void onPageScrolled(int i2, float f2, int i3) {
        if (!this.p || this.f8881i.isEmpty()) {
            return;
        }
        int min = Math.min(this.f8881i.size() - 1, i2);
        int min2 = Math.min(this.f8881i.size() - 1, i2 + 1);
        float f3 = this.f8881i.get(min).x;
        this.f8882j = f3 + ((this.f8881i.get(min2).x - f3) * this.f8879g.getInterpolation(f2));
        invalidate();
    }

    @Override // net.lucode.hackware.magicindicator.c.a
    public void onPageSelected(int i2) {
        this.f8877e = i2;
        if (this.p) {
            return;
        }
        this.f8882j = this.f8881i.get(i2).x;
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && this.f8884l != null && Math.abs(x - this.m) <= this.o && Math.abs(y - this.n) <= this.o) {
                float f2 = Float.MAX_VALUE;
                int i2 = 0;
                for (int i3 = 0; i3 < this.f8881i.size(); i3++) {
                    float abs = Math.abs(this.f8881i.get(i3).x - x);
                    if (abs < f2) {
                        i2 = i3;
                        f2 = abs;
                    }
                }
                this.f8884l.a(i2);
            }
        } else if (this.f8883k) {
            this.m = x;
            this.n = y;
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCircleClickListener(a aVar) {
        if (!this.f8883k) {
            this.f8883k = true;
        }
        this.f8884l = aVar;
    }

    public void setCircleColor(int i2) {
        this.b = i2;
        invalidate();
    }

    public void setCircleCount(int i2) {
        this.f8878f = i2;
    }

    public void setCircleSpacing(int i2) {
        this.f8876d = i2;
        h();
        invalidate();
    }

    public void setFollowTouch(boolean z) {
        this.p = z;
    }

    public void setRadius(int i2) {
        this.a = i2;
        h();
        invalidate();
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f8879g = interpolator;
        if (interpolator == null) {
            this.f8879g = new LinearInterpolator();
        }
    }

    public void setStrokeWidth(int i2) {
        this.c = i2;
        invalidate();
    }

    public void setTouchable(boolean z) {
        this.f8883k = z;
    }
}
