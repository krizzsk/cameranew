package kotlin.collections;

import kotlin.jvm.internal.Lambda;
/* compiled from: AbstractCollection.kt */
/* loaded from: classes3.dex */
final class AbstractCollection$toString$1 extends Lambda implements kotlin.jvm.b.l<E, CharSequence> {
    final /* synthetic */ AbstractCollection<E> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AbstractCollection$toString$1(AbstractCollection<? extends E> abstractCollection) {
        super(1);
        this.this$0 = abstractCollection;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ CharSequence invoke(Object obj) {
        return invoke((AbstractCollection$toString$1) obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.l
    public final CharSequence invoke(E e2) {
        return e2 == this.this$0 ? "(this Collection)" : String.valueOf(e2);
    }
}
