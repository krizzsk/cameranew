package kotlin.text;

import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Indent.kt */
/* loaded from: classes3.dex */
public final class StringsKt__IndentKt$getIndentFunction$1 extends Lambda implements kotlin.jvm.b.l<String, String> {
    public static final StringsKt__IndentKt$getIndentFunction$1 INSTANCE = new StringsKt__IndentKt$getIndentFunction$1();

    StringsKt__IndentKt$getIndentFunction$1() {
        super(1);
    }

    @Override // kotlin.jvm.b.l
    public final String invoke(String line) {
        kotlin.jvm.internal.s.h(line, "line");
        return line;
    }
}
