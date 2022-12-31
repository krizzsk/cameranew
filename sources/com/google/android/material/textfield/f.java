package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IndicatorViewController.java */
/* loaded from: classes2.dex */
public final class f {
    private final Context a;
    @NonNull
    private final TextInputLayout b;
    private LinearLayout c;

    /* renamed from: d  reason: collision with root package name */
    private int f4623d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f4624e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Animator f4625f;

    /* renamed from: g  reason: collision with root package name */
    private final float f4626g;

    /* renamed from: h  reason: collision with root package name */
    private int f4627h;

    /* renamed from: i  reason: collision with root package name */
    private int f4628i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f4629j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4630k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private TextView f4631l;
    @Nullable
    private CharSequence m;
    private int n;
    @Nullable
    private ColorStateList o;
    private CharSequence p;
    private boolean q;
    @Nullable
    private TextView r;
    private int s;
    @Nullable
    private ColorStateList t;
    private Typeface u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IndicatorViewController.java */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        final /* synthetic */ int a;
        final /* synthetic */ TextView b;
        final /* synthetic */ int c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TextView f4632d;

        a(int i2, TextView textView, int i3, TextView textView2) {
            this.a = i2;
            this.b = textView;
            this.c = i3;
            this.f4632d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f4627h = this.a;
            f.this.f4625f = null;
            TextView textView = this.b;
            if (textView != null) {
                textView.setVisibility(4);
                VdsAgent.onSetViewVisibility(textView, 4);
                if (this.c == 1 && f.this.f4631l != null) {
                    f.this.f4631l.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f4632d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f4632d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f4632d;
            if (textView != null) {
                textView.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView, 0);
            }
        }
    }

    public f(@NonNull TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.a = context;
        this.b = textInputLayout;
        this.f4626g = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    private void G(@Nullable TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void I(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            viewGroup.setVisibility(8);
            VdsAgent.onSetViewVisibility(viewGroup, 8);
        }
    }

    private boolean J(@Nullable TextView textView, @Nullable CharSequence charSequence) {
        return ViewCompat.isLaidOut(this.b) && this.b.isEnabled() && !(this.f4628i == this.f4627h && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void M(int i2, int i3, boolean z) {
        if (i2 == i3) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f4625f = animatorSet;
            ArrayList arrayList = new ArrayList();
            h(arrayList, this.q, this.r, 2, i2, i3);
            h(arrayList, this.f4630k, this.f4631l, 1, i2, i3);
            com.google.android.material.animation.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i3, l(i2), i2, l(i3)));
            animatorSet.start();
        } else {
            y(i2, i3);
        }
        this.b.P0();
        this.b.S0(z);
        this.b.c1();
    }

    private boolean f() {
        return (this.c == null || this.b.L() == null) ? false : true;
    }

    private void h(@NonNull List<Animator> list, boolean z, @Nullable TextView textView, int i2, int i3, int i4) {
        if (textView == null || !z) {
            return;
        }
        if (i2 == i4 || i2 == i3) {
            list.add(i(textView, i4 == i2));
            if (i4 == i2) {
                list.add(j(textView));
            }
        }
    }

    private ObjectAnimator i(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, z ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(com.google.android.material.animation.a.a);
        return ofFloat;
    }

    private ObjectAnimator j(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.f4626g, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(com.google.android.material.animation.a.f4032d);
        return ofFloat;
    }

