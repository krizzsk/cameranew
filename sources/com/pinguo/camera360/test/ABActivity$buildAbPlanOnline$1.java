package com.pinguo.camera360.test;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ABActivity.kt */
@DebugMetadata(c = "com.pinguo.camera360.test.ABActivity", f = "ABActivity.kt", i = {}, l = {120}, m = "buildAbPlanOnline", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ABActivity$buildAbPlanOnline$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ABActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ABActivity$buildAbPlanOnline$1(ABActivity aBActivity, Continuation<? super ABActivity$buildAbPlanOnline$1> continuation) {
        super(continuation);
        this.this$0 = aBActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object v0;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        v0 = this.this$0.v0(this);
        return v0;
    }
}
