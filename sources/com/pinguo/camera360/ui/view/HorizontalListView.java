package com.pinguo.camera360.ui.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.core.view.ViewCompat;
import androidx.core.widget.EdgeEffectCompat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    private boolean A;
    private boolean B;
    private View.OnClickListener C;
    private DataSetObserver D;
    private Runnable E;
    protected Scroller a;
    private final d b;
    private GestureDetector c;

    /* renamed from: d  reason: collision with root package name */
    private int f7038d;

    /* renamed from: e  reason: collision with root package name */
    protected ListAdapter f7039e;

    /* renamed from: f  reason: collision with root package name */
    private List<Queue<View>> f7040f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7041g;

    /* renamed from: h  reason: collision with root package name */
    private Rect f7042h;

    /* renamed from: i  reason: collision with root package name */
    private View f7043i;

    /* renamed from: j  reason: collision with root package name */
    private int f7044j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f7045k;

    /* renamed from: l  reason: collision with root package name */
    protected int f7046l;
    protected int m;
    private Integer n;
    private int o;
    private int p;
    private int q;
    private int r;
    private g s;
    private int t;
    private boolean u;
    private OnScrollStateChangedListener v;
    private OnScrollStateChangedListener.ScrollState w;
    private EdgeEffectCompat x;
    private EdgeEffectCompat y;
    private int z;

    /* loaded from: classes3.dex */
    public interface OnScrollStateChangedListener {

        /* loaded from: classes3.dex */
        public enum ScrollState {
            SCROLL_STATE_IDLE,
            SCROLL_STATE_TOUCH_SCROLL,
            SCROLL_STATE_FLING
        }

        void a(ScrollState scrollState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return HorizontalListView.this.c.onTouchEvent(motionEvent);
        }
    }

    /* loaded from: classes3.dex */
    class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            HorizontalListView.this.f7041g = true;
            HorizontalListView.this.u = false;
            HorizontalListView.this.X();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            HorizontalListView.this.u = false;
            HorizontalListView.this.X();
            HorizontalListView.this.T();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HorizontalListView.this.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    private class d extends GestureDetector.SimpleOnGestureListener {
        private d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return HorizontalListView.this.M(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return HorizontalListView.this.N(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            HorizontalListView.this.X();
            int z = HorizontalListView.this.z((int) motionEvent.getX(), (int) motionEvent.getY());
            if (z < 0 || HorizontalListView.this.A) {
                return;
            }
            View childAt = HorizontalListView.this.getChildAt(z);
            AdapterView.OnItemLongClickListener onItemLongClickListener = HorizontalListView.this.getOnItemLongClickListener();
            if (onItemLongClickListener != null) {
                int i2 = HorizontalListView.this.p + z;
                HorizontalListView horizontalListView = HorizontalListView.this;
                if (onItemLongClickListener.onItemLongClick(horizontalListView, childAt, i2, horizontalListView.f7039e.getItemId(i2))) {
                    HorizontalListView.this.performHapticFeedback(0);
                }
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            HorizontalListView.this.S(Boolean.TRUE);
            HorizontalListView.this.W(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_TOUCH_SCROLL);
            HorizontalListView.this.X();
            HorizontalListView horizontalListView = HorizontalListView.this;
            horizontalListView.m += (int) f2;
            horizontalListView.Y(Math.round(f2));
            HorizontalListView.this.requestLayout();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            HorizontalListView.this.X();
            AdapterView.OnItemClickListener onItemClickListener = HorizontalListView.this.getOnItemClickListener();
            int z = HorizontalListView.this.z((int) motionEvent.getX(), (int) motionEvent.getY());
            if (z >= 0 && !HorizontalListView.this.A) {
                View childAt = HorizontalListView.this.getChildAt(z);
                int i2 = HorizontalListView.this.p + z;
                if (onItemClickListener != null) {
                    HorizontalListView horizontalListView = HorizontalListView.this;
                    onItemClickListener.onItemClick(horizontalListView, childAt, i2, horizontalListView.f7039e.getItemId(i2));
                    return true;
                }
            }
            if (HorizontalListView.this.C == null || HorizontalListView.this.A) {
                return false;
            }
            HorizontalListView.this.C.onClick(HorizontalListView.this);
            return false;
        }

        /* synthetic */ d(HorizontalListView horizontalListView, a aVar) {
            this();
        }
    }

    @TargetApi(11)
    /* loaded from: classes3.dex */
    private static final class e {
        static {
            if (Build.VERSION.SDK_INT < 11) {
                throw new RuntimeException("Should not get to HoneycombPlus class unless sdk is >= 11!");
            }
        }

        public static void a(Scroller scroller, float f2) {
            if (scroller != null) {
                scroller.setFriction(f2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(14)
    /* loaded from: classes3.dex */
    public static final class f {
        static {
            if (Build.VERSION.SDK_INT < 14) {
                throw new RuntimeException("Should not get to IceCreamSandwichPlus class unless sdk is >= 14!");
            }
        }

        public static float a(Scroller scroller) {
            return scroller.getCurrVelocity();
        }
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a();
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Scroller(getContext());
        d dVar = new d(this, null);
        this.b = dVar;
        this.f7040f = new ArrayList();
        this.f7041g = false;
        this.f7042h = new Rect();
        this.f7043i = null;
        this.f7044j = 0;
        this.f7045k = null;
        this.n = null;
        this.o = Integer.MAX_VALUE;
        this.s = null;
        this.t = 0;
        this.u = false;
        this.v = null;
        this.w = OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE;
        this.A = false;
        this.B = false;
        this.D = new b();
        this.E = new c();
        this.x = new EdgeEffectCompat(context);
        this.y = new EdgeEffectCompat(context);
        this.c = new GestureDetector(context, dVar);
        n();
        G();
        U(context, attributeSet);
        setWillNotDraw(false);
        if (Build.VERSION.SDK_INT >= 11) {
            e.a(this.a, 0.009f);
        }
    }

    private ViewGroup.LayoutParams A(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-2, -1) : layoutParams;
    }

    private View B() {
        return getChildAt(0);
    }

    private View C(int i2) {
        int itemViewType = this.f7039e.getItemViewType(i2);
        if (J(itemViewType)) {
            return this.f7040f.get(itemViewType).poll();
        }
        return null;
    }

    private int D() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int E() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private View F() {
        return getChildAt(getChildCount() - 1);
    }

    private void G() {
        this.p = -1;
        this.q = -1;
        this.f7038d = 0;
        this.f7046l = 0;
        this.m = 0;
        this.o = Integer.MAX_VALUE;
        W(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
    }

    private void H(int i2) {
        this.f7040f.clear();
        for (int i3 = 0; i3 < i2; i3++) {
            this.f7040f.add(new LinkedList());
        }
    }

    private boolean I() {
        ListAdapter listAdapter = this.f7039e;
        return (listAdapter == null || listAdapter.isEmpty() || this.o <= 0) ? false : true;
    }

    private boolean J(int i2) {
        return i2 < this.f7040f.size();
    }

    private boolean K(int i2) {
        return i2 == this.f7039e.getCount() - 1;
    }

    private void L(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams A = A(view);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.z, getPaddingTop() + getPaddingBottom(), A.height);
        int i2 = A.width;
        if (i2 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    private void O(int i2) {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i3 = this.f7038d + i2;
            this.f7038d = i3;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                int paddingLeft = getPaddingLeft() + i3;
                int paddingTop = getPaddingTop();
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                i3 += childAt.getMeasuredWidth() + this.f7044j;
            }
        }
    }

    private void P(int i2, View view) {
        int itemViewType = this.f7039e.getItemViewType(i2);
        if (J(itemViewType)) {
            this.f7040f.get(itemViewType).offer(view);
        }
    }

    private void Q() {
        EdgeEffectCompat edgeEffectCompat = this.x;
        if (edgeEffectCompat != null) {
            edgeEffectCompat.onRelease();
        }
        EdgeEffectCompat edgeEffectCompat2 = this.y;
        if (edgeEffectCompat2 != null) {
            edgeEffectCompat2.onRelease();
        }
    }

    private void R(int i2) {
        View B = B();
        while (B != null && B.getRight() + i2 <= 0) {
            this.f7038d += K(this.p) ? B.getMeasuredWidth() : this.f7044j + B.getMeasuredWidth();
            P(this.p, B);
            removeViewInLayout(B);
            this.p++;
            B = B();
        }
        View F = F();
        while (F != null && F.getLeft() + i2 >= getWidth()) {
            P(this.q, F);
            removeViewInLayout(F);
            this.q--;
            F = F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Boolean bool) {
        if (this.B != bool.booleanValue()) {
            for (View view = this; view.getParent() instanceof View; view = (View) view.getParent()) {
                view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
                this.B = bool.booleanValue();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        G();
        removeAllViewsInLayout();
        requestLayout();
    }

    private void U(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HorizontalListView);
            Drawable drawable = obtainStyledAttributes.getDrawable(1);
            if (drawable != null) {
                setDivider(drawable);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            if (dimensionPixelSize != 0) {
                setDividerWidth(dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(OnScrollStateChangedListener.ScrollState scrollState) {
        OnScrollStateChangedListener onScrollStateChangedListener;
        if (this.w != scrollState && (onScrollStateChangedListener = this.v) != null) {
            onScrollStateChangedListener.a(scrollState);
        }
        this.w = scrollState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        View view = this.f7043i;
        if (view != null) {
            view.setPressed(false);
            refreshDrawableState();
            this.f7043i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(int i2) {
        if (this.x == null || this.y == null) {
            return;
        }
        int i3 = this.f7046l + i2;
        Scroller scroller = this.a;
        if (scroller == null || scroller.isFinished()) {
            if (i3 < 0) {
                this.x.onPull(Math.abs(i2) / E());
                if (this.y.isFinished()) {
                    return;
                }
                this.y.onRelease();
            } else if (i3 > this.o) {
                this.y.onPull(Math.abs(i2) / E());
                if (this.x.isFinished()) {
                    return;
                }
                this.x.onRelease();
            }
        }
    }

    private void m(View view, int i2) {
        addViewInLayout(view, i2, A(view), true);
        L(view);
    }

    private void n() {
        setOnTouchListener(new a());
    }

    private float o() {
        if (Build.VERSION.SDK_INT >= 14) {
            return f.a(this.a);
        }
        return 30.0f;
    }

    private void p() {
        ListAdapter listAdapter;
        if (this.s == null || (listAdapter = this.f7039e) == null || listAdapter.getCount() - (this.q + 1) >= this.t || this.u) {
            return;
        }
        this.u = true;
        this.s.a();
    }

    private boolean q() {
        View F;
        if (K(this.q) && (F = F()) != null) {
            int i2 = this.o;
            int right = (this.f7046l + (F.getRight() - getPaddingLeft())) - E();
            this.o = right;
            if (right < 0) {
                this.o = 0;
            }
            if (this.o != i2) {
                return true;
            }
        }
        return false;
    }

    private void r(Canvas canvas, Rect rect) {
        Drawable drawable = this.f7045k;
        if (drawable != null) {
            drawable.setBounds(rect);
            this.f7045k.draw(canvas);
        }
    }

    private void s(Canvas canvas) {
        int childCount = getChildCount();
        Rect rect = this.f7042h;
        rect.top = getPaddingTop();
        Rect rect2 = this.f7042h;
        rect2.bottom = rect2.top + D();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (i2 != childCount - 1 || !K(this.q)) {
                View childAt = getChildAt(i2);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.f7044j;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                r(canvas, rect);
                if (i2 == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    r(canvas, rect);
                }
            }
        }
    }

    private void t(Canvas canvas) {
        EdgeEffectCompat edgeEffectCompat = this.x;
        if (edgeEffectCompat != null && !edgeEffectCompat.isFinished() && I()) {
            int save = canvas.save();
            int height = getHeight();
            canvas.rotate(-90.0f, 0.0f, 0.0f);
            canvas.translate((-height) + getPaddingBottom(), 0.0f);
            this.x.setSize(D(), E());
            if (this.x.draw(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(save);
            return;
        }
        EdgeEffectCompat edgeEffectCompat2 = this.y;
        if (edgeEffectCompat2 == null || edgeEffectCompat2.isFinished() || !I()) {
            return;
        }
        int save2 = canvas.save();
        int width = getWidth();
        canvas.rotate(90.0f, 0.0f, 0.0f);
        canvas.translate(getPaddingTop(), -width);
        this.y.setSize(D(), E());
        if (this.y.draw(canvas)) {
            invalidate();
        }
        canvas.restoreToCount(save2);
    }

    private void u(int i2) {
        View F = F();
        w(F != null ? F.getRight() : 0, i2);
        View B = B();
        v(B != null ? B.getLeft() : 0, i2);
    }

    private void v(int i2, int i3) {
        int i4;
        while ((i2 + i3) - this.f7044j > 0 && (i4 = this.p) >= 1) {
            int i5 = i4 - 1;
            this.p = i5;
            View view = this.f7039e.getView(i5, C(i5), this);
            m(view, 0);
            i2 -= this.p == 0 ? view.getMeasuredWidth() : this.f7044j + view.getMeasuredWidth();
            this.f7038d -= i2 + i3 == 0 ? view.getMeasuredWidth() : view.getMeasuredWidth() + this.f7044j;
        }
    }

    private void w(int i2, int i3) {
        while (i2 + i3 + this.f7044j < getWidth() && this.q + 1 < this.f7039e.getCount()) {
            int i4 = this.q + 1;
            this.q = i4;
            if (this.p < 0) {
                this.p = i4;
            }
            View view = this.f7039e.getView(i4, C(i4), this);
            m(view, -1);
            i2 += (this.q == 0 ? 0 : this.f7044j) + view.getMeasuredWidth();
            p();
        }
    }

    private View y(int i2) {
        int i3 = this.p;
        if (i2 < i3 || i2 > this.q) {
            return null;
        }
        return getChildAt(i2 - i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int z(int i2, int i3) {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            getChildAt(i4).getHitRect(this.f7042h);
            if (this.f7042h.contains(i2, i3)) {
                return i4;
            }
        }
        return -1;
    }

    protected boolean M(MotionEvent motionEvent) {
        int z;
        this.A = !this.a.isFinished();
        this.a.forceFinished(true);
        W(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
        X();
        if (!this.A && (z = z((int) motionEvent.getX(), (int) motionEvent.getY())) >= 0) {
            View childAt = getChildAt(z);
            this.f7043i = childAt;
            if (childAt != null) {
                childAt.setPressed(true);
                refreshDrawableState();
            }
        }
        return true;
    }

    protected boolean N(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.a.fling(this.m, 0, (int) (-f2), 0, 0, this.o, 0, 0);
        W(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING);
        requestLayout();
        return true;
    }

    public void V(int i2) {
        Scroller scroller = this.a;
        int i3 = this.m;
        scroller.startScroll(i3, 0, i2 - i3, 0);
        W(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        t(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // android.widget.AdapterView
    public int getFirstVisiblePosition() {
        return this.p;
    }

    @Override // android.widget.AdapterView
    public int getLastVisiblePosition() {
        return this.q;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i2 = this.f7046l;
        if (i2 == 0) {
            return 0.0f;
        }
        if (i2 < horizontalFadingEdgeLength) {
            return i2 / horizontalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i2 = this.f7046l;
        int i3 = this.o;
        if (i2 == i3) {
            return 0.0f;
        }
        if (i3 - i2 < horizontalFadingEdgeLength) {
            return (i3 - i2) / horizontalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return y(this.r);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        s(canvas);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    @SuppressLint({"WrongCall"})
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f7039e == null) {
            return;
        }
        invalidate();
        if (this.f7041g) {
            int i6 = this.f7046l;
            G();
            removeAllViewsInLayout();
            this.m = i6;
            this.f7041g = false;
        }
        Integer num = this.n;
        if (num != null) {
            this.m = num.intValue();
            this.n = null;
        }
        if (this.a.computeScrollOffset()) {
            this.m = this.a.getCurrX();
        }
        int i7 = this.m;
        if (i7 < 0) {
            this.m = 0;
            if (this.x.isFinished()) {
                this.x.onAbsorb((int) o());
            }
            this.a.forceFinished(true);
            W(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
        } else {
            int i8 = this.o;
            if (i7 > i8) {
                this.m = i8;
                if (this.y.isFinished()) {
                    this.y.onAbsorb((int) o());
                }
                this.a.forceFinished(true);
                W(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
            }
        }
        int i9 = this.f7046l - this.m;
        R(i9);
        u(i9);
        O(i9);
        this.f7046l = this.m;
        if (q()) {
            onLayout(z, i2, i3, i4, i5);
        } else if (this.a.isFinished()) {
            if (this.w == OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING) {
                W(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
            }
        } else {
            ViewCompat.postOnAnimation(this, this.E);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.z = i3;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.n = Integer.valueOf(bundle.getInt("BUNDLE_ID_CURRENT_X"));
            super.onRestoreInstanceState(bundle.getParcelable("BUNDLE_ID_PARENT_STATE"));
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
        bundle.putInt("BUNDLE_ID_CURRENT_X", this.f7046l);
        return bundle;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            Scroller scroller = this.a;
            if (scroller == null || scroller.isFinished()) {
                W(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
            }
            S(Boolean.FALSE);
            Q();
        } else if (motionEvent.getAction() == 3) {
            X();
            Q();
            S(Boolean.FALSE);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setDivider(Drawable drawable) {
        this.f7045k = drawable;
        if (drawable != null) {
            setDividerWidth(drawable.getIntrinsicWidth());
        } else {
            setDividerWidth(0);
        }
    }

    public void setDividerWidth(int i2) {
        this.f7044j = i2;
        requestLayout();
        invalidate();
    }

    @Override // android.widget.AdapterView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.C = onClickListener;
    }

    public void setOnScrollStateChangedListener(OnScrollStateChangedListener onScrollStateChangedListener) {
        this.v = onScrollStateChangedListener;
    }

    public void setRunningOutOfDataListener(g gVar, int i2) {
        this.s = gVar;
        this.t = i2;
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i2) {
        this.r = i2;
        int width = i2 * getWidth();
        int childCount = getChildCount() * getWidth();
        if (width <= 0) {
            width = 0;
        }
        if (width <= childCount) {
            childCount = width;
        }
        V(childCount);
    }

    @Override // android.widget.AdapterView
    /* renamed from: x */
    public ListAdapter getAdapter() {
        return this.f7039e;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.f7039e;
        if (listAdapter2 != null) {
            listAdapter2.unregisterDataSetObserver(this.D);
        }
        if (listAdapter != null) {
            this.u = false;
            this.f7039e = listAdapter;
            listAdapter.registerDataSetObserver(this.D);
        }
        H(this.f7039e.getViewTypeCount());
        T();
    }
}
