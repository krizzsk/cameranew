package us.pinguo.repository2020.database.staticsticker;

import com.tapjoy.TapjoyAuctionFlags;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.staticsticker.StaticStickerManager", f = "StaticStickerManager.kt", i = {0, 0, 1, 1}, l = {636, 638}, m = "findStaticStickerDetail", n = {TapjoyAuctionFlags.AUCTION_ID, "stickerPath", TapjoyAuctionFlags.AUCTION_ID, "detailJsonPath"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes6.dex */
public final class StaticStickerManager$findStaticStickerDetail$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StaticStickerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerManager$findStaticStickerDetail$1(StaticStickerManager staticStickerManager, Continuation<? super StaticStickerManager$findStaticStickerDetail$1> continuation) {
        super(continuation);
        this.this$0 = staticStickerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.p(null, this);
    }
}
