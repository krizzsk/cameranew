package us.pinguo.repository2020.database.sticker;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager", f = "StickerManager.kt", i = {0}, l = {232}, m = "inflateRecentStickers", n = {"this"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class StickerManager$inflateRecentStickers$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StickerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManager$inflateRecentStickers$1(StickerManager stickerManager, Continuation<? super StickerManager$inflateRecentStickers$1> continuation) {
        super(continuation);
        this.this$0 = stickerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object Q;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Q = this.this$0.Q(this);
        return Q;
    }
}
