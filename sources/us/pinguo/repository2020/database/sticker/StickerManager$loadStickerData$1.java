package us.pinguo.repository2020.database.sticker;

import com.growingio.android.sdk.deeplink.DeeplinkCallback;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager", f = "StickerManager.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5, 6}, l = {1248, 385, 386, 389, DeeplinkCallback.ERROR_APP_NOT_ACCEPT, 410, 411}, m = "loadStickerData", n = {"this", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "context", "stickerResponseJson", "fromAsset", "this", "$this$withLock_u24default$iv", "context", "stickerResponseJson", "fromAsset", "this", "$this$withLock_u24default$iv", "context", "this", "$this$withLock_u24default$iv", "this", "this"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$0"})
/* loaded from: classes6.dex */
public final class StickerManager$loadStickerData$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StickerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManager$loadStickerData$1(StickerManager stickerManager, Continuation<? super StickerManager$loadStickerData$1> continuation) {
        super(continuation);
        this.this$0 = stickerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.W(this);
    }
}
