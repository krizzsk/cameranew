package kotlin.sequences;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
/* compiled from: _Sequences.kt */
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$onEachIndexed$1 extends Lambda implements p<Integer, T, T> {
    final /* synthetic */ p<Integer, T, u> $action;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SequencesKt___SequencesKt$onEachIndexed$1(p<? super Integer, ? super T, u> pVar) {
        super(2);
        this.$action = pVar;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Object obj) {
        return invoke(num.intValue(), (int) obj);
    }

    public final T invoke(int i2, T t) {
        this.$action.invoke(Integer.valueOf(i2), t);
        return t;
    }
}
