package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.j;
import com.google.android.material.textfield.TextInputLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {
    private final Chip a;
    private final TextInputLayout b;
    private final EditText c;

    /* renamed from: d  reason: collision with root package name */
    private TextWatcher f4637d;

    /* loaded from: classes2.dex */
    private class b extends j {
        private b() {
        }

        @Override // com.google.android.material.internal.j, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.a.setText(ChipTextInputComboView.this.d("00"));
            } else {
                ChipTextInputComboView.this.a.setText(ChipTextInputComboView.this.d(editable));
            }
        }
    }

    public ChipTextInputComboView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(CharSequence charSequence) {
        return TimeModel.a(getResources(), charSequence);
    }

    private void h() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    public void c(InputFilter inputFilter) {
        InputFilter[] filters = this.c.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.c.setFilters(inputFilterArr);
    }

    public TextInputLayout e() {
        return this.b;
    }

    public void f(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.a, accessibilityDelegateCompat);
    }

    public void g(CharSequence charSequence) {
        this.a.setText(d(charSequence));
        if (TextUtils.isEmpty(this.c.getText())) {
            return;
        }
        this.c.removeTextChangedListener(this.f4637d);
        this.c.setText((CharSequence) null);
        this.c.addTextChangedListener(this.f4637d);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.a.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        h();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        this.a.setChecked(z);
        EditText editText = this.c;
        int i2 = z ? 0 : 4;
        editText.setVisibility(i2);
        VdsAgent.onSetViewVisibility(editText, i2);
        Chip chip = this.a;
        int i3 = z ? 8 : 0;
        chip.setVisibility(i3);
        VdsAgent.onSetViewVisibility(chip, i3);
        if (isChecked()) {
            this.c.requestFocus();
            if (TextUtils.isEmpty(this.c.getText())) {
                return;
            }
            EditText editText2 = this.c;
            editText2.setSelection(editText2.getText().length());
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i2, Object obj) {
        this.a.setTag(i2, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.a.toggle();
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.a = chip;
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        this.b = textInputLayout;
        EditText L = textInputLayout.L();
        this.c = L;
        L.setVisibility(4);
        VdsAgent.onSetViewVisibility(L, 4);
        b bVar = new b();
        this.f4637d = bVar;
        L.addTextChangedListener(bVar);
        h();
        addView(chip);
        addView(textInputLayout);
        TextView textView = (TextView) findViewById(R.id.material_label);
        L.setSaveEnabled(false);
    }
}
