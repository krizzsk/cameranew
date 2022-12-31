package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.R;
import com.google.android.material.internal.k;
/* loaded from: classes2.dex */
public class TextInputEditText extends AppCompatEditText {
    private final Rect a;
    private boolean b;

    public TextInputEditText(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private String a(@NonNull TextInputLayout textInputLayout) {
        Editable text = getText();
        CharSequence U = textInputLayout.U();
        boolean z = !TextUtils.isEmpty(text);
        boolean z2 = !TextUtils.isEmpty(U);
        if (Build.VERSION.SDK_INT >= 17) {
            setLabelFor(R.id.textinput_helper_text);
        }
        String str = "";
        String charSequence = z2 ? U.toString() : "";
        if (!z) {
            return !TextUtils.isEmpty(charSequence) ? charSequence : "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) text);
        if (!TextUtils.isEmpty(charSequence)) {
            str = ", " + charSequence;
        }
        sb.append(str);
        return sb.toString();
    }

    @Nullable
    private CharSequence b() {
        TextInputLayout c = c();
        if (c != null) {
            return c.U();
        }
        return null;
    }

    @Nullable
    private TextInputLayout c() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@Nullable Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout c = c();
        if (c == null || !this.b || rect == null) {
            return;
        }
        c.getFocusedRect(this.a);
        rect.bottom = this.a.bottom;
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(@Nullable Rect rect, @Nullable Point point) {
        boolean globalVisibleRect = super.getGlobalVisibleRect(rect, point);
        TextInputLayout c = c();
        if (c != null && this.b && rect != null) {
            c.getGlobalVisibleRect(this.a, point);
            rect.bottom = this.a.bottom;
        }
        return globalVisibleRect;
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout c = c();
        if (c != null && c.h0()) {
            return c.U();
        }
        return super.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout c = c();
        if (c != null && c.h0() && super.getHint() == null && com.google.android.material.internal.d.c()) {
            setHint("");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = b();
        }
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        TextInputLayout c = c();
        if (Build.VERSION.SDK_INT >= 23 || c == null) {
            return;
        }
        accessibilityNodeInfo.setText(a(c));
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(@Nullable Rect rect) {
        boolean requestRectangleOnScreen = super.requestRectangleOnScreen(rect);
        TextInputLayout c = c();
        if (c != null && this.b) {
            this.a.set(0, c.getHeight() - getResources().getDimensionPixelOffset(R.dimen.mtrl_edittext_rectangle_top_offset), c.getWidth(), c.getHeight());
            c.requestRectangleOnScreen(this.a, true);
        }
        return requestRectangleOnScreen;
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z) {
        this.b = z;
    }

    public TextInputEditText(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public TextInputEditText(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, 0), attributeSet, i2);
        this.a = new Rect();
        TypedArray h2 = k.h(context, attributeSet, R.styleable.TextInputEditText, i2, R.style.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(h2.getBoolean(R.styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        h2.recycle();
    }
}
