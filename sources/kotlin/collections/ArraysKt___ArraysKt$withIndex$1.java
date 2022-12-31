package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
/* compiled from: _Arrays.kt */
/* loaded from: classes3.dex */
final class ArraysKt___ArraysKt$withIndex$1 extends Lambda implements kotlin.jvm.b.a<Iterator<? extends T>> {
    final /* synthetic */ T[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$1(T[] tArr) {
        super(0);
        this.$this_withIndex = tArr;
    }

    @Override // kotlin.jvm.b.a
    public final Iterator<T> invoke() {
        return kotlin.jvm.internal.h.a(this.$this_withIndex);
    }
}
