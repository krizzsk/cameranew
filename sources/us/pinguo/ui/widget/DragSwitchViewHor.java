package us.pinguo.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import androidx.core.view.GestureDetectorCompat;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
public class DragSwitchViewHor extends View implements GestureDetector.OnGestureListener {
    private Paint a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12124d;

    /* renamed from: e  reason: collision with root package name */
    private GestureDetectorCompat f12125e;

    /* renamed from: f  reason: collision with root package name */
    private OverScroller f12126f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12127g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12128h;

    /* renamed from: i  reason: collision with root package name */
    private int f12129i;

    /* renamed from: j  reason: collision with root package name */
    private int f12130j;

    /* renamed from: k  reason: collision with root package name */
    private int f12131k;

    /* renamed from: l  reason: collision with root package name */
    private int f12132l;
    private b m;
    private String[] n;
    private List<c> o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;

    /* loaded from: classes6.dex */
    class a implements View.OnLayoutChangeListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            DragSwitchViewHor.this.removeOnLayoutChangeListener(this);
            DragSwitchViewHor.this.q = DragSwitchViewHor.this.g(this.a);
            DragSwitchViewHor.this.invalidate();
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(int i2);
    }

    /* loaded from: classes6.dex */
    public static class c {
        Point a = new Point();
        Rect b = new Rect();
        String c;

        /* renamed from: d  reason: collision with root package name */
        int f12133d;
    }

    public DragSwitchViewHor(Context context) {
        super(context);
        this.f12124d = false;
        this.f12127g = false;
        this.f12128h = false;
        this.m = null;
        this.n = new String[]{"a", "b", "c"};
        this.o = new ArrayList();
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = -1;
        this.u = false;
        this.v = false;
        j();
    }

    private void c() {
        if (this.f12127g || this.v) {
            return;
        }
        int g2 = g(e());
        OverScroller overScroller = this.f12126f;
        int i2 = this.q;
        overScroller.startScroll(i2, 0, g2 - i2, 0, 500);
        invalidate();
        us.pinguo.common.log.a.c("autoSettle scroll,mScrollX:" + this.q + ",scrollX:" + g2, new Object[0]);
    }

    private int d(int i2, int i3) {
        int abs = 255 - (Math.abs(i2 - i3) * 80);
        if (abs < 50) {
            return 50;
        }
        return abs;
    }

    private int e() {
        int abs;
        int i2 = this.p;
        int i3 = this.q;
        int i4 = 0;
        for (int i5 = 0; i5 < this.o.size(); i5++) {
            c cVar = this.o.get(i5);
            int i6 = cVar.a.x - i3;
            if (i6 <= this.p && cVar.b.width() + i6 >= this.p) {
                return i5;
            }
            int width = cVar.b.width() + i6;
            int i7 = this.p;
            if (width <= i7) {
                abs = Math.abs(i7 - (i6 + cVar.b.width()));
            } else {
                abs = Math.abs(i7 - i6);
            }
            if (i2 > abs) {
                i4 = i5;
                i2 = abs;
            }
        }
        us.pinguo.common.log.a.c("currentIndex is:" + i4 + ",scrollX:" + i3 + ",mscrollX:" + this.q, new Object[0]);
        return i4;
    }

    private int f(int i2) {
        for (int i3 = 0; i3 < this.o.size(); i3++) {
            c cVar = this.o.get(i3);
            int i4 = cVar.a.x - this.q;
            int i5 = this.f12132l;
            int width = cVar.b.width() + i4 + (i5 / 2);
            if (i2 >= i4 - (i5 / 2) && i2 <= width) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(int i2) {
        int width;
        if (i2 == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 <= i2; i4++) {
            if (i4 == 0) {
                i3 = this.o.get(i4).b.width() / 2;
            } else {
                if (i4 == i2) {
                    i3 += this.o.get(i4).b.width() / 2;
                    width = this.f12132l;
                } else {
                    width = this.o.get(i4).b.width() + this.f12132l;
                }
                i3 += width;
            }
        }
        us.pinguo.common.log.a.c("calculateScrollXByIndex,currentIndex:" + i2 + ",scrollX:" + i3, new Object[0]);
        return i3;
    }

    private void h() {
        int e2;
        if (this.m == null || (e2 = e()) < 0 || e2 > this.o.size() - 1 || this.t == e2) {
            return;
        }
        us.pinguo.common.log.a.c("call onItemChange,the selected item is:" + e2, new Object[0]);
        this.t = e2;
        this.m.a(e2);
    }

    private int i() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.n.length; i3++) {
            Rect rect = new Rect();
            Paint paint = this.a;
            String[] strArr = this.n;
            paint.getTextBounds(strArr[i3], 0, strArr[i3].length(), rect);
            if (rect.height() > i2) {
                i2 = rect.height();
            }
        }
        return i2;
    }

    private void j() {
        GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(getContext(), this);
        this.f12125e = gestureDetectorCompat;
        gestureDetectorCompat.setIsLongpressEnabled(true);
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(this.c);
        this.a.setAntiAlias(true);
        this.a.setTextSize(this.f12129i);
        this.a.setTextAlign(Paint.Align.LEFT);
        OverScroller overScroller = new OverScroller(getContext());
        this.f12126f = overScroller;
        overScroller.setFriction(0.08f);
        float f2 = getResources().getDisplayMetrics().density;
    }

    private void k(AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorDragSwitchView, i2, 0);
        this.b = obtainStyledAttributes.getColor(R.styleable.HorDragSwitchView_hor_selected_color, -1);
        this.c = obtainStyledAttributes.getColor(R.styleable.HorDragSwitchView_hor_normal_color, -12303292);
        this.f12129i = (int) obtainStyledAttributes.getDimension(R.styleable.HorDragSwitchView_hor_text_size, getResources().getDisplayMetrics().density * 15.0f);
        this.f12130j = (int) obtainStyledAttributes.getDimension(R.styleable.HorDragSwitchView_hor_padding_top, getResources().getDisplayMetrics().density * 10.0f);
        this.f12131k = (int) obtainStyledAttributes.getDimension(R.styleable.HorDragSwitchView_hor_padding_bottom, getResources().getDisplayMetrics().density * 10.0f);
        this.f12132l = (int) obtainStyledAttributes.getDimension(R.styleable.HorDragSwitchView_hor_item_space, getResources().getDisplayMetrics().density * 40.0f);
        this.s = (int) obtainStyledAttributes.getDimension(R.styleable.HorDragSwitchView_hor_max_over_scroll, getResources().getDisplayMetrics().density * 20.0f);
        this.u = obtainStyledAttributes.getBoolean(R.styleable.HorDragSwitchView_hor_clickable, false);
        TypedArray obtainTypedArray = getResources().obtainTypedArray(obtainStyledAttributes.getResourceId(R.styleable.HorDragSwitchView_hor_items, 0));
        if (obtainTypedArray != null) {
            this.n = new String[obtainTypedArray.length()];
            for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                this.n[i3] = getResources().getString(obtainTypedArray.getResourceId(i3, 0));
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f12126f.computeScrollOffset()) {
            this.q = this.f12126f.getCurrX();
            invalidate();
        } else if (this.f12127g) {
            this.f12127g = false;
            c();
        } else {
            if (this.v) {
                this.v = false;
            }
            if (this.f12128h) {
                return;
            }
            h();
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (!this.f12126f.isFinished()) {
            this.f12126f.forceFinished(true);
        }
        this.f12127g = false;
        this.f12128h = true;
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int e2 = e();
        canvas.save();
        canvas.translate(-this.q, 0.0f);
        for (c cVar : this.o) {
            if (cVar.f12133d == e2) {
                this.a.setColor(this.b);
            } else {
                this.a.setColor(this.c);
            }
            this.a.setAlpha(d(e2, cVar.f12133d));
            String str = cVar.c;
            Point point = cVar.a;
            canvas.drawText(str, point.x, point.y, this.a);
        }
        canvas.restore();
        this.a.setAlpha(255);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        us.pinguo.common.log.a.c("onFling", new Object[0]);
        this.f12127g = true;
        this.f12126f.fling(this.q, 0, (int) (-f2), 0, 0, this.r, 0, 0, this.s, 0);
        invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(this.f12131k + this.f12130j + i(), 1073741824));
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        us.pinguo.common.log.a.c("onScroll,distanceX:" + f2, new Object[0]);
        int i2 = (int) (((float) this.q) + f2);
        this.q = i2;
        int i3 = this.r;
        int i4 = this.s;
        if (i2 > i3 + i4) {
            this.q = i3 + i4;
        } else if (i2 < (-i4)) {
            this.q = -i4;
        }
        invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int f2;
        if (!this.u || (f2 = f((int) motionEvent.getX())) == -1 || f2 >= this.o.size()) {
            return false;
        }
        int g2 = g(f2);
        this.v = true;
        OverScroller overScroller = this.f12126f;
        int i2 = this.q;
        overScroller.startScroll(i2, 0, g2 - i2, 0, 500);
        us.pinguo.common.log.a.c("onSingleTapUp scroll,mScrollX:" + this.q + ",scrollX:" + g2 + ",click index:" + f2, new Object[0]);
        invalidate();
        return true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        List<c> list;
        super.onSizeChanged(i2, i3, i4, i5);
        this.o.clear();
        this.p = i2 / 2;
        int i6 = i();
        Rect rect = new Rect();
        Paint paint = this.a;
        String[] strArr = this.n;
        paint.getTextBounds(strArr[0], 0, strArr[0].length(), rect);
        int width = this.p - (rect.width() / 2);
        int i7 = 0;
        while (true) {
            String[] strArr2 = this.n;
            if (i7 < strArr2.length) {
                String str = strArr2[i7];
                c cVar = new c();
                this.o.add(cVar);
                cVar.f12133d = i7;
                cVar.c = str;
                this.a.getTextBounds(str, 0, str.length(), cVar.b);
                Point point = cVar.a;
                point.y = this.f12130j + i6;
                int i8 = i7 - 1;
                if (i8 < 0) {
                    point.x = width;
                } else {
                    c cVar2 = this.o.get(i8);
                    cVar.a.x = cVar2.a.x + cVar2.b.width() + this.f12132l;
                }
                i7++;
            } else {
                c cVar3 = this.o.get(list.size() - 1);
                this.r = (cVar3.a.x - this.p) + (cVar3.b.width() / 2);
                return;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f12124d) {
            return false;
        }
        boolean onTouchEvent = this.f12125e.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            us.pinguo.common.log.a.c("Action_up", new Object[0]);
            this.f12128h = false;
            c();
        }
        return onTouchEvent;
    }

    public void setCurrentIndex(int i2) {
        if (i2 >= 0 || i2 < this.n.length) {
            addOnLayoutChangeListener(new a(i2));
            requestLayout();
        }
    }

    public void setItemChangeListener(b bVar) {
        this.m = bVar;
    }

    public void setItemStringArray(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            this.n = strArr;
        }
        requestLayout();
    }

    public DragSwitchViewHor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12124d = false;
        this.f12127g = false;
        this.f12128h = false;
        this.m = null;
        this.n = new String[]{"a", "b", "c"};
        this.o = new ArrayList();
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = -1;
        this.u = false;
        this.v = false;
        k(attributeSet, 0);
        j();
    }

    public DragSwitchViewHor(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12124d = false;
        this.f12127g = false;
        this.f12128h = false;
        this.m = null;
        this.n = new String[]{"a", "b", "c"};
        this.o = new ArrayList();
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = -1;
        this.u = false;
        this.v = false;
        k(attributeSet, i2);
        j();
    }
}
