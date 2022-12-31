package us.pinguo.common.filter;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraFilterModule.kt */
@DebugMetadata(c = "us.pinguo.common.filter.CameraFilterModule", f = "CameraFilterModule.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {263, 265, 268}, m = "getCurrentFilterDefaultOpacity", n = {"filterId", "packageId", "filterOpacity", "filterId", "packageId", "filterOpacity", "it", "filterId", "packageId", "filterOpacity"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$4", "L$0", "L$1", "L$2"})
/* loaded from: classes4.dex */
public final class CameraFilterModule$getCurrentFilterDefaultOpacity$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraFilterModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraFilterModule$getCurrentFilterDefaultOpacity$1(CameraFilterModule cameraFilterModule, Continuation<? super CameraFilterModule$getCurrentFilterDefaultOpacity$1> continuation) {
        super(continuation);
        this.this$0 = cameraFilterModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.q(null, this);
    }
}
