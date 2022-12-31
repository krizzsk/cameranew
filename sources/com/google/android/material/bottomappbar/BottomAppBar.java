package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private static final int v = R.style.Widget_MaterialComponents_BottomAppBar;
    private final int a;
    private final com.google.android.material.shape.h b;
    @Nullable
    private Animator c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Animator f4091d;

    /* renamed from: e  reason: collision with root package name */
    private int f4092e;

    /* renamed from: f  reason: collision with root package name */
    private int f4093f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4094g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f4095h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f4096i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f4097j;

    /* renamed from: k  reason: collision with root package name */
    private int f4098k;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<j> f4099l;
    @MenuRes
    private int m;
    private boolean n;
    private boolean o;
    private Behavior p;
    private int q;
    private int r;
    private int s;
    @NonNull
    AnimatorListenerAdapter t;
    @NonNull
    com.google.android.material.animation.j<FloatingActionButton> u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int a;
        boolean b;

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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
            this.b = parcel.readInt() != 0;
        }
    }

    /* loaded from: classes2.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (BottomAppBar.this.n) {
                return;
            }
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.f0(bottomAppBar.f4092e, BottomAppBar.this.o);
        }
    }

    /* loaded from: classes2.dex */
    class b implements com.google.android.material.animation.j<FloatingActionButton> {
        b() {
        }

        @Override // com.google.android.material.animation.j
        /* renamed from: c */
        public void a(@NonNull FloatingActionButton floatingActionButton) {
            BottomAppBar.this.b.X(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // com.google.android.material.animation.j
        /* renamed from: d */
        public void b(@NonNull FloatingActionButton floatingActionButton) {
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.this.d0().i() != translationX) {
                BottomAppBar.this.d0().o(translationX);
                BottomAppBar.this.b.invalidateSelf();
            }
            float max = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.this.d0().d() != max) {
                BottomAppBar.this.d0().j(max);
                BottomAppBar.this.b.invalidateSelf();
            }
            BottomAppBar.this.b.X(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }
    }

    /* loaded from: classes2.dex */
    class c implements p.e {
        c() {
        }

        @Override // com.google.android.material.internal.p.e
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull p.f fVar) {
            boolean z;
            if (BottomAppBar.this.f4095h) {
                BottomAppBar.this.q = windowInsetsCompat.getSystemWindowInsetBottom();
            }
            boolean z2 = false;
            if (BottomAppBar.this.f4096i) {
                z = BottomAppBar.this.s != windowInsetsCompat.getSystemWindowInsetLeft();
                BottomAppBar.this.s = windowInsetsCompat.getSystemWindowInsetLeft();
            } else {
                z = false;
            }
            if (BottomAppBar.this.f4097j) {
                boolean z3 = BottomAppBar.this.r != windowInsetsCompat.getSystemWindowInsetRight();
                BottomAppBar.this.r = windowInsetsCompat.getSystemWindowInsetRight();
                z2 = z3;
            }
            if (z || z2) {
                BottomAppBar.this.I();
                BottomAppBar.this.j0();
                BottomAppBar.this.i0();
            }
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.M();
            BottomAppBar.this.c = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e extends FloatingActionButton.b {
        final /* synthetic */ int a;

        /* loaded from: classes2.dex */
        class a extends FloatingActionButton.b {
            a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.M();
            }
        }

        e(int i2) {
            this.a = i2;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(@NonNull FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.Y(this.a));
            floatingActionButton.x(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.M();
            BottomAppBar.this.n = false;
            BottomAppBar.this.f4091d = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g extends AnimatorListenerAdapter {
        public boolean a;
        final /* synthetic */ ActionMenuView b;
        final /* synthetic */ int c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f4104d;

        g(ActionMenuView actionMenuView, int i2, boolean z) {
            this.b = actionMenuView;
            this.c = i2;
            this.f4104d = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            boolean z = BottomAppBar.this.m != 0;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.h0(bottomAppBar.m);
            BottomAppBar.this.n0(this.b, this.c, this.f4104d, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements Runnable {
        final /* synthetic */ ActionMenuView a;
        final /* synthetic */ int b;
        final /* synthetic */ boolean c;

        h(ActionMenuView actionMenuView, int i2, boolean z) {
            this.a = actionMenuView;
            this.b = i2;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuView actionMenuView = this.a;
            actionMenuView.setTranslationX(BottomAppBar.this.R(actionMenuView, this.b, this.c));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i extends AnimatorListenerAdapter {
        i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.t.onAnimationStart(animator);
            FloatingActionButton O = BottomAppBar.this.O();
            if (O != null) {
                O.setTranslationX(BottomAppBar.this.X());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface j {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    public BottomAppBar(@NonNull Context context) {
        this(context, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(@NonNull FloatingActionButton floatingActionButton) {
        floatingActionButton.f(this.t);
        floatingActionButton.g(new i());
        floatingActionButton.h(this.u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        Animator animator = this.f4091d;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.c;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void K(int i2, @NonNull List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(O(), "translationX", Y(i2));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    private void L(int i2, boolean z, @NonNull List<Animator> list) {
        ActionMenuView Q = Q();
        if (Q == null) {
            return;
        }
        Animator ofFloat = ObjectAnimator.ofFloat(Q, "alpha", 1.0f);
        if (Math.abs(Q.getTranslationX() - R(Q, i2, z)) > 1.0f) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(Q, "alpha", 0.0f);
            ofFloat2.addListener(new g(Q, i2, z));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
        } else if (Q.getAlpha() < 1.0f) {
            list.add(ofFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        ArrayList<j> arrayList;
        int i2 = this.f4098k - 1;
        this.f4098k = i2;
        if (i2 != 0 || (arrayList = this.f4099l) == null) {
            return;
        }
        Iterator<j> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        ArrayList<j> arrayList;
        int i2 = this.f4098k;
        this.f4098k = i2 + 1;
        if (i2 != 0 || (arrayList = this.f4099l) == null) {
            return;
        }
        Iterator<j> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public FloatingActionButton O() {
        View P = P();
        if (P instanceof FloatingActionButton) {
            return (FloatingActionButton) P;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View P() {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            android.view.ViewParent r0 = r4.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r0
            java.util.List r0 = r0.getDependents(r4)
            java.util.Iterator r0 = r0.iterator()
        L18:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L2d
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r3 != 0) goto L2c
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
            if (r3 == 0) goto L18
        L2c:
            return r2
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.P():android.view.View");
    }

    @Nullable
    private ActionMenuView Q() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int T() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float X() {
        return Y(this.f4092e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float Y(int i2) {
        boolean h2 = p.h(this);
        if (i2 == 1) {
            return ((getMeasuredWidth() / 2) - (this.a + (h2 ? this.s : this.r))) * (h2 ? -1 : 1);
        }
        return 0.0f;
    }

    private float Z() {
        return -d0().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b0() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c0() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public com.google.android.material.bottomappbar.a d0() {
        return (com.google.android.material.bottomappbar.a) this.b.C().p();
    }

    private boolean e0() {
        FloatingActionButton O = O();
        return O != null && O.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(int i2, boolean z) {
        if (!ViewCompat.isLaidOut(this)) {
            this.n = false;
            h0(this.m);
            return;
        }
        Animator animator = this.f4091d;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!e0()) {
            i2 = 0;
            z = false;
        }
        L(i2, z, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f4091d = animatorSet;
        animatorSet.addListener(new f());
        this.f4091d.start();
    }

    private void g0(int i2) {
        if (this.f4092e == i2 || !ViewCompat.isLaidOut(this)) {
            return;
        }
        Animator animator = this.c;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.f4093f == 1) {
            K(i2, arrayList);
        } else {
            J(i2, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.c = animatorSet;
        animatorSet.addListener(new d());
        this.c.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        ActionMenuView Q = Q();
        if (Q == null || this.f4091d != null) {
            return;
        }
        Q.setAlpha(1.0f);
        if (!e0()) {
            m0(Q, 0, false);
        } else {
            m0(Q, this.f4092e, this.o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        d0().o(X());
        View P = P();
        this.b.X((this.o && e0()) ? 1.0f : 0.0f);
        if (P != null) {
            P.setTranslationY(Z());
            P.setTranslationX(X());
        }
    }

    private void m0(@NonNull ActionMenuView actionMenuView, int i2, boolean z) {
        n0(actionMenuView, i2, z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(@NonNull ActionMenuView actionMenuView, int i2, boolean z, boolean z2) {
        h hVar = new h(actionMenuView, i2, z);
        if (z2) {
            actionMenuView.post(hVar);
        } else {
            hVar.run();
        }
    }

    protected void J(int i2, List<Animator> list) {
        FloatingActionButton O = O();
        if (O == null || O.s()) {
            return;
        }
        N();
        O.q(new e(i2));
    }

    protected int R(@NonNull ActionMenuView actionMenuView, int i2, boolean z) {
        if (i2 == 1 && z) {
            boolean h2 = p.h(this);
            int measuredWidth = h2 ? getMeasuredWidth() : 0;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                    if (h2) {
                        measuredWidth = Math.min(measuredWidth, childAt.getLeft());
                    } else {
                        measuredWidth = Math.max(measuredWidth, childAt.getRight());
                    }
                }
            }
            return measuredWidth - ((h2 ? actionMenuView.getRight() : actionMenuView.getLeft()) + (h2 ? this.r : -this.s));
        }
        return 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    /* renamed from: S */
    public Behavior getBehavior() {
        if (this.p == null) {
            this.p = new Behavior();
        }
        return this.p;
    }

    @Dimension
    public float U() {
        return d0().d();
    }

    public float V() {
        return d0().f();
    }

    @Dimension
    public float W() {
        return d0().g();
    }

    public boolean a0() {
        return this.f4094g;
    }

    public void h0(@MenuRes int i2) {
        if (i2 != 0) {
            this.m = 0;
            getMenu().clear();
            inflateMenu(i2);
        }
    }

    void k0(@Dimension float f2) {
        if (f2 != d0().e()) {
            d0().k(f2);
            this.b.invalidateSelf();
        }
    }

    boolean l0(@Px int i2) {
        float f2 = i2;
        if (f2 != d0().h()) {
            d0().n(f2);
            this.b.invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.i.f(this, this.b);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            I();
            j0();
        }
        i0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f4092e = savedState.a;
        this.o = savedState.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.f4092e;
        savedState.b = this.o;
        return savedState;
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.b, colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f2) {
        if (f2 != U()) {
            d0().j(f2);
            this.b.invalidateSelf();
            j0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        this.b.V(f2);
        getBehavior().c(this, this.b.B() - this.b.A());
    }

    public void setFabAlignmentMode(int i2) {
        setFabAlignmentModeAndReplaceMenu(i2, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int i2, @MenuRes int i3) {
        this.m = i3;
        this.n = true;
        f0(i2, this.o);
        g0(i2);
        this.f4092e = i2;
    }

    public void setFabAnimationMode(int i2) {
        this.f4093f = i2;
    }

    public void setFabCradleMargin(@Dimension float f2) {
        if (f2 != V()) {
            d0().l(f2);
            this.b.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f2) {
        if (f2 != W()) {
            d0().m(f2);
            this.b.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z) {
        this.f4094g = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    /* loaded from: classes2.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        private final Rect f4100e;

        /* renamed from: f  reason: collision with root package name */
        private WeakReference<BottomAppBar> f4101f;

        /* renamed from: g  reason: collision with root package name */
        private int f4102g;

        /* renamed from: h  reason: collision with root package name */
        private final View.OnLayoutChangeListener f4103h;

        /* loaded from: classes2.dex */
        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f4101f.get();
                if (bottomAppBar != null && (view instanceof FloatingActionButton)) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    floatingActionButton.m(Behavior.this.f4100e);
                    int height = Behavior.this.f4100e.height();
                    bottomAppBar.l0(height);
                    bottomAppBar.k0(floatingActionButton.n().r().a(new RectF(Behavior.this.f4100e)));
                    CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                    if (Behavior.this.f4102g == 0) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.T() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.b0();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.c0();
                        if (p.h(floatingActionButton)) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.a;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.a;
                            return;
                        }
                    }
                    return;
                }
                view.removeOnLayoutChangeListener(this);
            }
        }

        public Behavior() {
            this.f4103h = new a();
            this.f4100e = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: i */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i2) {
            this.f4101f = new WeakReference<>(bottomAppBar);
            View P = bottomAppBar.P();
            if (P != null && !ViewCompat.isLaidOut(P)) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) P.getLayoutParams();
                layoutParams.anchorGravity = 49;
                this.f4102g = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                if (P instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) P;
                    floatingActionButton.addOnLayoutChangeListener(this.f4103h);
                    bottomAppBar.H(floatingActionButton);
                }
                bottomAppBar.j0();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i2);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i2);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: j */
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i2, int i3) {
            return bottomAppBar.a0() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view, view2, i2, i3);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4103h = new a();
            this.f4100e = new Rect();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BottomAppBar(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r6 = com.google.android.material.bottomappbar.BottomAppBar.v
            android.content.Context r11 = com.google.android.material.theme.a.a.c(r11, r12, r13, r6)
            r10.<init>(r11, r12, r13)
            com.google.android.material.shape.h r11 = new com.google.android.material.shape.h
            r11.<init>()
            r10.b = r11
            r7 = 0
            r10.f4098k = r7
            r10.m = r7
            r10.n = r7
            r0 = 1
            r10.o = r0
            com.google.android.material.bottomappbar.BottomAppBar$a r0 = new com.google.android.material.bottomappbar.BottomAppBar$a
            r0.<init>()
            r10.t = r0
            com.google.android.material.bottomappbar.BottomAppBar$b r0 = new com.google.android.material.bottomappbar.BottomAppBar$b
            r0.<init>()
            r10.u = r0
            android.content.Context r8 = r10.getContext()
            int[] r2 = com.google.android.material.R.styleable.BottomAppBar
            int[] r5 = new int[r7]
            r0 = r8
            r1 = r12
            r3 = r13
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.k.h(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.BottomAppBar_backgroundTint
            android.content.res.ColorStateList r1 = com.google.android.material.f.c.a(r8, r0, r1)
            int r2 = com.google.android.material.R.styleable.BottomAppBar_elevation
            int r2 = r0.getDimensionPixelSize(r2, r7)
            int r3 = com.google.android.material.R.styleable.BottomAppBar_fabCradleMargin
            int r3 = r0.getDimensionPixelOffset(r3, r7)
            float r3 = (float) r3
            int r4 = com.google.android.material.R.styleable.BottomAppBar_fabCradleRoundedCornerRadius
            int r4 = r0.getDimensionPixelOffset(r4, r7)
            float r4 = (float) r4
            int r5 = com.google.android.material.R.styleable.BottomAppBar_fabCradleVerticalOffset
            int r5 = r0.getDimensionPixelOffset(r5, r7)
            float r5 = (float) r5
            int r9 = com.google.android.material.R.styleable.BottomAppBar_fabAlignmentMode
            int r9 = r0.getInt(r9, r7)
            r10.f4092e = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_fabAnimationMode
            int r9 = r0.getInt(r9, r7)
            r10.f4093f = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_hideOnScroll
            boolean r9 = r0.getBoolean(r9, r7)
            r10.f4094g = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingBottomSystemWindowInsets
            boolean r9 = r0.getBoolean(r9, r7)
            r10.f4095h = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingLeftSystemWindowInsets
            boolean r9 = r0.getBoolean(r9, r7)
            r10.f4096i = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingRightSystemWindowInsets
            boolean r7 = r0.getBoolean(r9, r7)
            r10.f4097j = r7
            r0.recycle()
            android.content.res.Resources r0 = r10.getResources()
            int r7 = com.google.android.material.R.dimen.mtrl_bottomappbar_fabOffsetEndMode
            int r0 = r0.getDimensionPixelOffset(r7)
            r10.a = r0
            com.google.android.material.bottomappbar.a r0 = new com.google.android.material.bottomappbar.a
            r0.<init>(r3, r4, r5)
            com.google.android.material.shape.m$b r3 = com.google.android.material.shape.m.a()
            r3.B(r0)
            com.google.android.material.shape.m r0 = r3.m()
            r11.setShapeAppearanceModel(r0)
            r0 = 2
            r11.e0(r0)
            android.graphics.Paint$Style r0 = android.graphics.Paint.Style.FILL
            r11.Z(r0)
            r11.L(r8)
            float r0 = (float) r2
            r10.setElevation(r0)
            androidx.core.graphics.drawable.DrawableCompat.setTintList(r11, r1)
            androidx.core.view.ViewCompat.setBackground(r10, r11)
            com.google.android.material.bottomappbar.BottomAppBar$c r11 = new com.google.android.material.bottomappbar.BottomAppBar$c
            r11.<init>()
            com.google.android.material.internal.p.a(r10, r12, r13, r6, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
