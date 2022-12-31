package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.s;
import kotlin.t;
/* compiled from: _UArrays.kt */
/* loaded from: classes3.dex */
final class UArraysKt___UArraysKt$withIndex$4 extends Lambda implements a<Iterator<? extends s>> {
    final /* synthetic */ short[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UArraysKt___UArraysKt$withIndex$4(short[] sArr) {
        super(0);
        this.$this_withIndex = sArr;
    }

    @Override // kotlin.jvm.b.a
    public final Iterator<? extends s> invoke() {
        return t.a(this.$this_withIndex);
    }
}
