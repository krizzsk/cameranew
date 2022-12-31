package com.shizhefei.view.indicator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.core.view.ViewCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.shizhefei.view.indicator.a;
import com.shizhefei.view.indicator.slidebar.ScrollBar;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class FixedIndicatorView extends LinearLayout implements com.shizhefei.view.indicator.a {
    private a.b a;
    private a.c b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f7126d;

    /* renamed from: e  reason: collision with root package name */
    private int f7127e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7128f;

    /* renamed from: g  reason: collision with root package name */
    private int f7129g;

    /* renamed from: h  reason: collision with root package name */
    private List<ViewGroup> f7130h;

    /* renamed from: i  reason: collision with root package name */
    private a.InterfaceC0251a f7131i;

    /* renamed from: j  reason: collision with root package name */
    private View.OnClickListener f7132j;

    /* renamed from: k  reason: collision with root package name */
    private ScrollBar f7133k;

    /* renamed from: l  reason: collision with root package name */
    private d f7134l;
    private Bitmap m;
    private Matrix n;
    private Canvas o;
    private int[] p;
    private int q;
    private int r;
    private float s;
    private a.d t;
    private View u;
    private LinearLayout.LayoutParams v;

    /* loaded from: classes3.dex */
    class a implements a.InterfaceC0251a {
        a() {
        }

        @Override // com.shizhefei.view.indicator.a.InterfaceC0251a
        public void onChange() {
            View b;
            if (!FixedIndicatorView.this.f7134l.c()) {
                FixedIndicatorView.this.f7134l.e();
            }
            int y = FixedIndicatorView.this.y();
            int a = FixedIndicatorView.this.a.a();
            FixedIndicatorView.this.f7130h.clear();
            for (int i2 = 0; i2 < y && i2 < a; i2++) {
                FixedIndicatorView.this.f7130h.add((ViewGroup) FixedIndicatorView.this.u(i2));
            }
            FixedIndicatorView.this.removeAllViews();
            int size = FixedIndicatorView.this.f7130h.size();
            int i3 = 0;
            while (i3 < a) {
                LinearLayout linearLayout = new LinearLayout(FixedIndicatorView.this.getContext());
                if (i3 < size) {
                    View childAt = ((ViewGroup) FixedIndicatorView.this.f7130h.get(i3)).getChildAt(0);
                    ((ViewGroup) FixedIndicatorView.this.f7130h.get(i3)).removeView(childAt);
                    b = FixedIndicatorView.this.a.b(i3, childAt, linearLayout);
                } else {
                    b = FixedIndicatorView.this.a.b(i3, null, linearLayout);
                }
                if (FixedIndicatorView.this.t != null) {
                    FixedIndicatorView.this.t.onTransition(b, i3, i3 == FixedIndicatorView.this.c ? 1.0f : 0.0f);
                }
                linearLayout.addView(b);
                linearLayout.setOnClickListener(FixedIndicatorView.this.f7132j);
                linearLayout.setTag(Integer.valueOf(i3));
                FixedIndicatorView.this.addView(linearLayout, new LinearLayout.LayoutParams(-2, -1));
                i3++;
            }
            if (FixedIndicatorView.this.u != null) {
                FixedIndicatorView fixedIndicatorView = FixedIndicatorView.this;
                fixedIndicatorView.setCenterView(fixedIndicatorView.u, FixedIndicatorView.this.v);
            }
            FixedIndicatorView.this.f7129g = -1;
            FixedIndicatorView fixedIndicatorView2 = FixedIndicatorView.this;
            fixedIndicatorView2.setCurrentItem(fixedIndicatorView2.c, false);
            FixedIndicatorView.this.B();
        }
    }

    /* loaded from: classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (FixedIndicatorView.this.f7128f) {
                int intValue = ((Integer) view.getTag()).intValue();
                ViewGroup viewGroup = (ViewGroup) view;
                FixedIndicatorView.this.setCurrentItem(intValue);
                if (FixedIndicatorView.this.b != null) {
                    FixedIndicatorView.this.b.a(viewGroup.getChildAt(0), intValue, FixedIndicatorView.this.f7129g);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ScrollBar.Gravity.values().length];
            a = iArr;
            try {
                iArr[ScrollBar.Gravity.BOTTOM_FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ScrollBar.Gravity.TOP_FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ScrollBar.Gravity.CENTENT_BACKGROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ScrollBar.Gravity.CENTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ScrollBar.Gravity.TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ScrollBar.Gravity.BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private int a = 20;
        private Scroller b;
        private final Interpolator c;

        /* loaded from: classes3.dex */
        class a implements Interpolator {
            a(d dVar) {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        }

        public d() {
            a aVar = new a(this);
            this.c = aVar;
            this.b = new Scroller(FixedIndicatorView.this.getContext(), aVar);
        }

        public boolean a() {
            return this.b.computeScrollOffset();
        }

        public int b() {
            return this.b.getCurrX();
        }

        public boolean c() {
            return this.b.isFinished();
        }

        public void d(int i2, int i3, int i4) {
            this.b.startScroll(i2, 0, i3 - i2, 0, i4);
            ViewCompat.postInvalidateOnAnimation(FixedIndicatorView.this);
            FixedIndicatorView.this.post(this);
        }

        public void e() {
            if (this.b.isFinished()) {
                this.b.abortAnimation();
            }
            FixedIndicatorView.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewCompat.postInvalidateOnAnimation(FixedIndicatorView.this);
            if (this.b.isFinished()) {
                return;
            }
            FixedIndicatorView.this.postDelayed(this, this.a);
        }
    }

    public FixedIndicatorView(Context context) {
        super(context);
        this.c = -1;
        this.f7126d = 0;
        this.f7127e = 0;
        this.f7128f = true;
        this.f7129g = -1;
        this.f7130h = new LinkedList();
        this.f7131i = new a();
        this.f7132j = new b();
        this.n = new Matrix();
        this.o = new Canvas();
        this.p = new int[]{-1, -1};
        z();
    }

    private int A(int i2, float f2, boolean z) {
        View u;
        ScrollBar scrollBar = this.f7133k;
        if (scrollBar == null) {
            return 0;
        }
        View a2 = scrollBar.a();
        if (a2.isLayoutRequested() || z) {
            View u2 = u(i2);
            int i3 = i2 + 1;
            if (i3 < this.a.a()) {
                u = u(i3);
            } else {
                u = u(0);
            }
            if (u2 != null) {
                int width = (int) ((u2.getWidth() * (1.0f - f2)) + (u == null ? 0.0f : u.getWidth() * f2));
                int d2 = this.f7133k.d(width);
                int b2 = this.f7133k.b(getHeight());
                a2.measure(d2, b2);
                a2.layout(0, 0, d2, b2);
                return width;
            }
        }
        return this.f7133k.a().getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        int y = y();
        int i2 = this.f7126d;
        int i3 = 0;
        if (i2 == 0) {
            for (int i4 = 0; i4 < y; i4++) {
                View u = u(i4);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) u.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                u.setLayoutParams(layoutParams);
            }
        } else if (i2 == 1) {
            while (i3 < y) {
                View u2 = u(i3);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) u2.getLayoutParams();
                layoutParams2.width = -2;
                layoutParams2.weight = 1.0f;
                u2.setLayoutParams(layoutParams2);
                i3++;
            }
        } else if (i2 == 2) {
            while (i3 < y) {
                View u3 = u(i3);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) u3.getLayoutParams();
                layoutParams3.width = -2;
                layoutParams3.weight = 0.0f;
                u3.setLayoutParams(layoutParams3);
                i3++;
            }
        }
    }

    private void C(int i2, float f2, int i3) {
        int[] iArr;
        View v;
        if (i2 < 0 || i2 > r() - 1) {
            return;
        }
        ScrollBar scrollBar = this.f7133k;
        if (scrollBar != null) {
            scrollBar.onPageScrolled(i2, f2, i3);
        }
        if (this.t != null) {
            for (int i4 : this.p) {
                if (i4 != i2 && i4 != i2 + 1 && (v = v(i4)) != null) {
                    this.t.onTransition(v, i4, 0.0f);
                }
            }
            int[] iArr2 = this.p;
            iArr2[0] = i2;
            int i5 = i2 + 1;
            iArr2[1] = i5;
            View v2 = v(this.f7129g);
            if (v2 != null) {
                this.t.onTransition(v2, this.f7129g, 0.0f);
            }
            View v3 = v(i2);
            if (v3 != null) {
                this.t.onTransition(v3, i2, 1.0f - f2);
            }
            View v4 = v(i5);
            if (v4 != null) {
                this.t.onTransition(v4, i5, f2);
            }
        }
    }

    private void E(int i2) {
        a.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        int a2 = bVar.a();
        int i3 = 0;
        while (i3 < a2) {
            View w = w(i3);
            if (w != null) {
                w.setSelected(i2 == i3);
            }
            i3++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void q(android.graphics.Canvas r15) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shizhefei.view.indicator.FixedIndicatorView.q(android.graphics.Canvas):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View u(int i2) {
        if (this.u != null && i2 >= (getChildCount() - 1) / 2) {
            i2++;
        }
        return getChildAt(i2);
    }

    private View w(int i2) {
        return ((ViewGroup) u(i2)).getChildAt(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int y() {
        if (this.u != null) {
            return getChildCount() - 1;
        }
        return getChildCount();
    }

    private void z() {
        this.f7134l = new d();
    }

    public void D() {
        View view = this.u;
        if (view != null) {
            removeView(view);
            this.u = null;
        }
        this.v = null;
    }

    @Override // com.shizhefei.view.indicator.a
    public int a() {
        return this.f7129g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        ScrollBar scrollBar = this.f7133k;
        if (scrollBar != null && scrollBar.c() == ScrollBar.Gravity.CENTENT_BACKGROUND) {
            q(canvas);
        }
        super.dispatchDraw(canvas);
        ScrollBar scrollBar2 = this.f7133k;
        if (scrollBar2 == null || scrollBar2.c() == ScrollBar.Gravity.CENTENT_BACKGROUND) {
            return;
        }
        q(canvas);
    }

    @Override // android.view.ViewGroup
    protected void measureChildren(int i2, int i3) {
        super.measureChildren(i2, i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7134l.e();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            this.u = childAt;
            this.v = (LinearLayout.LayoutParams) childAt.getLayoutParams();
        }
    }

    @Override // com.shizhefei.view.indicator.a
    public void onPageScrollStateChanged(int i2) {
        this.f7127e = i2;
        if (i2 == 0) {
            E(this.c);
        }
    }

    @Override // com.shizhefei.view.indicator.a
    public void onPageScrolled(int i2, float f2, int i3) {
        this.q = i2;
        this.s = f2;
        this.r = i3;
        if (this.f7133k != null) {
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            C(i2, f2, i3);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        A(this.c, 1.0f, true);
    }

    public int r() {
        a.b bVar = this.a;
        if (bVar == null) {
            return 0;
        }
        return bVar.a();
    }

    public int s() {
        return this.c;
    }

    @Override // com.shizhefei.view.indicator.a
    public void setAdapter(a.b bVar) {
        a.b bVar2 = this.a;
        if (bVar2 != null) {
            bVar2.g(this.f7131i);
        }
        this.a = bVar;
        bVar.e(this.f7131i);
        bVar.d();
    }

    public void setCenterView(View view, int i2, int i3) {
        this.u = view;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i3);
        layoutParams.gravity = 16;
        setCenterView(view, layoutParams);
    }

    public void setCurrentItem(int i2) {
        setCurrentItem(i2, true);
    }

    @Override // com.shizhefei.view.indicator.a
    public void setItemClickable(boolean z) {
        this.f7128f = z;
    }

    @Override // com.shizhefei.view.indicator.a
    public void setOnItemSelectListener(a.c cVar) {
        this.b = cVar;
    }

    @Override // com.shizhefei.view.indicator.a
    public void setOnTransitionListener(a.d dVar) {
        this.t = dVar;
        E(this.c);
        if (this.a != null) {
            int i2 = 0;
            while (i2 < this.a.a()) {
                View v = v(i2);
                if (v != null) {
                    dVar.onTransition(v, i2, this.c == i2 ? 1.0f : 0.0f);
                }
                i2++;
            }
        }
    }

    @Override // com.shizhefei.view.indicator.a
    public void setScrollBar(ScrollBar scrollBar) {
        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        ScrollBar scrollBar2 = this.f7133k;
        if (scrollBar2 != null) {
            int i2 = c.a[scrollBar2.c().ordinal()];
            if (i2 == 1) {
                paddingBottom -= scrollBar.b(getHeight());
            } else if (i2 == 2) {
                paddingTop -= scrollBar.b(getHeight());
            }
        }
        this.f7133k = scrollBar;
        int i3 = c.a[scrollBar.c().ordinal()];
        if (i3 == 1) {
            paddingBottom += scrollBar.b(getHeight());
        } else if (i3 == 2) {
            paddingTop += scrollBar.b(getHeight());
        }
        setPadding(getPaddingLeft(), paddingTop, getPaddingRight(), paddingBottom);
    }

    public void setSplitMethod(int i2) {
        this.f7126d = i2;
        B();
    }

    public a.b t() {
        return this.a;
    }

    public View v(int i2) {
        if (i2 < 0 || i2 > this.a.a() - 1) {
            return null;
        }
        return w(i2);
    }

    public ScrollBar x() {
        return this.f7133k;
    }

    @Override // com.shizhefei.view.indicator.a
    public void setCurrentItem(int i2, boolean z) {
        int i3;
        int left;
        int left2;
        int r = r();
        if (r == 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else {
            int i4 = r - 1;
            if (i2 > i4) {
                i2 = i4;
            }
        }
        int i5 = this.c;
        if (i5 != i2) {
            this.f7129g = i5;
            this.c = i2;
            if (!this.f7134l.c()) {
                this.f7134l.e();
            }
            if (this.f7127e == 0) {
                E(i2);
                if (z && getMeasuredWidth() != 0 && u(i2).getMeasuredWidth() != 0 && (i3 = this.f7129g) >= 0 && i3 < y()) {
                    this.f7134l.d(u(this.f7129g).getLeft(), u(i2).getLeft(), Math.min((int) (((Math.abs(left2 - left) / u(i2).getMeasuredWidth()) + 1.0f) * 100.0f), 600));
                    return;
                }
                C(i2, 0.0f, 0);
            } else if (this.t == null) {
                E(i2);
            }
        }
    }

    public void setCenterView(View view) {
        setCenterView(view, view.getLayoutParams());
    }

    public void setCenterView(View view, ViewGroup.LayoutParams layoutParams) {
        LinearLayout.LayoutParams generateLayoutParams;
        D();
        if (layoutParams == null) {
            generateLayoutParams = new LinearLayout.LayoutParams(-2, -1);
        } else {
            generateLayoutParams = generateLayoutParams(layoutParams);
        }
        this.v = generateLayoutParams;
        this.u = view;
        addView(view, getChildCount() / 2, generateLayoutParams);
    }

    @SuppressLint({"NewApi"})
    public FixedIndicatorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = -1;
        this.f7126d = 0;
        this.f7127e = 0;
        this.f7128f = true;
        this.f7129g = -1;
        this.f7130h = new LinkedList();
        this.f7131i = new a();
        this.f7132j = new b();
        this.n = new Matrix();
        this.o = new Canvas();
        this.p = new int[]{-1, -1};
        z();
    }

    public FixedIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = -1;
        this.f7126d = 0;
        this.f7127e = 0;
        this.f7128f = true;
        this.f7129g = -1;
        this.f7130h = new LinkedList();
        this.f7131i = new a();
        this.f7132j = new b();
        this.n = new Matrix();
        this.o = new Canvas();
        this.p = new int[]{-1, -1};
        z();
    }
}
