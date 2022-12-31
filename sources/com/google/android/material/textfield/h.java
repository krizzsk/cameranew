package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R;
import com.google.android.material.internal.j;
import com.google.android.material.textfield.TextInputLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PasswordToggleEndIconDelegate.java */
/* loaded from: classes2.dex */
public class h extends e {

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f4634d;

    /* renamed from: e  reason: collision with root package name */
    private final TextInputLayout.f f4635e;

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.g f4636f;

    /* compiled from: PasswordToggleEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class a extends j {
        a() {
        }

        @Override // com.google.android.material.internal.j, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            h hVar = h.this;
            hVar.c.setChecked(!hVar.g());
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class b implements TextInputLayout.f {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(@NonNull TextInputLayout textInputLayout) {
            EditText L = textInputLayout.L();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            h hVar = h.this;
            hVar.c.setChecked(!hVar.g());
            L.removeTextChangedListener(h.this.f4634d);
            L.addTextChangedListener(h.this.f4634d);
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class c implements TextInputLayout.g {

        /* compiled from: PasswordToggleEndIconDelegate.java */
        /* loaded from: classes2.dex */
        class a implements Runnable {
            final /* synthetic */ EditText a;

            a(EditText editText) {
                this.a = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.removeTextChangedListener(h.this.f4634d);
            }
        }

        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(@NonNull TextInputLayout textInputLayout, int i2) {
            EditText L = textInputLayout.L();
            if (L == null || i2 != 1) {
                return;
            }
            L.setTransformationMethod(PasswordTransformationMethod.getInstance());
            L.post(new a(L));
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate.java */
    /* loaded from: classes2.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            EditText L = h.this.a.L();
            if (L == null) {
                return;
            }
            int selectionEnd = L.getSelectionEnd();
            if (h.this.g()) {
                L.setTransformationMethod(null);
            } else {
                L.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                L.setSelection(selectionEnd);
            }
            h.this.a.o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f4634d = new a();
        this.f4635e = new b();
        this.f4636f = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        EditText L = this.a.L();
        return L != null && (L.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean h(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.b, R.drawable.design_password_eye));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.password_toggle_content_description));
        this.a.setEndIconOnClickListener(new d());
        this.a.e(this.f4635e);
        this.a.f(this.f4636f);
        EditText L = this.a.L();
        if (h(L)) {
            L.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
