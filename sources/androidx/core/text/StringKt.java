package androidx.core.text;

import android.text.TextUtils;
import kotlin.jvm.internal.s;
/* compiled from: String.kt */
/* loaded from: classes.dex */
public final class StringKt {
    public static final String htmlEncode(String str) {
        s.h(str, "<this>");
        String htmlEncode = TextUtils.htmlEncode(str);
        s.g(htmlEncode, "htmlEncode(this)");
        return htmlEncode;
    }
}
