package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClearTextEndIconDelegate.java */
/* loaded from: classes2.dex */
public class a extends com.google.android.material.textfield.e {

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f4608d;

    /* renamed from: e  reason: collision with root package name */
    private final View.OnFocusChangeListener f4609e;

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.f f4610f;

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.g f4611g;

    /* renamed from: h  reason: collision with root package name */
    private AnimatorSet f4612h;

    /* renamed from: i  reason: collision with root package name */
    private ValueAnimator f4613i;

    /* compiled from: ClearTextEndIconDelegate.java */
    /* renamed from: com.google.android.material.textfield.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0180a implements TextWatcher {
        C0180a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            if (a.this.a.a0() != null) {
                return;
            }
            a aVar = a.this;
            aVar.i(aVar.a.hasFocus() && a.l(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        @Instrumented
        public void onFocusChange(View view, boolean z) {
            VdsAgent.onFocusChange(this, view, z);
            boolean z2 = true;
            a.this.i(((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z) ? false : false);
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class c implements TextInputLayout.f {
        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(@NonNull TextInputLayout textInputLayout) {
            EditText L = textInputLayout.L();
            textInputLayout.setEndIconVisible(L.hasFocus() && a.l(L.getText()));
            textInputLayout.setEndIconCheckable(false);
            L.setOnFocusChangeListener(a.this.f4609e);
            L.removeTextChangedListener(a.this.f4608d);
            L.addTextChangedListener(a.this.f4608d);
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class d implements TextInputLayout.g {

        /* compiled from: ClearTextEndIconDelegate.java */
        /* renamed from: com.google.android.material.textfield.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0181a implements Runnable {
            final /* synthetic */ EditText a;

            RunnableC0181a(EditText editText) {
                this.a = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.removeTextChangedListener(a.this.f4608d);
            }
        }

        d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(@NonNull TextInputLayout textInputLayout, int i2) {
            EditText L = textInputLayout.L();
            if (L == null || i2 != 2) {
                return;
            }
            L.post(new RunnableC0181a(L));
            if (L.getOnFocusChangeListener() == a.this.f4609e) {
                L.setOnFocusChangeListener(null);
            }
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            Editable text = a.this.a.L().getText();
            if (text != null) {
                text.clear();
            }
            a.this.a.o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.a.setEndIconVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.a.setEndIconVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            a.this.c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.c.setScaleX(floatValue);
            a.this.c.setScaleY(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f4608d = new C0180a();
        this.f4609e = new b();
        this.f4610f = new c();
        this.f4611g = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z) {
        boolean z2 = this.a.d0() == z;
        if (z && !this.f4612h.isRunning()) {
            this.f4613i.cancel();
            this.f4612h.start();
            if (z2) {
                this.f4612h.end();
            }
        } else if (z) {
        } else {
            this.f4612h.cancel();
            this.f4613i.start();
            if (z2) {
                this.f4613i.end();
            }
        }
    }

    private ValueAnimator j(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(com.google.android.material.animation.a.a);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new h());
        return ofFloat;
    }

    private ValueAnimator k() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(com.google.android.material.animation.a.f4032d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new i());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(@NonNull Editable editable) {
        return editable.length() > 0;
    }

    private void m() {
        ValueAnimator k2 = k();
        ValueAnimator j2 = j(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f4612h = animatorSet;
        animatorSet.playTogether(k2, j2);
        this.f4612h.addListener(new f());
        ValueAnimator j3 = j(1.0f, 0.0f);
        this.f4613i = j3;
        j3.addListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.b, R.drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.a.setEndIconOnClickListener(new e());
        this.a.e(this.f4610f);
        this.a.f(this.f4611g);
        m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void c(boolean z) {
        if (this.a.a0() == null) {
            return;
        }
        i(z);
    }
}
