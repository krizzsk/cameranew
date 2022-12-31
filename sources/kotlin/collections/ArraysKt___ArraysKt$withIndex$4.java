package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
/* compiled from: _Arrays.kt */
/* loaded from: classes3.dex */
final class ArraysKt___ArraysKt$withIndex$4 extends Lambda implements kotlin.jvm.b.a<Iterator<? extends Integer>> {
    final /* synthetic */ int[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$4(int[] iArr) {
        super(0);
        this.$this_withIndex = iArr;
    }

    @Override // kotlin.jvm.b.a
    public final Iterator<? extends Integer> invoke() {
        return kotlin.jvm.internal.i.f(this.$this_withIndex);
    }
}
