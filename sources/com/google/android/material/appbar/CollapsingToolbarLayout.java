package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes2.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int D = R.style.Widget_Design_CollapsingToolbar;
    private boolean A;
    private int B;
    private boolean C;
    private boolean a;
    private int b;
    @Nullable
    private ViewGroup c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private View f4049d;

    /* renamed from: e  reason: collision with root package name */
    private View f4050e;

    /* renamed from: f  reason: collision with root package name */
    private int f4051f;

    /* renamed from: g  reason: collision with root package name */
    private int f4052g;

    /* renamed from: h  reason: collision with root package name */
    private int f4053h;

    /* renamed from: i  reason: collision with root package name */
    private int f4054i;

    /* renamed from: j  reason: collision with root package name */
    private final Rect f4055j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    final com.google.android.material.internal.a f4056k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    final ElevationOverlayProvider f4057l;
    private boolean m;
    private boolean n;
    @Nullable
    private Drawable o;
    @Nullable
    Drawable p;
    private int q;
    private boolean r;
    private ValueAnimator s;
    private long t;
    private int u;
    private AppBarLayout.d v;
    int w;
    private int x;
    @Nullable
    WindowInsetsCompat y;
    private int z;

    /* loaded from: classes2.dex */
    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            return CollapsingToolbarLayout.this.p(windowInsetsCompat);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.q(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* loaded from: classes2.dex */
    private class c implements AppBarLayout.d {
        c() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, int i2) {
            int height;
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.w = i2;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.y;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                com.google.android.material.appbar.a l2 = CollapsingToolbarLayout.l(childAt);
                int i4 = layoutParams.a;
                if (i4 == 1) {
                    l2.f(MathUtils.clamp(-i2, 0, CollapsingToolbarLayout.this.h(childAt)));
                } else if (i4 == 2) {
                    l2.f(Math.round((-i2) * layoutParams.b));
                }
            }
            CollapsingToolbarLayout.this.w();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.p != null && systemWindowInsetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
            }
            int height2 = (CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - systemWindowInsetTop;
            float f2 = height2;
            CollapsingToolbarLayout.this.f4056k.k0(Math.min(1.0f, (height - CollapsingToolbarLayout.this.i()) / f2));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.f4056k.Y(collapsingToolbarLayout3.w + height2);
            CollapsingToolbarLayout.this.f4056k.i0(Math.abs(i2) / f2);
        }
    }

    public CollapsingToolbarLayout(@NonNull Context context) {
        this(context, null);
    }

    private void a(int i2) {
        c();
        ValueAnimator valueAnimator = this.s;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.s = valueAnimator2;
            valueAnimator2.setDuration(this.t);
            this.s.setInterpolator(i2 > this.q ? com.google.android.material.animation.a.c : com.google.android.material.animation.a.f4032d);
            this.s.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.s.cancel();
        }
        this.s.setIntValues(this.q, i2);
        this.s.start();
    }

    private void b(AppBarLayout appBarLayout) {
        if (m()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    private void c() {
        if (this.a) {
            ViewGroup viewGroup = null;
            this.c = null;
            this.f4049d = null;
            int i2 = this.b;
            if (i2 != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i2);
                this.c = viewGroup2;
                if (viewGroup2 != null) {
                    this.f4049d = d(viewGroup2);
                }
            }
            if (this.c == null) {
                int childCount = getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i3);
                    if (n(childAt)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                    i3++;
                }
                this.c = viewGroup;
            }
            v();
            this.a = false;
        }
    }

    @NonNull
    private View d(@NonNull View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return view;
    }

    private static int g(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return view.getMeasuredHeight();
    }

    private static CharSequence k(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (Build.VERSION.SDK_INT < 21 || !(view instanceof android.widget.Toolbar)) {
            return null;
        }
        return ((android.widget.Toolbar) view).getTitle();
    }

    @NonNull
    static com.google.android.material.appbar.a l(@NonNull View view) {
        int i2 = R.id.view_offset_helper;
        com.google.android.material.appbar.a aVar = (com.google.android.material.appbar.a) view.getTag(i2);
        if (aVar == null) {
            com.google.android.material.appbar.a aVar2 = new com.google.android.material.appbar.a(view);
            view.setTag(i2, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private boolean m() {
        return this.x == 1;
    }

    private static boolean n(View view) {
        return (view instanceof Toolbar) || (Build.VERSION.SDK_INT >= 21 && (view instanceof android.widget.Toolbar));
    }

    private boolean o(View view) {
        View view2 = this.f4049d;
        if (view2 == null || view2 == this) {
            if (view == this.c) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    private void r(boolean z) {
        int i2;
        int i3;
        int i4;
        View view = this.f4049d;
        if (view == null) {
            view = this.c;
        }
        int h2 = h(view);
        com.google.android.material.internal.c.a(this, this.f4050e, this.f4055j);
        ViewGroup viewGroup = this.c;
        int i5 = 0;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            i5 = toolbar.getTitleMarginStart();
            i3 = toolbar.getTitleMarginEnd();
            i4 = toolbar.getTitleMarginTop();
            i2 = toolbar.getTitleMarginBottom();
        } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            i5 = toolbar2.getTitleMarginStart();
            i3 = toolbar2.getTitleMarginEnd();
            i4 = toolbar2.getTitleMarginTop();
            i2 = toolbar2.getTitleMarginBottom();
        }
        com.google.android.material.internal.a aVar = this.f4056k;
        Rect rect = this.f4055j;
        int i6 = rect.left + (z ? i3 : i5);
        int i7 = rect.top + h2 + i4;
        int i8 = rect.right;
        if (!z) {
            i5 = i3;
        }
        aVar.Q(i6, i7, i8 - i5, (rect.bottom + h2) - i2);
    }

    private void s() {
        setContentDescription(j());
    }

    private void t(@NonNull Drawable drawable, int i2, int i3) {
        u(drawable, this.c, i2, i3);
    }

    private void u(@NonNull Drawable drawable, @Nullable View view, int i2, int i3) {
        if (m() && view != null && this.m) {
            i3 = view.getBottom();
        }
        drawable.setBounds(0, 0, i2, i3);
    }

    private void v() {
        View view;
        if (!this.m && (view = this.f4050e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f4050e);
            }
        }
        if (!this.m || this.c == null) {
            return;
        }
        if (this.f4050e == null) {
            this.f4050e = new View(getContext());
        }
        if (this.f4050e.getParent() == null) {
            this.c.addView(this.f4050e, -1, -1);
        }
    }

    private void x(int i2, int i3, int i4, int i5, boolean z) {
        View view;
        if (!this.m || (view = this.f4050e) == null) {
            return;
        }
        boolean z2 = ViewCompat.isAttachedToWindow(view) && this.f4050e.getVisibility() == 0;
        this.n = z2;
        if (z2 || z) {
            boolean z3 = ViewCompat.getLayoutDirection(this) == 1;
            r(z3);
            this.f4056k.Z(z3 ? this.f4053h : this.f4051f, this.f4055j.top + this.f4052g, (i4 - i2) - (z3 ? this.f4051f : this.f4053h), (i5 - i3) - this.f4054i);
            this.f4056k.O(z);
        }
    }

    private void y() {
        if (this.c != null && this.m && TextUtils.isEmpty(this.f4056k.D())) {
            setTitle(k(this.c));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        c();
        if (this.c == null && (drawable = this.o) != null && this.q > 0) {
            drawable.mutate().setAlpha(this.q);
            this.o.draw(canvas);
        }
        if (this.m && this.n) {
            if (this.c != null && this.o != null && this.q > 0 && m() && this.f4056k.z() < this.f4056k.A()) {
                int save = canvas.save();
                canvas.clipRect(this.o.getBounds(), Region.Op.DIFFERENCE);
                this.f4056k.m(canvas);
                canvas.restoreToCount(save);
            } else {
                this.f4056k.m(canvas);
            }
        }
        if (this.p == null || this.q <= 0) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.y;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.p.setBounds(0, -this.w, getWidth(), systemWindowInsetTop - this.w);
            this.p.mutate().setAlpha(this.q);
            this.p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z;
        if (this.o == null || this.q <= 0 || !o(view)) {
            z = false;
        } else {
            u(this.o, view, getWidth(), getHeight());
            this.o.mutate().setAlpha(this.q);
            this.o.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j2) || z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.p;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.o;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.a aVar = this.f4056k;
        if (aVar != null) {
            z |= aVar.s0(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: e */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: f */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    final int h(@NonNull View view) {
        return ((getHeight() - l(view).b()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    public int i() {
        int i2 = this.u;
        if (i2 >= 0) {
            return i2 + this.z + this.B;
        }
        WindowInsetsCompat windowInsetsCompat = this.y;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight > 0) {
            return Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight());
        }
        return getHeight() / 3;
    }

    @Nullable
    public CharSequence j() {
        if (this.m) {
            return this.f4056k.D();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            b(appBarLayout);
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows(appBarLayout));
            if (this.v == null) {
                this.v = new c();
            }
            appBarLayout.b(this.v);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.d dVar = this.v;
        if (dVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).w(dVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        WindowInsetsCompat windowInsetsCompat = this.y;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            l(getChildAt(i7)).d();
        }
        x(i2, i3, i4, i5, false);
        y();
        w();
        int childCount3 = getChildCount();
        for (int i8 = 0; i8 < childCount3; i8++) {
            l(getChildAt(i8)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        c();
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        WindowInsetsCompat windowInsetsCompat = this.y;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if ((mode == 0 || this.A) && systemWindowInsetTop > 0) {
            this.z = systemWindowInsetTop;
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, 1073741824));
        }
        if (this.C && this.f4056k.C() > 1) {
            y();
            x(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int B = this.f4056k.B();
            if (B > 1) {
                this.B = Math.round(this.f4056k.x()) * (B - 1);
                super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.B, 1073741824));
            }
        }
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            View view = this.f4049d;
            if (view != null && view != this) {
                setMinimumHeight(g(view));
            } else {
                setMinimumHeight(g(viewGroup));
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.o;
        if (drawable != null) {
            t(drawable, i2, i3);
        }
    }

    WindowInsetsCompat p(@NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.y, windowInsetsCompat2)) {
            this.y = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    void q(int i2) {
        ViewGroup viewGroup;
        if (i2 != this.q) {
            if (this.o != null && (viewGroup = this.c) != null) {
                ViewCompat.postInvalidateOnAnimation(viewGroup);
            }
            this.q = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setCollapsedTitleGravity(int i2) {
        this.f4056k.V(i2);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i2) {
        this.f4056k.S(i2);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.f4056k.W(typeface);
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.o = mutate;
            if (mutate != null) {
                t(mutate, getWidth(), getHeight());
                this.o.setCallback(this);
                this.o.setAlpha(this.q);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(@ColorInt int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(@DrawableRes int i2) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setExpandedTitleColor(@ColorInt int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleGravity(int i2) {
        this.f4056k.e0(i2);
    }

    public void setExpandedTitleMargin(int i2, int i3, int i4, int i5) {
        this.f4051f = i2;
        this.f4052g = i3;
        this.f4053h = i4;
        this.f4054i = i5;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.f4054i = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.f4053h = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.f4051f = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.f4052g = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i2) {
        this.f4056k.b0(i2);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f4056k.d0(colorStateList);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.f4056k.g0(typeface);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraMultilineHeightEnabled(boolean z) {
        this.C = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean z) {
        this.A = z;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHyphenationFrequency(int i2) {
        this.f4056k.l0(i2);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingAdd(float f2) {
        this.f4056k.n0(f2);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float f2) {
        this.f4056k.o0(f2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int i2) {
        this.f4056k.p0(i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean z) {
        this.f4056k.r0(z);
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j2) {
        this.t = j2;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i2) {
        if (this.u != i2) {
            this.u = i2;
            w();
        }
    }

    public void setScrimsShown(boolean z) {
        setScrimsShown(z, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.p = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.p.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.p, ViewCompat.getLayoutDirection(this));
                this.p.setVisible(getVisibility() == 0, false);
                this.p.setCallback(this);
                this.p.setAlpha(this.q);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(@DrawableRes int i2) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f4056k.t0(charSequence);
        s();
    }

    public void setTitleCollapseMode(int i2) {
        this.x = i2;
        boolean m = m();
        this.f4056k.j0(m);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            b((AppBarLayout) parent);
        }
        if (m && this.o == null) {
            setContentScrimColor(this.f4057l.d(getResources().getDimension(R.dimen.design_appbar_elevation)));
        }
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.m) {
            this.m = z;
            s();
            v();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        VdsAgent.onSetViewVisibility(this, i2);
        boolean z = i2 == 0;
        Drawable drawable = this.p;
        if (drawable != null && drawable.isVisible() != z) {
            this.p.setVisible(z, false);
        }
        Drawable drawable2 = this.o;
        if (drawable2 == null || drawable2.isVisible() == z) {
            return;
        }
        this.o.setVisible(z, false);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o || drawable == this.p;
    }

    final void w() {
        if (this.o == null && this.p == null) {
            return;
        }
        setScrimsShown(getHeight() + this.w < i());
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.collapsingToolbarLayoutStyle);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f4056k.U(colorStateList);
    }

    public void setScrimsShown(boolean z, boolean z2) {
        if (this.r != z) {
            if (z2) {
                a(z ? 255 : 0);
            } else {
                q(z ? 255 : 0);
            }
            this.r = z;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public CollapsingToolbarLayout(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.Nullable android.util.AttributeSet r11, int r12) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        int a;
        float b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            this.b = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.a = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            a(obtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public void a(float f2) {
            this.b = f2;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.a = 0;
            this.b = 0.5f;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
            this.b = 0.5f;
        }
    }
}
