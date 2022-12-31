package me.relex.circleindicator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.annotation.DrawableRes;
import androidx.viewpager.widget.ViewPager;
import java.util.Objects;
/* loaded from: classes3.dex */
public class CircleIndicator extends LinearLayout {
    private ViewPager a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f8861d;

    /* renamed from: e  reason: collision with root package name */
    private int f8862e;

    /* renamed from: f  reason: collision with root package name */
    private int f8863f;

    /* renamed from: g  reason: collision with root package name */
    private int f8864g;

    /* renamed from: h  reason: collision with root package name */
    private int f8865h;

    /* renamed from: i  reason: collision with root package name */
    private Animator f8866i;

    /* renamed from: j  reason: collision with root package name */
    private Animator f8867j;

    /* renamed from: k  reason: collision with root package name */
    private Animator f8868k;

    /* renamed from: l  reason: collision with root package name */
    private Animator f8869l;
    private int m;
    private final ViewPager.OnPageChangeListener n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            CircleIndicator circleIndicator;
            View childAt;
            if (CircleIndicator.this.a.getAdapter() == null || CircleIndicator.this.a.getAdapter().getCount() <= 0) {
                return;
            }
            if (CircleIndicator.this.f8867j.isRunning()) {
                CircleIndicator.this.f8867j.end();
                CircleIndicator.this.f8867j.cancel();
            }
            if (CircleIndicator.this.f8866i.isRunning()) {
                CircleIndicator.this.f8866i.end();
                CircleIndicator.this.f8866i.cancel();
            }
            if (CircleIndicator.this.m >= 0 && (childAt = (circleIndicator = CircleIndicator.this).getChildAt(circleIndicator.m)) != null) {
                childAt.setBackgroundResource(CircleIndicator.this.f8865h);
                CircleIndicator.this.f8867j.setTarget(childAt);
                CircleIndicator.this.f8867j.start();
            }
            View childAt2 = CircleIndicator.this.getChildAt(i2);
            if (childAt2 != null) {
                childAt2.setBackgroundResource(CircleIndicator.this.f8864g);
                CircleIndicator.this.f8866i.setTarget(childAt2);
                CircleIndicator.this.f8866i.start();
            }
            CircleIndicator.this.m = i2;
        }
    }

    /* loaded from: classes3.dex */
    class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            int count;
            super.onChanged();
            if (CircleIndicator.this.a == null || (count = CircleIndicator.this.a.getAdapter().getCount()) == CircleIndicator.this.getChildCount()) {
                return;
            }
            if (CircleIndicator.this.m >= count) {
                CircleIndicator.this.m = -1;
            } else {
                CircleIndicator circleIndicator = CircleIndicator.this;
                circleIndicator.m = circleIndicator.a.getCurrentItem();
            }
            CircleIndicator.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c implements Interpolator {
        private c(CircleIndicator circleIndicator) {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return Math.abs(1.0f - f2);
        }

        /* synthetic */ c(CircleIndicator circleIndicator, a aVar) {
            this(circleIndicator);
        }
    }

    public CircleIndicator(Context context) {
        super(context);
        this.b = -1;
        this.c = -1;
        this.f8861d = -1;
        this.f8862e = R.animator.scale_with_alpha;
        this.f8863f = 0;
        int i2 = R.drawable.white_radius;
        this.f8864g = i2;
        this.f8865h = i2;
        this.m = -1;
        this.n = new a();
        new b();
        p(context, null);
    }

    private void i(@DrawableRes int i2, Animator animator) {
        if (animator.isRunning()) {
            animator.end();
            animator.cancel();
        }
        View view = new View(getContext());
        view.setBackgroundResource(i2);
        addView(view, this.c, this.f8861d);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        int i3 = this.b;
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i3;
        view.setLayoutParams(layoutParams);
        animator.setTarget(view);
        animator.start();
    }

    private void j(Context context) {
        int i2 = this.c;
        if (i2 < 0) {
            i2 = n(5.0f);
        }
        this.c = i2;
        int i3 = this.f8861d;
        if (i3 < 0) {
            i3 = n(5.0f);
        }
        this.f8861d = i3;
        int i4 = this.b;
        if (i4 < 0) {
            i4 = n(5.0f);
        }
        this.b = i4;
        int i5 = this.f8862e;
        if (i5 == 0) {
            i5 = R.animator.scale_with_alpha;
        }
        this.f8862e = i5;
        this.f8866i = l(context);
        Animator l2 = l(context);
        this.f8868k = l2;
        l2.setDuration(0L);
        this.f8867j = k(context);
        Animator k2 = k(context);
        this.f8869l = k2;
        k2.setDuration(0L);
        int i6 = this.f8864g;
        if (i6 == 0) {
            i6 = R.drawable.white_radius;
        }
        this.f8864g = i6;
        int i7 = this.f8865h;
        if (i7 != 0) {
            i6 = i7;
        }
        this.f8865h = i6;
    }

    private Animator k(Context context) {
        int i2 = this.f8863f;
        if (i2 == 0) {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, this.f8862e);
            loadAnimator.setInterpolator(new c(this, null));
            return loadAnimator;
        }
        return AnimatorInflater.loadAnimator(context, i2);
    }

    private Animator l(Context context) {
        return AnimatorInflater.loadAnimator(context, this.f8862e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        removeAllViews();
        int count = this.a.getAdapter().getCount();
        if (count <= 0) {
            return;
        }
        int currentItem = this.a.getCurrentItem();
        for (int i2 = 0; i2 < count; i2++) {
            if (currentItem == i2) {
                i(this.f8864g, this.f8868k);
            } else {
                i(this.f8865h, this.f8869l);
            }
        }
    }

    private void o(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleIndicator);
        this.c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_width, -1);
        this.f8861d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_height, -1);
        this.b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_margin, -1);
        this.f8862e = obtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_animator, R.animator.scale_with_alpha);
        this.f8863f = obtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_animator_reverse, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_drawable, R.drawable.white_radius);
        this.f8864g = resourceId;
        this.f8865h = obtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_drawable_unselected, resourceId);
        setOrientation(obtainStyledAttributes.getInt(R.styleable.CircleIndicator_ci_orientation, -1) == 1 ? 1 : 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.CircleIndicator_ci_gravity, -1);
        if (i2 < 0) {
            i2 = 17;
        }
        setGravity(i2);
        obtainStyledAttributes.recycle();
    }

    private void p(Context context, AttributeSet attributeSet) {
        o(context, attributeSet);
        j(context);
    }

    public int n(float f2) {
        return (int) ((f2 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Deprecated
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        ViewPager viewPager = this.a;
        Objects.requireNonNull(viewPager, "can not find Viewpager , setViewPager first");
        viewPager.removeOnPageChangeListener(onPageChangeListener);
        this.a.addOnPageChangeListener(onPageChangeListener);
    }

    public void setViewPager(ViewPager viewPager) {
        this.a = viewPager;
        if (viewPager == null || viewPager.getAdapter() == null) {
            return;
        }
        this.m = -1;
        m();
        this.a.removeOnPageChangeListener(this.n);
        this.a.addOnPageChangeListener(this.n);
        this.n.onPageSelected(this.a.getCurrentItem());
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1;
        this.c = -1;
        this.f8861d = -1;
        this.f8862e = R.animator.scale_with_alpha;
        this.f8863f = 0;
        int i2 = R.drawable.white_radius;
        this.f8864g = i2;
        this.f8865h = i2;
        this.m = -1;
        this.n = new a();
        new b();
        p(context, attributeSet);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = -1;
        this.c = -1;
        this.f8861d = -1;
        this.f8862e = R.animator.scale_with_alpha;
        this.f8863f = 0;
        int i3 = R.drawable.white_radius;
        this.f8864g = i3;
        this.f8865h = i3;
        this.m = -1;
        this.n = new a();
        new b();
        p(context, attributeSet);
    }
}
