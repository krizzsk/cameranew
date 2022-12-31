package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.b;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    @NonNull
    static final Handler t;
    private static final boolean u;
    private static final int[] v;
    private static final String w;
    @NonNull
    private final ViewGroup a;
    private final Context b;
    @NonNull
    protected final SnackbarBaseLayout c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.material.snackbar.a f4544d;

    /* renamed from: e  reason: collision with root package name */
    private int f4545e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4546f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private View f4547g;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Rect f4550j;

    /* renamed from: k  reason: collision with root package name */
    private int f4551k;

    /* renamed from: l  reason: collision with root package name */
    private int f4552l;
    private int m;
    private int n;
    private int o;
    private List<r<B>> p;
    private Behavior q;
    @Nullable
    private final AccessibilityManager r;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4548h = false;
    @RequiresApi(29)

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f4549i = new k();
    @NonNull
    b.InterfaceC0178b s = new n();

    /* loaded from: classes2.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {
        @NonNull

        /* renamed from: k  reason: collision with root package name */
        private final s f4553k = new s(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void l(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f4553k.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean a(View view) {
            return this.f4553k.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            this.f4553k.b(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public static class SnackbarBaseLayout extends FrameLayout {

        /* renamed from: h  reason: collision with root package name */
        private static final View.OnTouchListener f4554h = new a();
        private u a;
        private t b;
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private final float f4555d;

        /* renamed from: e  reason: collision with root package name */
        private final float f4556e;

        /* renamed from: f  reason: collision with root package name */
        private ColorStateList f4557f;

        /* renamed from: g  reason: collision with root package name */
        private PorterDuff.Mode f4558g;

        /* loaded from: classes2.dex */
        static class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public SnackbarBaseLayout(@NonNull Context context) {
            this(context, null);
        }

        @NonNull
        private Drawable a() {
            float dimension = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(com.google.android.material.b.a.i(this, R.attr.colorSurface, R.attr.colorOnSurface, d()));
            if (this.f4557f != null) {
                Drawable wrap = DrawableCompat.wrap(gradientDrawable);
                DrawableCompat.setTintList(wrap, this.f4557f);
                return wrap;
            }
            return DrawableCompat.wrap(gradientDrawable);
        }

        float b() {
            return this.f4556e;
        }

        int c() {
            return this.c;
        }

        float d() {
            return this.f4555d;
        }

        void e(t tVar) {
            this.b = tVar;
        }

        void f(u uVar) {
            this.a = uVar;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            t tVar = this.b;
            if (tVar != null) {
                tVar.onViewAttachedToWindow(this);
            }
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            t tVar = this.b;
            if (tVar != null) {
                tVar.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            u uVar = this.a;
            if (uVar != null) {
                uVar.a(this, i2, i3, i4, i5);
            }
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null && this.f4557f != null) {
                drawable = DrawableCompat.wrap(drawable.mutate());
                DrawableCompat.setTintList(drawable, this.f4557f);
                DrawableCompat.setTintMode(drawable, this.f4558g);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            this.f4557f = colorStateList;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintList(wrap, colorStateList);
                DrawableCompat.setTintMode(wrap, this.f4558g);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            this.f4558g = mode;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintMode(wrap, mode);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f4554h);
            super.setOnClickListener(onClickListener);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public SnackbarBaseLayout(@NonNull Context context, AttributeSet attributeSet) {
            super(com.google.android.material.theme.a.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            int i2 = R.styleable.SnackbarLayout_elevation;
            if (obtainStyledAttributes.hasValue(i2)) {
                ViewCompat.setElevation(this, obtainStyledAttributes.getDimensionPixelSize(i2, 0));
            }
            this.c = obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            this.f4555d = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(com.google.android.material.f.c.a(context2, obtainStyledAttributes, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(com.google.android.material.internal.p.i(obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f4556e = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f4554h);
            setFocusable(true);
            if (getBackground() == null) {
                ViewCompat.setBackground(this, a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SnackbarBaseLayout snackbarBaseLayout = BaseTransientBottomBar.this.c;
            if (snackbarBaseLayout == null) {
                return;
            }
            if (snackbarBaseLayout.getParent() != null) {
                SnackbarBaseLayout snackbarBaseLayout2 = BaseTransientBottomBar.this.c;
                snackbarBaseLayout2.setVisibility(0);
                VdsAgent.onSetViewVisibility(snackbarBaseLayout2, 0);
            }
            if (BaseTransientBottomBar.this.c.c() == 1) {
                BaseTransientBottomBar.this.P();
            } else {
                BaseTransientBottomBar.this.R();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.H();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        c(int i2) {
            this.a = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.G(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.c.setScaleX(floatValue);
            BaseTransientBottomBar.this.c.setScaleY(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.H();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f4544d.a(70, BaseBlurEffect.ROTATION_180);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        private int a;
        final /* synthetic */ int b;

        g(int i2) {
            this.b = i2;
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.u) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.c, intValue - this.a);
            } else {
                BaseTransientBottomBar.this.c.setTranslationY(intValue);
            }
            this.a = intValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        h(int i2) {
            this.a = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.G(this.a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f4544d.b(0, BaseBlurEffect.ROTATION_180);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        private int a = 0;

        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.u) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.c, intValue - this.a);
            } else {
                BaseTransientBottomBar.this.c.setTranslationY(intValue);
            }
            this.a = intValue;
        }
    }

    /* loaded from: classes2.dex */
    static class j implements Handler.Callback {
        j() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                ((BaseTransientBottomBar) message.obj).N();
                return true;
            } else if (i2 != 1) {
                return false;
            } else {
                ((BaseTransientBottomBar) message.obj).D(message.arg1);
                return true;
            }
        }
    }

    /* loaded from: classes2.dex */
    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int y;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.c == null || baseTransientBottomBar.b == null || (y = (BaseTransientBottomBar.this.y() - BaseTransientBottomBar.this.B()) + ((int) BaseTransientBottomBar.this.c.getTranslationY())) >= BaseTransientBottomBar.this.n) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.c.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.w, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.n - y;
            BaseTransientBottomBar.this.c.requestLayout();
        }
    }

    /* loaded from: classes2.dex */
    class l implements OnApplyWindowInsetsListener {
        l() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            BaseTransientBottomBar.this.f4551k = windowInsetsCompat.getSystemWindowInsetBottom();
            BaseTransientBottomBar.this.f4552l = windowInsetsCompat.getSystemWindowInsetLeft();
            BaseTransientBottomBar.this.m = windowInsetsCompat.getSystemWindowInsetRight();
            BaseTransientBottomBar.this.T();
            return windowInsetsCompat;
        }
    }

    /* loaded from: classes2.dex */
    class m extends AccessibilityDelegateCompat {
        m() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.addAction(1048576);
            accessibilityNodeInfoCompat.setDismissable(true);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (i2 == 1048576) {
                BaseTransientBottomBar.this.s();
                return true;
            }
            return super.performAccessibilityAction(view, i2, bundle);
        }
    }

    /* loaded from: classes2.dex */
    class n implements b.InterfaceC0178b {
        n() {
        }

        @Override // com.google.android.material.snackbar.b.InterfaceC0178b
        public void a(int i2) {
            Handler handler = BaseTransientBottomBar.t;
            handler.sendMessage(handler.obtainMessage(1, i2, 0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.b.InterfaceC0178b
        public void show() {
            Handler handler = BaseTransientBottomBar.t;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class o implements t {

        /* loaded from: classes2.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseTransientBottomBar.this.G(3);
            }
        }

        o() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        public void onViewAttachedToWindow(View view) {
            WindowInsets rootWindowInsets;
            if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = BaseTransientBottomBar.this.c.getRootWindowInsets()) == null) {
                return;
            }
            BaseTransientBottomBar.this.n = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            BaseTransientBottomBar.this.T();
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        public void onViewDetachedFromWindow(View view) {
            if (BaseTransientBottomBar.this.E()) {
                BaseTransientBottomBar.t.post(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class p implements u {
        p() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.u
        public void a(View view, int i2, int i3, int i4, int i5) {
            BaseTransientBottomBar.this.c.f(null);
            BaseTransientBottomBar.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class q implements SwipeDismissBehavior.c {
        q() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(@NonNull View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
                VdsAgent.onSetViewVisibility(view, 8);
            }
            BaseTransientBottomBar.this.t(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(int i2) {
            if (i2 == 0) {
                com.google.android.material.snackbar.b.c().k(BaseTransientBottomBar.this.s);
            } else if (i2 == 1 || i2 == 2) {
                com.google.android.material.snackbar.b.c().j(BaseTransientBottomBar.this.s);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class r<B> {
        public void a(B b, int i2) {
        }

        public void b(B b) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public static class s {
        private b.InterfaceC0178b a;

        public s(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.h(0.1f);
            swipeDismissBehavior.f(0.6f);
            swipeDismissBehavior.i(0);
        }

        public boolean a(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public void b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.b.c().j(this.a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.b.c().k(this.a);
            }
        }

        public void c(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.a = baseTransientBottomBar.s;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public interface t {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public interface u {
        void a(View view, int i2, int i3, int i4, int i5);
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        u = i2 >= 16 && i2 <= 19;
        v = new int[]{R.attr.snackbarStyle};
        w = BaseTransientBottomBar.class.getSimpleName();
        t = new Handler(Looper.getMainLooper(), new j());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseTransientBottomBar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull com.google.android.material.snackbar.a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (aVar != null) {
            this.a = viewGroup;
            this.f4544d = aVar;
            this.b = context;
            com.google.android.material.internal.k.a(context);
            SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(context).inflate(z(), viewGroup, false);
            this.c = snackbarBaseLayout;
            if (view instanceof SnackbarContentLayout) {
                ((SnackbarContentLayout) view).d(snackbarBaseLayout.b());
            }
            snackbarBaseLayout.addView(view);
            ViewGroup.LayoutParams layoutParams = snackbarBaseLayout.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.f4550j = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            ViewCompat.setAccessibilityLiveRegion(snackbarBaseLayout, 1);
            ViewCompat.setImportantForAccessibility(snackbarBaseLayout, 1);
            ViewCompat.setFitsSystemWindows(snackbarBaseLayout, true);
            ViewCompat.setOnApplyWindowInsetsListener(snackbarBaseLayout, new l());
            ViewCompat.setAccessibilityDelegate(snackbarBaseLayout, new m());
            this.r = (AccessibilityManager) context.getSystemService("accessibility");
            return;
        }
        throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
    }

    private int A() {
        int height = this.c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int B() {
        int[] iArr = new int[2];
        this.c.getLocationOnScreen(iArr);
        return iArr[1] + this.c.getHeight();
    }

    private boolean F() {
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof SwipeDismissBehavior);
    }

    private void J(CoordinatorLayout.LayoutParams layoutParams) {
        SwipeDismissBehavior<? extends View> swipeDismissBehavior = this.q;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = w();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).l(this);
        }
        swipeDismissBehavior.g(new q());
        layoutParams.setBehavior(swipeDismissBehavior);
        if (this.f4547g == null) {
            layoutParams.insetEdge = 80;
        }
    }

    private boolean L() {
        return this.n > 0 && !this.f4546f && F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (K()) {
            p();
            return;
        }
        if (this.c.getParent() != null) {
            SnackbarBaseLayout snackbarBaseLayout = this.c;
            snackbarBaseLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(snackbarBaseLayout, 0);
        }
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        ValueAnimator u2 = u(0.0f, 1.0f);
        ValueAnimator x = x(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(u2, x);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new b());
        animatorSet.start();
    }

    private void Q(int i2) {
        ValueAnimator u2 = u(1.0f, 0.0f);
        u2.setDuration(75L);
        u2.addListener(new c(i2));
        u2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        int A = A();
        if (u) {
            ViewCompat.offsetTopAndBottom(this.c, A);
        } else {
            this.c.setTranslationY(A);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(A, 0);
        valueAnimator.setInterpolator(com.google.android.material.animation.a.b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new f());
        valueAnimator.addUpdateListener(new g(A));
        valueAnimator.start();
    }

    private void S(int i2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, A());
        valueAnimator.setInterpolator(com.google.android.material.animation.a.b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new h(i2));
        valueAnimator.addUpdateListener(new i());
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        Rect rect;
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && (rect = this.f4550j) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = rect.bottom + (this.f4547g != null ? this.o : this.f4551k);
            marginLayoutParams.leftMargin = rect.left + this.f4552l;
            marginLayoutParams.rightMargin = rect.right + this.m;
            this.c.requestLayout();
            if (Build.VERSION.SDK_INT < 29 || !L()) {
                return;
            }
            this.c.removeCallbacks(this.f4549i);
            this.c.post(this.f4549i);
            return;
        }
        Log.w(w, "Unable to update margins because layout params are not MarginLayoutParams");
    }

    private void q(int i2) {
        if (this.c.c() == 1) {
            Q(i2);
        } else {
            S(i2);
        }
    }

    private int r() {
        View view = this.f4547g;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        this.a.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.a.getHeight()) - i2;
    }

    private ValueAnimator u(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(com.google.android.material.animation.a.a);
        ofFloat.addUpdateListener(new d());
        return ofFloat;
    }

    private ValueAnimator x(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(com.google.android.material.animation.a.f4032d);
        ofFloat.addUpdateListener(new e());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(17)
    public int y() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.b.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    protected boolean C() {
        TypedArray obtainStyledAttributes = this.b.obtainStyledAttributes(v);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    final void D(int i2) {
        if (K() && this.c.getVisibility() == 0) {
            q(i2);
        } else {
            G(i2);
        }
    }

    public boolean E() {
        return com.google.android.material.snackbar.b.c().e(this.s);
    }

    void G(int i2) {
        com.google.android.material.snackbar.b.c().h(this.s);
        List<r<B>> list = this.p;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.p.get(size).a(this, i2);
            }
        }
        ViewParent parent = this.c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.c);
        }
    }

    void H() {
        com.google.android.material.snackbar.b.c().i(this.s);
        List<r<B>> list = this.p;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.p.get(size).b(this);
            }
        }
    }

    @NonNull
    public B I(int i2) {
        this.f4545e = i2;
        return this;
    }

    boolean K() {
        AccessibilityManager accessibilityManager = this.r;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void M() {
        com.google.android.material.snackbar.b.c().m(v(), this.s);
    }

    final void N() {
        this.c.e(new o());
        if (this.c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                J((CoordinatorLayout.LayoutParams) layoutParams);
            }
            this.o = r();
            T();
            SnackbarBaseLayout snackbarBaseLayout = this.c;
            snackbarBaseLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(snackbarBaseLayout, 4);
            this.a.addView(this.c);
        }
        if (ViewCompat.isLaidOut(this.c)) {
            O();
        } else {
            this.c.f(new p());
        }
    }

    void p() {
        this.c.post(new a());
    }

    public void s() {
        t(3);
    }

    protected void t(int i2) {
        com.google.android.material.snackbar.b.c().b(this.s, i2);
    }

    public int v() {
        return this.f4545e;
    }

    @NonNull
    protected SwipeDismissBehavior<? extends View> w() {
        return new Behavior();
    }

    @LayoutRes
    protected int z() {
        return C() ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar;
    }
}
