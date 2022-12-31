package com.camera360.dynamic_feature_splice;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LongImageView.kt */
@DebugMetadata(c = "com.camera360.dynamic_feature_splice.LongImageView", f = "LongImageView.kt", i = {0}, l = {214}, m = "splitBigImage", n = {"this"}, s = {"L$0"})
/* loaded from: classes8.dex */
public final class LongImageView$splitBigImage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LongImageView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongImageView$splitBigImage$1(LongImageView longImageView, Continuation<? super LongImageView$splitBigImage$1> continuation) {
        super(continuation);
        this.this$0 = longImageView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object p;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        p = this.this$0.p(null, this);
        return p;
    }
}
