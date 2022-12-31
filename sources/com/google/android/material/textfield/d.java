package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.shape.m;
import com.google.android.material.textfield.TextInputLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DropdownMenuEndIconDelegate.java */
/* loaded from: classes2.dex */
public class d extends com.google.android.material.textfield.e {
    private static final boolean q;

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f4614d;

    /* renamed from: e  reason: collision with root package name */
    private final View.OnFocusChangeListener f4615e;

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.e f4616f;

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.f f4617g;
    @SuppressLint({"ClickableViewAccessibility"})

    /* renamed from: h  reason: collision with root package name */
    private final TextInputLayout.g f4618h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4619i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4620j;

    /* renamed from: k  reason: collision with root package name */
    private long f4621k;

    /* renamed from: l  reason: collision with root package name */
    private StateListDrawable f4622l;
    private com.google.android.material.shape.h m;
    @Nullable
    private AccessibilityManager n;
    private ValueAnimator o;
    private ValueAnimator p;

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class a extends com.google.android.material.internal.j {

        /* compiled from: DropdownMenuEndIconDelegate.java */
        /* renamed from: com.google.android.material.textfield.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0182a implements Runnable {
            final /* synthetic */ AutoCompleteTextView a;

            RunnableC0182a(AutoCompleteTextView autoCompleteTextView) {
                this.a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.a.isPopupShowing();
                d.this.E(isPopupShowing);
                d.this.f4619i = isPopupShowing;
            }
        }

        a() {
        }

