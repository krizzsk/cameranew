package kotlin.text;

import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strings.kt */
/* loaded from: classes3.dex */
public final class StringsKt__StringsKt$rangesDelimitedBy$1 extends Lambda implements kotlin.jvm.b.p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ char[] $delimiters;
    final /* synthetic */ boolean $ignoreCase;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$rangesDelimitedBy$1(char[] cArr, boolean z) {
        super(2);
        this.$delimiters = cArr;
        this.$ignoreCase = z;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        return invoke(charSequence, num.intValue());
    }

    public final Pair<Integer, Integer> invoke(CharSequence $receiver, int i2) {
        kotlin.jvm.internal.s.h($receiver, "$this$$receiver");
        int Q = StringsKt__StringsKt.Q($receiver, this.$delimiters, i2, this.$ignoreCase);
        if (Q < 0) {
            return null;
        }
        return kotlin.k.a(Integer.valueOf(Q), 1);
    }
}
