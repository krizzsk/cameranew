package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.p;
import kotlin.q;
/* compiled from: _UArrays.kt */
/* loaded from: classes3.dex */
final class UArraysKt___UArraysKt$withIndex$2 extends Lambda implements a<Iterator<? extends p>> {
    final /* synthetic */ long[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UArraysKt___UArraysKt$withIndex$2(long[] jArr) {
        super(0);
        this.$this_withIndex = jArr;
    }

    @Override // kotlin.jvm.b.a
    public final Iterator<? extends p> invoke() {
        return q.a(this.$this_withIndex);
    }
}
