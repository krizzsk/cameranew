package us.pinguo.edit2020.viewmodel.module;

import com.tencent.matrix.trace.config.SharePluginInfo;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerModule.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.StaticStickerModule", f = "StaticStickerModule.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {258, 450}, m = "doApplySticker", n = {"this", SharePluginInfo.ISSUE_STACK_TYPE, "frameSize", "frameActualSize", "sid", "sticker", "vip", "history", "frameChild", "fromTemplate", "this", "function", "$this$forEach$iv", "vip", "fromTemplate", "stickerWidth", "stickerHeight", "frameWidth", "frameHeight"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "Z$1", "Z$2", "Z$3", "L$0", "L$1", "L$2", "Z$0", "Z$1", "F$0", "F$1", "F$2", "F$3"})
/* loaded from: classes4.dex */
public final class StaticStickerModule$doApplySticker$1 extends ContinuationImpl {
    float F$0;
    float F$1;
    float F$2;
    float F$3;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    boolean Z$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StaticStickerModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerModule$doApplySticker$1(StaticStickerModule staticStickerModule, Continuation<? super StaticStickerModule$doApplySticker$1> continuation) {
        super(continuation);
        this.this$0 = staticStickerModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m = this.this$0.m(null, false, false, false, null, null, false, this);
        return m;
    }
}
