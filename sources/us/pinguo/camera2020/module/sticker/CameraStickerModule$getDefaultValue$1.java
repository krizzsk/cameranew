package us.pinguo.camera2020.module.sticker;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraStickerModule.kt */
@DebugMetadata(c = "us.pinguo.camera2020.module.sticker.CameraStickerModule", f = "CameraStickerModule.kt", i = {0, 0}, l = {115}, m = "getDefaultValue", n = {"type", "filterDefValue"}, s = {"L$0", "I$0"})
/* loaded from: classes3.dex */
public final class CameraStickerModule$getDefaultValue$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraStickerModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraStickerModule$getDefaultValue$1(CameraStickerModule cameraStickerModule, Continuation<? super CameraStickerModule$getDefaultValue$1> continuation) {
        super(continuation);
        this.this$0 = cameraStickerModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.v(null, null, this);
    }
}
