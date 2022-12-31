package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
/* compiled from: _Arrays.kt */
/* loaded from: classes3.dex */
final class ArraysKt___ArraysKt$withIndex$3 extends Lambda implements kotlin.jvm.b.a<Iterator<? extends Short>> {
    final /* synthetic */ short[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$3(short[] sArr) {
        super(0);
        this.$this_withIndex = sArr;
    }

    @Override // kotlin.jvm.b.a
    public final Iterator<? extends Short> invoke() {
        return kotlin.jvm.internal.i.h(this.$this_withIndex);
    }
}
