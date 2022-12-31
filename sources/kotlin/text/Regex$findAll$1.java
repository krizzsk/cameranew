package kotlin.text;

import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class Regex$findAll$1 extends Lambda implements kotlin.jvm.b.a<h> {
    final /* synthetic */ CharSequence $input;
    final /* synthetic */ int $startIndex;
    final /* synthetic */ Regex this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Regex$findAll$1(Regex regex, CharSequence charSequence, int i2) {
        super(0);
        this.this$0 = regex;
        this.$input = charSequence;
        this.$startIndex = i2;
    }

    @Override // kotlin.jvm.b.a
    public final h invoke() {
        return this.this$0.find(this.$input, this.$startIndex);
    }
}
