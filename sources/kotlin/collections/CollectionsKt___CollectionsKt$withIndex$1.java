package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
/* compiled from: _Collections.kt */
/* loaded from: classes3.dex */
final class CollectionsKt___CollectionsKt$withIndex$1 extends Lambda implements kotlin.jvm.b.a<Iterator<? extends T>> {
    final /* synthetic */ Iterable<T> $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CollectionsKt___CollectionsKt$withIndex$1(Iterable<? extends T> iterable) {
        super(0);
        this.$this_withIndex = iterable;
    }

    @Override // kotlin.jvm.b.a
    public final Iterator<T> invoke() {
        return this.$this_withIndex.iterator();
    }
}