    @Nullable
    private TextView l(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return null;
            }
            return this.r;
        }
        return this.f4631l;
    }

    private int q(boolean z, @DimenRes int i2, int i3) {
        return z ? this.a.getResources().getDimensionPixelSize(i2) : i3;
    }

    private boolean t(int i2) {
        return (i2 != 1 || this.f4631l == null || TextUtils.isEmpty(this.f4629j)) ? false : true;
    }

    private void y(int i2, int i3) {
        TextView l2;
        TextView l3;
        if (i2 == i3) {
            return;
        }
        if (i3 != 0 && (l3 = l(i3)) != null) {
            l3.setVisibility(0);
            VdsAgent.onSetViewVisibility(l3, 0);
            l3.setAlpha(1.0f);
        }
        if (i2 != 0 && (l2 = l(i2)) != null) {
            l2.setVisibility(4);
            VdsAgent.onSetViewVisibility(l2, 4);
            if (i2 == 1) {
                l2.setText((CharSequence) null);
            }
        }
        this.f4627h = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(boolean z) {
        if (this.f4630k == z) {
            return;
        }
        g();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.a);
            this.f4631l = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_error);
            if (Build.VERSION.SDK_INT >= 17) {
                this.f4631l.setTextAlignment(5);
            }
            Typeface typeface = this.u;
            if (typeface != null) {
                this.f4631l.setTypeface(typeface);
            }
            B(this.n);
            C(this.o);
            z(this.m);
            TextView textView = this.f4631l;
            textView.setVisibility(4);
            VdsAgent.onSetViewVisibility(textView, 4);
            ViewCompat.setAccessibilityLiveRegion(this.f4631l, 1);
            d(this.f4631l, 0);
        } else {
            r();
            x(this.f4631l, 0);
            this.f4631l = null;
            this.b.P0();
            this.b.c1();
        }
        this.f4630k = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(@StyleRes int i2) {
        this.n = i2;
        TextView textView = this.f4631l;
        if (textView != null) {
            this.b.B0(textView, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(@Nullable ColorStateList colorStateList) {
        this.o = colorStateList;
        TextView textView = this.f4631l;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(@StyleRes int i2) {
        this.s = i2;
        TextView textView = this.r;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(boolean z) {
        if (this.q == z) {
            return;
        }
        g();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.a);
            this.r = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_helper_text);
            if (Build.VERSION.SDK_INT >= 17) {
                this.r.setTextAlignment(5);
            }
            Typeface typeface = this.u;
            if (typeface != null) {
                this.r.setTypeface(typeface);
            }
            TextView textView = this.r;
            textView.setVisibility(4);
            VdsAgent.onSetViewVisibility(textView, 4);
            ViewCompat.setAccessibilityLiveRegion(this.r, 1);
            D(this.s);
            F(this.t);
            d(this.r, 1);
        } else {
            s();
            x(this.r, 1);
            this.r = null;
            this.b.P0();
            this.b.c1();
        }
        this.q = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(@Nullable ColorStateList colorStateList) {
        this.t = colorStateList;
        TextView textView = this.r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(Typeface typeface) {
        if (typeface != this.u) {
            this.u = typeface;
            G(this.f4631l, typeface);
            G(this.r, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(CharSequence charSequence) {
        g();
        this.f4629j = charSequence;
        this.f4631l.setText(charSequence);
        int i2 = this.f4627h;
        if (i2 != 1) {
            this.f4628i = 1;
        }
        M(i2, this.f4628i, J(this.f4631l, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(CharSequence charSequence) {
        g();
        this.p = charSequence;
        this.r.setText(charSequence);
        int i2 = this.f4627h;
        if (i2 != 2) {
            this.f4628i = 2;
        }
        M(i2, this.f4628i, J(this.r, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TextView textView, int i2) {
        if (this.c == null && this.f4624e == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            this.c = linearLayout;
            linearLayout.setOrientation(0);
            this.b.addView(this.c, -1, -2);
            this.f4624e = new FrameLayout(this.a);
            this.c.addView(this.f4624e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.b.L() != null) {
                e();
            }
        }
        if (u(i2)) {
            FrameLayout frameLayout = this.f4624e;
            frameLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(frameLayout, 0);
            this.f4624e.addView(textView);
        } else {
            this.c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        LinearLayout linearLayout2 = this.c;
        linearLayout2.setVisibility(0);
        VdsAgent.onSetViewVisibility(linearLayout2, 0);
        this.f4623d++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (f()) {
            EditText L = this.b.L();
            boolean g2 = com.google.android.material.f.c.g(this.a);
            LinearLayout linearLayout = this.c;
            int i2 = R.dimen.material_helper_text_font_1_3_padding_horizontal;
            ViewCompat.setPaddingRelative(linearLayout, q(g2, i2, ViewCompat.getPaddingStart(L)), q(g2, R.dimen.material_helper_text_font_1_3_padding_top, this.a.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top)), q(g2, i2, ViewCompat.getPaddingEnd(L)), 0);
        }
    }

    void g() {
        Animator animator = this.f4625f;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return t(this.f4628i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public CharSequence m() {
        return this.f4629j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ColorInt
    public int n() {
        TextView textView = this.f4631l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public ColorStateList o() {
        TextView textView = this.f4631l;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence p() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.f4629j = null;
        g();
        if (this.f4627h == 1) {
            if (this.q && !TextUtils.isEmpty(this.p)) {
                this.f4628i = 2;
            } else {
                this.f4628i = 0;
            }
        }
        M(this.f4627h, this.f4628i, J(this.f4631l, null));
    }

    void s() {
        g();
        int i2 = this.f4627h;
        if (i2 == 2) {
            this.f4628i = 0;
        }
        M(i2, this.f4628i, J(this.r, null));
    }

    boolean u(int i2) {
        return i2 == 0 || i2 == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v() {
        return this.f4630k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(TextView textView, int i2) {
        FrameLayout frameLayout;
        if (this.c == null) {
            return;
        }
        if (u(i2) && (frameLayout = this.f4624e) != null) {
            frameLayout.removeView(textView);
        } else {
            this.c.removeView(textView);
        }
        int i3 = this.f4623d - 1;
        this.f4623d = i3;
        I(this.c, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(@Nullable CharSequence charSequence) {
        this.m = charSequence;
        TextView textView = this.f4631l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }
}
