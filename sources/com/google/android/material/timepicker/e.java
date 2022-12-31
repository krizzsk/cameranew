package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
/* compiled from: TimePickerTextInputKeyController.java */
/* loaded from: classes2.dex */
class e implements TextView.OnEditorActionListener, View.OnKeyListener {
    private final ChipTextInputComboView a;
    private final ChipTextInputComboView b;
    private final TimeModel c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4678d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.a = chipTextInputComboView;
        this.b = chipTextInputComboView2;
        this.c = timeModel;
    }

    private void b(int i2) {
        this.b.setChecked(i2 == 12);
        this.a.setChecked(i2 == 10);
        this.c.f4665d = i2;
    }

    private boolean c(int i2, KeyEvent keyEvent, EditText editText) {
        Editable text = editText.getText();
        if (text == null) {
            return false;
        }
        if (i2 >= 7 && i2 <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2) {
            b(12);
            return true;
        }
        return false;
    }

    private boolean d(int i2, KeyEvent keyEvent, EditText editText) {
        if (i2 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText())) {
            b(10);
            return true;
        }
        return false;
    }

    public void a() {
        TextInputLayout e2 = this.a.e();
        TextInputLayout e3 = this.b.e();
        EditText L = e2.L();
        EditText L2 = e3.L();
        L.setImeOptions(268435461);
        L2.setImeOptions(268435462);
        L.setOnEditorActionListener(this);
        L.setOnKeyListener(this);
        L2.setOnKeyListener(this);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        boolean z = i2 == 5;
        if (z) {
            b(12);
        }
        return z;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        boolean c;
        if (this.f4678d) {
            return false;
        }
        this.f4678d = true;
        EditText editText = (EditText) view;
        if (this.c.f4665d == 12) {
            c = d(i2, keyEvent, editText);
        } else {
            c = c(i2, keyEvent, editText);
        }
        this.f4678d = false;
        return c;
    }
}
