package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
/* compiled from: _Arrays.kt */
/* loaded from: classes3.dex */
final class ArraysKt___ArraysKt$withIndex$5 extends Lambda implements kotlin.jvm.b.a<Iterator<? extends Long>> {
    final /* synthetic */ long[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$5(long[] jArr) {
        super(0);
        this.$this_withIndex = jArr;
    }

    @Override // kotlin.jvm.b.a
    public final Iterator<? extends Long> invoke() {
        return kotlin.jvm.internal.i.g(this.$this_withIndex);
    }
}
