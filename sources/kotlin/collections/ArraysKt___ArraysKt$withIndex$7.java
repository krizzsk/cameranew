package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
/* compiled from: _Arrays.kt */
/* loaded from: classes3.dex */
final class ArraysKt___ArraysKt$withIndex$7 extends Lambda implements kotlin.jvm.b.a<Iterator<? extends Double>> {
    final /* synthetic */ double[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$7(double[] dArr) {
        super(0);
        this.$this_withIndex = dArr;
    }

    @Override // kotlin.jvm.b.a
    public final Iterator<? extends Double> invoke() {
        return kotlin.jvm.internal.i.d(this.$this_withIndex);
    }
}
