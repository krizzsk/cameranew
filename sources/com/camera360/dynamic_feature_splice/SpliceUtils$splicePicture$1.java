package com.camera360.dynamic_feature_splice;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpliceUtils.kt */
@DebugMetadata(c = "com.camera360.dynamic_feature_splice.SpliceUtils", f = "SpliceUtils.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 5, 5, 6}, l = {42, 46, 48, 51, 59, 64, 70}, m = "splicePicture", n = {"spliceInfos", "outputPath", "tmpFolder", "outputPath", "tmpFolder", "nativeInfos", "it", "outputPath", "tmpFolder", "nativeInfos", "outputPath", "tmpFolder", "outputPath"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$4", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
/* loaded from: classes8.dex */
public final class SpliceUtils$splicePicture$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpliceUtils$splicePicture$1(Continuation<? super SpliceUtils$splicePicture$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SpliceUtils.o(null, null, this);
    }
}
