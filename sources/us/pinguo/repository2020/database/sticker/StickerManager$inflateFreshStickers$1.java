package us.pinguo.repository2020.database.sticker;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager", f = "StickerManager.kt", i = {0, 0}, l = {158}, m = "inflateFreshStickers", n = {"list", PGEditResultActivity2.PATH}, s = {"L$0", "L$1"})
/* loaded from: classes6.dex */
public final class StickerManager$inflateFreshStickers$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StickerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManager$inflateFreshStickers$1(StickerManager stickerManager, Continuation<? super StickerManager$inflateFreshStickers$1> continuation) {
        super(continuation);
        this.this$0 = stickerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object P;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        P = this.this$0.P(this);
        return P;
    }
}
