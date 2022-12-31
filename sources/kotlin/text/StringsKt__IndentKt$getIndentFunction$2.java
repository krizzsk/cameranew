package kotlin.text;

import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Indent.kt */
/* loaded from: classes3.dex */
public final class StringsKt__IndentKt$getIndentFunction$2 extends Lambda implements kotlin.jvm.b.l<String, String> {
    final /* synthetic */ String $indent;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt__IndentKt$getIndentFunction$2(String str) {
        super(1);
        this.$indent = str;
    }

    @Override // kotlin.jvm.b.l
    public final String invoke(String line) {
        kotlin.jvm.internal.s.h(line, "line");
        return this.$indent + line;
    }
}
