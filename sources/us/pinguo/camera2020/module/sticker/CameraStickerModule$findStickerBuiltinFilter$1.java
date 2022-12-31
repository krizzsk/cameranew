package us.pinguo.camera2020.module.sticker;

import androidx.recyclerview.widget.ItemTouchHelper;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraStickerModule.kt */
@DebugMetadata(c = "us.pinguo.camera2020.module.sticker.CameraStickerModule", f = "CameraStickerModule.kt", i = {0, 0, 1, 1}, l = {ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 255}, m = "findStickerBuiltinFilter", n = {"this", "relativePath", "this", PGEditResultActivity2.PATH}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes3.dex */
public final class CameraStickerModule$findStickerBuiltinFilter$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraStickerModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraStickerModule$findStickerBuiltinFilter$1(CameraStickerModule cameraStickerModule, Continuation<? super CameraStickerModule$findStickerBuiltinFilter$1> continuation) {
        super(continuation);
        this.this$0 = cameraStickerModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n(null, null, this);
    }
}
