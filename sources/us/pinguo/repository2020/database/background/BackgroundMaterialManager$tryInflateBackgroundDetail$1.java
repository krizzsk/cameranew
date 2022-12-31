package us.pinguo.repository2020.database.background;

import com.tapjoy.TapjoyAuctionFlags;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundMaterialManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.background.BackgroundMaterialManager", f = "BackgroundMaterialManager.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6}, l = {97, 99, 110, 114, 116, 119, 123}, m = "tryInflateBackgroundDetail", n = {TapjoyAuctionFlags.AUCTION_ID, "rootDirPath", TapjoyAuctionFlags.AUCTION_ID, "rootDirPath", "normalDetailPath", TapjoyAuctionFlags.AUCTION_ID, "rootDirPath", "normalDetailPath", TapjoyAuctionFlags.AUCTION_ID, "rootDirPath", "normalDetailPath", "f1", TapjoyAuctionFlags.AUCTION_ID, "rootDirPath", "normalDetailPath", "f1", TapjoyAuctionFlags.AUCTION_ID, "rootDirPath", "normalDetailPath", TapjoyAuctionFlags.AUCTION_ID, "normalDetailPath"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$4", "L$0", "L$1", "L$2", "L$4", "L$0", "L$1", "L$2", "L$0", "L$1"})
/* loaded from: classes6.dex */
public final class BackgroundMaterialManager$tryInflateBackgroundDetail$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BackgroundMaterialManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundMaterialManager$tryInflateBackgroundDetail$1(BackgroundMaterialManager backgroundMaterialManager, Continuation<? super BackgroundMaterialManager$tryInflateBackgroundDetail$1> continuation) {
        super(continuation);
        this.this$0 = backgroundMaterialManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object n;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        n = this.this$0.n(null, this);
        return n;
    }
}
