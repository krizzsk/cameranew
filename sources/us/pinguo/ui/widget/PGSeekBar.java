package us.pinguo.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import us.pinguo.foundation.utils.n0;
/* loaded from: classes6.dex */
public class PGSeekBar extends View {
    protected float a;
    protected int b;
    protected int c;

    /* renamed from: d  reason: collision with root package name */
    protected int f12163d;

    /* renamed from: e  reason: collision with root package name */
    private c f12164e;

    /* renamed from: f  reason: collision with root package name */
    private b f12165f;

    /* renamed from: g  reason: collision with root package name */
    protected Paint f12166g;

    /* renamed from: h  reason: collision with root package name */
    protected int f12167h;

    /* renamed from: i  reason: collision with root package name */
    protected int f12168i;

    /* renamed from: j  reason: collision with root package name */
    protected int f12169j;

    /* renamed from: k  reason: collision with root package name */
    protected Drawable f12170k;

    /* renamed from: l  reason: collision with root package name */
    protected Paint f12171l;
    protected Paint m;
    protected int n;
    protected GestureDetector o;
    protected Scroller p;
    private boolean q;

    /* loaded from: classes6.dex */
    public interface b {
        void a(Canvas canvas, int i2, int i3, int i4, int i5);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(float f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class d extends GestureDetector.SimpleOnGestureListener {
        private d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            PGSeekBar pGSeekBar;
            int i2;
            if (PGSeekBar.this.q) {
                float y = motionEvent2.getY();
                PGSeekBar pGSeekBar2 = PGSeekBar.this;
                pGSeekBar2.f12167h = pGSeekBar2.d(pGSeekBar2.f12163d - y);
            } else {
                float x = motionEvent2.getX();
                PGSeekBar pGSeekBar3 = PGSeekBar.this;
                pGSeekBar3.f12167h = pGSeekBar3.d(x - pGSeekBar3.c);
            }
            if (PGSeekBar.this.f12164e != null && (i2 = (pGSeekBar = PGSeekBar.this).b) != 0) {
                pGSeekBar.a = pGSeekBar.f12167h / i2;
                pGSeekBar.f12164e.a(PGSeekBar.this.a);
            }
            PGSeekBar.this.invalidate();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            int d2;
            PGSeekBar pGSeekBar;
            int i2;
            if (!PGSeekBar.this.q) {
                d2 = PGSeekBar.this.d(motionEvent.getX() - PGSeekBar.this.c);
                PGSeekBar pGSeekBar2 = PGSeekBar.this;
                Scroller scroller = pGSeekBar2.p;
                int i3 = pGSeekBar2.f12167h;
                scroller.startScroll(0, i3, 0, d2 - i3, 400);
            } else {
                PGSeekBar pGSeekBar3 = PGSeekBar.this;
                d2 = pGSeekBar3.d(pGSeekBar3.f12163d - motionEvent.getY());
                PGSeekBar pGSeekBar4 = PGSeekBar.this;
                Scroller scroller2 = pGSeekBar4.p;
                int i4 = pGSeekBar4.f12167h;
                scroller2.startScroll(0, i4, 0, d2 - i4, 400);
            }
            if (PGSeekBar.this.f12164e != null && (i2 = (pGSeekBar = PGSeekBar.this).b) != 0) {
                pGSeekBar.a = d2 / i2;
                pGSeekBar.f12164e.a(PGSeekBar.this.a);
            }
            PGSeekBar.this.invalidate();
            return true;
        }
    }

