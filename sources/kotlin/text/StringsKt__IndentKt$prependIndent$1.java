package kotlin.text;

import kotlin.jvm.internal.Lambda;
/* compiled from: Indent.kt */
/* loaded from: classes3.dex */
final class StringsKt__IndentKt$prependIndent$1 extends Lambda implements kotlin.jvm.b.l<String, String> {
    final /* synthetic */ String $indent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StringsKt__IndentKt$prependIndent$1(String str) {
        super(1);
        this.$indent = str;
    }

    @Override // kotlin.jvm.b.l
    public final String invoke(String it) {
        boolean p;
        kotlin.jvm.internal.s.h(it, "it");
        p = t.p(it);
        if (p) {
            return it.length() < this.$indent.length() ? this.$indent : it;
        }
        return this.$indent + it;
    }
}
