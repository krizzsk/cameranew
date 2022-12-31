package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.internal.p;
import com.google.android.material.shape.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int Y = R.style.Widget_Design_BottomSheet_Modal;
    float A;
    int B;
    float C;
    boolean D;
    private boolean E;
    private boolean F;
    int G;
    @Nullable
    ViewDragHelper H;
    private boolean I;
    private int J;
    private boolean K;
    private int L;
    int M;
    int N;
    @Nullable
    WeakReference<V> O;
    @Nullable
    WeakReference<View> P;
    @NonNull
    private final ArrayList<g> Q;
    @Nullable
    private VelocityTracker R;
    int S;
    private int T;
    boolean U;
    @Nullable
    private Map<View, Integer> V;
    private int W;
    private final ViewDragHelper.Callback X;
    private int a;
    private boolean b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private float f4110d;

    /* renamed from: e  reason: collision with root package name */
    private int f4111e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4112f;

    /* renamed from: g  reason: collision with root package name */
    private int f4113g;

    /* renamed from: h  reason: collision with root package name */
    private int f4114h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4115i;

    /* renamed from: j  reason: collision with root package name */
    private com.google.android.material.shape.h f4116j;

    /* renamed from: k  reason: collision with root package name */
    private int f4117k;

    /* renamed from: l  reason: collision with root package name */
    private int f4118l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private m t;
    private boolean u;
    private BottomSheetBehavior<V>.h v;
    @Nullable
    private ValueAnimator w;
    int x;
    int y;
    int z;

    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ ViewGroup.LayoutParams b;

        a(BottomSheetBehavior bottomSheetBehavior, View view, ViewGroup.LayoutParams layoutParams) {
            this.a = view;
            this.b = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setLayoutParams(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ int b;

        b(View view, int i2) {
            this.a = view;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.Y(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f4116j != null) {
                BottomSheetBehavior.this.f4116j.X(floatValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements p.e {
        final /* synthetic */ boolean a;

        d(boolean z) {
            this.a = z;
        }

        @Override // com.google.android.material.internal.p.e
        public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, p.f fVar) {
            BottomSheetBehavior.this.s = windowInsetsCompat.getSystemWindowInsetTop();
            boolean h2 = p.h(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.this.n) {
                BottomSheetBehavior.this.r = windowInsetsCompat.getSystemWindowInsetBottom();
                paddingBottom = fVar.f4383d + BottomSheetBehavior.this.r;
            }
            if (BottomSheetBehavior.this.o) {
                paddingLeft = (h2 ? fVar.c : fVar.a) + windowInsetsCompat.getSystemWindowInsetLeft();
            }
            if (BottomSheetBehavior.this.p) {
                paddingRight = (h2 ? fVar.a : fVar.c) + windowInsetsCompat.getSystemWindowInsetRight();
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.a) {
                BottomSheetBehavior.this.f4118l = windowInsetsCompat.getMandatorySystemGestureInsets().bottom;
            }
            if (BottomSheetBehavior.this.n || this.a) {
                BottomSheetBehavior.this.f0(false);
            }
            return windowInsetsCompat;
        }
    }

    /* loaded from: classes2.dex */
    class e extends ViewDragHelper.Callback {
        e() {
        }

        private boolean a(@NonNull View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.N + bottomSheetBehavior.z()) / 2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i2, int i3) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i2, int i3) {
            int z = BottomSheetBehavior.this.z();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return MathUtils.clamp(i2, z, bottomSheetBehavior.D ? bottomSheetBehavior.N : bottomSheetBehavior.B);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(@NonNull View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.D) {
                return bottomSheetBehavior.N;
            }
            return bottomSheetBehavior.B;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i2) {
            if (i2 == 1 && BottomSheetBehavior.this.F) {
                BottomSheetBehavior.this.W(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i2, int i3, int i4, int i5) {
            BottomSheetBehavior.this.w(i3);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f2, float f3) {
            int i2;
            int i3 = 4;
            if (f3 < 0.0f) {
                if (BottomSheetBehavior.this.b) {
                    i2 = BottomSheetBehavior.this.y;
                } else {
                    int top = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    int i4 = bottomSheetBehavior.z;
                    if (top > i4) {
                        i2 = i4;
                        i3 = 6;
                    } else {
                        i2 = bottomSheetBehavior.z();
                    }
                }
                i3 = 3;
            } else {
                BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                if (bottomSheetBehavior2.D && bottomSheetBehavior2.a0(view, f3)) {
                    if ((Math.abs(f2) >= Math.abs(f3) || f3 <= 500.0f) && !a(view)) {
                        if (BottomSheetBehavior.this.b) {
                            i2 = BottomSheetBehavior.this.y;
                        } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.z()) < Math.abs(view.getTop() - BottomSheetBehavior.this.z)) {
                            i2 = BottomSheetBehavior.this.z();
                        } else {
                            i2 = BottomSheetBehavior.this.z;
                            i3 = 6;
                        }
                        i3 = 3;
                    } else {
                        i2 = BottomSheetBehavior.this.N;
                        i3 = 5;
                    }
                } else if (f3 != 0.0f && Math.abs(f2) <= Math.abs(f3)) {
                    if (BottomSheetBehavior.this.b) {
                        i2 = BottomSheetBehavior.this.B;
                    } else {
                        int top2 = view.getTop();
                        if (Math.abs(top2 - BottomSheetBehavior.this.z) < Math.abs(top2 - BottomSheetBehavior.this.B)) {
                            i2 = BottomSheetBehavior.this.z;
                            i3 = 6;
                        } else {
                            i2 = BottomSheetBehavior.this.B;
                        }
                    }
                } else {
                    int top3 = view.getTop();
                    if (BottomSheetBehavior.this.b) {
                        if (Math.abs(top3 - BottomSheetBehavior.this.y) < Math.abs(top3 - BottomSheetBehavior.this.B)) {
                            i2 = BottomSheetBehavior.this.y;
                            i3 = 3;
                        } else {
                            i2 = BottomSheetBehavior.this.B;
                        }
                    } else {
                        BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                        int i5 = bottomSheetBehavior3.z;
                        if (top3 < i5) {
                            if (top3 < Math.abs(top3 - bottomSheetBehavior3.B)) {
                                i2 = BottomSheetBehavior.this.z();
                                i3 = 3;
                            } else {
                                i2 = BottomSheetBehavior.this.z;
                            }
                        } else if (Math.abs(top3 - i5) < Math.abs(top3 - BottomSheetBehavior.this.B)) {
                            i2 = BottomSheetBehavior.this.z;
                        } else {
                            i2 = BottomSheetBehavior.this.B;
                        }
                        i3 = 6;
                    }
                }
            }
            BottomSheetBehavior.this.b0(view, i3, i2, true);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NonNull View view, int i2) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i3 = bottomSheetBehavior.G;
            if (i3 == 1 || bottomSheetBehavior.U) {
                return false;
            }
            if (i3 == 3 && bottomSheetBehavior.S == i2) {
                WeakReference<View> weakReference = bottomSheetBehavior.P;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.O;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements AccessibilityViewCommand {
        final /* synthetic */ int a;

        f(int i2) {
            this.a = i2;
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
            BottomSheetBehavior.this.V(this.a);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class g {
        public abstract void a(@NonNull View view, float f2);

        public abstract void b(@NonNull View view, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class h implements Runnable {
        private final View a;
        private boolean b;
        int c;

        h(View view, int i2) {
            this.a = view;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.H;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.a, this);
            } else {
                BottomSheetBehavior.this.W(this.c);
            }
            this.b = false;
        }
    }

    public BottomSheetBehavior() {
        this.a = 0;
        this.b = true;
        this.c = false;
        this.f4117k = -1;
        this.v = null;
        this.A = 0.5f;
        this.C = -1.0f;
        this.F = true;
        this.G = 4;
        this.Q = new ArrayList<>();
        this.W = -1;
        this.X = new e();
    }

    private float D() {
        VelocityTracker velocityTracker = this.R;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f4110d);
        return this.R.getYVelocity(this.S);
    }

    private void H(V v, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i2) {
        ViewCompat.replaceAccessibilityAction(v, accessibilityActionCompat, null, s(i2));
    }

    private void I() {
        this.S = -1;
        VelocityTracker velocityTracker = this.R;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.R = null;
        }
    }

    private void J(@NonNull SavedState savedState) {
        int i2 = this.a;
        if (i2 == 0) {
            return;
        }
        if (i2 == -1 || (i2 & 1) == 1) {
            this.f4111e = savedState.b;
        }
        if (i2 == -1 || (i2 & 2) == 2) {
            this.b = savedState.c;
        }
        if (i2 == -1 || (i2 & 4) == 4) {
            this.D = savedState.f4119d;
        }
        if (i2 == -1 || (i2 & 8) == 8) {
            this.E = savedState.f4120e;
        }
    }

    private void X(@NonNull View view) {
        boolean z = (Build.VERSION.SDK_INT < 29 || E() || this.f4112f) ? false : true;
        if (this.n || this.o || this.p || z) {
            p.b(view, new d(z));
        }
    }

    private void Z(int i2) {
        V v = this.O.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v)) {
            v.post(new b(v, i2));
        } else {
            Y(v, i2);
        }
    }

    private void c0() {
        V v;
        WeakReference<V> weakReference = this.O;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(v, 524288);
        ViewCompat.removeAccessibilityAction(v, 262144);
        ViewCompat.removeAccessibilityAction(v, 1048576);
        int i2 = this.W;
        if (i2 != -1) {
            ViewCompat.removeAccessibilityAction(v, i2);
        }
        if (!this.b && this.G != 6) {
            this.W = n(v, R.string.bottomsheet_action_expand_halfway, 6);
        }
        if (this.D && this.G != 5) {
            H(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        int i3 = this.G;
        if (i3 == 3) {
            H(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, this.b ? 4 : 6);
        } else if (i3 == 4) {
            H(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, this.b ? 3 : 6);
        } else if (i3 != 6) {
        } else {
            H(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
            H(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        }
    }

    private void d0(int i2) {
        ValueAnimator valueAnimator;
        if (i2 == 2) {
            return;
        }
        boolean z = i2 == 3;
        if (this.u != z) {
            this.u = z;
            if (this.f4116j == null || (valueAnimator = this.w) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.w.reverse();
                return;
            }
            float f2 = z ? 0.0f : 1.0f;
            this.w.setFloatValues(1.0f - f2, f2);
            this.w.start();
        }
    }

    private void e0(boolean z) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.O;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.V != null) {
                    return;
                }
                this.V = new HashMap(childCount);
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt != this.O.get()) {
                    if (z) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.V.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        if (this.c) {
                            ViewCompat.setImportantForAccessibility(childAt, 4);
                        }
                    } else if (this.c && (map = this.V) != null && map.containsKey(childAt)) {
                        ViewCompat.setImportantForAccessibility(childAt, this.V.get(childAt).intValue());
                    }
                }
            }
            if (!z) {
                this.V = null;
            } else if (this.c) {
                this.O.get().sendAccessibilityEvent(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(boolean z) {
        V v;
        if (this.O != null) {
            p();
            if (this.G != 4 || (v = this.O.get()) == null) {
                return;
            }
            if (z) {
                Z(this.G);
            } else {
                v.requestLayout();
            }
        }
    }

    private int n(V v, @StringRes int i2, int i3) {
        return ViewCompat.addAccessibilityAction(v, v.getResources().getString(i2), s(i3));
    }

    private void p() {
        int r = r();
        if (this.b) {
            this.B = Math.max(this.N - r, this.y);
        } else {
            this.B = this.N - r;
        }
    }

    private void q() {
        this.z = (int) (this.N * (1.0f - this.A));
    }

    private int r() {
        int i2;
        if (this.f4112f) {
            return Math.min(Math.max(this.f4113g, this.N - ((this.M * 9) / 16)), this.L) + this.r;
        }
        if (!this.m && !this.n && (i2 = this.f4118l) > 0) {
            return Math.max(this.f4111e, i2 + this.f4114h);
        }
        return this.f4111e + this.r;
    }

    private AccessibilityViewCommand s(int i2) {
        return new f(i2);
    }

    private void t(@NonNull Context context, AttributeSet attributeSet, boolean z) {
        u(context, attributeSet, z, null);
    }

    private void u(@NonNull Context context, AttributeSet attributeSet, boolean z, @Nullable ColorStateList colorStateList) {
        if (this.f4115i) {
            this.t = m.e(context, attributeSet, R.attr.bottomSheetStyle, Y).m();
            com.google.android.material.shape.h hVar = new com.google.android.material.shape.h(this.t);
            this.f4116j = hVar;
            hVar.L(context);
            if (z && colorStateList != null) {
                this.f4116j.W(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.f4116j.setTint(typedValue.data);
        }
    }

    private void v() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.w = ofFloat;
        ofFloat.setDuration(500L);
        this.w.addUpdateListener(new c());
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> y(@NonNull V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.shape.h A() {
        return this.f4116j;
    }

    public int B() {
        if (this.f4112f) {
            return -1;
        }
        return this.f4111e;
    }

    public int C() {
        return this.G;
    }

    public boolean E() {
        return this.m;
    }

    public boolean F() {
        return this.D;
    }

    public void G(@NonNull g gVar) {
        this.Q.remove(gVar);
    }

    public void K(boolean z) {
        this.F = z;
    }

    public void L(int i2) {
        if (i2 >= 0) {
            this.x = i2;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void M(boolean z) {
        if (this.b == z) {
            return;
        }
        this.b = z;
        if (this.O != null) {
            p();
        }
        W((this.b && this.G == 6) ? 3 : this.G);
        c0();
    }

    public void N(boolean z) {
        this.m = z;
    }

    public void O(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (f2 > 0.0f && f2 < 1.0f) {
            this.A = f2;
            if (this.O != null) {
                q();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void P(boolean z) {
        if (this.D != z) {
            this.D = z;
            if (!z && this.G == 5) {
                V(4);
            }
            c0();
        }
    }

    public void Q(@Px int i2) {
        this.f4117k = i2;
    }

    public void R(int i2) {
        S(i2, false);
    }

    public final void S(int i2, boolean z) {
        boolean z2 = true;
        if (i2 == -1) {
            if (!this.f4112f) {
                this.f4112f = true;
            }
            z2 = false;
        } else {
            if (this.f4112f || this.f4111e != i2) {
                this.f4112f = false;
                this.f4111e = Math.max(0, i2);
            }
            z2 = false;
        }
        if (z2) {
            f0(z);
        }
    }

    public void T(int i2) {
        this.a = i2;
    }

    public void U(boolean z) {
        this.E = z;
    }

    public void V(int i2) {
        if (i2 == this.G) {
            return;
        }
        if (this.O == null) {
            if (i2 == 4 || i2 == 3 || i2 == 6 || (this.D && i2 == 5)) {
                this.G = i2;
                return;
            }
            return;
        }
        Z(i2);
    }

    void W(int i2) {
        V v;
        if (this.G == i2) {
            return;
        }
        this.G = i2;
        WeakReference<V> weakReference = this.O;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (i2 == 3) {
            e0(true);
        } else if (i2 == 6 || i2 == 5 || i2 == 4) {
            e0(false);
        }
        d0(i2);
        for (int i3 = 0; i3 < this.Q.size(); i3++) {
            this.Q.get(i3).b(v, i2);
        }
        c0();
    }

    void Y(@NonNull View view, int i2) {
        int i3;
        int i4;
        if (i2 == 4) {
            i3 = this.B;
        } else if (i2 == 6) {
            int i5 = this.z;
            if (!this.b || i5 > (i4 = this.y)) {
                i3 = i5;
            } else {
                i3 = i4;
                i2 = 3;
            }
        } else if (i2 == 3) {
            i3 = z();
        } else if (this.D && i2 == 5) {
            i3 = this.N;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i2);
        }
        b0(view, i2, i3, false);
    }

    boolean a0(@NonNull View view, float f2) {
        if (this.E) {
            return true;
        }
        if (view.getTop() < this.B) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.B)) / ((float) r()) > 0.5f;
    }

    void b0(View view, int i2, int i3, boolean z) {
        ViewDragHelper viewDragHelper = this.H;
        if (viewDragHelper != null && (!z ? !viewDragHelper.smoothSlideViewTo(view, view.getLeft(), i3) : !viewDragHelper.settleCapturedViewAt(view.getLeft(), i3))) {
            W(2);
            d0(i2);
            if (this.v == null) {
                this.v = new h(view, i2);
            }
            if (!((h) this.v).b) {
                BottomSheetBehavior<V>.h hVar = this.v;
                hVar.c = i2;
                ViewCompat.postOnAnimation(view, hVar);
                ((h) this.v).b = true;
                return;
            }
            this.v.c = i2;
            return;
        }
        W(i2);
    }

    public void o(@NonNull g gVar) {
        if (this.Q.contains(gVar)) {
            return;
        }
        this.Q.add(gVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.O = null;
        this.H = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.O = null;
        this.H = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (v.isShown() && this.F) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                I();
            }
            if (this.R == null) {
                this.R = VelocityTracker.obtain();
            }
            this.R.addMovement(motionEvent);
            if (actionMasked == 0) {
                int x = (int) motionEvent.getX();
                this.T = (int) motionEvent.getY();
                if (this.G != 2) {
                    WeakReference<View> weakReference = this.P;
                    View view = weakReference != null ? weakReference.get() : null;
                    if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.T)) {
                        this.S = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.U = true;
                    }
                }
                this.I = this.S == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.T);
            } else if (actionMasked == 1 || actionMasked == 3) {
                this.U = false;
                this.S = -1;
                if (this.I) {
                    this.I = false;
                    return false;
                }
            }
            if (this.I || (viewDragHelper = this.H) == null || !viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
                WeakReference<View> weakReference2 = this.P;
                View view2 = weakReference2 != null ? weakReference2.get() : null;
                return (actionMasked != 2 || view2 == null || this.I || this.G == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.H == null || Math.abs(((float) this.T) - motionEvent.getY()) <= ((float) this.H.getTouchSlop())) ? false : true;
            }
            return true;
        }
        this.I = true;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        com.google.android.material.shape.h hVar;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.O == null) {
            this.f4113g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            X(v);
            this.O = new WeakReference<>(v);
            if (this.f4115i && (hVar = this.f4116j) != null) {
                ViewCompat.setBackground(v, hVar);
            }
            com.google.android.material.shape.h hVar2 = this.f4116j;
            if (hVar2 != null) {
                float f2 = this.C;
                if (f2 == -1.0f) {
                    f2 = ViewCompat.getElevation(v);
                }
                hVar2.V(f2);
                boolean z = this.G == 3;
                this.u = z;
                this.f4116j.X(z ? 0.0f : 1.0f);
            }
            c0();
            if (ViewCompat.getImportantForAccessibility(v) == 0) {
                ViewCompat.setImportantForAccessibility(v, 1);
            }
            int measuredWidth = v.getMeasuredWidth();
            int i3 = this.f4117k;
            if (measuredWidth > i3 && i3 != -1) {
                ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                layoutParams.width = this.f4117k;
                v.post(new a(this, v, layoutParams));
            }
        }
        if (this.H == null) {
            this.H = ViewDragHelper.create(coordinatorLayout, this.X);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i2);
        this.M = coordinatorLayout.getWidth();
        this.N = coordinatorLayout.getHeight();
        int height = v.getHeight();
        this.L = height;
        int i4 = this.N;
        int i5 = i4 - height;
        int i6 = this.s;
        if (i5 < i6) {
            if (this.q) {
                this.L = i4;
            } else {
                this.L = i4 - i6;
            }
        }
        this.y = Math.max(0, i4 - this.L);
        q();
        p();
        int i7 = this.G;
        if (i7 == 3) {
            ViewCompat.offsetTopAndBottom(v, z());
        } else if (i7 == 6) {
            ViewCompat.offsetTopAndBottom(v, this.z);
        } else if (this.D && i7 == 5) {
            ViewCompat.offsetTopAndBottom(v, this.N);
        } else if (i7 == 4) {
            ViewCompat.offsetTopAndBottom(v, this.B);
        } else if (i7 == 1 || i7 == 2) {
            ViewCompat.offsetTopAndBottom(v, top - v.getTop());
        }
        this.P = new WeakReference<>(x(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, float f2, float f3) {
        WeakReference<View> weakReference = this.P;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.G != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f2, f3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, @NonNull int[] iArr, int i4) {
        if (i4 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.P;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i5 = top - i3;
        if (i3 > 0) {
            if (i5 < z()) {
                iArr[1] = top - z();
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                W(3);
            } else if (!this.F) {
                return;
            } else {
                iArr[1] = i3;
                ViewCompat.offsetTopAndBottom(v, -i3);
                W(1);
            }
        } else if (i3 < 0 && !view.canScrollVertically(-1)) {
            int i6 = this.B;
            if (i5 > i6 && !this.D) {
                iArr[1] = top - i6;
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                W(4);
            } else if (!this.F) {
                return;
            } else {
                iArr[1] = i3;
                ViewCompat.offsetTopAndBottom(v, -i3);
                W(1);
            }
        }
        w(v.getTop());
        this.J = i3;
        this.K = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        J(savedState);
        int i2 = savedState.a;
        if (i2 != 1 && i2 != 2) {
            this.G = i2;
        } else {
            this.G = 4;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2, int i3) {
        this.J = 0;
        this.K = false;
        return (i2 & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2) {
        int i3;
        int i4 = 3;
        if (v.getTop() == z()) {
            W(3);
            return;
        }
        WeakReference<View> weakReference = this.P;
        if (weakReference != null && view == weakReference.get() && this.K) {
            if (this.J > 0) {
                if (this.b) {
                    i3 = this.y;
                } else {
                    int top = v.getTop();
                    int i5 = this.z;
                    if (top > i5) {
                        i3 = i5;
                        i4 = 6;
                    } else {
                        i3 = z();
                    }
                }
            } else if (this.D && a0(v, D())) {
                i3 = this.N;
                i4 = 5;
            } else if (this.J == 0) {
                int top2 = v.getTop();
                if (this.b) {
                    if (Math.abs(top2 - this.y) < Math.abs(top2 - this.B)) {
                        i3 = this.y;
                    } else {
                        i3 = this.B;
                        i4 = 4;
                    }
                } else {
                    int i6 = this.z;
                    if (top2 < i6) {
                        if (top2 < Math.abs(top2 - this.B)) {
                            i3 = z();
                        } else {
                            i3 = this.z;
                        }
                    } else if (Math.abs(top2 - i6) < Math.abs(top2 - this.B)) {
                        i3 = this.z;
                    } else {
                        i3 = this.B;
                        i4 = 4;
                    }
                    i4 = 6;
                }
            } else {
                if (this.b) {
                    i3 = this.B;
                } else {
                    int top3 = v.getTop();
                    if (Math.abs(top3 - this.z) < Math.abs(top3 - this.B)) {
                        i3 = this.z;
                        i4 = 6;
                    } else {
                        i3 = this.B;
                    }
                }
                i4 = 4;
            }
            b0(v, i4, i3, false);
            this.K = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        if (v.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            if (this.G == 1 && actionMasked == 0) {
                return true;
            }
            ViewDragHelper viewDragHelper = this.H;
            if (viewDragHelper != null) {
                viewDragHelper.processTouchEvent(motionEvent);
            }
            if (actionMasked == 0) {
                I();
            }
            if (this.R == null) {
                this.R = VelocityTracker.obtain();
            }
            this.R.addMovement(motionEvent);
            if (this.H != null && actionMasked == 2 && !this.I && Math.abs(this.T - motionEvent.getY()) > this.H.getTouchSlop()) {
                this.H.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
            return !this.I;
        }
        return false;
    }

    void w(int i2) {
        float f2;
        float f3;
        V v = this.O.get();
        if (v == null || this.Q.isEmpty()) {
            return;
        }
        int i3 = this.B;
        if (i2 <= i3 && i3 != z()) {
            int i4 = this.B;
            f2 = i4 - i2;
            f3 = i4 - z();
        } else {
            int i5 = this.B;
            f2 = i5 - i2;
            f3 = this.N - i5;
        }
        float f4 = f2 / f3;
        for (int i6 = 0; i6 < this.Q.size(); i6++) {
            this.Q.get(i6).a(v, f4);
        }
    }

    @Nullable
    @VisibleForTesting
    View x(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View x = x(viewGroup.getChildAt(i2));
                if (x != null) {
                    return x;
                }
            }
            return null;
        }
        return null;
    }

    public int z() {
        if (this.b) {
            return this.y;
        }
        return Math.max(this.x, this.q ? 0 : this.s);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        final int a;
        int b;
        boolean c;

        /* renamed from: d  reason: collision with root package name */
        boolean f4119d;

        /* renamed from: e  reason: collision with root package name */
        boolean f4120e;

        /* loaded from: classes2.dex */
        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
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
            this.b = parcel.readInt();
            this.c = parcel.readInt() == 1;
            this.f4119d = parcel.readInt() == 1;
            this.f4120e = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
            parcel.writeInt(this.f4119d ? 1 : 0);
            parcel.writeInt(this.f4120e ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.a = bottomSheetBehavior.G;
            this.b = ((BottomSheetBehavior) bottomSheetBehavior).f4111e;
            this.c = ((BottomSheetBehavior) bottomSheetBehavior).b;
            this.f4119d = bottomSheetBehavior.D;
            this.f4120e = ((BottomSheetBehavior) bottomSheetBehavior).E;
        }
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        this.a = 0;
        this.b = true;
        this.c = false;
        this.f4117k = -1;
        this.v = null;
        this.A = 0.5f;
        this.C = -1.0f;
        this.F = true;
        this.G = 4;
        this.Q = new ArrayList<>();
        this.W = -1;
        this.X = new e();
        this.f4114h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.f4115i = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int i3 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean hasValue = obtainStyledAttributes.hasValue(i3);
        if (hasValue) {
            u(context, attributeSet, hasValue, com.google.android.material.f.c.a(context, obtainStyledAttributes, i3));
        } else {
            t(context, attributeSet, hasValue);
        }
        v();
        if (Build.VERSION.SDK_INT >= 21) {
            this.C = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        int i4 = R.styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (obtainStyledAttributes.hasValue(i4)) {
            Q(obtainStyledAttributes.getDimensionPixelSize(i4, -1));
        }
        int i5 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i5);
        if (peekValue != null && (i2 = peekValue.data) == -1) {
            R(i2);
        } else {
            R(obtainStyledAttributes.getDimensionPixelSize(i5, -1));
        }
        P(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        N(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        M(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        U(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        K(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        T(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        O(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i6 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i6);
        if (peekValue2 != null && peekValue2.type == 16) {
            L(peekValue2.data);
        } else {
            L(obtainStyledAttributes.getDimensionPixelOffset(i6, 0));
        }
        this.n = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.o = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.p = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.q = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        obtainStyledAttributes.recycle();
        this.f4110d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
