package kotlin.text;

import kotlin.jvm.internal.Lambda;
/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
final class Regex$special$$inlined$fromInt$1 extends Lambda implements kotlin.jvm.b.l<RegexOption, Boolean> {
    final /* synthetic */ int $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Regex$special$$inlined$fromInt$1(int i2) {
        super(1);
        this.$value = i2;
    }

    @Override // kotlin.jvm.b.l
    public final Boolean invoke(RegexOption regexOption) {
        RegexOption regexOption2 = regexOption;
        return Boolean.valueOf((this.$value & regexOption2.getMask()) == regexOption2.getValue());
    }
}
