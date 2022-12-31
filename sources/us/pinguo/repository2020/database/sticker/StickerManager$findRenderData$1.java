package us.pinguo.repository2020.database.sticker;

import com.tapjoy.TapjoyAuctionFlags;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager", f = "StickerManager.kt", i = {0, 0, 1}, l = {307, 308}, m = "findRenderData", n = {TapjoyAuctionFlags.AUCTION_ID, "file", TapjoyAuctionFlags.AUCTION_ID}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes6.dex */
public final class StickerManager$findRenderData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StickerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManager$findRenderData$1(StickerManager stickerManager, Continuation<? super StickerManager$findRenderData$1> continuation) {
        super(continuation);
        this.this$0 = stickerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.F(null, this);
    }
}
