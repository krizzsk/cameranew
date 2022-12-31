package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
/* compiled from: _Sequences.kt */
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$filterNotNull$1 extends Lambda implements kotlin.jvm.b.l<T, Boolean> {
    public static final SequencesKt___SequencesKt$filterNotNull$1 INSTANCE = new SequencesKt___SequencesKt$filterNotNull$1();

    SequencesKt___SequencesKt$filterNotNull$1() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.l
    public final Boolean invoke(T t) {
        return Boolean.valueOf(t == 0);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return invoke((SequencesKt___SequencesKt$filterNotNull$1) obj);
    }
}
