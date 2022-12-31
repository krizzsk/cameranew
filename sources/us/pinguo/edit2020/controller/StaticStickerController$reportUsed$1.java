package us.pinguo.edit2020.controller;

import com.tencent.tauth.AuthActivity;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.StaticStickerController", f = "StaticStickerController.kt", i = {0, 0}, l = {739}, m = "reportUsed", n = {"this", AuthActivity.ACTION_KEY}, s = {"L$0", "L$1"})
/* loaded from: classes4.dex */
public final class StaticStickerController$reportUsed$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StaticStickerController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerController$reportUsed$1(StaticStickerController staticStickerController, Continuation<? super StaticStickerController$reportUsed$1> continuation) {
        super(continuation);
        this.this$0 = staticStickerController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object v0;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        v0 = this.this$0.v0(null, this);
        return v0;
    }
}
