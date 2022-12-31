package kotlin.collections;

import kotlin.jvm.internal.Lambda;
/* JADX WARN: Incorrect field signature: TK; */
/* compiled from: Collections.kt */
/* loaded from: classes3.dex */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1 extends Lambda implements kotlin.jvm.b.l<T, Integer> {
    final /* synthetic */ Comparable $key;
    final /* synthetic */ kotlin.jvm.b.l<T, K> $selector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/b/l<-TT;+TK;>;TK;)V */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(kotlin.jvm.b.l lVar, Comparable comparable) {
        super(1);
        this.$selector = lVar;
        this.$key = comparable;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.l
    public final Integer invoke(T t) {
        int a;
        a = kotlin.w.b.a((Comparable) this.$selector.invoke(t), this.$key);
        return Integer.valueOf(a);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
        return invoke((CollectionsKt__CollectionsKt$binarySearchBy$1) obj);
    }
}
