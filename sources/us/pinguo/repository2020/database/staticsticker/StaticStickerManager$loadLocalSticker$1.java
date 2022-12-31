package us.pinguo.repository2020.database.staticsticker;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.staticsticker.StaticStickerManager", f = "StaticStickerManager.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {656, 181}, m = "loadLocalSticker", n = {"$this$withLock_u24default$iv", "fromBuiltin", "$this$withLock_u24default$iv", "context", "stickerJson", "stickerCategories", "categoryTable", "cid", "sids", "stickerEntry", "fromBuiltin", "now"}, s = {"L$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$9", "Z$0", "J$0"})
/* loaded from: classes6.dex */
public final class StaticStickerManager$loadLocalSticker$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StaticStickerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerManager$loadLocalSticker$1(StaticStickerManager staticStickerManager, Continuation<? super StaticStickerManager$loadLocalSticker$1> continuation) {
        super(continuation);
        this.this$0 = staticStickerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object E;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        E = this.this$0.E(false, this);
        return E;
    }
}
