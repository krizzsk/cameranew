package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.shape.m;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* loaded from: classes2.dex */
public class TextInputLayout extends LinearLayout {
    private static final int P0 = R.style.Widget_Design_TextInputLayout;
    private boolean A;
    @ColorInt
    private int A0;
    private CharSequence B;
    @ColorInt
    private int B0;
    private boolean C;
    private ColorStateList C0;
    @Nullable
    private com.google.android.material.shape.h D;
    @ColorInt
    private int D0;
    @Nullable
    private com.google.android.material.shape.h E;
    @ColorInt
    private int E0;
    @NonNull
    private m F;
    @ColorInt
    private int F0;
    private final int G;
    @ColorInt
    private int G0;
    private int H;
    @ColorInt
    private int H0;
    private int I;
    private boolean I0;
    private int J;
    final com.google.android.material.internal.a J0;
    private int K;
    private boolean K0;
    private int L;
    private boolean L0;
    private int M;
    private ValueAnimator M0;
    @ColorInt
    private int N;
    private boolean N0;
    @ColorInt
    private int O;
    private boolean O0;
    private final Rect P;
    private final Rect Q;
    private final RectF R;
    private Typeface S;
    @NonNull
    private final CheckableImageButton T;
    private ColorStateList U;
    private boolean V;
    private PorterDuff.Mode W;
    @NonNull
    private final FrameLayout a;
    @NonNull
    private final LinearLayout b;
    @NonNull
    private final LinearLayout c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f4597d;
    private boolean d0;

    /* renamed from: e  reason: collision with root package name */
    EditText f4598e;
    @Nullable
    private Drawable e0;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f4599f;
    private int f0;

    /* renamed from: g  reason: collision with root package name */
    private int f4600g;
    private View.OnLongClickListener g0;

    /* renamed from: h  reason: collision with root package name */
    private int f4601h;
    private final LinkedHashSet<f> h0;

    /* renamed from: i  reason: collision with root package name */
    private final com.google.android.material.textfield.f f4602i;
    private int i0;

    /* renamed from: j  reason: collision with root package name */
    boolean f4603j;
    private final SparseArray<com.google.android.material.textfield.e> j0;

