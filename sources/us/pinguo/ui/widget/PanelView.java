package us.pinguo.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
public class PanelView extends FrameLayout {
    private int a;
    private float b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f12172d;

    /* renamed from: e  reason: collision with root package name */
    private float f12173e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12174f;

    /* renamed from: g  reason: collision with root package name */
    private int f12175g;

    /* renamed from: h  reason: collision with root package name */
    private float f12176h;

    /* renamed from: i  reason: collision with root package name */
    private int f12177i;

    /* renamed from: j  reason: collision with root package name */
    private int f12178j;

    /* renamed from: k  reason: collision with root package name */
    private int f12179k;

    /* renamed from: l  reason: collision with root package name */
    private int f12180l;
    private Paint m;
    private Paint n;
    private Path o;
    private View p;
    private int q;

    public PanelView(Context context) {
        super(context);
        f();
        g();
    }

    private void a(Canvas canvas) {
        Log.d("PanelView", "arrow_height=" + this.b);
        float tan = this.b / ((float) Math.tan((((double) this.c) * 3.141592653589793d) / 180.0d));
        int d2 = d();
        this.o.reset();
        float f2 = d2;
        this.o.moveTo(f2 - tan, this.b);
        this.o.lineTo(f2, 0.0f);
        this.o.lineTo(f2 + tan, this.b);
        this.o.close();
        canvas.drawPath(this.o, this.m);
    }

    private void b(Canvas canvas) {
        RectF rectF = new RectF(0.0f, this.b, getWidth(), getHeight());
        int i2 = this.f12180l;
        canvas.drawRoundRect(rectF, i2, i2, this.m);
    }

    private void c(Canvas canvas) {
        if (this.f12174f) {
            if (this.f12179k == 1) {
                return;
            }
            for (int i2 = 1; i2 < this.f12179k; i2++) {
                float f2 = this.f12176h;
                float paddingTop = ((int) this.b) + getPaddingTop() + (this.f12177i * i2) + ((int) (((i2 - 1) * f2) + f2));
                canvas.drawLine(this.q, paddingTop, getWidth() - this.q, paddingTop, this.n);
            }
        }
    }

    private int d() {
        int width = getWidth() / 2;
        View view = this.p;
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int[] iArr2 = new int[2];
            getLocationInWindow(iArr2);
            return (iArr[0] + (this.p.getWidth() / 2)) - iArr2[0];
        }
        return width;
    }

    private int e() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3).getVisibility() != 8) {
                i2++;
            }
        }
        return i2;
    }

    private void f() {
        this.a = 2;
        this.b = 100.0f;
        this.c = 45;
        this.f12173e = getContext().getResources().getDisplayMetrics().density * 1.0f;
        this.f12180l = (int) (getContext().getResources().getDisplayMetrics().density * 3.0f);
        this.q = (int) (getContext().getResources().getDisplayMetrics().density * 6.0f);
        this.f12174f = true;
        this.f12175g = -1;
        this.n = new Paint(1);
    }

    private void g() {
        Paint paint = new Paint();
        this.m = paint;
        paint.setColor(this.f12172d);
        this.m.setStrokeWidth(1.0f);
        this.o = new Path();
        setWillNotDraw(false);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
        c(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        int i6 = 1;
        int i7 = 1;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                int paddingLeft = getPaddingLeft() + (this.f12178j * (i6 - 1));
                int paddingTop = ((int) this.b) + getPaddingTop();
                int i9 = this.f12177i;
                int i10 = i7 - 1;
                int i11 = paddingTop + (i9 * i10) + (((int) this.f12176h) * i10);
                childAt.layout(paddingLeft, i11, this.f12178j + paddingLeft, i9 + i11);
                i6++;
                if (i6 > this.a) {
                    i7++;
                    i6 = 1;
                }
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode != 0 || mode == 1073741824) {
            int e2 = e();
            if (e2 == 0) {
                setMeasuredDimension(size, getSuggestedMinimumHeight());
                return;
            }
            int paddingLeft = ((size - getPaddingLeft()) - getPaddingRight()) / this.a;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), FrameLayout.getChildMeasureSpec(i3, 0, childAt.getLayoutParams().height));
                    i5 = Math.max(i5, childAt.getMeasuredHeight());
                    i4++;
                }
            }
            int i7 = this.a;
            this.f12179k = (i4 / i7) + (i4 % i7 != 0 ? 1 : 0);
            this.f12177i = i5;
            this.f12178j = paddingLeft;
            int ceil = (((int) Math.ceil((e2 * 1.0f) / i7)) * i5) + ((int) this.b) + getPaddingTop() + getPaddingBottom() + ((this.f12179k - 1) * ((int) this.f12176h));
            if (mode2 == 1073741824) {
                setMeasuredDimension(size, size2);
                return;
            } else {
                setMeasuredDimension(size, ceil);
                return;
            }
        }
        throw new IllegalArgumentException("width should be exactly");
    }

    public void setAnchorView(View view) {
        this.p = view;
    }

    public PanelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.CustomPanelStyle);
    }

    public PanelView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        f();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.panelStyle, i2, R.style.defaultPanelStyle);
        this.a = obtainStyledAttributes.getInteger(R.styleable.panelStyle_column_count, 5);
        this.f12173e = obtainStyledAttributes.getDimension(R.styleable.panelStyle_separator_size, 1.0f);
        this.f12174f = obtainStyledAttributes.getBoolean(R.styleable.panelStyle_row_separator, false);
        obtainStyledAttributes.getBoolean(R.styleable.panelStyle_column_separator, false);
        this.f12175g = obtainStyledAttributes.getColor(R.styleable.panelStyle_separator_color, -1);
        obtainStyledAttributes.getDimension(R.styleable.panelStyle_separator_paddingLeftRight, 5.0f);
        this.f12176h = obtainStyledAttributes.getDimension(R.styleable.panelStyle_separator_paddingTopBottom, 5.0f);
        this.b = obtainStyledAttributes.getDimension(R.styleable.panelStyle_arrow_height, 20.0f);
        this.f12180l = (int) obtainStyledAttributes.getDimension(R.styleable.panelStyle_round_corner, 3.0f);
        this.c = obtainStyledAttributes.getInteger(R.styleable.panelStyle_arrow_angle, 45);
        this.f12172d = obtainStyledAttributes.getColor(R.styleable.panelStyle_arrow_background, -1);
        obtainStyledAttributes.recycle();
        this.n.setColor(this.f12175g);
        this.n.setStrokeWidth(this.f12173e);
        g();
    }
}
