package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.p;
import com.google.android.material.shape.i;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
@ViewPager.DecorView
/* loaded from: classes2.dex */
public class TabLayout extends HorizontalScrollView {
    private static final int O = R.style.Widget_Design_TabLayout;
    private static final Pools.Pool<f> P = new Pools.SynchronizedPool(16);
    boolean A;
    boolean B;
    boolean C;
    private com.google.android.material.tabs.b D;
    @Nullable
    private c E;
    private final ArrayList<c> F;
    @Nullable
    private c G;
    @Nullable
    ViewPager H;
    @Nullable
    private PagerAdapter I;
    private DataSetObserver J;
    private g K;
    private b L;
    private boolean M;
    private final Pools.Pool<TabView> N;
    private final ArrayList<f> a;
    @Nullable
    private f b;
    @NonNull
    final SlidingTabIndicator c;

    /* renamed from: d  reason: collision with root package name */
    int f4565d;

    /* renamed from: e  reason: collision with root package name */
    int f4566e;

    /* renamed from: f  reason: collision with root package name */
    int f4567f;

    /* renamed from: g  reason: collision with root package name */
    int f4568g;

    /* renamed from: h  reason: collision with root package name */
    int f4569h;

    /* renamed from: i  reason: collision with root package name */
    ColorStateList f4570i;

    /* renamed from: j  reason: collision with root package name */
    ColorStateList f4571j;

