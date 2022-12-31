package com.pinguo.camera360.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class EditTextWithFork extends AppCompatEditText {
    private Drawable a;
    private Drawable b;

    /* loaded from: classes3.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            EditTextWithFork editTextWithFork = EditTextWithFork.this;
            if (editTextWithFork.getCompoundDrawables()[2] == null) {
                return false;
            }
            if (motionEvent.getX() > (editTextWithFork.getWidth() - editTextWithFork.getPaddingRight()) - EditTextWithFork.this.a.getIntrinsicWidth() && (motionEvent.getAction() != 1 || motionEvent.getAction() != 3)) {
                EditTextWithFork editTextWithFork2 = EditTextWithFork.this;
                editTextWithFork2.setCompoundDrawables(editTextWithFork2.getCompoundDrawables()[0], EditTextWithFork.this.getCompoundDrawables()[1], EditTextWithFork.this.b, EditTextWithFork.this.getCompoundDrawables()[3]);
            }
            if (motionEvent.getAction() == 1 && motionEvent.getX() > (editTextWithFork.getWidth() - editTextWithFork.getPaddingRight()) - EditTextWithFork.this.a.getIntrinsicWidth()) {
                editTextWithFork.setText("");
                EditTextWithFork editTextWithFork3 = EditTextWithFork.this;
                editTextWithFork3.setCompoundDrawables(editTextWithFork3.getCompoundDrawables()[0], EditTextWithFork.this.getCompoundDrawables()[1], EditTextWithFork.this.a, EditTextWithFork.this.getCompoundDrawables()[3]);
            }
            return false;
        }
    }

    public EditTextWithFork(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        c();
    }

    private void c() {
        this.a = getResources().getDrawable(R.drawable.edittext_clear_default);
        this.b = getResources().getDrawable(R.drawable.edittext_clear_press);
        Drawable drawable = this.a;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.a.getIntrinsicHeight());
        Drawable drawable2 = this.b;
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.b.getIntrinsicHeight());
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.a, getCompoundDrawables()[3]);
    }

    public void setClearButtonEvent() {
        setOnTouchListener(new a());
    }
}
