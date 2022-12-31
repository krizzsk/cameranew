package com.camera360.dynamic_feature_splice;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpliceUtils.kt */
@DebugMetadata(c = "com.camera360.dynamic_feature_splice.SpliceUtils", f = "SpliceUtils.kt", i = {0, 0, 0, 0, 0}, l = {99}, m = "scalePicture", n = {"this", BigAlbumStore.PhotoColumns.SIZE, "rectF", "width", "angle"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"})
/* loaded from: classes8.dex */
public final class SpliceUtils$scalePicture$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SpliceUtils this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpliceUtils$scalePicture$1(SpliceUtils spliceUtils, Continuation<? super SpliceUtils$scalePicture$1> continuation) {
        super(continuation);
        this.this$0 = spliceUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object n;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        n = this.this$0.n(null, null, 0, 0, null, this);
        return n;
    }
}
