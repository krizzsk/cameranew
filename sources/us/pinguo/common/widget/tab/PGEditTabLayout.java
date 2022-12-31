package us.pinguo.common.widget.tab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.internal.p;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.common.widget.tab.PGEditTabLayout;
@ViewPager.DecorView
/* loaded from: classes4.dex */
public class PGEditTabLayout extends HorizontalScrollView {
    private static final Pools.Pool<f> Q = new Pools.SynchronizedPool(16);
    boolean A;
    boolean B;
    private c C;
    private final ArrayList<c> D;
    private c E;
    private ValueAnimator F;
    ViewPager G;
    private PagerAdapter H;
    private DataSetObserver I;
    public g J;
    private b K;
    private boolean L;
    private final Pools.Pool<TabView> M;
    private int N;
    private int O;
    private boolean P;
    private final ArrayList<f> a;
    private f b;
    private final RectF c;

    /* renamed from: d  reason: collision with root package name */
    private final SlidingTabIndicator f10025d;

    /* renamed from: e  reason: collision with root package name */
    int f10026e;

    /* renamed from: f  reason: collision with root package name */
    int f10027f;

    /* renamed from: g  reason: collision with root package name */
    int f10028g;

    /* renamed from: h  reason: collision with root package name */
    int f10029h;

    /* renamed from: i  reason: collision with root package name */
    int f10030i;

    /* renamed from: j  reason: collision with root package name */
    ColorStateList f10031j;

    /* renamed from: k  reason: collision with root package name */
    ColorStateList f10032k;

