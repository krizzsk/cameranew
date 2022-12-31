package kotlin.text;

import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strings.kt */
/* loaded from: classes3.dex */
public final class StringsKt__StringsKt$rangesDelimitedBy$2 extends Lambda implements kotlin.jvm.b.p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ List<String> $delimitersList;
    final /* synthetic */ boolean $ignoreCase;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$rangesDelimitedBy$2(List<String> list, boolean z) {
        super(2);
        this.$delimitersList = list;
        this.$ignoreCase = z;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        return invoke(charSequence, num.intValue());
    }

    public final Pair<Integer, Integer> invoke(CharSequence $receiver, int i2) {
        Pair H;
        kotlin.jvm.internal.s.h($receiver, "$this$$receiver");
        H = StringsKt__StringsKt.H($receiver, this.$delimitersList, i2, this.$ignoreCase, false);
        if (H != null) {
            return kotlin.k.a(H.getFirst(), Integer.valueOf(((String) H.getSecond()).length()));
        }
        return null;
    }
}
