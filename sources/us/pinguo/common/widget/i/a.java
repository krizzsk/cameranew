package us.pinguo.common.widget.i;

import android.text.SpannableString;
import android.text.style.StyleSpan;
import kotlin.jvm.internal.s;
import kotlin.z.d;
import us.pinguo.foundation.e;
/* compiled from: ViewExtensions.kt */
/* loaded from: classes4.dex */
public final class a {
    public static final int a(Number number) {
        s.h(number, "<this>");
        return (int) (number.intValue() * e.b().getResources().getDisplayMetrics().density);
    }

    public static final float b(Number number) {
        s.h(number, "<this>");
        return number.floatValue() * e.b().getResources().getDisplayMetrics().density;
    }

    public static final CharSequence c(CharSequence charSequence, int i2, d range) {
        s.h(charSequence, "<this>");
        s.h(range, "range");
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new StyleSpan(i2), range.a(), range.b(), 17);
        return spannableString;
    }
}
