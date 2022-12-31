package us.pinguo.common.filter;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraFilterModule.kt */
@DebugMetadata(c = "us.pinguo.common.filter.CameraFilterModule", f = "CameraFilterModule.kt", i = {0}, l = {218}, m = "getCurrentFilterOpacity$suspendImpl", n = {"baseFilter"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class CameraFilterModule$getCurrentFilterOpacity$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraFilterModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraFilterModule$getCurrentFilterOpacity$1(CameraFilterModule cameraFilterModule, Continuation<? super CameraFilterModule$getCurrentFilterOpacity$1> continuation) {
        super(continuation);
        this.this$0 = cameraFilterModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return CameraFilterModule.t(this.this$0, this);
    }
}