        @Override // com.google.android.material.internal.j, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView y = d.y(d.this.a.L());
            if (d.this.n.isTouchExplorationEnabled() && d.D(y) && !d.this.c.hasFocus()) {
                y.dismissDropDown();
            }
            y.post(new RunnableC0182a(y));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            d.this.c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class c implements View.OnFocusChangeListener {
        c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        @Instrumented
        public void onFocusChange(View view, boolean z) {
            VdsAgent.onFocusChange(this, view, z);
            d.this.a.setEndIconActivated(z);
            if (z) {
                return;
            }
            d.this.E(false);
            d.this.f4619i = false;
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* renamed from: com.google.android.material.textfield.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0183d extends TextInputLayout.e {
        C0183d(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!d.D(d.this.a.L())) {
                accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
            }
            if (accessibilityNodeInfoCompat.isShowingHintText()) {
                accessibilityNodeInfoCompat.setHintText(null);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView y = d.y(d.this.a.L());
            if (accessibilityEvent.getEventType() == 1 && d.this.n.isTouchExplorationEnabled() && !d.D(d.this.a.L())) {
                d.this.H(y);
            }
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class e implements TextInputLayout.f {
        e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(@NonNull TextInputLayout textInputLayout) {
            AutoCompleteTextView y = d.y(textInputLayout.L());
            d.this.F(y);
            d.this.v(y);
            d.this.G(y);
            y.setThreshold(0);
            y.removeTextChangedListener(d.this.f4614d);
            y.addTextChangedListener(d.this.f4614d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!d.D(y)) {
                ViewCompat.setImportantForAccessibility(d.this.c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(d.this.f4616f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class f implements TextInputLayout.g {

        /* compiled from: DropdownMenuEndIconDelegate.java */
        /* loaded from: classes2.dex */
        class a implements Runnable {
            final /* synthetic */ AutoCompleteTextView a;

            a(AutoCompleteTextView autoCompleteTextView) {
                this.a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.removeTextChangedListener(d.this.f4614d);
            }
        }

        f() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(@NonNull TextInputLayout textInputLayout, int i2) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.L();
            if (autoCompleteTextView == null || i2 != 3) {
                return;
            }
            autoCompleteTextView.post(new a(autoCompleteTextView));
            if (autoCompleteTextView.getOnFocusChangeListener() == d.this.f4615e) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            if (d.q) {
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            d.this.H((AutoCompleteTextView) d.this.a.L());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class h implements View.OnTouchListener {
        final /* synthetic */ AutoCompleteTextView a;

        h(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (d.this.C()) {
                    d.this.f4619i = false;
                }
                d.this.H(this.a);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class i implements AutoCompleteTextView.OnDismissListener {
        i() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            d.this.f4619i = true;
            d.this.f4621k = System.currentTimeMillis();
            d.this.E(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class j extends AnimatorListenerAdapter {
        j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            dVar.c.setChecked(dVar.f4620j);
            d.this.p.start();
        }
    }

    static {
        q = Build.VERSION.SDK_INT >= 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f4614d = new a();
        this.f4615e = new c();
        this.f4616f = new C0183d(this.a);
        this.f4617g = new e();
        this.f4618h = new f();
        this.f4619i = false;
        this.f4620j = false;
        this.f4621k = LocationRequestCompat.PASSIVE_INTERVAL;
    }

    private com.google.android.material.shape.h A(float f2, float f3, float f4, int i2) {
        m.b a2 = m.a();
        a2.E(f2);
        a2.I(f2);
        a2.v(f3);
        a2.z(f3);
        m m = a2.m();
        com.google.android.material.shape.h m2 = com.google.android.material.shape.h.m(this.b, f4);
        m2.setShapeAppearanceModel(m);
        m2.Y(0, i2, 0, i2);
        return m2;
    }

    private void B() {
        this.p = z(67, 0.0f, 1.0f);
        ValueAnimator z = z(50, 1.0f, 0.0f);
        this.o = z;
        z.addListener(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        long currentTimeMillis = System.currentTimeMillis() - this.f4621k;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean D(@NonNull EditText editText) {
        return editText.getKeyListener() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z) {
        if (this.f4620j != z) {
            this.f4620j = z;
            this.p.cancel();
            this.o.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(@NonNull AutoCompleteTextView autoCompleteTextView) {
        if (q) {
            int I = this.a.I();
            if (I == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.m);
            } else if (I == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f4622l);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void G(@NonNull AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new h(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f4615e);
        if (q) {
            autoCompleteTextView.setOnDismissListener(new i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(@Nullable AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (C()) {
            this.f4619i = false;
        }
        if (!this.f4619i) {
            if (q) {
                E(!this.f4620j);
            } else {
                this.f4620j = !this.f4620j;
                this.c.toggle();
            }
            if (this.f4620j) {
                autoCompleteTextView.requestFocus();
                autoCompleteTextView.showDropDown();
                return;
            }
            autoCompleteTextView.dismissDropDown();
            return;
        }
        this.f4619i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(@NonNull AutoCompleteTextView autoCompleteTextView) {
        if (D(autoCompleteTextView)) {
            return;
        }
        int I = this.a.I();
        com.google.android.material.shape.h G = this.a.G();
        int d2 = com.google.android.material.b.a.d(autoCompleteTextView, R.attr.colorControlHighlight);
        int[][] iArr = {new int[]{16842919}, new int[0]};
        if (I == 2) {
            x(autoCompleteTextView, d2, iArr, G);
        } else if (I == 1) {
            w(autoCompleteTextView, d2, iArr, G);
        }
    }

    private void w(@NonNull AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, @NonNull com.google.android.material.shape.h hVar) {
        int H = this.a.H();
        int[] iArr2 = {com.google.android.material.b.a.h(i2, H, 0.1f), H};
        if (q) {
            ViewCompat.setBackground(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), hVar, hVar));
            return;
        }
        com.google.android.material.shape.h hVar2 = new com.google.android.material.shape.h(hVar.C());
        hVar2.W(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{hVar, hVar2});
        int paddingStart = ViewCompat.getPaddingStart(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
        ViewCompat.setPaddingRelative(autoCompleteTextView, paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    private void x(@NonNull AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, @NonNull com.google.android.material.shape.h hVar) {
        LayerDrawable layerDrawable;
        int d2 = com.google.android.material.b.a.d(autoCompleteTextView, R.attr.colorSurface);
        com.google.android.material.shape.h hVar2 = new com.google.android.material.shape.h(hVar.C());
        int h2 = com.google.android.material.b.a.h(i2, d2, 0.1f);
        hVar2.W(new ColorStateList(iArr, new int[]{h2, 0}));
        if (q) {
            hVar2.setTint(d2);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{h2, d2});
            com.google.android.material.shape.h hVar3 = new com.google.android.material.shape.h(hVar.C());
            hVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, hVar2, hVar3), hVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{hVar2, hVar});
        }
        ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static AutoCompleteTextView y(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator z(int i2, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(com.google.android.material.animation.a.a);
        ofFloat.setDuration(i2);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        float dimensionPixelOffset = this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        com.google.android.material.shape.h A = A(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        com.google.android.material.shape.h A2 = A(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.m = A;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f4622l = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, A);
        this.f4622l.addState(new int[0], A2);
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.b, q ? R.drawable.mtrl_dropdown_arrow : R.drawable.mtrl_ic_arrow_drop_down));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.a.setEndIconOnClickListener(new g());
        this.a.e(this.f4617g);
        this.a.f(this.f4618h);
        B();
        this.n = (AccessibilityManager) this.b.getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public boolean b(int i2) {
        return i2 != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public boolean d() {
        return true;
    }
}