    /* renamed from: k  reason: collision with root package name */
    ColorStateList f4572k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    Drawable f4573l;
    private int m;
    PorterDuff.Mode n;
    float o;
    float p;
    final int q;
    int r;
    private final int s;
    private ValueAnimator scrollAnimator;
    private final int t;
    private final int u;
    private int v;
    int w;
    int x;
    int y;
    int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class SlidingTabIndicator extends LinearLayout {
        ValueAnimator a;
        int b;
        float c;

        /* renamed from: d  reason: collision with root package name */
        private int f4574d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ View a;
            final /* synthetic */ View b;

            a(View view, View view2) {
                this.a = view;
                this.b = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                SlidingTabIndicator.this.g(this.a, this.b, valueAnimator.getAnimatedFraction());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class b extends AnimatorListenerAdapter {
            final /* synthetic */ int a;

            b(int i2) {
                this.a = i2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SlidingTabIndicator.this.b = this.a;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SlidingTabIndicator.this.b = this.a;
            }
        }

        SlidingTabIndicator(Context context) {
            super(context);
            this.b = -1;
            this.f4574d = -1;
            setWillNotDraw(false);
        }

        private void d() {
            View childAt = getChildAt(this.b);
            com.google.android.material.tabs.b bVar = TabLayout.this.D;
            TabLayout tabLayout = TabLayout.this;
            bVar.d(tabLayout, childAt, tabLayout.f4573l);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(View view, View view2, float f2) {
            if (view != null && view.getWidth() > 0) {
                com.google.android.material.tabs.b bVar = TabLayout.this.D;
                TabLayout tabLayout = TabLayout.this;
                bVar.c(tabLayout, view, view2, f2, tabLayout.f4573l);
            } else {
                Drawable drawable = TabLayout.this.f4573l;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.f4573l.getBounds().bottom);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }

        private void h(boolean z, int i2, int i3) {
            View childAt = getChildAt(this.b);
            View childAt2 = getChildAt(i2);
            if (childAt2 == null) {
                d();
                return;
            }
            a aVar = new a(childAt, childAt2);
            if (z) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.a = valueAnimator;
                valueAnimator.setInterpolator(com.google.android.material.animation.a.b);
                valueAnimator.setDuration(i3);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(aVar);
                valueAnimator.addListener(new b(i2));
                valueAnimator.start();
                return;
            }
            this.a.removeAllUpdateListeners();
            this.a.addUpdateListener(aVar);
        }

        void b(int i2, int i3) {
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.a.cancel();
            }
            h(true, i2, i3);
        }

        boolean c() {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (getChildAt(i2).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas canvas) {
            int height = TabLayout.this.f4573l.getBounds().height();
            if (height < 0) {
                height = TabLayout.this.f4573l.getIntrinsicHeight();
            }
            int i2 = TabLayout.this.y;
            int i3 = 0;
            if (i2 == 0) {
                i3 = getHeight() - height;
                height = getHeight();
            } else if (i2 == 1) {
                i3 = (getHeight() - height) / 2;
                height = (getHeight() + height) / 2;
            } else if (i2 != 2) {
                height = i2 != 3 ? 0 : getHeight();
            }
            if (TabLayout.this.f4573l.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.f4573l.getBounds();
                TabLayout.this.f4573l.setBounds(bounds.left, i3, bounds.right, height);
                TabLayout tabLayout = TabLayout.this;
                Drawable drawable = tabLayout.f4573l;
                if (tabLayout.m != 0) {
                    drawable = DrawableCompat.wrap(drawable);
                    if (Build.VERSION.SDK_INT == 21) {
                        drawable.setColorFilter(TabLayout.this.m, PorterDuff.Mode.SRC_IN);
                    } else {
                        DrawableCompat.setTint(drawable, TabLayout.this.m);
                    }
                }
                drawable.draw(canvas);
            }
            super.draw(canvas);
        }

        void e(int i2, float f2) {
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.a.cancel();
            }
            this.b = i2;
            this.c = f2;
            g(getChildAt(i2), getChildAt(this.b + 1), this.c);
        }

        void f(int i2) {
            Rect bounds = TabLayout.this.f4573l.getBounds();
            TabLayout.this.f4573l.setBounds(bounds.left, 0, bounds.right, i2);
            requestLayout();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                h(false, this.b, -1);
            } else {
                d();
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z = true;
            if (tabLayout.w == 1 || tabLayout.z == 2) {
                int childCount = getChildCount();
                int i4 = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    if (childAt.getVisibility() == 0) {
                        i4 = Math.max(i4, childAt.getMeasuredWidth());
                    }
                }
                if (i4 <= 0) {
                    return;
                }
                if (i4 * childCount <= getMeasuredWidth() - (((int) p.c(getContext(), 16)) * 2)) {
                    boolean z2 = false;
                    for (int i6 = 0; i6 < childCount; i6++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                        if (layoutParams.width != i4 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i4;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.w = 0;
                    tabLayout2.T(false);
                }
                if (z) {
                    super.onMeasure(i2, i3);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT >= 23 || this.f4574d == i2) {
                return;
            }
            requestLayout();
            this.f4574d = i2;
        }
    }

    /* loaded from: classes2.dex */
    public final class TabView extends LinearLayout {
        private f a;
        private TextView b;
        private ImageView c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private View f4576d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private BadgeDrawable f4577e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private View f4578f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private TextView f4579g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private ImageView f4580h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private Drawable f4581i;

        /* renamed from: j  reason: collision with root package name */
        private int f4582j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements View.OnLayoutChangeListener {
            final /* synthetic */ View a;

            a(View view) {
                this.a = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                if (this.a.getVisibility() == 0) {
                    TabView.this.v(this.a);
                }
            }
        }

        public TabView(@NonNull Context context) {
            super(context);
            this.f4582j = 2;
            x(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.f4565d, TabLayout.this.f4566e, TabLayout.this.f4567f, TabLayout.this.f4568g);
            setGravity(17);
            setOrientation(!TabLayout.this.A ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        private void f(@Nullable View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        private float g(@NonNull Layout layout, int i2, float f2) {
            return layout.getLineWidth(i2) * (f2 / layout.getPaint().getTextSize());
        }

        private void h(boolean z) {
            setClipChildren(z);
            setClipToPadding(z);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z);
                viewGroup.setClipToPadding(z);
            }
        }

        @NonNull
        private FrameLayout i() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(@NonNull Canvas canvas) {
            Drawable drawable = this.f4581i;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f4581i.draw(canvas);
            }
        }

        @Nullable
        private FrameLayout m(@NonNull View view) {
            if ((view == this.c || view == this.b) && com.google.android.material.badge.a.a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean n() {
            return this.f4577e != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void o() {
            FrameLayout frameLayout;
            if (com.google.android.material.badge.a.a) {
                frameLayout = i();
                addView(frameLayout, 0);
            } else {
                frameLayout = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) frameLayout, false);
            this.c = imageView;
            frameLayout.addView(imageView, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void p() {
            FrameLayout frameLayout;
            if (com.google.android.material.badge.a.a) {
                frameLayout = i();
                addView(frameLayout);
            } else {
                frameLayout = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) frameLayout, false);
            this.b = textView;
            frameLayout.addView(textView);
        }

        private void s(@Nullable View view) {
            if (n() && view != null) {
                h(false);
                com.google.android.material.badge.a.a(this.f4577e, view, m(view));
                this.f4576d = view;
            }
        }

        private void t() {
            if (n()) {
                h(true);
                View view = this.f4576d;
                if (view != null) {
                    com.google.android.material.badge.a.d(this.f4577e, view);
                    this.f4576d = null;
                }
            }
        }

        private void u() {
            f fVar;
            f fVar2;
            if (n()) {
                if (this.f4578f != null) {
                    t();
                } else if (this.c != null && (fVar2 = this.a) != null && fVar2.f() != null) {
                    View view = this.f4576d;
                    ImageView imageView = this.c;
                    if (view != imageView) {
                        t();
                        s(this.c);
                        return;
                    }
                    v(imageView);
                } else if (this.b != null && (fVar = this.a) != null && fVar.h() == 1) {
                    View view2 = this.f4576d;
                    TextView textView = this.b;
                    if (view2 != textView) {
                        t();
                        s(this.b);
                        return;
                    }
                    v(textView);
                } else {
                    t();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v(@NonNull View view) {
            if (n() && view == this.f4576d) {
                com.google.android.material.badge.a.e(this.f4577e, view, m(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARN: Type inference failed for: r2v3, types: [android.graphics.drawable.LayerDrawable] */
        public void x(Context context) {
            int i2 = TabLayout.this.q;
            if (i2 != 0) {
                Drawable drawable = AppCompatResources.getDrawable(context, i2);
                this.f4581i = drawable;
                if (drawable != null && drawable.isStateful()) {
                    this.f4581i.setState(getDrawableState());
                }
            } else {
                this.f4581i = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (TabLayout.this.f4572k != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList a2 = com.google.android.material.g.b.a(TabLayout.this.f4572k);
                if (Build.VERSION.SDK_INT >= 21) {
                    boolean z = TabLayout.this.C;
                    if (z) {
                        gradientDrawable = null;
                    }
                    gradientDrawable = new RippleDrawable(a2, gradientDrawable, z ? null : gradientDrawable2);
                } else {
                    Drawable wrap = DrawableCompat.wrap(gradientDrawable2);
                    DrawableCompat.setTintList(wrap, a2);
                    gradientDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, wrap});
                }
            }
            ViewCompat.setBackground(this, gradientDrawable);
            TabLayout.this.invalidate();
        }

        private void z(@Nullable TextView textView, @Nullable ImageView imageView) {
            f fVar = this.a;
            Drawable mutate = (fVar == null || fVar.f() == null) ? null : DrawableCompat.wrap(this.a.f()).mutate();
            f fVar2 = this.a;
            CharSequence i2 = fVar2 != null ? fVar2.i() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                    VdsAgent.onSetViewVisibility(this, 0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(i2);
            if (textView != null) {
                if (z) {
                    textView.setText(i2);
                    if (this.a.f4586f == 1) {
                        textView.setVisibility(0);
                        VdsAgent.onSetViewVisibility(textView, 0);
                    } else {
                        textView.setVisibility(8);
                        VdsAgent.onSetViewVisibility(textView, 8);
                    }
                    setVisibility(0);
                    VdsAgent.onSetViewVisibility(this, 0);
                } else {
                    textView.setVisibility(8);
                    VdsAgent.onSetViewVisibility(textView, 8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int c = (z && imageView.getVisibility() == 0) ? (int) p.c(getContext(), 8) : 0;
                if (TabLayout.this.A) {
                    if (c != MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, c);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (c != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = c;
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            f fVar3 = this.a;
            CharSequence charSequence = fVar3 != null ? fVar3.c : null;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < 21 || i3 > 23) {
                if (!z) {
                    i2 = charSequence;
                }
                TooltipCompat.setTooltipText(this, i2);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f4581i;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.f4581i.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int k() {
            View[] viewArr = {this.b, this.c, this.f4578f};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getTop()) : view.getTop();
                    i2 = z ? Math.max(i2, view.getBottom()) : view.getBottom();
                    z = true;
                }
            }
            return i2 - i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int l() {
            View[] viewArr = {this.b, this.c, this.f4578f};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getLeft()) : view.getLeft();
                    i2 = z ? Math.max(i2, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i2 - i3;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.f4577e;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                accessibilityNodeInfo.setContentDescription(((Object) contentDescription) + ", " + ((Object) this.f4577e.f()));
            }
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.a.g(), 1, false, isSelected()));
            if (isSelected()) {
                wrap.setClickable(false);
                wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            wrap.setRoleDescription(getResources().getString(R.string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int B = TabLayout.this.B();
            if (B > 0 && (mode == 0 || size > B)) {
                i2 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.r, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.b != null) {
                float f2 = TabLayout.this.o;
                int i4 = this.f4582j;
                ImageView imageView = this.c;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = TabLayout.this.p;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.b.getTextSize();
                int lineCount = this.b.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.b);
                int i5 = (f2 > textSize ? 1 : (f2 == textSize ? 0 : -1));
                if (i5 != 0 || (maxLines >= 0 && i4 != maxLines)) {
                    if (TabLayout.this.z == 1 && i5 > 0 && lineCount == 1 && ((layout = this.b.getLayout()) == null || g(layout, 0, f2) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.b.setTextSize(0, f2);
                        this.b.setMaxLines(i4);
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            VdsAgent.clickOn(this);
            boolean performClick = super.performClick();
            if (this.a != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.a.l();
                return true;
            }
            return performClick;
        }

        void q() {
            r(null);
            setSelected(false);
        }

        void r(@Nullable f fVar) {
            if (fVar != this.a) {
                this.a = fVar;
                w();
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.b;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.c;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f4578f;
            if (view != null) {
                view.setSelected(z);
            }
        }

        final void w() {
            f fVar = this.a;
            Drawable drawable = null;
            View e2 = fVar != null ? fVar.e() : null;
            if (e2 != null) {
                ViewParent parent = e2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(e2);
                    }
                    addView(e2);
                }
                this.f4578f = e2;
                TextView textView = this.b;
                if (textView != null) {
                    textView.setVisibility(8);
                    VdsAgent.onSetViewVisibility(textView, 8);
                }
                ImageView imageView = this.c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) e2.findViewById(16908308);
                this.f4579g = textView2;
                if (textView2 != null) {
                    this.f4582j = TextViewCompat.getMaxLines(textView2);
                }
                this.f4580h = (ImageView) e2.findViewById(16908294);
            } else {
                View view = this.f4578f;
                if (view != null) {
                    removeView(view);
                    this.f4578f = null;
                }
                this.f4579g = null;
                this.f4580h = null;
            }
            if (this.f4578f == null) {
                if (this.c == null) {
                    o();
                }
                if (fVar != null && fVar.f() != null) {
                    drawable = DrawableCompat.wrap(fVar.f()).mutate();
                }
                if (drawable != null) {
                    DrawableCompat.setTintList(drawable, TabLayout.this.f4571j);
                    PorterDuff.Mode mode = TabLayout.this.n;
                    if (mode != null) {
                        DrawableCompat.setTintMode(drawable, mode);
                    }
                }
                if (this.b == null) {
                    p();
                    this.f4582j = TextViewCompat.getMaxLines(this.b);
                }
                TextViewCompat.setTextAppearance(this.b, TabLayout.this.f4569h);
                ColorStateList colorStateList = TabLayout.this.f4570i;
                if (colorStateList != null) {
                    this.b.setTextColor(colorStateList);
                }
                z(this.b, this.c);
                u();
                f(this.c);
                f(this.b);
            } else {
                TextView textView3 = this.f4579g;
                if (textView3 != null || this.f4580h != null) {
                    z(textView3, this.f4580h);
                }
            }
            if (fVar != null && !TextUtils.isEmpty(fVar.c)) {
                setContentDescription(fVar.c);
            }
            setSelected(fVar != null && fVar.j());
        }

        final void y() {
            setOrientation(!TabLayout.this.A ? 1 : 0);
            TextView textView = this.f4579g;
            if (textView == null && this.f4580h == null) {
                z(this.b, this.c);
            } else {
                z(textView, this.f4580h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements ViewPager.OnAdapterChangeListener {
        private boolean a;

        b() {
        }

        void a(boolean z) {
            this.a = z;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.H == viewPager) {
                tabLayout.O(pagerAdapter2, this.a);
            }
        }
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface c<T extends f> {
        void onTabReselected(T t);

        void onTabSelected(T t);

        void onTabUnselected(T t);
    }

    /* loaded from: classes2.dex */
    public interface d extends c<f> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e extends DataSetObserver {
        e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.G();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.G();
        }
    }

    /* loaded from: classes2.dex */
    public static class f {
        @Nullable
        private Drawable a;
        @Nullable
        private CharSequence b;
        @Nullable
        private CharSequence c;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private View f4585e;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public TabLayout f4587g;
        @NonNull

        /* renamed from: h  reason: collision with root package name */
        public TabView f4588h;

        /* renamed from: d  reason: collision with root package name */
        private int f4584d = -1;

        /* renamed from: f  reason: collision with root package name */
        private int f4586f = 1;

        /* renamed from: i  reason: collision with root package name */
        private int f4589i = -1;

        @Nullable
        public View e() {
            return this.f4585e;
        }

        @Nullable
        public Drawable f() {
            return this.a;
        }

        public int g() {
            return this.f4584d;
        }

        public int h() {
            return this.f4586f;
        }

        @Nullable
        public CharSequence i() {
            return this.b;
        }

        public boolean j() {
            TabLayout tabLayout = this.f4587g;
            if (tabLayout != null) {
                return tabLayout.y() == this.f4584d;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void k() {
            this.f4587g = null;
            this.f4588h = null;
            this.a = null;
            this.f4589i = -1;
            this.b = null;
            this.c = null;
            this.f4584d = -1;
            this.f4585e = null;
        }

        public void l() {
            TabLayout tabLayout = this.f4587g;
            if (tabLayout != null) {
                tabLayout.M(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public f m(@Nullable CharSequence charSequence) {
            this.c = charSequence;
            s();
            return this;
        }

        @NonNull
        public f n(@LayoutRes int i2) {
            o(LayoutInflater.from(this.f4588h.getContext()).inflate(i2, (ViewGroup) this.f4588h, false));
            return this;
        }

        @NonNull
        public f o(@Nullable View view) {
            this.f4585e = view;
            s();
            return this;
        }

        @NonNull
        public f p(@Nullable Drawable drawable) {
            this.a = drawable;
            TabLayout tabLayout = this.f4587g;
            if (tabLayout.w == 1 || tabLayout.z == 2) {
                tabLayout.T(true);
            }
            s();
            if (com.google.android.material.badge.a.a && this.f4588h.n() && this.f4588h.f4577e.isVisible()) {
                this.f4588h.invalidate();
            }
            return this;
        }

        void q(int i2) {
            this.f4584d = i2;
        }

        @NonNull
        public f r(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(charSequence)) {
                this.f4588h.setContentDescription(charSequence);
            }
            this.b = charSequence;
            s();
            return this;
        }

        void s() {
            TabView tabView = this.f4588h;
            if (tabView != null) {
                tabView.w();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class g implements ViewPager.OnPageChangeListener {
        @NonNull
        private final WeakReference<TabLayout> a;
        private int b;
        private int c;

        public g(TabLayout tabLayout) {
            this.a = new WeakReference<>(tabLayout);
        }

        void a() {
            this.c = 0;
            this.b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            this.b = this.c;
            this.c = i2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null) {
                int i4 = this.c;
                boolean z = false;
                tabLayout.setScrollPosition(i2, f2, i4 != 2 || this.b == 1, (i4 == 2 && this.b == 0) ? true : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout == null || tabLayout.y() == i2 || i2 >= tabLayout.A()) {
                return;
            }
            int i3 = this.c;
            tabLayout.N(tabLayout.z(i2), i3 == 0 || (i3 == 2 && this.b == 0));
        }
    }

    /* loaded from: classes2.dex */
    public static class h implements d {
        private final ViewPager a;

        public h(ViewPager viewPager) {
            this.a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(f fVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(@NonNull f fVar) {
            this.a.setCurrentItem(fVar.g());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(f fVar) {
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, null);
    }

    private int C() {
        int i2 = this.s;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.z;
        if (i3 == 0 || i3 == 2) {
            return this.u;
        }
        return 0;
    }

    private int D() {
        return Math.max(0, ((this.c.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void L(int i2) {
        TabView tabView = (TabView) this.c.getChildAt(i2);
        this.c.removeViewAt(i2);
        if (tabView != null) {
            tabView.q();
            this.N.release(tabView);
        }
        requestLayout();
    }

    private void P(int i2) {
        int childCount = this.c.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.c.getChildAt(i3);
                boolean z = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z = false;
                }
                childAt.setActivated(z);
                i3++;
            }
        }
    }

    private void Q(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.H;
        if (viewPager2 != null) {
            g gVar = this.K;
            if (gVar != null) {
                viewPager2.removeOnPageChangeListener(gVar);
            }
            b bVar = this.L;
            if (bVar != null) {
                this.H.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.G;
        if (cVar != null) {
            J(cVar);
            this.G = null;
        }
        if (viewPager != null) {
            this.H = viewPager;
            if (this.K == null) {
                this.K = new g(this);
            }
            this.K.a();
            viewPager.addOnPageChangeListener(this.K);
            h hVar = new h(viewPager);
            this.G = hVar;
            c(hVar);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                O(adapter, z);
            }
            if (this.L == null) {
                this.L = new b();
            }
            this.L.a(z);
            viewPager.addOnAdapterChangeListener(this.L);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.H = null;
            O(null, false);
        }
        this.M = z2;
    }

    private void R() {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.a.get(i2).s();
        }
    }

    private void S(@NonNull LinearLayout.LayoutParams layoutParams) {
        if (this.z == 1 && this.w == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private void h(@NonNull TabItem tabItem) {
        f F = F();
        CharSequence charSequence = tabItem.a;
        if (charSequence != null) {
            F.r(charSequence);
        }
        Drawable drawable = tabItem.b;
        if (drawable != null) {
            F.p(drawable);
        }
        int i2 = tabItem.c;
        if (i2 != 0) {
            F.n(i2);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            F.m(tabItem.getContentDescription());
        }
        e(F);
    }

    private void i(@NonNull f fVar) {
        TabView tabView = fVar.f4588h;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.c.addView(tabView, fVar.g(), q());
    }

    private void j(View view) {
        if (view instanceof TabItem) {
            h((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void k(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.c.c()) {
            int scrollX = getScrollX();
            int n = n(i2, 0.0f);
            if (scrollX != n) {
                w();
                this.scrollAnimator.setIntValues(scrollX, n);
                this.scrollAnimator.start();
            }
            this.c.b(i2, this.x);
            return;
        }
        setScrollPosition(i2, 0.0f, true);
    }

    private void l(int i2) {
        if (i2 == 0) {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i2 == 1) {
            this.c.setGravity(1);
            return;
        } else if (i2 != 2) {
            return;
        }
        this.c.setGravity(GravityCompat.START);
    }

    private void m() {
        int i2 = this.z;
        ViewCompat.setPaddingRelative(this.c, (i2 == 0 || i2 == 2) ? Math.max(0, this.v - this.f4565d) : 0, 0, 0, 0);
        int i3 = this.z;
        if (i3 == 0) {
            l(this.w);
        } else if (i3 == 1 || i3 == 2) {
            if (this.w == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.c.setGravity(1);
        }
        T(true);
    }

    private int n(int i2, float f2) {
        int i3 = this.z;
        if (i3 == 0 || i3 == 2) {
            View childAt = this.c.getChildAt(i2);
            int i4 = i2 + 1;
            View childAt2 = i4 < this.c.getChildCount() ? this.c.getChildAt(i4) : null;
            int width = childAt != null ? childAt.getWidth() : 0;
            int width2 = childAt2 != null ? childAt2.getWidth() : 0;
            int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
            int i5 = (int) ((width + width2) * 0.5f * f2);
            return ViewCompat.getLayoutDirection(this) == 0 ? left + i5 : left - i5;
        }
        return 0;
    }

    private void o(@NonNull f fVar, int i2) {
        fVar.q(i2);
        this.a.add(i2, fVar);
        int size = this.a.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            }
            this.a.get(i2).q(i2);
        }
    }

    @NonNull
    private static ColorStateList p(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    @NonNull
    private LinearLayout.LayoutParams q() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        S(layoutParams);
        return layoutParams;
    }

    @NonNull
    private TabView s(@NonNull f fVar) {
        Pools.Pool<TabView> pool = this.N;
        TabView acquire = pool != null ? pool.acquire() : null;
        if (acquire == null) {
            acquire = new TabView(getContext());
        }
        acquire.r(fVar);
        acquire.setFocusable(true);
        acquire.setMinimumWidth(C());
        if (TextUtils.isEmpty(fVar.c)) {
            acquire.setContentDescription(fVar.b);
        } else {
            acquire.setContentDescription(fVar.c);
        }
        return acquire;
    }

    private void t(@NonNull f fVar) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).onTabReselected(fVar);
        }
    }

    private void u(@NonNull f fVar) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).onTabSelected(fVar);
        }
    }

    private void v(@NonNull f fVar) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).onTabUnselected(fVar);
        }
    }

    private void w() {
        if (this.scrollAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.scrollAnimator = valueAnimator;
            valueAnimator.setInterpolator(com.google.android.material.animation.a.b);
            this.scrollAnimator.setDuration(this.x);
            this.scrollAnimator.addUpdateListener(new a());
        }
    }

    @Dimension(unit = 0)
    private int x() {
        int size = this.a.size();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                f fVar = this.a.get(i2);
                if (fVar != null && fVar.f() != null && !TextUtils.isEmpty(fVar.i())) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z || this.A) ? 48 : 72;
    }

    public int A() {
        return this.a.size();
    }

    int B() {
        return this.r;
    }

    public boolean E() {
        return this.B;
    }

    @NonNull
    public f F() {
        f r = r();
        r.f4587g = this;
        r.f4588h = s(r);
        if (r.f4589i != -1) {
            r.f4588h.setId(r.f4589i);
        }
        return r;
    }

    void G() {
        int currentItem;
        I();
        PagerAdapter pagerAdapter = this.I;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                f F = F();
                F.r(this.I.getPageTitle(i2));
                g(F, false);
            }
            ViewPager viewPager = this.H;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == y() || currentItem >= A()) {
                return;
            }
            M(z(currentItem));
        }
    }

    protected boolean H(f fVar) {
        return P.release(fVar);
    }

    public void I() {
        for (int childCount = this.c.getChildCount() - 1; childCount >= 0; childCount--) {
            L(childCount);
        }
        Iterator<f> it = this.a.iterator();
        while (it.hasNext()) {
            f next = it.next();
            it.remove();
            next.k();
            H(next);
        }
        this.b = null;
    }

    @Deprecated
    public void J(@Nullable c cVar) {
        this.F.remove(cVar);
    }

    public void K(@NonNull d dVar) {
        J(dVar);
    }

    public void M(@Nullable f fVar) {
        N(fVar, true);
    }

    public void N(@Nullable f fVar, boolean z) {
        f fVar2 = this.b;
        if (fVar2 == fVar) {
            if (fVar2 != null) {
                t(fVar);
                k(fVar.g());
                return;
            }
            return;
        }
        int g2 = fVar != null ? fVar.g() : -1;
        if (z) {
            if ((fVar2 == null || fVar2.g() == -1) && g2 != -1) {
                setScrollPosition(g2, 0.0f, true);
            } else {
                k(g2);
            }
            if (g2 != -1) {
                P(g2);
            }
        }
        this.b = fVar;
        if (fVar2 != null) {
            v(fVar2);
        }
        if (fVar != null) {
            u(fVar);
        }
    }

    void O(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.I;
        if (pagerAdapter2 != null && (dataSetObserver = this.J) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.I = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.J == null) {
                this.J = new e();
            }
            pagerAdapter.registerDataSetObserver(this.J);
        }
        G();
    }

    void T(boolean z) {
        for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
            View childAt = this.c.getChildAt(i2);
            childAt.setMinimumWidth(C());
            S((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        j(view);
    }

    @Deprecated
    public void c(@Nullable c cVar) {
        if (this.F.contains(cVar)) {
            return;
        }
        this.F.add(cVar);
    }

    public void d(@NonNull d dVar) {
        c(dVar);
    }

    public void e(@NonNull f fVar) {
        g(fVar, this.a.isEmpty());
    }

    public void f(@NonNull f fVar, int i2, boolean z) {
        if (fVar.f4587g == this) {
            o(fVar, i2);
            i(fVar);
            if (z) {
                fVar.l();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void g(@NonNull f fVar, boolean z) {
        f(fVar, this.a.size(), z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.e(this);
        if (this.H == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                Q((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.M) {
            setupWithViewPager(null);
            this.M = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
            View childAt = this.c.getChildAt(i2);
            if (childAt instanceof TabView) {
                ((TabView) childAt).j(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, A(), false, 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
        if (r0 != 2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007e, code lost:
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0080, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008a, code lost:
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L25;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.x()
            float r0 = com.google.android.material.internal.p.c(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.t
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.p.c(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.r = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Lad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.z
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto L8d
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L8d
        L80:
            r4 = 1
            goto L8d
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L8d
            goto L80
        L8d:
            if (r4 == 0) goto Lad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = android.widget.HorizontalScrollView.getChildMeasureSpec(r8, r0, r1)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    protected f r() {
        f acquire = P.acquire();
        return acquire == null ? new f() : acquire;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        i.d(this, f2);
    }

    public void setInlineLabel(boolean z) {
        if (this.A != z) {
            this.A = z;
            for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
                View childAt = this.c.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).y();
                }
            }
            m();
        }
    }

    public void setInlineLabelResource(@BoolRes int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    public void setScrollPosition(int i2, float f2, boolean z) {
        setScrollPosition(i2, f2, z, true);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (this.f4573l != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.f4573l = drawable;
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i2) {
        this.m = i2;
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.y != i2) {
            this.y = i2;
            ViewCompat.postInvalidateOnAnimation(this.c);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.c.f(i2);
    }

    public void setTabGravity(int i2) {
        if (this.w != i2) {
            this.w = i2;
            m();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f4571j != colorStateList) {
            this.f4571j = colorStateList;
            R();
        }
    }

    public void setTabIconTintResource(@ColorRes int i2) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setTabIndicatorAnimationMode(int i2) {
        if (i2 == 0) {
            this.D = new com.google.android.material.tabs.b();
        } else if (i2 == 1) {
            this.D = new com.google.android.material.tabs.a();
        } else {
            throw new IllegalArgumentException(i2 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.B = z;
        ViewCompat.postInvalidateOnAnimation(this.c);
    }

    public void setTabMode(int i2) {
        if (i2 != this.z) {
            this.z = i2;
            m();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f4572k != colorStateList) {
            this.f4572k = colorStateList;
            for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
                View childAt = this.c.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).x(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i2) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.f4570i != colorStateList) {
            this.f4570i = colorStateList;
            R();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        O(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.C != z) {
            this.C = z;
            for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
                View childAt = this.c.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).x(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return D() > 0;
    }

    public int y() {
        f fVar = this.b;
        if (fVar != null) {
            return fVar.g();
        }
        return -1;
    }

    @Nullable
    public f z(int i2) {
        if (i2 < 0 || i2 >= A()) {
            return null;
        }
        return this.a.get(i2);
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        j(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c cVar) {
        c cVar2 = this.E;
        if (cVar2 != null) {
            J(cVar2);
        }
        this.E = cVar;
        if (cVar != null) {
            c(cVar);
        }
    }

    public void setScrollPosition(int i2, float f2, boolean z, boolean z2) {
        int round = Math.round(i2 + f2);
        if (round < 0 || round >= this.c.getChildCount()) {
            return;
        }
        if (z2) {
            this.c.e(i2, f2);
        }
        ValueAnimator valueAnimator = this.scrollAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.scrollAnimator.cancel();
        }
        scrollTo(n(i2, f2), 0);
        if (z) {
            P(round);
        }
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z) {
        Q(viewPager, z, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TabLayout(@androidx.annotation.NonNull android.content.Context r12, @androidx.annotation.Nullable android.util.AttributeSet r13, int r14) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        j(view);
    }

    public void setSelectedTabIndicator(@DrawableRes int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        j(view);
    }

    public void setTabTextColors(int i2, int i3) {
        setTabTextColors(p(i2, i3));
    }
}
