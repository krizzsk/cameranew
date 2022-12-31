package us.pinguo.common.filter;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraFilterModule.kt */
@DebugMetadata(c = "us.pinguo.common.filter.CameraFilterModule", f = "CameraFilterModule.kt", i = {0, 0, 1, 1, 1}, l = {90, 94}, m = "makeSkyFilterParamsRecord", n = {"this", "filterId", "defaultTransparent", "defaultMix", "defaultTemperature"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2"})
/* loaded from: classes4.dex */
public final class CameraFilterModule$makeSkyFilterParamsRecord$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraFilterModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraFilterModule$makeSkyFilterParamsRecord$1(CameraFilterModule cameraFilterModule, Continuation<? super CameraFilterModule$makeSkyFilterParamsRecord$1> continuation) {
        super(continuation);
        this.this$0 = cameraFilterModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b0(null, null, this);
    }
}
