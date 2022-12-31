package com.camera360.dynamic_feature_splice;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpliceUtils.kt */
@DebugMetadata(c = "com.camera360.dynamic_feature_splice.SpliceUtils", f = "SpliceUtils.kt", i = {0}, l = {255}, m = "cropImage", n = {"savePath"}, s = {"L$0"})
/* loaded from: classes8.dex */
public final class SpliceUtils$cropImage$2 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SpliceUtils this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpliceUtils$cropImage$2(SpliceUtils spliceUtils, Continuation<? super SpliceUtils$cropImage$2> continuation) {
        super(continuation);
        this.this$0 = spliceUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object h2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        h2 = this.this$0.h(null, null, 0.0f, null, this);
        return h2;
    }
}