    public PGSeekBar(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(float f2) {
        int i2 = (int) f2;
        if (i2 < 0) {
            return 0;
        }
        int i3 = this.b;
        return i2 > i3 ? i3 : i2;
    }

    private void e() {
        this.p = new Scroller(getContext());
        this.o = new GestureDetector(getContext(), new d());
        Paint paint = new Paint();
        this.f12166g = paint;
        paint.setAntiAlias(true);
        this.f12166g.setColor(-1);
        this.f12166g.setStrokeWidth(this.f12169j);
        this.f12166g.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f12171l = paint2;
        paint2.setAntiAlias(true);
        this.f12171l.setColor(-1);
        this.f12171l.setAlpha(200);
        Paint paint3 = new Paint();
        this.m = paint3;
        paint3.setAntiAlias(true);
        this.m.setColor(-1);
        this.m.setAlpha(200);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int paddingTop;
        int i2;
        if (this.b == 0) {
            if (this.q) {
                int height = getHeight();
                this.b = (((height - getPaddingTop()) - getPaddingBottom()) - (this.f12168i * 2)) - (this.f12169j * 2);
                this.c = getPaddingTop() + this.f12168i + this.f12169j;
                this.f12163d = ((height - getPaddingBottom()) - this.f12168i) - this.f12169j;
            } else {
                int width = getWidth();
                this.b = (((width - getPaddingLeft()) - getPaddingRight()) - (this.f12168i * 2)) - (this.f12169j * 2);
                this.c = getPaddingLeft() + this.f12168i + this.f12169j;
                this.f12163d = ((width - getPaddingRight()) - this.f12168i) - this.f12169j;
            }
            this.f12167h = (int) (this.b * this.a);
        }
        if (this.q) {
            int paddingLeft = ((getPaddingLeft() + this.f12168i) + (this.f12169j / 2)) - (this.n / 2);
            int paddingLeft2 = getPaddingLeft();
            int i3 = this.n;
            int i4 = this.f12168i;
            int i5 = this.f12169j;
            int i6 = (((paddingLeft2 + i3) + i4) + (i5 / 2)) - (i3 / 2);
            int i7 = ((this.f12163d - this.f12167h) + (i5 / 2)) - i4;
            int i8 = this.c;
            if (i7 > i8) {
                canvas.drawRect(paddingLeft, i8, i6, i7, this.m);
            }
            int i9 = i7 + (this.f12168i * 2);
            int i10 = this.f12163d;
            if (i10 > i9) {
                canvas.drawRect(paddingLeft, i9, i6, i10, this.f12171l);
            }
        } else {
            int paddingTop2 = ((getPaddingTop() + this.f12168i) + (this.f12169j / 2)) - (this.n / 2);
            int paddingTop3 = getPaddingTop();
            int i11 = this.n;
            int i12 = this.f12168i;
            int i13 = this.f12169j;
            int i14 = (((paddingTop3 + i11) + i12) + (i13 / 2)) - (i11 / 2);
            int i15 = this.c;
            int i16 = ((this.f12167h + i15) + (i13 / 2)) - i12;
            if (i16 > i15) {
                canvas.drawRect(i15, paddingTop2, i16, i14, this.f12171l);
            }
            int i17 = i16 + (this.f12168i * 2);
            int i18 = this.f12163d;
            if (i18 > i17) {
                canvas.drawRect(i17, paddingTop2, i18, i14, this.m);
            }
            b bVar = this.f12165f;
            if (bVar != null) {
                bVar.a(canvas, this.c, i16, i17, this.f12163d);
            }
        }
        if (this.q) {
            i2 = this.f12168i + (this.f12169j / 2) + getPaddingLeft();
            paddingTop = this.f12163d - this.f12167h;
        } else {
            paddingTop = getPaddingTop() + this.f12168i + (this.f12169j / 2);
            i2 = this.c + this.f12167h;
        }
        canvas.drawCircle(i2, paddingTop, this.f12168i, this.f12166g);
        Drawable drawable = this.f12170k;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth() / 2;
            int intrinsicHeight = this.f12170k.getIntrinsicHeight() / 2;
            this.f12170k.setBounds(i2 - intrinsicWidth, paddingTop - intrinsicHeight, i2 + intrinsicWidth, paddingTop + intrinsicHeight);
            this.f12170k.draw(canvas);
        }
        if (this.p.computeScrollOffset()) {
            this.f12167h = this.p.getCurrY();
            invalidate();
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.q) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i3);
            if (mode == Integer.MIN_VALUE) {
                int i4 = this.f12168i;
                int i5 = this.f12169j;
                int i6 = (i4 + i5) * 2;
                int i7 = this.n;
                if (i6 > i7) {
                    i7 = (i4 + i5) * 2;
                }
                Drawable drawable = this.f12170k;
                if (drawable != null && i7 <= drawable.getIntrinsicWidth()) {
                    i7 = this.f12170k.getIntrinsicWidth();
                }
                setMeasuredDimension(i7 + getPaddingLeft() + getPaddingRight(), size);
                return;
            }
            super.onMeasure(i2, i3);
            return;
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            int i8 = this.f12168i;
            int i9 = this.f12169j;
            int i10 = (i8 + i9) * 2;
            int i11 = this.n;
            if (i10 > i11) {
                i11 = (i8 + i9) * 2;
            }
            Drawable drawable2 = this.f12170k;
            if (drawable2 != null && i11 <= drawable2.getIntrinsicHeight()) {
                i11 = this.f12170k.getIntrinsicHeight();
            }
            setMeasuredDimension(size2, i11 + getPaddingTop() + getPaddingBottom());
            return;
        }
        super.onMeasure(i2, i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000b, code lost:
        if (r0 != 3) goto L7;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r3) {
        /*
            r2 = this;
            int r0 = r3.getAction()
            r1 = 1
            if (r0 == r1) goto L12
            r1 = 2
            if (r0 == r1) goto Le
            r1 = 3
            if (r0 == r1) goto L12
            goto L15
        Le:
            r2.invalidate()
            goto L15
        L12:
            r2.invalidate()
        L15:
            android.view.GestureDetector r0 = r2.o
            boolean r3 = r0.onTouchEvent(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.ui.widget.PGSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setCurrentSeekValue(float f2) {
        float f3 = this.a;
        if (f3 > 1.0f) {
            this.a = 1.0f;
        } else if (f3 < 0.0f) {
            this.a = 0.0f;
        }
        this.a = f2;
        this.f12167h = (int) (this.b * f2);
        invalidate();
    }

    public void setOnSeekChangedListener(c cVar) {
        this.f12164e = cVar;
    }

    public void setOrientation(boolean z) {
        this.q = z;
        requestLayout();
    }

    public void setProgress(int i2) {
        setCurrentSeekValue(i2 / 100.0f);
    }

    public void setmOnDrawListener(b bVar) {
        this.f12165f = bVar;
    }

    public PGSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12168i = n0.c(6);
        this.f12169j = Math.round(n0.b(1.5f));
        this.n = Math.round(n0.b(1.5f));
        this.q = true;
        e();
    }
}
