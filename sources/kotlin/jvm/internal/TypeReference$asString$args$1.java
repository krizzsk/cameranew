package kotlin.jvm.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeReference.kt */
/* loaded from: classes3.dex */
public final class TypeReference$asString$args$1 extends Lambda implements kotlin.jvm.b.l<kotlin.reflect.p, CharSequence> {
    final /* synthetic */ TypeReference this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeReference$asString$args$1(TypeReference typeReference) {
        super(1);
        this.this$0 = typeReference;
    }

    @Override // kotlin.jvm.b.l
    public final CharSequence invoke(kotlin.reflect.p it) {
        String b;
        s.h(it, "it");
        b = this.this$0.b(it);
        return b;
    }
}
