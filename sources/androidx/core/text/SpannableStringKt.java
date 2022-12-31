package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import kotlin.jvm.internal.s;
import kotlin.z.d;
/* compiled from: SpannableString.kt */
/* loaded from: classes.dex */
public final class SpannableStringKt {
    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(Spannable spannable) {
        s.h(spannable, "<this>");
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        s.g(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(Spannable spannable, int i2, int i3, Object span) {
        s.h(spannable, "<this>");
        s.h(span, "span");
        spannable.setSpan(span, i2, i3, 17);
    }

    public static final Spannable toSpannable(CharSequence charSequence) {
        s.h(charSequence, "<this>");
        SpannableString valueOf = SpannableString.valueOf(charSequence);
        s.g(valueOf, "valueOf(this)");
        return valueOf;
    }

    public static final void set(Spannable spannable, d range, Object span) {
        s.h(spannable, "<this>");
        s.h(range, "range");
        s.h(span, "span");
        spannable.setSpan(span, range.getStart().intValue(), range.getEndInclusive().intValue(), 17);
    }
}
