package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
/* compiled from: ViewUtils.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class p {

    /* compiled from: ViewUtils.java */
    /* loaded from: classes2.dex */
    static class a implements Runnable {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.a.getContext().getSystemService("input_method")).showSoftInput(this.a, 1);
        }
    }

    /* compiled from: ViewUtils.java */
    /* loaded from: classes2.dex */
    static class b implements e {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e f4382d;

        b(boolean z, boolean z2, boolean z3, e eVar) {
            this.a = z;
            this.b = z2;
            this.c = z3;
            this.f4382d = eVar;
        }

        @Override // com.google.android.material.internal.p.e
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull f fVar) {
            if (this.a) {
                fVar.f4383d += windowInsetsCompat.getSystemWindowInsetBottom();
            }
            boolean h2 = p.h(view);
            if (this.b) {
                if (h2) {
                    fVar.c += windowInsetsCompat.getSystemWindowInsetLeft();
                } else {
                    fVar.a += windowInsetsCompat.getSystemWindowInsetLeft();
                }
            }
            if (this.c) {
                if (h2) {
                    fVar.a += windowInsetsCompat.getSystemWindowInsetRight();
                } else {
                    fVar.c += windowInsetsCompat.getSystemWindowInsetRight();
                }
            }
            fVar.a(view);
            e eVar = this.f4382d;
            return eVar != null ? eVar.a(view, windowInsetsCompat, fVar) : windowInsetsCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewUtils.java */
    /* loaded from: classes2.dex */
    public static class c implements OnApplyWindowInsetsListener {
        final /* synthetic */ e a;
        final /* synthetic */ f b;

        c(e eVar, f fVar) {
            this.a = eVar;
            this.b = fVar;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return this.a.a(view, windowInsetsCompat, new f(this.b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewUtils.java */
    /* loaded from: classes2.dex */
    public static class d implements View.OnAttachStateChangeListener {
        d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NonNull View view) {
            view.removeOnAttachStateChangeListener(this);
            ViewCompat.requestApplyInsets(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* compiled from: ViewUtils.java */
    /* loaded from: classes2.dex */
    public interface e {
        WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, f fVar);
    }

    public static void a(@NonNull View view, @Nullable AttributeSet attributeSet, int i2, int i3, @Nullable e eVar) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.Insets, i2, i3);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingRightSystemWindowInsets, false);
        obtainStyledAttributes.recycle();
        b(view, new b(z, z2, z3, eVar));
    }

    public static void b(@NonNull View view, @NonNull e eVar) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new c(eVar, new f(ViewCompat.getPaddingStart(view), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom())));
        j(view);
    }

    public static float c(@NonNull Context context, @Dimension(unit = 0) int i2) {
        return TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
    }

    @Nullable
    public static ViewGroup d(@Nullable View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(16908290);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    @Nullable
    public static o e(@NonNull View view) {
        return f(d(view));
    }

    @Nullable
    public static o f(@Nullable View view) {
        if (view == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            return new n(view);
        }
        return ViewOverlayApi14.a(view);
    }

    public static float g(@NonNull View view) {
        float f2 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f2 += ViewCompat.getElevation((View) parent);
        }
        return f2;
    }

    public static boolean h(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static PorterDuff.Mode i(int i2, PorterDuff.Mode mode) {
        if (i2 != 3) {
            if (i2 != 5) {
                if (i2 != 9) {
                    switch (i2) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    public static void j(@NonNull View view) {
        if (ViewCompat.isAttachedToWindow(view)) {
            ViewCompat.requestApplyInsets(view);
        } else {
            view.addOnAttachStateChangeListener(new d());
        }
    }

    public static void k(@NonNull View view) {
        view.requestFocus();
        view.post(new a(view));
    }

    /* compiled from: ViewUtils.java */
    /* loaded from: classes2.dex */
    public static class f {
        public int a;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f4383d;

        public f(int i2, int i3, int i4, int i5) {
            this.a = i2;
            this.b = i3;
            this.c = i4;
            this.f4383d = i5;
        }

        public void a(View view) {
            ViewCompat.setPaddingRelative(view, this.a, this.b, this.c, this.f4383d);
        }

        public f(@NonNull f fVar) {
            this.a = fVar.a;
            this.b = fVar.b;
            this.c = fVar.c;
            this.f4383d = fVar.f4383d;
        }
    }
}
