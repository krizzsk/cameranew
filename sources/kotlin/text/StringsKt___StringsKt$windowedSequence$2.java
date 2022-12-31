package kotlin.text;

import kotlin.jvm.internal.Lambda;
/* compiled from: _Strings.kt */
/* loaded from: classes3.dex */
final class StringsKt___StringsKt$windowedSequence$2 extends Lambda implements kotlin.jvm.b.l<Integer, R> {
    final /* synthetic */ int $size;
    final /* synthetic */ CharSequence $this_windowedSequence;
    final /* synthetic */ kotlin.jvm.b.l<CharSequence, R> $transform;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    StringsKt___StringsKt$windowedSequence$2(int i2, CharSequence charSequence, kotlin.jvm.b.l<? super CharSequence, ? extends R> lVar) {
        super(1);
        this.$size = i2;
        this.$this_windowedSequence = charSequence;
        this.$transform = lVar;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [R, java.lang.Object] */
    public final R invoke(int i2) {
        int i3 = this.$size + i2;
        if (i3 < 0 || i3 > this.$this_windowedSequence.length()) {
            i3 = this.$this_windowedSequence.length();
        }
        return this.$transform.invoke(this.$this_windowedSequence.subSequence(i2, i3));
    }
}
