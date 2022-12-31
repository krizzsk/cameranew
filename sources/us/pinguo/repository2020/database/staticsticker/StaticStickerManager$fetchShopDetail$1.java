package us.pinguo.repository2020.database.staticsticker;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
/* compiled from: StaticStickerManager.kt */
/* loaded from: classes6.dex */
final class StaticStickerManager$fetchShopDetail$1 extends Lambda implements p<ShopDetail, Throwable, u> {
    final /* synthetic */ kotlin.jvm.b.l<ShopDetail, u> $callback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StaticStickerManager$fetchShopDetail$1(kotlin.jvm.b.l<? super ShopDetail, u> lVar) {
        super(2);
        this.$callback = lVar;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(ShopDetail shopDetail, Throwable th) {
        invoke2(shopDetail, th);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ShopDetail shopDetail, Throwable th) {
        if (shopDetail != null && th == null) {
            kotlin.jvm.b.l<ShopDetail, u> lVar = this.$callback;
            if (lVar == null) {
                return;
            }
            lVar.invoke(shopDetail);
            return;
        }
        kotlin.jvm.b.l<ShopDetail, u> lVar2 = this.$callback;
        if (lVar2 == null) {
            return;
        }
        lVar2.invoke(null);
    }
}
