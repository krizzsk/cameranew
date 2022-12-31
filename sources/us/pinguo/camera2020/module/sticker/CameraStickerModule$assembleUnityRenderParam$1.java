package us.pinguo.camera2020.module.sticker;

import com.tapjoy.TapjoyAuctionFlags;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraStickerModule.kt */
@DebugMetadata(c = "us.pinguo.camera2020.module.sticker.CameraStickerModule", f = "CameraStickerModule.kt", i = {0, 1}, l = {215, 216}, m = "assembleUnityRenderParam", n = {TapjoyAuctionFlags.AUCTION_ID, "renderData"}, s = {"L$0", "L$0"})
/* loaded from: classes3.dex */
public final class CameraStickerModule$assembleUnityRenderParam$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraStickerModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraStickerModule$assembleUnityRenderParam$1(CameraStickerModule cameraStickerModule, Continuation<? super CameraStickerModule$assembleUnityRenderParam$1> continuation) {
        super(continuation);
        this.this$0 = cameraStickerModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object g2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        g2 = this.this$0.g(null, this);
        return g2;
    }
}
