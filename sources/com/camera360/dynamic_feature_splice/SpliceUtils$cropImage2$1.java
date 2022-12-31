package com.camera360.dynamic_feature_splice;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpliceUtils.kt */
@DebugMetadata(c = "com.camera360.dynamic_feature_splice.SpliceUtils", f = "SpliceUtils.kt", i = {0, 0, 0, 0, 1}, l = {84, 92}, m = "cropImage2", n = {"this", "tmpFolder", "rectF", PGEditResultActivity2.PATH, "tmpFolder"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
/* loaded from: classes8.dex */
public final class SpliceUtils$cropImage2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SpliceUtils this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpliceUtils$cropImage2$1(SpliceUtils spliceUtils, Continuation<? super SpliceUtils$cropImage2$1> continuation) {
        super(continuation);
        this.this$0 = spliceUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object j2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        j2 = this.this$0.j(null, null, this);
        return j2;
    }
}
