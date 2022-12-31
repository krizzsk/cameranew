package com.camera360.dynamic_feature_splice;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Splices.kt */
@DebugMetadata(c = "com.camera360.dynamic_feature_splice.Splices", f = "Splices.kt", i = {0, 0}, l = {28}, m = "loadSpliceItems", n = {"spliceLists", "retList"}, s = {"L$0", "L$1"})
/* loaded from: classes8.dex */
public final class Splices$loadSpliceItems$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Splices this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Splices$loadSpliceItems$1(Splices splices, Continuation<? super Splices$loadSpliceItems$1> continuation) {
        super(continuation);
        this.this$0 = splices;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, this);
    }
}
