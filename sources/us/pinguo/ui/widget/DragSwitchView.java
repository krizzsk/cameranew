package us.pinguo.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import androidx.core.view.GestureDetectorCompat;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
public class DragSwitchView extends View implements GestureDetector.OnGestureListener {
    private static int L;
    private static int M;
    private OverScroller A;
    private boolean B;
    private boolean C;
    private boolean D;
    private int E;
    private boolean F;
    private boolean G;
    private int H;
    private int I;
    private b J;
    private a K;
    private String a;
    private Paint b;
    private Paint c;

    /* renamed from: d  reason: collision with root package name */
    private int f12115d;

    /* renamed from: e  reason: collision with root package name */
    private int f12116e;

    /* renamed from: f  reason: collision with root package name */
    private int f12117f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12118g;

    /* renamed from: h  reason: collision with root package name */
    private int f12119h;

    /* renamed from: i  reason: collision with root package name */
    private int f12120i;

    /* renamed from: j  reason: collision with root package name */
    private int f12121j;

    /* renamed from: k  reason: collision with root package name */
    private int f12122k;

    /* renamed from: l  reason: collision with root package name */
    private int f12123l;
    private int m;
    private int n;
    private int o;
    private Rect p;
    private Point q;
    private Point r;
    private Rect s;
    private int t;
    private int u;
    private int v;
    private List<String> w;
    private Rect x;
    private SparseArray<Integer> y;
    private GestureDetectorCompat z;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b(boolean z);

        void c();

        void d();

