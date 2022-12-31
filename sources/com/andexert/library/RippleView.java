package com.andexert.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class RippleView extends RelativeLayout {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f592d;

    /* renamed from: e  reason: collision with root package name */
    private int f593e;

    /* renamed from: f  reason: collision with root package name */
    private Handler f594f;

    /* renamed from: g  reason: collision with root package name */
    private float f595g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f596h;

    /* renamed from: i  reason: collision with root package name */
    private int f597i;

    /* renamed from: j  reason: collision with root package name */
    private int f598j;

    /* renamed from: k  reason: collision with root package name */
    private int f599k;

    /* renamed from: l  reason: collision with root package name */
    private float f600l;
    private float m;
    private int n;
    private float o;
    private ScaleAnimation p;
    private Boolean q;
    private Boolean r;
    private Integer s;
    private Paint t;
    private Bitmap u;
    private int v;
    private int w;
    private GestureDetector x;
    private final Runnable y;
    private c z;

    /* loaded from: classes.dex */
    public enum RippleType {
        SIMPLE(0),
        DOUBLE(1),
        RECTANGLE(2);
        
        int type;

        RippleType(int i2) {
            this.type = i2;
        }
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RippleView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            super.onLongPress(motionEvent);
            RippleView.this.b(motionEvent);
            RippleView.this.f(Boolean.TRUE);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(RippleView rippleView);
    }

    public RippleView(Context context) {
        super(context);
        this.c = 10;
        this.f592d = 400;
        this.f593e = 90;
        this.f595g = 0.0f;
        this.f596h = false;
        this.f597i = 0;
        this.f598j = 0;
        this.f599k = -1;
        this.f600l = -1.0f;
        this.m = -1.0f;
        this.y = new a();
    }

    private void c(float f2, float f3) {
        if (!isEnabled() || this.f596h) {
            return;
        }
        if (this.q.booleanValue()) {
            startAnimation(this.p);
        }
        this.f595g = Math.max(this.a, this.b);
        if (this.s.intValue() != 2) {
            this.f595g /= 2.0f;
        }
        this.f595g -= this.w;
        if (!this.r.booleanValue() && this.s.intValue() != 1) {
            this.f600l = f2;
            this.m = f3;
        } else {
            this.f600l = getMeasuredWidth() / 2;
            this.m = getMeasuredHeight() / 2;
        }
        this.f596h = true;
        if (this.s.intValue() == 1 && this.u == null) {
            this.u = getDrawingCache(true);
        }
        invalidate();
    }

    private Bitmap d(int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(this.u.getWidth(), this.u.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        float f2 = this.f600l;
        float f3 = i2;
        float f4 = this.m;
        Rect rect = new Rect((int) (f2 - f3), (int) (f4 - f3), (int) (f2 + f3), (int) (f4 + f3));
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(this.f600l, this.m, f3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(this.u, rect, rect, paint);
        return createBitmap;
    }

    private void e(Context context, AttributeSet attributeSet) {
        if (isInEditMode()) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RippleView);
        this.v = obtainStyledAttributes.getColor(R.styleable.RippleView_rv_color, getResources().getColor(R.color.rippelColor));
        this.s = Integer.valueOf(obtainStyledAttributes.getInt(R.styleable.RippleView_rv_type, 0));
        this.q = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.RippleView_rv_zoom, false));
        this.r = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.RippleView_rv_centered, false));
        this.f592d = obtainStyledAttributes.getInteger(R.styleable.RippleView_rv_rippleDuration, this.f592d);
        this.c = obtainStyledAttributes.getInteger(R.styleable.RippleView_rv_framerate, this.c);
        this.f593e = obtainStyledAttributes.getInteger(R.styleable.RippleView_rv_alpha, this.f593e);
        this.w = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RippleView_rv_ripplePadding, 0);
        this.f594f = new Handler();
        this.o = obtainStyledAttributes.getFloat(R.styleable.RippleView_rv_zoomScale, 1.03f);
        this.n = obtainStyledAttributes.getInt(R.styleable.RippleView_rv_zoomDuration, 200);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.t = paint;
        paint.setAntiAlias(true);
        this.t.setStyle(Paint.Style.FILL);
        this.t.setColor(this.v);
        this.t.setAlpha(this.f593e);
        setWillNotDraw(false);
        this.x = new GestureDetector(context, new b());
        setDrawingCacheEnabled(true);
        setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Boolean bool) {
        if (getParent() instanceof AdapterView) {
            AdapterView<?> adapterView = (AdapterView) getParent();
            int positionForView = adapterView.getPositionForView(this);
            long itemIdAtPosition = adapterView.getItemIdAtPosition(positionForView);
            if (bool.booleanValue()) {
                if (adapterView.getOnItemLongClickListener() != null) {
                    adapterView.getOnItemLongClickListener().onItemLongClick(adapterView, this, positionForView, itemIdAtPosition);
                }
            } else if (adapterView.getOnItemClickListener() != null) {
                adapterView.getOnItemClickListener().onItemClick(adapterView, this, positionForView, itemIdAtPosition);
            }
        }
    }

    public void b(MotionEvent motionEvent) {
        c(motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f596h) {
            int i2 = this.f592d;
            int i3 = this.f597i;
            int i4 = this.c;
            if (i2 <= i3 * i4) {
                this.f596h = false;
                this.f597i = 0;
                this.f599k = -1;
                this.f598j = 0;
                canvas.restore();
                invalidate();
                c cVar = this.z;
                if (cVar != null) {
                    cVar.a(this);
                    return;
                }
                return;
            }
            this.f594f.postDelayed(this.y, i4);
            if (this.f597i == 0) {
                canvas.save();
            }
            canvas.drawCircle(this.f600l, this.m, this.f595g * ((this.f597i * this.c) / this.f592d), this.t);
            this.t.setColor(Color.parseColor("#ffff4444"));
            if (this.s.intValue() == 1 && this.u != null) {
                int i5 = this.f597i;
                int i6 = this.c;
                float f2 = i5 * i6;
                int i7 = this.f592d;
                if (f2 / i7 > 0.4f) {
                    if (this.f599k == -1) {
                        this.f599k = i7 - (i5 * i6);
                    }
                    int i8 = this.f598j + 1;
                    this.f598j = i8;
                    Bitmap d2 = d((int) (this.f595g * ((i8 * i6) / this.f599k)));
                    canvas.drawBitmap(d2, 0.0f, 0.0f, this.t);
                    d2.recycle();
                }
            }
            this.t.setColor(this.v);
            if (this.s.intValue() == 1) {
                int i9 = this.c;
                if ((this.f597i * i9) / this.f592d > 0.6f) {
                    Paint paint = this.t;
                    int i10 = this.f593e;
                    paint.setAlpha((int) (i10 - (i10 * ((this.f598j * i9) / this.f599k))));
                } else {
                    this.t.setAlpha(this.f593e);
                }
            } else {
                Paint paint2 = this.t;
                int i11 = this.f593e;
                paint2.setAlpha((int) (i11 - (i11 * ((this.f597i * this.c) / this.f592d))));
            }
            this.f597i++;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        onTouchEvent(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.a = i2;
        this.b = i3;
        float f2 = this.o;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f2, 1.0f, f2, i2 / 2, i3 / 2);
        this.p = scaleAnimation;
        scaleAnimation.setDuration(this.n);
        this.p.setRepeatMode(2);
        this.p.setRepeatCount(1);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.x.onTouchEvent(motionEvent)) {
            b(motionEvent);
            f(Boolean.FALSE);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCentered(Boolean bool) {
        this.r = bool;
    }

    public void setFrameRate(int i2) {
        this.c = i2;
    }

    public void setOnRippleCompleteListener(c cVar) {
        this.z = cVar;
    }

    public void setRippleAlpha(int i2) {
        this.f593e = i2;
    }

    public void setRippleColor(int i2) {
        this.v = getResources().getColor(i2);
    }

    public void setRippleDuration(int i2) {
        this.f592d = i2;
    }

    public void setRipplePadding(int i2) {
        this.w = i2;
    }

    public void setRippleType(RippleType rippleType) {
        this.s = Integer.valueOf(rippleType.ordinal());
    }

    public void setZoomDuration(int i2) {
        this.n = i2;
    }

    public void setZoomScale(float f2) {
        this.o = f2;
    }

    public void setZooming(Boolean bool) {
        this.q = bool;
    }

    public RippleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 10;
        this.f592d = 400;
        this.f593e = 90;
        this.f595g = 0.0f;
        this.f596h = false;
        this.f597i = 0;
        this.f598j = 0;
        this.f599k = -1;
        this.f600l = -1.0f;
        this.m = -1.0f;
        this.y = new a();
        e(context, attributeSet);
    }

    public RippleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = 10;
        this.f592d = 400;
        this.f593e = 90;
        this.f595g = 0.0f;
        this.f596h = false;
        this.f597i = 0;
        this.f598j = 0;
        this.f599k = -1;
        this.f600l = -1.0f;
        this.m = -1.0f;
        this.y = new a();
        e(context, attributeSet);
    }
}
