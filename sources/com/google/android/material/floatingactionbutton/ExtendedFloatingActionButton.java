package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.List;
/* loaded from: classes2.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    private static final int E = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    static final Property<View, Float> F = new d(Float.class, "width");
    static final Property<View, Float> G = new e(Float.class, "height");
    static final Property<View, Float> H = new f(Float.class, "paddingStart");
    static final Property<View, Float> I = new g(Float.class, "paddingEnd");
    private boolean A;
    private boolean B;
    private boolean C;
    @NonNull
    protected ColorStateList D;
    private int q;
    private final com.google.android.material.floatingactionbutton.a r;
    @NonNull
    private final com.google.android.material.floatingactionbutton.f s;
    @NonNull
    private final com.google.android.material.floatingactionbutton.f t;
    private final com.google.android.material.floatingactionbutton.f u;
    private final com.google.android.material.floatingactionbutton.f v;
    private final int w;
    private int x;
    private int y;
    @NonNull
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> z;

    /* loaded from: classes2.dex */
    class a implements l {
        a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int a() {
            return ExtendedFloatingActionButton.this.y;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int b() {
            return ExtendedFloatingActionButton.this.x;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getWidth() {
            return (ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.I() * 2)) + ExtendedFloatingActionButton.this.x + ExtendedFloatingActionButton.this.y;
        }
    }

    /* loaded from: classes2.dex */
    class b implements l {
        b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int a() {
            return ExtendedFloatingActionButton.this.I();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int b() {
            return ExtendedFloatingActionButton.this.I();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getHeight() {
            return ExtendedFloatingActionButton.this.J();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(getWidth(), getHeight());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getWidth() {
            return ExtendedFloatingActionButton.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {
        private boolean a;
        final /* synthetic */ com.google.android.material.floatingactionbutton.f b;
        final /* synthetic */ j c;

        c(ExtendedFloatingActionButton extendedFloatingActionButton, com.google.android.material.floatingactionbutton.f fVar, j jVar) {
            this.b = fVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
            this.b.d();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.b.a();
            if (this.a) {
                return;
            }
            this.b.i(this.c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.b.onAnimationStart(animator);
            this.a = false;
        }
    }

    /* loaded from: classes2.dex */
    static class d extends Property<View, Float> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f2) {
            view.getLayoutParams().width = f2.intValue();
            view.requestLayout();
        }
    }

    /* loaded from: classes2.dex */
    static class e extends Property<View, Float> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f2) {
            view.getLayoutParams().height = f2.intValue();
            view.requestLayout();
        }
    }

    /* loaded from: classes2.dex */
    static class f extends Property<View, Float> {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingStart(view));
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f2) {
            ViewCompat.setPaddingRelative(view, f2.intValue(), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom());
        }
    }

    /* loaded from: classes2.dex */
    static class g extends Property<View, Float> {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingEnd(view));
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f2) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), view.getPaddingTop(), f2.intValue(), view.getPaddingBottom());
        }
    }

    /* loaded from: classes2.dex */
    class h extends com.google.android.material.floatingactionbutton.b {

        /* renamed from: g  reason: collision with root package name */
        private final l f4266g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f4267h;

        h(com.google.android.material.floatingactionbutton.a aVar, l lVar, boolean z) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.f4266g = lVar;
            this.f4267h = z;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void a() {
            super.a();
            ExtendedFloatingActionButton.this.B = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f4266g.getLayoutParams().width;
            layoutParams.height = this.f4266g.getLayoutParams().height;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void b() {
            ExtendedFloatingActionButton.this.A = this.f4267h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f4266g.getLayoutParams().width;
            layoutParams.height = this.f4266g.getLayoutParams().height;
            ViewCompat.setPaddingRelative(ExtendedFloatingActionButton.this, this.f4266g.b(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f4266g.a(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean c() {
            return this.f4267h == ExtendedFloatingActionButton.this.A || ExtendedFloatingActionButton.this.c() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int e() {
            return this.f4267h ? R.animator.mtrl_extended_fab_change_size_expand_motion_spec : R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        @NonNull
        public AnimatorSet g() {
            com.google.android.material.animation.g l2 = l();
            if (l2.j("width")) {
                PropertyValuesHolder[] g2 = l2.g("width");
                g2[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.f4266g.getWidth());
                l2.l("width", g2);
            }
            if (l2.j("height")) {
                PropertyValuesHolder[] g3 = l2.g("height");
                g3[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.f4266g.getHeight());
                l2.l("height", g3);
            }
            if (l2.j("paddingStart")) {
                PropertyValuesHolder[] g4 = l2.g("paddingStart");
                g4[0].setFloatValues(ViewCompat.getPaddingStart(ExtendedFloatingActionButton.this), this.f4266g.b());
                l2.l("paddingStart", g4);
            }
            if (l2.j("paddingEnd")) {
                PropertyValuesHolder[] g5 = l2.g("paddingEnd");
                g5[0].setFloatValues(ViewCompat.getPaddingEnd(ExtendedFloatingActionButton.this), this.f4266g.a());
                l2.l("paddingEnd", g5);
            }
            if (l2.j("labelOpacity")) {
                PropertyValuesHolder[] g6 = l2.g("labelOpacity");
                boolean z = this.f4267h;
                g6[0].setFloatValues(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
                l2.l("labelOpacity", g6);
            }
            return super.k(l2);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void i(@Nullable j jVar) {
            if (jVar == null) {
                return;
            }
            if (this.f4267h) {
                jVar.a(ExtendedFloatingActionButton.this);
            } else {
                jVar.d(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.A = this.f4267h;
            ExtendedFloatingActionButton.this.B = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }
    }

    /* loaded from: classes2.dex */
    class i extends com.google.android.material.floatingactionbutton.b {

        /* renamed from: g  reason: collision with root package name */
        private boolean f4269g;

        public i(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void a() {
            super.a();
            ExtendedFloatingActionButton.this.q = 0;
            if (this.f4269g) {
                return;
            }
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.setVisibility(8);
            VdsAgent.onSetViewVisibility(extendedFloatingActionButton, 8);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void b() {
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.setVisibility(8);
            VdsAgent.onSetViewVisibility(extendedFloatingActionButton, 8);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean c() {
            return ExtendedFloatingActionButton.this.K();
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void d() {
            super.d();
            this.f4269g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int e() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void i(@Nullable j jVar) {
            if (jVar != null) {
                jVar.b(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f4269g = false;
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.setVisibility(0);
            VdsAgent.onSetViewVisibility(extendedFloatingActionButton, 0);
            ExtendedFloatingActionButton.this.q = 1;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class j {
        public abstract void a(ExtendedFloatingActionButton extendedFloatingActionButton);

        public abstract void b(ExtendedFloatingActionButton extendedFloatingActionButton);

        public abstract void c(ExtendedFloatingActionButton extendedFloatingActionButton);

        public abstract void d(ExtendedFloatingActionButton extendedFloatingActionButton);
    }

    /* loaded from: classes2.dex */
    class k extends com.google.android.material.floatingactionbutton.b {
        public k(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void a() {
            super.a();
            ExtendedFloatingActionButton.this.q = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void b() {
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.setVisibility(0);
            VdsAgent.onSetViewVisibility(extendedFloatingActionButton, 0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean c() {
            return ExtendedFloatingActionButton.this.L();
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int e() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void i(@Nullable j jVar) {
            if (jVar != null) {
                jVar.c(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.setVisibility(0);
            VdsAgent.onSetViewVisibility(extendedFloatingActionButton, 0);
            ExtendedFloatingActionButton.this.q = 2;
        }
    }

    /* loaded from: classes2.dex */
    interface l {
        int a();

        int b();

        int getHeight();

        ViewGroup.LayoutParams getLayoutParams();

        int getWidth();
    }

    public ExtendedFloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K() {
        return getVisibility() == 0 ? this.q == 1 : this.q != 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L() {
        return getVisibility() != 0 ? this.q == 2 : this.q != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(@NonNull com.google.android.material.floatingactionbutton.f fVar, @Nullable j jVar) {
        if (fVar.c()) {
            return;
        }
        if (!O()) {
            fVar.b();
            fVar.i(jVar);
            return;
        }
        measure(0, 0);
        AnimatorSet g2 = fVar.g();
        g2.addListener(new c(this, fVar, jVar));
        for (Animator.AnimatorListener animatorListener : fVar.h()) {
            g2.addListener(animatorListener);
        }
        g2.start();
    }

    private void N() {
        this.D = getTextColors();
    }

    private boolean O() {
        return (ViewCompat.isLaidOut(this) || (!L() && this.C)) && !isInEditMode();
    }

    int I() {
        return (J() - d()) / 2;
    }

    @VisibleForTesting
    int J() {
        int i2 = this.w;
        return i2 < 0 ? (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + d() : i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.A && TextUtils.isEmpty(getText()) && c() != null) {
            this.A = false;
            this.s.b();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z) {
        this.C = z;
    }

    public void setExtendMotionSpec(@Nullable com.google.android.material.animation.g gVar) {
        this.t.f(gVar);
    }

    public void setExtendMotionSpecResource(@AnimatorRes int i2) {
        setExtendMotionSpec(com.google.android.material.animation.g.d(getContext(), i2));
    }

    public void setExtended(boolean z) {
        if (this.A == z) {
            return;
        }
        com.google.android.material.floatingactionbutton.f fVar = z ? this.t : this.s;
        if (fVar.c()) {
            return;
        }
        fVar.b();
    }

    public void setHideMotionSpec(@Nullable com.google.android.material.animation.g gVar) {
        this.v.f(gVar);
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        setHideMotionSpec(com.google.android.material.animation.g.d(getContext(), i2));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        if (!this.A || this.B) {
            return;
        }
        this.x = ViewCompat.getPaddingStart(this);
        this.y = ViewCompat.getPaddingEnd(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        if (!this.A || this.B) {
            return;
        }
        this.x = i2;
        this.y = i4;
    }

    public void setShowMotionSpec(@Nullable com.google.android.material.animation.g gVar) {
        this.u.f(gVar);
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        setShowMotionSpec(com.google.android.material.animation.g.d(getContext(), i2));
    }

    public void setShrinkMotionSpec(@Nullable com.google.android.material.animation.g gVar) {
        this.s.f(gVar);
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int i2) {
        setShrinkMotionSpec(com.google.android.material.animation.g.d(getContext(), i2));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i2) {
        super.setTextColor(i2);
        N();
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.extendedFloatingActionButtonStyle);
    }

    /* loaded from: classes2.dex */
    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private Rect a;
        @Nullable
        private j b;
        @Nullable
        private j c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f4264d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f4265e;

        public ExtendedFloatingActionButtonBehavior() {
            this.f4264d = false;
            this.f4265e = true;
        }

        private static boolean c(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean f(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f4264d || this.f4265e) && ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).getAnchorId() == view.getId();
        }

        private boolean h(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (f(appBarLayout, extendedFloatingActionButton)) {
                if (this.a == null) {
                    this.a = new Rect();
                }
                Rect rect = this.a;
                com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
                if (rect.bottom <= appBarLayout.j()) {
                    g(extendedFloatingActionButton);
                    return true;
                }
                a(extendedFloatingActionButton);
                return true;
            }
            return false;
        }

        private boolean i(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (f(view, extendedFloatingActionButton)) {
                if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                    g(extendedFloatingActionButton);
                    return true;
                }
                a(extendedFloatingActionButton);
                return true;
            }
            return false;
        }

        protected void a(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z = this.f4265e;
            extendedFloatingActionButton.M(z ? extendedFloatingActionButton.t : extendedFloatingActionButton.u, z ? this.c : this.b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: b */
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: d */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                h(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            } else if (c(view)) {
                i(view, extendedFloatingActionButton);
                return false;
            } else {
                return false;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: e */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, int i2) {
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = dependencies.get(i3);
                if (view instanceof AppBarLayout) {
                    if (h(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (c(view) && i(view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i2);
            return true;
        }

        protected void g(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z = this.f4265e;
            extendedFloatingActionButton.M(z ? extendedFloatingActionButton.s : extendedFloatingActionButton.v, z ? this.c : this.b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f4264d = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f4265e = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ExtendedFloatingActionButton(@androidx.annotation.NonNull android.content.Context r17, @androidx.annotation.Nullable android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r9 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.E
            r1 = r17
            android.content.Context r1 = com.google.android.material.theme.a.a.c(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = 0
            r0.q = r10
            com.google.android.material.floatingactionbutton.a r1 = new com.google.android.material.floatingactionbutton.a
            r1.<init>()
            r0.r = r1
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k r11 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k
            r11.<init>(r1)
            r0.u = r11
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$i r12 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$i
            r12.<init>(r1)
            r0.v = r12
            r13 = 1
            r0.A = r13
            r0.B = r10
            r0.C = r10
            android.content.Context r14 = r16.getContext()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior r1 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior
            r1.<init>(r14, r7)
            r0.z = r1
            int[] r3 = com.google.android.material.R.styleable.ExtendedFloatingActionButton
            int[] r6 = new int[r10]
            r1 = r14
            r2 = r18
            r4 = r19
            r5 = r9
            android.content.res.TypedArray r1 = com.google.android.material.internal.k.h(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_showMotionSpec
            com.google.android.material.animation.g r2 = com.google.android.material.animation.g.c(r14, r1, r2)
            int r3 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_hideMotionSpec
            com.google.android.material.animation.g r3 = com.google.android.material.animation.g.c(r14, r1, r3)
            int r4 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_extendMotionSpec
            com.google.android.material.animation.g r4 = com.google.android.material.animation.g.c(r14, r1, r4)
            int r5 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec
            com.google.android.material.animation.g r5 = com.google.android.material.animation.g.c(r14, r1, r5)
            int r6 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_collapsedSize
            r15 = -1
            int r6 = r1.getDimensionPixelSize(r6, r15)
            r0.w = r6
            int r6 = androidx.core.view.ViewCompat.getPaddingStart(r16)
            r0.x = r6
            int r6 = androidx.core.view.ViewCompat.getPaddingEnd(r16)
            r0.y = r6
            com.google.android.material.floatingactionbutton.a r6 = new com.google.android.material.floatingactionbutton.a
            r6.<init>()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h r15 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a
            r10.<init>()
            r15.<init>(r6, r10, r13)
            r0.t = r15
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$b r13 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$b
            r13.<init>()
            r7 = 0
            r10.<init>(r6, r13, r7)
            r0.s = r10
            r11.f(r2)
            r12.f(r3)
            r15.f(r4)
            r10.f(r5)
            r1.recycle()
            com.google.android.material.shape.c r1 = com.google.android.material.shape.m.m
            r2 = r18
            com.google.android.material.shape.m$b r1 = com.google.android.material.shape.m.g(r14, r2, r8, r9, r1)
            com.google.android.material.shape.m r1 = r1.m()
            r0.setShapeAppearanceModel(r1)
            r16.N()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        N();
    }
}