        void e(boolean z);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(int i2);
    }

    public DragSwitchView(Context context) {
        super(context);
        this.f12115d = 1728019059;
        this.f12116e = -1;
        this.f12118g = false;
        this.t = 0;
        this.y = new SparseArray<>();
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = false;
        this.G = true;
        this.H = 0;
        this.J = null;
        this.K = null;
        f();
    }

    private void a() {
        if (this.B) {
            return;
        }
        int c = c();
        if (c != 0) {
            this.A.startScroll(0, this.t, 0, c, 500);
            invalidate();
        } else if (this.C) {
        } else {
            d();
        }
    }

    private int b() {
        Rect rect = this.x;
        int i2 = (rect.top + rect.bottom) / 2;
        int i3 = Integer.MAX_VALUE;
        int i4 = -1;
        for (int i5 = 0; i5 < this.w.size(); i5++) {
            if (this.y.get(i5) == null) {
                us.pinguo.common.log.a.c("calculateCurrentIndex,get is null,continue", new Object[0]);
            } else {
                int intValue = i2 - this.y.get(i5).intValue();
                if (Math.abs(i3) > Math.abs(intValue)) {
                    i4 = i5;
                    i3 = intValue;
                }
            }
        }
        us.pinguo.common.log.a.c("calculateCurrentIndex,index is:" + i4, new Object[0]);
        return i4;
    }

    private int c() {
        Rect rect = this.x;
        int i2 = (rect.top + rect.bottom) / 2;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < this.w.size(); i4++) {
            int intValue = i2 - this.y.get(i4).intValue();
            if (Math.abs(i3) > Math.abs(intValue)) {
                i3 = intValue;
            }
        }
        return i3;
    }

    private void d() {
        int b2;
        if (this.J == null || (b2 = b()) < 0 || b2 > this.w.size() - 1 || this.E == b2) {
            return;
        }
        us.pinguo.common.log.a.c("call onItemChange,the selected item is:" + b2, new Object[0]);
        us.pinguo.common.log.a.c(Log.getStackTraceString(new Throwable()), new Object[0]);
        this.E = b2;
        this.J.a(b2);
    }

    private String e() {
        String str = "";
        for (String str2 : this.w) {
            if (str2.length() >= str.length()) {
                str = str2;
            }
        }
        return str;
    }

    private void f() {
        GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(getContext(), this);
        this.z = gestureDetectorCompat;
        gestureDetectorCompat.setIsLongpressEnabled(true);
        this.f12117f = us.pinguo.foundation.t.b.b.a(getContext(), 18);
        this.f12121j = us.pinguo.foundation.t.b.b.a(getContext(), 8);
        this.f12122k = us.pinguo.foundation.t.b.b.a(getContext(), 10);
        this.f12123l = us.pinguo.foundation.t.b.b.a(getContext(), 20);
        this.m = us.pinguo.foundation.t.b.b.a(getContext(), 20);
        this.n = us.pinguo.foundation.t.b.b.a(getContext(), 10);
        this.o = us.pinguo.foundation.t.b.b.a(getContext(), 35);
        Paint paint = new Paint();
        this.b = paint;
        paint.setColor(this.f12115d);
        this.b.setAntiAlias(true);
        this.b.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.c = paint2;
        paint2.setColor(this.f12116e);
        this.c.setAntiAlias(true);
        this.I = us.pinguo.foundation.t.b.b.a(getContext(), 18);
        us.pinguo.foundation.t.b.b.a(getContext(), 20);
        this.c.setTextSize(this.I);
        this.w = new ArrayList(Arrays.asList("1", "2", "3", Constants.VIA_TO_TYPE_QZONE, "5", Constants.VIA_SHARE_TYPE_INFO));
        OverScroller overScroller = new OverScroller(getContext());
        this.A = overScroller;
        overScroller.setFriction(0.08f);
        float f2 = getResources().getDisplayMetrics().density;
        L = (int) ((50.0f * f2) + 0.5d);
        M = (int) ((f2 * 200.0f) + 0.5d);
    }

    private void g(AttributeSet attributeSet, int i2) {
        String string = getContext().obtainStyledAttributes(attributeSet, R.styleable.DragSwitchView, i2, 0).getString(R.styleable.DragSwitchView_name);
        if (TextUtils.isEmpty(string)) {
            this.a = "";
        } else {
            this.a = string;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.A.computeScrollOffset()) {
            this.t = this.A.getCurrY();
            invalidate();
        } else if (this.B) {
            this.B = false;
            a();
        } else if (this.C) {
        } else {
            d();
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        a aVar = this.K;
        if (aVar != null) {
            aVar.d();
        }
        if (!this.A.isFinished()) {
            this.A.forceFinished(true);
        }
        this.B = false;
        this.C = true;
        this.G = true;
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.y.clear();
        RectF rectF = new RectF(this.p);
        int i2 = this.f12117f;
        canvas.drawRoundRect(rectF, i2, i2, this.b);
        String str = this.a;
        Point point = this.q;
        canvas.drawText(str, point.x, point.y, this.c);
        Point point2 = this.r;
        int i3 = point2.y + this.t;
        int i4 = point2.x;
        for (int i5 = 0; i5 < this.w.size(); i5++) {
            Rect rect = new Rect(i4, i3 - this.s.height(), this.s.width() + i4, i3);
            this.y.put(i5, Integer.valueOf((rect.top + rect.bottom) / 2));
            if (this.p.contains(rect)) {
                this.c.setAlpha(255);
                canvas.drawText(this.w.get(i5), i4, i3, this.c);
            } else if (!this.p.contains(rect.left, rect.top) && !this.p.contains(rect.left, rect.bottom)) {
                this.c.setAlpha(100);
                this.c.setAlpha(100);
                canvas.drawText(this.w.get(i5), i4, i3, this.c);
            } else {
                this.c.setAlpha(100);
                canvas.drawText(this.w.get(i5), i4, i3, this.c);
            }
            i3 += this.s.height() + this.o;
        }
        this.c.setAlpha(255);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        us.pinguo.common.log.a.c("onFling", new Object[0]);
        float x = motionEvent2.getX() - motionEvent.getX();
        if (!this.D && Math.abs(x) > L && Math.abs(f2) > M) {
            int i2 = (x > 0.0f ? 1 : (x == 0.0f ? 0 : -1));
            if (i2 > 0) {
                this.K.e(true);
            } else {
                this.K.e(false);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("fling left:");
            sb.append(i2 > 0 ? "true" : "false");
            us.pinguo.common.log.a.c(sb.toString(), new Object[0]);
            return true;
        }
        this.B = true;
        this.A.fling(0, this.t, 0, (int) f3, 0, 0, this.v, this.u, 0, this.s.height());
        invalidate();
        this.K.c();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        a aVar = this.K;
        if (aVar != null) {
            this.F = true;
            aVar.b(true);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        a aVar;
        if ((this.D || Math.abs(motionEvent2.getY() - motionEvent.getY()) >= L) && this.C) {
            us.pinguo.common.log.a.c("onScroll,distanceY:" + f3, new Object[0]);
            if (this.G && (aVar = this.K) != null) {
                this.G = false;
                aVar.c();
            }
            int i2 = (int) (this.t - (f3 * 0.6d));
            this.t = i2;
            int i3 = this.u;
            int i4 = this.H;
            if (i2 > i3 + i4) {
                this.t = i3 + i4;
            }
            int i5 = this.t;
            int i6 = this.v;
            if (i5 < i6 - i4) {
                this.t = i6 - i4;
            }
            invalidate();
            this.D = true;
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f12119h = i2 / 2;
        this.f12120i = i3 / 5;
        String str = this.a + e();
        Rect rect = new Rect();
        this.c.getTextBounds(str, 0, str.length(), rect);
        this.s = new Rect();
        String e2 = e();
        this.c.getTextBounds(e2, 0, e2.length(), this.s);
        int width = this.f12123l + this.m + rect.width() + this.n;
        int i6 = this.f12119h;
        int i7 = width / 2;
        int i8 = this.f12120i;
        this.p = new Rect(i6 - i7, i8, (i6 - i7) + width, this.f12121j + this.f12122k + rect.height() + i8);
        Rect rect2 = this.p;
        this.q = new Point(rect2.left + this.f12123l, rect2.bottom - this.f12122k);
        this.r = new Point((this.p.right - this.m) - this.s.width(), this.q.y);
        this.u = 0;
        this.v = (-(this.o + this.s.height())) * (this.w.size() - 1);
        Point point = this.r;
        this.x = new Rect(point.x, point.y - this.s.height(), this.r.x + this.s.width(), this.r.y);
        this.H = this.o / 2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f12118g) {
            return false;
        }
        boolean onTouchEvent = this.z.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            us.pinguo.common.log.a.c("Action_up", new Object[0]);
            this.C = false;
            this.D = false;
            if (this.F) {
                a aVar = this.K;
                if (aVar != null) {
                    this.F = false;
                    aVar.b(false);
                }
            } else {
                a();
                a aVar2 = this.K;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
        }
        return onTouchEvent;
    }

    public void setCurrentIndex(int i2) {
        us.pinguo.common.log.a.c("setCurrentIndex:" + i2, new Object[0]);
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > this.w.size() - 1) {
            i2 = this.w.size() - 1;
        }
        this.E = i2;
        Rect rect = new Rect();
        String e2 = e();
        this.c.getTextBounds(e2, 0, e2.length(), rect);
        this.t = (-i2) * (rect.height() + this.o);
    }

    public void setGestureListener(a aVar) {
        this.K = aVar;
    }

    public void setItemChangeListener(b bVar) {
        this.J = bVar;
    }

    public void setItemList(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.w = list;
        requestLayout();
    }

    public DragSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12115d = 1728019059;
        this.f12116e = -1;
        this.f12118g = false;
        this.t = 0;
        this.y = new SparseArray<>();
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = false;
        this.G = true;
        this.H = 0;
        this.J = null;
        this.K = null;
        g(attributeSet, 0);
        f();
    }

    public DragSwitchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12115d = 1728019059;
        this.f12116e = -1;
        this.f12118g = false;
        this.t = 0;
        this.y = new SparseArray<>();
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = false;
        this.G = true;
        this.H = 0;
        this.J = null;
        this.K = null;
        g(attributeSet, i2);
        f();
    }
}
