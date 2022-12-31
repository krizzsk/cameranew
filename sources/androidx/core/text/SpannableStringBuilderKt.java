package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: SpannableStringBuilder.kt */
/* loaded from: classes.dex */
public final class SpannableStringBuilderKt {
    public static final SpannableStringBuilder backgroundColor(SpannableStringBuilder spannableStringBuilder, @ColorInt int i2, l<? super SpannableStringBuilder, u> builderAction) {
        s.h(spannableStringBuilder, "<this>");
        s.h(builderAction, "builderAction");
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(i2);
        int length = spannableStringBuilder.length();
        builderAction.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(backgroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder bold(SpannableStringBuilder spannableStringBuilder, l<? super SpannableStringBuilder, u> builderAction) {
        s.h(spannableStringBuilder, "<this>");
        s.h(builderAction, "builderAction");
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableStringBuilder.length();
        builderAction.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannedString buildSpannedString(l<? super SpannableStringBuilder, u> builderAction) {
        s.h(builderAction, "builderAction");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        builderAction.invoke(spannableStringBuilder);
        return new SpannedString(spannableStringBuilder);
    }

    public static final SpannableStringBuilder color(SpannableStringBuilder spannableStringBuilder, @ColorInt int i2, l<? super SpannableStringBuilder, u> builderAction) {
        s.h(spannableStringBuilder, "<this>");
        s.h(builderAction, "builderAction");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i2);
        int length = spannableStringBuilder.length();
        builderAction.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(foregroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder spannableStringBuilder, Object[] spans, l<? super SpannableStringBuilder, u> builderAction) {
        s.h(spannableStringBuilder, "<this>");
        s.h(spans, "spans");
        s.h(builderAction, "builderAction");
        int length = spannableStringBuilder.length();
        builderAction.invoke(spannableStringBuilder);
        int length2 = spans.length;
        int i2 = 0;
        while (i2 < length2) {
            Object obj = spans[i2];
            i2++;
            spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder italic(SpannableStringBuilder spannableStringBuilder, l<? super SpannableStringBuilder, u> builderAction) {
        s.h(spannableStringBuilder, "<this>");
        s.h(builderAction, "builderAction");
        StyleSpan styleSpan = new StyleSpan(2);
        int length = spannableStringBuilder.length();
        builderAction.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder scale(SpannableStringBuilder spannableStringBuilder, float f2, l<? super SpannableStringBuilder, u> builderAction) {
        s.h(spannableStringBuilder, "<this>");
        s.h(builderAction, "builderAction");
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(f2);
        int length = spannableStringBuilder.length();
        builderAction.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(relativeSizeSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder strikeThrough(SpannableStringBuilder spannableStringBuilder, l<? super SpannableStringBuilder, u> builderAction) {
        s.h(spannableStringBuilder, "<this>");
        s.h(builderAction, "builderAction");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        int length = spannableStringBuilder.length();
        builderAction.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(strikethroughSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder subscript(SpannableStringBuilder spannableStringBuilder, l<? super SpannableStringBuilder, u> builderAction) {
        s.h(spannableStringBuilder, "<this>");
        s.h(builderAction, "builderAction");
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        int length = spannableStringBuilder.length();
        builderAction.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(subscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder superscript(SpannableStringBuilder spannableStringBuilder, l<? super SpannableStringBuilder, u> builderAction) {
        s.h(spannableStringBuilder, "<this>");
        s.h(builderAction, "builderAction");
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        int length = spannableStringBuilder.length();
        builderAction.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(superscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder underline(SpannableStringBuilder spannableStringBuilder, l<? super SpannableStringBuilder, u> builderAction) {
        s.h(spannableStringBuilder, "<this>");
        s.h(builderAction, "builderAction");
        UnderlineSpan underlineSpan = new UnderlineSpan();
        int length = spannableStringBuilder.length();
        builderAction.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(underlineSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder spannableStringBuilder, Object span, l<? super SpannableStringBuilder, u> builderAction) {
        s.h(spannableStringBuilder, "<this>");
        s.h(span, "span");
        s.h(builderAction, "builderAction");
        int length = spannableStringBuilder.length();
        builderAction.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(span, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }
}
