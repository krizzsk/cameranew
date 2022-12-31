package us.pinguo.repository2020.utils;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BeautyDataUtils.kt */
@DebugMetadata(c = "us.pinguo.repository2020.utils.BeautyDataUtils", f = "BeautyDataUtils.kt", i = {0}, l = {18}, m = "getFilterMakeInfo", n = {"filterIndexPath"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class BeautyDataUtils$getFilterMakeInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BeautyDataUtils this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyDataUtils$getFilterMakeInfo$1(BeautyDataUtils beautyDataUtils, Continuation<? super BeautyDataUtils$getFilterMakeInfo$1> continuation) {
        super(continuation);
        this.this$0 = beautyDataUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
