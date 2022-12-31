package kotlin.text;

import java.nio.charset.Charset;
/* compiled from: Charsets.kt */
/* loaded from: classes3.dex */
public final class d {
    public static final Charset a;

    static {
        Charset forName = Charset.forName("UTF-8");
        kotlin.jvm.internal.s.g(forName, "forName(\"UTF-8\")");
        a = forName;
        kotlin.jvm.internal.s.g(Charset.forName("UTF-16"), "forName(\"UTF-16\")");
        kotlin.jvm.internal.s.g(Charset.forName("UTF-16BE"), "forName(\"UTF-16BE\")");
        kotlin.jvm.internal.s.g(Charset.forName("UTF-16LE"), "forName(\"UTF-16LE\")");
        kotlin.jvm.internal.s.g(Charset.forName("US-ASCII"), "forName(\"US-ASCII\")");
        kotlin.jvm.internal.s.g(Charset.forName("ISO-8859-1"), "forName(\"ISO-8859-1\")");
    }
}
