package us.pinguo.repository2020.database.sticker;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager", f = "StickerManager.kt", i = {0, 1}, l = {526, 527}, m = "generateStickerMap", n = {"map", "map"}, s = {"L$0", "L$0"})
/* loaded from: classes6.dex */
public final class StickerManager$generateStickerMap$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StickerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManager$generateStickerMap$1(StickerManager stickerManager, Continuation<? super StickerManager$generateStickerMap$1> continuation) {
        super(continuation);
        this.this$0 = stickerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object J;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        J = this.this$0.J(null, this);
        return J;
    }
}