    /* renamed from: l  reason: collision with root package name */
    ColorStateList f10033l;
    @Nullable
    Drawable m;
    PorterDuff.Mode n;
    float o;
    float p;
    final int q;
    int r;
    private final int s;
    private final int t;
    private int u;
    int v;
    int w;
    int x;
    int y;
    boolean z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class SlidingTabIndicator extends LinearLayout {
        private int a;
        private final Paint b;
        private final GradientDrawable c;

        /* renamed from: d  reason: collision with root package name */
        int f10034d;

        /* renamed from: e  reason: collision with root package name */
        float f10035e;

        /* renamed from: f  reason: collision with root package name */
        private int f10036f;

        /* renamed from: g  reason: collision with root package name */
        private int f10037g;

        /* renamed from: h  reason: collision with root package name */
        private int f10038h;

        /* renamed from: i  reason: collision with root package name */
        private ValueAnimator f10039i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a extends AnimatorListenerAdapter {
            final /* synthetic */ int a;

            a(int i2) {
                this.a = i2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SlidingTabIndicator slidingTabIndicator = SlidingTabIndicator.this;
                slidingTabIndicator.f10034d = this.a;
                slidingTabIndicator.f10035e = 0.0f;
            }
        }

        SlidingTabIndicator(Context context) {
            super(context);
            this.f10034d = -1;
            this.f10036f = -1;
            this.f10037g = -1;
            this.f10038h = -1;
            setWillNotDraw(false);
            this.b = new Paint();
            this.c = new GradientDrawable();
        }

        private void b(TabView tabView, RectF rectF) {
            int f2 = tabView.f();
            if (f2 < PGEditTabLayout.this.z(24)) {
                f2 = PGEditTabLayout.this.z(24);
            }
            int left = (tabView.getLeft() + tabView.getRight()) / 2;
            int i2 = f2 / 2;
            rectF.set(left - i2, 0.0f, left + i2, 0.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void e(int i2, int i3, int i4, int i5, ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            f(com.google.android.material.animation.a.c(i2, i3, animatedFraction), com.google.android.material.animation.a.c(i4, i5, animatedFraction));
        }

        private void j() {
            int i2;
            View childAt = getChildAt(this.f10034d);
            int i3 = -1;
            if (childAt == null || childAt.getWidth() <= 0) {
                i2 = -1;
            } else {
                i3 = childAt.getLeft();
                int right = childAt.getRight();
                PGEditTabLayout pGEditTabLayout = PGEditTabLayout.this;
                if (!pGEditTabLayout.A && (childAt instanceof TabView)) {
                    b((TabView) childAt, pGEditTabLayout.c);
                    right = (int) PGEditTabLayout.this.c.right;
                    i3 = (int) PGEditTabLayout.this.c.left;
                }
                if (this.f10035e <= 0.0f || this.f10034d >= getChildCount() - 1) {
                    i2 = right;
                } else {
                    View childAt2 = getChildAt(this.f10034d + 1);
                    int left = childAt2.getLeft();
                    int right2 = childAt2.getRight();
                    PGEditTabLayout pGEditTabLayout2 = PGEditTabLayout.this;
                    if (!pGEditTabLayout2.A && (childAt2 instanceof TabView)) {
                        b((TabView) childAt2, pGEditTabLayout2.c);
                        left = (int) PGEditTabLayout.this.c.left;
                        right2 = (int) PGEditTabLayout.this.c.right;
                    }
                    float f2 = this.f10035e;
                    i3 = (int) ((left * f2) + ((1.0f - f2) * i3));
                    i2 = (int) ((right2 * f2) + ((1.0f - f2) * right));
                }
            }
            f(i3, i2);
        }

        void a(int i2, int i3) {
            ValueAnimator valueAnimator = this.f10039i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f10039i.cancel();
            }
            View childAt = getChildAt(i2);
            if (childAt == null) {
                j();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            PGEditTabLayout pGEditTabLayout = PGEditTabLayout.this;
            if (!pGEditTabLayout.A && (childAt instanceof TabView)) {
                b((TabView) childAt, pGEditTabLayout.c);
                left = (int) PGEditTabLayout.this.c.left;
                right = (int) PGEditTabLayout.this.c.right;
            }
            final int i4 = left;
            final int i5 = right;
            final int i6 = this.f10037g;
            final int i7 = this.f10038h;
            if (i6 == i4 && i7 == i5) {
                return;
            }
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f10039i = valueAnimator2;
            valueAnimator2.setInterpolator(com.google.android.material.animation.a.b);
            valueAnimator2.setDuration(i3);
            valueAnimator2.setFloatValues(0.0f, 1.0f);
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.common.widget.tab.j
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    PGEditTabLayout.SlidingTabIndicator.this.e(i6, i4, i7, i5, valueAnimator3);
                }
            });
            valueAnimator2.addListener(new a(i2));
            valueAnimator2.start();
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
        public void draw(Canvas canvas) {
            int i2;
            Drawable drawable = PGEditTabLayout.this.m;
            int i3 = 0;
            int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
            int i4 = this.a;
            if (i4 >= 0) {
                intrinsicHeight = i4;
            }
            int i5 = PGEditTabLayout.this.x;
            if (i5 == 0) {
                i3 = (getHeight() - intrinsicHeight) - PGEditTabLayout.this.N;
                intrinsicHeight = getHeight() - PGEditTabLayout.this.N;
            } else if (i5 == 1) {
                i3 = (getHeight() - intrinsicHeight) / 2;
                intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
            } else if (i5 != 2) {
                intrinsicHeight = i5 != 3 ? 0 : getHeight();
            }
            if (PGEditTabLayout.this.P && (i2 = this.f10037g) >= 0 && this.f10038h > i2) {
                int i6 = PGEditTabLayout.this.O;
                int i7 = this.f10038h;
                int i8 = this.f10037g;
                int i9 = i7 - i8;
                if (i9 >= i6) {
                    i8 += (i9 - i6) / 2;
                    i7 = i8 + i6;
                }
                if (PGEditTabLayout.this.b != null) {
                    i8 -= PGEditTabLayout.this.b.f10054k;
                    i7 -= PGEditTabLayout.this.b.f10054k;
                }
                Drawable drawable2 = PGEditTabLayout.this.m;
                if (drawable2 == null) {
                    drawable2 = this.c;
                }
                Drawable wrap = DrawableCompat.wrap(drawable2);
                wrap.setBounds(i8, i3, i7, intrinsicHeight);
                Paint paint = this.b;
                if (paint != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        wrap.setColorFilter(paint.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        DrawableCompat.setTint(wrap, paint.getColor());
                    }
                }
                wrap.draw(canvas);
            }
            super.draw(canvas);
        }

        void f(int i2, int i3) {
            if (i2 == this.f10037g && i3 == this.f10038h) {
                return;
            }
            this.f10037g = i2;
            this.f10038h = i3;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        void g(int i2, float f2) {
            ValueAnimator valueAnimator = this.f10039i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f10039i.cancel();
            }
            this.f10034d = i2;
            this.f10035e = f2;
            j();
        }

        void h(int i2) {
            if (this.b.getColor() != i2) {
                this.b.setColor(i2);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void i(int i2) {
            if (this.a != i2) {
                this.a = i2;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.f10039i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f10039i.cancel();
                a(this.f10034d, Math.round((1.0f - this.f10039i.getAnimatedFraction()) * ((float) this.f10039i.getDuration())));
                return;
            }
            j();
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                PGEditTabLayout pGEditTabLayout = PGEditTabLayout.this;
                boolean z = true;
                if (pGEditTabLayout.y == 1 && pGEditTabLayout.v == 1) {
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
                    if (i4 * childCount > getMeasuredWidth() - (PGEditTabLayout.this.z(16) * 2)) {
                        PGEditTabLayout pGEditTabLayout2 = PGEditTabLayout.this;
                        pGEditTabLayout2.v = 0;
                        pGEditTabLayout2.Y(false);
                    } else {
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
                    }
                    if (z) {
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT >= 23 || this.f10036f == i2) {
                return;
            }
            requestLayout();
            this.f10036f = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class TabView extends LinearLayout {
        private f a;
        private TextView b;
        private ImageView c;

        /* renamed from: d  reason: collision with root package name */
        private View f10041d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f10042e;

        /* renamed from: f  reason: collision with root package name */
        private ImageView f10043f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private Drawable f10044g;

        /* renamed from: h  reason: collision with root package name */
        private int f10045h;

        public TabView(Context context) {
            super(context);
            this.f10045h = 2;
            j(context);
            ViewCompat.setPaddingRelative(this, PGEditTabLayout.this.f10026e, PGEditTabLayout.this.f10027f, PGEditTabLayout.this.f10028g, PGEditTabLayout.this.f10029h);
            setGravity(17);
            setOrientation(!PGEditTabLayout.this.z ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        private float d(Layout layout, int i2, float f2) {
            return layout.getLineWidth(i2) * (f2 / layout.getPaint().getTextSize());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(Canvas canvas) {
            Drawable drawable = this.f10044g;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f10044g.draw(canvas);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int f() {
            View[] viewArr = {this.b, this.c, this.f10041d};
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

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARN: Type inference failed for: r2v3, types: [android.graphics.drawable.LayerDrawable] */
        public void j(Context context) {
            int i2 = PGEditTabLayout.this.q;
            if (i2 != 0) {
                Drawable drawable = AppCompatResources.getDrawable(context, i2);
                this.f10044g = drawable;
                if (drawable != null && drawable.isStateful()) {
                    this.f10044g.setState(getDrawableState());
                }
            } else {
                this.f10044g = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (PGEditTabLayout.this.f10033l != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList a = com.google.android.material.g.b.a(PGEditTabLayout.this.f10033l);
                if (Build.VERSION.SDK_INT >= 21) {
                    boolean z = PGEditTabLayout.this.B;
                    if (z) {
                        gradientDrawable = null;
                    }
                    gradientDrawable = new RippleDrawable(a, gradientDrawable, z ? null : gradientDrawable2);
                } else {
                    Drawable wrap = DrawableCompat.wrap(gradientDrawable2);
                    DrawableCompat.setTintList(wrap, a);
                    gradientDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, wrap});
                }
            }
            ViewCompat.setBackground(this, gradientDrawable);
            PGEditTabLayout.this.invalidate();
        }

        private void l(@Nullable TextView textView, @Nullable ImageView imageView) {
            f fVar = this.a;
            Drawable mutate = (fVar == null || fVar.g() == null) ? null : DrawableCompat.wrap(this.a.g()).mutate();
            f fVar2 = this.a;
            CharSequence k2 = fVar2 != null ? fVar2.k() : null;
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
            boolean z = !TextUtils.isEmpty(k2);
            if (textView != null) {
                if (z) {
                    textView.setText(k2);
                    textView.setVisibility(0);
                    VdsAgent.onSetViewVisibility(textView, 0);
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
                int z2 = (z && imageView.getVisibility() == 0) ? PGEditTabLayout.this.z(8) : 0;
                if (PGEditTabLayout.this.z) {
                    if (z2 != MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, z2);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (z2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = z2;
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            f fVar3 = this.a;
            TooltipCompat.setTooltipText(this, z ? null : fVar3 != null ? fVar3.f10047d : null);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f10044g;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.f10044g.setState(drawableState);
            }
            if (z) {
                invalidate();
                PGEditTabLayout.this.invalidate();
            }
        }

        void g() {
            h(null);
            setSelected(false);
        }

        void h(@Nullable f fVar) {
            if (fVar != this.a) {
                this.a = fVar;
                i();
            }
        }

        final void i() {
            f fVar = this.a;
            Drawable drawable = null;
            View f2 = fVar != null ? fVar.f() : null;
            if (f2 != null) {
                ViewParent parent = f2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(f2);
                    }
                    addView(f2);
                }
                this.f10041d = f2;
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
                TextView textView2 = (TextView) f2.findViewById(16908308);
                this.f10042e = textView2;
                if (textView2 != null) {
                    this.f10045h = TextViewCompat.getMaxLines(textView2);
                }
                this.f10043f = (ImageView) f2.findViewById(16908294);
            } else {
                View view = this.f10041d;
                if (view != null) {
                    removeView(view);
                    this.f10041d = null;
                }
                this.f10042e = null;
                this.f10043f = null;
            }
            boolean z = false;
            if (this.f10041d == null) {
                if (this.c == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    addView(imageView2, 0);
                    this.c = imageView2;
                }
                if (fVar != null && fVar.g() != null) {
                    drawable = DrawableCompat.wrap(fVar.g()).mutate();
                }
                if (drawable != null) {
                    DrawableCompat.setTintList(drawable, PGEditTabLayout.this.f10032k);
                    PorterDuff.Mode mode = PGEditTabLayout.this.n;
                    if (mode != null) {
                        DrawableCompat.setTintMode(drawable, mode);
                    }
                }
                if (this.b == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    addView(textView3);
                    this.b = textView3;
                    this.f10045h = TextViewCompat.getMaxLines(textView3);
                }
                TextViewCompat.setTextAppearance(this.b, PGEditTabLayout.this.f10030i);
                ColorStateList colorStateList = PGEditTabLayout.this.f10031j;
                if (colorStateList != null) {
                    this.b.setTextColor(colorStateList);
                }
                l(this.b, this.c);
            } else {
                TextView textView4 = this.f10042e;
                if (textView4 != null || this.f10043f != null) {
                    l(textView4, this.f10043f);
                }
            }
            if (fVar != null && !TextUtils.isEmpty(fVar.f10047d)) {
                setContentDescription(fVar.f10047d);
            }
            if (fVar != null && fVar.l()) {
                z = true;
            }
            setSelected(z);
        }

        final void k() {
            setOrientation(!PGEditTabLayout.this.z ? 1 : 0);
            TextView textView = this.f10042e;
            if (textView == null && this.f10043f == null) {
                l(this.b, this.c);
            } else {
                l(textView, this.f10043f);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int F = PGEditTabLayout.this.F();
            if (F > 0 && (mode == 0 || size > F)) {
                i2 = View.MeasureSpec.makeMeasureSpec(PGEditTabLayout.this.r, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.b != null) {
                float f2 = PGEditTabLayout.this.o;
                int i4 = this.f10045h;
                ImageView imageView = this.c;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = PGEditTabLayout.this.p;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.b.getTextSize();
                int lineCount = this.b.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.b);
                int i5 = (f2 > textSize ? 1 : (f2 == textSize ? 0 : -1));
                if (i5 != 0 || (maxLines >= 0 && i4 != maxLines)) {
                    if (PGEditTabLayout.this.y == 1 && i5 > 0 && lineCount == 1 && ((layout = this.b.getLayout()) == null || d(layout, 0, f2) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
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
            boolean performClick = super.performClick();
            if (this.a != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.a.n();
                return true;
            }
            return performClick;
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
            View view = this.f10041d;
            if (view != null) {
                view.setSelected(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PGEditTabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b implements ViewPager.OnAdapterChangeListener {
        private boolean a;

        b() {
        }

        void a(boolean z) {
            this.a = z;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            PGEditTabLayout pGEditTabLayout = PGEditTabLayout.this;
            if (pGEditTabLayout.G == viewPager) {
                pGEditTabLayout.R(pagerAdapter2, this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c<T extends f> {
        void a(T t);

        void h(T t);

        void i(T t);
    }

    /* loaded from: classes4.dex */
    public interface d extends c<f> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class e extends DataSetObserver {
        e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PGEditTabLayout.this.K();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            PGEditTabLayout.this.K();
        }
    }

    /* loaded from: classes4.dex */
    public static class f {
        private Object a;
        private Drawable b;
        private CharSequence c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f10047d;

        /* renamed from: g  reason: collision with root package name */
        private View f10050g;

        /* renamed from: h  reason: collision with root package name */
        public PGEditTabLayout f10051h;

        /* renamed from: i  reason: collision with root package name */
        public TabView f10052i;

        /* renamed from: e  reason: collision with root package name */
        private int f10048e = -1;

        /* renamed from: f  reason: collision with root package name */
        private int f10049f = -1;

        /* renamed from: j  reason: collision with root package name */
        private boolean f10053j = true;

        /* renamed from: k  reason: collision with root package name */
        private int f10054k = 0;

        @Nullable
        public View f() {
            return this.f10050g;
        }

        @Nullable
        public Drawable g() {
            return this.b;
        }

        public int h() {
            return this.f10048e;
        }

        public int i() {
            return this.f10049f;
        }

        @Nullable
        public Object j() {
            return this.a;
        }

        @Nullable
        public CharSequence k() {
            return this.c;
        }

        public boolean l() {
            PGEditTabLayout pGEditTabLayout = this.f10051h;
            if (pGEditTabLayout != null) {
                return pGEditTabLayout.C() == this.f10049f;
            }
            throw new IllegalArgumentException("Tab not attached to a PGEditTabLayout");
        }

        void m() {
            this.f10051h = null;
            this.f10052i = null;
            this.a = null;
            this.b = null;
            this.c = null;
            this.f10047d = null;
            this.f10049f = -1;
            this.f10053j = true;
            this.f10050g = null;
            this.f10054k = 0;
        }

        public void n() {
            PGEditTabLayout pGEditTabLayout = this.f10051h;
            if (pGEditTabLayout != null) {
                pGEditTabLayout.P(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a PGEditTabLayout");
        }

        @NonNull
        public f o(@Nullable CharSequence charSequence) {
            this.f10047d = charSequence;
            y();
            return this;
        }

        @NonNull
        public f p(@LayoutRes int i2) {
            q(LayoutInflater.from(this.f10052i.getContext()).inflate(i2, (ViewGroup) this.f10052i, false));
            return this;
        }

        @NonNull
        public f q(@Nullable View view) {
            this.f10050g = view;
            y();
            return this;
        }

        @NonNull
        public f r(@Nullable Drawable drawable) {
            this.b = drawable;
            y();
            return this;
        }

        @NonNull
        public f s(@Nullable int i2) {
            this.f10048e = i2;
            return this;
        }

        public void t(int i2) {
            this.f10054k = i2;
        }

        void u(int i2) {
            this.f10049f = i2;
        }

        @NonNull
        public f v(@Nullable Object obj) {
            this.a = obj;
            return this;
        }

        @NonNull
        public f w(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f10047d) && !TextUtils.isEmpty(charSequence)) {
                this.f10052i.setContentDescription(charSequence);
            }
            this.c = charSequence;
            y();
            return this;
        }

        @NonNull
        public f x(@Nullable boolean z) {
            this.f10053j = z;
            y();
            return this;
        }

        void y() {
            TabView tabView = this.f10052i;
            if (tabView != null) {
                tabView.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g implements ViewPager.OnPageChangeListener {
        private final WeakReference<PGEditTabLayout> a;
        private int b;
        private int c;

        public g(PGEditTabLayout pGEditTabLayout) {
            this.a = new WeakReference<>(pGEditTabLayout);
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
            PGEditTabLayout pGEditTabLayout = this.a.get();
            if (pGEditTabLayout != null) {
                int i4 = this.c;
                boolean z = false;
                pGEditTabLayout.S(i2, f2, i4 != 2 || this.b == 1, (i4 == 2 && this.b == 0) ? true : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            PGEditTabLayout pGEditTabLayout = this.a.get();
            if (pGEditTabLayout == null || pGEditTabLayout.C() == i2 || i2 >= pGEditTabLayout.E()) {
                return;
            }
            int i3 = this.c;
            pGEditTabLayout.Q(pGEditTabLayout.D(i2), i3 == 0 || (i3 == 2 && this.b == 0));
        }
    }

    /* loaded from: classes4.dex */
    public static class h implements d {
        private final ViewPager a;

        public h(ViewPager viewPager) {
            this.a = viewPager;
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void a(f fVar) {
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void h(f fVar) {
            this.a.setCurrentItem(fVar.i());
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void i(f fVar) {
        }
    }

    public PGEditTabLayout(Context context) {
        this(context, null);
    }

    private void A() {
        if (this.F == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.F = valueAnimator;
            valueAnimator.setInterpolator(com.google.android.material.animation.a.b);
            this.F.setDuration(this.w);
            this.F.addUpdateListener(new a());
        }
    }

    @Dimension(unit = 0)
    private int B() {
        int size = this.a.size();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                f fVar = this.a.get(i2);
                if (fVar != null && fVar.g() != null && !TextUtils.isEmpty(fVar.k())) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z || this.z) ? 48 : 72;
    }

    private int G() {
        int i2 = this.s;
        if (i2 != -1) {
            return i2;
        }
        return 0;
    }

    private int I() {
        return Math.max(0, ((this.f10025d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void O(int i2) {
        TabView tabView = (TabView) this.f10025d.getChildAt(i2);
        this.f10025d.removeViewAt(i2);
        if (tabView != null) {
            tabView.g();
            this.M.release(tabView);
        }
        requestLayout();
    }

    private void T(int i2) {
        int childCount = this.f10025d.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.f10025d.getChildAt(i3);
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

    private void V(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.G;
        if (viewPager2 != null) {
            g gVar = this.J;
            if (gVar != null) {
                viewPager2.removeOnPageChangeListener(gVar);
            }
            b bVar = this.K;
            if (bVar != null) {
                this.G.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.E;
        if (cVar != null) {
            N(cVar);
            this.E = null;
        }
        if (viewPager != null) {
            this.G = viewPager;
            if (this.J == null) {
                this.J = new g(this);
            }
            this.J.a();
            viewPager.addOnPageChangeListener(this.J);
            h hVar = new h(viewPager);
            this.E = hVar;
            f(hVar);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                R(adapter, z);
            }
            if (this.K == null) {
                this.K = new b();
            }
            this.K.a(z);
            viewPager.addOnAdapterChangeListener(this.K);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.G = null;
            R(null, false);
        }
        this.L = z2;
    }

    private void W() {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.a.get(i2).y();
        }
    }

    private void X(LinearLayout.LayoutParams layoutParams) {
        if (this.y == 1 && this.v == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private void k(@NonNull PGEditTabItem pGEditTabItem, int i2) {
        f J = J();
        CharSequence charSequence = pGEditTabItem.f10021d;
        if (charSequence != null) {
            J.w(charSequence);
        }
        if (pGEditTabItem.getId() != -1) {
            J.s(pGEditTabItem.getId());
        }
        Drawable drawable = pGEditTabItem.f10022e;
        if (drawable != null) {
            J.r(drawable);
        }
        int i3 = pGEditTabItem.f10023f;
        if (i3 != 0) {
            J.p(i3);
        }
        J.f10053j = pGEditTabItem.f10024g;
        if (!TextUtils.isEmpty(pGEditTabItem.getContentDescription())) {
            J.o(pGEditTabItem.getContentDescription());
        }
        if (i2 != -1) {
            h(J, i2);
        } else {
            g(J);
        }
    }

    private void l(f fVar) {
        this.f10025d.addView(fVar.f10052i, fVar.i(), t());
    }

    private void m(View view, int i2) {
        if (view instanceof PGEditTabItem) {
            k((PGEditTabItem) view, i2);
            return;
        }
        throw new IllegalArgumentException("Only PGEditTabItem instances can be added to PGEditTabLayout");
    }

    private void n(int i2) {
        if (i2 != -1) {
            if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.f10025d.c()) {
                int scrollX = getScrollX();
                int p = p(i2, 0.0f);
                if (scrollX != p) {
                    A();
                    this.F.setIntValues(scrollX, p);
                    this.F.start();
                }
                this.f10025d.a(i2, this.w);
                return;
            }
            setScrollPosition(i2, 0.0f, true);
        }
    }

    private void o() {
        ViewCompat.setPaddingRelative(this.f10025d, this.y == 0 ? Math.max(0, this.u - this.f10026e) : 0, 0, 0, 0);
        int i2 = this.y;
        if (i2 == 0) {
            this.f10025d.setGravity(GravityCompat.START);
        } else if (i2 == 1) {
            this.f10025d.setGravity(1);
        }
        Y(true);
    }

    private int p(int i2, float f2) {
        if (this.y == 0) {
            View childAt = this.f10025d.getChildAt(i2);
            int i3 = i2 + 1;
            View childAt2 = i3 < this.f10025d.getChildCount() ? this.f10025d.getChildAt(i3) : null;
            int width = childAt != null ? childAt.getWidth() : 0;
            int width2 = childAt2 != null ? childAt2.getWidth() : 0;
            int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
            int i4 = (int) ((width + width2) * 0.5f * f2);
            return ViewCompat.getLayoutDirection(this) == 0 ? left + i4 : left - i4;
        }
        return 0;
    }

    private void r(f fVar, int i2) {
        fVar.u(i2);
        this.a.add(i2, fVar);
        int size = this.a.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            }
            this.a.get(i2).u(i2);
        }
    }

    private static ColorStateList s(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private LinearLayout.LayoutParams t() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        X(layoutParams);
        return layoutParams;
    }

    private TabView v(@NonNull f fVar) {
        Pools.Pool<TabView> pool = this.M;
        TabView acquire = pool != null ? pool.acquire() : null;
        if (acquire == null) {
            acquire = new TabView(getContext());
        }
        acquire.h(fVar);
        acquire.setFocusable(true);
        acquire.setMinimumWidth(G());
        if (TextUtils.isEmpty(fVar.f10047d)) {
            acquire.setContentDescription(fVar.c);
        } else {
            acquire.setContentDescription(fVar.f10047d);
        }
        return acquire;
    }

    private void w(@NonNull f fVar) {
        for (int size = this.D.size() - 1; size >= 0; size--) {
            this.D.get(size).i(fVar);
        }
    }

    private void x(@NonNull f fVar) {
        for (int size = this.D.size() - 1; size >= 0; size--) {
            this.D.get(size).h(fVar);
        }
    }

    private void y(@NonNull f fVar) {
        for (int size = this.D.size() - 1; size >= 0; size--) {
            this.D.get(size).a(fVar);
        }
    }

    public int C() {
        f fVar = this.b;
        if (fVar != null) {
            return fVar.i();
        }
        return -1;
    }

    @Nullable
    public f D(int i2) {
        if (i2 < 0 || i2 >= E()) {
            return null;
        }
        return this.a.get(i2);
    }

    public int E() {
        return this.a.size();
    }

    int F() {
        return this.r;
    }

    public int H() {
        return this.y;
    }

    @NonNull
    public f J() {
        f u = u();
        u.f10051h = this;
        u.f10052i = v(u);
        return u;
    }

    void K() {
        int currentItem;
        M();
        PagerAdapter pagerAdapter = this.H;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                f J = J();
                J.w(this.H.getPageTitle(i2));
                j(J, false);
            }
            ViewPager viewPager = this.G;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == C() || currentItem >= E()) {
                return;
            }
            P(D(currentItem));
        }
    }

    protected boolean L(f fVar) {
        return Q.release(fVar);
    }

    public void M() {
        for (int childCount = this.f10025d.getChildCount() - 1; childCount >= 0; childCount--) {
            O(childCount);
        }
        Iterator<f> it = this.a.iterator();
        while (it.hasNext()) {
            f next = it.next();
            it.remove();
            next.m();
            L(next);
        }
        this.b = null;
    }

    public void N(@NonNull c cVar) {
        this.D.remove(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(f fVar) {
        Q(fVar, fVar.f10053j);
    }

    void Q(f fVar, boolean z) {
        f fVar2 = this.b;
        if (fVar2 == fVar) {
            if (fVar2 != null) {
                w(fVar);
                if (fVar.f10053j) {
                    n(fVar.i());
                    return;
                }
                return;
            }
            return;
        }
        int i2 = fVar != null ? fVar.i() : -1;
        if (z) {
            if ((fVar2 == null || fVar2.i() == -1) && i2 != -1) {
                setScrollPosition(i2, 0.0f, true);
            } else {
                n(i2);
            }
            if (i2 != -1) {
                T(i2);
            }
        }
        this.b = fVar;
        if (fVar2 != null) {
            y(fVar2);
        }
        if (fVar != null) {
            x(fVar);
        }
    }

    void R(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.H;
        if (pagerAdapter2 != null && (dataSetObserver = this.I) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.H = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.I == null) {
                this.I = new e();
            }
            pagerAdapter.registerDataSetObserver(this.I);
        }
        K();
    }

    void S(int i2, float f2, boolean z, boolean z2) {
        int round = Math.round(i2 + f2);
        if (round < 0 || round >= this.f10025d.getChildCount()) {
            return;
        }
        if (z2) {
            this.f10025d.g(i2, f2);
        }
        ValueAnimator valueAnimator = this.F;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.F.cancel();
        }
        scrollTo(p(i2, f2), 0);
        if (z) {
            T(round);
        }
    }

    void U(f fVar) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        fVar.f10052i.setLayoutParams(layoutParams);
    }

    void Y(boolean z) {
        for (int i2 = 0; i2 < this.f10025d.getChildCount(); i2++) {
            View childAt = this.f10025d.getChildAt(i2);
            childAt.setMinimumWidth(G());
            X((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        m(view, -1);
    }

    public void f(@NonNull c cVar) {
        if (this.D.contains(cVar)) {
            return;
        }
        this.D.add(cVar);
    }

    public void g(@NonNull f fVar) {
        j(fVar, this.a.isEmpty());
    }

    public void h(@NonNull f fVar, int i2) {
        i(fVar, i2, this.a.isEmpty());
    }

    public void i(@NonNull f fVar, int i2, boolean z) {
        if (fVar.f10051h == this) {
            r(fVar, i2);
            U(fVar);
            l(fVar);
            if (z) {
                fVar.n();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different PGEditTabLayout.");
    }

    public void j(@NonNull f fVar, boolean z) {
        i(fVar, this.a.size(), z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.G == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                V((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.L) {
            setupWithViewPager(null);
            this.L = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.f10025d.getChildCount(); i2++) {
            View childAt = this.f10025d.getChildAt(i2);
            if (childAt instanceof TabView) {
                ((TabView) childAt).e(canvas);
            }
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
        if (r1.getMeasuredWidth() != getMeasuredWidth()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
        if (r1.getMeasuredWidth() < getMeasuredWidth()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0075, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
        r6 = r0;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.B()
            int r0 = r5.z(r0)
            int r1 = r5.getPaddingTop()
            int r0 = r0 + r1
            int r1 = r5.getPaddingBottom()
            int r0 = r0 + r1
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r1 == r2) goto L24
            if (r1 == 0) goto L1f
            goto L30
        L1f:
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L30
        L24:
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            int r7 = java.lang.Math.min(r0, r7)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3)
        L30:
            int r0 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r6)
            if (r1 == 0) goto L49
            int r1 = r5.t
            if (r1 <= 0) goto L3f
            goto L47
        L3f:
            r1 = 48
            int r1 = r5.z(r1)
            int r1 = r0 - r1
        L47:
            r5.r = r1
        L49:
            super.onMeasure(r6, r7)
            int r6 = r5.getChildCount()
            r0 = 1
            if (r6 != r0) goto L97
            r6 = 0
            android.view.View r1 = r5.getChildAt(r6)
            int r2 = r5.y
            if (r2 == 0) goto L6a
            if (r2 == r0) goto L5f
            goto L77
        L5f:
            int r2 = r1.getMeasuredWidth()
            int r4 = r5.getMeasuredWidth()
            if (r2 == r4) goto L75
            goto L76
        L6a:
            int r2 = r1.getMeasuredWidth()
            int r4 = r5.getMeasuredWidth()
            if (r2 >= r4) goto L75
            goto L76
        L75:
            r0 = 0
        L76:
            r6 = r0
        L77:
            if (r6 == 0) goto L97
            int r6 = r5.getPaddingTop()
            int r0 = r5.getPaddingBottom()
            int r6 = r6 + r0
            android.view.ViewGroup$LayoutParams r0 = r1.getLayoutParams()
            int r0 = r0.height
            int r6 = android.widget.HorizontalScrollView.getChildMeasureSpec(r7, r6, r0)
            int r7 = r5.getMeasuredWidth()
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3)
            r1.measure(r7, r6)
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.widget.tab.PGEditTabLayout.onMeasure(int, int):void");
    }

    public void q() {
        this.D.clear();
    }

    public void setInlineLabel(boolean z) {
        if (this.z != z) {
            this.z = z;
            for (int i2 = 0; i2 < this.f10025d.getChildCount(); i2++) {
                View childAt = this.f10025d.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).k();
                }
            }
            o();
        }
    }

    public void setInlineLabelResource(@BoolRes int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c cVar) {
        c cVar2 = this.C;
        if (cVar2 != null) {
            N(cVar2);
        }
        this.C = cVar;
        if (cVar != null) {
            f(cVar);
        }
    }

    public void setScrollPosition(int i2, float f2, boolean z) {
        S(i2, f2, z, true);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (this.m != drawable) {
            this.m = drawable;
            ViewCompat.postInvalidateOnAnimation(this.f10025d);
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i2) {
        this.f10025d.h(i2);
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.x != i2) {
            this.x = i2;
            ViewCompat.postInvalidateOnAnimation(this.f10025d);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.f10025d.i(i2);
    }

    public void setShowTabIndicator(boolean z) {
        this.P = z;
        requestLayout();
    }

    public void setTabGravity(int i2) {
        if (this.v != i2) {
            this.v = i2;
            o();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f10032k != colorStateList) {
            this.f10032k = colorStateList;
            W();
        }
    }

    public void setTabIconTintResource(@ColorRes int i2) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.A = z;
        ViewCompat.postInvalidateOnAnimation(this.f10025d);
    }

    public void setTabMode(int i2) {
        if (i2 != this.y) {
            this.y = i2;
            o();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f10033l != colorStateList) {
            this.f10033l = colorStateList;
            for (int i2 = 0; i2 < this.f10025d.getChildCount(); i2++) {
                View childAt = this.f10025d.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).j(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i2) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.f10031j != colorStateList) {
            this.f10031j = colorStateList;
            W();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        R(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.B != z) {
            this.B = z;
            for (int i2 = 0; i2 < this.f10025d.getChildCount(); i2++) {
                View childAt = this.f10025d.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).j(getContext());
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
        return I() > 0;
    }

    protected f u() {
        f acquire = Q.acquire();
        return acquire == null ? new f() : acquire;
    }

    @Dimension(unit = 1)
    int z(@Dimension(unit = 0) int i2) {
        return Math.round(getResources().getDisplayMetrics().density * i2);
    }

    public PGEditTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        m(view, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z) {
        V(viewPager, z, false);
    }

    public PGEditTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.N = 0;
        this.a = new ArrayList<>();
        this.c = new RectF();
        this.r = Integer.MAX_VALUE;
        this.D = new ArrayList<>();
        this.M = new Pools.SimplePool(12);
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator slidingTabIndicator = new SlidingTabIndicator(context);
        this.f10025d = slidingTabIndicator;
        super.addView(slidingTabIndicator, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] iArr = R.styleable.TabLayout;
        int i3 = R.style.Widget_Design_TabLayout;
        int i4 = R.styleable.TabLayout_tabTextAppearance;
        TypedArray h2 = com.google.android.material.internal.k.h(context, attributeSet, iArr, i2, i3, i4);
        slidingTabIndicator.i(h2.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
        slidingTabIndicator.h(h2.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        setSelectedTabIndicator(com.google.android.material.f.c.d(context, h2, R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(h2.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(h2.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = h2.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.f10029h = dimensionPixelSize;
        this.f10028g = dimensionPixelSize;
        this.f10027f = dimensionPixelSize;
        this.f10026e = dimensionPixelSize;
        this.f10026e = h2.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.f10027f = h2.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.f10027f);
        this.f10028g = h2.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.f10028g);
        this.f10029h = h2.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.f10029h);
        this.f10026e = 0;
        this.f10028g = 0;
        this.f10027f = 0;
        this.f10029h = 0;
        int resourceId = h2.getResourceId(i4, R.style.TextAppearance_Design_Tab);
        this.f10030i = resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId, androidx.appcompat.R.styleable.TextAppearance);
        this.N = z(1);
        this.O = z(28);
        try {
            this.o = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.f10031j = com.google.android.material.f.c.a(context, obtainStyledAttributes, androidx.appcompat.R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes.recycle();
            int i5 = R.styleable.TabLayout_tabTextColor;
            if (h2.hasValue(i5)) {
                this.f10031j = com.google.android.material.f.c.a(context, h2, i5);
            }
            int i6 = R.styleable.TabLayout_tabSelectedTextColor;
            if (h2.hasValue(i6)) {
                this.f10031j = s(this.f10031j.getDefaultColor(), h2.getColor(i6, 0));
            }
            this.f10032k = com.google.android.material.f.c.a(context, h2, R.styleable.TabLayout_tabIconTint);
            this.n = p.i(h2.getInt(R.styleable.TabLayout_tabIconTintMode, -1), null);
            this.f10033l = com.google.android.material.f.c.a(context, h2, R.styleable.TabLayout_tabRippleColor);
            this.w = h2.getInt(R.styleable.TabLayout_tabIndicatorAnimationDuration, IjkMediaCodecInfo.RANK_SECURE);
            this.s = h2.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            this.t = h2.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            this.q = h2.getResourceId(R.styleable.TabLayout_tabBackground, 0);
            this.u = h2.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            this.y = h2.getInt(R.styleable.TabLayout_tabMode, 1);
            this.v = h2.getInt(R.styleable.TabLayout_tabGravity, 0);
            this.z = h2.getBoolean(R.styleable.TabLayout_tabInlineLabel, false);
            this.B = h2.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
            h2.recycle();
            this.p = getResources().getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            z(68);
            o();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        m(view, -1);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        m(view, i2);
    }

    public void setSelectedTabIndicator(@DrawableRes int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public void setTabTextColors(int i2, int i3) {
        setTabTextColors(s(i2, i3));
    }
}
