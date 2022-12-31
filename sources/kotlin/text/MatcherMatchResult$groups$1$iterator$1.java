package kotlin.text;

import kotlin.jvm.internal.Lambda;
import kotlin.text.i;
/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
final class MatcherMatchResult$groups$1$iterator$1 extends Lambda implements kotlin.jvm.b.l<Integer, g> {
    final /* synthetic */ i.a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MatcherMatchResult$groups$1$iterator$1(i.a aVar) {
        super(1);
        this.this$0 = aVar;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ g invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final g invoke(int i2) {
        return this.this$0.c(i2);
    }
}
