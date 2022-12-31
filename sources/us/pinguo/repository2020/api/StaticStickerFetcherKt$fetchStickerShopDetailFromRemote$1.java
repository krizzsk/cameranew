package us.pinguo.repository2020.api;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.repository2020.database.staticsticker.ShopDetail;
import us.pinguo.repository2020.database.staticsticker.ShopDetailResponse;
/* compiled from: StaticStickerFetcher.kt */
/* loaded from: classes6.dex */
final class StaticStickerFetcherKt$fetchStickerShopDetailFromRemote$1 extends Lambda implements p<ShopDetailResponse, Throwable, u> {
    final /* synthetic */ p<ShopDetail, Throwable, u> $callback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StaticStickerFetcherKt$fetchStickerShopDetailFromRemote$1(p<? super ShopDetail, ? super Throwable, u> pVar) {
        super(2);
        this.$callback = pVar;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(ShopDetailResponse shopDetailResponse, Throwable th) {
        invoke2(shopDetailResponse, th);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ShopDetailResponse shopDetailResponse, Throwable th) {
        if (shopDetailResponse == null) {
            p<ShopDetail, Throwable, u> pVar = this.$callback;
            if (pVar == null) {
                return;
            }
            pVar.invoke(null, th);
            return;
        }
        Integer status = shopDetailResponse.getStatus();
        if (status == null || status.intValue() != 200) {
            p<ShopDetail, Throwable, u> pVar2 = this.$callback;
            if (pVar2 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("status:");
            Integer status2 = shopDetailResponse.getStatus();
            if (status2 == null) {
                status2 = "null";
            }
            sb.append(status2);
            sb.append(",message:");
            String message = shopDetailResponse.getMessage();
            sb.append(message != null ? message : "null");
            pVar2.invoke(null, new Throwable(sb.toString()));
            return;
        }
        p<ShopDetail, Throwable, u> pVar3 = this.$callback;
        if (pVar3 == null) {
            return;
        }
        pVar3.invoke(shopDetailResponse.getData(), null);
    }
}
