package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.shape.h;
import com.google.android.material.shape.i;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int r = R.style.Widget_Design_AppBarLayout;
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f4036d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4037e;

    /* renamed from: f  reason: collision with root package name */
    private int f4038f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private WindowInsetsCompat f4039g;

    /* renamed from: h  reason: collision with root package name */
    private List<c> f4040h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4041i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4042j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4043k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4044l;
    @IdRes
    private int m;
    @Nullable
    private WeakReference<View> n;
    @Nullable
    private ValueAnimator o;
    private int[] p;
    @Nullable
    private Drawable q;

    /* loaded from: classes2.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes2.dex */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private static int n(@NonNull AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                return ((BaseBehavior) behavior).i();
            }
            return 0;
        }

        private void o(@NonNull View view, @NonNull View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).f4045k) + i()) - e(view2));
            }
        }

        private void p(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.s()) {
                    appBarLayout.A(appBarLayout.C(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float f(View view) {
            int i2;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int m = appBarLayout.m();
                int h2 = appBarLayout.h();
                int n = n(appBarLayout);
                if ((h2 == 0 || m + n > h2) && (i2 = m - h2) != 0) {
                    return (n / i2) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        int h(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).m();
            }
            return super.h(view);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        /* renamed from: m */
        public AppBarLayout d(@NonNull List<View> list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = list.get(i2);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            o(view, view2);
            p(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z) {
            AppBarLayout d2 = d(coordinatorLayout.getDependencies(view));
            if (d2 != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f4065d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    d2.setExpanded(false, !z);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            k(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes2.dex */
    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            AppBarLayout.this.u(windowInsetsCompat);
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ h a;

        b(AppBarLayout appBarLayout, h hVar) {
            this.a = hVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            this.a.V(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes2.dex */
    public interface c<T extends AppBarLayout> {
        void a(T t, int i2);
    }

    /* loaded from: classes2.dex */
    public interface d extends c<AppBarLayout> {
    }

    public AppBarLayout(@NonNull Context context) {
        this(context, null);
    }

    private boolean B() {
        return this.q != null && l() > 0;
    }

    private boolean D() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            return (childAt.getVisibility() == 8 || ViewCompat.getFitsSystemWindows(childAt)) ? false : true;
        }
        return false;
    }

    private void E(@NonNull h hVar, boolean z) {
        float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
        float f2 = z ? 0.0f : dimension;
        if (!z) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.o;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, dimension);
        this.o = ofFloat;
        ofFloat.setDuration(getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
        this.o.setInterpolator(com.google.android.material.animation.a.a);
        this.o.addUpdateListener(new b(this, hVar));
        this.o.start();
    }

    private void F() {
        setWillNotDraw(!B());
    }

    private void c() {
        WeakReference<View> weakReference = this.n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.n = null;
    }

    @Nullable
    private View d(@Nullable View view) {
        int i2;
        if (this.n == null && (i2 = this.m) != -1) {
            View findViewById = view != null ? view.findViewById(i2) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.m);
            }
            if (findViewById != null) {
                this.n = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.n;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean p() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((LayoutParams) getChildAt(i2).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void r() {
        this.b = -1;
        this.c = -1;
        this.f4036d = -1;
    }

    private void y(boolean z, boolean z2, boolean z3) {
        this.f4038f = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    private boolean z(boolean z) {
        if (this.f4042j != z) {
            this.f4042j = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    boolean A(boolean z) {
        if (this.f4043k != z) {
            this.f4043k = z;
            refreshDrawableState();
            if (this.f4044l && (getBackground() instanceof h)) {
                E((h) getBackground(), z);
                return true;
            }
            return true;
        }
        return false;
    }

    boolean C(@Nullable View view) {
        View d2 = d(view);
        if (d2 != null) {
            view = d2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    public void a(@Nullable c cVar) {
        if (this.f4040h == null) {
            this.f4040h = new ArrayList();
        }
        if (cVar == null || this.f4040h.contains(cVar)) {
            return;
        }
        this.f4040h.add(cVar);
    }

    public void b(d dVar) {
        a(dVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (B()) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.a);
            this.q.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.q;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: e */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: f */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: g */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    int h() {
        int i2;
        int minimumHeight;
        int i3 = this.c;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = layoutParams.a;
            if ((i5 & 5) == 5) {
                int i6 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i5 & 8) != 0) {
                    minimumHeight = ViewCompat.getMinimumHeight(childAt);
                } else if ((i5 & 2) != 0) {
                    minimumHeight = measuredHeight - ViewCompat.getMinimumHeight(childAt);
                } else {
                    i2 = i6 + measuredHeight;
                    if (childCount == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                        i2 = Math.min(i2, measuredHeight - l());
                    }
                    i4 += i2;
                }
                i2 = i6 + minimumHeight;
                if (childCount == 0) {
                    i2 = Math.min(i2, measuredHeight - l());
                }
                i4 += i2;
            } else if (i4 > 0) {
                break;
            }
        }
        int max = Math.max(0, i4);
        this.c = max;
        return max;
    }

    int i() {
        int i2 = this.f4036d;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            int i5 = layoutParams.a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                i4 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f4036d = max;
        return max;
    }

    public final int j() {
        int l2 = l();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + l2;
    }

    int k() {
        return this.f4038f;
    }

    @VisibleForTesting
    final int l() {
        WindowInsetsCompat windowInsetsCompat = this.f4039g;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int m() {
        int i2 = this.b;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = layoutParams.a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            if (i3 == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                i4 -= l();
            }
            if ((i5 & 2) != 0) {
                i4 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.b = max;
        return max;
    }

    int n() {
        return m();
    }

    boolean o() {
        return this.f4037e;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.p == null) {
            this.p = new int[4];
        }
        int[] iArr = this.p;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        boolean z = this.f4042j;
        int i3 = R.attr.state_liftable;
        if (!z) {
            i3 = -i3;
        }
        iArr[0] = i3;
        iArr[1] = (z && this.f4043k) ? R.attr.state_lifted : -R.attr.state_lifted;
        int i4 = R.attr.state_collapsible;
        if (!z) {
            i4 = -i4;
        }
        iArr[2] = i4;
        iArr[3] = (z && this.f4043k) ? R.attr.state_collapsed : -R.attr.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        boolean z2 = true;
        if (ViewCompat.getFitsSystemWindows(this) && D()) {
            int l2 = l();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.offsetTopAndBottom(getChildAt(childCount), l2);
            }
        }
        r();
        this.f4037e = false;
        int childCount2 = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount2) {
                break;
            } else if (((LayoutParams) getChildAt(i6).getLayoutParams()).b() != null) {
                this.f4037e = true;
                break;
            } else {
                i6++;
            }
        }
        Drawable drawable = this.q;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), l());
        }
        if (this.f4041i) {
            return;
        }
        if (!this.f4044l && !p()) {
            z2 = false;
        }
        z(z2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && D()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = MathUtils.clamp(getMeasuredHeight() + l(), 0, View.MeasureSpec.getSize(i3));
            } else if (mode == 0) {
                measuredHeight += l();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        r();
    }

    boolean q() {
        return m() != 0;
    }

    public boolean s() {
        return this.f4044l;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        i.d(this, f2);
    }

    public void setExpanded(boolean z) {
        setExpanded(z, ViewCompat.isLaidOut(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.f4044l = z;
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i2) {
        this.m = i2;
        c();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        if (i2 == 1) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.q = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.q.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.q, ViewCompat.getLayoutDirection(this));
                this.q.setVisible(getVisibility() == 0, false);
                this.q.setCallback(this);
            }
            F();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i2) {
        setStatusBarForeground(new ColorDrawable(i2));
    }

    public void setStatusBarForegroundResource(@DrawableRes int i2) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), i2));
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            com.google.android.material.appbar.b.b(this, f2);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        VdsAgent.onSetViewVisibility(this, i2);
        boolean z = i2 == 0;
        Drawable drawable = this.q;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    void t(int i2) {
        this.a = i2;
        if (!willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        List<c> list = this.f4040h;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = this.f4040h.get(i3);
                if (cVar != null) {
                    cVar.a(this, i2);
                }
            }
        }
    }

    WindowInsetsCompat u(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.f4039g, windowInsetsCompat2)) {
            this.f4039g = windowInsetsCompat2;
            F();
            requestLayout();
        }
        return windowInsetsCompat;
    }

    public void v(@Nullable c cVar) {
        List<c> list = this.f4040h;
        if (list == null || cVar == null) {
            return;
        }
        list.remove(cVar);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q;
    }

    public void w(d dVar) {
        v(dVar);
    }

    void x() {
        this.f4038f = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {

        /* renamed from: k  reason: collision with root package name */
        private int f4045k;

        /* renamed from: l  reason: collision with root package name */
        private int f4046l;
        private ValueAnimator m;
        private int n;
        private boolean o;
        private float p;
        @Nullable
        private WeakReference<View> q;
        private d r;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ CoordinatorLayout a;
            final /* synthetic */ AppBarLayout b;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.a = coordinatorLayout;
                this.b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                BaseBehavior.this.l(this.a, this.b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class b implements AccessibilityViewCommand {
            final /* synthetic */ CoordinatorLayout a;
            final /* synthetic */ AppBarLayout b;
            final /* synthetic */ View c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f4047d;

            b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
                this.a = coordinatorLayout;
                this.b = appBarLayout;
                this.c = view;
                this.f4047d = i2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                BaseBehavior.this.onNestedPreScroll(this.a, this.b, this.c, 0, this.f4047d, new int[]{0, 0}, 1);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class c implements AccessibilityViewCommand {
            final /* synthetic */ AppBarLayout a;
            final /* synthetic */ boolean b;

            c(BaseBehavior baseBehavior, AppBarLayout appBarLayout, boolean z) {
                this.a = appBarLayout;
                this.b = z;
            }

            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                this.a.setExpanded(this.b);
                return true;
            }
        }

        /* loaded from: classes2.dex */
        public static abstract class d<T extends AppBarLayout> {
            public abstract boolean a(@NonNull T t);
        }

        public BaseBehavior() {
            this.n = -1;
        }

        private int A(@NonNull T t, int i2) {
            int abs = Math.abs(i2);
            int childCount = t.getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator b2 = layoutParams.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i4++;
                } else if (b2 != null) {
                    int a2 = layoutParams.a();
                    if ((a2 & 1) != 0) {
                        i3 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        if ((a2 & 2) != 0) {
                            i3 -= ViewCompat.getMinimumHeight(childAt);
                        }
                    }
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        i3 -= t.l();
                    }
                    if (i3 > 0) {
                        float f2 = i3;
                        return Integer.signum(i2) * (childAt.getTop() + Math.round(f2 * b2.getInterpolation((abs - childAt.getTop()) / f2)));
                    }
                }
            }
            return i2;
        }

        private boolean L(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t) {
            List<View> dependents = coordinatorLayout.getDependents(t);
            int size = dependents.size();
            for (int i2 = 0; i2 < size; i2++) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) dependents.get(i2).getLayoutParams()).getBehavior();
                if (behavior instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) behavior).g() != 0;
                }
            }
            return false;
        }

        private void M(CoordinatorLayout coordinatorLayout, @NonNull T t) {
            int i2 = i();
            int x = x(t, i2);
            if (x >= 0) {
                View childAt = t.getChildAt(x);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int a2 = layoutParams.a();
                if ((a2 & 17) == 17) {
                    int i3 = -childAt.getTop();
                    int i4 = -childAt.getBottom();
                    if (x == t.getChildCount() - 1) {
                        i4 += t.l();
                    }
                    if (u(a2, 2)) {
                        i4 += ViewCompat.getMinimumHeight(childAt);
                    } else if (u(a2, 5)) {
                        int minimumHeight = ViewCompat.getMinimumHeight(childAt) + i4;
                        if (i2 < minimumHeight) {
                            i3 = minimumHeight;
                        } else {
                            i4 = minimumHeight;
                        }
                    }
                    if (u(a2, 32)) {
                        i3 += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        i4 -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    if (i2 < (i4 + i3) / 2) {
                        i3 = i4;
                    }
                    q(coordinatorLayout, t, MathUtils.clamp(i3, -t.m(), 0), 0.0f);
                }
            }
        }

        private void N(CoordinatorLayout coordinatorLayout, @NonNull T t) {
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            View v = v(coordinatorLayout);
            if (v == null || t.m() == 0 || !(((CoordinatorLayout.LayoutParams) v.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior)) {
                return;
            }
            o(coordinatorLayout, t, v);
        }

        private void O(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i2, int i3, boolean z) {
            View w = w(t, i2);
            if (w != null) {
                int a2 = ((LayoutParams) w.getLayoutParams()).a();
                boolean z2 = false;
                if ((a2 & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(w);
                    if (i3 <= 0 || (a2 & 12) == 0 ? !((a2 & 2) == 0 || (-i2) < (w.getBottom() - minimumHeight) - t.l()) : (-i2) >= (w.getBottom() - minimumHeight) - t.l()) {
                        z2 = true;
                    }
                }
                if (t.s()) {
                    z2 = t.C(v(coordinatorLayout));
                }
                boolean A = t.A(z2);
                if (z || (A && L(coordinatorLayout, t))) {
                    t.jumpDrawablesToCurrentState();
                }
            }
        }

        private void o(CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull View view) {
            if (i() != (-t.m()) && view.canScrollVertically(1)) {
                p(coordinatorLayout, t, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
            }
            if (i() != 0) {
                if (view.canScrollVertically(-1)) {
                    int i2 = -t.h();
                    if (i2 != 0) {
                        ViewCompat.replaceAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new b(coordinatorLayout, t, view, i2));
                        return;
                    }
                    return;
                }
                p(coordinatorLayout, t, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
            }
        }

        private void p(CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, boolean z) {
            ViewCompat.replaceAccessibilityAction(coordinatorLayout, accessibilityActionCompat, null, new c(this, t, z));
        }

        private void q(CoordinatorLayout coordinatorLayout, @NonNull T t, int i2, float f2) {
            int height;
            int abs = Math.abs(i() - i2);
            float abs2 = Math.abs(f2);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / t.getHeight()) + 1.0f) * 150.0f);
            }
            r(coordinatorLayout, t, i2, height);
        }

        private void r(CoordinatorLayout coordinatorLayout, T t, int i2, int i3) {
            int i4 = i();
            if (i4 == i2) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.m = valueAnimator3;
                valueAnimator3.setInterpolator(com.google.android.material.animation.a.f4033e);
                this.m.addUpdateListener(new a(coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration(Math.min(i3, 600));
            this.m.setIntValues(i4, i2);
            this.m.start();
        }

        private boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull View view) {
            return t.q() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        private static boolean u(int i2, int i3) {
            return (i2 & i3) == i3;
        }

        @Nullable
        private View v(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        @Nullable
        private static View w(@NonNull AppBarLayout appBarLayout, int i2) {
            int abs = Math.abs(i2);
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int x(@NonNull T t, int i2) {
            int childCount = t.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t.getChildAt(i3);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (u(layoutParams.a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i4 = -i2;
                if (top <= i4 && bottom >= i4) {
                    return i3;
                }
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: B */
        public void j(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t) {
            M(coordinatorLayout, t);
            if (t.s()) {
                t.A(t.C(v(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: C */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i2) {
            int round;
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, t, i2);
            int k2 = t.k();
            int i3 = this.n;
            if (i3 >= 0 && (k2 & 8) == 0) {
                View childAt = t.getChildAt(i3);
                int i4 = -childAt.getBottom();
                if (this.o) {
                    round = ViewCompat.getMinimumHeight(childAt) + t.l();
                } else {
                    round = Math.round(childAt.getHeight() * this.p);
                }
                l(coordinatorLayout, t, i4 + round);
            } else if (k2 != 0) {
                boolean z = (k2 & 4) != 0;
                if ((k2 & 2) != 0) {
                    int i5 = -t.n();
                    if (z) {
                        q(coordinatorLayout, t, i5, 0.0f);
                    } else {
                        l(coordinatorLayout, t, i5);
                    }
                } else if ((k2 & 1) != 0) {
                    if (z) {
                        q(coordinatorLayout, t, 0, 0.0f);
                    } else {
                        l(coordinatorLayout, t, 0);
                    }
                }
            }
            t.x();
            this.n = -1;
            c(MathUtils.clamp(a(), -t.m(), 0));
            O(coordinatorLayout, t, a(), 0, true);
            t.t(a());
            N(coordinatorLayout, t);
            return onLayoutChild;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: D */
        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i2, int i3, int i4, int i5) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) t.getLayoutParams())).height == -2) {
                coordinatorLayout.onMeasureChild(t, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
                return true;
            }
            return super.onMeasureChild(coordinatorLayout, t, i2, i3, i4, i5);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: E */
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull T t, View view, int i2, int i3, int[] iArr, int i4) {
            int i5;
            int i6;
            if (i3 != 0) {
                if (i3 < 0) {
                    int i7 = -t.m();
                    i5 = i7;
                    i6 = t.h() + i7;
                } else {
                    i5 = -t.n();
                    i6 = 0;
                }
                if (i5 != i6) {
                    iArr[1] = k(coordinatorLayout, t, i3, i5, i6);
                }
            }
            if (t.s()) {
                t.A(t.C(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: F */
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            if (i5 < 0) {
                iArr[1] = k(coordinatorLayout, t, i5, -t.i(), 0);
            }
            if (i5 == 0) {
                N(coordinatorLayout, t);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: G */
        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.onRestoreInstanceState(coordinatorLayout, t, savedState.getSuperState());
                this.n = savedState.a;
                this.p = savedState.b;
                this.o = savedState.c;
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, t, parcelable);
            this.n = -1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: H */
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, t);
            int a2 = a();
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int bottom = childAt.getBottom() + a2;
                if (childAt.getTop() + a2 <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(onSaveInstanceState);
                    savedState.a = i2;
                    savedState.c = bottom == ViewCompat.getMinimumHeight(childAt) + t.l();
                    savedState.b = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return onSaveInstanceState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: I */
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull View view, View view2, int i2, int i3) {
            ValueAnimator valueAnimator;
            boolean z = (i2 & 2) != 0 && (t.s() || t(coordinatorLayout, t, view));
            if (z && (valueAnimator = this.m) != null) {
                valueAnimator.cancel();
            }
            this.q = null;
            this.f4046l = i3;
            return z;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: J */
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t, View view, int i2) {
            if (this.f4046l == 0 || i2 == 1) {
                M(coordinatorLayout, t);
                if (t.s()) {
                    t.A(t.C(view));
                }
            }
            this.q = new WeakReference<>(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: K */
        public int m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i2, int i3, int i4) {
            int i5 = i();
            int i6 = 0;
            if (i3 != 0 && i5 >= i3 && i5 <= i4) {
                int clamp = MathUtils.clamp(i2, i3, i4);
                if (i5 != clamp) {
                    int A = t.o() ? A(t, clamp) : clamp;
                    boolean c2 = c(A);
                    i6 = i5 - clamp;
                    this.f4045k = clamp - A;
                    if (!c2 && t.o()) {
                        coordinatorLayout.dispatchDependentViewsChanged(t);
                    }
                    t.t(a());
                    O(coordinatorLayout, t, clamp, clamp < i5 ? -1 : 1, false);
                }
            } else {
                this.f4045k = 0;
            }
            N(coordinatorLayout, t);
            return i6;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int i() {
            return a() + this.f4045k;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: s */
        public boolean d(T t) {
            d dVar = this.r;
            if (dVar != null) {
                return dVar.a(t);
            }
            WeakReference<View> weakReference = this.q;
            if (weakReference != null) {
                View view = weakReference.get();
                return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: y */
        public int g(@NonNull T t) {
            return -t.i();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: z */
        public int h(@NonNull T t) {
            return t.m();
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.n = -1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes2.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();
            int a;
            float b;
            boolean c;

            /* loaded from: classes2.dex */
            static class a implements Parcelable.ClassLoaderCreator<SavedState> {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                @Nullable
                /* renamed from: a */
                public SavedState createFromParcel(@NonNull Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                @NonNull
                /* renamed from: b */
                public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                @NonNull
                /* renamed from: c */
                public SavedState[] newArray(int i2) {
                    return new SavedState[i2];
                }
            }

            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.a = parcel.readInt();
                this.b = parcel.readFloat();
                this.c = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel parcel, int i2) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.a);
                parcel.writeFloat(this.b);
                parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
    }

    public void setExpanded(boolean z, boolean z2) {
        y(z, z2, true);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppBarLayout(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r4 = com.google.android.material.appbar.AppBarLayout.r
            android.content.Context r11 = com.google.android.material.theme.a.a.c(r11, r12, r13, r4)
            r10.<init>(r11, r12, r13)
            r11 = -1
            r10.b = r11
            r10.c = r11
            r10.f4036d = r11
            r6 = 0
            r10.f4038f = r6
            android.content.Context r7 = r10.getContext()
            r0 = 1
            r10.setOrientation(r0)
            int r8 = android.os.Build.VERSION.SDK_INT
            r9 = 21
            if (r8 < r9) goto L27
            com.google.android.material.appbar.b.a(r10)
            com.google.android.material.appbar.b.c(r10, r12, r13, r4)
        L27:
            int[] r2 = com.google.android.material.R.styleable.AppBarLayout
            int[] r5 = new int[r6]
            r0 = r7
            r1 = r12
            r3 = r13
            android.content.res.TypedArray r12 = com.google.android.material.internal.k.h(r0, r1, r2, r3, r4, r5)
            int r13 = com.google.android.material.R.styleable.AppBarLayout_android_background
            android.graphics.drawable.Drawable r13 = r12.getDrawable(r13)
            androidx.core.view.ViewCompat.setBackground(r10, r13)
            android.graphics.drawable.Drawable r13 = r10.getBackground()
            boolean r13 = r13 instanceof android.graphics.drawable.ColorDrawable
            if (r13 == 0) goto L5f
            android.graphics.drawable.Drawable r13 = r10.getBackground()
            android.graphics.drawable.ColorDrawable r13 = (android.graphics.drawable.ColorDrawable) r13
            com.google.android.material.shape.h r0 = new com.google.android.material.shape.h
            r0.<init>()
            int r13 = r13.getColor()
            android.content.res.ColorStateList r13 = android.content.res.ColorStateList.valueOf(r13)
            r0.W(r13)
            r0.L(r7)
            androidx.core.view.ViewCompat.setBackground(r10, r0)
        L5f:
            int r13 = com.google.android.material.R.styleable.AppBarLayout_expanded
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L6e
            boolean r13 = r12.getBoolean(r13, r6)
            r10.y(r13, r6, r6)
        L6e:
            if (r8 < r9) goto L80
            int r13 = com.google.android.material.R.styleable.AppBarLayout_elevation
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L80
            int r13 = r12.getDimensionPixelSize(r13, r6)
            float r13 = (float) r13
            com.google.android.material.appbar.b.b(r10, r13)
        L80:
            r13 = 26
            if (r8 < r13) goto La2
            int r13 = com.google.android.material.R.styleable.AppBarLayout_android_keyboardNavigationCluster
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L93
            boolean r13 = r12.getBoolean(r13, r6)
            r10.setKeyboardNavigationCluster(r13)
        L93:
            int r13 = com.google.android.material.R.styleable.AppBarLayout_android_touchscreenBlocksFocus
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto La2
            boolean r13 = r12.getBoolean(r13, r6)
            r10.setTouchscreenBlocksFocus(r13)
        La2:
            int r13 = com.google.android.material.R.styleable.AppBarLayout_liftOnScroll
            boolean r13 = r12.getBoolean(r13, r6)
            r10.f4044l = r13
            int r13 = com.google.android.material.R.styleable.AppBarLayout_liftOnScrollTargetViewId
            int r11 = r12.getResourceId(r13, r11)
            r10.m = r11
            int r11 = com.google.android.material.R.styleable.AppBarLayout_statusBarForeground
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r11)
            r10.setStatusBarForeground(r11)
            r12.recycle()
            com.google.android.material.appbar.AppBarLayout$a r11 = new com.google.android.material.appbar.AppBarLayout$a
            r11.<init>()
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        int a;
        Interpolator b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.a = obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            int i2 = R.styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i2, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public int a() {
            return this.a;
        }

        public Interpolator b() {
            return this.b;
        }

        boolean c() {
            int i2 = this.a;
            return (i2 & 1) == 1 && (i2 & 10) != 0;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.a = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }
    }
}
