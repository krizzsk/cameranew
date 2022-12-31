package kotlin.text;

import kotlin.jvm.internal.Lambda;
/* compiled from: Strings.kt */
/* loaded from: classes3.dex */
final class StringsKt__StringsKt$splitToSequence$2 extends Lambda implements kotlin.jvm.b.l<kotlin.z.d, String> {
    final /* synthetic */ CharSequence $this_splitToSequence;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$splitToSequence$2(CharSequence charSequence) {
        super(1);
        this.$this_splitToSequence = charSequence;
    }

    @Override // kotlin.jvm.b.l
    public final String invoke(kotlin.z.d it) {
        kotlin.jvm.internal.s.h(it, "it");
        return StringsKt__StringsKt.w0(this.$this_splitToSequence, it);
    }
}
