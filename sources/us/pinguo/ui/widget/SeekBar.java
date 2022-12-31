package us.pinguo.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
public class SeekBar extends View {
    private Scroller a;
    private GestureDetector b;
    private Paint c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f12191d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f12192e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f12193f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f12194g;

    /* renamed from: h  reason: collision with root package name */
    private float f12195h;

    /* renamed from: i  reason: collision with root package name */
    private float f12196i;

    /* renamed from: j  reason: collision with root package name */
    private float f12197j;

    /* renamed from: k  reason: collision with root package name */
    private float f12198k;

    /* renamed from: l  reason: collision with root package name */
    private float f12199l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private int r;
    private int s;
    private int t;
    private int u;
    private b v;
    private float w;
    private c x;
    private boolean y;
    private boolean z;

    /* loaded from: classes6.dex */
    public interface b {
        void a(float f2, float f3);

        void b(float f2, float f3);

        void c(float f2, float f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        private c() {
        }

        public boolean a(MotionEvent motionEvent) {
            float f2 = SeekBar.this.q;
            SeekBar.this.w();
            SeekBar.this.a.startScroll(0, Math.round(f2), 0, Math.round(SeekBar.this.q - f2), 400);
            SeekBar.this.q = f2;
            SeekBar.this.invalidate();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            int t = (int) SeekBar.this.t(motionEvent.getX() - SeekBar.this.n);
            SeekBar.this.a.startScroll(0, (int) SeekBar.this.q, 0, (int) (t - SeekBar.this.q), 400);
            SeekBar seekBar = SeekBar.this;
            seekBar.v((int) ((t * seekBar.r) / SeekBar.this.m));
            SeekBar.this.w();
            SeekBar.this.invalidate();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            float f4;
            SeekBar.f(SeekBar.this, f2);
            if (SeekBar.this.q < SeekBar.this.n - SeekBar.this.f12195h) {
                SeekBar seekBar = SeekBar.this;
                seekBar.q = seekBar.n - SeekBar.this.f12195h;
            }
            if (SeekBar.this.q > SeekBar.this.o - SeekBar.this.f12195h) {
                SeekBar seekBar2 = SeekBar.this;
                seekBar2.q = seekBar2.o - SeekBar.this.f12195h;
            }
            if (SeekBar.this.t == 0 || SeekBar.this.t == SeekBar.this.r) {
                f4 = (SeekBar.this.q * SeekBar.this.r) / SeekBar.this.m;
            } else {
                float f5 = SeekBar.this.f12199l * 2.0f;
                f4 = SeekBar.this.q < SeekBar.this.p - SeekBar.this.f12199l ? (SeekBar.this.q * (SeekBar.this.r - 2)) / (SeekBar.this.m - f5) : SeekBar.this.q > SeekBar.this.p + SeekBar.this.f12199l ? SeekBar.this.t + ((((SeekBar.this.q - SeekBar.this.p) - SeekBar.this.f12199l) * (SeekBar.this.r - 2)) / (SeekBar.this.m - f5)) + 1.0f : SeekBar.this.t;
            }
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            if (f4 > SeekBar.this.r) {
                f4 = SeekBar.this.r;
            }
            SeekBar.this.v(Math.round(f4));
            SeekBar.this.invalidate();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            int i2 = SeekBar.this.s - 1;
            if (motionEvent.getX() > SeekBar.this.q) {
                i2 = SeekBar.this.s + 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 > SeekBar.this.r) {
                i2 = SeekBar.this.r;
            }
            SeekBar.this.v(i2);
            float f2 = SeekBar.this.q;
            SeekBar.this.w();
            SeekBar.this.a.startScroll(0, Math.round(f2), 0, Math.round(SeekBar.this.q - f2), 400);
            SeekBar.this.q = f2;
            SeekBar.this.invalidate();
            if (SeekBar.this.v != null) {
                SeekBar.this.v.c((SeekBar.this.s + SeekBar.this.u) * SeekBar.this.w, SeekBar.this.w);
            }
            return true;
        }
    }

