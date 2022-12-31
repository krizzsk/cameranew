package us.pinguo.camera2020.module.sticker;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraStickerModule.kt */
@DebugMetadata(c = "us.pinguo.camera2020.module.sticker.CameraStickerModule", f = "CameraStickerModule.kt", i = {}, l = {74}, m = "getStickerTouchMode", n = {}, s = {})
/* loaded from: classes3.dex */
public final class CameraStickerModule$getStickerTouchMode$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraStickerModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraStickerModule$getStickerTouchMode$1(CameraStickerModule cameraStickerModule, Continuation<? super CameraStickerModule$getStickerTouchMode$1> continuation) {
        super(continuation);
        this.this$0 = cameraStickerModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.x(null, this);
    }
}
