package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.n;
import kotlin.o;
/* compiled from: _UArrays.kt */
/* loaded from: classes3.dex */
final class UArraysKt___UArraysKt$withIndex$1 extends Lambda implements a<Iterator<? extends n>> {
    final /* synthetic */ int[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UArraysKt___UArraysKt$withIndex$1(int[] iArr) {
        super(0);
        this.$this_withIndex = iArr;
    }

    @Override // kotlin.jvm.b.a
    public final Iterator<? extends n> invoke() {
        return o.a(this.$this_withIndex);
    }
}
