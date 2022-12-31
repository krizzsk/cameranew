package us.pinguo.common.widget.banner2;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
/* compiled from: BaseBannerAdapter.kt */
/* loaded from: classes4.dex */
public final class BaseBannerAdapter$remove$2$1 extends Lambda implements l<T, Boolean> {
    final /* synthetic */ l<T, Boolean> $predicate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseBannerAdapter$remove$2$1(l<? super T, Boolean> lVar) {
        super(1);
        this.$predicate = lVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.l
    public final Boolean invoke(T it) {
        s.h(it, "it");
        return this.$predicate.invoke(it);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return invoke((BaseBannerAdapter$remove$2$1) obj);
    }
}
