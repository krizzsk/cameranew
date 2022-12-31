package us.pinguo.repository2020.database.staticsticker;

import com.tapjoy.TapjoyAuctionFlags;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.staticsticker.StaticStickerManager", f = "StaticStickerManager.kt", i = {0}, l = {627}, m = "needUpdate", n = {TapjoyAuctionFlags.AUCTION_ID}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class StaticStickerManager$needUpdate$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StaticStickerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerManager$needUpdate$1(StaticStickerManager staticStickerManager, Continuation<? super StaticStickerManager$needUpdate$1> continuation) {
        super(continuation);
        this.this$0 = staticStickerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.G(null, this);
    }
}
