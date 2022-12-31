package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
/* compiled from: _Arrays.kt */
/* loaded from: classes3.dex */
final class ArraysKt___ArraysKt$withIndex$6 extends Lambda implements kotlin.jvm.b.a<Iterator<? extends Float>> {
    final /* synthetic */ float[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$6(float[] fArr) {
        super(0);
        this.$this_withIndex = fArr;
    }

    @Override // kotlin.jvm.b.a
    public final Iterator<? extends Float> invoke() {
        return kotlin.jvm.internal.i.e(this.$this_withIndex);
    }
}
