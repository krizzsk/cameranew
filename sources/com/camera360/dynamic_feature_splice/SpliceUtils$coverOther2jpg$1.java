package com.camera360.dynamic_feature_splice;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpliceUtils.kt */
@DebugMetadata(c = "com.camera360.dynamic_feature_splice.SpliceUtils", f = "SpliceUtils.kt", i = {0, 0, 0}, l = {283}, m = "coverOther2jpg", n = {"this", "jpgPath", "maxLen"}, s = {"L$0", "L$1", "I$0"})
/* loaded from: classes8.dex */
public final class SpliceUtils$coverOther2jpg$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SpliceUtils this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpliceUtils$coverOther2jpg$1(SpliceUtils spliceUtils, Continuation<? super SpliceUtils$coverOther2jpg$1> continuation) {
        super(continuation);
        this.this$0 = spliceUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object g2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        g2 = this.this$0.g(null, null, this);
        return g2;
    }
}
