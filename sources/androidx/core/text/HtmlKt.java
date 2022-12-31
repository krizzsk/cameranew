package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import kotlin.jvm.internal.s;
/* compiled from: Html.kt */
/* loaded from: classes.dex */
public final class HtmlKt {
    public static final Spanned parseAsHtml(String str, int i2, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        s.h(str, "<this>");
        Spanned fromHtml = HtmlCompat.fromHtml(str, i2, imageGetter, tagHandler);
        s.g(fromHtml, "fromHtml(this, flags, imageGetter, tagHandler)");
        return fromHtml;
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String str, int i2, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            imageGetter = null;
        }
        if ((i3 & 4) != 0) {
            tagHandler = null;
        }
        s.h(str, "<this>");
        Spanned fromHtml = HtmlCompat.fromHtml(str, i2, imageGetter, tagHandler);
        s.g(fromHtml, "fromHtml(this, flags, imageGetter, tagHandler)");
        return fromHtml;
    }

    public static final String toHtml(Spanned spanned, int i2) {
        s.h(spanned, "<this>");
        String html = HtmlCompat.toHtml(spanned, i2);
        s.g(html, "toHtml(this, option)");
        return html;
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        s.h(spanned, "<this>");
        String html = HtmlCompat.toHtml(spanned, i2);
        s.g(html, "toHtml(this, option)");
        return html;
    }
}