    public SeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12195h = 24.0f;
        this.f12196i = 8.0f;
        this.f12197j = 1.5f;
        this.f12198k = 1.5f;
        this.f12199l = (((24.0f - 8.0f) - 1.5f) + 24.0f) / 2.0f;
        this.r = 100;
        this.s = 50;
        this.t = 50;
        this.y = true;
        this.z = true;
        this.f12195h = context.getResources().getDimension(R.dimen.seekbar_thumb_radius);
        this.f12196i = context.getResources().getDimension(R.dimen.seekbar_nail_radius);
        this.f12197j = context.getResources().getDimension(R.dimen.seekbar_nail_stroke_width);
        this.f12198k = context.getResources().getDimension(R.dimen.seekbar_line_width);
        u();
    }

    static /* synthetic */ float f(SeekBar seekBar, float f2) {
        float f3 = seekBar.q - f2;
        seekBar.q = f3;
        return f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float t(float f2) {
        if (f2 < 0.0f) {
            return 0.0f;
        }
        float f3 = this.m;
        return f2 > f3 ? f3 : f2;
    }

    private void u() {
        this.a = new Scroller(getContext());
        this.x = new c();
        this.b = new GestureDetector(getContext(), this.x);
        Paint paint = new Paint();
        this.f12194g = paint;
        paint.setAntiAlias(true);
        this.f12194g.setColor(Color.parseColor("#ffe049"));
        this.f12194g.setStrokeWidth(this.f12197j);
        this.f12194g.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.c = paint2;
        paint2.setAntiAlias(true);
        this.c.setColor(Color.parseColor("#ffffff"));
        this.c.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint();
        this.f12191d = paint3;
        paint3.setAntiAlias(true);
        this.f12191d.setColor(Color.parseColor("#ffffff"));
        this.f12191d.setAlpha(200);
        Paint paint4 = new Paint();
        this.f12192e = paint4;
        paint4.setAntiAlias(true);
        this.f12192e.setColor(Color.parseColor("#ffffff"));
        this.f12192e.setAlpha(200);
        Paint paint5 = new Paint();
        this.f12193f = paint5;
        paint5.setAntiAlias(true);
        this.f12193f.setColor(Color.parseColor("#ffe049"));
        this.f12193f.setAlpha(200);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i2) {
        if (this.s == i2) {
            return;
        }
        this.s = i2;
        b bVar = this.v;
        if (bVar != null) {
            float f2 = this.w;
            bVar.b((i2 + this.u) * f2, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        int i2;
        int i3 = this.t;
        if (i3 != 0 && i3 != (i2 = this.r)) {
            float f2 = this.f12199l * 2.0f;
            int i4 = this.s;
            if (i4 == 0) {
                this.q = 0.0f;
                return;
            } else if (i4 == i2) {
                this.q = this.o - this.n;
                return;
            } else if (i4 < i3) {
                this.q = ((this.m - f2) * i4) / i2;
                return;
            } else if (i4 > i3) {
                this.q = (((this.m - f2) * i4) / i2) + f2;
                return;
            } else {
                this.q = this.p;
                return;
            }
        }
        int i5 = this.s;
        if (i5 == 0) {
            this.q = 0.0f;
            return;
        }
        int i6 = this.r;
        if (i5 == i6) {
            this.q = this.o - this.n;
        } else if (i5 == i3) {
            this.q = this.p;
        } else {
            this.q = (i5 * this.m) / i6;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.m == 0.0f) {
            int width = getWidth();
            this.m = ((width - getPaddingLeft()) - getPaddingRight()) - (this.f12195h * 2.0f);
            this.n = getPaddingLeft() + this.f12195h;
            this.o = (width - getPaddingRight()) - this.f12195h;
            float f2 = this.m;
            int i2 = this.t;
            int i3 = this.r;
            float f3 = (i2 * f2) / i3;
            this.p = f3;
            if (i2 != 0 && i2 != i3) {
                float f4 = this.f12199l;
                float f5 = f4 * 2.0f;
                int i4 = this.s;
                if (i4 < i2) {
                    this.q = ((f2 - f5) * i4) / i3;
                } else if (i4 > i2) {
                    this.q = (((f2 - f5) * i4) / i3) + (f4 * 2.0f);
                } else {
                    this.q = f3;
                }
            } else {
                this.q = (f2 * this.s) / i3;
            }
        }
        float f6 = this.f12198k;
        float measuredHeight = (getMeasuredHeight() / 2) - (f6 / 2.0f);
        float f7 = f6 + measuredHeight;
        float f8 = this.n;
        float f9 = ((this.p + f8) + (this.f12197j / 2.0f)) - this.f12196i;
        if (f9 > f8) {
            canvas.drawRect(f8, measuredHeight, f9, f7, this.f12191d);
        }
        float f10 = f9 + (this.f12196i * 2.0f);
        float f11 = this.o;
        if (f11 > f10) {
            canvas.drawRect(f10, measuredHeight, f11, f7, this.f12192e);
        }
        float f12 = this.n + this.p;
        float measuredHeight2 = getMeasuredHeight() / 2;
        if (this.y) {
            canvas.drawCircle(f12, measuredHeight2, this.f12196i, this.f12194g);
        }
        float f13 = this.n + this.q;
        float measuredHeight3 = getMeasuredHeight() / 2;
        float f14 = this.f12195h;
        float f15 = f13 + f14;
        float f16 = this.f12196i;
        float f17 = f12 - f16;
        if (f13 > f12) {
            f15 = f12 + f16;
            f17 = f13 - f14;
        }
        canvas.drawRect(f15, measuredHeight, f17, f7, this.f12193f);
        canvas.drawCircle(f13, measuredHeight3, this.f12195h, this.c);
        if (this.a.computeScrollOffset()) {
            this.q = this.a.getCurrY();
            invalidate();
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE) {
            setMeasuredDimension(View.MeasureSpec.getSize(i2), Math.round(this.f12195h * 2.0f) + getPaddingTop() + getPaddingBottom());
        } else {
            super.onMeasure(i2, i3);
        }
        this.m = 0.0f;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        if (this.z) {
            if (motionEvent.getAction() == 0 && (bVar = this.v) != null) {
                float f2 = this.w;
                bVar.a((this.s + this.u) * f2, f2);
            }
            if (this.b.onTouchEvent(motionEvent)) {
                return true;
            }
            if (1 == motionEvent.getAction()) {
                this.x.a(motionEvent);
                b bVar2 = this.v;
                if (bVar2 != null) {
                    float f3 = this.w;
                    bVar2.c((this.s + this.u) * f3, f3);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void setCircleColor(int i2) {
        this.c.setColor(i2);
        invalidate();
    }

    public void setDrawThumbCircle(boolean z) {
        this.y = z;
    }

    public void setEnableTouch(boolean z) {
        this.z = z;
    }

    public void setLine2Color(int i2) {
        this.f12192e.setColor(i2);
        invalidate();
    }

    public void setLineColor(int i2) {
        this.f12193f.setColor(i2);
        this.f12194g.setColor(i2);
    }

    public void setLineWidth(int i2) {
        this.f12198k = i2;
        invalidate();
    }

    public void setOnSeekChangeListener(b bVar) {
        this.v = bVar;
    }

    public void setSeekLength(int i2, int i3, int i4, float f2) {
        this.t = Math.round((i4 - i2) / f2);
        this.r = Math.round((i3 - i2) / f2);
        this.u = Math.round(i2 / f2);
        this.w = f2;
    }

    public void setThumbSize(float f2) {
        this.f12195h = f2;
    }

    public void setValue(float f2) {
        int round = Math.round(f2 / this.w) - this.u;
        if (round == this.s) {
            return;
        }
        this.s = round;
        b bVar = this.v;
        if (bVar != null) {
            float f3 = this.w;
            bVar.b(f2 * f3, f3);
        }
        this.a.abortAnimation();
        w();
        invalidate();
    }
}
