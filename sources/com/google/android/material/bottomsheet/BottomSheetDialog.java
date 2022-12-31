package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.shape.h;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* loaded from: classes2.dex */
public class BottomSheetDialog extends AppCompatDialog {
    private BottomSheetBehavior<FrameLayout> a;
    private FrameLayout b;
    private CoordinatorLayout c;

    /* renamed from: d  reason: collision with root package name */
    private FrameLayout f4122d;

    /* renamed from: e  reason: collision with root package name */
    boolean f4123e;

    /* renamed from: f  reason: collision with root package name */
    boolean f4124f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4125g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4126h;

    /* renamed from: i  reason: collision with root package name */
    private BottomSheetBehavior.g f4127i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4128j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private BottomSheetBehavior.g f4129k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            if (BottomSheetDialog.this.f4127i != null) {
                BottomSheetDialog.this.a.G(BottomSheetDialog.this.f4127i);
            }
            if (windowInsetsCompat != null) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                bottomSheetDialog.f4127i = new f(bottomSheetDialog.f4122d, windowInsetsCompat, null);
                BottomSheetDialog.this.a.o(BottomSheetDialog.this.f4127i);
            }
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
            if (bottomSheetDialog.f4124f && bottomSheetDialog.isShowing() && BottomSheetDialog.this.j()) {
                BottomSheetDialog.this.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends AccessibilityDelegateCompat {
        c() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (BottomSheetDialog.this.f4124f) {
                accessibilityNodeInfoCompat.addAction(1048576);
                accessibilityNodeInfoCompat.setDismissable(true);
                return;
            }
            accessibilityNodeInfoCompat.setDismissable(false);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (i2 == 1048576) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.f4124f) {
                    bottomSheetDialog.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i2, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements View.OnTouchListener {
        d(BottomSheetDialog bottomSheetDialog) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: classes2.dex */
    class e extends BottomSheetBehavior.g {
        e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void a(@NonNull View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(@NonNull View view, int i2) {
            if (i2 == 5) {
                BottomSheetDialog.this.cancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class f extends BottomSheetBehavior.g {
        private final boolean a;
        private final boolean b;
        private final WindowInsetsCompat c;

        /* synthetic */ f(View view, WindowInsetsCompat windowInsetsCompat, a aVar) {
            this(view, windowInsetsCompat);
        }

        private void c(View view) {
            if (view.getTop() < this.c.getSystemWindowInsetTop()) {
                BottomSheetDialog.i(view, this.a);
                view.setPadding(view.getPaddingLeft(), this.c.getSystemWindowInsetTop() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                BottomSheetDialog.i(view, this.b);
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void a(@NonNull View view, float f2) {
            c(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(@NonNull View view, int i2) {
            c(view);
        }

        private f(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            ColorStateList backgroundTintList;
            this.c = windowInsetsCompat;
            boolean z = Build.VERSION.SDK_INT >= 23 && (view.getSystemUiVisibility() & 8192) != 0;
            this.b = z;
            h A = BottomSheetBehavior.y(view).A();
            if (A != null) {
                backgroundTintList = A.x();
            } else {
                backgroundTintList = ViewCompat.getBackgroundTintList(view);
            }
            if (backgroundTintList != null) {
                this.a = com.google.android.material.b.a.f(backgroundTintList.getDefaultColor());
            } else if (view.getBackground() instanceof ColorDrawable) {
                this.a = com.google.android.material.b.a.f(((ColorDrawable) view.getBackground()).getColor());
            } else {
                this.a = z;
            }
        }
    }

    public BottomSheetDialog(@NonNull Context context) {
        this(context, 0);
        this.f4128j = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    private FrameLayout e() {
        if (this.b == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
            this.b = frameLayout;
            this.c = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.b.findViewById(R.id.design_bottom_sheet);
            this.f4122d = frameLayout2;
            BottomSheetBehavior<FrameLayout> y = BottomSheetBehavior.y(frameLayout2);
            this.a = y;
            y.o(this.f4129k);
            this.a.P(this.f4124f);
        }
        return this.b;
    }

    private static int getThemeResId(@NonNull Context context, int i2) {
        if (i2 == 0) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
                return typedValue.resourceId;
            }
            return R.style.Theme_Design_Light_BottomSheetDialog;
        }
        return i2;
    }

    public static void i(@NonNull View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = view.getSystemUiVisibility();
            view.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    private View k(int i2, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        e();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.b.findViewById(R.id.coordinator);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f4128j) {
            ViewCompat.setOnApplyWindowInsetsListener(this.f4122d, new a());
        }
        this.f4122d.removeAllViews();
        if (layoutParams == null) {
            this.f4122d.addView(view);
        } else {
            this.f4122d.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new b());
        ViewCompat.setAccessibilityDelegate(this.f4122d, new c());
        this.f4122d.setOnTouchListener(new d(this));
        return this.b;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> f2 = f();
        if (this.f4123e && f2.C() != 5) {
            f2.V(5);
        } else {
            super.cancel();
        }
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> f() {
        if (this.a == null) {
            e();
        }
        return this.a;
    }

    public boolean g() {
        return this.f4123e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.a.G(this.f4129k);
    }

    boolean j() {
        if (!this.f4126h) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.f4125g = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.f4126h = true;
        }
        return this.f4125g;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window == null || Build.VERSION.SDK_INT < 21) {
            return;
        }
        boolean z = this.f4128j && Color.alpha(window.getNavigationBarColor()) < 255;
        FrameLayout frameLayout = this.b;
        if (frameLayout != null) {
            frameLayout.setFitsSystemWindows(!z);
        }
        CoordinatorLayout coordinatorLayout = this.c;
        if (coordinatorLayout != null) {
            coordinatorLayout.setFitsSystemWindows(!z);
        }
        if (z) {
            window.getDecorView().setSystemUiVisibility(768);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                window.setStatusBarColor(0);
                window.addFlags(Integer.MIN_VALUE);
                if (i2 < 23) {
                    window.addFlags(67108864);
                }
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.a;
        if (bottomSheetBehavior == null || bottomSheetBehavior.C() != 5) {
            return;
        }
        this.a.V(4);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f4124f != z) {
            this.f4124f = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.a;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.P(z);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f4124f) {
            this.f4124f = true;
        }
        this.f4125g = z;
        this.f4126h = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(@LayoutRes int i2) {
        super.setContentView(k(i2, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(k(0, view, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(k(0, view, layoutParams));
    }

    public BottomSheetDialog(@NonNull Context context, @StyleRes int i2) {
        super(context, getThemeResId(context, i2));
        this.f4124f = true;
        this.f4125g = true;
        this.f4129k = new e();
        supportRequestWindowFeature(1);
        this.f4128j = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }
}
