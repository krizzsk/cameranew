package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
/* compiled from: _SequencesJvm.kt */
/* loaded from: classes3.dex */
final class SequencesKt___SequencesJvmKt$filterIsInstance$1 extends Lambda implements kotlin.jvm.b.l<Object, Boolean> {
    final /* synthetic */ Class<R> $klass;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesJvmKt$filterIsInstance$1(Class<R> cls) {
        super(1);
        this.$klass = cls;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.l
    public final Boolean invoke(Object obj) {
        return Boolean.valueOf(this.$klass.isInstance(obj));
    }
}
