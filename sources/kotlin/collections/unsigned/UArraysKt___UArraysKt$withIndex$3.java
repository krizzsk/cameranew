package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.l;
import kotlin.m;
/* compiled from: _UArrays.kt */
/* loaded from: classes3.dex */
final class UArraysKt___UArraysKt$withIndex$3 extends Lambda implements a<Iterator<? extends l>> {
    final /* synthetic */ byte[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UArraysKt___UArraysKt$withIndex$3(byte[] bArr) {
        super(0);
        this.$this_withIndex = bArr;
    }

    @Override // kotlin.jvm.b.a
    public final Iterator<? extends l> invoke() {
        return m.a(this.$this_withIndex);
    }
}
