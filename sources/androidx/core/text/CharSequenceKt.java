package androidx.core.text;

import android.text.TextUtils;
import kotlin.jvm.internal.s;
/* compiled from: CharSequence.kt */
/* loaded from: classes.dex */
public final class CharSequenceKt {
    public static final boolean isDigitsOnly(CharSequence charSequence) {
        s.h(charSequence, "<this>");
        return TextUtils.isDigitsOnly(charSequence);
    }

    public static final int trimmedLength(CharSequence charSequence) {
        s.h(charSequence, "<this>");
        return TextUtils.getTrimmedLength(charSequence);
    }
}
