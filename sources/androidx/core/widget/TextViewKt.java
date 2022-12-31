package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.jvm.b.l;
import kotlin.jvm.b.r;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: TextView.kt */
/* loaded from: classes.dex */
public final class TextViewKt {
    public static final TextWatcher addTextChangedListener(TextView textView, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, u> beforeTextChanged, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, u> onTextChanged, l<? super Editable, u> afterTextChanged) {
        s.h(textView, "<this>");
        s.h(beforeTextChanged, "beforeTextChanged");
        s.h(onTextChanged, "onTextChanged");
        s.h(afterTextChanged, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(afterTextChanged, beforeTextChanged, onTextChanged);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView textView, r beforeTextChanged, r onTextChanged, l afterTextChanged, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            beforeTextChanged = TextViewKt$addTextChangedListener$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            onTextChanged = TextViewKt$addTextChangedListener$2.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            afterTextChanged = TextViewKt$addTextChangedListener$3.INSTANCE;
        }
        s.h(textView, "<this>");
        s.h(beforeTextChanged, "beforeTextChanged");
        s.h(onTextChanged, "onTextChanged");
        s.h(afterTextChanged, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(afterTextChanged, beforeTextChanged, onTextChanged);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static final TextWatcher doAfterTextChanged(TextView textView, final l<? super Editable, u> action) {
        s.h(textView, "<this>");
        s.h(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                l.this.invoke(editable);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    public static final TextWatcher doBeforeTextChanged(TextView textView, final r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, u> action) {
        s.h(textView, "<this>");
        s.h(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                r.this.invoke(charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    public static final TextWatcher doOnTextChanged(TextView textView, final r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, u> action) {
        s.h(textView, "<this>");
        s.h(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                r.this.invoke(charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }
}
