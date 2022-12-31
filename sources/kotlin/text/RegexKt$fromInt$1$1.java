package kotlin.text;

import kotlin.jvm.internal.Lambda;
/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class RegexKt$fromInt$1$1 extends Lambda implements kotlin.jvm.b.l<T, Boolean> {
    final /* synthetic */ int $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegexKt$fromInt$1$1(int i2) {
        super(1);
        this.$value = i2;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)Ljava/lang/Boolean; */
    @Override // kotlin.jvm.b.l
    public final Boolean invoke(Enum r3) {
        f fVar = (f) r3;
        return Boolean.valueOf((this.$value & fVar.getMask()) == fVar.getValue());
    }
}
