package kotlin.text;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
/* compiled from: _Strings.kt */
/* loaded from: classes3.dex */
final class StringsKt___StringsKt$withIndex$1 extends Lambda implements kotlin.jvm.b.a<Iterator<? extends Character>> {
    final /* synthetic */ CharSequence $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StringsKt___StringsKt$withIndex$1(CharSequence charSequence) {
        super(0);
        this.$this_withIndex = charSequence;
    }

    @Override // kotlin.jvm.b.a
    public final Iterator<? extends Character> invoke() {
        return StringsKt__StringsKt.R(this.$this_withIndex);
    }
}
