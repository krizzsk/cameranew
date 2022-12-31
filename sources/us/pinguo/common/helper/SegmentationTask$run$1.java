package us.pinguo.common.helper;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SegmentationHelper.kt */
@DebugMetadata(c = "us.pinguo.common.helper.SegmentationTask", f = "SegmentationHelper.kt", i = {0, 0, 0, 0}, l = {142}, m = "run", n = {"this", "resultPath", "resultBitmap", "orientation"}, s = {"L$0", "L$1", "L$2", "I$0"})
/* loaded from: classes4.dex */
public final class SegmentationTask$run$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SegmentationTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentationTask$run$1(SegmentationTask segmentationTask, Continuation<? super SegmentationTask$run$1> continuation) {
        super(continuation);
        this.this$0 = segmentationTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(this);
    }
}
