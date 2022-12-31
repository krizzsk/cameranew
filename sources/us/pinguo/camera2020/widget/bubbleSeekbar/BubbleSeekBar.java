package us.pinguo.camera2020.widget.bubbleSeekbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.widget.bubbleSeekbar.a;
/* loaded from: classes3.dex */
public class BubbleSeekBar extends View {
    private final WindowManager a;
    protected final Paint b;
    private final Rect c;

    /* renamed from: d  reason: collision with root package name */
    private float f9509d;

    /* renamed from: e  reason: collision with root package name */
    us.pinguo.camera2020.widget.bubbleSeekbar.a f9510e;

    /* renamed from: f  reason: collision with root package name */
    private int f9511f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9512g;

    /* renamed from: h  reason: collision with root package name */
    protected int[] f9513h;

    /* renamed from: i  reason: collision with root package name */
    private g f9514i;

    /* renamed from: j  reason: collision with root package name */
    int f9515j;

    /* renamed from: k  reason: collision with root package name */
    int f9516k;

    /* renamed from: l  reason: collision with root package name */
    int f9517l;
    int m;
    protected float n;
    protected float o;
    protected float p;
    private int q;
    private float r;
    private BubbleView s;
    private int t;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public class BubbleView extends View {
        private final Paint a;
        private final Path b;
        private final RectF c;

        /* renamed from: d  reason: collision with root package name */
        private final Rect f9518d;

        /* renamed from: e  reason: collision with root package name */
        private int f9519e;

        /* renamed from: f  reason: collision with root package name */
        private int f9520f;

        /* renamed from: g  reason: collision with root package name */
        private int f9521g;

        /* renamed from: h  reason: collision with root package name */
        private int f9522h;

        /* renamed from: i  reason: collision with root package name */
        private a.b.C0367a f9523i;

        BubbleView(BubbleSeekBar bubbleSeekBar, Context context) {
            this(bubbleSeekBar, context, null);
        }

        private void b(String str) {
            if (str == null || this.f9523i.b.equals(str)) {
                return;
            }
            a.b.C0367a c0367a = this.f9523i;
            c0367a.b = str;
            c0367a.a = 0;
            invalidate();
        }

        protected int a() {
            us.pinguo.camera2020.widget.bubbleSeekbar.a aVar = BubbleSeekBar.this.f9510e;
            float f2 = aVar.b;
            float f3 = aVar.a;
            float f4 = (f2 - f3) / aVar.m;
            float f5 = aVar.c;
            int i2 = (int) ((f5 - f3) / f4);
            return (f5 - f3) % f4 >= f4 / 2.0f ? i2 + 1 : i2;
        }

        public void c() {
            us.pinguo.camera2020.widget.bubbleSeekbar.a aVar = BubbleSeekBar.this.f9510e;
            if (aVar.o && aVar.p) {
                a.b.C0367a d2 = BubbleSeekBar.this.f9510e.q.d(a());
                if (d2 == null || d2.equals(this.f9523i)) {
                    return;
                }
                a.b.C0367a c0367a = this.f9523i;
                c0367a.b = d2.b;
                c0367a.a = d2.a;
                invalidate();
                return;
            }
            b(aVar.l() ? String.valueOf(BubbleSeekBar.this.z()) : String.valueOf(BubbleSeekBar.this.x()));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            this.b.reset();
            float measuredWidth = getMeasuredWidth() / 2.0f;
            float measuredHeight = getMeasuredHeight() - (this.f9519e / 3.0f);
            this.b.moveTo(measuredWidth, measuredHeight);
            int i2 = this.f9519e;
            float measuredWidth2 = (float) ((getMeasuredWidth() / 2.0f) - ((Math.sqrt(3.0d) / 2.0d) * i2));
            float f2 = i2 * 1.5f;
            this.b.quadTo(measuredWidth2 - us.pinguo.camera2020.widget.bubbleSeekbar.b.a(2.0f), f2 - us.pinguo.camera2020.widget.bubbleSeekbar.b.a(2.0f), measuredWidth2, f2);
            this.b.arcTo(this.c, 150.0f, 240.0f);
            this.b.quadTo(((float) ((getMeasuredWidth() / 2.0f) + ((Math.sqrt(3.0d) / 2.0d) * this.f9519e))) + us.pinguo.camera2020.widget.bubbleSeekbar.b.a(2.0f), f2 - us.pinguo.camera2020.widget.bubbleSeekbar.b.a(2.0f), measuredWidth, measuredHeight);
            this.b.close();
            this.a.setColor(this.f9520f);
            canvas.drawPath(this.b, this.a);
            a.b.C0367a c0367a = this.f9523i;
            if (c0367a.a > 0) {
                Drawable drawable = getResources().getDrawable(this.f9523i.a);
                this.f9518d.left = (int) (getMeasuredWidth() * 0.25f);
                this.f9518d.top = (int) (getMeasuredHeight() * 0.1f);
                this.f9518d.right = (int) (getMeasuredWidth() * 0.75f);
                this.f9518d.bottom = (int) (getMeasuredHeight() * 0.6f);
                drawable.setBounds(this.f9518d);
                drawable.draw(canvas);
            } else if (c0367a.b != null) {
                this.a.setTextSize(this.f9521g);
                this.a.setColor(this.f9522h);
                Paint paint = this.a;
                String str = this.f9523i.b;
                paint.getTextBounds(str, 0, str.length(), this.f9518d);
                Paint.FontMetrics fontMetrics = this.a.getFontMetrics();
                float f3 = fontMetrics.descent;
                canvas.drawText(this.f9523i.b, getMeasuredWidth() / 2.0f, (this.f9519e + ((f3 - fontMetrics.ascent) / 2.0f)) - f3, this.a);
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            int i4 = this.f9519e;
            setMeasuredDimension(i4 * 3, i4 * 3);
            int i5 = this.f9519e;
            this.c.set((getMeasuredWidth() / 2.0f) - this.f9519e, 0.0f, (getMeasuredWidth() / 2.0f) + i5, i5 * 2);
        }

        public void setBubbleColor(int i2) {
            this.f9520f = i2;
        }

        public void setBubbleRadio(int i2) {
            this.f9519e = i2;
        }

        public void setBubbleTextColor(int i2) {
            this.f9522h = i2;
        }

        public void setBubbleTextSize(int i2) {
            this.f9521g = i2;
        }

        BubbleView(BubbleSeekBar bubbleSeekBar, Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        BubbleView(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.f9521g = us.pinguo.camera2020.widget.bubbleSeekbar.b.a(14.0f);
            this.f9523i = new a.b.C0367a(0, "");
            Paint paint = new Paint();
            this.a = paint;
            paint.setAntiAlias(true);
            paint.setTextAlign(Paint.Align.CENTER);
            this.b = new Path();
            this.c = new RectF();
            this.f9518d = new Rect();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BubbleView bubbleView = BubbleSeekBar.this.s;
            bubbleView.setVisibility(8);
            VdsAgent.onSetViewVisibility(bubbleView, 8);
            if (BubbleSeekBar.this.s.getParent() != null) {
                BubbleSeekBar.this.a.removeViewImmediate(BubbleSeekBar.this.s);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BubbleSeekBar.this.s.setPivotX(BubbleSeekBar.this.s.getMeasuredWidth() / 2);
            BubbleSeekBar.this.s.setPivotY(BubbleSeekBar.this.s.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BubbleSeekBar.this.s.setAlpha(floatValue);
            BubbleSeekBar.this.s.setScaleX(floatValue);
            BubbleSeekBar.this.s.setScaleY(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends AnimatorListenerAdapter {
        final /* synthetic */ WindowManager.LayoutParams a;

        c(WindowManager.LayoutParams layoutParams) {
            this.a = layoutParams;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (BubbleSeekBar.this.s.getParent() == null) {
                BubbleSeekBar.this.a.addView(BubbleSeekBar.this.s, this.a);
            }
            BubbleSeekBar.this.s.setPivotX(BubbleSeekBar.this.s.getMeasuredWidth() / 2);
            BubbleSeekBar.this.s.setPivotY(BubbleSeekBar.this.s.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BubbleSeekBar.this.s.setAlpha(floatValue);
            BubbleSeekBar.this.s.setScaleX(floatValue);
            BubbleSeekBar.this.s.setScaleY(floatValue);
            BubbleSeekBar.this.s.setTranslationY((1.0f - floatValue) * BubbleSeekBar.this.r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BubbleSeekBar.this.f9510e.c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BubbleSeekBar.this.I();
            BubbleSeekBar.this.invalidate();
            BubbleSeekBar.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f extends AnimatorListenerAdapter {
        final /* synthetic */ float a;

        f(float f2) {
            this.a = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BubbleSeekBar bubbleSeekBar = BubbleSeekBar.this;
            bubbleSeekBar.f9510e.c = this.a;
            bubbleSeekBar.invalidate();
            if (BubbleSeekBar.this.f9514i != null) {
                g gVar = BubbleSeekBar.this.f9514i;
                BubbleSeekBar bubbleSeekBar2 = BubbleSeekBar.this;
                gVar.c(bubbleSeekBar2, bubbleSeekBar2.y(this.a), BubbleSeekBar.this.A(this.a));
            }
            BubbleSeekBar bubbleSeekBar3 = BubbleSeekBar.this;
            if (bubbleSeekBar3.f9510e.A) {
                bubbleSeekBar3.B();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(BubbleSeekBar bubbleSeekBar, int i2, float f2);

        void b(BubbleSeekBar bubbleSeekBar, int i2, float f2);

        void c(BubbleSeekBar bubbleSeekBar, int i2, float f2);
    }

    public BubbleSeekBar(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        BubbleView bubbleView = this.s;
        if (bubbleView == null || bubbleView.getParent() == null) {
            return;
        }
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(200L);
        duration.addListener(new a());
        duration.addUpdateListener(new b());
        duration.start();
    }

    private boolean D(MotionEvent motionEvent) {
        if (isEnabled()) {
            float f2 = this.p;
            float f3 = this.n;
            us.pinguo.camera2020.widget.bubbleSeekbar.a aVar = this.f9510e;
            float f4 = aVar.c;
            float f5 = aVar.a;
            float f6 = (((f4 - f5) * (f2 - f3)) / (aVar.b - f5)) + f3;
            float f7 = this.o;
            int a2 = (aVar.f9528g * 2) + us.pinguo.camera2020.widget.bubbleSeekbar.b.a(20.0f);
            return ((motionEvent.getX() - f6) * (motionEvent.getX() - f6)) + ((motionEvent.getY() - f7) * (motionEvent.getY() - f7)) <= ((float) (a2 * a2));
        }
        return false;
    }

    private boolean E(MotionEvent motionEvent) {
        return isEnabled() && motionEvent.getX() >= this.n && motionEvent.getX() <= this.p && Math.abs(motionEvent.getY() - this.o) <= ((float) this.f9510e.f9529h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (this.f9514i != null) {
            float A = A(this.f9510e.c);
            if (this.f9509d != A) {
                this.f9514i.a(this, y(this.f9510e.c), A);
                this.f9509d = A;
            }
        }
    }

    private void H() {
        BubbleView bubbleView = this.s;
        if (bubbleView == null || bubbleView.getParent() != null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.s.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new WindowManager.LayoutParams();
            layoutParams.gravity = 8388659;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.format = -3;
            layoutParams.flags = 524328;
            if (!us.pinguo.camera2020.widget.bubbleSeekbar.b.d() && Build.VERSION.SDK_INT < 25) {
                layoutParams.type = 2005;
            } else {
                layoutParams.type = 2;
            }
        }
        layoutParams.x = (int) ((((u() + this.f9513h[0]) + getLeft()) - (this.s.getMeasuredWidth() / 2)) + 0.5f);
        layoutParams.y = (int) (this.t + 0.5f);
        this.s.setAlpha(0.0f);
        BubbleView bubbleView2 = this.s;
        bubbleView2.setVisibility(0);
        VdsAgent.onSetViewVisibility(bubbleView2, 0);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        duration.addListener(new c(layoutParams));
        duration.addUpdateListener(new d());
        duration.start();
        this.s.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        WindowManager.LayoutParams layoutParams;
        BubbleView bubbleView = this.s;
        if (bubbleView == null || bubbleView.getParent() == null || (layoutParams = (WindowManager.LayoutParams) this.s.getLayoutParams()) == null) {
            return;
        }
        layoutParams.x = (int) (((u() + this.f9513h[0]) - (this.s.getMeasuredWidth() / 2)) + 0.5f);
        this.a.updateViewLayout(this.s, layoutParams);
        this.s.c();
    }

    private void h(float f2) {
        float A = A(f2);
        float abs = Math.abs(f2 - A);
        us.pinguo.camera2020.widget.bubbleSeekbar.a aVar = this.f9510e;
        ValueAnimator valueAnimator = null;
        if (!(abs < (aVar.b - aVar.a) / 1000.0f)) {
            valueAnimator = ValueAnimator.ofFloat(f2, A);
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.setDuration(200L);
            valueAnimator.addUpdateListener(new e());
            valueAnimator.addListener(new f(A));
            valueAnimator.start();
        } else {
            aVar.c = A;
            G();
            if (this.f9514i != null) {
                this.f9514i.c(this, y(A), A(A));
            }
            if (this.f9510e.A) {
                B();
            }
        }
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    private float u() {
        float f2 = this.p;
        float f3 = this.n;
        us.pinguo.camera2020.widget.bubbleSeekbar.a aVar = this.f9510e;
        float f4 = aVar.c;
        float f5 = aVar.a;
        return (((f4 - f5) * (f2 - f3)) / (aVar.b - f5)) + f3;
    }

    private float w(float f2) {
        us.pinguo.camera2020.widget.bubbleSeekbar.a aVar = this.f9510e;
        float f3 = aVar.a;
        float f4 = aVar.b;
        float f5 = this.n;
        float f6 = (((f4 - f3) * (f2 - f5)) / (this.p - f5)) + f3;
        return f6 < f3 ? f3 : f6 > f4 ? f4 : f6;
    }

    protected float A(float f2) {
        us.pinguo.camera2020.widget.bubbleSeekbar.a aVar = this.f9510e;
        if (aVar.v) {
            float f3 = aVar.b;
            float f4 = aVar.a;
            float f5 = (f3 - f4) / aVar.m;
            int i2 = (int) ((f2 - f4) / f5);
            if ((f2 - f4) % f5 >= f5 / 2.0f) {
                i2++;
            }
            return (i2 * f5) + f4;
        }
        return f2;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void C() {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.C():void");
    }

    protected void F() {
        getLocationOnScreen(this.f9513h);
        int measuredHeight = ((this.f9513h[1] - this.s.getMeasuredHeight()) - this.f9517l) + this.q;
        this.t = measuredHeight;
        this.t = measuredHeight - us.pinguo.camera2020.widget.bubbleSeekbar.b.a(24.0f);
        if (!us.pinguo.camera2020.widget.bubbleSeekbar.b.c(((Activity) getContext()).getWindow())) {
            this.t -= us.pinguo.camera2020.widget.bubbleSeekbar.b.a(24.0f);
        }
        if (us.pinguo.camera2020.widget.bubbleSeekbar.b.d()) {
            this.t += us.pinguo.camera2020.widget.bubbleSeekbar.b.a(4.0f);
        }
        this.r = ((this.f9513h[1] + this.o) - this.t) - this.s.getMeasuredHeight();
    }

    boolean i(float f2, float f3, float f4) {
        return (f4 >= f2 && f4 <= f3) || (f4 <= f2 && f4 >= f3);
    }

    protected void j() {
        a.b bVar;
        this.b.setTextSize(this.f9510e.s);
        this.b.getTextBounds("j", 0, 1, this.c);
        this.f9515j = this.c.height();
        us.pinguo.camera2020.widget.bubbleSeekbar.a aVar = this.f9510e;
        if (aVar.p && (bVar = aVar.q) != null) {
            this.b.setTextSize(bVar.c());
            this.b.getTextBounds("j", 0, 1, this.c);
            this.f9516k = this.c.height();
            this.f9517l = Math.max(this.f9510e.q.b() == null ? 0 : this.f9510e.q.b().b, this.f9516k);
        } else {
            this.f9517l = 0;
        }
        a.C0366a c0366a = this.f9510e.B;
        if (c0366a != null) {
            if (c0366a.b > 0) {
                this.m = c0366a.a.a;
                return;
            } else if (c0366a.c != null) {
                this.b.setTextSize(c0366a.f9534d);
                Paint paint = this.b;
                String str = this.f9510e.B.c;
                paint.getTextBounds(str, 0, str.length(), this.c);
                this.m = this.c.width();
                return;
            } else {
                return;
            }
        }
        this.m = 0;
    }

    public void k(us.pinguo.camera2020.widget.bubbleSeekbar.a aVar) {
        this.f9510e = aVar;
        this.s.setBubbleRadio(aVar.w);
        this.s.setBubbleColor(aVar.x);
        this.s.setBubbleTextColor(aVar.z);
        this.s.setBubbleTextSize(aVar.y);
        j();
        invalidate();
    }

    public void l() {
        F();
        if (this.s.getParent() != null) {
            postInvalidate();
        }
    }

    protected void m(Canvas canvas) {
        this.b.setColor(this.f9510e.i());
        this.b.setStrokeWidth(this.f9510e.j());
        float f2 = this.n;
        float f3 = this.o;
        canvas.drawLine(f2, f3, this.p, f3, this.b);
    }

    protected void n(Canvas canvas, float f2) {
        a.C0366a c0366a = this.f9510e.B;
        if (c0366a.b > 0) {
            Drawable drawable = getResources().getDrawable(this.f9510e.B.b);
            us.pinguo.camera2020.widget.bubbleSeekbar.c cVar = this.f9510e.B.a;
            float f3 = this.o;
            int i2 = cVar.b;
            drawable.setBounds((int) f2, (int) (f3 - (i2 / 2.0f)), (int) (f2 + cVar.a), (int) (f3 + (i2 / 2.0f)));
            drawable.draw(canvas);
        } else if (c0366a.c != null) {
            this.b.setTextSize(c0366a.f9534d);
            this.b.setColor(this.f9510e.B.f9535e);
            Paint paint = this.b;
            String str = this.f9510e.B.c;
            paint.getTextBounds(str, 0, str.length(), this.c);
            this.b.setTextAlign(Paint.Align.LEFT);
            String str2 = this.f9510e.B.c;
            canvas.drawText(str2, 0, str2.length(), f2, (int) ((this.o - (this.c.height() / 2.0f)) - this.c.top), this.b);
        }
    }

    protected void o(Canvas canvas, float f2, float f3) {
        this.b.setColor(this.f9510e.f9532k);
        this.b.setStrokeWidth(this.f9510e.f9527f);
        float f4 = this.o;
        canvas.drawLine(f2, f4, f3, f4, this.b);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float paddingLeft = getPaddingLeft();
        float paddingTop = getPaddingTop() + this.q;
        boolean z = this.f9517l > 0;
        us.pinguo.camera2020.widget.bubbleSeekbar.a aVar = this.f9510e;
        boolean z2 = aVar.B != null;
        float f2 = this.p;
        float f3 = this.n;
        float f4 = f2 - f3;
        float f5 = aVar.a;
        float f6 = aVar.b;
        float f7 = ((f5 * f4) * 1.0f) / (f5 - f6);
        if (f5 >= 0.0f) {
            f4 = 0.0f;
        } else if (f6 > 0.0f) {
            f4 = f7;
        }
        float f8 = f4 + f3;
        float u = u();
        if (z2) {
            n(canvas, paddingLeft);
        }
        m(canvas);
        us.pinguo.camera2020.widget.bubbleSeekbar.a aVar2 = this.f9510e;
        if ((aVar2.p || aVar2.n) && aVar2.m > 0) {
            p(canvas, paddingTop, z, f8, u);
        }
        o(canvas, f8, u);
        q(canvas, u);
        if (!this.f9510e.r || this.f9512g) {
            return;
        }
        r(canvas, u);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            F();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        us.pinguo.camera2020.widget.bubbleSeekbar.a aVar = this.f9510e;
        int i4 = aVar.f9529h * 2;
        a.C0366a c0366a = aVar.B;
        int i5 = c0366a == null ? 0 : c0366a.a.b;
        int max = Math.max(0, c0366a == null ? 0 : (c0366a.a.b - i4) / 2);
        us.pinguo.camera2020.widget.bubbleSeekbar.a aVar2 = this.f9510e;
        int max2 = Math.max(i5, i4 + Math.max(aVar2.r ? this.f9515j + this.f9511f : 0, (!aVar2.p || aVar2.q == null) ? 0 : this.f9517l + this.f9511f)) + max;
        if (View.MeasureSpec.getMode(i3) == 1073741824 && max2 < View.MeasureSpec.getSize(i3)) {
            this.q = (View.MeasureSpec.getSize(i3) - max2) / 2;
            max2 = View.MeasureSpec.getSize(i3);
        } else {
            this.q = 0;
        }
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i2), max2);
        C();
        F();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000d, code lost:
        if (r0 != 3) goto L8;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L70
            if (r0 == r1) goto L31
            r2 = 2
            if (r0 == r2) goto L11
            r2 = 3
            if (r0 == r2) goto L31
            goto Laf
        L11:
            boolean r0 = r4.f9512g
            if (r0 == 0) goto Laf
            us.pinguo.camera2020.widget.bubbleSeekbar.a r0 = r4.f9510e
            float r5 = r5.getX()
            float r5 = r4.w(r5)
            r0.c = r5
            r4.invalidate()
            r4.G()
            us.pinguo.camera2020.widget.bubbleSeekbar.a r5 = r4.f9510e
            boolean r5 = r5.A
            if (r5 == 0) goto L30
            r4.I()
        L30:
            return r1
        L31:
            us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar$g r0 = r4.f9514i
            if (r0 == 0) goto L50
            float r2 = r5.getX()
            float r2 = r4.w(r2)
            int r2 = r4.y(r2)
            float r3 = r5.getX()
            float r3 = r4.w(r3)
            float r3 = r4.A(r3)
            r0.b(r4, r2, r3)
        L50:
            us.pinguo.camera2020.widget.bubbleSeekbar.a r0 = r4.f9510e
            boolean r2 = r0.o
            if (r2 == 0) goto L62
            float r5 = r5.getX()
            float r5 = r4.w(r5)
            r4.h(r5)
            goto L69
        L62:
            boolean r5 = r0.A
            if (r5 == 0) goto L69
            r4.B()
        L69:
            r5 = 0
            r4.f9512g = r5
            r4.invalidate()
            return r1
        L70:
            boolean r0 = r4.D(r5)
            r4.f9512g = r0
            if (r0 == 0) goto L85
            r4.invalidate()
            us.pinguo.camera2020.widget.bubbleSeekbar.a r5 = r4.f9510e
            boolean r5 = r5.A
            if (r5 == 0) goto L84
            r4.H()
        L84:
            return r1
        L85:
            us.pinguo.camera2020.widget.bubbleSeekbar.a r0 = r4.f9510e
            boolean r0 = r0.u
            if (r0 == 0) goto Laf
            boolean r0 = r4.E(r5)
            if (r0 == 0) goto Laf
            us.pinguo.camera2020.widget.bubbleSeekbar.a r0 = r4.f9510e
            float r5 = r5.getX()
            float r5 = r4.w(r5)
            r0.c = r5
            r4.G()
            r4.invalidate()
            r4.f9512g = r1
            us.pinguo.camera2020.widget.bubbleSeekbar.a r5 = r4.f9510e
            boolean r5 = r5.A
            if (r5 == 0) goto Lae
            r4.H()
        Lae:
            return r1
        Laf:
            boolean r5 = super.onTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void p(android.graphics.Canvas r17, float r18, boolean r19, float r20, float r21) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.p(android.graphics.Canvas, float, boolean, float, float):void");
    }

    protected void q(Canvas canvas, float f2) {
        this.b.setColor(this.f9510e.f9533l);
        canvas.drawCircle(f2, this.o, this.f9512g ? this.f9510e.f9529h : this.f9510e.f9528g, this.b);
    }

    protected void r(Canvas canvas, float f2) {
        this.b.setColor(this.f9510e.t);
        this.b.setTextSize(this.f9510e.s);
        this.b.getTextBounds("0123456789", 0, 10, this.c);
        float f3 = this.o;
        us.pinguo.camera2020.widget.bubbleSeekbar.a aVar = this.f9510e;
        float f4 = ((f3 - aVar.f9529h) - this.f9511f) - this.c.bottom;
        boolean z = aVar.f9525d;
        float f5 = aVar.c;
        canvas.drawText(z ? String.valueOf(f5) : String.valueOf((int) f5), f2, f4, this.b);
    }

    public us.pinguo.camera2020.widget.bubbleSeekbar.a s() {
        return this.f9510e;
    }

    public void setOnProgressListener(g gVar) {
        this.f9514i = gVar;
    }

    public void setProgress(float f2) {
        us.pinguo.camera2020.widget.bubbleSeekbar.a s = s();
        s.p(f2);
        s.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int t(int i2) {
        return ((int) ((i2 & 255) * 0.8f)) | (((i2 >>> 24) & 255) << 24) | (((int) (((i2 >> 16) & 255) * 0.8f)) << 16) | (((int) (((i2 >> 8) & 255) * 0.8f)) << 8);
    }

    public float v() {
        return this.f9510e.g();
    }

    public int x() {
        return y(this.f9510e.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int y(float f2) {
        float round;
        float f3;
        us.pinguo.camera2020.widget.bubbleSeekbar.a aVar = this.f9510e;
        if (aVar.v) {
            float f4 = aVar.b;
            float f5 = aVar.a;
            float f6 = (f4 - f5) / aVar.m;
            int i2 = (int) ((f2 - f5) / f6);
            if ((f2 - f5) % f6 >= f6 / 2.0f) {
                round = Math.round((i2 + 1) * f6);
                f3 = this.f9510e.a;
            } else {
                round = Math.round(i2 * f6);
                f3 = this.f9510e.a;
            }
            return (int) (round + f3);
        }
        return Math.round(f2);
    }

    public float z() {
        return A(this.f9510e.c);
    }

    public BubbleSeekBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleSeekBar(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9509d = Float.MIN_VALUE;
        this.f9511f = us.pinguo.camera2020.widget.bubbleSeekbar.b.a(2.0f);
        this.f9512g = false;
        this.f9513h = new int[2];
        this.f9515j = 0;
        this.f9516k = 0;
        this.f9517l = 0;
        this.m = 0;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = 0;
        this.r = 0.0f;
        this.a = (WindowManager) context.getSystemService("window");
        this.s = new BubbleView(this, context);
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        this.c = new Rect();
        us.pinguo.camera2020.widget.bubbleSeekbar.a aVar = new us.pinguo.camera2020.widget.bubbleSeekbar.a(this);
        this.f9510e = aVar;
        aVar.o(0.0f);
        aVar.n(100.0f);
        aVar.p(0.0f);
        aVar.F(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(2.0f));
        aVar.r(this.f9510e.f9526e + us.pinguo.camera2020.widget.bubbleSeekbar.b.a(2.0f));
        aVar.A((this.f9510e.f9527f + us.pinguo.camera2020.widget.bubbleSeekbar.b.a(2.0f)) / 2);
        aVar.B(this.f9510e.f9528g + us.pinguo.camera2020.widget.bubbleSeekbar.b.a(1.0f));
        aVar.E(ContextCompat.getColor(context, R.color.colorPrimary));
        aVar.q(ContextCompat.getColor(context, R.color.colorAccent));
        aVar.z(this.f9510e.f9532k);
        aVar.C(us.pinguo.camera2020.widget.bubbleSeekbar.b.e(14.0f));
        aVar.b(this.f9510e.f9532k);
        aVar.d(us.pinguo.camera2020.widget.bubbleSeekbar.b.e(14.0f));
        aVar.c(this.f9510e.f9531j);
        aVar.e();
    }
}
