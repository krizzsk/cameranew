package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.j;
import com.google.android.material.timepicker.TimePickerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.lang.reflect.Field;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimePickerTextInputPresenter.java */
/* loaded from: classes2.dex */
public class f implements TimePickerView.g, com.google.android.material.timepicker.d {
    private final LinearLayout a;
    private final TimeModel b;
    private final TextWatcher c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f4679d = new b();

    /* renamed from: e  reason: collision with root package name */
    private final ChipTextInputComboView f4680e;

    /* renamed from: f  reason: collision with root package name */
    private final ChipTextInputComboView f4681f;

    /* renamed from: g  reason: collision with root package name */
    private final e f4682g;

    /* renamed from: h  reason: collision with root package name */
    private final EditText f4683h;

    /* renamed from: i  reason: collision with root package name */
    private final EditText f4684i;

    /* renamed from: j  reason: collision with root package name */
    private MaterialButtonToggleGroup f4685j;

    /* compiled from: TimePickerTextInputPresenter.java */
    /* loaded from: classes2.dex */
    class a extends j {
        a() {
        }

        @Override // com.google.android.material.internal.j, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    f.this.b.k(0);
                    return;
                }
                f.this.b.k(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* compiled from: TimePickerTextInputPresenter.java */
    /* loaded from: classes2.dex */
    class b extends j {
        b() {
        }

        @Override // com.google.android.material.internal.j, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    f.this.b.j(0);
                    return;
                }
                f.this.b.j(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* compiled from: TimePickerTextInputPresenter.java */
    /* loaded from: classes2.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            f.this.e(((Integer) view.getTag(R.id.selection_type)).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimePickerTextInputPresenter.java */
    /* loaded from: classes2.dex */
    public class d implements MaterialButtonToggleGroup.e {
        d() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z) {
            f.this.b.l(i2 == R.id.material_clock_period_pm_button ? 1 : 0);
        }
    }

    public f(LinearLayout linearLayout, TimeModel timeModel) {
        this.a = linearLayout;
        this.b = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_minute_text_input);
        this.f4680e = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_hour_text_input);
        this.f4681f = chipTextInputComboView2;
        int i2 = R.id.material_label;
        ((TextView) chipTextInputComboView.findViewById(i2)).setText(resources.getString(R.string.material_timepicker_minute));
        ((TextView) chipTextInputComboView2.findViewById(i2)).setText(resources.getString(R.string.material_timepicker_hour));
        int i3 = R.id.selection_type;
        chipTextInputComboView.setTag(i3, 12);
        chipTextInputComboView2.setTag(i3, 10);
        if (timeModel.a == 0) {
            l();
        }
        c cVar = new c();
        chipTextInputComboView2.setOnClickListener(cVar);
        chipTextInputComboView.setOnClickListener(cVar);
        chipTextInputComboView2.c(timeModel.f());
        chipTextInputComboView.c(timeModel.g());
        EditText L = chipTextInputComboView2.e().L();
        this.f4683h = L;
        EditText L2 = chipTextInputComboView.e().L();
        this.f4684i = L2;
        if (Build.VERSION.SDK_INT < 21) {
            int d2 = com.google.android.material.b.a.d(linearLayout, R.attr.colorPrimary);
            j(L, d2);
            j(L2, d2);
        }
        this.f4682g = new e(chipTextInputComboView2, chipTextInputComboView, timeModel);
        chipTextInputComboView2.f(new com.google.android.material.timepicker.a(linearLayout.getContext(), R.string.material_hour_selection));
        chipTextInputComboView.f(new com.google.android.material.timepicker.a(linearLayout.getContext(), R.string.material_minute_selection));
        g();
    }

    private void d() {
        this.f4683h.addTextChangedListener(this.f4679d);
        this.f4684i.addTextChangedListener(this.c);
    }

    private void h() {
        this.f4683h.removeTextChangedListener(this.f4679d);
        this.f4684i.removeTextChangedListener(this.c);
    }

    private static void j(EditText editText, @ColorInt int i2) {
        try {
            Context context = editText.getContext();
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i3 = declaredField.getInt(editText);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            Drawable drawable = AppCompatResources.getDrawable(context, i3);
            drawable.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, new Drawable[]{drawable, drawable});
        } catch (Throwable unused) {
        }
    }

    private void k(TimeModel timeModel) {
        h();
        Locale locale = this.a.getResources().getConfiguration().locale;
        String format = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(timeModel.c));
        String format2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(timeModel.c()));
        this.f4680e.g(format);
        this.f4681f.g(format2);
        d();
        m();
    }

    private void l() {
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.a.findViewById(R.id.material_clock_period_toggle);
        this.f4685j = materialButtonToggleGroup;
        materialButtonToggleGroup.g(new d());
        MaterialButtonToggleGroup materialButtonToggleGroup2 = this.f4685j;
        materialButtonToggleGroup2.setVisibility(0);
        VdsAgent.onSetViewVisibility(materialButtonToggleGroup2, 0);
        m();
    }

    private void m() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f4685j;
        if (materialButtonToggleGroup == null) {
            return;
        }
        materialButtonToggleGroup.j(this.b.f4666e == 0 ? R.id.material_clock_period_am_button : R.id.material_clock_period_pm_button);
    }

    @Override // com.google.android.material.timepicker.d
    public void a() {
        View focusedChild = this.a.getFocusedChild();
        if (focusedChild == null) {
            LinearLayout linearLayout = this.a;
            linearLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(linearLayout, 8);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(this.a.getContext(), InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        LinearLayout linearLayout2 = this.a;
        linearLayout2.setVisibility(8);
        VdsAgent.onSetViewVisibility(linearLayout2, 8);
    }

    @Override // com.google.android.material.timepicker.d
    public void b() {
        k(this.b);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.g
    public void e(int i2) {
        this.b.f4665d = i2;
        this.f4680e.setChecked(i2 == 12);
        this.f4681f.setChecked(i2 == 10);
        m();
    }

    public void f() {
        this.f4680e.setChecked(false);
        this.f4681f.setChecked(false);
    }

    public void g() {
        d();
        k(this.b);
        this.f4682g.a();
    }

    public void i() {
        this.f4680e.setChecked(this.b.f4665d == 12);
        this.f4681f.setChecked(this.b.f4665d == 10);
    }

    @Override // com.google.android.material.timepicker.d
    public void show() {
        LinearLayout linearLayout = this.a;
        linearLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(linearLayout, 0);
    }
}
