package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.jvm.b.l;
import kotlin.jvm.b.r;
import kotlin.u;
/* compiled from: TextView.kt */
/* loaded from: classes.dex */
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    final /* synthetic */ l<Editable, u> $afterTextChanged;
    final /* synthetic */ r<CharSequence, Integer, Integer, Integer, u> $beforeTextChanged;
    final /* synthetic */ r<CharSequence, Integer, Integer, Integer, u> $onTextChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public TextViewKt$addTextChangedListener$textWatcher$1(l<? super Editable, u> lVar, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, u> rVar, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, u> rVar2) {
        this.$afterTextChanged = lVar;
        this.$beforeTextChanged = rVar;
        this.$onTextChanged = rVar2;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.$onTextChanged.invoke(charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }
}
