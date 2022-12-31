package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
/* compiled from: _Arrays.kt */
/* loaded from: classes3.dex */
final class ArraysKt___ArraysKt$withIndex$9 extends Lambda implements kotlin.jvm.b.a<Iterator<? extends Character>> {
    final /* synthetic */ char[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$9(char[] cArr) {
        super(0);
        this.$this_withIndex = cArr;
    }

    @Override // kotlin.jvm.b.a
    public final Iterator<? extends Character> invoke() {
        return kotlin.jvm.internal.i.c(this.$this_withIndex);
    }
}
