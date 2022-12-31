package kotlin.text;

import kotlin.jvm.internal.Lambda;
/* compiled from: _Strings.kt */
/* loaded from: classes3.dex */
final class StringsKt___StringsKt$windowed$1 extends Lambda implements kotlin.jvm.b.l<CharSequence, String> {
    public static final StringsKt___StringsKt$windowed$1 INSTANCE = new StringsKt___StringsKt$windowed$1();

    StringsKt___StringsKt$windowed$1() {
        super(1);
    }

    @Override // kotlin.jvm.b.l
    public final String invoke(CharSequence it) {
        kotlin.jvm.internal.s.h(it, "it");
        return it.toString();
    }
}
