package com.camera360.dynamic_feature_splice;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpliceUtils.kt */
@DebugMetadata(c = "com.camera360.dynamic_feature_splice.SpliceUtils", f = "SpliceUtils.kt", i = {0, 0, 0}, l = {340}, m = "splitBigImage", n = {"srcWidth", "srcHeight", "spliceCount"}, s = {"I$0", "I$1", "I$2"})
/* loaded from: classes8.dex */
public final class SpliceUtils$splitBigImage$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SpliceUtils this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpliceUtils$splitBigImage$1(SpliceUtils spliceUtils, Continuation<? super SpliceUtils$splitBigImage$1> continuation) {
        super(continuation);
        this.this$0 = spliceUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.p(null, 0, 0, 0, this);
    }
}
