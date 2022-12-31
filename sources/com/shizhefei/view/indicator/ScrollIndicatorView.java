package com.shizhefei.view.indicator;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.shizhefei.view.indicator.a;
import com.shizhefei.view.indicator.slidebar.ScrollBar;
/* loaded from: classes3.dex */
public class ScrollIndicatorView extends HorizontalScrollView implements com.shizhefei.view.indicator.a {
    private final d a;
    private SFixedIndicatorView b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f7145d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f7146e;

    /* renamed from: f  reason: collision with root package name */
    private int f7147f;

    /* renamed from: g  reason: collision with root package name */
    private int f7148g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f7149h;

    /* renamed from: i  reason: collision with root package name */
    private a.InterfaceC0251a f7150i;

    /* renamed from: j  reason: collision with root package name */
    private Runnable f7151j;

    /* renamed from: k  reason: collision with root package name */
    private View f7152k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7153l;
    private int m;
    private float n;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class SFixedIndicatorView extends FixedIndicatorView {
        private boolean w;

        public SFixedIndicatorView(Context context) {
            super(context);
        }

        private int F(View view, int i2, int i3) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), -2), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), layoutParams.height));
            return view.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
        }

        public void G(boolean z) {
            if (this.w != z) {
                this.w = z;
                if (!z) {
                    setSplitMethod(2);
                }
                requestLayout();
                invalidate();
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i2, int i3) {
            ScrollIndicatorView scrollIndicatorView;
            int measuredWidth;
            if (this.w && (measuredWidth = (scrollIndicatorView = (ScrollIndicatorView) getParent()).getMeasuredWidth()) != 0) {
                int childCount = getChildCount();
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < childCount; i6++) {
                    int F = F(getChildAt(i6), i2, i3);
                    if (i5 < F) {
                        i5 = F;
                    }
                    i4 += F;
                }
                if (i4 > measuredWidth) {
                    scrollIndicatorView.setFillViewport(false);
                    setSplitMethod(2);
                } else if (i5 * childCount > measuredWidth) {
                    scrollIndicatorView.setFillViewport(true);
                    setSplitMethod(1);
                } else {
                    scrollIndicatorView.setFillViewport(true);
                    setSplitMethod(0);
                }
            }
            super.onMeasure(i2, i3);
        }
    }

    /* loaded from: classes3.dex */
    class a implements a.InterfaceC0251a {
        a() {
        }

        @Override // com.shizhefei.view.indicator.a.InterfaceC0251a
        public void onChange() {
            if (ScrollIndicatorView.this.f7151j != null) {
                ScrollIndicatorView scrollIndicatorView = ScrollIndicatorView.this;
                scrollIndicatorView.removeCallbacks(scrollIndicatorView.f7151j);
            }
            ScrollIndicatorView.this.n = 0.0f;
            ScrollIndicatorView scrollIndicatorView2 = ScrollIndicatorView.this;
            scrollIndicatorView2.setCurrentItem(scrollIndicatorView2.b.s(), false);
            if (!ScrollIndicatorView.this.c || ScrollIndicatorView.this.b.getChildCount() <= 0) {
                return;
            }
            ScrollIndicatorView scrollIndicatorView3 = ScrollIndicatorView.this;
            scrollIndicatorView3.f7152k = scrollIndicatorView3.b.getChildAt(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        final /* synthetic */ View a;

        b(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollIndicatorView.this.smoothScrollTo(this.a.getLeft() - ((ScrollIndicatorView.this.getWidth() - this.a.getWidth()) / 2), 0);
            ScrollIndicatorView.this.f7151j = null;
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
                iArr[ScrollBar.Gravity.CENTENT_BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ScrollBar.Gravity.CENTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ScrollBar.Gravity.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ScrollBar.Gravity.TOP_FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ScrollBar.Gravity.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ScrollBar.Gravity.BOTTOM_FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes3.dex */
    private class d implements a.c {
        private a.c a;

        private d() {
        }

        @Override // com.shizhefei.view.indicator.a.c
        public void a(View view, int i2, int i3) {
            if (ScrollIndicatorView.this.f7148g == 0) {
                ScrollIndicatorView.this.j(i2);
            }
            a.c cVar = this.a;
            if (cVar != null) {
                cVar.a(view, i2, i3);
            }
        }

        public void b(a.c cVar) {
            this.a = cVar;
        }

        /* synthetic */ d(ScrollIndicatorView scrollIndicatorView, a aVar) {
            this();
        }
    }

    @TargetApi(11)
    public ScrollIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        this.f7145d = null;
        this.f7148g = 0;
        this.f7150i = new a();
        this.m = -1;
        SFixedIndicatorView sFixedIndicatorView = new SFixedIndicatorView(context);
        this.b = sFixedIndicatorView;
        addView(sFixedIndicatorView, new FrameLayout.LayoutParams(-2, -1));
        setHorizontalScrollBarEnabled(false);
        setSplitAuto(true);
        Paint paint = new Paint();
        this.f7145d = paint;
        paint.setAntiAlias(true);
        this.f7145d.setColor(866822826);
        int k2 = k(3.0f);
        this.f7147f = k2;
        this.f7145d.setShadowLayer(k2, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        SFixedIndicatorView sFixedIndicatorView2 = this.b;
        d dVar = new d(this, null);
        this.a = dVar;
        sFixedIndicatorView2.setOnItemSelectListener(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i2) {
        if (i2 < 0 || i2 > this.b.r() - 1) {
            return;
        }
        View childAt = this.b.getChildAt(i2);
        Runnable runnable = this.f7151j;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        b bVar = new b(childAt);
        this.f7151j = bVar;
        post(bVar);
    }

    private int k(float f2) {
        return (int) TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }

    private void l(Canvas canvas) {
        int height;
        ScrollBar x = this.b.x();
        if (x == null || this.b.s() != 0) {
            return;
        }
        int save = canvas.save();
        int i2 = c.a[x.c().ordinal()];
        if (i2 != 1 && i2 != 2) {
            height = (i2 == 3 || i2 == 4) ? 0 : getHeight() - x.b(getHeight());
        } else {
            height = (getHeight() - x.b(getHeight())) / 2;
        }
        int d2 = x.d(this.f7152k.getWidth());
        int b2 = x.b(this.f7152k.getHeight());
        x.a().measure(d2, b2);
        x.a().layout(0, 0, d2, b2);
        canvas.translate((this.f7152k.getWidth() - d2) / 2, height);
        canvas.clipRect(0, 0, d2, b2);
        x.a().draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // com.shizhefei.view.indicator.a
    public int a() {
        return this.b.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.c) {
            int scrollX = getScrollX();
            if (this.f7152k == null || scrollX <= 0) {
                return;
            }
            int save = canvas.save();
            canvas.translate(scrollX + getPaddingLeft(), getPaddingTop());
            Drawable drawable = this.f7149h;
            if (drawable != null) {
                drawable.setBounds(0, 0, this.f7152k.getWidth(), this.f7152k.getHeight());
                this.f7149h.draw(canvas);
            }
            ScrollBar x = this.b.x();
            if (x != null && x.c() == ScrollBar.Gravity.CENTENT_BACKGROUND) {
                l(canvas);
            }
            this.f7152k.draw(canvas);
            if (x != null && x.c() != ScrollBar.Gravity.CENTENT_BACKGROUND) {
                l(canvas);
            }
            canvas.translate(this.f7152k.getWidth(), 0.0f);
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            Drawable drawable2 = this.f7146e;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, this.f7147f, height);
                this.f7146e.draw(canvas);
            } else {
                canvas.clipRect(0, 0, this.f7147f + k(1.0f), height);
                canvas.drawRect(0.0f, 0.0f, k(1.0f), height, this.f7145d);
            }
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.c) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            View view = this.f7152k;
            if (view != null && y >= view.getTop() && y <= this.f7152k.getBottom() && x > this.f7152k.getLeft() && x < this.f7152k.getRight()) {
                if (motionEvent.getAction() == 0) {
                    this.f7153l = true;
                } else if (motionEvent.getAction() == 1 && this.f7153l) {
                    this.f7152k.performClick();
                    invalidate(new Rect(0, 0, this.f7152k.getMeasuredWidth(), this.f7152k.getMeasuredHeight()));
                    this.f7153l = false;
                }
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public a.b m() {
        return this.b.t();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f7151j;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f7151j;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View childAt;
        int left;
        super.onLayout(z, i2, i3, i4, i5);
        int i6 = this.m;
        if (i6 == -1 || (childAt = this.b.getChildAt(i6)) == null || (left = childAt.getLeft() - ((getMeasuredWidth() - childAt.getMeasuredWidth()) / 2)) < 0) {
            return;
        }
        smoothScrollTo(left, 0);
        this.m = -1;
    }

    @Override // com.shizhefei.view.indicator.a
    public void onPageScrollStateChanged(int i2) {
        this.f7148g = i2;
        this.b.onPageScrollStateChanged(i2);
    }

    @Override // com.shizhefei.view.indicator.a
    public void onPageScrolled(int i2, float f2, int i3) {
        View childAt = this.b.getChildAt(i2);
        if (childAt == null) {
            return;
        }
        View childAt2 = this.b.getChildAt(i2 + 1);
        scrollTo((int) ((childAt.getLeft() - ((getWidth() - childAt.getWidth()) / 2)) + (((childAt.getWidth() + (childAt2 == null ? childAt.getWidth() : childAt2.getWidth())) / 2) * f2)), 0);
        this.b.onPageScrolled(i2, f2, i3);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.b.r() > 0) {
            j(this.b.s());
        }
    }

    @Override // com.shizhefei.view.indicator.a
    public void setAdapter(a.b bVar) {
        if (m() != null) {
            m().g(this.f7150i);
        }
        this.b.setAdapter(bVar);
        bVar.e(this.f7150i);
        this.f7150i.onChange();
    }

    public void setCurrentItem(int i2) {
        setCurrentItem(i2, true);
    }

    @Override // com.shizhefei.view.indicator.a
    public void setItemClickable(boolean z) {
        this.b.setItemClickable(z);
    }

    @Override // com.shizhefei.view.indicator.a
    public void setOnItemSelectListener(a.c cVar) {
        this.a.b(cVar);
    }

    @Override // com.shizhefei.view.indicator.a
    public void setOnTransitionListener(a.d dVar) {
        this.b.setOnTransitionListener(dVar);
    }

    public void setPinnedShadow(Drawable drawable, int i2) {
        this.f7146e = drawable;
        this.f7147f = i2;
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setPinnedTabBg(Drawable drawable) {
        this.f7149h = drawable;
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setPinnedTabBgColor(int i2) {
        setPinnedTabBg(new ColorDrawable(i2));
    }

    public void setPinnedTabBgId(int i2) {
        setPinnedTabBg(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setPinnedTabView(boolean z) {
        this.c = z;
        if (z && this.b.getChildCount() > 0) {
            this.f7152k = this.b.getChildAt(0);
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // com.shizhefei.view.indicator.a
    public void setScrollBar(ScrollBar scrollBar) {
        this.b.setScrollBar(scrollBar);
    }

    public void setSplitAuto(boolean z) {
        setFillViewport(z);
        this.b.G(z);
    }

    @Override // com.shizhefei.view.indicator.a
    public void setCurrentItem(int i2, boolean z) {
        int r = this.b.r();
        if (r == 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else {
            int i3 = r - 1;
            if (i2 > i3) {
                i2 = i3;
            }
        }
        this.m = -1;
        if (this.f7148g == 0) {
            if (z) {
                j(i2);
            } else {
                View childAt = this.b.getChildAt(i2);
                scrollTo(childAt.getLeft() - ((getWidth() - childAt.getWidth()) / 2), 0);
                this.m = i2;
            }
        }
        this.b.setCurrentItem(i2, z);
    }

    public void setPinnedShadow(int i2, int i3) {
        setPinnedShadow(ContextCompat.getDrawable(getContext(), i2), i3);
    }
}
