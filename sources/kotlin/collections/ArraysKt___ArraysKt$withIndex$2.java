package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
/* compiled from: _Arrays.kt */
/* loaded from: classes3.dex */
final class ArraysKt___ArraysKt$withIndex$2 extends Lambda implements kotlin.jvm.b.a<Iterator<? extends Byte>> {
    final /* synthetic */ byte[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$2(byte[] bArr) {
        super(0);
        this.$this_withIndex = bArr;
    }

    @Override // kotlin.jvm.b.a
    public final Iterator<? extends Byte> invoke() {
        return kotlin.jvm.internal.i.b(this.$this_withIndex);
    }
}
