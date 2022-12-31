package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
/* compiled from: _Arrays.kt */
/* loaded from: classes3.dex */
final class ArraysKt___ArraysKt$withIndex$8 extends Lambda implements kotlin.jvm.b.a<Iterator<? extends Boolean>> {
    final /* synthetic */ boolean[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$8(boolean[] zArr) {
        super(0);
        this.$this_withIndex = zArr;
    }

    @Override // kotlin.jvm.b.a
    public final Iterator<? extends Boolean> invoke() {
        return kotlin.jvm.internal.i.a(this.$this_withIndex);
    }
}
