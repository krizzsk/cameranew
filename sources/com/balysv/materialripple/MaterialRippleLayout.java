package com.balysv.materialripple;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
/* loaded from: classes.dex */
public class MaterialRippleLayout extends FrameLayout {
    private f A;
    private g B;
    private boolean C;
    private GestureDetector.SimpleOnGestureListener D;
    private Property<MaterialRippleLayout, Float> E;
    private Property<MaterialRippleLayout, Integer> F;
    private final Paint a;
    private final Rect b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f601d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f602e;

    /* renamed from: f  reason: collision with root package name */
    private int f603f;

    /* renamed from: g  reason: collision with root package name */
    private int f604g;

    /* renamed from: h  reason: collision with root package name */
    private int f605h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f606i;

    /* renamed from: j  reason: collision with root package name */
    private int f607j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f608k;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f609l;
    private boolean m;
    private float n;
    private float o;
    private AdapterView p;
    private View q;
    private AnimatorSet r;
    private ObjectAnimator s;
    private Point t;
    private Point u;
    private int v;
    private boolean w;
    private boolean x;
    private int y;
    private GestureDetector z;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialRippleLayout.this.q.setPressed(false);
        }
    }

    /* loaded from: classes.dex */
    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            MaterialRippleLayout.this.C = false;
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            MaterialRippleLayout materialRippleLayout = MaterialRippleLayout.this;
            materialRippleLayout.C = materialRippleLayout.q.performLongClick();
            if (MaterialRippleLayout.this.C) {
                if (MaterialRippleLayout.this.f602e) {
                    MaterialRippleLayout.this.B(null);
                }
                MaterialRippleLayout.this.q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        final /* synthetic */ Runnable a;

        c(Runnable runnable) {
            this.a = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!MaterialRippleLayout.this.f608k) {
                MaterialRippleLayout.this.setRadius(0.0f);
                MaterialRippleLayout materialRippleLayout = MaterialRippleLayout.this;
                materialRippleLayout.setRippleAlpha(Integer.valueOf(materialRippleLayout.f605h));
            }
            if (this.a != null && MaterialRippleLayout.this.f606i) {
                this.a.run();
            }
            MaterialRippleLayout.this.q.setPressed(false);
        }
    }

    /* loaded from: classes.dex */
    class d extends Property<MaterialRippleLayout, Float> {
        d(MaterialRippleLayout materialRippleLayout, Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(MaterialRippleLayout materialRippleLayout) {
            return Float.valueOf(materialRippleLayout.w());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(MaterialRippleLayout materialRippleLayout, Float f2) {
            materialRippleLayout.setRadius(f2.floatValue());
        }
    }

    /* loaded from: classes.dex */
    class e extends Property<MaterialRippleLayout, Integer> {
        e(MaterialRippleLayout materialRippleLayout, Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(MaterialRippleLayout materialRippleLayout) {
            return Integer.valueOf(materialRippleLayout.x());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(MaterialRippleLayout materialRippleLayout, Integer num) {
            materialRippleLayout.setRippleAlpha(num);
        }
    }

    /* loaded from: classes.dex */
    private class f implements Runnable {
        private f() {
        }

        private void a(AdapterView adapterView) {
            int positionForView = adapterView.getPositionForView(MaterialRippleLayout.this);
            long itemId = adapterView.getAdapter() != null ? adapterView.getAdapter().getItemId(positionForView) : 0L;
            if (positionForView != -1) {
                adapterView.performItemClick(MaterialRippleLayout.this, positionForView, itemId);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MaterialRippleLayout.this.C) {
                return;
            }
            if (!(MaterialRippleLayout.this.getParent() instanceof AdapterView)) {
                if (MaterialRippleLayout.this.m) {
                    a(MaterialRippleLayout.this.u());
                    return;
                } else {
                    MaterialRippleLayout.this.q.performClick();
                    return;
                }
            }
            a((AdapterView) MaterialRippleLayout.this.getParent());
        }

        /* synthetic */ f(MaterialRippleLayout materialRippleLayout, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class g implements Runnable {
        private final MotionEvent a;

        public g(MotionEvent motionEvent) {
            this.a = motionEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialRippleLayout.this.x = false;
            MaterialRippleLayout.this.q.setLongClickable(false);
            MaterialRippleLayout.this.q.onTouchEvent(this.a);
            MaterialRippleLayout.this.q.setPressed(true);
            if (MaterialRippleLayout.this.f602e) {
                MaterialRippleLayout.this.A();
            }
        }
    }

    public MaterialRippleLayout(Context context) {
        this(context, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (this.w) {
            return;
        }
        ObjectAnimator objectAnimator = this.s;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this, this.E, this.f603f, (float) (Math.sqrt(Math.pow(getWidth(), 2.0d) + Math.pow(getHeight(), 2.0d)) * 1.2000000476837158d)).setDuration(2500L);
        this.s = duration;
        duration.setInterpolator(new LinearInterpolator());
        this.s.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Runnable runnable) {
        if (this.w) {
            return;
        }
        float v = v();
        p();
        AnimatorSet animatorSet = new AnimatorSet();
        this.r = animatorSet;
        animatorSet.addListener(new c(runnable));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.E, this.o, v);
        ofFloat.setDuration(this.f604g);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, this.F, this.f605h, 0);
        ofInt.setDuration(this.f607j);
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.setStartDelay((this.f604g - this.f607j) - 50);
        if (this.f608k) {
            this.r.play(ofFloat);
        } else if (w() > v) {
            ofInt.setStartDelay(0L);
            this.r.play(ofInt);
        } else {
            this.r.playTogether(ofFloat, ofInt);
        }
        this.r.start();
    }

    private boolean o() {
        if (this.m) {
            int positionForView = u().getPositionForView(this);
            boolean z = positionForView != this.y;
            this.y = positionForView;
            if (z) {
                q();
                p();
                this.q.setPressed(false);
                setRadius(0.0f);
            }
            return z;
        }
        return false;
    }

    private void p() {
        AnimatorSet animatorSet = this.r;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.r.removeAllListeners();
        }
        ObjectAnimator objectAnimator = this.s;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        g gVar = this.B;
        if (gVar != null) {
            removeCallbacks(gVar);
            this.x = false;
        }
    }

    static float r(Resources resources, float f2) {
        return TypedValue.applyDimension(1, f2, resources.getDisplayMetrics());
    }

    private void s() {
        if (Build.VERSION.SDK_INT <= 17) {
            if (this.n != 0.0f) {
                this.v = getLayerType();
                setLayerType(1, null);
                return;
            }
            setLayerType(this.v, null);
        }
    }

    private boolean t(View view, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                View childAt = viewGroup.getChildAt(i4);
                Rect rect = new Rect();
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return t(childAt, i2 - rect.left, i3 - rect.top);
                }
            }
        } else if (view != this.q) {
            if (view.isEnabled()) {
                return view.isClickable() || view.isLongClickable() || view.isFocusableInTouchMode();
            }
            return false;
        }
        return view.isFocusableInTouchMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdapterView u() {
        AdapterView adapterView = this.p;
        if (adapterView != null) {
            return adapterView;
        }
        ViewParent parent = getParent();
        while (!(parent instanceof AdapterView)) {
            try {
                parent = parent.getParent();
            } catch (NullPointerException unused) {
                throw new RuntimeException("Could not find a parent AdapterView");
            }
        }
        AdapterView adapterView2 = (AdapterView) parent;
        this.p = adapterView2;
        return adapterView2;
    }

    private float v() {
        int width = getWidth();
        int height = getHeight();
        int i2 = width / 2;
        int i3 = height / 2;
        Point point = this.t;
        int i4 = point.x;
        float f2 = i2 > i4 ? width - i4 : i4;
        int i5 = point.y;
        return ((float) Math.sqrt(Math.pow(f2, 2.0d) + Math.pow(i3 > i5 ? height - i5 : i5, 2.0d))) * 1.2f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float w() {
        return this.o;
    }

    private boolean y() {
        for (ViewParent parent = getParent(); parent != null && (parent instanceof ViewGroup); parent = parent.getParent()) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private void z() {
        if (this.m) {
            this.y = u().getPositionForView(this);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            this.q = view;
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("MaterialRippleLayout can host only one child");
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean o = o();
        if (this.f601d) {
            if (!o) {
                this.f609l.draw(canvas);
            }
            super.draw(canvas);
            if (o) {
                return;
            }
            if (this.n != 0.0f) {
                Path path = new Path();
                RectF rectF = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
                float f2 = this.n;
                path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
                canvas.clipPath(path);
            }
            Point point = this.t;
            canvas.drawCircle(point.x, point.y, this.o, this.a);
            return;
        }
        if (!o) {
            this.f609l.draw(canvas);
            Point point2 = this.t;
            canvas.drawCircle(point2.x, point2.y, this.o, this.a);
        }
        super.draw(canvas);
    }

    @Override // android.view.View
    public boolean isInEditMode() {
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !t(this.q, (int) motionEvent.getX(), (int) motionEvent.getY());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.b.set(0, 0, i2, i3);
        this.f609l.setBounds(this.b);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (isEnabled() && this.q.isEnabled()) {
            boolean contains = this.b.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            if (contains) {
                Point point = this.u;
                Point point2 = this.t;
                point.set(point2.x, point2.y);
                this.t.set((int) motionEvent.getX(), (int) motionEvent.getY());
            }
            if (!this.z.onTouchEvent(motionEvent) && !this.C) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    z();
                    this.w = false;
                    this.B = new g(motionEvent);
                    if (y()) {
                        q();
                        this.x = true;
                        postDelayed(this.B, ViewConfiguration.getTapTimeout());
                    } else {
                        this.B.run();
                    }
                } else if (actionMasked == 1) {
                    this.A = new f(this, null);
                    if (this.x) {
                        this.q.setPressed(true);
                        postDelayed(new a(), ViewConfiguration.getPressedStateDuration());
                    }
                    if (contains) {
                        B(this.A);
                    } else if (!this.f602e) {
                        setRadius(0.0f);
                    }
                    if (!this.f606i && contains) {
                        this.A.run();
                    }
                    q();
                } else if (actionMasked == 2) {
                    if (this.f602e) {
                        if (contains && !this.w) {
                            invalidate();
                        } else if (!contains) {
                            B(null);
                        }
                    }
                    if (!contains) {
                        q();
                        ObjectAnimator objectAnimator = this.s;
                        if (objectAnimator != null) {
                            objectAnimator.cancel();
                        }
                        this.q.onTouchEvent(motionEvent);
                        this.w = true;
                    }
                } else if (actionMasked == 3) {
                    if (this.m) {
                        Point point3 = this.t;
                        Point point4 = this.u;
                        point3.set(point4.x, point4.y);
                        this.u = new Point();
                    }
                    this.q.onTouchEvent(motionEvent);
                    if (this.f602e) {
                        if (!this.x) {
                            B(null);
                        }
                    } else {
                        this.q.setPressed(false);
                    }
                    q();
                }
            }
            return true;
        }
        return onTouchEvent;
    }

    public void setDefaultRippleAlpha(int i2) {
        this.f605h = i2;
        this.a.setAlpha(i2);
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        View view = this.q;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            return;
        }
        throw new IllegalStateException("MaterialRippleLayout must have a child view to handle clicks");
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        View view = this.q;
        if (view != null) {
            view.setOnLongClickListener(onLongClickListener);
            return;
        }
        throw new IllegalStateException("MaterialRippleLayout must have a child view to handle clicks");
    }

    public void setRadius(float f2) {
        this.o = f2;
        invalidate();
    }

    public void setRippleAlpha(Integer num) {
        this.a.setAlpha(num.intValue());
        invalidate();
    }

    public void setRippleBackground(int i2) {
        ColorDrawable colorDrawable = new ColorDrawable(i2);
        this.f609l = colorDrawable;
        colorDrawable.setBounds(this.b);
        invalidate();
    }

    public void setRippleColor(int i2) {
        this.c = i2;
        this.a.setColor(i2);
        this.a.setAlpha(this.f605h);
        invalidate();
    }

    public void setRippleDelayClick(boolean z) {
        this.f606i = z;
    }

    public void setRippleDiameter(int i2) {
        this.f603f = i2;
    }

    public void setRippleDuration(int i2) {
        this.f604g = i2;
    }

    public void setRippleFadeDuration(int i2) {
        this.f607j = i2;
    }

    public void setRippleHover(boolean z) {
        this.f602e = z;
    }

    public void setRippleInAdapter(boolean z) {
        this.m = z;
    }

    public void setRippleOverlay(boolean z) {
        this.f601d = z;
    }

    public void setRipplePersistent(boolean z) {
        this.f608k = z;
    }

    public void setRippleRoundedCorners(int i2) {
        this.n = i2;
        s();
    }

    public int x() {
        return this.a.getAlpha();
    }

    public MaterialRippleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialRippleLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Paint paint = new Paint(1);
        this.a = paint;
        this.b = new Rect();
        this.t = new Point();
        this.u = new Point();
        this.D = new b();
        this.E = new d(this, Float.class, "radius");
        this.F = new e(this, Integer.class, "rippleAlpha");
        setWillNotDraw(false);
        this.z = new GestureDetector(context, this.D);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialRippleLayout);
        this.c = obtainStyledAttributes.getColor(R.styleable.MaterialRippleLayout_mrl_rippleColor, ViewCompat.MEASURED_STATE_MASK);
        this.f603f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialRippleLayout_mrl_rippleDimension, (int) r(getResources(), 35.0f));
        this.f601d = obtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_rippleOverlay, false);
        this.f602e = obtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_rippleHover, true);
        this.f604g = obtainStyledAttributes.getInt(R.styleable.MaterialRippleLayout_mrl_rippleDuration, 350);
        this.f605h = (int) (obtainStyledAttributes.getFloat(R.styleable.MaterialRippleLayout_mrl_rippleAlpha, 0.2f) * 255.0f);
        this.f606i = obtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_rippleDelayClick, true);
        this.f607j = obtainStyledAttributes.getInteger(R.styleable.MaterialRippleLayout_mrl_rippleFadeDuration, 75);
        this.f609l = new ColorDrawable(obtainStyledAttributes.getColor(R.styleable.MaterialRippleLayout_mrl_rippleBackground, 0));
        this.f608k = obtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_ripplePersistent, false);
        this.m = obtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_rippleInAdapter, false);
        this.n = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialRippleLayout_mrl_rippleRoundedCorners, 0);
        obtainStyledAttributes.recycle();
        paint.setColor(this.c);
        paint.setAlpha(this.f605h);
        s();
    }
}