    /* renamed from: k  reason: collision with root package name */
    private int f4604k;
    @NonNull
    private final CheckableImageButton k0;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4605l;
    private final LinkedHashSet<g> l0;
    @Nullable
    private TextView m;
    private ColorStateList m0;
    private int n;
    private boolean n0;
    private int o;
    private PorterDuff.Mode o0;
    private CharSequence p;
    private boolean p0;
    private boolean q;
    @Nullable
    private Drawable q0;
    private TextView r;
    private int r0;
    @Nullable
    private ColorStateList s;
    private Drawable s0;
    private int t;
    private View.OnLongClickListener t0;
    @Nullable
    private ColorStateList u;
    private View.OnLongClickListener u0;
    @Nullable
    private ColorStateList v;
    @NonNull
    private final CheckableImageButton v0;
    @Nullable
    private CharSequence w;
    private ColorStateList w0;
    @NonNull
    private final TextView x;
    private ColorStateList x0;
    @Nullable
    private CharSequence y;
    private ColorStateList y0;
    @NonNull
    private final TextView z;
    @ColorInt
    private int z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        @Nullable
        CharSequence a;
        boolean b;
        @Nullable
        CharSequence c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        CharSequence f4606d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        CharSequence f4607e;

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

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.a) + " hint=" + ((Object) this.c) + " helperText=" + ((Object) this.f4606d) + " placeholderText=" + ((Object) this.f4607e) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.a, parcel, i2);
            parcel.writeInt(this.b ? 1 : 0);
            TextUtils.writeToParcel(this.c, parcel, i2);
            TextUtils.writeToParcel(this.f4606d, parcel, i2);
            TextUtils.writeToParcel(this.f4607e, parcel, i2);
        }

        SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.b = parcel.readInt() == 1;
            this.c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f4606d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f4607e = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.S0(!textInputLayout.O0);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f4603j) {
                textInputLayout2.K0(editable.length());
            }
            if (TextInputLayout.this.q) {
                TextInputLayout.this.W0(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.k0.performClick();
            TextInputLayout.this.k0.jumpDrawablesToCurrentState();
        }
    }

    /* loaded from: classes2.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f4598e.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TextInputLayout.this.J0.i0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends AccessibilityDelegateCompat {
        private final TextInputLayout a;

        public e(@NonNull TextInputLayout textInputLayout) {
            this.a = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText L = this.a.L();
            CharSequence text = L != null ? L.getText() : null;
            CharSequence U = this.a.U();
            CharSequence R = this.a.R();
            CharSequence X = this.a.X();
            int J = this.a.J();
            CharSequence K = this.a.K();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(U);
            boolean z3 = !this.a.g0();
            boolean z4 = !TextUtils.isEmpty(R);
            boolean z5 = z4 || !TextUtils.isEmpty(K);
            String charSequence = z2 ? U.toString() : "";
            if (z) {
                accessibilityNodeInfoCompat.setText(text);
            } else if (!TextUtils.isEmpty(charSequence)) {
                accessibilityNodeInfoCompat.setText(charSequence);
                if (z3 && X != null) {
                    accessibilityNodeInfoCompat.setText(charSequence + ", " + ((Object) X));
                }
            } else if (X != null) {
                accessibilityNodeInfoCompat.setText(X);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(charSequence);
                } else {
                    if (z) {
                        charSequence = ((Object) text) + ", " + charSequence;
                    }
                    accessibilityNodeInfoCompat.setText(charSequence);
                }
                accessibilityNodeInfoCompat.setShowingHintText(!z);
            }
            accessibilityNodeInfoCompat.setMaxTextLength((text == null || text.length() != J) ? -1 : -1);
            if (z5) {
                if (!z4) {
                    R = K;
                }
                accessibilityNodeInfoCompat.setError(R);
            }
            if (Build.VERSION.SDK_INT < 17 || L == null) {
                return;
            }
            L.setLabelFor(R.id.textinput_helper_text);
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a(@NonNull TextInputLayout textInputLayout);
    }

    /* loaded from: classes2.dex */
    public interface g {
        void a(@NonNull TextInputLayout textInputLayout, int i2);
    }

    public TextInputLayout(@NonNull Context context) {
        this(context, null);
    }

    private boolean A() {
        return this.A && !TextUtils.isEmpty(this.B) && (this.D instanceof com.google.android.material.textfield.c);
    }

    private void A0(boolean z) {
        if (this.q == z) {
            return;
        }
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.r = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_placeholder);
            ViewCompat.setAccessibilityLiveRegion(this.r, 1);
            setPlaceholderTextAppearance(this.t);
            setPlaceholderTextColor(this.s);
            g();
        } else {
            s0();
            this.r = null;
        }
        this.q = z;
    }

    private void B() {
        Iterator<f> it = this.h0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void C(int i2) {
        Iterator<g> it = this.l0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2);
        }
    }

    private boolean C0() {
        return (this.v0.getVisibility() == 0 || ((b0() && d0()) || this.y != null)) && this.c.getMeasuredWidth() > 0;
    }

    private void D(Canvas canvas) {
        com.google.android.material.shape.h hVar = this.E;
        if (hVar != null) {
            Rect bounds = hVar.getBounds();
            bounds.top = bounds.bottom - this.K;
            this.E.draw(canvas);
        }
    }

    private boolean D0() {
        return !(Z() == null && this.w == null) && this.b.getMeasuredWidth() > 0;
    }

    private void E(@NonNull Canvas canvas) {
        if (this.A) {
            this.J0.m(canvas);
        }
    }

    private boolean E0() {
        EditText editText = this.f4598e;
        return (editText == null || this.D == null || editText.getBackground() != null || this.I == 0) ? false : true;
    }

    private void F(boolean z) {
        ValueAnimator valueAnimator = this.M0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.M0.cancel();
        }
        if (z && this.L0) {
            i(0.0f);
        } else {
            this.J0.i0(0.0f);
        }
        if (A() && ((com.google.android.material.textfield.c) this.D).m0()) {
            y();
        }
        this.I0 = true;
        c0();
        Y0();
        b1();
    }

    private void F0() {
        TextView textView = this.r;
        if (textView == null || !this.q) {
            return;
        }
        textView.setText(this.p);
        TextView textView2 = this.r;
        textView2.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView2, 0);
        this.r.bringToFront();
    }

    private void G0(boolean z) {
        if (z && O() != null) {
            Drawable mutate = DrawableCompat.wrap(O()).mutate();
            DrawableCompat.setTint(mutate, this.f4602i.n());
            this.k0.setImageDrawable(mutate);
            return;
        }
        m();
    }

    private void H0() {
        if (this.I == 1) {
            if (com.google.android.material.f.c.h(getContext())) {
                this.J = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (com.google.android.material.f.c.g(getContext())) {
                this.J = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    private void I0(@NonNull Rect rect) {
        com.google.android.material.shape.h hVar = this.E;
        if (hVar != null) {
            int i2 = rect.bottom;
            hVar.setBounds(rect.left, i2 - this.M, rect.right, i2);
        }
    }

    private void J0() {
        if (this.m != null) {
            EditText editText = this.f4598e;
            K0(editText == null ? 0 : editText.getText().length());
        }
    }

    private static void L0(@NonNull Context context, @NonNull TextView textView, int i2, int i3, boolean z) {
        textView.setContentDescription(context.getString(z ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    private void M0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.m;
        if (textView != null) {
            B0(textView, this.f4605l ? this.n : this.o);
            if (!this.f4605l && (colorStateList2 = this.u) != null) {
                this.m.setTextColor(colorStateList2);
            }
            if (!this.f4605l || (colorStateList = this.v) == null) {
                return;
            }
            this.m.setTextColor(colorStateList);
        }
    }

    private com.google.android.material.textfield.e N() {
        com.google.android.material.textfield.e eVar = this.j0.get(this.i0);
        return eVar != null ? eVar : this.j0.get(0);
    }

    private void N0() {
        if (!A() || this.I0 || this.H == this.K) {
            return;
        }
        y();
        m0();
    }

    private boolean O0() {
        boolean z;
        if (this.f4598e == null) {
            return false;
        }
        boolean z2 = true;
        if (D0()) {
            int measuredWidth = this.b.getMeasuredWidth() - this.f4598e.getPaddingLeft();
            if (this.e0 == null || this.f0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.e0 = colorDrawable;
                this.f0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.f4598e);
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.e0;
            if (drawable != drawable2) {
                TextViewCompat.setCompoundDrawablesRelative(this.f4598e, drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                z = true;
            }
            z = false;
        } else {
            if (this.e0 != null) {
                Drawable[] compoundDrawablesRelative2 = TextViewCompat.getCompoundDrawablesRelative(this.f4598e);
                TextViewCompat.setCompoundDrawablesRelative(this.f4598e, null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.e0 = null;
                z = true;
            }
            z = false;
        }
        if (C0()) {
            int measuredWidth2 = this.z.getMeasuredWidth() - this.f4598e.getPaddingRight();
            CheckableImageButton P = P();
            if (P != null) {
                measuredWidth2 = measuredWidth2 + P.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) P.getLayoutParams());
            }
            Drawable[] compoundDrawablesRelative3 = TextViewCompat.getCompoundDrawablesRelative(this.f4598e);
            Drawable drawable3 = this.q0;
            if (drawable3 != null && this.r0 != measuredWidth2) {
                this.r0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                TextViewCompat.setCompoundDrawablesRelative(this.f4598e, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.q0, compoundDrawablesRelative3[3]);
            } else {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.q0 = colorDrawable2;
                    this.r0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = compoundDrawablesRelative3[2];
                Drawable drawable5 = this.q0;
                if (drawable4 != drawable5) {
                    this.s0 = compoundDrawablesRelative3[2];
                    TextViewCompat.setCompoundDrawablesRelative(this.f4598e, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], drawable5, compoundDrawablesRelative3[3]);
                } else {
                    z2 = z;
                }
            }
        } else if (this.q0 == null) {
            return z;
        } else {
            Drawable[] compoundDrawablesRelative4 = TextViewCompat.getCompoundDrawablesRelative(this.f4598e);
            if (compoundDrawablesRelative4[2] == this.q0) {
                TextViewCompat.setCompoundDrawablesRelative(this.f4598e, compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.s0, compoundDrawablesRelative4[3]);
            } else {
                z2 = z;
            }
            this.q0 = null;
        }
        return z2;
    }

    @Nullable
    private CheckableImageButton P() {
        if (this.v0.getVisibility() == 0) {
            return this.v0;
        }
        if (b0() && d0()) {
            return this.k0;
        }
        return null;
    }

    private boolean Q0() {
        int max;
        if (this.f4598e != null && this.f4598e.getMeasuredHeight() < (max = Math.max(this.c.getMeasuredHeight(), this.b.getMeasuredHeight()))) {
            this.f4598e.setMinimumHeight(max);
            return true;
        }
        return false;
    }

    private void R0() {
        if (this.I != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
            int v = v();
            if (v != layoutParams.topMargin) {
                layoutParams.topMargin = v;
                this.a.requestLayout();
            }
        }
    }

    private void T0(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f4598e;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f4598e;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean k2 = this.f4602i.k();
        ColorStateList colorStateList2 = this.x0;
        if (colorStateList2 != null) {
            this.J0.U(colorStateList2);
            this.J0.d0(this.x0);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.x0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.H0) : this.H0;
            this.J0.U(ColorStateList.valueOf(colorForState));
            this.J0.d0(ColorStateList.valueOf(colorForState));
        } else if (k2) {
            this.J0.U(this.f4602i.o());
        } else if (this.f4605l && (textView = this.m) != null) {
            this.J0.U(textView.getTextColors());
        } else if (z4 && (colorStateList = this.y0) != null) {
            this.J0.U(colorStateList);
        }
        if (!z3 && this.K0 && (!isEnabled() || !z4)) {
            if (z2 || !this.I0) {
                F(z);
            }
        } else if (z2 || this.I0) {
            z(z);
        }
    }

    private void U0() {
        EditText editText;
        if (this.r == null || (editText = this.f4598e) == null) {
            return;
        }
        this.r.setGravity(editText.getGravity());
        this.r.setPadding(this.f4598e.getCompoundPaddingLeft(), this.f4598e.getCompoundPaddingTop(), this.f4598e.getCompoundPaddingRight(), this.f4598e.getCompoundPaddingBottom());
    }

    private int V(int i2, boolean z) {
        int compoundPaddingLeft = i2 + this.f4598e.getCompoundPaddingLeft();
        return (this.w == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - this.x.getMeasuredWidth()) + this.x.getPaddingLeft();
    }

    private void V0() {
        EditText editText = this.f4598e;
        W0(editText == null ? 0 : editText.getText().length());
    }

    private int W(int i2, boolean z) {
        int compoundPaddingRight = i2 - this.f4598e.getCompoundPaddingRight();
        return (this.w == null || !z) ? compoundPaddingRight : compoundPaddingRight + (this.x.getMeasuredWidth() - this.x.getPaddingRight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(int i2) {
        if (i2 == 0 && !this.I0) {
            F0();
        } else {
            c0();
        }
    }

    private void X0() {
        if (this.f4598e == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.x, j0() ? 0 : ViewCompat.getPaddingStart(this.f4598e), this.f4598e.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.f4598e.getCompoundPaddingBottom());
    }

    private void Y0() {
        TextView textView = this.x;
        int i2 = (this.w == null || g0()) ? 8 : 0;
        textView.setVisibility(i2);
        VdsAgent.onSetViewVisibility(textView, i2);
        O0();
    }

    private void Z0(boolean z, boolean z2) {
        int defaultColor = this.C0.getDefaultColor();
        int colorForState = this.C0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.C0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z) {
            this.N = colorForState2;
        } else if (z2) {
            this.N = colorForState;
        } else {
            this.N = defaultColor;
        }
    }

    private void a1() {
        if (this.f4598e == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.z, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.f4598e.getPaddingTop(), (d0() || e0()) ? 0 : ViewCompat.getPaddingEnd(this.f4598e), this.f4598e.getPaddingBottom());
    }

    private boolean b0() {
        return this.i0 != 0;
    }

    private void b1() {
        int visibility = this.z.getVisibility();
        boolean z = (this.y == null || g0()) ? false : true;
        TextView textView = this.z;
        int i2 = z ? 0 : 8;
        textView.setVisibility(i2);
        VdsAgent.onSetViewVisibility(textView, i2);
        if (visibility != this.z.getVisibility()) {
            N().c(z);
        }
        O0();
    }

    private void c0() {
        TextView textView = this.r;
        if (textView == null || !this.q) {
            return;
        }
        textView.setText((CharSequence) null);
        TextView textView2 = this.r;
        textView2.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView2, 4);
    }

    private boolean e0() {
        return this.v0.getVisibility() == 0;
    }

    private void g() {
        TextView textView = this.r;
        if (textView != null) {
            this.a.addView(textView);
            TextView textView2 = this.r;
            textView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView2, 0);
        }
    }

    private void h() {
        if (this.f4598e == null || this.I != 1) {
            return;
        }
        if (com.google.android.material.f.c.h(getContext())) {
            EditText editText = this.f4598e;
            ViewCompat.setPaddingRelative(editText, ViewCompat.getPaddingStart(editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.getPaddingEnd(this.f4598e), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (com.google.android.material.f.c.g(getContext())) {
            EditText editText2 = this.f4598e;
            ViewCompat.setPaddingRelative(editText2, ViewCompat.getPaddingStart(editText2), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.getPaddingEnd(this.f4598e), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    private boolean i0() {
        return this.I == 1 && (Build.VERSION.SDK_INT < 16 || this.f4598e.getMinLines() <= 1);
    }

    private void j() {
        com.google.android.material.shape.h hVar = this.D;
        if (hVar == null) {
            return;
        }
        hVar.setShapeAppearanceModel(this.F);
        if (w()) {
            this.D.f0(this.K, this.N);
        }
        int q = q();
        this.O = q;
        this.D.W(ColorStateList.valueOf(q));
        if (this.i0 == 3) {
            this.f4598e.getBackground().invalidateSelf();
        }
        k();
        invalidate();
    }

    private void k() {
        if (this.E == null) {
            return;
        }
        if (x()) {
            this.E.W(ColorStateList.valueOf(this.N));
        }
        invalidate();
    }

    private int[] k0(CheckableImageButton checkableImageButton) {
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        return copyOf;
    }

    private void l(@NonNull RectF rectF) {
        float f2 = rectF.left;
        int i2 = this.G;
        rectF.left = f2 - i2;
        rectF.right += i2;
    }

    private void l0() {
        p();
        u0();
        c1();
        H0();
        h();
        if (this.I != 0) {
            R0();
        }
    }

    private void m() {
        n(this.k0, this.n0, this.m0, this.p0, this.o0);
    }

    private void m0() {
        if (A()) {
            RectF rectF = this.R;
            this.J0.p(rectF, this.f4598e.getWidth(), this.f4598e.getGravity());
            l(rectF);
            int i2 = this.K;
            this.H = i2;
            rectF.top = 0.0f;
            rectF.bottom = i2;
            rectF.offset(-getPaddingLeft(), 0.0f);
            ((com.google.android.material.textfield.c) this.D).s0(rectF);
        }
    }

    private void n(@NonNull CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (z) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
            if (z2) {
                DrawableCompat.setTintMode(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private static void n0(@NonNull ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                n0((ViewGroup) childAt, z);
            }
        }
    }

    private void o() {
        n(this.T, this.V, this.U, this.d0, this.W);
    }

    private void p() {
        int i2 = this.I;
        if (i2 == 0) {
            this.D = null;
            this.E = null;
        } else if (i2 == 1) {
            this.D = new com.google.android.material.shape.h(this.F);
            this.E = new com.google.android.material.shape.h();
        } else if (i2 == 2) {
            if (this.A && !(this.D instanceof com.google.android.material.textfield.c)) {
                this.D = new com.google.android.material.textfield.c(this.F);
            } else {
                this.D = new com.google.android.material.shape.h(this.F);
            }
            this.E = null;
        } else {
            throw new IllegalArgumentException(this.I + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
    }

    private int q() {
        return this.I == 1 ? com.google.android.material.b.a.g(com.google.android.material.b.a.e(this, R.attr.colorSurface, 0), this.O) : this.O;
    }

    private void q0(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(k0(checkableImageButton), colorStateList.getDefaultColor());
        Drawable mutate = DrawableCompat.wrap(drawable).mutate();
        DrawableCompat.setTintList(mutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(mutate);
    }

    @NonNull
    private Rect r(@NonNull Rect rect) {
        if (this.f4598e != null) {
            Rect rect2 = this.Q;
            boolean z = ViewCompat.getLayoutDirection(this) == 1;
            rect2.bottom = rect.bottom;
            int i2 = this.I;
            if (i2 == 1) {
                rect2.left = V(rect.left, z);
                rect2.top = rect.top + this.J;
                rect2.right = W(rect.right, z);
                return rect2;
            } else if (i2 != 2) {
                rect2.left = V(rect.left, z);
                rect2.top = getPaddingTop();
                rect2.right = W(rect.right, z);
                return rect2;
            } else {
                rect2.left = rect.left + this.f4598e.getPaddingLeft();
                rect2.top = rect.top - v();
                rect2.right = rect.right - this.f4598e.getPaddingRight();
                return rect2;
            }
        }
        throw new IllegalStateException();
    }

    private int s(@NonNull Rect rect, @NonNull Rect rect2, float f2) {
        if (i0()) {
            return (int) (rect2.top + f2);
        }
        return rect.bottom - this.f4598e.getCompoundPaddingBottom();
    }

    private void s0() {
        TextView textView = this.r;
        if (textView != null) {
            textView.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView, 8);
        }
    }

    private int t(@NonNull Rect rect, float f2) {
        if (i0()) {
            return (int) (rect.centerY() - (f2 / 2.0f));
        }
        return rect.top + this.f4598e.getCompoundPaddingTop();
    }

    private void t0(EditText editText) {
        if (this.f4598e == null) {
            if (this.i0 != 3 && !(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f4598e = editText;
            setMinWidth(this.f4600g);
            setMaxWidth(this.f4601h);
            l0();
            setTextInputAccessibilityDelegate(new e(this));
            this.J0.v0(this.f4598e.getTypeface());
            this.J0.f0(this.f4598e.getTextSize());
            int gravity = this.f4598e.getGravity();
            this.J0.V((gravity & (-113)) | 48);
            this.J0.e0(gravity);
            this.f4598e.addTextChangedListener(new a());
            if (this.x0 == null) {
                this.x0 = this.f4598e.getHintTextColors();
            }
            if (this.A) {
                if (TextUtils.isEmpty(this.B)) {
                    CharSequence hint = this.f4598e.getHint();
                    this.f4599f = hint;
                    setHint(hint);
                    this.f4598e.setHint((CharSequence) null);
                }
                this.C = true;
            }
            if (this.m != null) {
                K0(this.f4598e.getText().length());
            }
            P0();
            this.f4602i.e();
            this.b.bringToFront();
            this.c.bringToFront();
            this.f4597d.bringToFront();
            this.v0.bringToFront();
            B();
            X0();
            a1();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            T0(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    @NonNull
    private Rect u(@NonNull Rect rect) {
        if (this.f4598e != null) {
            Rect rect2 = this.Q;
            float y = this.J0.y();
            rect2.left = rect.left + this.f4598e.getCompoundPaddingLeft();
            rect2.top = t(rect, y);
            rect2.right = rect.right - this.f4598e.getCompoundPaddingRight();
            rect2.bottom = s(rect, rect2, y);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private void u0() {
        if (E0()) {
            ViewCompat.setBackground(this.f4598e, this.D);
        }
    }

    private int v() {
        float r;
        if (this.A) {
            int i2 = this.I;
            if (i2 == 0 || i2 == 1) {
                r = this.J0.r();
            } else if (i2 != 2) {
                return 0;
            } else {
                r = this.J0.r() / 2.0f;
            }
            return (int) r;
        }
        return 0;
    }

    private void v0(boolean z) {
        this.v0.setVisibility(z ? 0 : 8);
        FrameLayout frameLayout = this.f4597d;
        int i2 = z ? 8 : 0;
        frameLayout.setVisibility(i2);
        VdsAgent.onSetViewVisibility(frameLayout, i2);
        a1();
        if (b0()) {
            return;
        }
        O0();
    }

    private boolean w() {
        return this.I == 2 && x();
    }

    private void w0(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.B)) {
            return;
        }
        this.B = charSequence;
        this.J0.t0(charSequence);
        if (this.I0) {
            return;
        }
        m0();
    }

    private boolean x() {
        return this.K > -1 && this.N != 0;
    }

    private static void x0(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        boolean hasOnClickListeners = ViewCompat.hasOnClickListeners(checkableImageButton);
        boolean z = false;
        boolean z2 = onLongClickListener != null;
        z = (hasOnClickListeners || z2) ? true : true;
        checkableImageButton.setFocusable(z);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z2);
        ViewCompat.setImportantForAccessibility(checkableImageButton, z ? 1 : 2);
    }

    private void y() {
        if (A()) {
            ((com.google.android.material.textfield.c) this.D).p0();
        }
    }

    private static void y0(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnClickListener onClickListener, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        x0(checkableImageButton, onLongClickListener);
    }

    private void z(boolean z) {
        ValueAnimator valueAnimator = this.M0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.M0.cancel();
        }
        if (z && this.L0) {
            i(1.0f);
        } else {
            this.J0.i0(1.0f);
        }
        this.I0 = false;
        if (A()) {
            m0();
        }
        V0();
        Y0();
        b1();
    }

    private static void z0(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        x0(checkableImageButton, onLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void B0(@androidx.annotation.NonNull android.widget.TextView r3, @androidx.annotation.StyleRes int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.TextViewCompat.setTextAppearance(r3, r4)     // Catch: java.lang.Exception -> L1b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1b
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1b
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1c
        L18:
            r4 = 0
            r0 = 0
            goto L1c
        L1b:
        L1c:
            if (r0 == 0) goto L30
            int r4 = com.google.android.material.R.style.TextAppearance_AppCompat_Caption
            androidx.core.widget.TextViewCompat.setTextAppearance(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = com.google.android.material.R.color.design_error
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r0)
            r3.setTextColor(r4)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.B0(android.widget.TextView, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public com.google.android.material.shape.h G() {
        int i2 = this.I;
        if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException();
        }
        return this.D;
    }

    public int H() {
        return this.O;
    }

    public int I() {
        return this.I;
    }

    public int J() {
        return this.f4604k;
    }

    @Nullable
    CharSequence K() {
        TextView textView;
        if (this.f4603j && this.f4605l && (textView = this.m) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    void K0(int i2) {
        boolean z = this.f4605l;
        int i3 = this.f4604k;
        if (i3 == -1) {
            this.m.setText(String.valueOf(i2));
            this.m.setContentDescription(null);
            this.f4605l = false;
        } else {
            this.f4605l = i2 > i3;
            L0(getContext(), this.m, i2, this.f4604k, this.f4605l);
            if (z != this.f4605l) {
                M0();
            }
            this.m.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i2), Integer.valueOf(this.f4604k))));
        }
        if (this.f4598e == null || z == this.f4605l) {
            return;
        }
        S0(false);
        c1();
        P0();
    }

    @Nullable
    public EditText L() {
        return this.f4598e;
    }

    @Nullable
    public CharSequence M() {
        return this.k0.getContentDescription();
    }

    @Nullable
    public Drawable O() {
        return this.k0.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f4598e;
        if (editText == null || this.I != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (this.f4602i.k()) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.f4602i.n(), PorterDuff.Mode.SRC_IN));
        } else if (this.f4605l && (textView = this.m) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.clearColorFilter(background);
            this.f4598e.refreshDrawableState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public CheckableImageButton Q() {
        return this.k0;
    }

    @Nullable
    public CharSequence R() {
        if (this.f4602i.v()) {
            return this.f4602i.m();
        }
        return null;
    }

    @Nullable
    public Drawable S() {
        return this.v0.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S0(boolean z) {
        T0(z, false);
    }

    @Nullable
    public CharSequence T() {
        if (this.f4602i.w()) {
            return this.f4602i.p();
        }
        return null;
    }

    @Nullable
    public CharSequence U() {
        if (this.A) {
            return this.B;
        }
        return null;
    }

    @Nullable
    public CharSequence X() {
        if (this.q) {
            return this.p;
        }
        return null;
    }

    @Nullable
    public CharSequence Y() {
        return this.T.getContentDescription();
    }

    @Nullable
    public Drawable Z() {
        return this.T.getDrawable();
    }

    @Nullable
    public CharSequence a0() {
        return this.y;
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i2, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.a.addView(view, layoutParams2);
            this.a.setLayoutParams(layoutParams);
            R0();
            t0((EditText) view);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c1() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.D == null || this.I == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.f4598e) != null && editText2.hasFocus());
        boolean z3 = isHovered() || ((editText = this.f4598e) != null && editText.isHovered());
        if (!isEnabled()) {
            this.N = this.H0;
        } else if (this.f4602i.k()) {
            if (this.C0 != null) {
                Z0(z2, z3);
            } else {
                this.N = this.f4602i.n();
            }
        } else if (!this.f4605l || (textView = this.m) == null) {
            if (z2) {
                this.N = this.B0;
            } else if (z3) {
                this.N = this.A0;
            } else {
                this.N = this.z0;
            }
        } else if (this.C0 != null) {
            Z0(z2, z3);
        } else {
            this.N = textView.getCurrentTextColor();
        }
        if (S() != null && this.f4602i.v() && this.f4602i.k()) {
            z = true;
        }
        v0(z);
        p0();
        r0();
        o0();
        if (N().d()) {
            G0(this.f4602i.k());
        }
        if (z2 && isEnabled()) {
            this.K = this.M;
        } else {
            this.K = this.L;
        }
        if (this.I == 2) {
            N0();
        }
        if (this.I == 1) {
            if (!isEnabled()) {
                this.O = this.E0;
            } else if (z3 && !z2) {
                this.O = this.G0;
            } else if (z2) {
                this.O = this.F0;
            } else {
                this.O = this.D0;
            }
        }
        j();
    }

    public boolean d0() {
        return this.f4597d.getVisibility() == 0 && this.k0.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i2) {
        EditText editText = this.f4598e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        if (this.f4599f != null) {
            boolean z = this.C;
            this.C = false;
            CharSequence hint = editText.getHint();
            this.f4598e.setHint(this.f4599f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i2);
                return;
            } finally {
                this.f4598e.setHint(hint);
                this.C = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i2);
        onProvideAutofillVirtualStructure(viewStructure, i2);
        viewStructure.setChildCount(this.a.getChildCount());
        for (int i3 = 0; i3 < this.a.getChildCount(); i3++) {
            View childAt = this.a.getChildAt(i3);
            ViewStructure newChild = viewStructure.newChild(i3);
            childAt.dispatchProvideAutofillStructure(newChild, i2);
            if (childAt == this.f4598e) {
                newChild.setHint(U());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.O0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.O0 = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        E(canvas);
        D(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.N0) {
            return;
        }
        boolean z = true;
        this.N0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.a aVar = this.J0;
        boolean s0 = aVar != null ? aVar.s0(drawableState) | false : false;
        if (this.f4598e != null) {
            S0((ViewCompat.isLaidOut(this) && isEnabled()) ? false : false);
        }
        P0();
        c1();
        if (s0) {
            invalidate();
        }
        this.N0 = false;
    }

    public void e(@NonNull f fVar) {
        this.h0.add(fVar);
        if (this.f4598e != null) {
            fVar.a(this);
        }
    }

    public void f(@NonNull g gVar) {
        this.l0.add(gVar);
    }

    public boolean f0() {
        return this.f4602i.w();
    }

    @VisibleForTesting
    final boolean g0() {
        return this.I0;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f4598e;
        if (editText != null) {
            return editText.getBaseline() + getPaddingTop() + v();
        }
        return super.getBaseline();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean h0() {
        return this.C;
    }

    @VisibleForTesting
    void i(float f2) {
        if (this.J0.z() == f2) {
            return;
        }
        if (this.M0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.M0 = valueAnimator;
            valueAnimator.setInterpolator(com.google.android.material.animation.a.b);
            this.M0.setDuration(167L);
            this.M0.addUpdateListener(new d());
        }
        this.M0.setFloatValues(this.J0.z(), f2);
        this.M0.start();
    }

    public boolean j0() {
        return this.T.getVisibility() == 0;
    }

    public void o0() {
        q0(this.k0, this.m0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        EditText editText = this.f4598e;
        if (editText != null) {
            Rect rect = this.P;
            com.google.android.material.internal.c.a(this, editText, rect);
            I0(rect);
            if (this.A) {
                this.J0.f0(this.f4598e.getTextSize());
                int gravity = this.f4598e.getGravity();
                this.J0.V((gravity & (-113)) | 48);
                this.J0.e0(gravity);
                this.J0.R(r(rect));
                this.J0.a0(u(rect));
                this.J0.N();
                if (!A() || this.I0) {
                    return;
                }
                m0();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        boolean Q0 = Q0();
        boolean O0 = O0();
        if (Q0 || O0) {
            this.f4598e.post(new c());
        }
        U0();
        X0();
        a1();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.a);
        if (savedState.b) {
            this.k0.post(new b());
        }
        setHint(savedState.c);
        setHelperText(savedState.f4606d);
        setPlaceholderText(savedState.f4607e);
        requestLayout();
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f4602i.k()) {
            savedState.a = R();
        }
        savedState.b = b0() && this.k0.isChecked();
        savedState.c = U();
        savedState.f4606d = T();
        savedState.f4607e = X();
        return savedState;
    }

    public void p0() {
        q0(this.v0, this.w0);
    }

    public void r0() {
        q0(this.T, this.U);
    }

    public void setBoxBackgroundColor(@ColorInt int i2) {
        if (this.O != i2) {
            this.O = i2;
            this.D0 = i2;
            this.F0 = i2;
            this.G0 = i2;
            j();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i2) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i2));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.D0 = defaultColor;
        this.O = defaultColor;
        this.E0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.F0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.G0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        j();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 == this.I) {
            return;
        }
        this.I = i2;
        if (this.f4598e != null) {
            l0();
        }
    }

    public void setBoxCornerRadii(float f2, float f3, float f4, float f5) {
        com.google.android.material.shape.h hVar = this.D;
        if (hVar != null && hVar.E() == f2 && this.D.F() == f3 && this.D.t() == f5 && this.D.s() == f4) {
            return;
        }
        m.b v = this.F.v();
        v.E(f2);
        v.I(f3);
        v.z(f5);
        v.v(f4);
        this.F = v.m();
        j();
    }

    public void setBoxCornerRadiiResources(@DimenRes int i2, @DimenRes int i3, @DimenRes int i4, @DimenRes int i5) {
        setBoxCornerRadii(getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i3), getContext().getResources().getDimension(i5), getContext().getResources().getDimension(i4));
    }

    public void setBoxStrokeColor(@ColorInt int i2) {
        if (this.B0 != i2) {
            this.B0 = i2;
            c1();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.z0 = colorStateList.getDefaultColor();
            this.H0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.A0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.B0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.B0 != colorStateList.getDefaultColor()) {
            this.B0 = colorStateList.getDefaultColor();
        }
        c1();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.C0 != colorStateList) {
            this.C0 = colorStateList;
            c1();
        }
    }

    public void setBoxStrokeWidth(int i2) {
        this.L = i2;
        c1();
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.M = i2;
        c1();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setCounterEnabled(boolean z) {
        if (this.f4603j != z) {
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.m = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface = this.S;
                if (typeface != null) {
                    this.m.setTypeface(typeface);
                }
                this.m.setMaxLines(1);
                this.f4602i.d(this.m, 2);
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.m.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                M0();
                J0();
            } else {
                this.f4602i.x(this.m, 2);
                this.m = null;
            }
            this.f4603j = z;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.f4604k != i2) {
            if (i2 > 0) {
                this.f4604k = i2;
            } else {
                this.f4604k = -1;
            }
            if (this.f4603j) {
                J0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i2) {
        if (this.n != i2) {
            this.n = i2;
            M0();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.v != colorStateList) {
            this.v = colorStateList;
            M0();
        }
    }

    public void setCounterTextAppearance(int i2) {
        if (this.o != i2) {
            this.o = i2;
            M0();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.u != colorStateList) {
            this.u = colorStateList;
            M0();
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.x0 = colorStateList;
        this.y0 = colorStateList;
        if (this.f4598e != null) {
            S0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        n0(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.k0.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.k0.setCheckable(z);
    }

    public void setEndIconContentDescription(@StringRes int i2) {
        setEndIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setEndIconDrawable(@DrawableRes int i2) {
        setEndIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setEndIconMode(int i2) {
        int i3 = this.i0;
        this.i0 = i2;
        C(i3);
        setEndIconVisible(i2 != 0);
        if (N().b(this.I)) {
            N().a();
            m();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.I + " is not supported by the end icon mode " + i2);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        y0(this.k0, onClickListener, this.t0);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.t0 = onLongClickListener;
        z0(this.k0, onLongClickListener);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.m0 != colorStateList) {
            this.m0 = colorStateList;
            this.n0 = true;
            m();
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.o0 != mode) {
            this.o0 = mode;
            this.p0 = true;
            m();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (d0() != z) {
            this.k0.setVisibility(z ? 0 : 8);
            a1();
            O0();
        }
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.f4602i.v()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f4602i.K(charSequence);
        } else {
            this.f4602i.r();
        }
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        this.f4602i.z(charSequence);
    }

    public void setErrorEnabled(boolean z) {
        this.f4602i.A(z);
    }

    public void setErrorIconDrawable(@DrawableRes int i2) {
        setErrorIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
        p0();
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        y0(this.v0, onClickListener, this.u0);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.u0 = onLongClickListener;
        z0(this.v0, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        this.w0 = colorStateList;
        Drawable drawable = this.v0.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(drawable, colorStateList);
        }
        if (this.v0.getDrawable() != drawable) {
            this.v0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        Drawable drawable = this.v0.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintMode(drawable, mode);
        }
        if (this.v0.getDrawable() != drawable) {
            this.v0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(@StyleRes int i2) {
        this.f4602i.B(i2);
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        this.f4602i.C(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.K0 != z) {
            this.K0 = z;
            S0(false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (f0()) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!f0()) {
            setHelperTextEnabled(true);
        }
        this.f4602i.L(charSequence);
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        this.f4602i.F(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.f4602i.E(z);
    }

    public void setHelperTextTextAppearance(@StyleRes int i2) {
        this.f4602i.D(i2);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.A) {
            w0(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.L0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.A) {
            this.A = z;
            if (!z) {
                this.C = false;
                if (!TextUtils.isEmpty(this.B) && TextUtils.isEmpty(this.f4598e.getHint())) {
                    this.f4598e.setHint(this.B);
                }
                w0(null);
            } else {
                CharSequence hint = this.f4598e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.B)) {
                        setHint(hint);
                    }
                    this.f4598e.setHint((CharSequence) null);
                }
                this.C = true;
            }
            if (this.f4598e != null) {
                R0();
            }
        }
    }

    public void setHintTextAppearance(@StyleRes int i2) {
        this.J0.S(i2);
        this.y0 = this.J0.q();
        if (this.f4598e != null) {
            S0(false);
            R0();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.y0 != colorStateList) {
            if (this.x0 == null) {
                this.J0.U(colorStateList);
            }
            this.y0 = colorStateList;
            if (this.f4598e != null) {
                S0(false);
            }
        }
    }

    public void setMaxWidth(@Px int i2) {
        this.f4601h = i2;
        EditText editText = this.f4598e;
        if (editText == null || i2 == -1) {
            return;
        }
        editText.setMaxWidth(i2);
    }

    public void setMaxWidthResource(@DimenRes int i2) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i2));
    }

    public void setMinWidth(@Px int i2) {
        this.f4600g = i2;
        EditText editText = this.f4598e;
        if (editText == null || i2 == -1) {
            return;
        }
        editText.setMinWidth(i2);
    }

    public void setMinWidthResource(@DimenRes int i2) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i2));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.i0 != 1) {
            setEndIconMode(1);
        } else if (z) {
        } else {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.m0 = colorStateList;
        this.n0 = true;
        m();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.o0 = mode;
        this.p0 = true;
        m();
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.q && TextUtils.isEmpty(charSequence)) {
            A0(false);
        } else {
            if (!this.q) {
                A0(true);
            }
            this.p = charSequence;
        }
        V0();
    }

    public void setPlaceholderTextAppearance(@StyleRes int i2) {
        this.t = i2;
        TextView textView = this.r;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i2);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.s != colorStateList) {
            this.s = colorStateList;
            TextView textView = this.r;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        this.w = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.x.setText(charSequence);
        Y0();
    }

    public void setPrefixTextAppearance(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.x, i2);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.x.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.T.setCheckable(z);
    }

    public void setStartIconContentDescription(@StringRes int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconDrawable(@DrawableRes int i2) {
        setStartIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        y0(this.T, onClickListener, this.g0);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.g0 = onLongClickListener;
        z0(this.T, onLongClickListener);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.U != colorStateList) {
            this.U = colorStateList;
            this.V = true;
            o();
        }
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.W != mode) {
            this.W = mode;
            this.d0 = true;
            o();
        }
    }

    public void setStartIconVisible(boolean z) {
        if (j0() != z) {
            this.T.setVisibility(z ? 0 : 8);
            X0();
            O0();
        }
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        this.y = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.z.setText(charSequence);
        b1();
    }

    public void setSuffixTextAppearance(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.z, i2);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.z.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable e eVar) {
        EditText editText = this.f4598e;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, eVar);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.S) {
            this.S = typeface;
            this.J0.v0(typeface);
            this.f4602i.H(typeface);
            TextView textView = this.m;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        if (M() != charSequence) {
            this.k0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.k0.setImageDrawable(drawable);
        o0();
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        if (Y() != charSequence) {
            this.T.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.T.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            r0();
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v158 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TextInputLayout(@androidx.annotation.NonNull android.content.Context r24, @androidx.annotation.Nullable android.util.AttributeSet r25, int r26) {
        /*
            Method dump skipped, instructions count: 1578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.v0.setImageDrawable(drawable);
        v0(drawable != null && this.f4602i.v());
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.k0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.k0.setImageDrawable(drawable);
    }

    public void setHint(@StringRes int i2) {
        setHint(i2 != 0 ? getResources().getText(i2) : null);
    }
}
