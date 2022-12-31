package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.R;
import com.google.android.material.animation.g;
import com.google.android.material.animation.j;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.d;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.shape.m;
import com.google.android.material.shape.o;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.List;
/* loaded from: classes2.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, TintableImageSourceView, com.google.android.material.d.a, o, CoordinatorLayout.AttachedBehavior {
    private static final int r = R.style.Widget_Design_FloatingActionButton;
    @Nullable
    private ColorStateList b;
    @Nullable
    private PorterDuff.Mode c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f4272d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private PorterDuff.Mode f4273e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f4274f;

    /* renamed from: g  reason: collision with root package name */
    private int f4275g;

    /* renamed from: h  reason: collision with root package name */
    private int f4276h;

    /* renamed from: i  reason: collision with root package name */
    private int f4277i;

    /* renamed from: j  reason: collision with root package name */
    private int f4278j;

    /* renamed from: k  reason: collision with root package name */
    private int f4279k;

    /* renamed from: l  reason: collision with root package name */
    boolean f4280l;
    final Rect m;
    private final Rect n;
    @NonNull
    private final AppCompatImageHelper o;
    @NonNull
    private final com.google.android.material.d.b p;
    private com.google.android.material.floatingactionbutton.d q;

    /* loaded from: classes2.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements d.j {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.d.j
        public void a() {
            this.a.a(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.d.j
        public void onShown() {
            this.a.b(FloatingActionButton.this);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements com.google.android.material.h.b {
        c() {
        }

        @Override // com.google.android.material.h.b
        public boolean a() {
            return FloatingActionButton.this.f4280l;
        }

        @Override // com.google.android.material.h.b
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // com.google.android.material.h.b
        public void setShadowPadding(int i2, int i3, int i4, int i5) {
            FloatingActionButton.this.m.set(i2, i3, i4, i5);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i2 + floatingActionButton.f4278j, i3 + FloatingActionButton.this.f4278j, i4 + FloatingActionButton.this.f4278j, i5 + FloatingActionButton.this.f4278j);
        }
    }

    /* loaded from: classes2.dex */
    class d<T extends FloatingActionButton> implements d.i {
        @NonNull
        private final j<T> a;

        d(@NonNull j<T> jVar) {
            this.a = jVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.floatingactionbutton.d.i
        public void a() {
            this.a.b(FloatingActionButton.this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.floatingactionbutton.d.i
        public void b() {
            this.a.a(FloatingActionButton.this);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof d) && ((d) obj).a.equals(this.a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public FloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private com.google.android.material.floatingactionbutton.d i() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new e(this, new c());
        }
        return new com.google.android.material.floatingactionbutton.d(this, new c());
    }

    private com.google.android.material.floatingactionbutton.d l() {
        if (this.q == null) {
            this.q = i();
        }
        return this.q;
    }

    private int p(int i2) {
        int i3 = this.f4277i;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        if (i2 != -1) {
            if (i2 != 1) {
                return resources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
        } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return p(1);
        } else {
            return p(0);
        }
    }

    private void u(@NonNull Rect rect) {
        int i2 = rect.left;
        Rect rect2 = this.m;
        rect.left = i2 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void v() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f4272d;
        if (colorStateList == null) {
            DrawableCompat.clearColorFilter(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f4273e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
    }

    private static int w(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    return size;
                }
                throw new IllegalArgumentException();
            }
            return i2;
        }
        return Math.min(i2, size);
    }

    @Nullable
    private d.j z(@Nullable b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    @Override // com.google.android.material.d.a
    public boolean a() {
        return this.p.c();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        l().z(getDrawableState());
    }

    public void f(@NonNull Animator.AnimatorListener animatorListener) {
        l().d(animatorListener);
    }

    public void g(@NonNull Animator.AnimatorListener animatorListener) {
        l().e(animatorListener);
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.b;
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.f4272d;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f4273e;
    }

    public void h(@NonNull j<? extends FloatingActionButton> jVar) {
        l().f(new d(jVar));
    }

    @Deprecated
    public boolean j(@NonNull Rect rect) {
        if (ViewCompat.isLaidOut(this)) {
            rect.set(0, 0, getWidth(), getHeight());
            u(rect);
            return true;
        }
        return false;
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        l().v();
    }

    public int k() {
        return this.p.b();
    }

    public void m(@NonNull Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        u(rect);
    }

    @NonNull
    public m n() {
        return (m) Preconditions.checkNotNull(l().q());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        return p(this.f4276h);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        l().w();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l().y();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int o = o();
        this.f4278j = (o - this.f4279k) / 2;
        l().a0();
        int min = Math.min(w(o, i2), w(o, i3));
        Rect rect = this.m;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        this.p.d((Bundle) Preconditions.checkNotNull(extendableSavedState.extendableStates.get("expandableWidgetHelper")));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        extendableSavedState.extendableStates.put("expandableWidgetHelper", this.p.e());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && j(this.n) && !this.n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void q(@Nullable b bVar) {
        r(bVar, true);
    }

    void r(@Nullable b bVar, boolean z) {
        l().r(z(bVar), z);
    }

    public boolean s() {
        return l().t();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.b != colorStateList) {
            this.b = colorStateList;
            l().G(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.c != mode) {
            this.c = mode;
            l().H(mode);
        }
    }

    public void setCompatElevation(float f2) {
        l().I(f2);
    }

    public void setCompatElevationResource(@DimenRes int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        l().L(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(@DimenRes int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        l().P(f2);
    }

    public void setCompatPressedTranslationZResource(@DimenRes int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(@Px int i2) {
        if (i2 >= 0) {
            if (i2 != this.f4277i) {
                this.f4277i = i2;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        l().b0(f2);
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != l().n()) {
            l().J(z);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(@IdRes int i2) {
        this.p.f(i2);
    }

    public void setHideMotionSpec(@Nullable g gVar) {
        l().K(gVar);
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        setHideMotionSpec(g.d(getContext(), i2));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            l().Z();
            if (this.f4272d != null) {
                v();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i2) {
        this.o.setImageResource(i2);
        v();
    }

    public void setRippleColor(@ColorInt int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    @Override // android.view.View
    public void setScaleX(float f2) {
        super.setScaleX(f2);
        l().D();
    }

    @Override // android.view.View
    public void setScaleY(float f2) {
        super.setScaleY(f2);
        l().D();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setShadowPaddingEnabled(boolean z) {
        l().R(z);
    }

    @Override // com.google.android.material.shape.o
    public void setShapeAppearanceModel(@NonNull m mVar) {
        l().S(mVar);
    }

    public void setShowMotionSpec(@Nullable g gVar) {
        l().T(gVar);
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        setShowMotionSpec(g.d(getContext(), i2));
    }

    public void setSize(int i2) {
        this.f4277i = 0;
        if (i2 != this.f4276h) {
            this.f4276h = i2;
            requestLayout();
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        if (this.f4272d != colorStateList) {
            this.f4272d = colorStateList;
            v();
        }
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f4273e != mode) {
            this.f4273e = mode;
            v();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        l().E();
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        l().E();
    }

    @Override // android.view.View
    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        l().E();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f4280l != z) {
            this.f4280l = z;
            l().x();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    public boolean t() {
        return l().u();
    }

    public void x(@Nullable b bVar) {
        y(bVar, true);
    }

    void y(@Nullable b bVar, boolean z) {
        l().X(z(bVar), z);
    }

    /* loaded from: classes2.dex */
    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private Rect a;
        private b b;
        private boolean c;

        public BaseBehavior() {
            this.c = true;
        }

        private static boolean b(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void c(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton) {
            int i2;
            Rect rect = floatingActionButton.m;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            int i3 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) {
                i2 = rect.right;
            } else {
                i2 = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) {
                i3 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) {
                i3 = -rect.top;
            }
            if (i3 != 0) {
                ViewCompat.offsetTopAndBottom(floatingActionButton, i3);
            }
            if (i2 != 0) {
                ViewCompat.offsetLeftAndRight(floatingActionButton, i2);
            }
        }

        private boolean f(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            return this.c && ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).getAnchorId() == view.getId() && floatingActionButton.b() == 0;
        }

        private boolean g(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull FloatingActionButton floatingActionButton) {
            if (f(appBarLayout, floatingActionButton)) {
                if (this.a == null) {
                    this.a = new Rect();
                }
                Rect rect = this.a;
                com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
                if (rect.bottom <= appBarLayout.j()) {
                    floatingActionButton.r(this.b, false);
                    return true;
                }
                floatingActionButton.y(this.b, false);
                return true;
            }
            return false;
        }

        private boolean h(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            if (f(view, floatingActionButton)) {
                if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams())).topMargin) {
                    floatingActionButton.r(this.b, false);
                    return true;
                }
                floatingActionButton.y(this.b, false);
                return true;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: a */
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            Rect rect2 = floatingActionButton.m;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: d */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                g(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (b(view)) {
                h(view, floatingActionButton);
                return false;
            } else {
                return false;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: e */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i2) {
            List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = dependencies.get(i3);
                if (view instanceof AppBarLayout) {
                    if (g(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (b(view) && h(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i2);
            c(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.c = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }
    }

    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingActionButtonStyle);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f4274f != colorStateList) {
            this.f4274f = colorStateList;
            l().Q(this.f4274f);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public FloatingActionButton(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.FloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
