package us.pinguo.common.utils;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.s;
/* compiled from: ViewExtensions.kt */
/* loaded from: classes4.dex */
public final class k {
    public static final TextView a(TextView textView, String string, @ColorInt int i2, int i3, int i4, int i5) {
        s.h(textView, "<this>");
        s.h(string, "string");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(i2), i3, i4, i5);
        textView.setText(spannableString);
        return textView;
    }

    public static final int b(int i2) {
        return ContextCompat.getColor(us.pinguo.foundation.e.b(), i2);
    }

    public static final String c(int i2) {
        String string = us.pinguo.foundation.e.b().getString(i2);
        s.g(string, "getAppContext().getString(this)");
        return string;
    }
}
