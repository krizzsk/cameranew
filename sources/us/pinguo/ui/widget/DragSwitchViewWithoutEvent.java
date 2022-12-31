package us.pinguo.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.Scroller;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
public class DragSwitchViewWithoutEvent extends View {
    private static final int G = us.pinguo.foundation.t.b.a.a(us.pinguo.foundation.e.b(), 15.0f);
    private a A;
    private boolean B;
    private int C;
    private int D;
    private int E;
    private float F;
    private String a;
    private Drawable b;
    private Paint c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f12134d;

    /* renamed from: e  reason: collision with root package name */
    private Path f12135e;

    /* renamed from: f  reason: collision with root package name */
    private int f12136f;

    /* renamed from: g  reason: collision with root package name */
    private int f12137g;

    /* renamed from: h  reason: collision with root package name */
    private int f12138h;

    /* renamed from: i  reason: collision with root package name */
    private int f12139i;

    /* renamed from: j  reason: collision with root package name */
    private int f12140j;

    /* renamed from: k  reason: collision with root package name */
    private int f12141k;

    /* renamed from: l  reason: collision with root package name */
    private int f12142l;
    private int m;
    private int n;
    private int o;
    private Rect p;
    private Point q;
    private Point r;
    private Rect s;
    private SparseArray<Integer> t;
    private Scroller u;
    private boolean v;
    private boolean w;
    private int x;
    private int y;
    private int z;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i2);
    }

    public DragSwitchViewWithoutEvent(Context context) {
        super(context);
        this.f12135e = new Path();
        this.f12136f = 1342177280;
        this.f12137g = -1;
        this.p = new Rect();
        this.q = new Point();
        new Point();
        this.r = new Point();
        this.s = new Rect();
        new Rect();
        this.t = new SparseArray<>();
        this.v = false;
        this.w = false;
        this.x = 0;
        this.y = 0;
        this.A = null;
        this.B = false;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0.0f;
        d();
    }

    private void a() {
        us.pinguo.common.log.a.c("autoSettle:check fling", new Object[0]);
        if (this.v || this.w) {
            return;
        }
        b();
    }

    private void b() {
        a aVar = this.A;
        if (aVar != null) {
            int i2 = this.x;
            int i3 = this.y;
            if (i2 != i3) {
                this.x = i3;
                aVar.a(i3);
            }
        }
    }

    private String c() {
        return String.valueOf(100);
    }

    private void d() {
        this.f12138h = us.pinguo.foundation.t.b.b.a(getContext(), 30);
        this.f12141k = us.pinguo.foundation.t.b.b.a(getContext(), 15);
        this.f12142l = us.pinguo.foundation.t.b.b.a(getContext(), 17);
        this.m = us.pinguo.foundation.t.b.b.a(getContext(), 22);
        this.n = us.pinguo.foundation.t.b.b.a(getContext(), 25);
        this.o = us.pinguo.foundation.t.b.b.a(getContext(), 10);
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(this.f12136f);
        this.c.setAntiAlias(true);
        this.c.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f12134d = paint2;
        paint2.setColor(this.f12137g);
        this.f12134d.setAntiAlias(true);
        this.f12134d.setTextAlign(Paint.Align.CENTER);
        int a2 = us.pinguo.foundation.t.b.b.a(getContext(), 28);
        this.z = a2;
        this.f12134d.setTextSize(a2);
        this.u = new Scroller(getContext());
        float f2 = getResources().getDisplayMetrics().density;
    }

    private void e(AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.DragSwitchViewWithoutEvent, i2, 0);
        String string = obtainStyledAttributes.getString(R.styleable.DragSwitchViewWithoutEvent_left_text);
        if (TextUtils.isEmpty(string)) {
            this.a = "";
        } else {
            this.a = string;
        }
        this.b = obtainStyledAttributes.getDrawable(R.styleable.DragSwitchViewWithoutEvent_icon);
    }

    private boolean f(float f2) {
        boolean z;
        if (this.F + Math.abs(f2) < G) {
            this.F += Math.abs(f2);
            z = false;
        } else {
            this.F = 0.0f;
            z = true;
        }
        if (z) {
            if (f2 > 0.0f) {
                this.y += this.E;
            } else {
                this.y -= this.E;
            }
            int i2 = this.y;
            int i3 = this.D;
            if (i2 > i3) {
                this.y = i3;
            }
            int i4 = this.y;
            int i5 = this.C;
            if (i4 < i5) {
                this.y = i5;
            }
        }
        return z;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.B) {
            b();
        }
        if (this.u.computeScrollOffset()) {
            f(this.u.getCurrY());
            invalidate();
        } else if (this.v) {
            this.v = false;
            a();
        } else if (this.w) {
        } else {
            b();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.t.clear();
        canvas.clipPath(this.f12135e);
        RectF rectF = new RectF(this.p);
        int i2 = this.f12138h;
        canvas.drawRoundRect(rectF, i2, i2, this.c);
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.draw(canvas);
        } else {
            String str = this.a;
            Point point = this.q;
            canvas.drawText(str, point.x, point.y, this.f12134d);
        }
        String valueOf = String.valueOf(this.y);
        Point point2 = this.r;
        canvas.drawText(valueOf, point2.x, point2.y, this.f12134d);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        int width;
        int i6;
        super.onSizeChanged(i2, i3, i4, i5);
        this.f12139i = i2 / 2;
        this.f12140j = us.pinguo.foundation.t.b.a.a(getContext(), 70.0f);
        String str = this.a + c();
        Rect rect = new Rect();
        this.f12134d.getTextBounds(str, 0, str.length(), rect);
        Rect rect2 = new Rect();
        Paint paint = this.f12134d;
        String str2 = this.a;
        paint.getTextBounds(str2, 0, str2.length(), rect2);
        this.s = new Rect();
        String c = c();
        this.f12134d.getTextBounds(c, 0, c.length(), this.s);
        this.f12134d.getTextBounds(PGTransHeader.CONNECTOR, 0, 1, new Rect());
        if (this.b != null) {
            width = this.m + this.n + rect.width() + this.o;
            i6 = this.b.getIntrinsicWidth();
        } else {
            width = this.m + this.n + rect.width();
            i6 = this.o;
        }
        int i7 = width + i6;
        int height = this.f12141k + this.f12142l + rect.height();
        int i8 = this.f12139i;
        int i9 = i7 / 2;
        int i10 = this.f12140j;
        this.p = new Rect(i8 - i9, i10, (i8 - i9) + i7, i10 + height);
        this.q = new Point(this.p.left + this.m + (rect2.width() / 2), this.p.bottom - this.f12142l);
        Drawable drawable = this.b;
        if (drawable != null) {
            Rect rect3 = this.p;
            int i11 = rect3.left + this.m;
            int intrinsicHeight = rect3.top + ((height - drawable.getIntrinsicHeight()) / 2);
            Drawable drawable2 = this.b;
            drawable2.setBounds(i11, intrinsicHeight, drawable2.getIntrinsicWidth() + i11, this.b.getIntrinsicHeight() + intrinsicHeight);
        }
        this.r = new Point((this.p.right - this.n) - (this.s.width() / 2), this.q.y);
        Rect rect4 = this.p;
        new Point(this.q.x + (rect2.width() / 2) + (((this.r.x - (this.s.width() / 2)) - (this.q.x + (rect2.width() / 2))) / 2), rect4.bottom - (rect4.height() / 2));
        Point point = this.r;
        new Rect(point.x, point.y - this.s.height(), this.r.x + this.s.width(), this.r.y);
        Path path = this.f12135e;
        RectF rectF = new RectF(this.p);
        int i12 = this.f12138h;
        path.addRoundRect(rectF, i12, i12, Path.Direction.CW);
    }

    public void setCurrentIndex(int i2) {
        this.x = i2;
        this.y = i2;
        invalidate();
    }

    public void setDispatchEveryChange(boolean z) {
        this.B = z;
    }

    public void setItemChangeListener(a aVar) {
        this.A = aVar;
    }

    public void setItemListByRange(int i2, int i3, int i4) {
        this.C = i2;
        this.D = i3;
        this.E = i4;
        requestLayout();
    }

    public DragSwitchViewWithoutEvent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12135e = new Path();
        this.f12136f = 1342177280;
        this.f12137g = -1;
        this.p = new Rect();
        this.q = new Point();
        new Point();
        this.r = new Point();
        this.s = new Rect();
        new Rect();
        this.t = new SparseArray<>();
        this.v = false;
        this.w = false;
        this.x = 0;
        this.y = 0;
        this.A = null;
        this.B = false;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0.0f;
        e(attributeSet, 0);
        d();
    }

    public DragSwitchViewWithoutEvent(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12135e = new Path();
        this.f12136f = 1342177280;
        this.f12137g = -1;
        this.p = new Rect();
        this.q = new Point();
        new Point();
        this.r = new Point();
        this.s = new Rect();
        new Rect();
        this.t = new SparseArray<>();
        this.v = false;
        this.w = false;
        this.x = 0;
        this.y = 0;
        this.A = null;
        this.B = false;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0.0f;
        e(attributeSet, i2);
        d();
    }
}
